package com.ldve.siad.util;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Formatador {
	
	public static Calendar convertStringToCalendar(String data, String formato) {
		DateFormat df = new SimpleDateFormat(formato);
		Calendar cal  = Calendar.getInstance();
		
		try {
			cal.setTime(df.parse(data));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cal;
	}
	
	public static String convertCalendarToString(Calendar data, String formato) {
		SimpleDateFormat format1 = new SimpleDateFormat(formato);
		String dataString  = format1.format(data.getTime());
		return dataString;
	}
	
	public static String formatToMoeda(BigDecimal valor) {
		Locale ptBr = new Locale("pt", "BR");
		
		NumberFormat nf = NumberFormat.getCurrencyInstance(ptBr);  
		String formatado = nf.format (valor);
		return formatado.trim();
	}
	
	public static String formatToMoeda(String strValor) {
		Locale ptBr = new Locale("pt", "BR");
		NumberFormat nf = NumberFormat.getCurrencyInstance(ptBr);
		BigDecimal valor = new BigDecimal(strValor);
		String formatado = nf.format (valor);
		return formatado.trim();
	}
	
	public static String formatToMoedaSemSimbolo(BigDecimal valor) {
		Locale ptBr = new Locale("pt", "BR");
		
		NumberFormat nf = NumberFormat.getInstance(ptBr);
		nf.setMinimumFractionDigits(2);
		nf.setMaximumFractionDigits(2);
		String formatado = nf.format (valor);
		return formatado.trim();
	}
	
	public static String formatMoedaToDecimal(String strValor) {
		String formatado = strValor;
		formatado = formatado.replace("R$", "");
		formatado = formatado.trim();
		formatado = formatado.replace(".", "");
		formatado = formatado.replace(",", ".");
		formatado = formatado.replace('\u00A0',' ').trim(); //remover todos os espaços a esquerda e a direita
		return formatado;
	}
	
	
	public static String formatNumero(BigDecimal valor, int quantidadeDecimal) {
		Locale ptBr = new Locale("pt", "BR");
		NumberFormat nf = NumberFormat.getInstance(ptBr);
		nf.setMinimumFractionDigits(quantidadeDecimal);
		String formatado = nf.format (valor);
		return formatado.trim();
	}
	
	public static String formatNumeroPorcentagem(BigDecimal valor) {
		Locale ptBr = new Locale("pt", "BR");
		NumberFormat percentageFormat = NumberFormat.getPercentInstance(ptBr);
		percentageFormat.setMinimumFractionDigits(2);
		percentageFormat.setMaximumFractionDigits(2);
		String percentage = percentageFormat.format(valor);
		return percentage;
	}
}
