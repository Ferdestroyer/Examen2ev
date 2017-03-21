package Alumnos;

public class Asignatura {
	private String nombre;//nombre de la asignatura
	private char nivel;//nivel de la asigantura
	private int horasSemana;//horas de la asignatura a la semana
	
	
	/**
	 * @param nombre
	 * @param nivel
	 * @param horasSemana
	 */
	public Asignatura(String nombre, char nivel, int horasSemana) {//contructor de la asignatura con parámetros
		this.nombre = nombre;
		this.nivel = nivel;
		this.horasSemana = horasSemana;
	}


	public String getNombre() {//devuelve el nombre de la asignatura
		return nombre;
	}


	public void setNombre(String nombre) {//pone nombre a la asignatura
		this.nombre = nombre;
	}


	public char getNivel() {//devuelve el nivel de la asignatura
		return nivel;
	}


	public void setNivel(char nivel) {//graba el nombre de la materia
		this.nivel = nivel;
	}


	public int getHorasSemana() {//graba las horas a la semana
		return horasSemana;
	}


	public void setHorasSemana(int horasSemana) {//devuelve las horas a la semana
		this.horasSemana = horasSemana;
	}
	
	
}
