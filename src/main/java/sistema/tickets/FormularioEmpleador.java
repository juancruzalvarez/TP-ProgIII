package sistema.tickets;

public class FormularioEmpleador extends Formulario {
	private double pesoLocacion;
    private double pesoRemuneracion;
    private double pesoCargaHoraria;
    private double pesoPuestoLaboral;
    private double pesoRangoEtario;  
    private double pesoExpPrevia;
    private double pesoEstudios;
    
	public FormularioEmpleador(String locacion,double pesoLocacion, String remuneracion,double pesoRemuneracion, String cargaHoraria,double pesoCargaHoraria, String puestoLaboral,
			double pesoPuestoLaboral,String rangoEtario,double pesoRangoEtario, String expPrevia, double pesoExpPrevia, String estudios,double pesoEstudios) {
		super(locacion, remuneracion, cargaHoraria, puestoLaboral, rangoEtario, expPrevia, estudios);
		this.pesoLocacion=pesoLocacion;
		this.pesoRemuneracion=pesoRemuneracion;
		this.pesoCargaHoraria=pesoCargaHoraria;
		this.pesoPuestoLaboral=pesoPuestoLaboral;
		this.pesoRangoEtario=pesoRangoEtario;
		this.pesoExpPrevia=pesoExpPrevia;
		this.pesoEstudios=pesoEstudios;
		
	}

	public double getPesoLocacion() {
		return pesoLocacion;
	}

	public double getPesoRemuneracion() {
		return pesoRemuneracion;
	}

	public double getPesoCargaHoraria() {
		return pesoCargaHoraria;
	}

	public double getPesoPuestoLaboral() {
		return pesoPuestoLaboral;
	}

	public double getPesoRangoEtario() {
		return pesoRangoEtario;
	}

	public double getPesoExpPrevia() {
		return pesoExpPrevia;
	}

	public double getPesoEstudios() {
		return pesoEstudios;
	}
	

}
