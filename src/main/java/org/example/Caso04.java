package org.example;

import java.util.Scanner;

public class Caso04 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double deuda, pago, minimo, saldo;
        double interes, mora, nuevoSaldo;
        int dias;
        char tarjeta;
        String estado;

        System.out.print("Ingrese deuda: ");
        deuda = sc.nextDouble();

        System.out.print("Ingrese pago: ");
        pago = sc.nextDouble();

        System.out.print("Ingrese dias de atraso: ");
        dias = sc.nextInt();

        System.out.print("Ingrese tarjeta (C/G): ");
        tarjeta = sc.next().charAt(0);

        if (deuda < 50) {
            minimo = deuda;
        } else {
            minimo = deuda * 0.05;

            if (minimo < 50) {
                minimo = 50;
            }
        }

        if (pago >= deuda) {

            System.out.println("Deuda cancelada. Sin intereses");

        } else {

            saldo = deuda - pago;

            if (tarjeta == 'C') {
                interes = saldo * 0.035;
            } else {
                interes = saldo * 0.028;
            }

            if (pago < minimo) {

                mora = saldo * 0.001 * dias;

                if (mora > saldo * 0.10) {
                    mora = saldo * 0.10;
                }

                estado = "En mora";

            } else {

                mora = 0;
                estado = "Al dia";
            }

            nuevoSaldo = saldo + interes + mora;

            System.out.printf("Pago minimo: S/ %.2f%n", minimo);
            System.out.printf("Saldo pendiente: S/ %.2f%n", saldo);
            System.out.printf("Interes: S/ %.2f%n", interes);
            System.out.printf("Mora: S/ %.2f%n", mora);
            System.out.printf("Nuevo saldo: S/ %.2f%n", nuevoSaldo);
            System.out.println("Estado: " + estado);
        }

        sc.close();
    }
}

