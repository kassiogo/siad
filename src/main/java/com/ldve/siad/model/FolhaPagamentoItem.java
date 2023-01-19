package com.ldve.siad.model;

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
@Table(name = "folhapagamento_item")
public class FolhaPagamentoItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFolhaPagamentoItem;
	@ManyToOne
	@NotNull
	@JoinColumn(name="idFolhaPagamento", referencedColumnName="idFolhaPagamento")
	private FolhaPagamento folhaPagamento;
	@ManyToOne
	@NotNull
	@JoinColumn(name="idProfissional", referencedColumnName="idProfissional")
	private Profissional profissional;
	@ManyToOne
	@JoinColumn(name="idBanco", referencedColumnName="idBanco")
	private Banco banco;
	@OneToOne
	@JoinColumn(name="idVale", referencedColumnName="idVale")
	private Vale vale;
	@ManyToOne
	@JoinColumn(name="idValeFixo", referencedColumnName="idValeFixo")
	private ValeFixo valeFixo;
	@OneToOne
	@JoinColumn(name="idReceitaProfissional", referencedColumnName="idReceitaProfissional")
	private ReceitaProfissional receitaProfissional;
	@NotNull
	private String descricao;
	@NotNull
	private BigDecimal valor;
	@NotNull
	private String operacao; //C - Débito, D - Débito
	@NotNull
	private Calendar dataVencimento;
	private Calendar dataLancamento;
	@NotNull
	private String nomeProfissional;
	@NotNull
	int tipoPessoa;
	
	
	//******************************************************************************************************************
	public String getDataVencimentoToString() {
		if (dataVencimento != null) {
			SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
			String dataString  = format1.format(dataVencimento.getTime());
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
	
	public String getValorToMoeda() {
		return Formatador.formatToMoeda(valor);
	}
	
}
