package com.ldve.siad.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Banco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idBanco;
	@NotBlank
	private String nome;
	@NotBlank
	private String codigo;
	private String site;
	@JsonIgnore
	@OneToMany(mappedBy="banco", targetEntity = Profissional.class)
	private List<Profissional> profissionais;
	@JsonIgnore
	@OneToMany(mappedBy="banco", targetEntity = FolhaPagamentoItem.class)
	private List<FolhaPagamentoItem> folhasPagamentosItens;
	@JsonIgnore
	@OneToMany(mappedBy="banco", targetEntity = ReceitaProfissional.class)
	private List<ReceitaProfissional> receitasProfissional;


}
