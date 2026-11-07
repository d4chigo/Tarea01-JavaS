package org.example;

import java.util.Scanner;

public class Caso05 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char plan, atencion;
        double monto, deducible, cobertura, tope;
        double aseguradora, paciente;

        System.out.print("Ingrese el plan (B/P/F): ");
        plan = sc.next().charAt(0);

        // Primero validamos el plan
        if (plan != 'B' && plan != 'P' && plan != 'F') {
            System.out.println("Plan no valido");
            sc.close();
            return;
        }

        // Si el plan es correcto, recién pedimos la atención
        System.out.print("Ingrese tipo de atencion (C/E/H): ");
        atencion = sc.next().charAt(0);

        // Validamos el tipo de atención
        if (atencion != 'C' && atencion != 'E' && atencion != 'H') {
            System.out.println("Tipo de atencion no valido");
            sc.close();
            return;
        }

        System.out.print("Ingrese el monto de la atencion: ");
        monto = sc.nextDouble();

        // Calculamos el deducible
        if (atencion == 'C') {
            deducible = 0;
        } else if (atencion == 'E') {
            deducible = 50;
        } else {
            deducible = 200;
        }

        // Determinamos la cobertura y el tope
        if (plan == 'B') {
            tope = 5000;

            if (atencion == 'C') {
                cobertura = 0.60;
            } else if (atencion == 'E') {
                cobertura = 0.70;
            } else {
                cobertura = 0.50;
            }

        } else if (plan == 'P') {
            tope = 15000;

            if (atencion == 'C') {
                cobertura = 0.80;
            } else if (atencion == 'E') {
                cobertura = 0.90;
            } else {
                cobertura = 0.70;
            }

        } else {
            tope = 50000;

            if (atencion == 'C' || atencion == 'E') {
                cobertura = 1.00;
            } else {
                cobertura = 0.90;
            }
        }

        // Calculamos cuánto paga la aseguradora
        if (monto <= deducible) {
            aseguradora = 0;
        } else {
            aseguradora = (monto - deducible) * cobertura;

            if (aseguradora > tope) {
                aseguradora = tope;
            }
        }

        // Calculamos cuánto paga el paciente
        paciente = monto - aseguradora;

        System.out.printf("Paga la aseguradora: S/ %.2f%n", aseguradora);
        System.out.printf("Paga el paciente: S/ %.2f%n", paciente);

        sc.close();
    }
}
