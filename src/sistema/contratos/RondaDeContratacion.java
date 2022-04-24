package sistema.contratos;

import sistema.tickets.Ticket;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RondaDeContratacion {


    private List<Contrato> contratos;

    public RondaDeContratacion(List<Eleccion> eleccionesMutuas){
        contratos = new ArrayList<Contrato>();
        generarContratos(eleccionesMutuas);
    }

    private void generarContratos(List<Eleccion> eleccionesMutuas){
        eleccionesMutuas.forEach(e -> contratos.add(new Contrato(e.getElector(), e.getElegido()))); //ver cual es el empleado y cual el empleador
    }

    public List<Contrato> getContratos(){
        return contratos;
    }
}
