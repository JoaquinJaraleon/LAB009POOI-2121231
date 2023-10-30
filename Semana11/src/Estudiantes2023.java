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

