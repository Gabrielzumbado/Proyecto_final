/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_introducion_progra;

/**
 *
 * @author gabrielzumbadoortiz
 */
public class Piso {
    //atributos
    private int numeroPiso;
    private int capacidaMaxima;
    private int espaciosOcupados;
    private Veiculo[] espacios;
    
    //Piso

    public Piso() {
        this.espaciosOcupados = 0;
    }
    
    //parametros del espacio

    public Piso(int numeroPiso, int capacidaMaxima, int espaciosOcupados, Veiculo[] espacios) {
        this.numeroPiso = numeroPiso;
        this.capacidaMaxima = capacidaMaxima;
        this.espaciosOcupados = espaciosOcupados;
        this.espacios = espacios;
    }

    Piso(int i, int espaciosPorPiso) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    //getter y setters

    public int getNumeroPiso() {
        return numeroPiso;
    }

    public void setNumeroPiso(int numeroPiso) {
        this.numeroPiso = numeroPiso;
    }

    public int getCapacidaMaxima() {
        return capacidaMaxima;
    }

    public void setCapacidaMaxima(int capacidaMaxima) {
        this.capacidaMaxima = capacidaMaxima;
    }

    public int getEspaciosOcupados() {
        return espaciosOcupados;
    }

    public void setEspaciosOcupados(int espaciosOcupados) {
        this.espaciosOcupados = espaciosOcupados;
    }

    public Veiculo[] getEspacios() {
        return espacios;
    }

    public void setEspacios(Veiculo[] espacios) {
        this.espacios = espacios;
    }
    //campos libres
    public boolean hayDIsponibilidad(){
        return this.espaciosOcupados < this.capacidaMaxima;     
    }
    // asignar espacios 
    public boolean asignarVeiculo(Veiculo nuevoveiculo){
        for (int i = 0; i < this.espacios.length; i++) {
            if (this.espacios [i] == null) {
                this.espacios[i] = nuevoveiculo;
                this.espaciosOcupados++;
                return true;
            }
        }
        return false;
    }
    //reservar espacios
    public  boolean liberarveiculo(String placa){
        for (int i = 0; i < this.espacios.length; i++) {
            if (this.espacios[i] != null && this.espacios[i].getPlaca().equalsIgnoreCase(placa)){
                this.espacios[i] =null;
                this.espaciosOcupados--;
                return true;
            }
        }
        return false;
    }
    // porcentaje de espacio
    public double calcularPorcentajeOcupado(){
        if (this.capacidaMaxima == 0) {
            return 0;
        }
        return (this.espaciosOcupados * 100.0) / this.capacidaMaxima;
    }    
}
