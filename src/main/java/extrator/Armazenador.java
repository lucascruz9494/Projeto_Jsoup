package extrator;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Armazenador {
	private String converteAutor;
	private String converteData;
	private Document doc;
	private Elements salvaClasse;

	private String urlPrincipal ;
	private String titulo ;
	private String subtitulo;
	private String autor ;
	private String data;
	private String conteudo ;
	private String linksNoticias;




	public String getConverteAutor() {
		return converteAutor;
	}




	public void setConverteAutor(String converteAutor) {
		this.converteAutor = converteAutor;
	}




	public String getConverteData() {
		return converteData;
	}




	public void setConverteData(String converteData) {
		this.converteData = converteData;
	}




	public Document getDoc() {
		return doc;
	}




	public void setDoc(Document doc) {
		this.doc = doc;
	}




	public Elements getSalvaClasse() {
		return salvaClasse;
	}




	public void setSalvaClasse(Elements salvaClasse) {
		this.salvaClasse = salvaClasse;
	}




	public String getUrlPrincipal() {
		return urlPrincipal;
	}




	public void setUrlPrincipal(String urlPrincipal) {
		this.urlPrincipal = urlPrincipal;
	}




	public String getTitulo() {
		return titulo;
	}




	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}




	public String getSubtitulo() {
		return subtitulo;
	}




	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}




	public String getAutor() {
		return autor;
	}




	public void setAutor(String autor) {
		this.autor = autor;
	}




	public String getData() {
		return data;
	}




	public void setData(String data) {
		this.data = data;
	}




	public String getConteudo() {
		return conteudo;
	}




	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}




	public String getLinksNoticias() {
		return linksNoticias;
	}




	public void setLinksNoticias(String linksNoticias) {
		this.linksNoticias = linksNoticias;
	}




	public Armazenador() {
		// TODO Auto-generated constructor stub
	}

	

}
	