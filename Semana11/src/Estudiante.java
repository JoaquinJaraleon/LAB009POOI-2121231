/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



class Estudiante {
    private int codigo;
    private String nombre;
    private int ciclo;
    private double pension;

    public Estudiante(int codigo, String nombre, int ciclo, double pension) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ciclo = ciclo;
        this.pension = pension;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCiclo() {
        return ciclo;
    }

    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }

    public double getPension() {
        return pension;
    }

    public void setPension(double pension) {
        this.pension = pension;
    }

    @Override
    public String toString() {
        return "         " + codigo + "    " + nombre + "    " + ciclo + "    " + pension;
    }  
}
