package Controlador;

import Conexion.GestorBD;
import Modelos.Apartamentos;
import Modelos.Dueno;
import Modelos.Filiales;
import java.util.Observer;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Controlador {

    private Filiales filiales;
    private Apartamentos apartamentos;
    private Dueno dueno;

    public Controlador() {
        this.filiales = new Filiales();
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

    public void agregarFilial() {
        this.filiales.agregarFilial();
    }

    public void eliminarFilial() {
        this.filiales.eliminarFilial();
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

    public void verFilial(int idFilial) {
        this.apartamentos.verFilial(idFilial);
    }
     public void verAgregarAparta() {
        this.apartamentos.verAgregarAparta();
    }
      public void verDueno(int idDueno) {
        this.dueno.verDueno(idDueno);
    }
     public void agregarAparta(JTable tabla, int idFilial) {
        this.apartamentos.agregarAparta(tabla, idFilial);
    }

    public void cargarApartamentos(int idFilial, JTable tabla) {
        this.apartamentos.cargarApartamentos(idFilial, tabla);
    }
    public void cargarFilial( int idFilial, JTextField cantApartamentos, JTextField cantonFilial, JTextField cedJuridica, JTextField distritoFilial, JTextField nombreFilial, JTextField provinciaFilial) {
        this.apartamentos.cargarFilial(idFilial,cantApartamentos, cantonFilial, cedJuridica, distritoFilial, nombreFilial, provinciaFilial);
    }
}
