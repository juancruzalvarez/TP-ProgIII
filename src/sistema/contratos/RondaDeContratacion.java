package sistema.contratos;

import sistema.tickets.Ticket;
import sistema.usuarios.TipoUsuario;

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
        eleccionesMutuas.forEach(e -> {
            contratos.add(e.getElector().getContrato(e));
        });
    }

    public List<Contrato> getContratos(){
        return contratos;
    }
}
