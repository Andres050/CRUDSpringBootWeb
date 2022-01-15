package com.example.crudspringbootweb.repository.Restaurante;

import com.example.crudspringbootweb.entity.Etiquetas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.List;

public interface EtiquetasRepository extends JpaRepository<Etiquetas, BigInteger> {
    @Query(value = "SELECT * FROM etiquetas WHERE nombre = ?1",nativeQuery = true)
    List<Etiquetas> findEtiquetasByNombre(String nombre);
}
