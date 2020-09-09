/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author LENOVO
 */
public class botonesTabla {

    private String nombre = "";
    private int fila = -1;

    public botonesTabla(java.awt.event.MouseEvent evt, JTable tabla) {
        int colum = tabla.columnAtPoint(evt.getPoint());
        fila = tabla.rowAtPoint(evt.getPoint());

        Object pulsado = tabla.getValueAt(fila, colum);
        if (pulsado instanceof JButton) {

            nombre = (((JButton) pulsado).getName());

        }

    }

    public String getNombre() {
        return nombre;

    }

    public int getFila() {
        return fila;
    }

}
