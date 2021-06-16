package jsoup;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.jsoup.Jsoup;

import extrator.Armazenador;

public class Main {

	public static void main(String[] args) {

		ArrayList<String> lista = new ArrayList<String>();
	
		Armazenador arm = new Armazenador();
		
		
		try {

			arm.setLinksNoticias(".hl-title.hl-title-2 > a");
			arm.setAutor(".author-name");
			arm.setConteudo(".col-md-9");
			arm.setData(".entry-date.published");
			arm.setSubtitulo(".article-lead");
			arm.setTitulo(".page-title-1");
			arm.setUrlPrincipal("https://www.infomoney.com.br/mercados/");
			// acessa a url principal
			arm.setDoc(Jsoup.connect(arm.getUrlPrincipal()).get());
			// seleciona os links da pagina principal
			arm.setSalvaClasse(arm.getDoc().select(arm.getLinksNoticias())); 
			
			for (int i = 0; i < arm.getSalvaClasse().size(); i++) {
				try {
					// extrai o link da noticia correspondente ao index atual e adiciona a lista

					lista.add(arm.getSalvaClasse().get(i).attr("href"));

					System.out.println(i + 1 + "" + "\n Link : " + lista.get(i));
					System.out.println();
					// acessa o link correspondente ao index da lista
					arm.setDoc(Jsoup.connect(lista.get(i)).get());
					// extrai o titulo
					arm.setSalvaClasse(arm.getDoc().select(arm.getTitulo())); 
					System.out.println(i + 1 + "" + "\n Titulo : " + arm.getSalvaClasse().text());
					System.out.println();
					// extrai o subtitulo
					arm.setSalvaClasse(arm.getDoc().select(arm.getSubtitulo()));
					System.out.println(i + 1 + "" + "\n Subtitulo : " + arm.getSalvaClasse().text());
					System.out.println();
					// extrai o autor
					arm.setSalvaClasse(arm.getDoc().select(arm.getAutor()));
					arm.setConverteAutor(arm.getSalvaClasse().text());
					arm.setConverteAutor(arm.getConverteAutor().substring(4, arm.getConverteAutor().length()));
					System.out.println(i + 1 + "" + "\n Autor : " + arm.getConverteAutor());
					System.out.println();
					// extrai a data
					arm.setSalvaClasse(arm.getDoc().select(arm.getData()));
					arm.setConverteData(arm.getSalvaClasse().attr("datetime"));
					DateTimeFormatter originalFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
					DateTimeFormatter targetFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

					LocalDateTime dateTime = LocalDateTime.parse(arm.getConverteData(), originalFormat);

					arm.setConverteData(dateTime.format(targetFormat));

					System.out.println(i + 1 + "" + "\n Data : " + arm.getConverteData());
					System.out.println();
					// extrai o conteúdo
					arm.setSalvaClasse(arm.getDoc().select(arm.getConteudo()));
					System.out.println(i + 1 + "" + "\n Conteudo : " + arm.getSalvaClasse().text());
					System.out.println();
					// retorna a página inicial para extrair os proximos links
					arm.setDoc(Jsoup.connect(arm.getUrlPrincipal()).get());
					// seleciona a clase da proxima notícia
					arm.setSalvaClasse(arm.getDoc().select(arm.getLinksNoticias()));
					System.out.println();
					System.out.println();
					System.out.println("_______________________________________");
					System.out.println();
					System.out.println();

				} catch (Exception e1) {
					System.out.println("Nao existem mais elementos a serem explorados");
					e1.printStackTrace();
				}
			}
		}

		catch (IOException e) {
			System.out.println("Site inacessivel");

			e.printStackTrace();
		}
		System.out.println("Fim do programa");

	}
}
