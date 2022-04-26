package sistema.contratos;

import sistema.tickets.Ticket;

import java.util.List;

public class Contrataciones {
    private RondaDeElecciones rondaDeElecciones;
    private RondaDeContratacion rondaDeContratacion;

    public Contrataciones(){
        rondaDeElecciones = null;
        rondaDeContratacion = null;
    }

    /**
     *  Da comienzo a una nueva ronda de elecciones, eliminando cualquier eleccion previa.
     */
    public void iniciarRondaDeElecciones(){
        rondaDeElecciones = new RondaDeElecciones();
    }

    /**
     *  En base a las elecciones realizadas por los usuarios en la ronda de elecciones, genera una lista de contratos.
     *
     */
    public void realizarRondaDeContratacion(){
        rondaDeContratacion = new RondaDeContratacion(rondaDeElecciones.getEleccionesMutuas());
    }

    /**
     *  Agrega una nueva eleccion a la ronda de elecciones.
     * @param elector Ticket perteneciente al usuario que esta realizando la eleccion
     * @param elegido Ticket elegido.
     */
    public void realizarEleccion(Ticket elector, Ticket elegido){
        rondaDeElecciones.agregarEleccion(elector, elegido);
    }

    /**
     *  Devuelve una lista con los contratos generados en la ronda de contratacion.
     * @return Lista de contratos generada.
     */
    public List<Contrato> getContratos(){
        return rondaDeContratacion.getContratos();
    }

}
