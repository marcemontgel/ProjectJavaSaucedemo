package data;

import com.fasterxml.jackson.databind.ObjectMapper;
import modelos.CredencialJson;
import utilities.Logs;

import java.io.File;
import java.io.IOException;

public class JsonReader {
    private static final String credencialesPath = "src/test/resources/data/credenciales.json";

    public static CredencialJson obtenerMapCredenciales() {
        final var ObjectMapper = new ObjectMapper();

        try {
            return ObjectMapper.readValue(new File(credencialesPath), CredencialJson.class);
        } catch (IOException ioException) {
            Logs.error("Error al leer JSON de Credenciales: %s/n",
                    ioException.getLocalizedMessage());
            throw new RuntimeException(ioException.getLocalizedMessage());

        }
    }
}
