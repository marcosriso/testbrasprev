package br.com.brasilprev.TesteBrasilPrev.services;

import br.com.brasilprev.TesteBrasilPrev.domain.Clients;
import br.com.brasilprev.TesteBrasilPrev.domain.Users;
import br.com.brasilprev.TesteBrasilPrev.repositories.ClientsRepository;
import br.com.brasilprev.TesteBrasilPrev.utils.ReturnStatus;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientsService {
    @Autowired
    private ClientsRepository clientsRepository;

    public List<Clients> getAll() {
        return clientsRepository.findAll();
    }

    public void save(Clients client) {
        clientsRepository.save(client);
    }

    public Optional<Clients> findById(Long Id){
        return clientsRepository.findById(Id);
    }

    /**
     ** Update Method
     *  Returns a Json Object with Action details
     *  @Author @memr_1979
     *  @Since 2021-02-09
     */
    public ObjectNode update(Long id, Clients client) {
        Optional<Clients> clientData = clientsRepository.findById(id);
        ReturnStatus returnStatus = new ReturnStatus();

        if (clientData.isPresent()){
            Clients clientUpdate = clientData.get();
            clientUpdate.setNome(client.getNome());
            clientUpdate.setCpf(client.getCpf());
            clientUpdate.setEndereco(client.getEndereco());

            try {
                clientsRepository.save(clientUpdate);
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
    public ObjectNode delete(Long id, Clients client) {
        Optional<Clients> clientData = clientsRepository.findById(id);
        ReturnStatus returnStatus = new ReturnStatus();

        if (clientData.isPresent()){
            Clients clientdelete = clientData.get();

            try {
                clientsRepository.delete(clientdelete);
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
