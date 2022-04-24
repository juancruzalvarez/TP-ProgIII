package sistema.tickets;
import sistemaPuntaje.Iopcion;
import sistemaPuntaje.OpcionA;
import sistemaPuntaje.OpcionB;
import sistemaPuntaje.OpcionC;

public class Formulario {

    // IMPORTANTE
    // hay que encontrar una manera de verificar que valores puede tomar cada cosa.

    private String locacion;
    private String remuneracion;
    private String cargaHoraria;
    private String puestoLaboral;
    private String rangoEtario;  
    private String expPrevia;
    private String estudios;

    public Formulario(String locacion, String remuneracion, String cargaHoraria, String puestoLaboral, String rangoEtario,
                      String expPrevia, String estudios) {
        this.locacion = locacion;
        this.remuneracion = remuneracion;
        this.cargaHoraria = cargaHoraria;
        this.puestoLaboral = puestoLaboral;
        this.rangoEtario = rangoEtario;
        this.expPrevia = expPrevia;
        this.estudios = estudios;
    }

    public Iopcion getLocacion() {
    	Iopcion rta=null;
    	switch(this.locacion) {
    	case "Home Office"-> {rta= new OpcionA();}
    	case "Presencial" -> {rta= new OpcionB();}
    	case "Indistinto"->{rta= new OpcionC();}
    	}
    	return rta;
        
    }

    public Iopcion getRemuneracion() {
    	Iopcion rta=null;
    	switch(this.remuneracion) {
    	case "hasta V1"-> {rta= new OpcionA();}
    	case "entre V1 y V2" -> {rta= new OpcionB();}
    	case "m�s de V2"->{rta= new OpcionC();}
    	}
    	return rta;
    }

    public Iopcion getCargaHoraria() {
    	Iopcion rta=null;
    	switch(this.cargaHoraria) {
    	case "media"-> {rta= new OpcionA();}
    	case "completa" -> {rta= new OpcionB();}
    	case "extendida"->{rta= new OpcionC();}
    	}
    	return rta;
    }

    public Iopcion getPuestoLaboral() {
    	Iopcion rta=null;
    	switch(this.puestoLaboral) {
    	case "junior"-> {rta= new OpcionA();}
    	case "senior" -> {rta= new OpcionB();}
    	case "managment"->{rta= new OpcionC();}
    	}
    	return rta;
    }

    public Iopcion getRangoEtario() {
    	Iopcion rta=null;
    	switch(this.rangoEtario) {
    	case "menos de 40"-> {rta= new OpcionA();}
    	case "40 a 50" -> {rta= new OpcionB();}
    	case "m�s de 50"->{rta= new OpcionC();}
    	}
    	return rta;
    }

    public Iopcion getExpPrevia() {
    	Iopcion rta=null;
    	switch(this.expPrevia) {
    	case "nada"-> {rta= new OpcionA();}
    	case "media" -> {rta= new OpcionB();}
    	case "mucha"->{rta= new OpcionC();}
    	}
    	return rta;
    }

    public Iopcion getEstudios() {
    	Iopcion rta=null;
    	switch(this.estudios) {
    	case "primario"-> {rta= new OpcionA();}
    	case "secundario" -> {rta= new OpcionB();}
    	case "terciario"->{rta= new OpcionC();}
    	}
    	return rta;
    }


}
