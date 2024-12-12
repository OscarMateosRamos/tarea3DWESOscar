package com.Tarea3DWESOscar.modelo;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "personas")

public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "email")
	private String email;

	@OneToMany( mappedBy="persona", cascade = CascadeType.ALL)
	private List<Mensaje> mensajes;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idcredencial")
	private Credencial credencial;

	public Persona() {

	}

	public Persona(Long id, String nombre, String email, Credencial credencial) {
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.credencial = credencial;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Mensaje> getMensaje() {
		return getMensaje();
	}

	public void setMensaje(List<Mensaje> mensaje) {
		this.mensajes = mensaje;
	}

	public Credencial getCredencial() {
		return credencial;
	}

	public void setCredencial(Credencial credencial) {
		this.credencial = credencial;
	}

	@Override
	public int hashCode() {
		return Objects.hash(credencial, email, id, mensajes, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(credencial, other.credencial) && Objects.equals(email, other.email)
				&& Objects.equals(id, other.id) && Objects.equals(mensajes, other.mensajes)
				&& Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", email=" + email + ", mensaje=" + mensajes
				+ ", credencial=" + credencial + "]";
	}

}