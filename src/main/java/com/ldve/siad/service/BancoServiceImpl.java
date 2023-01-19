package com.ldve.siad.service;

import com.ldve.siad.model.Banco;
import com.ldve.siad.repository.BancoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BancoServiceImpl implements BancoService {
    @Autowired
    BancoRepository repository;

    @Override
    public Banco findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Banco> find(String nome, String codigo) {
        return repository.find(nome, codigo);
    }

    @Override
    public Banco save(Banco banco) {
        return repository.save(banco);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

}
