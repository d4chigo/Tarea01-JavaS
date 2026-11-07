package org.example;

import java.util.Scanner;

public class Caso01 {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        //Vriables que utilizaremos para almacenar los datos 
        int edad, anticipado, destino;
        int exceso = 12;
        Double costoembarque = 28.90;
        char Clase;
        Double Pagototal = 0.00; 
        Double equipaje, kilosExcedentes;
        Double costoExceso = 0.00;
        Double preciotino = 0.00;
        Double preciocusco = 180.00;
        Double precioarequipa = 220.00;
        Double preciopiura = 250.00;
        Double precioiquitos = 320.00;

        System.out.println("-----Destinos con su precio: -----");
        System.out.println("1. Cusco - S/. 180.00");
        System.out.println("2. Arequipa - S/. 220.00");
        System.out.println("3. Piura - S/. 250.00");
        System.out.println("4. Iquitos - S/. 320.00");
        System.out.print("Para elegir un destino, ingrese el número correspondiente (1 - 4): ");
        destino = sc.nextInt();

        System.out.println("El destino se paga de acuerdo a la Edad:");
        System.out.println("Menos de 2 años: paga el 10% ");
        System.out.println("2 a 11 años: paga el 75% ");
        System.out.println("65 años en adelante: paga el 85% ");
        System.out.println("Las demas edades : paga el 100% ");
        System.out.print("Ingrese su edad: ");
        edad = sc.nextInt();

        switch (destino) {
            case 1:
                if (edad < 2) {
                    preciotino = preciocusco * 0.10;
                } else if (edad >= 2 && edad <= 11) {
                    preciotino = preciocusco * 0.75;
                } else if (edad >= 65) {
                    preciotino = preciocusco * 0.85;
                } else {
                    preciotino = preciocusco;
                }
                System.out.println("Destino Seleccionado: Cusco");
                break;

            case 2:
                if (edad < 2) {
                    preciotino = precioarequipa * 0.10;
                } else if (edad >= 2 && edad <= 11) {
                    preciotino = precioarequipa * 0.75;
                } else if (edad >= 65) {
                    preciotino = precioarequipa * 0.85;
                } else {
                    preciotino = precioarequipa;
                }
                System.out.println("Destino Seleccionado: Arequipa");
                break;

            case 3:  
                if (edad < 2) {
                    preciotino = preciopiura * 0.10;
                } else if (edad >= 2 && edad <= 11) {
                    preciotino = preciopiura * 0.75;
                } else if (edad >= 65) {
                    preciotino = preciopiura * 0.85;
                } else {
                    preciotino = preciopiura;
                }
                System.out.println("Destino Seleccionado: Piura");
                break;

            case 4:
                if (edad < 2) {
                    preciotino = precioiquitos * 0.10;
                } else if (edad >= 2 && edad <= 11) {
                    preciotino = precioiquitos * 0.75;
                } else if (edad >= 65) {
                    preciotino = precioiquitos * 0.85;
                } else {
                    preciotino = precioiquitos;
                }
                System.out.println("Destino Seleccionado: Iquitos");
                break;

            default:
                System.out.println("Destino no válido.");
                return;
        }

        System.out.println(" Clase de viaje: (N)-Negocios, (E)-Económica");
        System.out.println("La clase de Negocios cuesta 1.80 veces la tarifa base ");
        System.out.print("Ingrese la clase de viaje (N/E): ");
        Clase = sc.next().charAt(0);
        System.out.println("Equipaje permitido de acuerdo a la clase de viaje: ");
        System.out.println("Clase de Negocios: 32 kg");
        System.out.println("Clase Económica: 23 kg");
        System.out.println("Costo de embarque: S/. 28.90");
        System.out.println("Si su equipaje excede el peso permitido, se cobrará un costo adicional de S/. 12.00 por cada kilogramo excedente.");
        System.out.print("Ingrese el peso de su equipaje en kg: ");
        equipaje = sc.nextDouble();
        if (Clase == 'N' || Clase == 'n') {
            preciotino = preciotino * 1.80;
            kilosExcedentes = equipaje - 32; // Peso permitido para clase de negocios
            if (kilosExcedentes > 0) {
                costoExceso  = kilosExcedentes * exceso;
                System.out.println("Se ha aplicado un costo adicional de S/. " + costoExceso + " por exceso de equipaje.");
            }else {
                System.out.println("No se ha aplicado ningún costo adicional por exceso de equipaje.");
            }
            System.out.println("Tu clase de viaje es: Negocios");
        } else if (Clase == 'E' || Clase == 'e') {
            kilosExcedentes = equipaje - 23; //Peso permitido para clase económica
            if(kilosExcedentes >0){
                costoExceso = kilosExcedentes * exceso;
                System.out.println("Se ha aplicado un costo adicional de S/. " + costoExceso + " por exceso de equipaje.");
            }else {
                System.out.println("No se ha aplicado ningún costo adicional por exceso de equipaje.");
            }
            // No se aplica ningún cambio en el precio para la clase económica
            System.out.println("Tu clase de viaje es: Económica");
        } else {
            System.out.println("Clase de viaje no válida.");
            return;
        }
        

        System.out.println("--------Descuento por compra anticipada-------- ");
        System.out.println("30 o mas dias de anticipación: 15% de descuento");
        System.out.println("15 a 29 dias de anticipación: 8% de descuento");
        System.out.print("Ingrese la cantidad de días de anticipación con la que realiza la compra: ");
        anticipado = sc.nextInt();
        if (anticipado >= 30){
            preciotino = preciotino * 0.85;
            System.out.println("Se le ha aplicado un descuento del 15% por compra anticipada.");
        }else if (anticipado >= 15 && anticipado <= 29){
            preciotino = preciotino * 0.92;
            System.out.println("Se le ha aplicado un descuento del 8% por compra anticipada.");
        }else{
            // No se aplica ningún descuento si la compra es realizada con menos de 15 días de anticipación
            System.out.println("No se le ha aplicado ningún descuento por compra anticipada.");
        }

        System.out.println("--------Detalle de su compra--------");
        

        Pagototal = preciotino + costoExceso + costoembarque;
        System.out.printf("Tarifa con descuento: S/. %.2f%n", preciotino);
        System.out.printf("Exceso de equipaje: S/. %.2f%n", costoExceso);
        System.out.printf("Tasa de embarque: S/. %.2f%n", costoembarque);
        System.out.printf("Total: S/. %.2f%n", Pagototal);

    }
}
