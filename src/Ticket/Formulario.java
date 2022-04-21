package Ticket;

public class Formulario {
private String locacion;
private String remuneracion;
private String cargahoraria;
private String puestolaboral;
private String rangoetario;  //String?
private String Expprevia;
private String Estudios;

public Formulario(String locacion, String remuneracion, String cargahoraria, String puestolaboral, String rangoetario,
		String expprevia, String estudios) {
	super();
	this.locacion = locacion;
	this.remuneracion = remuneracion;
	this.cargahoraria = cargahoraria;
	this.puestolaboral = puestolaboral;
	this.rangoetario = rangoetario;
	Expprevia = expprevia;
	Estudios = estudios;
}

public String getLocacion() {
	return locacion;
}

public String getRemuneracion() {
	return remuneracion;
}

public String getCargahoraria() {
	return cargahoraria;
}

public String getPuestolaboral() {
	return puestolaboral;
}

public String getRangoetario() {
	return rangoetario;
}

public String getExpprevia() {
	return Expprevia;
}

public String getEstudios() {
	return Estudios;
}



}
