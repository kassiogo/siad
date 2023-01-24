package com.ldve.siad.service;

import java.util.List;
import java.util.Optional;

import com.ldve.siad.model.Profissional;

import jakarta.persistence.Tuple;

public interface ProfissionalService {
	Profissional save(Profissional profissional);
	void deleteById(long id);
	Optional<Profissional> findById( long id );
	List<Profissional> listAll();
	List<Profissional> find(String nome, Integer tipoPessoa, Boolean ativo);
	List<Profissional> findByName(String nome);
	List<Tuple> findListaAutoComplete(String nome);
	Profissional findByCpf(String cpf, int idProfissional);
	Profissional findByCnpj(String cnpj, int idProfissional);
}
