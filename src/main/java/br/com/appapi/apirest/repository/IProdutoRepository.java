package br.com.appapi.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.appapi.apirest.models.Produto;



public interface IProdutoRepository extends JpaRepository<Produto, Long>{
	
	Produto findById(long id);

}
