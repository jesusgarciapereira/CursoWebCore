package com.ejemplo.proyecto0.app.model;

public class Animal {

	private String tipo;
	private double precio;
	private int peso;

	public Animal(String tipo, double precio, int peso) {
		this.tipo = tipo;
		this.precio = precio;
		this.peso = peso;
	}

	public String getTipo() {
		return tipo;
	}

	public double getPrecio() {
		return precio;
	}

	public int getPeso() {
		return peso;
	}


}
