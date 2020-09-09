/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rojeru San CL
 */
public class TableStyleRenderer extends DefaultTableCellRenderer {

    private Component componenete;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {
        componenete = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.       

//     this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setBorder(null);
        componenete.setFont(new Font("Roboto", Font.BOLD, 12));
        componenete.setForeground(new Color(180, 236, 255));
        if (row % 2 == 0) {
//            componenete.setForeground(new Color(1, 170, 45));
            componenete.setBackground(new Color(33, 76, 102));
        } else {
//            componenete.setForeground(new Color(1, 170, 45));
            componenete.setBackground(new Color(50, 66, 82
            ));
        }
        if (isSelected) {
            componenete.setForeground(Color.white);
            componenete.setBackground(new Color(0, 153, 153));

        }
//añadir imagen
//        if (value instanceof JLabel) {
//            JLabel label = (JLabel) value;
//
//            return label;
//        }

        if (value instanceof JButton) {
            JButton bn = (JButton) value;
            bn.setBackground(new Color(33, 76, 102));
            bn.setForeground(new Color(255, 255, 255));
            return (bn);

        }
        
       JCheckBox chec = new JCheckBox();
        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
        
        if(modelo.getValueAt(row, column).getClass().equals(Boolean.class)){
            chec.setSelected(Boolean.parseBoolean(modelo.getValueAt(row, column).toString()));
            return chec;
        }
        
        if (value instanceof JComboBox){
            return (JComboBox)value;
        }
        return componenete;

    }

}
