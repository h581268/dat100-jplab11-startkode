package no.hvl.dat100.jplab11.oppgave6;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.Innlegg;
import no.hvl.dat100.jplab11.oppgave3.Blogg;

public class HtmlBlogg extends Blogg {

	public HtmlBlogg() {
		super();
	}
	
	private static String HTMLPREFIX = 
			"<html>\n\t<head>\n\t\t<title>DAT100 Blogg</title>\n\t</head>\n\t<body>\n";
	
	private static String HTMLPOSTFIX = 
			"\t</body>\n</html>";
	
	private String getBody() {
		String body = "";
		for(Innlegg innlegg : super.getSamling()) {
			if (innlegg == null) {
				break;
			}
			body += innlegg.toHTML();
		}
		return body;
	}
	
	@Override
	public String toString() {
		
		return HTMLPREFIX + getBody() + HTMLPOSTFIX;
		
	}
}
