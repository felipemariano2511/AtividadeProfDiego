package br.com.unicuritiba.atividadeprofdiego.controller;

import br.com.unicuritiba.atividadeprofdiego.model.Client;
import br.com.unicuritiba.atividadeprofdiego.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping
    public ResponseEntity<?> searchAllClients() {
        return ResponseEntity.ok(service.searchAllClients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> searchClient(@PathVariable Long id) {
        return ResponseEntity.ok(service.searchClient(id));
    }

    @PostMapping
    public ResponseEntity<?> saveClient(@RequestBody Client client) {
        return ResponseEntity.ok(service.saveClient(client));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateClient(@PathVariable Long id, @RequestBody Client client) {
        return ResponseEntity.ok(service.updateClient(id, client));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable Long id) {
        return ResponseEntity.ok(service.deleteClient(id));
    }
}
