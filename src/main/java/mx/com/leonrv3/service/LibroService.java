package mx.com.leonrv3.service;

import java.util.List;
import mx.com.leonrv3.dao.LibroDao;
import mx.com.leonrv3.domain.Libro;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LibroService implements ILibroService {

    @Autowired
    private LibroDao libroDao;

    @Override
    @Transactional(readOnly = true)
    public List<Libro> listarLibros() {
        return (List<Libro>) libroDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Libro libro) {
        libroDao.save(libro);
    }

    @Override
    @Transactional
    public void eliminar(Libro libro) {
        libroDao.delete(libro);
    }

    @Override
    @Transactional(readOnly = true)
    public Libro encontrarLibro(Libro libro) {
        return libroDao.findById(libro.getId()).orElse(null);
        // return null;
    }

}
