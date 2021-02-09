package br.com.brasilprev.TesteBrasilPrev.repositories;

import br.com.brasilprev.TesteBrasilPrev.domain.Clients;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ClientsRepository extends CrudRepository<Clients, Long> {
    List<Clients> findAll();
}