package com.example.Notas.webscrap;

import java.io.IOException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.example.Notas.webscrap.modelo.Nota;

public class Webscrap {
	
	public static void main(String[] args) {
		
		int i = 0;
		ArrayList<Nota> notasInsert = new ArrayList<>();
		String verificacao = "<td><img src=\"imagens/bola_verde_P.png\"></td>";
		String url = "https://www.nfe.fazenda.gov.br/portal/disponibilidade.aspx?versao=2.00";
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("notas");
		EntityManager em = factory.createEntityManager();
		
		
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Elements table = doc.getElementsByClass("tabelaListagemDados").first()
				.getElementsByTag("tr");
		
		
		em.getTransaction().begin();
		for (Element linha: table) {
			try {
			//Pular a primeira linha da tabela
			if (i == 0) {
				i++;
				continue;
			}
			
			for (int j = 0; j <= 8; j++) {
				
				Element linhas = table.get(j);
				Nota nota = new Nota();
				
				if (j == 0) {
					nota.setNomeUF(linha.getElementsByTag("td").first().text());
					System.out.println(nota.getNomeUF());
					
				} else if (j == 6) continue; // Pular a célula de tempo
				
				System.out.println(linha.getElementsByTag("td").toString().contains(verificacao));
				
				if (linha.getElementsByTag("td").toString().contains(verificacao)) {
					
					if (j == 1) {
						nota.setAutorizacao("Disponível");
						System.out.println(nota.getAutorizacao());
					}
					else if (j == 2) {
						nota.setRetornoAutorizacao("Disponivel");
					}
					else if (j == 3) {
						nota.setInutilizacao("Disponivel");
					}
					else if (j == 4) {
						nota.setConsultaProtocolo("Disponível");
					}
					else if (j == 5) {
						nota.setStatusServico("Disponiel");						
					}
					else if (j == 7) {
						nota.setConsultaCadastro("Disponível");
					}
					else if (j == 8) {
						nota.setRecepcaoEvento("Disponivel");						
					}
				}
				
				notasInsert.add(nota);
			}  
			
			em.persist(notasInsert.get(i));
			i++;
			} catch (NullPointerException e) {}
			
			try {
				em.getTransaction().commit();
			} catch (IllegalStateException e) {}
		}	
		
		
		em.close();
	}
}