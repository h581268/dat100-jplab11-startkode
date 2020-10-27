package no.hvl.dat100.jplab11.oppgave2;

import no.hvl.dat100.jplab11.common.TODO;

public class Bilde extends Tekst {

	private String url;
	
	public Bilde(int id, String bruker, String dato, String tekst, String url) {
		this(id, bruker, dato, 0, tekst, url);
	}

	public Bilde(int id, String bruker, String dato, int likes, String tekst, String url) {
		super(id, bruker, dato, likes, tekst);
		this.url = url;
	}
	
	public String getUrl() {
		return this.url;

	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return String.format("BILDE\n%d\n%s\n%s\n%d\n%s\n%s\n", super.getId(), super.getBruker(), super.getDato(), super.getLikes(), super.getTekst(), this.url);

	}

	// Metoden nedenfor er kun for valgfri oppgave 6
	public String toHTML() {
		
		return super.toHTML().replace("<hr>", String.format("<iframe src=\"%s\" height=600 width=800></iframe>\n\t\t<hr>\n", this.url));
				
	}
}
