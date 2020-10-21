package no.hvl.dat100.jplab11.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.*;
import no.hvl.dat100.jplab11.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {
		
		Blogg blogg = null;
		
		// TODO! Finn en bedre løsning!
		int id = 0;
		String bruker = "";
		String dato = "";
		int likes = 0;
		String enTekst = "";
		String etBilde = "";
		String url = "";
		
		try {
			BufferedReader fil = new BufferedReader(new FileReader(mappe + filnavn));
			String linje = "";
			while((linje = fil.readLine()) != null)  {
				if(blogg == null) {
					blogg = new Blogg(Integer.valueOf(linje));
				}
				
				if(linje.equals(TEKST)) {
					// Vet at en tekst har 5 argumenter å sette.
					for(int i = 0; i < 5; i++) {
						switch (i){
							case(0):
								id = Integer.parseInt(fil.readLine());
								break;
							case(1):
								bruker = fil.readLine();
								break;
							case(2):
								dato = fil.readLine();
								break;
							case(3):
								likes = Integer.parseInt(fil.readLine());
								break;
							case(4):
								// tar utgangspunkt i at teksten kun er 1 linje. TODO! Fix dette!
								enTekst = fil.readLine(); 
								break;
						}
					}
					Innlegg tekst = new Tekst(id, bruker, dato, likes, enTekst);
					blogg.leggTil(tekst);
				} else if (linje.equals(BILDE)) {
					// Vet at et bilde har 6 argumenter å sette
					for(int i = 0; i < 6; i++) {
						switch (i){
							case(0):
								id = Integer.parseInt(fil.readLine());
								break;
							case(1):
								bruker = fil.readLine();
								break;
							case(2):
								dato = fil.readLine();
								break;
							case(3):
								likes = Integer.parseInt(fil.readLine());
								break;
							case(4):
								//Tar utgangs punkt i at bildetekst er 1 linje TODO! Fix dette!
								etBilde = fil.readLine();
								break;
							case(5):
								url = fil.readLine();
						}
					}
					Innlegg bilde = new Bilde(id, bruker, dato, likes, etBilde, url);
					blogg.leggTil(bilde);
				}
			}
			fil.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return blogg;

	}
}
