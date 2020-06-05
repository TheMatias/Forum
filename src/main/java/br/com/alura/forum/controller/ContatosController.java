package br.com.alura.forum.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.forum.model.Contato;
import br.com.alura.forum.repository.ContatoRepository;

@RestController
@RequestMapping("/contatos")
public class ContatosController {

	@Autowired
	private ContatoRepository contatoRepository;
	
	@GetMapping
	@Cacheable(value = "listaDeContatos")
	public List<Contato> lista(String nomeContato) {
		if (nomeContato == null) {
			List<Contato> contatos = contatoRepository.findAll();
			return contatos;
		} else {
			List<Contato> contatos = contatoRepository.findByNome(nomeContato);
			return contatos;
		}
	}

	@PostMapping()
	@Transactional
	@CacheEvict(value = "listaDeContatos", allEntries = true)
	public ResponseEntity<Contato> cadastrar(@RequestBody @Valid Contato formContato, UriComponentsBuilder uriBuilder) {
		Contato contato = contatoRepository.save(formContato);
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(contato.getId()).toUri();
		return ResponseEntity.created(uri).body(contato);
	}

	@GetMapping("/{id}")
	@Transactional
	public ResponseEntity<Contato> detalhar(@PathVariable Long id) {
		Optional<Contato> contato = contatoRepository.findById(id);
		if (contato.isPresent()) {
			return ResponseEntity.ok(contato.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaDeContatos", allEntries = true)
	public ResponseEntity<Contato> atualizar(@PathVariable Long id, @RequestBody @Valid Contato formContato) {
		Optional<Contato> optionalContato = contatoRepository.findById(id);
		if (optionalContato.isPresent()) {
			formContato.setId(optionalContato.get().getId());
			Contato contato = contatoRepository.save(formContato);
			return ResponseEntity.ok(contato);
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaDeContatos", allEntries = true)
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Contato> contato = contatoRepository.findById(id);
		if (contato.isPresent()) {
			contatoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}
	
	
}
