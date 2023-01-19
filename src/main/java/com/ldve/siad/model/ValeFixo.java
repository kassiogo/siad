package com.ldve.siad.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.ldve.siad.util.Formatador;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

@Entity
public class ValeFixo implements Serializable {

	private static final long serialVersionUID = -6765102008500926693L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idValeFixo;
	@NotNull
	private String descricao;
	@NotNull
	private BigDecimal valor;
	@NotNull
	private Calendar dataInicio;
	private Calendar dataFim;
	@NotNull
	private int diaVencimento;
	@ManyToMany
	@JoinTable(name="valefixo_profissional", joinColumns={@JoinColumn(name="idValeFixo")}, inverseJoinColumns={@JoinColumn(name="idProfissional")})
	private List<Profissional> profissionais;
	@NotNull
	private Calendar dataRegistro;
	private Calendar dataRegistroAlteracao;
	@NotNull
	private String userInclusao;
	private String userUltimaAlteracao;
	private String userExclusao;
	@OneToMany(mappedBy="valeFixo", targetEntity = FolhaPagamentoItem.class)
	private List<FolhaPagamentoItem> folhaPagamentoItens;
	
	
	//**********************************************************************************************************************************
	public String getDataInicioToString() {
		if (dataInicio != null) {
			SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
			String dataString  = format1.format(dataInicio.getTime());
			return dataString;
		}else{
			return "";
		}
		
	}
	
	public String getDataFimToString() {
		if (dataFim != null) {
			SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
			String dataString  = format1.format(dataFim.getTime());
			return dataString;
		}else{
			return "";
		}
		
	}
	
	public String getDataRegistroToString() {
		if (dataRegistro != null) {
			SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			String dataString  = format1.format(dataRegistro.getTime());
			return dataString;
		}else{
			return "";
		}
		
	}
	
	public String getValorToMoeda() {
		return Formatador.formatToMoeda(valor);
	}
}
