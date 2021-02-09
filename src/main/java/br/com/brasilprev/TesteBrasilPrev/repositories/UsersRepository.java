package br.com.brasilprev.TesteBrasilPrev.repositories;

import br.com.brasilprev.TesteBrasilPrev.domain.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsersRepository extends CrudRepository<Users, Long> {
    List<Users> findAll();
}