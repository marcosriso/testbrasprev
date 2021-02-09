package br.com.brasilprev.TesteBrasilPrev;

import br.com.brasilprev.TesteBrasilPrev.domain.Clients;
import br.com.brasilprev.TesteBrasilPrev.repositories.ClientsRepository;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@ExtendWith(MockitoExtension.class)
public class ClientControllerTest {

    @Mock
    private ClientsRepository clientsRepository;

    @Test
    @DisplayName("ServiceHaveNoErrors")
    void ServiceHaveNoErrors() {
        assertNotNull(clientsRepository);
    }

    @Test
    @DisplayName("Should Insert a Client Successfully")
    void shouldInsertaClientSuccessfully() {
        Clients client = new Clients("Marcos Marras", "123", "Rua Teste");
        Mockito.when(clientsRepository.save(client)).thenReturn(client);
        assertTrue(client == clientsRepository.save(client));
    }


}
