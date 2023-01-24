package com.ldve.siad.service;

import com.ldve.siad.model.Banco;

import java.util.List;

public interface BancoService {

    Banco findById(Integer id);
    List<Banco> find(String nome, String codigo);
    Banco save(Banco banco);
    void deleteById(Integer id);
}
