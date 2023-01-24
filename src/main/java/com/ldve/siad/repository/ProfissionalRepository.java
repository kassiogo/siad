package com.ldve.siad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ldve.siad.model.Profissional;

public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {
	
	/**
	 * Método que seleciona um profissional pelo nome ou parte do nome.
	 * @param nome
	 * @return
	 */
	@Query(value = "FROM Profissional"
			+ " WHERE nome LIKE %:nome%"
			+ " AND isAtivo = 1"
			+ " ORDER BY nome")
	List<Profissional> findByName(String nome);
	
	
	
}
