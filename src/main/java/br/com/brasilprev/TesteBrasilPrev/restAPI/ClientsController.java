package br.com.brasilprev.TesteBrasilPrev.restAPI;

import br.com.brasilprev.TesteBrasilPrev.domain.Clients;
import br.com.brasilprev.TesteBrasilPrev.services.ClientsService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
public class ClientsController {
    @Autowired
    private ClientsService clientsService;

    @PostMapping(value = "/client", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveUser(final @RequestBody Clients user, HttpServletResponse response) {
        try{
            clientsService.save(user);
            response.setStatus(HttpServletResponse.SC_CREATED);
        }catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @PostMapping(value = "/client/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ObjectNode updateClients(@PathVariable("id") Long id, final @RequestBody Clients client){
        return clientsService.update(id, client);
    }

    @PostMapping(value = "/client/delete/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ObjectNode deleteClients(@PathVariable("id") Long id, final @RequestBody Clients client){
        return clientsService.delete(id, client);
    }

    @GetMapping("/clients")
    public List<Clients> clientsList() {
        return clientsService.getAll();
    }

    /**
     * @TODO Make a proper response in case of not found.
     * @param id
     * @return
     */
    @GetMapping("/client/{id}")
    public Clients clientInfo(@PathVariable("id") Long id) {
        Optional<Clients> optionalClients = clientsService.findById(id);

        Clients client = new Clients();
        if(optionalClients.isPresent()) {
            client = optionalClients.get();
        }

        return client;
    }
}
