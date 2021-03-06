package com.example.crudspringbootweb.serviceImpl;

import com.example.crudspringbootweb.entity.Etiquetas;
import com.example.crudspringbootweb.repository.Restaurante.EtiquetasRepository;
import com.example.crudspringbootweb.service.EtiquetasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class EtiquetasServiceImpl implements EtiquetasService {
    @Autowired
    EtiquetasRepository etiquetasRepository;

    @Override
    public List<Etiquetas> findAllEtiquetas() {
        return etiquetasRepository.findAll();
    }

    @Override
    public Optional<Etiquetas> findEtiquetaById(BigInteger id) {
        return etiquetasRepository.findById(id);
    }

    @Override
    public Etiquetas saveEtiqueta(Etiquetas etiquetasNew) {
        if (etiquetasNew != null) {
            return etiquetasRepository.save(etiquetasNew);
        }
        return new Etiquetas();
    }

    @Override
    public void deleteEtiqueta(BigInteger id) {
        if (etiquetasRepository.findById(id).isPresent()) {
            etiquetasRepository.deleteById(id);
        }
    }

    @Override
    public void updateEtiqueta(Etiquetas etiquetas) {
        BigInteger id = etiquetas.getId_etiqueta();
        if (etiquetasRepository.findById(id).isPresent()) {
            Etiquetas etiquetasUpdate = new Etiquetas();
            etiquetasUpdate.setId_etiqueta(etiquetas.getId_etiqueta());
            etiquetasUpdate.setNombre(etiquetas.getNombre());
            etiquetasRepository.save(etiquetasUpdate);
        }
    }

    @Override
    public List<Etiquetas> findEtiquetaByName(String name) {
        return etiquetasRepository.findEtiquetasByNombre(name);
    }
}
