package br.com.senai.comercio194.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.comercio194.entity.Cliente;
import br.com.senai.comercio194.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService ClienteService;
    
    // listar todos os Clientes
    @GetMapping("/listar")
    public ResponseEntity<List<Cliente>> findAll(){
        List<Cliente> clientes = ClienteService.findAll();
        return ResponseEntity.ok().body(clientes);
    }

    // inserir um Cliente
    @PostMapping("/inserir")
    public ResponseEntity<Cliente> insertNew(@RequestBody Cliente cliente){
        Cliente clienteInserido = ClienteService.insertNew(cliente);
        return ResponseEntity.ok().body(clienteInserido);
    }

    // alterar pelo ID
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update (@PathVariable Long id, @RequestBody Cliente cliente) {
        Cliente clienteAlterado = ClienteService.update(id, cliente);
        return ResponseEntity.ok().body(clienteAlterado);
    }

    // apagar pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok().body (ClienteService.deleteById(id));
    }

    // listar pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(ClienteService.findById(id));
    }


}
