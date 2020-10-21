package no.hvl.dat100.jplab11.oppgave1;

import no.hvl.dat100.jplab11.common.TODO;

public abstract class Innlegg {
		
	int id;
	String bruker;
	String dato;
	int likes;
	
	public Innlegg() {
		//this(0,"","", 0);
	}
	
	public Innlegg(int id, String bruker, String dato) {

		this(id, bruker, dato, 0);
	}

	public Innlegg(int id, String bruker, String dato, int likes) {

		this.id = id;
		this.bruker	= bruker;
		this.dato = dato;
		this.likes = likes;
			
	}
	
	public String getBruker() {
		
		return this.bruker;
	}

	public void setBruker(String bruker) {
		this.bruker = bruker;
	}

	public String getDato() {
		return this.dato;
		
	}

	public void setDato(String dato) {
		this.dato = dato;
	}

	public int getId() {
		return this.id;

	}

	public int getLikes() {
		return this.likes;

	}
	
	public void doLike () {
		this.likes += 1;
	}
	
	public boolean erLik(Innlegg innlegg) {
		// Sammenligner verdiene og ikke pointers.
		return Integer.compare(this.id, innlegg.id) == 0 ? true : false;

	}
	
	@Override
	public String toString() {
		
		return String.format("%d\n%s\n%s\n%d\n", this.id, this.bruker, this.dato, this.likes);
				
	}
	
	// Metoden nedenfor er kun for valgfri oppgave 6
	public String toHTML() {
		
		throw new UnsupportedOperationException(TODO.method());
				
	}
}
