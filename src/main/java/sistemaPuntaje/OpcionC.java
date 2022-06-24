package sistemaPuntaje;

public class OpcionC implements Iopcion{

	@Override
	public double PuntajeOp(Iopcion o) {
		// TODO Auto-generated method stub
		return o.PuntajeC();
	}

	@Override
	public double PuntajeA() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public double PuntajeB() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public double PuntajeC() {
		// TODO Auto-generated method stub
		return 3;
	}

}
