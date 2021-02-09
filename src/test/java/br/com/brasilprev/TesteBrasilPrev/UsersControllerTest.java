package br.com.brasilprev.TesteBrasilPrev;

import br.com.brasilprev.TesteBrasilPrev.domain.Clients;
import br.com.brasilprev.TesteBrasilPrev.domain.Users;
import br.com.brasilprev.TesteBrasilPrev.repositories.ClientsRepository;
import br.com.brasilprev.TesteBrasilPrev.repositories.UsersRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@ExtendWith(MockitoExtension.class)
public class UsersControllerTest {

    @Mock
    private UsersRepository usersRepository;

    @Test
    @DisplayName("ServiceHaveNoErrors")
    void ServiceHaveNoErrors() {
        assertNotNull(usersRepository);
    }

    @Test
    @DisplayName("Should Insert a User Successfully")
    void shouldInsertaClientSuccessfully() {
        Users user = new Users("mmarras", "123");
        Mockito.when(usersRepository.save(user)).thenReturn(user);
        assertTrue(user == usersRepository.save(user));
    }


}
