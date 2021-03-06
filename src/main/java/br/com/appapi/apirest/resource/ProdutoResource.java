package br.com.appapi.apirest.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.appapi.apirest.models.Produto;
import br.com.appapi.apirest.repository.IProdutoRepository;


@RestController
@RequestMapping(value="/api")
public class ProdutoResource {
	
	@Autowired
	IProdutoRepository produtoRepository;
	
	
	@GetMapping("/produtos")
	public List<Produto> listaProdutos(){
		return produtoRepository.findAll();
	}
	
	@GetMapping("/produto/{id}")
	public Produto listaProdutoUnico(@PathVariable(value="id") long id){
		return produtoRepository.findById(id);
	}
	
	@PostMapping("/produto")
	public Produto salvaProduto(@RequestBody @Valid Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@DeleteMapping("/produto")
	public void deletaProduto(@RequestBody @Valid Produto produto) {
		produtoRepository.delete(produto);
	}
	
	@PutMapping("/produto")
	public Produto atualizaProduto(@RequestBody @Valid Produto produto) {
		return produtoRepository.save(produto);
	}
	
	
}
