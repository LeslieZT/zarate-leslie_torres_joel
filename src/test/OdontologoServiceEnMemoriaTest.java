package test;

import dao.impl.DaoEnMemoria;
import model.Odontologo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.OdontologoService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OdontologoServiceEnMemoriaTest {

    private static OdontologoService odontologoService = new OdontologoService(new DaoEnMemoria());

    @Test
    @DisplayName("Testear que se listen todos los odontologos en Memoria")
    void listar() {
        // DADO
        Odontologo odontologo1 = new Odontologo("ODO-0010", "Marta", "Perez");
        Odontologo odontologoDesdeDB1 = odontologoService.guardar(odontologo1);

        Odontologo odontologo2 = new Odontologo("ODO-0011", "Mario", "Torres");
        Odontologo odontologoDesdeDB2 = odontologoService.guardar(odontologo2);

        // CUANDO
        List<Odontologo> odontologos  = odontologoService.listar();
        // ENTONCES
        assertNotNull(odontologos);
    }

}
