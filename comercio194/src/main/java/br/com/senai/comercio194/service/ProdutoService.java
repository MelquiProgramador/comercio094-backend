package br.com.senai.comercio194.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.comercio194.entity.Produto;
import br.com.senai.comercio194.repository.ProdutoRepository;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;


    // listar todos os produtos
    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }

    public Produto findById(Long id){
        return produtoRepository.findById(id).orElse(null);
    }

    // inserir um produto
    public Produto insertNew(Produto produto){
        return produtoRepository.save(produto);
    }

    // alterar produto 
    public Produto update(Long id, Produto produtoAlterado){
        Produto produtoAtual = findById(id);
        produtoAtual.setNome(produtoAlterado.getNome());
        produtoAtual.setPreco(produtoAlterado.getPreco());
        produtoAtual.setDescricao(produtoAlterado.getDescricao());
        produtoAtual.setQuantidade(produtoAlterado.getQuantidade());
        produtoRepository.save(produtoAtual);
        return produtoAtual;
    }

    // Apagar um produto
    public Boolean deleteById(Long id) {
        Produto produto = findById(id);
    if (produto == null) {
        return false;
    }else{
        produtoRepository.deleteById(id);
        return true;

    }
}
}