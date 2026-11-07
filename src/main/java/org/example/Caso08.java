package org.example;

public class Caso08 {
    void main(){
        int numAlumnos = 0;
        final int notasT = 3;
        double nota = 0;
        double sum = 0;
        String nombreAlum;
        String[] nombres = null;
        double[] promedios = null;
        boolean[] validos = null;
        boolean valido;
        int considerados = 0;
        int aprobados = 0;
        double sumaPromedios = 0;
        double mejorPromedio = -1;
        String mejorAlumno = "";

        IO.println("\tApp para calcular promedio de Alumnos\n");

        IO.println("Hola maestro !");
        do {
            IO.print("Ingrese el número de estudiantes a evaluar: ");
            numAlumnos = Integer.parseInt(IO.readln());

            if (numAlumnos > 0){
                nombres = new String[numAlumnos];
                promedios = new double[numAlumnos];
                validos = new boolean[numAlumnos];

                for (int i = 0; i < numAlumnos; i++) {
                    IO.print("Ingrese el nombre del Alumno %d : ".formatted(i + 1));
                    nombreAlum = IO.readln();

                    sum = 0;
                    valido = true;

                    for (int j = 1; j <= notasT; j++){
                        IO.print("Para %s ingrese la nota %d : ".formatted(nombreAlum, j));
                        nota = Double.parseDouble(IO.readln());

                        if (nota < 0 || nota > 20){
                            valido = false;
                        }

                        sum += nota;
                    }

                    nombres[i] = nombreAlum;
                    validos[i] = valido;
                    promedios[i] = sum / notasT;
                }

            }else{
                IO.println("Ingrese un monto válido.");
            }

        }while (numAlumnos <= 0);

        IO.println("\n\tResultados\n");

        for (int i = 0; i < numAlumnos; i++) {
            if (validos[i]){
                considerados++;
                sumaPromedios += promedios[i];

                if (promedios[i] >= 11){
                    aprobados++;
                    IO.println("%s: promedio %.2f - Aprobado".formatted(nombres[i], promedios[i]));
                }else{
                    IO.println("%s: promedio %.2f - Desaprobado".formatted(nombres[i], promedios[i]));
                }

                if (promedios[i] > mejorPromedio){
                    mejorPromedio = promedios[i];
                    mejorAlumno = nombres[i];
                }
            }else{
                IO.println("%s: nota inválida, no se considera".formatted(nombres[i]));
            }
        }

        IO.println("\n\tResumen del salón\n");

        if (considerados == 0){
            IO.println("Sin estudiantes válidos");
        }else{
            double porcentaje = aprobados * 100.0 / considerados;
            double promedioGeneral = sumaPromedios / considerados;

            IO.println("Estudiantes considerados: %d".formatted(considerados));
            IO.println("Aprobados: %d (%.2f%%)".formatted(aprobados, porcentaje));
            IO.println("Promedio general: %.2f".formatted(promedioGeneral));
            IO.println("Mejor promedio: %s con %.2f".formatted(mejorAlumno, mejorPromedio));
        }
    }
}