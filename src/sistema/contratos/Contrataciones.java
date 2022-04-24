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

    public void iniciarRondaDeElecciones(){
        rondaDeElecciones = new RondaDeElecciones();
    }

    public void realizarRondaDeContratacion(){
        rondaDeContratacion = new RondaDeContratacion(rondaDeElecciones.getEleccionesMutuas());
    }

    public void realizarEleccion(Ticket elector, Ticket elegido){
        rondaDeElecciones.agregarEleccion(elector, elegido);
    }

    public List<Contrato> getContratos(){
        return rondaDeContratacion.getContratos();
    }

}
