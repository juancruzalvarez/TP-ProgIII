package sistema.tickets;

import java.io.Serializable;
import java.util.*;

public class Formulario implements Serializable {

	public static final List<String> locaciones = List.of("Home Office", "Indistinto", "Presencial");
	public static final List<String> puestos = List.of("Junior", "Senior", "Management");

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


    public String getLocacion() {
		return locacion;
	}


	public String getRemuneracion() {
		return remuneracion;
	}


	public String getCargaHoraria() {
		return cargaHoraria;
	}


	public String getPuestoLaboral() {
		return puestoLaboral;
	}


	public String getRangoEtario() {
		return rangoEtario;
	}


	public String getExpPrevia() {
		return expPrevia;
	}


	public String getEstudios() {
		return estudios;
	}


	public String getPuesto() {
    	return this.puestoLaboral;
    }


	@Override
	public String toString() {
		return " [locacion:" + locacion + ", remuneracion:" + remuneracion + ", cargaHoraria:" + cargaHoraria
				+ ", puestoLaboral:" + puestoLaboral + ", rangoEtario:" + rangoEtario + ", expPrevia:" + expPrevia
				+ ", estudios:" + estudios + "]";
	}
	


}
