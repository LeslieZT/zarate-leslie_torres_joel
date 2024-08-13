package test;
import dao.impl.DaoH2Odontologo;
import model.Odontologo;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.OdontologoService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class OdontologoServiceTest {

    private static final Logger logger = Logger.getLogger(OdontologoServiceTest.class);
    private static OdontologoService  odontologoService = new OdontologoService(new DaoH2Odontologo());

    @BeforeAll
    static void crearTabla(){
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection =  DriverManager.getConnection("jdbc:h2:./odontologos;INIT=RUNSCRIPT FROM 'create.sql'","sa","sa");
        }catch (Exception e){
            logger.error(e.getMessage());
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
    }

    @Test
    @DisplayName("Testear que se listen todos los odontologos")
    void listar() {
        // DADO
        Odontologo odontologo1 = new Odontologo("ODO-0002", "Maria", "Perez");
        Odontologo odontologoDesdeDB1 = odontologoService.guardar(odontologo1);

        Odontologo odontologo2 = new Odontologo("ODO-0003", "Carlos", "Torres");
        Odontologo odontologoDesdeDB2 = odontologoService.guardar(odontologo2);

        // CUANDO
        List<Odontologo> odontologos  = odontologoService.listar();
        // ENTONCES
        assertNotNull(odontologos);


    }
}