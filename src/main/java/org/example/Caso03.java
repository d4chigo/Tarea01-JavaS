package org.example;

import java.util.Scanner;

public class Caso03 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int unidadesLote, unidadesRevisadas, defectosMenores, defectosCriticos;
        int muestraMinima;
        double precioUnitario, porcentajeDefectuosas, maximoAceptable;
        double valorLote, pago;
        char certificado;

        System.out.println("----- CONTROL DE CALIDAD DE UN LOTE -----");
        System.out.print("Unidades del lote: ");
        unidadesLote = teclado.nextInt();
        System.out.print("Unidades revisadas: ");
        unidadesRevisadas = teclado.nextInt();
        System.out.print("Defectos menores encontrados: ");
        defectosMenores = teclado.nextInt();
        System.out.print("Defectos criticos encontrados: ");
        defectosCriticos = teclado.nextInt();
        System.out.print("Precio unitario: ");
        precioUnitario = teclado.nextDouble();
        System.out.print("¿Proveedor certificado? (S/N): ");
        certificado = teclado.next().toUpperCase().charAt(0);

        muestraMinima = (int) Math.ceil(unidadesLote * 0.10);

        if (unidadesRevisadas < muestraMinima) {
            System.out.println("Muestra insuficiente: revisar al menos " + muestraMinima + " unidades");
            teclado.close();
            return;
        }

        if (defectosCriticos >= 1) {
            System.out.println("Decisión: Lote RECHAZADO: defectos críticos");
            System.out.println("Pago al proveedor: S/ 0.00");
            teclado.close();
            return;
        }

        porcentajeDefectuosas = (double) defectosMenores / unidadesRevisadas * 100;

        if (certificado == 'S') {
            maximoAceptable = 3.0;
        } else {
            maximoAceptable = 2.0;
        }

        valorLote = unidadesLote * precioUnitario;

        System.out.printf("Defectuosas: %.2f %%%n", porcentajeDefectuosas);

        if (porcentajeDefectuosas <= maximoAceptable) {
            pago = valorLote;
            System.out.println("Decisión: Lote ACEPTADO");
        } else if (porcentajeDefectuosas <= maximoAceptable + 3.0) {
            pago = valorLote * 0.90;
            System.out.println("Decisión: Lote ACEPTADO CON DESCUENTO");
        } else {
            pago = 0;
            System.out.println("Decisión: Lote RECHAZADO: exceso de defectos");
        }

        System.out.printf("Pago al proveedor: S/ %.2f%n", pago);
        teclado.close();
    }
}
