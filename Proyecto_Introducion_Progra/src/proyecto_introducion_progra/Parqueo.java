/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_introducion_progra;

/**
 *
 * @author gabrielzumbadoortiz
 */
public class Parqueo {
   //Atributos
    private String nombreParqueo;
    private String ubicacion;
    private Piso[] pisos;
    private double tarifaEntreSemana;
    private double tarifaFinSeman;        
    private double tarifaMensula;
    
    //datsos

    public Parqueo() {
        this.nombreParqueo = "Parque El Descanso";
        this.ubicacion = "sin definir";
        this.tarifaEntreSemana = 2500.0;
        this.tarifaFinSeman = 3500.0;
        this.tarifaMensula = 45000.0;
    }
    //parametros

    public Parqueo(String nombreParqueo, String ubicacion, int cantidadPisos, int espaciosPorPisos) {
        this.nombreParqueo = nombreParqueo;
        this.ubicacion = ubicacion;
        this.tarifaEntreSemana = 2500.0;
        this.tarifaFinSeman = 3500.0;
        this.tarifaMensula = 45000.0;
        configurarEspacios(ubicacion, cantidadPisos, espaciosPorPisos);
    }
    // Getters y Setters

    public String getNombreParqueo() {
        return nombreParqueo;
    }

    public void setNombreParqueo(String nombreParqueo) {
        this.nombreParqueo = nombreParqueo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Piso[] getPisos() {
        return pisos;
    }

    public void setPisos(Piso[] pisos) {
        this.pisos = pisos;
    }

    public double getTarifaEntreSemana() {
        return tarifaEntreSemana;
    }

    public void setTarifaEntreSemana(double tarifaEntreSemana) {
        this.tarifaEntreSemana = tarifaEntreSemana;
    }

    public double getTarifaFinSeman() {
        return tarifaFinSeman;
    }

    public void setTarifaFinSeman(double tarifaFinSeman) {
        this.tarifaFinSeman = tarifaFinSeman;
    }

    public double getTarifaMensula() {
        return tarifaMensula;
    }

    public void setTarifaMensula(double tarifaMensula) {
        this.tarifaMensula = tarifaMensula;
    }
    //Ubicaciones 
    public void configurarEspacios(String ubicacion, int cantidadPisos, int espaciosPorPiso){
        this.ubicacion = ubicacion;
        this.pisos = new Piso[cantidadPisos];
        for (int i = 0; i < cantidadPisos; i++) {
            this.pisos[i] = new Piso(i + 1, espaciosPorPiso);            
        }
    }
    //validar los pisos
    public  boolean estaConfigurado(){
        return this.pisos != null && this.pisos.length > 0;
    }
    // asiganr veiculos al primer piso
    public  int asignarPrimerPiso(Veiculo veiculo){
        if (!estaConfigurado()) {
            return -1;
        }
        for (int i = 0; i < this.pisos.length; i++) {
            if (this.pisos[i].hayDIsponibilidad()) {
                this.pisos[i].asignarVeiculo(veiculo);
                return this.pisos[i].getNumeroPiso();
                
            }
        }
        return -1;
    }
    //registro de veiculo
    public  Veiculo ingresoVeiculo(String placa, String formaPago, int tiempoEstimado){
       Veiculo nuevo = new Veiculo(placa, formaPago, tiempoEstimado, "Diaria", "Entre semana", 0);
       nuevo.calcularMontoTotal(this.tarifaEntreSemana, this.tarifaFinSeman, this.tarifaMensula);
       int piso = asignarPrimerPiso(nuevo);
        if (piso != -1) {
            return nuevo;
        }
        return null;
    }
    //reserva veiculo
    public Veiculo registrarReservaDiari(String placa, String formaPago, int dias, boolean esFinDesemana){
        String tipoDia = "Entre semana";
        double tarifa = this.tarifaEntreSemana;
        
        if (esFinDesemana) {
            tipoDia = "Fin de semana";
            tarifa = this.tarifaFinSeman;
        }
        double subtotal = tarifa * dias;
        double iva = subtotal * 0.13;
        double total = subtotal + iva;
        
        Veiculo reserva = new Veiculo(placa, formaPago, dias, "Diaria", tipoDia, total);
        int piso = asignarPrimerPiso(reserva);
        if (piso != -1) {
            return reserva;
        }
        return null;
    }
    //registro 
    public String obtenerReporteOcupacion(){
        if (!estaConfigurado()) {
            return "El parque  aun no tiene piso configurados.";            
        }
        String reporte = "=== REPORTE DE OCUPACIO -" + this.nombreParqueo + "===\n"
                + "Ubicacion: " + this.ubicacion + "\n\n";
        
        int totalCapacidad = 0;
        int totalOcupados = 0;
        double ingresosTotales = 0;
        
        for (int i = 0; i < this.pisos.length; i++) {
            Piso p = this.pisos[i];
            totalCapacidad += p.getCapacidaMaxima();
            totalOcupados += p.getEspaciosOcupados();
            
            reporte += "Piso " + p.getNumeroPiso() + ": "
                    + p.getEspaciosOcupados() +  "/" + p.getCapacidaMaxima()
                    + " ocupados (" + String.format("%.1f", p.calcularPorcentajeOcupado()) + "%) \n";
            
            Veiculo[] lista = p.getEspacios();
            for (int j = 0; j < lista.length; j++) {
                if (lista[j] != null) {
                    ingresosTotales += lista[j].getMontoTotal();
                    reporte += " -Espacio " + (j + 1) + ": Placa[" + lista[j].getPlaca()
                            + "] | Tipo: " + lista[j].getReserva()
                            + " | Total: $" + lista[j].getMontoTotal() + "\n";
                }
            }
        }
        double porcentajeGeneral = (totalOcupados * 100.0) / totalCapacidad;
        reporte += "\nOcupacion General: " + totalOcupados + "  de " + totalCapacidad
                + " (" + String.format("%.1f", porcentajeGeneral) + "%)\n"
                + "Ingresos proyectados ( con IVA): $" + ingresosTotales;
        
        return reporte;
    }
    //registra salida
    public boolean  registraSalidaVehiculo(String placa){
        if (!estaConfigurado()) {
            return false;
        }
        for (int i = 0; i < this.pisos.length; i++) {
            if (this.pisos[i].liberarveiculo(placa)) {
                return true; 
            }
        }
        return false;
    }
    
}
