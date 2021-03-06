package com.example.crudspringbootweb.repository.Restaurante;

import com.example.crudspringbootweb.entity.Localidad;
import com.example.crudspringbootweb.entity.Useracount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface LocalidadRepository extends JpaRepository<Localidad, BigInteger> {
    @Query(value = "SELECT * FROM localidad WHERE nombre_localidad = ?1",nativeQuery = true)
    List<Localidad> findLocalidadByNombre_localidad(String nombre);
}
