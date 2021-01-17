package br.com.ayty.fintech.repository;

import org.springframework.data.repository.CrudRepository;


import br.com.ayty.fintech.models.Cadastro;

public interface CadastroRepository extends CrudRepository<Cadastro, String> {
	Cadastro findByCodigo(long codigo);
}
