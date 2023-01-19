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
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "vale")
public class Vale implements Serializable {
	
	private static final long serialVersionUID = 8394433285553877277L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idVale;
	@ManyToOne
	@NotNull
	@JoinColumn(name="idProfissional", referencedColumnName="idProfissional")
	private Profissional profissional;
	@NotNull
	private Calendar dataRegistro;
	private Calendar dataRegistroAlteracao;
	@NotNull
	private Calendar dataLancamento;
	@NotNull
	private BigDecimal valor;
	@NotNull
	private Calendar dataVencimento;
	@NotNull
	@NotEmpty
	private String descricao;
	@NotNull
	private String userInclusao;
	private String userUltimaAlteracao;
	private String userExclusao;
	@NotNull
	private boolean isAtivo;
	@NotNull
	private int tipoVale; //1-Debito, 2-Crédito
	@OneToOne(mappedBy="vale", targetEntity = FolhaPagamentoItem.class)
	private FolhaPagamentoItem folhaPagamentoItem;
	
	
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
	
	public String getDataRegistroAlteracaoToString() {
		if (dataRegistroAlteracao != null) {
			SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			String dataString  = format1.format(dataRegistroAlteracao.getTime());
			return dataString;
		}else{
			return "";
		}
		
	}
	
	public String getDataLancamentoToString() {
		if (dataLancamento != null) {
			SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
			String dataString  = format1.format(dataLancamento.getTime());
			return dataString;
		}else{
			return "";
		}
		
	}
	
	public String getDataVencimentoToString() {
		if (dataVencimento != null) {
			SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
			String dataString  = format1.format(dataVencimento.getTime());
			return dataString;
		}else{
			return "";
		}
		
	}
	
	public String getValorToMoeda() {
		return Formatador.formatToMoeda(valor);
	}

	
}
