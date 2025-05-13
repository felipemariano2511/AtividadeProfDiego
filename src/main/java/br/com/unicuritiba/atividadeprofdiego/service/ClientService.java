package br.com.unicuritiba.atividadeprofdiego.service;

import br.com.unicuritiba.atividadeprofdiego.model.Client;
import br.com.unicuritiba.atividadeprofdiego.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public ResponseEntity<List<Client>> searchAllClients() {
        return ResponseEntity.ok(repository.findAll());
    }

    public ResponseEntity<Client> searchClient(Long id){
        return ResponseEntity.ok(repository.findById(id).
                orElseThrow(() -> new RuntimeException(String.format("Não encontrado o cliente com o id: %s", id))));
    }

    public ResponseEntity<Client> saveClient(Client client) {
        return ResponseEntity.ok(repository.save(client));
    }

    public ResponseEntity<Client> updateClient(Long id, Client client) {

       Client clientUpdate = repository.findById(id)
            .orElseThrow(() -> new RuntimeException(String.format(
                    "Cliente não encontrado com o id: %s", id)));

       clientUpdate.setName(client.getName());
       clientUpdate.setCpf(client.getCpf());
       clientUpdate.setPhone(client.getPhone());

        return ResponseEntity.ok(repository.saveAndFlush(clientUpdate));
    }

    public ResponseEntity<Client> deleteClient(Long id) {
        repository.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
