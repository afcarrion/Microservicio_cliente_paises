package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import model.Pais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaisServiceImpl implements PaiseService{

    String url = "https://restcountries.com/v3.1/all";

    @Autowired
    RestTemplate template;

    @Override
    public List<Pais> obtenerPaises() {
        String resultado = template.getForObject(url, String.class);
        ObjectMapper maper = new ObjectMapper();
        List<Pais> paises = new ArrayList<>();
        ArrayNode array;

        try {
            array = (ArrayNode) maper.readTree(resultado);
            for(Object ob:array){
                ObjectNode json = (ObjectNode) ob;
                if(json.get("capital")==null){
                    System.out.println("No se encontro capital para este pais");
                }else{
                    paises.add(new Pais(json.get("name").get("common").asText(),
                            json.get("capital").get(0).asText(),
                            json.get("population").asInt(),
                            json.get("flag").asText()));
                }
                System.out.println(json.get("name").get("common").asText());
            }
        }catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return paises;
    }

    @Override
    public List<Pais> buscarPaises(String nombre) {
        return obtenerPaises()
                .stream()
                .filter(p -> p.getNombre().contains(nombre))
                .collect(Collectors.toList());
    }
}
