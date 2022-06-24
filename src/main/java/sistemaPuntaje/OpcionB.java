package sistemaPuntaje;

public class OpcionB implements Iopcion{

	@Override
	public double PuntajeOp(Iopcion o) {
		// TODO Auto-generated method stub
		return o.PuntajeB();
	}

	@Override
	public double PuntajeA() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public double PuntajeB() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public double PuntajeC() {
		// TODO Auto-generated method stub
		return 2;
	}
}
