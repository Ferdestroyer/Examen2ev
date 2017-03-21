package Banco;
/**
 * @author usuario
 *
 */
public class CuentaCorriente extends Cuenta {
	private static float interes=0.0012f; //En porcentaje
    private static float comision=0.6f; // En euros
    private int puntos;
    
	/**
	 * 
	 */
	public CuentaCorriente() {
		super();
		this.puntos=0;
	}

	public CuentaCorriente(Cliente cliente){
		super();
		super.setCliente(0, cliente);
		this.titulares=1;
		this.puntos=0;
	}
	
	/* (non-Javadoc)
	 * @see Cuenta#getCuenta()
	 */	
	@Override
	public String getCuenta(){
		return "Cuenta Corriente "+super.getNumero();
	}
	
	/* (non-Javadoc)
	 * @see Cuenta#ingresar(float)
	 */
	@Override
	public void ingresar(float importe) {

		int paraPuntos;
		super.setSaldo(super.getSaldo()+importe);
		paraPuntos = (int) importe/6;
		this.puntos=this.puntos+paraPuntos;
		return;
	}
	
	/* (non-Javadoc)
	 * @see Cuenta#sacar(float)
	 */
	@Override
	public float sacar(float importe) {

		if(super.getSaldo()-importe<0){
			importe=super.getSaldo();
			System.out.println("No hay importe suficiente. Solo sacará "+importe);
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

		return "Número de cuenta "+super.getNumero()+", Titular 0 "+super.getTCliente(0)+", Cuenta Corriente - saldo: "+super.getSaldo()+", Puntos "+this.puntos;
	}
}