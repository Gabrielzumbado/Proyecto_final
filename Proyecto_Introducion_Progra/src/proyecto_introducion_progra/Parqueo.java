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
}
