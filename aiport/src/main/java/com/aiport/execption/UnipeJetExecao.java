package com.aiport.execption;

import java.util.ArrayList;
import java.util.List;


public class UnipeJetExecao extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private static final String PONTO_E_VIRGULA = ".";

	private static final String ESPACO_EM_BRANCO = " ";
	
	private final List<String> mensagemList;
	private final String message;

	public UnipeJetExecao() {
		super();
		this.mensagemList = new ArrayList<String>();
		this.message = new String();
		
	}
	
	public UnipeJetExecao(String mensagem){
		this.message = mensagem;
		this.mensagemList = new ArrayList<String>();
	}
	
	public UnipeJetExecao(List<String> mensagemList) {
		StringBuilder sb = new StringBuilder();
		for (String msg : mensagemList) {
			sb.append(msg+PONTO_E_VIRGULA+ESPACO_EM_BRANCO);
		}
		this.mensagemList = mensagemList;
		this.message = sb.toString();
	}
	
	public List<String> getMensagemList() {
		return mensagemList;
	}
	
	@Override
	public String getMessage() {
		return message;
	}

}
