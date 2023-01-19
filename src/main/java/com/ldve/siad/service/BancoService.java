package com.ldve.siad.service;

import com.ldve.siad.model.Banco;

import java.util.List;

public interface BancoService {

    public Banco findById(Integer id);
    public List<Banco> find(String nome, String codigo);
    public Banco save(Banco banco);
    public void deleteById(Integer id);
}
