


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        Estudiantes2023 a = new Estudiantes2023();
        int cerrar = 0;
        try{
        do{

            System.out.println("****** BIENVENIDOS AL SISTEMA DE GESTION DE ESTUDIANTES ********");
            System.out.println("1-NUEVO ESTUDIANTE");
            System.out.println("2-BUSCAR ESTUDIANTE");
            System.out.println("3-ELIMINAR ESTUDIANTE");
            System.out.println("4-MODIFICAR ESTUDIANTE");
            System.out.println("5-MODIFICAR APELLIDOS EN MINÚSCULAS");
            System.out.println("6-VER TODOS LOS ESTUDIANTES");
            System.out.println("7-VER TODOS LOS ESTUDIANTE POR APELLIDOS");
            System.out.println("8-VER TODOS LOS ESTUDIANTE POR PENSIÓN");
            System.out.println("9-TOTAL DE PENSIONES");
            System.out.println("10-SALIR\n");
            
            System.out.print("Ingrese su numero de operación : ");
            int numOperacion = scanner.nextInt();
        
        
            switch (numOperacion) {
                
                case 1:
                    a.nuevoEstudiante();
                    System.out.println("");
                    break;
                case 2:
                    a.buscarEstudiante();
                    System.out.println("");
                    break;
                case 3:
                    a.eliminarEstudiante();
                    System.out.println("");
                    break;
                
                case 4:
                    a.modificarEstudiante();
                    System.out.println("");
                    break;
                
                case 5:
                    a.modificarApellidosMinuscula();
                    System.out.println("");
                    break;
                
                case 6:
                    a.mostrarTablaEstudiantes();
                    break;
                    
                case 7:
                    break;
                
                case 8:
                    a.mostrarTablaEstudiantesXPension();
                    break;
                
                case 9:
                    a.sumTotalPensiones();
                    System.out.println("");
                    break; 
                    
                case 10:
                    cerrar = 10;
                    System.out.println("\nSaliendo del programa.... Hasta luego!");
                    break;    
            }
            
        }while(10 != cerrar);
        }catch(InputMismatchException e){
            System.out.println("Ese no es el tipo de dato correcto, vuelva a intentar");
        }
    }
    
}
