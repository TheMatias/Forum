package br.com.alura.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.forum.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

	List<Contato> findByNome(String nome);
}
