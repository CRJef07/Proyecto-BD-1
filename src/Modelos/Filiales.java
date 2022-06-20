package Modelos;

import Conexion.GestorBD;
import Vistas.condominios;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JTable;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Filiales extends Observable {

    private int idFilial = 0;
    private String nombre = "";
    private String provincia = "";
    private String canton = "";
    private String distrito = "";
    private char habilitado = 'S';
    private int cantApartamentos = 0;
    private GestorBD gestor = null;

    public Filiales() {
        this.gestor = new GestorBD();
    }

    public int getCantApartamentos() {
        return cantApartamentos;
    }

    public void setCantApartamentos(int cantApartamentos) {
        this.cantApartamentos = cantApartamentos;
    }

    public int getIdFilial() {
        return idFilial;
    }

    public void setIdFilial(int idFilial) {
        this.idFilial = idFilial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public char getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(char habilitado) {
        this.habilitado = habilitado;
    }

    public GestorBD getGestor() {
        return gestor;
    }

    public void setGestor(GestorBD gestor) {
        this.gestor = gestor;
    }

    public void cerrarConexion() {
        this.gestor.cerrar();
        setChanged();
        notifyObservers("Se cerro la conexion");
    }

    public void agregarObservador(Observer observador) {
        addObserver(observador);
        setChanged();
        notifyObservers("Observador");
    }

    public void agregarFilial() {

    }

    public void eliminarFilial() {

    }

    public void modificarFilial() {

    }

    public void cargarFiliales(JTable tabla) {
        try {
            String cadena = "SELECT * FROM FILIALES";
            Statement st = gestor.getConexion().createStatement();
            ResultSet rs = st.executeQuery(cadena);
            while (rs.next()) {
                DefaultTableModel filiales = (DefaultTableModel) tabla.getModel();
                filiales.addRow(new Object[]{rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)});
            }
            setChanged();
            notifyObservers("CARGANDO FILIALES");
        } catch (SQLException e) {
            System.err.println("Error:" + e);
        } finally {
            gestor.cerrar();
        }
    }



}
