package eus.uni.dam.in;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
public class Pelicula {
	@Id
	private long id;
	@Column
	private String titulo;
	@Column
	private String anyo;

	// private List<String> generos;

	public Pelicula() {
	}

	public Pelicula(long id, String titulo, String anyo, List<String> generos) {
		this.id = id;
		this.titulo = titulo;
		this.anyo = anyo;
		//this.generos = generos;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAnyo() {
		return anyo;
	}

	public void setAnyo(String anyo) {
		this.anyo = anyo;
	}

	/*
	 * public List<String> getGeneros() { return generos; }
	 * 
	 * 
	 * public void setGeneros(List<String> generos) { this.generos = generos; }
	 */

	@Override
	public int hashCode() {
		return Objects.hash(anyo, id, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pelicula other = (Pelicula) obj;
		return Objects.equals(anyo, other.anyo) && id == other.id && Objects.equals(titulo, other.titulo);
	}

	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", titulo=" + titulo + ", anyo=" + anyo + "]";
	}

}
