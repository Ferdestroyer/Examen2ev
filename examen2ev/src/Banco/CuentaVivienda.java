package Banco;
/**
 * @author yo
 *
 */
public class CuentaVivienda extends Cuenta {
	private static float interes=0.0024f; //En porcentaje
    private static float comision=0.0f; // En euros

	/**
	 * 
	 */
	public CuentaVivienda() {
		super();
	}

	public CuentaVivienda(Cliente cliente) {
		super();
		super.setCliente(0, cliente);
		this.titulares=1;
	}
	
	/* (non-Javadoc)
	 * @see Cuenta#getCuenta()
	 */
	@Override
	public String getCuenta() {
	
		return "Cuenta Vivienda "+super.getNumero();
	}

	/* (non-Javadoc)
	 * @see Cuenta#ingresar(float)
	 */
	@Override
	public void ingresar(float importe) {

		super.setSaldo(super.getSaldo()+importe);
	}

	/* (non-Javadoc)
	 * @see Cuenta#sacar(float)
	 */
	@Override
	public float sacar(float importe) {
		
		System.out.println("De esta cuenta no se puede sacar dinero");
		return 0;
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

		return "Número de cuenta "+super.getNumero()+", Titular 0 "+super.getTCliente(0)+", Cuenta Vivienda - saldo: "+super.getSaldo();
	}
}