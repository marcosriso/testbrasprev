package br.com.brasilprev.TesteBrasilPrev.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public abstract class AbstractDeserializer<E> extends JsonDeserializer<E> {

    protected abstract E deserialize(final JsonNode jsonNode) throws IOException;

    @Override
    public E deserialize(final JsonParser jsonParser, final DeserializationContext deserializationContext) throws IOException {

        final ObjectCodec objectCoded = jsonParser.getCodec();
        final JsonNode jsonNode = objectCoded.readTree(jsonParser);

        return this.deserialize(jsonNode);
    }

}
