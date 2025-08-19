package com.example;

public class ProductoElectronico extends Producto {
	private int garantiaMeses;
	private String marca;
	private double voltaje;
	private boolean esImportado;

	public ProductoElectronico(String nombre, double precioBase, String codigo, int cantidadStock, String categoria,
							   int garantiaMeses, String marca, double voltaje, boolean esImportado) {
		super(nombre, precioBase, codigo, cantidadStock, categoria);
		this.garantiaMeses = garantiaMeses;
		this.marca = marca;
		this.voltaje = voltaje;
		this.esImportado = esImportado;
	}

	// Getters y setters
	public int getGarantiaMeses() { return garantiaMeses; }
	public void setGarantiaMeses(int garantiaMeses) { this.garantiaMeses = garantiaMeses; }

	public String getMarca() { return marca; }
	public void setMarca(String marca) { this.marca = marca; }

	public double getVoltaje() { return voltaje; }
	public void setVoltaje(double voltaje) { this.voltaje = voltaje; }

	public boolean isEsImportado() { return esImportado; }
	public void setEsImportado(boolean esImportado) { this.esImportado = esImportado; }

	public double calcularPrecioElectronico() {
		double precio = calcularPrecioFinal();
		if (esImportado) {
			precio += this.precioBase * 0.05;
		}
		double descuento = calcularDescuentoGarantia();
		precio = precio - (precio * descuento);
		return precio;
	}

	public double calcularDescuentoGarantia() {
		if (garantiaMeses >= 24) {
			return 0.10;
		} else if (garantiaMeses >= 12) {
			return 0.05;
		} else {
			return 0.0;
		}
	}

	public boolean esGarantiaExtendida() {
		return garantiaMeses > 12;
	}

	public double calcularCostoGarantia() {
		return this.precioBase * 0.02 * garantiaMeses;
	}

	public boolean esCompatibleVoltaje(double voltajeLocal) {
		double diferencia = Math.abs(this.voltaje - voltajeLocal);
		return diferencia <= (voltajeLocal * 0.10);
	}
}
