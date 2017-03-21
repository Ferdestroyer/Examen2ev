package Alumnos;

public class Alumno {//Atributos
	private String nombre;//nombre del alumno
	private int edad;//edad del alumno
	private Asignatura [] matricula;//vector de las materias en que está matriculado
	private float [] notas;//vector de notas de las materias en que está matriculado
	private int numAsignaturas=0;//número de asignaturas en qué está matriculado el alumno 
	
	public Alumno(){//constructor por defecto
		nombre=" ";
		edad=-1;
		matricula=new Asignatura[10];
		notas=new float[10];
	}
	/**
	 * @param nombre
	 * @param edad
	 */
	public Alumno(String nombre, int edad) {//constructor con parámetros
		this.nombre = nombre;
		this.edad = edad;
		matricula=new Asignatura[10];
		notas=new float[10];
	}
	
	public String getAlumno(){//devuelve el nombre y edad como texto
		return nombre+" edad "+edad;
	}
	public int getNumAsignaturas(){//devuelve el número de asiganturas en que está matriculado el alumno
		return numAsignaturas;
	}
	public String getNombre() {//devuelve el nombre del alumno
		return nombre;
	}
	public void setNombre(String nombre) {//graba el nombre del alumno
		this.nombre = nombre;
	}
	public int getEdad() {//devuelve la edad del alumno
		return edad;
	}
	public void setEdad(int edad) {//graba la edad del alumno
		this.edad = edad;
	}
	public Asignatura[] getMatricula() {//devuelve el vector de materias matriculadas completo
		return matricula;
	}
	public void setMatricula(Asignatura[] matricula) {//graba el vector de materias completo desde parámetro
		this.matricula = matricula;
	}
	public float[] getNotas() {//devuelve el vector de notas completo 
		return notas;
	}
	public void setNotas(float[] notas) {//graba el vector de notas completo desde parámetro
		this.notas = notas;
	}
	public Asignatura getMatricula(int i) {//devuelve la asignatura de la posición i de las maticuladas
		return matricula[i];
	}
	public void setMatricula(Asignatura asignatura, int i) {//graba la asignatura (objeto) en la posición i
		this.matricula[i] = asignatura;
	}
	public float getNotas(int i) {//devuelve la nota de la posición (materia) i
		return notas[i];
	}
	public void setNotas(float notas, int i) {//graba la nota en la posición (materia) i
		this.notas[i] = notas;
	}
	public float getNotas(Asignatura asignatura) {//devuelve la nota de una materia por objeto
		for (int i=0; i<numAsignaturas; i++){
			if(this.matricula[i]==asignatura){
				return notas[i];
			}
		}
		System.out.println("El alumno no está matriculado en "+asignatura.getNombre());//mensaje si no está matriculado
		return -1;
	}
	
	public void setNotas(Asignatura asignatura, float nota) {//grabar nota según asignatura
		for (int i=0; i<numAsignaturas; i++){
			if(this.matricula[i]==asignatura){
				this.notas[i] = nota;
				return;
			}
		}
		System.out.println("El alumno "+nombre+ " no está matriculado en "+asignatura.getNombre());
		return;
	}

	public void setNotas(int asignatura, float nota) {// grabar nota según posición de asignatura
		this.notas[asignatura] = nota;
		return;
	}
	
	public void verMatricula(){//imprime las materias en que está matriculado un alumno
		for (int i=0; i<numAsignaturas; i++){
			System.out.println(i+" "+matricula[i].getNombre());
		}
		return;
	}

	public void verNotas(){//imprime las materias y las notas en que está matriculado un alumno 
		for (int i=0; i<numAsignaturas; i++){
			System.out.println(i+" "+matricula[i].getNombre()+"  :  "+notas[i]);
		}
		return;
	}

	public void matricular(Asignatura asignatura){//añade una materia a la matrícula de un alumno
		if(numAsignaturas>9){//límite de 10 materias 
			System.out.println("El alumno ya está matriculado en 10 asignaturas, no puede matricularse en más");
			return;
		}
		for (int i=0; i<numAsignaturas; i++){//control de no repetir materias en matrícula
			if(this.matricula[i]==asignatura){
				System.out.println("El alumno ya está matriculado en "+asignatura.getNombre());
				return;
			}
		}
		matricula[numAsignaturas]=asignatura;//asiganción de la materia a la matrícula
		numAsignaturas++;//incrementa las materias matriculadas del alumno
		return;
	}
	 public float media(){//calcula la nota media de las asignaturas en que está maticulado
		 float media=-1;
		 if (numAsignaturas>0){
			 media=0;
			 for (int i=0; i<numAsignaturas; i++){
				 media=media+notas[i];
			 }
			 media=media/numAsignaturas;
		 }
		 return media;
	 }
	 public String notaTexto(float nota){//pasa un valor de nota al texto
		 String texto="Suspenso";
		 if (nota>=6){
			 texto="Aprobado";
		 }
		 return texto;
	 }
	
}
