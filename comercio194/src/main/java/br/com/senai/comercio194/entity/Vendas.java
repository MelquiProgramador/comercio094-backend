package br.com.senai.comercio194.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Vendas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantidadeVendida;
    private double precoUnidade;
    private String dataVenda;

    // conectando a outra tabela, a de Clientes
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    // conectando a outra tabela, a de Produtos
    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

}