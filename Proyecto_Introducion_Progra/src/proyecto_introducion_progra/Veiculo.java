/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_introducion_progra;

import java.util.Random;

/**
 *
 * @author gabrielzumbadoortiz
 */
public class Veiculo {
    //atributos 
    private int idreserva;
    private String placa;
    private String pago;
    private int tiempo;
    private String reserva;
    private String dia;
    private double montoTotal;
    
    //ID

    public Veiculo() {
        Random aleatorio = new Random();
        this.idreserva= aleatorio.nextInt(1000, 9999);
        
    }
    
    //parametros

    public Veiculo(String placa, String pago, int tiempo, String reserva, String dia, double montoTotal) {
        Random aleatorio = new Random();
        this.idreserva= aleatorio.nextInt(1000, 9999);
        this.placa = placa;
        this.pago = pago;
        this.tiempo = tiempo;
        this.reserva = reserva;
        this.dia = dia;
        this.montoTotal = montoTotal;
    }
    
    // getters y setters

    public int getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public String getReserva() {
        return reserva;
    }

    public void setReserva(String reserva) {
        this.reserva = reserva;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }
    //calculos 
    public void calcularMontoTotal(double  tarifaEntreSemana, double  tarifaFinSemana, double  tarifaMensual){
      double subtotal = 0;
      
        if (this.reserva.equals("Diara")) {
            if (this.dia.equals("Entre semana")) {
                subtotal =tarifaEntreSemana * this.tiempo;
            }
            if (this.dia.equals("Fin de semana")) {
                subtotal = tarifaFinSemana * this.tiempo;
            }
        }
        if (this.reserva.equals("Mensual")) {
            subtotal = tarifaMensual;
        }
        double iva = subtotal * 0.13;
        this.montoTotal = subtotal + iva; 
    }           
}
