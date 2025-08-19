package com.example;

public class ProductoAlimenticio extends Producto {
	private boolean refrigerado;
	private String lote;
	private int diasParaVencer;

	public ProductoAlimenticio(String nombre, double precioBase, String codigo, int cantidadStock, String categoria,
							   boolean refrigerado, String lote, int diasParaVencer) {
		super(nombre, precioBase, codigo, cantidadStock, categoria);
		this.refrigerado = refrigerado;
		this.lote = lote;
		this.diasParaVencer = diasParaVencer;
	}

	public boolean isRefrigerado() { return refrigerado; }
	public void setRefrigerado(boolean refrigerado) { this.refrigerado = refrigerado; }

	public String getLote() { return lote; }
	public void setLote(String lote) { this.lote = lote; }

	public int getDiasParaVencer() { return diasParaVencer; }
	public void setDiasParaVencer(int diasParaVencer) { this.diasParaVencer = diasParaVencer; }

	public double calcularPrecioAlimenticio() {
		double precio = calcularPrecioFinal();
		if (refrigerado) {
			precio += this.precioBase * 0.08;
		}
		double descuento = calcularDescuentoVencimiento();
		precio = precio - (precio * descuento);
		return precio;
	}

	public double calcularDescuentoVencimiento() {
		if (diasParaVencer <= 3) {
			return 0.50;
		} else if (diasParaVencer <= 7) {
			return 0.30;
		} else if (diasParaVencer <= 15) {
			return 0.15;
		} else {
			return 0.0;
		}
	}

	public boolean estaProximoAVencer() {
		return diasParaVencer <= 7;
	}

	public boolean estaVencido() {
		return diasParaVencer <= 0;
	}

	public String obtenerEstadoFrescura() {
		if (estaVencido()) {
			return "VENCIDO";
		} else if (diasParaVencer <= 3) {
			return "URGENTE";
		} else if (diasParaVencer <= 7) {
			return "PRÓXIMO A VENCER";
		} else if (diasParaVencer <= 15) {
			return "CONSUMIR PRONTO";
		} else {
			return "FRESCO";
		}
	}

	public double calcularPerdidaPorVencimiento() {
		if (estaVencido()) {
			return this.precioBase * this.cantidadStock;
		} else {
			return 0.0;
		}
	}
}
