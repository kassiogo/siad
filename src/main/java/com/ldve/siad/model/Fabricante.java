package com.ldve.siad.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

@Entity
public class Fabricante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idFabricante;
	@NotNull
	@Column(name="nome", nullable=false, length=512)
	private String nome;
	@OneToMany(mappedBy="fabricante", targetEntity = Produto.class, fetch = FetchType.LAZY)
	private List<Produto> produtos;
	
}
