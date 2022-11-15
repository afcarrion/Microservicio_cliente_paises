package service;

import model.Pais;

import java.util.List;

public interface PaiseService {

    List<Pais> obtenerPaises();
    List<Pais> buscarPaises(String nombre);
}
