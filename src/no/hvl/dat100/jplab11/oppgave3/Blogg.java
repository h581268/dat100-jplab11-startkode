package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;

public class Blogg {

	int antall;
	Innlegg[] samling;
	
	public Blogg() {
		this(20);
	}

	public Blogg(int lengde) {
		this.samling = new Innlegg[lengde];
		this.antall = 0;
		
	}

	public int getAntall() {
		int antall = 0;
		for(int i = 0; i < samling.length; i++) {
			if(samling[i] == null) {
				return antall;
			}
			antall ++;
		}
		return antall;
	}
	
	public Innlegg[] getSamling() {
		return this.samling;
	}
	
	public int finnInnlegg(Innlegg innlegg) {
		for(int i = 0; i < samling.length; i++) {
			if (samling[i] != null && samling[i].erLik(innlegg)) {
				return i;
			}
		}
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		for(Innlegg inl : samling) {
			if (inl != null && inl.erLik(innlegg)) {
				return true;
			}
		}
		return false;
	}

	public boolean ledigPlass() {
		return samling[samling.length - 1] == null;

	}
	
	public boolean leggTil(Innlegg innlegg) {

		if(!finnes(innlegg) && ledigPlass()) {
			for(int i = 0; i < samling.length; i++) {
				if(samling[i] == null) {
					samling[i] = innlegg;
					return true;
				}
			}
		}
		return false;
	}
	
	public String toString() {
		String retur = String.valueOf(getAntall()) + "\n";
		for(Innlegg innlegg : samling) {
			if(innlegg != null) {
				retur += innlegg.toString();
			}
		}
		return retur;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		Innlegg[] nySamling = new Innlegg[samling.length * 2]; // velger å doble størrelsen, helt vilkårlig.
		System.arraycopy(samling, 0, nySamling, 0, samling.length);
		this.samling = nySamling;
	}
	
	//TODO! Skriv test!
	public boolean leggTilUtvid(Innlegg innlegg) {

		if(!leggTil(innlegg)) {
			int index = samling.length;
			utvid();
			samling[index] = innlegg;
			return true;
		}
		return false;
	}
	
	public boolean slett(Innlegg innlegg) {
		for(int i = 0; i < samling.length; i++) {
			if(samling[i] != null && samling[i].equals(innlegg)) {
				samling[i] = null;
				return true;
			}
		}
		return false;
	}
	
	//TODO! Bruk toString til søk! 
	public int[] search(String keyword) {
		// Returner alle id til alle innlegg der teksten inneholder "keyword".
		throw new UnsupportedOperationException(TODO.method());

	}
}