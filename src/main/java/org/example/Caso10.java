package org.example;

public class Caso10 {
    void main(){
        final double capacidad = 1000;
        final double pesoMaxPaquete = 200;
        final double umbralLleno = 950;

        double peso;
        double pesoTotal = 0;
        double espacioRestante;
        double masPesado = 0;
        double porcentaje;
        int cargados = 0;
        int rechazados = 0;
        boolean lleno = false;
        String detalle = "";

        IO.println("\tApp para cargar paquetes en el camión\n");

        do {
            IO.print("Ingrese el peso del paquete en kg (0 para terminar): ");
            peso = Double.parseDouble(IO.readln().trim());

            if (peso < 0){
                IO.println("Ingrese un peso válido.");
            }else if (peso > 0){
                espacioRestante = capacidad - pesoTotal;

                if (peso > pesoMaxPaquete){
                    rechazados++;
                    detalle += "Paquete rechazado: excede 200 kg\n";
                }else if (peso > espacioRestante){
                    rechazados++;
                    detalle += "Paquete rechazado: no cabe (quedan %.2f kg)\n".formatted(espacioRestante);
                }else{
                    cargados++;
                    pesoTotal += peso;

                    if (peso > masPesado){
                        masPesado = peso;
                    }

                    detalle += "Paquete %d cargado: %.2f - Total: %.2f\n".formatted(cargados, peso, pesoTotal);

                    if (pesoTotal >= umbralLleno){
                        lleno = true;
                    }
                }
            }

        }while (peso != 0 && !lleno);

        IO.println("\n\tDetalle de paquetes\n");

        if (cargados + rechazados == 0){
            IO.println("No se ingresaron paquetes");
        }else{
            IO.print(detalle);
        }

        if (lleno){
            IO.println("Camión lleno");
        }

        porcentaje = pesoTotal * 100 / capacidad;

        IO.println("\n\tResumen de la carga\n");
        IO.println("Paquetes cargados: %d".formatted(cargados));
        IO.println("Paquetes rechazados: %d".formatted(rechazados));
        IO.println("Peso total: %.2f kg".formatted(pesoTotal));
        IO.println("Ocupación: %.2f%%".formatted(porcentaje));
        IO.println("Paquete más pesado cargado: %.2f kg".formatted(masPesado));
    }
}