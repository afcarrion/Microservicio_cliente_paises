package controller;

import model.Pais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import service.PaiseService;

import java.util.List;

@RestController
public class PaisController {
    @Autowired
    PaiseService servicePais;

    @GetMapping(value = "/paises", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Pais> buscarTodosPaises(){
        return servicePais.obtenerPaises();
    }

    @GetMapping(value = "/paises/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Pais> buscarPaisPorNombre(@PathVariable("name") String nombre){
        return servicePais.buscarPaises(nombre);
    }
}
