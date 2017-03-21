package Banco;
// Completa las declaraciones siguientes
public abstract class Cuenta {
    // Número máximo de titulares que puede tener la cuenta
    public static final int TITULARES = 4; 
    protected static int contador=1;//para número de cuenta
    private int numero;
    private float saldo; // En euros
    private Cliente [] clientes; // Lista de titulares de la cuenta
    protected int titulares;  // y número total de los mismos

//metodos de Cuenta:
    
    public Cuenta(){
    	this.numero=this.contador;
    	this.contador++;
    	this.clientes = new Cliente[TITULARES];
    	this.saldo=0;
    }

    public int getContador(){
    	return this.contador;
    }
    public int getTitulares(){
    	return this.titulares;
    }
    public void setContador(int contador){
    	this.contador=contador;
    	return;
    }
    public void setTitulares(int titulares){
    	this.titulares=titulares;
    	return;
    }
    public void setCliente(int i, Cliente cli){
    	this.clientes[i]=cli;
    	return;
    }
    public Cliente getCliente(int i){
    	return this.clientes[i];
    }
    public int getNumero(){
    	return this.numero;
    }
    public float getSaldo(){ //ver el saldo de una cuenta
    	return saldo;
    }
    public void setSaldo(float saldo){
    	this.saldo=saldo;
    	return;
    }
    public String getTCliente(int i){//Clientes de un
    	return this.clientes[i].nombre+" "+this.clientes[i].apellidos;
    }

    public abstract String getCuenta(); //devuelve el tipo y el número de cuenta

    public abstract void ingresar(float importe); //el importe es en euros

    public abstract float sacar(float importe); //el importe es en euros

 	public void agregarCliente(Cliente cliente) {//añadir el cliente
		
		if(this.titulares>3){//Si hay un solo titular no lo borra
			System.out.println("No se puede añadir otro titular. Alcanzado el máximo");
		} else{
			for (int i=0; i<this.titulares; i++){
				if (this.clientes[i]==cliente){//no agregar un cliente que ya esté asignado a la cuenta
					System.out.println("Ese cliente ya está en la cuenta");
					return;
				}
			}
			setCliente(this.titulares,cliente);//agrega el nuevo cliente
			this.titulares++;//suma uno más
		}
		return;
 	}

   	public void eliminarCliente(Cliente cliente) {//borrar el cliente
		
		boolean t=true;
		if(this.titulares<2){//no borrar si hay un solo cliente;
			System.out.println("No se puede borrar el titular. No hay titulares o solo hay uno");
		} else{
			for (int i=0;i<this.titulares;i++){//busca el cliente
				if (this.clientes[i]==cliente){//si lo encuentra se borra
					for (int j=i;j<this.titulares-1;j++){//se mueven hacia arriba los que haya debajo
						this.clientes[j]=this.clientes[j+1];
					}
					this.clientes[titulares-1]=null;//el último se anula
					this.titulares--;//se descuenta 1
					t=false;
					break;
				}
			}
			if(t){//para cuando el cliente no estaba
				System.out.println("El titular no figuraba en esta cuenta");
			}	
		}
		return;
	}

    public abstract float liquidacionMensual(); // se lanza una vez al mes

    public abstract String imprimirCuentas(); // opción para preparar/ver el contenido de las cuentas del banco para sacarlo por pantalla

}