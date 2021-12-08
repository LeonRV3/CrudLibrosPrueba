package mx.com.leonrv3.dao;


import mx.com.leonrv3.domain.Libro;
import org.springframework.data.repository.CrudRepository;

public interface LibroDao extends CrudRepository<Libro, Integer> {
} 