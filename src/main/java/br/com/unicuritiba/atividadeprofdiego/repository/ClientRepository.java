package br.com.unicuritiba.atividadeprofdiego.repository;

import br.com.unicuritiba.atividadeprofdiego.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {}
