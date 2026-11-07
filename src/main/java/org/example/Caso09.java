package org.example;

public class Caso09 {
    void main(){
        final double tarifaLocal = 0.08;
        final double tarifaNacional = 0.15;
        final double tarifaInter = 0.90;
        final int minGratis = 60;
        final double limite = 50.00;
        final double igvPorc = 0.18;

        String tipo;
        int segundos;
        int minutos;
        int minGratisUsados = 0;
        int minGratisRestantes;
        int minCobrados;
        int numLlamada = 0;
        double costo;
        double totalSinIgv = 0;
        double igv;
        double totalPagar;
        boolean suspendido = false;
        String detalle = "";

        IO.println("\tApp para calcular el recibo de telefonía\n");

        do {
            IO.print("Ingrese el tipo de llamada (L, N, I o F para terminar)");
            IO.println("\n L: Local \n N: Nacional \n I: Internacional \n F: colgar");
            IO.print("Opción: ");
            tipo = IO.readln().trim().toUpperCase();

            if (tipo.equals("L") || tipo.equals("N") || tipo.equals("I")){
                IO.print("Ingrese la duración en segundos: ");
                segundos = Integer.parseInt(IO.readln().trim());

                minutos = (segundos + 59) / 60;
                numLlamada++;

                if (tipo.equals("L")){
                    minGratisRestantes = minGratis - minGratisUsados;

                    if (minutos <= minGratisRestantes){
                        minGratisUsados += minutos;
                        minCobrados = 0;
                    }else{
                        minGratisUsados += minGratisRestantes;
                        minCobrados = minutos - minGratisRestantes;
                    }

                    costo = minCobrados * tarifaLocal;
                }else if (tipo.equals("N")){
                    costo = minutos * tarifaNacional;
                }else{
                    costo = minutos * tarifaInter;
                }

                totalSinIgv += costo;

                detalle += "Llamada %d (%s): %d min - S/ %.2f\n".formatted(numLlamada, tipo, minutos, costo);

                if (totalSinIgv > limite){
                    suspendido = true;
                }

            }else if (!tipo.equals("F")){
                IO.println("Tipo de llamada no válido");
            }

        }while (!tipo.equals("F") && !suspendido);

        igv = totalSinIgv * igvPorc;
        totalPagar = totalSinIgv + igv;

        IO.println("\n\tDetalle de llamadas\n");

        if (numLlamada == 0){
            IO.println("No se registraron llamadas válidas");
        }else{
            IO.print(detalle);
        }

        if (suspendido){
            IO.println("Servicio suspendido por exceder el límite");
        }

        IO.println("\n\tResumen del recibo\n");
        IO.println("Minutos locales gratis usados: %d".formatted(minGratisUsados));
        IO.println("Total sin IGV: S/ %.2f".formatted(totalSinIgv));
        IO.println("IGV (18%%): S/ %.2f".formatted(igv));
        IO.println("Total a pagar: S/ %.2f".formatted(totalPagar));
    }
}