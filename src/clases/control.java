/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.awt.event.MouseAdapter;
import java.sql.ResultSetMetaData;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.util.Arrays;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.w3c.dom.events.MouseEvent;

/**
 *
 * @author LENOVO
 */
public class control {

    public ResultSet DevolverRegistros(String sq) {
        ResultSet rt = null;
        try {
            Statement st = (conexion.Conectar()).createStatement();
            rt = st.executeQuery(sq);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rt;
    }

    public ResultSet devolverUnaFila(String sql) {
        ResultSet res = null;
        try {
            Statement st = (conexion.Conectar()).createStatement();
            res = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(control.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;

    }

    public void llenarTabla(JTable tabla, String sql, Object[] botones) {
        int numColumnas = llenarEncabezadoTabla(tabla, sql, botones);
        LlenarContenidoTAbla(sql, (DefaultTableModel) tabla.getModel(), numColumnas, botones);
    }

    public void LlenarContenidoTAbla(String sql, DefaultTableModel modelo, int cantidadFila, Object[] botones) {
        LimTabla(modelo);
        try {

            List<Object> fila = new ArrayList<Object>();

            ResultSet rt = DevolverRegistros(sql);

            while (rt.next()) {
                for (int i = 0; i < cantidadFila; i++) {

            
                    if (rt.getString(i + 1).equals("si")) {
                        fila.add(true);

                    } else if (rt.getString(i + 1).equals("no")) {
                        fila.add(false);

                    } else {
                        fila.add(rt.getString(i + 1));
                    }

                }

                modelo.addRow(juntarArrays(combertirArrayList(fila), botones));
                fila.clear();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int llenarEncabezadoTabla(JTable tabla, String sql, Object[] botones) {
        List<String> datos = new ArrayList<>();
        ResultSet res = devolverUnaFila(sql);
        ResultSetMetaData meta;
        int cant = 0;
        try {
            meta = res.getMetaData();
            for (int i = 0; i < meta.getColumnCount(); i++) {
                datos.add(meta.getColumnName(i + 1));

            }

            Object[] btNom = new Object[botones.length];

            for (int i = 0; i < botones.length; i++) {
                btNom[i] = "";

            }

            Object[] d = juntarArrays(combertirArrayList(datos), btNom);

            DefaultTableModel modelo = new DefaultTableModel(d, meta.getColumnCount());
            tabla.setModel(modelo);
            datos.clear();
            cant = meta.getColumnCount();

        } catch (SQLException ex) {
            Logger.getLogger(control.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cant;

    }

    public void LimTabla(DefaultTableModel mdl) {
        while (mdl.getRowCount() > 0) {
            mdl.removeRow(0);
        }
    }

    private Object[] combertirArrayList(List lista) {
        Object[] boton = {new JButton("actualizar"), new JButton("eliminar")};
        Object[] fila = lista.toArray();

        return fila;
    }

    private Object[] juntarArrays(Object[] a1, Object[] a2) {
        Object[] ambos = new Object[a1.length + a2.length];

        System.arraycopy(a1, 0, ambos, 0, a1.length);
        System.arraycopy(a2, 0, ambos, a1.length, a2.length);

        return ambos;
    }

    public void manipularTablasBD(String sql, String[] datos) {

        try {
            PreparedStatement prep = (conexion.Conectar()).prepareStatement(sql);
            for (int i = 0; i < datos.length; i++) {
                prep.setString(i + 1, datos[i]);
            }
            prep.execute();
            System.out.print("se ingreso correctamente");

        } catch (SQLException ex) {

            if (ex.getErrorCode() == 1451) {
                JOptionPane.showMessageDialog(null, " la tabla que deseas eliminar tiene una clave foranea en otras tablas", "alerta", JOptionPane.WARNING_MESSAGE);
            }

            ex.printStackTrace();
        }

    }

    public void LlenarCombo(JComboBox cbo, String Consulta, int pos) {
        cbo.removeAllItems();
        try {
            ResultSet rt = DevolverRegistros(Consulta);
            while (rt.next()) {
                cbo.addItem(rt.getString(pos));
            }
            cbo.setSelectedIndex(-1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }

    public Object getComponente(java.awt.event.MouseEvent evt, JTable tabla) {
        int colum = tabla.columnAtPoint(evt.getPoint());
        int fila = tabla.rowAtPoint(evt.getPoint());
        Object pulsado = tabla.getValueAt(fila, colum);

        return pulsado;

    }

}
