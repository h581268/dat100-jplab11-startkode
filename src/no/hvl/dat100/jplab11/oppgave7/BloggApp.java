package no.hvl.dat100.jplab11.oppgave7;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import no.hvl.dat100.jplab11.oppgave2.Bilde;
import no.hvl.dat100.jplab11.oppgave2.Tekst;
import no.hvl.dat100.jplab11.oppgave3.Blogg;
import no.hvl.dat100.jplab11.oppgave6.HtmlBlogg;

public class BloggApp {

	public static String toHTML() {

		Tekst innlegg1 = new Tekst(1, "Sven-Olai", "23-10-2020",
				"Harald, hva er status for den siste obligatoriske innleveringen?");
		Bilde innlegg2 = new Bilde(2, "Harald", "24-10-2020",
				"Ser bra ut! - har lagt ved output-eksempel fra enhetstester",
				"https://cdn1.bbcode0.com/uploads/2020/10/20/bbaeb2bf000360b087cd5f62a9967d12-full.png?__cf_chl_jschl_tk__=afabfd9388a40f4b1b951fc86cbf729b4ac9ec40-1603323752-0-AfjnRb7I6Rk1jiFtm3ipYJubuGYAwBmRJqlLV0L79EDEvyVoNwluv9rKL29E6j9-BpiH-xWf6WyGXrjV9Qt2sTuPzeLSRsk7wGVHicBQ7YbWdR5DQiZvY5Fur7tDursEVbHLnM2ECQ2Ha3nCU3rFkGSoxLSm2dYUnvIIcOGs8CzZ_w8P5iGxIKsDyhpJMPMwVqVPq-LGuY7LSipXO9ktEuOjrpnK2Qta3491jyEzoKZHckyHi3EXKKvSubLd4SCYzXRNJwOx3dGas4PMVyT2BWUCdZ1qnZ4cRe76PRj-wQLK3daSEalXunOzvDu8IhzHO8IwUBJBwWSk1iYyZwvo7cFnsFrlLssRS4gqPAeZiHao");

		innlegg1.doLike();
		innlegg1.doLike();
		innlegg2.doLike();

		HtmlBlogg samling = new HtmlBlogg();

		samling.leggTil(innlegg1);
		samling.leggTil(innlegg2);

		return samling.toString();
	}

	private ServerSocket welcomeSocket;

	public BloggApp(ServerSocket welcomeSocket) {
		this.welcomeSocket = welcomeSocket;
	}

	public void process() {

		try {

			System.out.println("SERVER ACCEPTING");

			Socket connectionSocket = welcomeSocket.accept();

			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

			String text = inFromClient.readLine();

			System.out.println("SERVER RECEIVED: " + text);

			String htmlbody = toHTML();

			String header = "HTTP/1.1 200 OK\n" + "Server: DAT100 HTTP Server : 1.0\n" + "Date: " + (new Date()) + "\n"
					+ "Content-type: " + "text/html" + "\n" + "Content-length: " + htmlbody.length() + "\n" + "\n";

			String outtext = header + htmlbody;

			System.out.println("SERVER SENDING: " + outtext);

			outToClient.write(outtext.getBytes());
			outToClient.flush();

			outToClient.close();
			inFromClient.close();

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				
			}
			connectionSocket.close();

		} catch (IOException ex) {

			System.out.println("TCPServer: " + ex.getMessage());
			ex.printStackTrace();
			System.exit(1);

		}
	}
}
