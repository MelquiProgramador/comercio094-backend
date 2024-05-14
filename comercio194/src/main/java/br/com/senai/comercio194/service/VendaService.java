package br.com.senai.comercio194.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.comercio194.entity.Produto;
import br.com.senai.comercio194.entity.Venda;
import br.com.senai.comercio194.repository.ProdutoRepository;
import br.com.senai.comercio194.repository.VendaRepository;

@Service
public class VendaService {
    
    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;
    // mostrar todas as vendas
    public List<Venda> findAll(){
        return vendaRepository.findAll();
    }

    //mostrar uma venda especifica
    public Venda findById(Long id){
        return vendaRepository.findById(id).orElse(null);
    }

    public Venda realizarVenda(Venda venda){
        // inserir a data de hoje como data da venda
        venda.setDataVenda(LocalDate.now());

        // Reduzir a quantidade de produto no estoque
        Produto produto = produtoRepository.findById(venda.getProdutoId()).orElse(null);
        if (produto == null){
            return null;
        } else {
            int quantidadeVendida = venda.getQuantidade();
            int quantidadeAtualizada = produto.getQuantidade();
            produto.setQuantidade(quantidadeAtualizada - quantidadeVendida);
            produtoRepository.save(produto);

            venda.setPrecoTotal(quantidadeVendida*produto.getPreco());

            return vendaRepository.save(venda);
        }
    }
}
