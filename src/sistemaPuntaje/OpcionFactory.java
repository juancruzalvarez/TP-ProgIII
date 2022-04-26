package sistemaPuntaje;

public class OpcionFactory {

	public static Iopcion getLocacion(String locacion) {
    	Iopcion rta=null;
    	switch(locacion) {
    	case "Home Office"-> {rta= new OpcionA();}
    	case "Presencial" -> {rta= new OpcionB();}
    	case "Indistinto"->{rta= new OpcionC();}
    	}

    	return rta;
        
    }

    public static Iopcion getRemuneracion(String remuneracion) {
    	Iopcion rta=null;
    	switch(remuneracion) {
    	case "hasta V1"-> {rta= new OpcionA();}
    	case "entre V1 y V2" -> {rta= new OpcionB();}
    	case "mas de V2"->{rta= new OpcionC();}
    	}

    	return rta;
    }

    public static Iopcion getCargaHoraria(String cargaHoraria) {
    	Iopcion rta=null;
    	switch(cargaHoraria) {
    	case "media"-> {rta= new OpcionA();}
    	case "completa" -> {rta= new OpcionB();}
    	case "extendida"->{rta= new OpcionC();}
    	}

    	return rta;
    }

    public static Iopcion getPuestoLaboral(String puestoLaboral) {
    	Iopcion rta=null;
    	switch(puestoLaboral) {
    	case "junior"-> {rta= new OpcionA();}
    	case "senior" -> {rta= new OpcionB();}
    	case "managment"->{rta= new OpcionC();}
    	}
    	return rta;
    }

    public static Iopcion getRangoEtario(String rangoEtario) {
    	Iopcion rta=null;
    	switch(rangoEtario) {
    	case "menos de 40"-> {rta= new OpcionA();}
    	case "40 a 50" -> {rta= new OpcionB();}
    	case "mas de 50"->{rta= new OpcionC();}
    	}
    	return rta;
    }

    public static Iopcion getExpPrevia(String expPrevia) {
    	Iopcion rta=null;
    	switch(expPrevia) {
    	case "nada"-> {rta= new OpcionA();}
    	case "media" -> {rta= new OpcionB();}
    	case "mucha"->{rta= new OpcionC();}
    	}
    	return rta;
    }

    public static Iopcion getEstudios(String estudios) {
    	Iopcion rta=null;
    	switch(estudios) {
    	case "primario"-> {rta= new OpcionA();}
    	case "secundario" -> {rta= new OpcionB();}
    	case "terciario"->{rta= new OpcionC();}
    	}

    	return rta;
    }

}
