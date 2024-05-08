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
    
    @GetMapping("/listar")
    public ResponseEntity<List<Cliente>> findAll(){
        List<Cliente> Clientes = ClienteService.findAll();
        return ResponseEntity.ok().body(Clientes); 
    }

    @PostMapping("/inserir")
    public ResponseEntity<Cliente> insertNew(@RequestBody Cliente Cliente){
        Cliente ClienteInserido = ClienteService.insertNew(Cliente);
        return ResponseEntity.ok().body(ClienteInserido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update (@PathVariable Long id, @RequestBody Cliente Cliente) {
        Cliente ClienteAlterado = ClienteService.update(id, Cliente);
        return ResponseEntity.ok().body (ClienteAlterado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok().body (ClienteService.deleteById(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(ClienteService.findById(id));
    }
}
