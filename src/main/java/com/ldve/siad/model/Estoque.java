package com.ldve.siad.model;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.ldve.siad.util.Formatador;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Estoque {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idEstoque;
	@ManyToOne
	@NotNull
	@JoinColumn(name="idProduto", referencedColumnName="idProduto")
	private Produto produto;
	@NotNull
	private BigDecimal precoCompra;
	@NotNull
	private Calendar dataCompra;
	@NotNull
	private Calendar dataEntrada;
	private Calendar dataSaida;
	private Calendar dataExclusao;
	@NotNull
	private Calendar dataRegistro;
	@NotNull
	private String userEntrada;
	private String userUltimaAlteracao;
	private String userSaida;
	private String userExclusao;
	@NotNull
	private boolean isExcluido;
	@Column(length = 500)
	private String motivoExclusao;
	@Column(length = 500)
	private String motivoSaida;
	@ManyToOne
	@JoinColumn(name="idVendaItem", referencedColumnName="id")
	private VendaItem vendaItem;
	
	//*************************************************************************************************************
	public String getDataRegistroToString() {
		if (dataRegistro != null) {
			SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			String dataString  = format1.format(dataRegistro.getTime());
			return dataString;
		}else{
			return "";
		}
		
	}
	
	public String getDataCompraToString() {
		if (dataCompra != null) {
			SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
			String dataString  = format1.format(dataCompra.getTime());
			return dataString;
		}else{
			return "";
		}
		
	}
	
	public String getDataEntradaToString() {
		if (dataEntrada != null) {
			SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
			String dataString  = format1.format(dataEntrada.getTime());
			return dataString;
		}else{
			return "";
		}
		
	}
	
	public String getDataSaidaToString() {
		if (dataSaida != null) {
			SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			String dataString  = format1.format(dataSaida.getTime());
			return dataString;
		}else{
			return "";
		}
		
	}
	
	public String getDataExclusaoToString() {
		if (dataExclusao != null) {
			SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
			String dataString  = format1.format(dataExclusao.getTime());
			return dataString;
		}else{
			return "";
		}
		
	}
	
	public String getPrecoCompraToMoeda() {
		return Formatador.formatToMoeda(precoCompra);
	}
	
}
