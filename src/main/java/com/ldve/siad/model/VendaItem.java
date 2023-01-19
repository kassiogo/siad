package com.ldve.siad.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "vendaItem")
public class VendaItem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@ManyToOne
	@JoinColumn(name="idVenda", referencedColumnName = "id")
	private Venda venda;
	@NotNull
	@ManyToOne
	@JoinColumn(name="idProduto", referencedColumnName = "idProduto")
	private Produto produto;
	@NotNull
	private BigDecimal valorVenda;
	@NotNull
	private Integer quantidade;
	private BigDecimal valorCompra;
	@ManyToOne
	@JoinColumn(name="idProfissional", referencedColumnName = "idProfissional")
	private Profissional profissional; 
	private BigDecimal comissaoProfissional;
	@NotNull
	private Calendar dataRegistro;
	@OneToMany(mappedBy = "vendaItem", targetEntity = Estoque.class)
	private List<Estoque> estoques;
	
}
