package br.com.brasilprev.TesteBrasilPrev.deserializers;

import br.com.brasilprev.TesteBrasilPrev.domain.Users;
import com.fasterxml.jackson.databind.JsonNode;

public class UserDeserializer extends AbstractDeserializer<Users> {
    @Override
    public Users deserialize(final JsonNode node) {
        final String username = node.get("username").asText();
        final String password = node.get("password").asText();

        return new Users(username, password);
    }
}
