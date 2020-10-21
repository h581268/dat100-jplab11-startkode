package no.hvl.dat100.jplab11.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import no.hvl.dat100.jplab11.oppgave1.Innlegg;
import no.hvl.dat100.jplab11.oppgave3.*;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {
		
		try {
			PrintWriter fil = new PrintWriter(mappe + filnavn);

			fil.write(String.valueOf(samling.getAntall())+ "\n");
			for(Innlegg innlegg : samling.getSamling()) {
				if (innlegg == null) {
					break;
				}
				fil.write(innlegg.toString());
			}
			fil.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return true;
	}
}
