/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import Conexion.GestorBD;
import Vistas.agregarAparta;
import Vistas.condominios;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Observable;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hilla
 */
public class Apartamentos extends Observable {

    private GestorBD gestor = null;

    public Apartamentos() {
        this.gestor = new GestorBD();
    }

    public void verFilial(int idFilial) {
        condominios VistaCondominio = new condominios();
        VistaCondominio.iniciar(idFilial);

    }

    public void verAgregarAparta() {
        agregarAparta newframe = new agregarAparta();
        newframe.setVisible(true);
        newframe.setResizable(false);
        newframe.setLocationRelativeTo(null);

    }

    public void cargarFilial(int idFilial, JTextField cantApartamentos, JTextField cantonFilial, JTextField cedJuridica, JTextField distritoFilial, JTextField nombreFilial, JTextField provinciaFilial) {
        try {
            String cadena = "SELECT * FROM FILIALES WHERE ID_FILIAL= " + idFilial;
            Statement st = gestor.getConexion().createStatement();
            ResultSet rs = st.executeQuery(cadena);
            while (rs.next()) {
                cedJuridica.setText(rs.getString(1));
                nombreFilial.setText(rs.getString(2));
                cantApartamentos.setText(rs.getInt(3) + "");
                provinciaFilial.setText(rs.getString(4));
                cantonFilial.setText(rs.getString(5));
                distritoFilial.setText(rs.getString(6));

            }
            setChanged();
            notifyObservers("CARGANDO FILIALES");
        } catch (SQLException e) {
            System.err.println("Error:" + e);
        } finally {
            gestor.cerrar();
        }
    }

    public void cargarApartamentos(int idFilial, JTable tabla) {
        try {
            String cadena = "SELECT * FROM APARTAMENTOS WHERE ID_FILIAL= " + idFilial;
            Statement st = gestor.getConexion().createStatement();
            ResultSet rs = st.executeQuery(cadena);
            while (rs.next()) {
                DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
                modelo.addRow(new Object[]{rs.getString("ID_CASA"), rs.getString("ID_DUEÑO")});

            }
            setChanged();
            notifyObservers("CARGANDO APARTAMENTOS");
        } catch (SQLException e) {
            System.err.println("Error:" + e);
        } finally {
            gestor.cerrar();
        }
    }

    public void agregarAparta(JTable tabla, int idFilial) {
        String id = JOptionPane.showInputDialog(null, "Digite el id del apartamento");
        if (id != null && !id.isBlank() && !id.isEmpty()) {
                String dueno = JOptionPane.showInputDialog(null, "Digite el dueño del apartamento");
                if (dueno != null && !dueno.isBlank() && !dueno.isEmpty()) {
                    try {
                        CallableStatement pst = gestor.getConexion().prepareCall("{CALL SP_INS_APAR(?, ?, ?, ?)}");
                        pst.setString(1, id);
                        pst.setInt(2, idFilial);
                        pst.setString(3, dueno);
                        pst.setString(4, "S");
                        pst.execute();
                        
                        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
                        modelo.addRow(new Object[]{id, idFilial, dueno});

                        setChanged();
                        notifyObservers("CARGANDO TABLA APARTAMENTOS");
                    } catch (SQLException e) {
                        System.err.println("Error:" + e);
                    } finally {
                        gestor.cerrar();
                    }

                }
            

        }
    }

}
