package mx.com.leonrv3.service;

import java.util.List;
import mx.com.leonrv3.domain.Libro;


public interface ILibroService {
    public List<Libro> listarLibros();

    public void guardar(Libro libro);

    public void eliminar(Libro libro);

    public Libro encontrarLibro(Libro libro);
}
