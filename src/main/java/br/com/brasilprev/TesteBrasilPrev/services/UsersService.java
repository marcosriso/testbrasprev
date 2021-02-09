package br.com.brasilprev.TesteBrasilPrev.services;

import br.com.brasilprev.TesteBrasilPrev.domain.Clients;
import br.com.brasilprev.TesteBrasilPrev.domain.Users;
import br.com.brasilprev.TesteBrasilPrev.repositories.UsersRepository;
import br.com.brasilprev.TesteBrasilPrev.utils.ReturnStatus;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    public List<Users> getAll() {
        return usersRepository.findAll();
    }

    public void save(Users user) {
        usersRepository.save(user);
    }

    public Optional<Users> findById(Long Id){
        return usersRepository.findById(Id);
    }

    /**
     ** Update Method
     *  Returns a Json Object with Action details
     *  @Author @memr_1979
     *  @Since 2021-02-09
     */
    public ObjectNode update(Long id, Users user) {
        Optional<Users> userData = usersRepository.findById(id);
        ReturnStatus returnStatus = new ReturnStatus();

        if (userData.isPresent()){
            Users userUpdate = userData.get();
            userUpdate.setUsername(user.getUsername());
            userUpdate.setPassword(user.getPassword());

            try {
                usersRepository.save(userUpdate);
                return returnStatus.statusUpdated();
            }catch (DataAccessException ex) {
                return returnStatus.statusError(ex.getMessage());
            }
        }
        else{
            return returnStatus.NotFound();
        }

    }

    /**
     ** Delete Method
     *  Returns a Json Object with Action details
     *  @Author @memr_1979
     *  @Since 2021-02-09
     */
    public ObjectNode delete(Long id, Users user) {
        Optional<Users> userData = usersRepository.findById(id);
        ReturnStatus returnStatus = new ReturnStatus();

        if (userData.isPresent()){
            Users userdelete = userData.get();

            try {
                usersRepository.delete(userdelete);
                return returnStatus.statusDeleted();
            }catch (DataAccessException ex) {
                return returnStatus.statusError(ex.getMessage());
            }
        }
        else{
            return returnStatus.NotFound();
        }
    }

}
