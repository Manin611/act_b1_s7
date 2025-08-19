package com.example;

public class SistemaTienda {
    public static void main(String[] args) {
        ProductoElectronico laptop = new ProductoElectronico(
            "Laptop", 2500000, "PROD-0001", 5, "Electrónica", 24, "Dell", 110, true
        );
        ProductoElectronico celular = new ProductoElectronico(
            "Celular", 1200000, "PROD-0002", 10, "Electrónica", 12, "Samsung", 120, false
        );

        ProductoAlimenticio leche = new ProductoAlimenticio(
            "Leche", 4500, "PROD-1001", 20, "Alimentos", true, "L001", 5
        );
        ProductoAlimenticio pan = new ProductoAlimenticio(
            "Pan", 2000, "PROD-1002", 15, "Alimentos", false, "L002", 10
        );

        laptop.vender(2);
        laptop.vender(10);

        System.out.println("Precio final laptop: " + laptop.calcularPrecioElectronico());
        System.out.println("Precio final leche: " + leche.calcularPrecioAlimenticio());

        leche.reabastecer(10);
        pan.reabastecer(5);

        System.out.println("Laptop compatible 120V: " + laptop.esCompatibleVoltaje(120));
        System.out.println("Celular compatible 110V: " + celular.esCompatibleVoltaje(110));

        System.out.println("Precio base laptop: " + laptop.getPrecioBase());
        System.out.println("Precio electrónico laptop: " + laptop.calcularPrecioElectronico());

        System.out.println("Laptop garantía extendida: " + laptop.esGarantiaExtendida());
        System.out.println("Leche próxima a vencer: " + leche.estaProximoAVencer());
        System.out.println("Estado frescura pan: " + pan.obtenerEstadoFrescura());
        System.out.println("Pérdida por vencimiento leche: " + leche.calcularPerdidaPorVencimiento());
    }
}
