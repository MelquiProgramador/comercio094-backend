package br.com.senai.comercio194.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.comercio194.entity.Cliente;
import br.com.senai.comercio194.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository ClienteRepository;


    // AQUI ESTÁ UM !CRUD!
    // CRUD(create) R(read) U(update) D(delete)

    // listar todos os Clientes - CR(read) U D - CRUD(read)
    public List<Cliente> findAll(){
        return ClienteRepository.findAll();
    }

    // listar o cliente pelo ID - CR(read) U D - CRUD(read)
    public Cliente findById(Long id){
        return ClienteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o id: " + id));
    }

    // inserir um Cliente - C(create) RUD - CRUD(create)
    public Cliente insertNew(Cliente cliente){
        return ClienteRepository.save(cliente);
    }

    // alterar Cliente - CRU(update) D - CRUD(update)
    public Cliente update(Long id, Cliente ClienteAlterado){
        Cliente ClienteAtual = findById(id);
        ClienteAtual.setNome(ClienteAlterado.getNome());
        ClienteAtual.setEmail(ClienteAlterado.getEmail());
        ClienteAtual.setTelefone(ClienteAlterado.getTelefone());
        ClienteAtual.setEndereco(ClienteAlterado.getEndereco());
        ClienteRepository.save(ClienteAtual);
        return ClienteAtual;
    }

    // Apagar um Cliente - CRUD(delete) - CRUD(delete)
    public Boolean deleteById(Long id) {
        Cliente cliente = findById(id);
    if (cliente == null) {
        return false;
    }else{
        ClienteRepository.deleteById(id);
        return true;

    }
}
}