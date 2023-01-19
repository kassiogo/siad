package com.ldve.siad.model;

import java.math.BigDecimal;
import java.util.List;

import com.ldve.siad.util.Formatador;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

@Entity
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProduto;
	@NotNull
	@ManyToOne
	@JoinColumn(name="idFabricante", referencedColumnName="idFabricante")
	private Fabricante fabricante;
	@NotNull
	@Column(name="nome", nullable=false, length=512)
	private String nome;
	private BigDecimal precoVenda;
	private BigDecimal descontoMaximo;
	private BigDecimal precoVendaProfissional;
	@NotNull
	private int estoqueMinino;
	@NotNull
	private int somenteUsoInterno;
	@Column(length = 8000)
	private String descricao;
	@OneToMany(mappedBy="produto", targetEntity = Estoque.class)
	private List<Estoque> estoques;
	@OneToMany(mappedBy="produto", targetEntity = VendaItem.class)
	private List<VendaItem> vendasItems;
	
	private BigDecimal comissaoProfissional;
	

	//******************************************************************************************
	public String getPrecoVendaToMoeda() {
		String valorMoeda = "";
		if (precoVenda != null)
			valorMoeda = Formatador.formatToMoeda(precoVenda);
		
		valorMoeda = valorMoeda.replace("R$", "");
		return valorMoeda.trim();
	}
	
	public String getPrecoVendaProfissionalToMoeda() {
		String valorMoeda = "";
		if (precoVendaProfissional != null)
			valorMoeda = Formatador.formatToMoeda(precoVendaProfissional);
		
		valorMoeda = valorMoeda.replace("R$", "");
		return valorMoeda.trim();
	}
	
	
}
