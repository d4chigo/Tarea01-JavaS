package org.example;

import java.util.Scanner;

public class Caso02 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        double distancia, costoDistancia;
        double costoEspera, subtotal;
        double total, multiplicador;
        int minutosEspera, hora, demanda;
        char aeropuerto;

        // Ingreso de datos
        System.out.println("------- TARIFA DE TAXI -------");

        System.out.print("Ingrese la distancia del viaje (km): ");
        distancia = teclado.nextDouble();

        System.out.print("Ingrese los minutos de espera: ");
        minutosEspera = teclado.nextInt();

        System.out.print("Ingrese la hora de inicio (0-23): ");
        hora = teclado.nextInt();

        System.out.print("¿El viaje es al aeropuerto? (S/N): ");
        aeropuerto = teclado.next().toUpperCase().charAt(0);

        System.out.println("\n------- NIVEL DE DEMANDA -------");
        System.out.println("1. Normal (x1.0)");
        System.out.println("2. Alta (x1.3)");
        System.out.println("3. Muy alta (x1.6)");
        System.out.print("Seleccione el nivel de demanda: ");
        demanda = teclado.nextInt();

        // Validar nivel de demanda
        if (demanda < 1 || demanda > 3) {
            System.out.println("Nivel de demanda no válido");
            return;
        }

        // Calcular costo por distancia
        if (distancia <= 5) {
            costoDistancia = distancia * 1.80;
        } else {
            costoDistancia = (5 * 1.80) + ((distancia - 5) * 1.50);
        }

        // Calcular costo por espera
        if (minutosEspera > 3) {
            costoEspera = (minutosEspera - 3) * 0.30;
        } else {
            costoEspera = 0;
        }

        // Calcular subtotal
        subtotal = 4.50 + costoDistancia + costoEspera;

        // Recargo nocturno
        if (hora >= 22 || hora < 5) {
            subtotal = subtotal * 1.20;
        }

        // Multiplicador por demanda
        switch (demanda) {
            case 1:
                multiplicador = 1.0;
                break;
            case 2:
                multiplicador = 1.3;
                break;
            default:
                multiplicador = 1.6;
                break;
        }

        total = subtotal * multiplicador;

        // Recargo por aeropuerto
        if (aeropuerto == 'S' || aeropuerto == 's') {
            total = total + 8.00;
        }

        // Aplicar tarifa mínima
        if (total < 9.00) {
            total = 9.00;
            System.out.printf("Total a pagar: S/. %.2f (tarifa mínima)%n", total);
        } else {
            System.out.printf("Total a pagar: S/. %.2f%n", total);
        }

        teclado.close();
    }
}
