package com.ldve.siad.model;

import java.io.Serializable;
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
@Table(name = "venda")
public class Venda implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private Calendar dataVenda;
	@NotNull
	private Calendar dataRegistro;
	@NotNull
	private String usuarioVenda;
	@NotNull
	@ManyToOne
	@JoinColumn(name="idTipoVenda", referencedColumnName="id")
	private TipoVenda tipoVenda;
	@ManyToOne
	@JoinColumn(name="idMotivoCancelamento", referencedColumnName = "id")
	private MotivoCancelamento motivoCancelamento;
	String usuarioCancelamento;
	String observacaoCancelamento;
	@OneToMany(mappedBy = "venda", targetEntity = VendaItem.class)
	private List<VendaItem> vendasItems;
	
}
