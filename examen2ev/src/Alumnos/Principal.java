package Alumnos;

import java.util.*;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Menu
		 * 			1 matricular alumno
		 * 			2 poner notas
		 * 			3 imprimir notas (incluye la media)
		 *                
		 */
		final int NUMALU=3;//alumnos a crear
		final int NUMASI=6;//asignaturas a crear
		Alumno[] lista=new Alumno[NUMALU];//alumnos
		Asignatura[] materias=new Asignatura[NUMASI];//asignaturas
		materias[0]=new Asignatura("Bases de datos", '1', 6);
		materias[1]=new Asignatura("Programación", '1', 8);
		materias[2]=new Asignatura("Entornos de Desarrollo", '1', 3);
		materias[3]=new Asignatura("Lenguajes de marcas", '1', 3);
		materias[4]=new Asignatura("Sistemas", '1', 6);
		materias[5]=new Asignatura("Desarrollo entorno servidor", '1', 9);
		lista[0]=new Alumno("Jorgito", 18);
		lista[1]=new Alumno("Juanito", 18);
		lista[2]=new Alumno("Jaimito", 18);
		int alu;//posición de alumno en vector de alumnos
		int asi;//posición de materia en vector de asignaturas
		float nota;//nota a leer

		int opcion=0;//opción de menú
		do {//menú
			System.out.println("1.- Asignar asignaturas a alumno");
			System.out.println("2.- Asignar calificación a asinatura de alumno");
			System.out.println("3.- Imprimir todos los boletines");
			System.out.println("4.- Ver asignaturas de un alumno");
			System.out.println("0.- Salir");
			opcion=Leer.pedirEnteroValidar("Elije opción");
			switch (opcion) {//acciones de menú
			case 1://matricular
				verAlumnos(NUMALU,lista);
				System.out.println("---------------");
				do{//escoge alumno de la lista
					alu=Leer.pedirEnteroValidar("Escoge el alumno");
				} while(alu<0 || alu>=NUMALU);
				verAsignaturas(NUMASI, materias);
				System.out.println("---------------");
				do{//escoge asignatura
					asi=Leer.pedirEnteroValidar("Escoge la asignatura");
				} while(asi<0 || asi>=NUMASI);
				lista[alu].matricular(materias[asi]);//intenta matricular
				System.out.println("---------------");
				break;
			case 2://poner nota
				verAlumnos(NUMALU,lista);
				System.out.println("---------------");
				do{//escoge alumnos de la lista
					alu=Leer.pedirEnteroValidar("Escoge el alumno");
				} while(alu<0 || alu>=NUMALU);
				if(lista[alu].getNumAsignaturas()==0){
					System.out.println("El alumno "+lista[alu].getNombre()+" no está matriculado");
				} else{
					lista[alu].verMatricula();
					System.out.println("---------------");
					do{//escoge materia de las que está matriculado
						asi=Leer.pedirEnteroValidar("Escoge la asignatura");
					} while(asi<0 || asi>=lista[alu].getNumAsignaturas());
					do{//pone la nota
						nota=Leer.pedirFloat("Introduce la nota");
					} while(nota<0 || nota>10);
					lista[alu].setNotas(asi, nota);//asigna la nota
				}
				break;
			case 3://imprime boletines
				for(int i=0; i<NUMALU; i++){
					System.out.println(lista[i].getAlumno());
					lista[i].verNotas();
					System.out.println("Media: "+lista[i].media()+" "+lista[i].notaTexto(lista[i].media()));
					System.out.println("---------------");
				}
				break;
			case 4://imprime matrícula de un alumno
				verAlumnos(NUMALU,lista);
				do{
					alu=Leer.pedirEnteroValidar("Escoge el alumno");
				} while(alu<0 || alu>=NUMALU);
				lista[alu].verMatricula();
				System.out.println("---------------");
				break;
			}

		} while(opcion!=0);
	}

	public static void verAsignaturas(int NUMASI, Asignatura[] materias){//lista de materias
		for (int i=0; i<NUMASI; i++){
			System.out.print(i+" "+materias[i].getNombre()+" / ");
			if ((i+1)%5==0){
				System.out.println();
			}
		}
		System.out.println();
	}

	public static void verAlumnos(int NUMALU, Alumno[] lista){//lista de alumnos
		for (int i=0; i<NUMALU; i++){
	System.out.print(i+" "+lista[i].getNombre()+" / ");
			if ((i+1)%5==0){
				System.out.println();
			}
		}
		System.out.println();
	}

}
