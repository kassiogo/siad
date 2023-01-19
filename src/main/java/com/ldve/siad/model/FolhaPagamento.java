package com.ldve.siad.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "folhapagamento")
public class FolhaPagamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idFolhaPagamento;
	@OneToMany(mappedBy="folhaPagamento", targetEntity = FolhaPagamentoItem.class)
	private List<FolhaPagamentoItem> folhaPagamentoItens;
	@NotNull
	private Calendar dataRegistro;
	@NotNull
	private String userInclusao;
	@NotNull
	private int mesReferencia;
	@NotNull
	private int anoReferencia;
	
	public String getDataRegistroToString() {
		if (dataRegistro != null) {
			SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			String dataString  = format1.format(dataRegistro.getTime());
			return dataString;
		}else{
			return "";
		}
		
	}
}
