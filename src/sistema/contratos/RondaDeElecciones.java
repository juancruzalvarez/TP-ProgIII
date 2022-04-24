package sistema.contratos;

import sistema.tickets.Ticket;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RondaDeElecciones {


    private List<Eleccion> elecciones;  //guarda las elecciones
    private List<Eleccion> eleccionesMutuas;    //guarda las elecciones donde coinciden ambas partes
    public RondaDeElecciones(){
        elecciones = new ArrayList<>();
        eleccionesMutuas = new ArrayList<>();
    }

    public void agregarEleccion(Ticket elector, Ticket elegido){
        Eleccion aux;
        boolean encontrado = false;
        for(Iterator<Eleccion> it = elecciones.iterator(); it.hasNext() && !encontrado;){
            aux = it.next();
            if(aux.getElector() == elegido && aux.getElegido() == elector){
                encontrado = true;
                it.remove();
            }
        }
        //si encuentra una eleccion igual a la que se esta agregando agregar a elecciones nuevas, sino a elecciones.
        List<Eleccion> aAgregar = encontrado ? eleccionesMutuas : elecciones;
        aAgregar.add(new Eleccion(elector, elegido));
    }

    public List<Eleccion> getEleccionesMutuas(){
        return eleccionesMutuas;
    }
}
