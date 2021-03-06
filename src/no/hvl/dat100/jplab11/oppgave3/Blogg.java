package no.hvl.dat100.jplab11.oppgave3;

import java.util.ArrayList;

import no.hvl.dat100.jplab11.oppgave1.*;

public class Blogg {

	private int antall;
	private Innlegg[] samling;
	
	public Blogg() {
		this(20); // Setter 20 som standard lengde om annet ikke er spesifisert i konstruktøren.
	}

	public Blogg(int lengde) {
		this.samling = new Innlegg[lengde];
		this.antall = 0;
		
	}

	public int getAntall() {
		return this.antall;
	}
	
	public Innlegg[] getSamling() {
		return this.samling;
	}
	
	public int finnInnlegg(Innlegg innlegg) {
		for(int i = 0; i < antall; i++) {
			if (samling[i].erLik(innlegg)) {
				return i;
			}
		}
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		for(int i = 0; i < antall; i++) {
			if (samling[i].erLik(innlegg)) {
				return true;
			}
		}
		return false;
	}

	public boolean ledigPlass() {
		return antall < samling.length;

	}
	
	public boolean leggTil(Innlegg innlegg) {

		if(!finnes(innlegg) && ledigPlass()) {
			samling[antall] = innlegg;
			antall++;
			return true;
		}
		return false;
	}
	
	public String toString() {
		String retur = String.valueOf(antall) + "\n";
		for(int i = 0; i < antall; i++) {
			retur += samling[i].toString();
		}
		return retur;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		Innlegg[] nySamling = new Innlegg[samling.length * 2]; // velger å doble størrelsen, helt vilkårlig.
		System.arraycopy(samling, 0, nySamling, 0, samling.length);
		this.samling = nySamling;
	}

	public boolean leggTilUtvid(Innlegg innlegg) {

		if(!leggTil(innlegg)) {
			utvid();
			return leggTil(innlegg);
		}
		return false;
	}
	
	public boolean slett(Innlegg innlegg) {
		for(int i = 0; i < samling.length; i++) {
			if(samling[i].equals(innlegg)) {
				samling[i] = samling[antall- 1];
				samling[antall - 1] = null;
				this.antall--;
				return true;
			}
		}
		return false;
	}
	
	public int[] search(String keyword) {
		ArrayList<Integer> resultatListe = new ArrayList<Integer>();
		
		for (Innlegg innlegg: samling) {
			if (innlegg.toString().contains(keyword)) {
				resultatListe.add(innlegg.getId());
			}
		}
		
		int[] resultat = new int[resultatListe.size()];
		for (int i = 0; i < resultatListe.size(); i++) {
			resultat[i] = resultatListe.get(i);
		}
		
		return resultat;

	}
}