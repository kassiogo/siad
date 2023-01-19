package com.ldve.siad.repository;

import com.ldve.siad.model.Banco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BancoRepository extends JpaRepository<Banco, Integer> {

    @Query(value = "FROM Banco"
            + " WHERE nome LIKE %:nome%"
            + " AND codigo LIKE %:codigo%"
            + " ORDER BY nome")
    List<Banco> find(@Param("nome") String nome, @Param("codigo") String codigo);

    @Query(value="SELECT distinct(b)"
            + " FROM Banco b"
            + " WHERE b.nome LIKE %:termo%"
            + " ORDER BY b.nome")
    List<Banco> findByName(@Param("termo") String termo);

}