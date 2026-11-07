package org.example;

import java.util.Scanner;

public class Caso07 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double inicial, residual, valor;
        double depreciacion, nuevoValor, acumulada = 0;

        int anio = 0;

        System.out.print("Ingrese valor inicial: ");
        inicial = sc.nextDouble();

        residual = inicial * 0.10;
        valor = inicial;

        while (valor > residual) {

            anio++;

            depreciacion = valor * 0.25;
            nuevoValor = valor - depreciacion;

            if (nuevoValor < residual) {

                depreciacion = valor - residual;
                nuevoValor = residual;

            }

            acumulada += depreciacion;
            valor = nuevoValor;

            System.out.printf("%d | %.2f | %.2f%n",
                    anio, depreciacion, valor);
        }

        System.out.println("Años de depreciacion: " + anio);
        System.out.printf("Depreciacion acumulada: S/ %.2f%n", acumulada);

        sc.close();
    }
}
