package com.aiport.util;

import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.text.MaskFormatter;

import org.springframework.stereotype.Service;

@Service
public class MascaraUtil {

	public String CNPJ = "##.###.###/####-##";
	public String CPF = "###.###.###-##";
	public String TELEFONE = "(##) ####-####";
	public String CEP = "#####-###";

	public String adicionarMascara(String valor, String mascara) throws ParseException {
		String valorTemp = valor;
		if (valorTemp != null) {
			MaskFormatter mf = new MaskFormatter(mascara);
			mf.setValueContainsLiteralCharacters(false);
			valorTemp = mf.valueToString(valorTemp);
		}
		return valorTemp;
	}

	public String removerMascara(String valor) {
		Pattern numericos = Pattern.compile("([0-9])");
		Matcher encaixe = numericos.matcher(valor);
		StringBuilder saida = new StringBuilder();
		while (encaixe.find()) {
			saida.append(encaixe.group());
		}
		return saida.toString();
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public String getCPF() {
		return CPF;
	}

	public String getTELEFONE() {
		return TELEFONE;
	}

	public String getCEP() {
		return CEP;
	}

}