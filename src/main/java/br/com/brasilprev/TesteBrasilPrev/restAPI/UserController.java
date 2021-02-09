package br.com.brasilprev.TesteBrasilPrev.restAPI;

import br.com.brasilprev.TesteBrasilPrev.domain.Users;
import br.com.brasilprev.TesteBrasilPrev.services.UsersService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UsersService usersService;

    @PostMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveUser(final @RequestBody Users user, HttpServletResponse response) {
        try{
            usersService.save(user);
            response.setStatus(HttpServletResponse.SC_CREATED);
        }catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @PostMapping(value = "/user/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ObjectNode updateUser(@PathVariable("id") Long id, final @RequestBody Users user){
        return usersService.update(id, user);
    }

    @PostMapping(value = "/user/delete/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ObjectNode deleteUser(@PathVariable("id") Long id, final @RequestBody Users user){
        return usersService.delete(id, user);
    }

    @GetMapping("/users")
    public List<Users> UsersList() {
        return usersService.getAll();
    }

    /**
     * @TODO Make a proper response.
     * @param id
     * @return Users user
     */
    @GetMapping("/user/{id}")
    public Users userInfo(@PathVariable("id") Long id) {
        Optional<Users> optionalUsers = usersService.findById(id);

        Users user = new Users();
        if(optionalUsers.isPresent()) {
            user = optionalUsers.get();
        }

        return user;
    }
}
