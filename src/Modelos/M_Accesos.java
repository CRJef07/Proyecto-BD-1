package Modelos;

import Conexion.GestorBD;
import Controlador.Controlador;
import Vistas.Accesos;
import Vistas.condominios;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JTable;
import Vistas.index;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class M_Accesos extends Observable {

    public static Calendar calendar = new GregorianCalendar();
    private GestorBD gestor = null;
    private int idAcceso = 0;
    private String idCasa = "";
    private String entrada = "";
    private String salida = "";
    private String visitante = "";

    public M_Accesos() {
        this.gestor = new GestorBD();
    }

    public String getVisitante() {
        return visitante;
    }

    public void setVisitante(String visitante) {
        this.visitante = visitante;
    }

    public GestorBD getGestor() {
        return gestor;
    }

    public void setGestor(GestorBD gestor) {
        this.gestor = gestor;
    }

    public int getIdAcceso() {
        return idAcceso;
    }

    public void setIdAcceso(int idAcceso) {
        this.idAcceso = idAcceso;
    }

    public String getIdCasa() {
        return idCasa;
    }

    public void setIdCasa(String idCasa) {
        this.idCasa = idCasa;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    public void agregarObservadorAccesos(Observer observador) {
        addObserver(observador);
        setChanged();
        notifyObservers("Observador");
    }

    public void cargarAccesos(String idApartamento, JTable tbApartamentos) {
        try {
            String cadena = "SELECT * FROM ACCESOS WHERE ID_CASA='" + idApartamento + "'";
            Statement st = gestor.getConexion().createStatement();
            ResultSet rs = st.executeQuery(cadena);
            while (rs.next()) {
                DefaultTableModel modelo = (DefaultTableModel) tbApartamentos.getModel();
                modelo.addRow(new Object[]{rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)});

            }
            setChanged();
            notifyObservers("CARGANDO APARTAMENTOS");
        } catch (SQLException e) {
            System.err.println("Error:" + e);
        } finally {
            gestor.cerrar();
        }
    }

    public void verAccesos(String idApartamento) {
        Accesos access = new Accesos();
        access.iniciar(idApartamento);
    }

    public void agregarAcceso(JTable tbAccesos, String idApartamento) throws SQLException {
        String ced = JOptionPane.showInputDialog(null, "Ingrese la cedula del visitante \n DEBE SER MAYOR A 8 Y MENOR A 16 DÍGITOS");

        if (ced != null && ced.length() <= 15 && ced.length() >= 9 && !ced.equals("")) {

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/YYYY");
            String fecha = dtf.format(LocalDateTime.now());

            try {
                CallableStatement cs = gestor.getConexion().prepareCall("{CALL SP_INS_ACC(?,?,?,?)}");
                cs.setString(1, idApartamento);
                cs.setString(2, fecha);
                cs.setString(3, fecha);
                cs.setString(4, ced);
                cs.execute();

                DefaultTableModel modelo = (DefaultTableModel) tbAccesos.getModel();
                modelo.addRow(new Object[]{idAcceso, idApartamento, fecha, "No registrado", ced});
            } catch (SQLException e) {
                System.err.println("Error:" + e);
            } finally {
                gestor.cerrar();
            }

        }
    }
}
