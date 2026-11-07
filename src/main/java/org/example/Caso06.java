package org.example;

import java.util.Scanner;

public class Caso06 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char tipo;
        int cantidad, general = 0, vip = 0;
        int aceptadas = 0, rechazadas = 0;
        int compra = 0, disponibles;

        double monto, ingresos = 0;
        double descuento, ocupacion;

        System.out.print("Ingrese tipo (G/V/F): ");
        tipo = sc.next().charAt(0);

        while (tipo != 'F') {

            System.out.print("Ingrese cantidad: ");
            cantidad = sc.nextInt();

            if (tipo != 'G' && tipo != 'V') {

                System.out.println("Tipo no valido");
                rechazadas++;

            } else if (cantidad < 1 || cantidad > 6) {

                System.out.println("Cantidad no valida: debe ser de 1 a 6");
                rechazadas++;

            } else {

                if (tipo == 'G') {
                    disponibles = 12 - general;
                } else {
                    disponibles = 4 - vip;
                }

                if (cantidad > disponibles) {

                    System.out.println("Entradas insuficientes: quedan " + disponibles);
                    rechazadas++;

                } else {

                    if (tipo == 'G') {
                        general += cantidad;
                        monto = cantidad * 80;
                    } else {
                        vip += cantidad;
                        monto = cantidad * 200;
                    }

                    if (cantidad >= 4) {
                        descuento = monto * 0.10;
                    } else {
                        descuento = 0;
                    }

                    monto = monto - descuento;
                    ingresos += monto;

                    aceptadas++;
                    compra++;

                    System.out.printf("Compra %d: %d entradas %c - S/ %.2f%n",
                            compra, cantidad, tipo, monto);
                }
            }

            System.out.print("Ingrese tipo (G/V/F): ");
            tipo = sc.next().charAt(0);
        }

        ocupacion = ((general + vip) / 16.0) * 100;

        System.out.println("Entradas vendidas: General " + general + " | VIP " + vip);
        System.out.printf("Ingresos: S/ %.2f%n", ingresos);
        System.out.printf("Ocupacion del aforo: %.2f %% %n", ocupacion);
        System.out.println("Compras aceptadas: " + aceptadas +
                " | Compras rechazadas: " + rechazadas);

        sc.close();
    }
}
