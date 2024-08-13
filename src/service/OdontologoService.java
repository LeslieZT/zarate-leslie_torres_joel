package service;

import dao.IDao;
import model.Odontologo;

import java.util.List;

public class OdontologoService {
    private IDao<Odontologo> odontologoIDao;

    public OdontologoService(IDao<Odontologo> ondontologoIDao) {
        this.odontologoIDao = ondontologoIDao;
    }

    public Odontologo guardar ( Odontologo odontologo) {
        return  odontologoIDao.guardar(odontologo);
    }

    public List<Odontologo> listar () {
        return  odontologoIDao.listarTodos();
    }

}
