package br.com.senai.comercio194.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.comercio194.entity.Cliente;
import br.com.senai.comercio194.repository.ClienteRepository;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository ClienteRepository;


    // listar todos os Clientes
    public List<Cliente> findAll(){
        return ClienteRepository.findAll();
    }

    public Cliente findById(Long id){
        return ClienteRepository.findById(id).orElse(null);
    }

    // inserir um Cliente
    public Cliente insertNew(Cliente Cliente){
        return ClienteRepository.save(Cliente);
    }

    // alterar Cliente 
    public Cliente update(Long id, Cliente ClienteAlterado){
        Cliente ClienteAtual = findById(id);
        ClienteAtual.setNome(ClienteAlterado.getNome());
        ClienteAtual.setEmail(ClienteAlterado.getEmail());
        ClienteAtual.setTelefone(ClienteAlterado.getTelefone());
        ClienteAtual.setEndereco(ClienteAlterado.getEndereco());
        ClienteRepository.save(ClienteAtual);
        return ClienteAtual;
    }

    // Apagar um Cliente
    public Boolean deleteById(Long id) {
        Cliente Cliente = findById(id);
    if (Cliente == null) {
        return false;
    }else{
        ClienteRepository.deleteById(id);
        return true;

    }
}
}