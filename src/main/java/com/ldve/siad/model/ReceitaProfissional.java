package com.ldve.siad.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.ldve.siad.util.Formatador;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "receita_profissional")
public class ReceitaProfissional implements Serializable {
	
	private static final long serialVersionUID = 1746030301920188256L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idReceitaProfissional;
	@NotNull
	private BigDecimal valor;
	@ManyToOne
	@NotNull
	@JoinColumn(name="idProfissional", referencedColumnName="idProfissional")
	private Profissional profissional;
	@NotNull
	private Calendar dataRegistro;
	private Calendar dataRegistroAlteracao;
	@NotNull
	private Calendar dataReceita;
	private String userInclusao;
	private String userUltimaAlteracao;
	private String userExclusao;
	@NotNull
	private boolean isAtivo;
	@ManyToOne
	@JoinColumn(name="idBanco", referencedColumnName="idBanco")
	private Banco banco;
	@OneToOne(mappedBy="receitaProfissional", targetEntity = FolhaPagamentoItem.class)
	private FolhaPagamentoItem folhaPagamentoItem;
	
	
	//*****************************************************************************************************************************
	public String getValorToMoeda() {
		String valorMoeda = "";
		valorMoeda = Formatador.formatToMoeda(valor);
		valorMoeda = valorMoeda.replace("R$", "");
		return valorMoeda.trim();
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
	
	public String getDataRegistroAlteracaoToString() {
		if (dataRegistroAlteracao != null) {
			SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			String dataString  = format1.format(dataRegistroAlteracao.getTime());
			return dataString;
		}else{
			return "";
		}
		
	}
	
}
