/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Rojeru San CL
 */
public class tableHeaderStyle implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object value, boolean bln, boolean bln1, int row, int column) {
        

        JComponent jcomponent = null;

        if (value instanceof String) {
            jcomponent = new JLabel((String) "   " + value);
//            ((JLabel)jcomponent).setHorizontalAlignment(SwingConstants.CENTER );
            ((JLabel) jcomponent).setSize(30, jcomponent.getWidth());
            ((JLabel) jcomponent).setPreferredSize(new Dimension(3, jcomponent.getWidth() + 20));
        }

        jcomponent.setEnabled(true);
//   jcomponent.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jcomponent.setOpaque(true);
        jcomponent.setBackground(new Color(33, 76, 102));
        jcomponent.setForeground(verde);
        jcomponent.setFont(new Font("Agency FB", Font.BOLD, 20));
        return jcomponent;

    }

    Color verde = new Color(255, 255, 255);
}