package Banco;
/**
 * @author yo
 *
 */
public class FondoInversion extends Cuenta {
	private static float interes=0.0036f; //En porcentaje
    private static float comision=0.6f; // En euros
    private boolean bloqueada;

	/**
	 * 
	 */
	public FondoInversion() {
		super();
	}

	public FondoInversion(Cliente cliente){
		super();
		super.setCliente(0, cliente);
		this.titulares=1;
		bloqueada=false;
	}
	
	/* (non-Javadoc)
	 * @see Cuenta#getCuenta()
	 */
	@Override
	public String getCuenta() {
		// TODO Auto-generated method stub
		return "Fondo Inversión "+super.getNumero();
	}

	/* (non-Javadoc)
	 * @see Cuenta#ingresar(float)
	 */
	@Override
	public void ingresar(float importe) {

		super.setSaldo(super.getSaldo()+importe);
		bloqueada=false;
		return;
	}

	/* (non-Javadoc)
	 * @see Cuenta#sacar(float)
	 */
	@Override
	public float sacar(float importe) {

		if(super.getSaldo()-importe<-500){
			importe=500+super.getSaldo();
			System.out.println("No hay importe suficiente. Solo sacará "+importe);
			bloqueada=true;
		}
		super.setSaldo(super.getSaldo()-importe);
		return importe;
	}

	/* (non-Javadoc)
	 * @see Cuenta#liquidacionMensual()
	 */
	@Override
	public float liquidacionMensual() {
		
		float interesMes;
		interesMes=super.getSaldo()*(this.interes/12)-this.comision;
		if(interesMes<0){
			sacar(-interesMes);
		}else {
			ingresar(interesMes);
		}
		return interesMes;

	}

	/* (non-Javadoc)
	 * @see Cuenta#imprimirCuentas()
	 */
	@Override
	public String imprimirCuentas() {
		// TODO Auto-generated method stub
		return "Número de cuenta "+super.getNumero()+", Titular 0 "+super.getTCliente(0)+", Fondo Inversión - saldo: "+super.getSaldo()+" , "+bloqueada;
	}
}