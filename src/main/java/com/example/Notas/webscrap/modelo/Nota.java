package com.example.Notas.webscrap.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "notas")
public class Nota {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nomeUF;
	private String autorizacao = "Indisponivel";
	private String retornoAutorizacao = "Indisponivel";
	private String inutilizacao = "Indisponivel";
	private String consultaProtocolo = "Indisponivel";
	private String statusServico = "Indisponivel";
	private String consultaCadastro = "Indisponivel";
	private String recepcaoEvento = "Indisponivel";

	//public Nota(){
		//Default
	//}
	
	public String getAutorizacao() {
		return autorizacao;
	}

	public void setAutorizacao(String autorizacao) {
		this.autorizacao = autorizacao;
	}

	public String getRetornoAutorizacao() {
		return retornoAutorizacao;
	}

	public void setRetornoAutorizacao(String retornoAutorizacao) {
		this.retornoAutorizacao = retornoAutorizacao;
	}

	public String getInutilizacao() {
		return inutilizacao;
	}

	public void setInutilizacao(String inutilizacao) {
		this.inutilizacao = inutilizacao;
	}

	public String getConsultaProtocolo() {
		return consultaProtocolo;
	}

	public void setConsultaProtocolo(String consultaProtocolo) {
		this.consultaProtocolo = consultaProtocolo;
	}

	public String getStatusServico() {
		return statusServico;
	}

	public void setStatusServico(String statusServico) {
		this.statusServico = statusServico;
	}

	public String getConsultaCadastro() {
		return consultaCadastro;
	}

	public void setConsultaCadastro(String consultaCadastro) {
		this.consultaCadastro = consultaCadastro;
	}

	public String getRecepcaoEvento() {
		return recepcaoEvento;
	}

	public void setRecepcaoEvento(String recepcaoEvento) {
		this.recepcaoEvento = recepcaoEvento;
	}


	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public String getNomeUF() {
		return nomeUF;
	}

	public void setNomeUF(String nomeUF) {
		this.nomeUF = nomeUF;
	}

}
