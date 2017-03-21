package Banco;
import java.io.*;
import java.util.*;

public class Banco {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Leer fichero de pruebas y nadadores vector de pruebas y nadadores
		//Menu
		/* 			1 crear Cuenta
		 * 			2 asignar Cliente
		 *          3 quitar Cliente
		 * 			4 ingresar dinero
		 * 			5 sacar dinero
		 * 			6 liquidar intereses
		 * 			7 imprimir cuentas
		 * 			8 ver cuenta
		 *                
		 */
		final int NUMCLI=10;//clientes a crear
		final int NUMCUE=6;//cuentas a crear
		Cliente[] lista=new Cliente[NUMCLI];
		Cuenta[] cuentas=new Cuenta[NUMCUE];
		lista[0]=new Cliente("Jorgito","Donald");
		lista[1]=new Cliente("Juanito","Donald");
		lista[2]=new Cliente("Jaimito","Donald");
		lista[3]=new Cliente("Daisy","Donald");
		lista[4]=new Cliente("Alejandra","Donald");
		lista[5]=new Cliente("Laura","Donald");
		lista[6]=new Cliente("Antonio","Cebollo");
		lista[7]=new Cliente("Alejandro","Molesto");
		lista[8]=new Cliente("Jose","Altivo");
		lista[9]=new Cliente("Alberto","Pasota");
		int ncuenta=0;//contador de cuentas
		int cue;//número de cuenta
		int cli;//número de cliente
		int tcue;//tipo de cuenta
		int opcion=0;//opción de menú
		float importe;//impoete a sacar ingresar
		do {//menú
			System.out.println("1.- Crear cuenta");
			if (ncuenta>0){
				System.out.println("2.- Asignar cliente a cuenta");
				System.out.println("3.- Quitar cliente de cuenta");
				System.out.println("4.- Ingresar dinero");
				System.out.println("5.- Sacar dinero");
				System.out.println("6.- Liquidar intereses");
				System.out.println("7.- Imprimir cuentas");
				System.out.println("8.- Ver cuenta");
			}
			System.out.println("0.- Salir");
			opcion=Leer.pedirEnteroValidar("Elije opción");
			switch (opcion) {//acciones de menú
			case 1://

				if (ncuenta>5){
					System.out.println(" Alcanzado el número máximo de cuentas ");
				}else {
					cli=verClientes(NUMCLI,lista);
					do{//escoge tipo de cuenta
						tcue=Leer.pedirEnteroValidar("Escoge cuenta: 1.- Cuenta Corriente / 2.- Fondo de Inversión / 3.- Cuenta Vivienda");
					} while(tcue<0 || tcue>3);
					switch (tcue){
					case 1:
						cuentas[ncuenta]=new CuentaCorriente(lista[cli]);
						ncuenta++;
						break;
					case 2:
						cuentas[ncuenta]=new FondoInversion(lista[cli]);
						ncuenta++;
						break;
					case 3:
						cuentas[ncuenta]=new CuentaVivienda(lista[cli]);
						ncuenta++;
						break;
					}
					System.out.println("---------------");
				}
				break;
			case 2://añadir cliente

				cue=verCuentas(ncuenta, cuentas);
				cli=verClientes(NUMCLI,lista);
				cuentas[cue].agregarCliente(lista[cli]);
				break;
			case 3://Eliminar cliente

				cue=verCuentas(ncuenta, cuentas);
				cli=verClientes(NUMCLI,lista);
				cuentas[cue].eliminarCliente(lista[cli]);
				break;
			case 4://Ingresar dinero

				cue=verCuentas(ncuenta, cuentas);
				do{
					importe=Leer.pedirFloat("Introduce el importe en euros a ingresar");
				} while(importe<0);
				if (importe>0){
					cuentas[cue].ingresar(importe);
				}
				break;
			case 5://Sacar dinero

				cue=verCuentas(ncuenta, cuentas);
				do{
					importe=Leer.pedirFloat("Introduce el importe en euros a sacar");
				} while(importe<0);
				if (importe>0){
					cuentas[cue].sacar(importe);
				}
				break;
			case 6: //Liquidar intereses
				
				for (int i=0;i<Cuenta.contador-1;i++){
					cuentas[i].liquidacionMensual();
				}
				System.out.println("Liquidación realizada");
				break;
			case 7://Imprimir cuentas
				
				for (int i=0;i<Cuenta.contador-1;i++){
					System.out.println(cuentas[i].imprimirCuentas());
				}
				break;
			case 8://Mostrar una cuenta

				cue=verCuentas(ncuenta, cuentas);
				System.out.println(cuentas[cue].imprimirCuentas());
				for (int i=1; i<cuentas[cue].getTitulares();i++){
					System.out.println("titular "+i+" "+cuentas[cue].getTCliente(i) );
				}
				break;
			}

		} while(opcion!=0);
	}

	public static int verClientes(int ncli, Cliente[] lista){//lista de clientes
		int cli;
		for (int i=0; i<ncli; i++){
			System.out.print(i+" "+lista[i].getCliente()+" / ");
			if ((i+1)%5==0){
				System.out.println();
			}
		}
		System.out.println("---------------");
		do{//escoge cliente de la lista
			cli=Leer.pedirEnteroValidar("Escoge el cliente");
		} while(cli<0 || cli>=ncli);
		return cli;
	}

	public static int verCuentas(int ncuenta, Cuenta[] cuentas){//lista de cuentas
		int cue;
		for (int i=0; i<ncuenta; i++){
			System.out.println(i+" "+cuentas[i].getCuenta()+" / ");
			if ((i+1)%5==0){
				System.out.println();
			}
		}
		System.out.println("---------------");
		do{//escoge cuenta de la lista
			cue=Leer.pedirEnteroValidar("Escoge la cuenta");
		} while(cue<0 || cue>=ncuenta);
		return cue;
	}
}