package com.example;


public class Producto {
	protected String nombre;
	protected double precioBase;
	protected String codigo;
	protected int cantidadStock;
	protected String categoria;
	protected boolean activo;

	public Producto(String nombre, double precioBase, String codigo, int cantidadStock, String categoria) {
		this.setNombre(nombre);
		this.setPrecioBase(precioBase);
		this.setCodigo(codigo);
		this.setCantidadStock(cantidadStock);
		this.setCategoria(categoria);
		this.activo = true;
	}

	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }

	public double getPrecioBase() { return precioBase; }
	public void setPrecioBase(double precioBase) {
		if (precioBase > 0) {
			this.precioBase = precioBase;
		}
	}

	public String getCodigo() { return codigo; }
	public void setCodigo(String codigo) {
		if (codigo != null && codigo.matches("PROD-\\d{4}")) {
			this.codigo = codigo;
		}
	}

	public int getCantidadStock() { return cantidadStock; }
	public void setCantidadStock(int cantidadStock) {
		if (cantidadStock >= 0) {
			this.cantidadStock = cantidadStock;
		}
	}

	public String getCategoria() { return categoria; }
	public void setCategoria(String categoria) { this.categoria = categoria; }

	public boolean isActivo() { return activo; }
	public void setActivo(boolean activo) { this.activo = activo; }

	public double calcularPrecioFinal() {
		return this.precioBase * 1.19;
	}

	public boolean hayStock(int cantidad) {
		return this.cantidadStock >= cantidad && this.activo;
	}

	public void vender(int cantidad) {
		if (hayStock(cantidad)) {
			this.cantidadStock -= cantidad;
			System.out.println("Venta exitosa: " + cantidad + " unidades de " + nombre);
		} else {
			System.out.println("Error: Stock insuficiente");
		}
	}

	public void reabastecer(int cantidad) {
		this.cantidadStock += cantidad;
		System.out.println("Reabastecimiento exitoso: +" + cantidad + " unidades de " + nombre);
	}

	public double calcularDescuento() {
		return 0.0;
	}
}
