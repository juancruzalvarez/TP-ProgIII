package systema.tickets;

public class Formulario {

    // IMPORTANTE
    // hay que encontrar una manera de verificar que valores puede tomar cada cosa.

    private String locacion;
    private String remuneracion;
    private String cargaHoraria;
    private String puestoLaboral;
    private String rangoEtario;  //String?
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


}
