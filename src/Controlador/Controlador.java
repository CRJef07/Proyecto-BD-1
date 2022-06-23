package Controlador;

import Conexion.GestorBD;
import Modelos.Apartamentos;
import Modelos.Cuotas;
import Modelos.Dueno;
import Modelos.Filiales;
import java.sql.SQLException;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Controlador {

    private Filiales filiales;
    private Apartamentos apartamentos;
    private Dueno dueno;
    private Cuotas cuotas;

    public Controlador() {
        this.filiales = new Filiales();
        this.cuotas= new Cuotas();
        this.apartamentos = new Apartamentos();
        this.dueno = new Dueno();
    }

    public int getCantApartamentos() {
        return filiales.getCantApartamentos();
    }

    public void setCantApartamentos(int cantApartamentos) {
        this.filiales.setCantApartamentos(cantApartamentos);
    }

    public int getIdFilial() {
        return filiales.getIdFilial();
    }

    public void setIdFilial(int idFilial) {
        this.filiales.setIdFilial(idFilial);
    }

    public String getNombre() {
        return filiales.getNombre();
    }

    public void setNombre(String nombre) {
        this.filiales.setNombre(nombre);
    }

    public String getProvincia() {
        return filiales.getProvincia();
    }

    public void setProvincia(String provincia) {
        this.filiales.setProvincia(provincia);
    }

    public String getCanton() {
        return filiales.getCanton();
    }

    public void setCanton(String canton) {
        this.filiales.setCanton(canton);
    }

    public String getDistrito() {
        return filiales.getDistrito();
    }

    public void setDistrito(String distrito) {
        this.filiales.setDistrito(distrito);
    }

    public char getHabilitado() {
        return filiales.getHabilitado();
    }

    public void setHabilitado(char habilitado) {
        this.filiales.setHabilitado(habilitado);
    }

    public GestorBD getGestor() {
        return filiales.getGestor();
    }

    public void setGestor(GestorBD gestor) {
        this.filiales.setGestor(gestor);
    }

    public void cerrarConexion() {
        this.filiales.cerrarConexion();
    }

    public void agregarObservador(Observer observador) {
        this.filiales.agregarObservador(observador);
    }

    public void agregarFilial(JTable tbFiliales) {
        try {
            this.filiales.agregarFilial(tbFiliales);
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarFilial(int idFilial, JTable tbFiliales) {
        this.filiales.eliminarFilial(idFilial, tbFiliales);
    }
    public void eliminarCuota(int idFilial,int fila, JTable tabla) {
        this.cuotas.eliminarCuota(idFilial, fila, tabla);
    }

    public void modificarFilial() {
        this.filiales.modificarFilial();
    }

    public void cargarFiliales(JTable tabla) {
        this.filiales.cargarFiliales(tabla);
    }

    public void cargarDueno(JTable tabla) {
        this.dueno.cargarDueno(tabla);
    }

    public void verFilial(String idAparta, int idFilial) {
        this.apartamentos.verFilial(idAparta,idFilial);
    }

    public void verAgregarAparta() {
        this.apartamentos.verAgregarAparta();
    }

    public void verDueno(int idDueno) {
        this.dueno.verDueno(idDueno);
    }

    public void verCuotas(String idCuotas, int idF) {
        this.cuotas.verCuotas(idCuotas, idF);
    }

    public void agregarAparta(JTable tabla, int idFilial) {
        this.apartamentos.agregarAparta(tabla, idFilial);
    }
     public void agregarCuota(String idCasa,JTable tabla) {
        this.cuotas.agregarCuota( idCasa, tabla);
    }

    public void cargarApartamentos(int idFilial, JTable tabla) {
        this.apartamentos.cargarApartamentos(idFilial, tabla);
    }

    public void cargarCuotas(String idCuotas, JTable tabla) {
        this.cuotas.cargarCuotas(idCuotas, tabla);
    }

    public void cargarFilial(int idFilial, JTextField cantApartamentos, JTextField cantonFilial, JTextField cedJuridica, JTextField distritoFilial, JTextField nombreFilial, JTextField provinciaFilial) {
        this.apartamentos.cargarFilial(idFilial, cantApartamentos, cantonFilial, cedJuridica, distritoFilial, nombreFilial, provinciaFilial);
    }

}
