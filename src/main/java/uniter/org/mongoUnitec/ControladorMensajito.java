package uniter.org.mongoUnitec;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ControladorMensajito {
    @Autowired RepositorioMensajito repoMensa;

    //Aquí van las 5 operaciones básicas con la entidad Mensajito

    //Obtener todos
    @CrossOrigin
    @RequestMapping(value="/mensajito", method=RequestMethod.GET, headers = {"Accept=application/json"})
    public ArrayList<Mensajito> obetenerTodos()throws Exception{
        return (ArrayList<Mensajito>) repoMensa.findAll();
    }

    //Obtener por Id
    @CrossOrigin
    @RequestMapping(value = "/mensajito/{id}", method = RequestMethod.GET, headers = {"Accept = application/json"})
    public Mensajito obtenerPorId(@PathVariable String id) throws Exception{
        return repoMensa.findOne(id);
    }

    //Guardar Mensajito para clientes web y desktop
    @CrossOrigin
    @RequestMapping(value = "/mensajito/{titulo}/{cuerpo}", method = RequestMethod.POST, headers = {"Accept = application/json"})
    public Estatus guardarMensajito(@PathVariable String titulo, @PathVariable String cuerpo) throws Exception{
        repoMensa.save(new Mensajito(titulo, cuerpo));
        Estatus estatus = new Estatus(true);
        return estatus;
    }

    //Guardar Mensajito, forma más pura y efectiva
    @CrossOrigin
    @RequestMapping(value = "/mensajito", method = RequestMethod.POST, headers = {"Accept = application/json"})
    public Estatus guardarMensajitoPuro(@RequestBody String json) throws Exception{
        ObjectMapper maper = new ObjectMapper();
        Mensajito mensa = maper.readValue(json, Mensajito.class);
        repoMensa.save(mensa);
        Estatus es = new Estatus(true);
        return es;
    }

    //Actualizar Mensajito
    @CrossOrigin
    @RequestMapping(value = "/mensajito", method = RequestMethod.PUT, headers = {"Accept = application/json"})
    public Estatus actualizarMensajito(@RequestBody String json) throws Exception{
        ObjectMapper maper = new ObjectMapper();
        Mensajito mensa = maper.readValue(json, Mensajito.class);
        Estatus es = new Estatus(true);
        return es;
    }

    //Eliminar Mensajito
    @CrossOrigin
    @RequestMapping(value = "/mensajito/{id}", method = RequestMethod.DELETE, headers = {"Accept = application/json"})
    public Estatus borrarMensajito(@PathVariable String id) throws Exception{
        repoMensa.delete(id);
        Estatus es = new Estatus(true);
        return es;
    }
}
