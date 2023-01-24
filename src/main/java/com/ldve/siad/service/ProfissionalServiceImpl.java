package com.ldve.siad.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ldve.siad.model.Profissional;
import com.ldve.siad.repository.ProfissionalRepository;

import jakarta.persistence.Tuple;

@Service
public class ProfissionalServiceImpl implements ProfissionalService {

	@Autowired
	ProfissionalRepository repository;
	
	
	@Override
	public Profissional save(Profissional profissional) {
		return repository.save(profissional);
	}
	
	@Override
	public void deleteById(long id) {
		repository.deleteById(id);
	}
	
	@Override
	public Optional<Profissional> findById(long id) {
		return repository.findById(id);
	}

	@Override
	public List<Profissional> listAll() {
		return repository.findAll(Sort.by("nome"));
	}

	@Override
	public List<Profissional> find(String nome, Integer tipoPessoa, Boolean ativo) {
		Profissional profissional = new Profissional();
		profissional.setNome(nome);
		profissional.setTipoPessoa(tipoPessoa);
		profissional.setAtivo(ativo);
		return repository.findAll(Example.of(profissional));
	}

	@Override
	public List<Profissional> findByName(String nome) {
		return repository.findByName(nome);
	}

	@Override
	public List<Tuple> findListaAutoComplete(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Profissional findByCpf(String cpf, int idProfissional) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Profissional findByCnpj(String cnpj, int idProfissional) {
		// TODO Auto-generated method stub
		return null;
	}

}
