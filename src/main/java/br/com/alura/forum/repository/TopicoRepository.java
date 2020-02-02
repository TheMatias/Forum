package br.com.alura.forum.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.forum.model.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

	// metodo responsavel por retornar atributo nomme de curso
	// se houver um atributo em topico nomeada cursoNome
	// para se referir ao atributo de nome do curso
	// sera necessario adicionar o underline entre o nome da classe e do atributo
	// segue o exemplo..
	// List<Topico> findByCurso_Nome(String nomeCurso);
	List<Topico> findByCursoNome(String nomeCurso);

	Optional<Topico> findByTitulo(String titulo);
}
