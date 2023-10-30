/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.*;
import javax.swing.*;
import java.io.*;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Estudiantes2023 {
    Scanner scanner = new Scanner(System.in);
    
    private static ArrayList<Estudiante> estudiantes;
    
    public Estudiantes2023() {
    estudiantes = new ArrayList<>();
    cargarArchivo();
    }
    
    public void adicionar(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }
    
    public void eliminar(Estudiante estudiante) {
        estudiantes.remove(estudiante);
    }
    
    public Estudiante obtener(int pos) {
        
        return null;
    }
    
    public Estudiante buscar(int codigo) {
        
        return null;
    }
    
    public int tamano() {
        return estudiantes.size();
    }
    
    public void listarEstudiantes(){
        if (tamano() > 0) {

            for(Estudiante estudiante : estudiantes) {
            System.out.println(estudiante.toString());
            }
        }else{
            System.out.println("No hay estudiantes registrados");
        }
    }
    
    public void nuevoEstudiante() {
        try{
            System.out.println("\nRecuerde poner exactamente el nombre y apellido del estudiante\n");
        
            System.out.print("Ingrese el nombre del estudiante : ");
            String nombre = scanner.next();
            
            System.out.print("Ingrese el apellido del estudiante : ");
            String apellido = scanner.next();
            
            String nombreapellido = nombre + " " + apellido;
            
            System.out.print("Ingrese el ciclo del estudiante : ");
            int ciclo = scanner.nextInt();
            
            System.out.print("Ingrese la pension del estudiante : ");
            double pension  = scanner.nextDouble();
            
            int nuevocod = (estudiantes.get(tamano() - 1)).getCodigo();
            nuevocod++;
            
            Estudiante estudiante = new Estudiante(nuevocod, nombreapellido, ciclo, pension);
            adicionar(estudiante);
            
        }catch(InputMismatchException e){
            System.out.println("No es el tipo de dato solicitado, intente otra vez");
        }
    }
    
    public void buscarEstudiante() {
        try{
            System.out.println("\nRecuerde poner exactamente el nombre y apellido del estudiante\n");
            
            System.out.print("Ingrese el nombre del estudiante : ");
            String nombre = scanner.next();
            
            System.out.print("Ingrese el apellido del estudiante : ");
            String apellido = scanner.next();
            
            String nombreapellido = nombre + " " + apellido;
            
            String resultado = null;
            
            
            for (Estudiante estudiante : estudiantes){
                if (estudiante.getNombre().equals(nombreapellido)){
                    resultado = estudiante.toString();
                    break;
                }
            }
        
            if(resultado != null){
                System.out.println(resultado);
            }else{
                System.out.println("\nNo se encontro el estudiante");
            }  
        }catch(InputMismatchException e){
            System.out.println("No es el tipo de dato solicitado, intente otra vez");
        }
    }
    
    public void eliminarEstudiante(){
        try{
            System.out.println("\nRecuerde poner exactamente el nombre y apellido del estudiante\n");
        
            System.out.print("Ingrese el nombre del estudiante : ");
            String nombre = scanner.next();
            
            System.out.print("Ingrese el apellido del estudiante : ");
            String apellido = scanner.next();
            
            String nombreapellido = nombre + " " + apellido;
            
            for (Estudiante estudiante : estudiantes){
                if (estudiante.getNombre().equals(nombreapellido)){
                 int index = estudiantes.indexOf(estudiante);
                    estudiantes.remove(index);
                    
                    if(estudiantes.contains(estudiante)){
                        System.out.println("No se elimino\n");
                    }else{
                        System.out.println("Se ha eliminado correctamente\n");
                    }
                    return;
                }
            }    
            System.out.println("\nNo se encontro el estudiante");
        }catch(InputMismatchException e){
            System.out.println("No es el tipo de dato solicitado, intente otra vez");
        }
    }
    
    public void sumTotalPensiones(){
        double sumatotal = 0;
        
        for (Estudiante estudiante : estudiantes){
            sumatotal += estudiante.getPension();
        }
        
        System.out.println("La suma total de la pensiones de los estudiantes es : S/" + sumatotal +"\n");
    }
    
    

    public void modificarApellidosMinusculaAMayuscula() {
        for (Estudiante estudiante : estudiantes) {
           String nombreCompleto = estudiante.getNombre();
        
            String nombreModificado1;
        
            nombreModificado1 = nombreCompleto.toLowerCase();
        
            String nombreModificado2 = nombreModificado1.substring(0, 1).toUpperCase() + nombreModificado1.substring(1);
        
            estudiante.setNombre(nombreModificado2);
        }
    }
    
    
    


    
    
    
    
    
    
    
    
    // M?todos para manipular el archivo de texto
    private void readFromInputStream(InputStream inputStream) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String linea;
        
        while ((linea = br.readLine()) != null) {
         StringTokenizer st = new StringTokenizer(linea, ",");
            createStudent(st);
        } 
        br.close();
    }
    
    // M?todo que a?adir a los estudiantes del archivo .txt en el arrayList estudiantes.
    private void createStudent(StringTokenizer st){
        int codigo = Integer.parseInt(st.nextToken().trim());
        String nombre = st.nextToken().trim();
        int ciclo = Integer.parseInt(st.nextToken().trim());
        double pension = Double.parseDouble(st.nextToken().trim());
        Estudiante estudiante = new Estudiante(codigo, nombre, ciclo, pension);
        adicionar(estudiante);
    }
    
    // M?todos para manipular el archivo de texto
    private void cargarArchivo() {
    try {
        File file = new File("./src/estudiantes.txt");
        Class<Estudiantes2023> clazz = Estudiantes2023.class;
        InputStream inputStream = clazz.getResourceAsStream("/estudiantes.txt");
        if (file.exists()) {
            readFromInputStream(inputStream);
        } else
            JOptionPane.showMessageDialog(null,"El archivo estudiantes.txt no existe");
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Se produjo un error= " + x);
        }
    }
}

