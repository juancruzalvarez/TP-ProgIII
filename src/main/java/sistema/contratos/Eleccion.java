package sistema.contratos;

import sistema.tickets.Ticket;

import java.io.Serializable;

public class Eleccion implements Serializable {
    private Ticket elector, elegido;
    
    public Eleccion(Ticket elector, Ticket elegido){
        this.elector = elector;
        this.elegido = elegido;
    }

    public Ticket getElector() {
        return elector;
    }

    public Ticket getElegido() {
        return elegido;
    }
}