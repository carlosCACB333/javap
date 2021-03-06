/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import clases.TableStyleRenderer;
import clases.botonesTabla;
import clases.control;
import clases.tableHeaderStyle;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class alumnos extends javax.swing.JDialog {

    control control = new control();
    JButton eliminar = new JButton("eliminar");
    JButton actualizar = new JButton("actualizar");
    JComboBox esc = new JComboBox();

    /**
     * Creates new form alumnos
     */
    public alumnos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(33, 76, 102));

        control.LlenarCombo(jComboBox1, "select facultad from facultades", 1);
        control.LlenarCombo(esc, "select escuela from escuelas", 1);
        jComboBox2.removeAllItems();

//        eliminar.addMouseListener(new MouseAdapter() {
//            public void mouseClicked(MouseEvent e){
//                JOptionPane.showMessageDialog(null, "holaaaaaaaaa");
//            }
//        });
        actualizar.setName("actualizar");
        eliminar.setName("eliminar");

        control.llenarTabla(jTable1, "select alumnos.id,nombres,apellidos,codigo,email,telefono,escuela,condicionBeneficiado from alumnos inner join escuelas on alumnos.escuelas_id=escuelas.id", new Object[]{actualizar, eliminar});

        jTable1.getTableHeader().setDefaultRenderer(new tableHeaderStyle());
        jTable1.setDefaultRenderer(Object.class, new TableStyleRenderer());
        jTable1.setRowHeight(30);
        (jTable1.getColumnModel().getColumn(7)).setCellEditor(new DefaultCellEditor(new JCheckBox()));
        (jTable1.getColumnModel().getColumn(6)).setCellEditor(new DefaultCellEditor(esc));
    

    }

    public void actualizar() {
        String nombre = jTextField1.getText().trim();
        String apell = jTextField2.getText().trim();
        String cod = jTextField3.getText().trim();
        String correo = jTextField4.getText().trim();
        String tel = jTextField5.getText().trim();
        String condicion = null;

        if (jRadioButton1.isSelected()) {
            condicion = "si";

        } else if (jRadioButton2.isSelected()) {
            condicion = "no";

        }

        if (nombre.length() != 0 && apell.length() != 0 && cod.length() != 0 && correo.length() != 0 && tel.length() != 0 && condicion != null && jComboBox2.getSelectedIndex() != -1) {

            if (jTable1.getSelectedRowCount() != 0) {
                String escuela = jComboBox2.getSelectedItem().toString();
                String alumnos_id = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
                String datos[] = {nombre, apell, cod, correo, tel, escuela, condicion, alumnos_id};

                control.manipularTablasBD("update alumnos set nombres=?,apellidos=?,codigo=?,email=?,telefono=?,escuelas_id=(select id from escuelas where escuela=?),condicionBeneficiado=? where id=?", datos);
                control.llenarTabla(jTable1, "select alumnos.id,nombres,apellidos,codigo,email,telefono,escuela,condicionBeneficiado from alumnos inner join escuelas on alumnos.escuelas_id=escuelas.id", new Object[]{actualizar, eliminar});
            } else {
                JOptionPane.showMessageDialog(this, "selecionar la fila que desea actualizar");

            }
        } else {
            JOptionPane.showMessageDialog(this, "todo los campos son requeridos. verifiquie y intente de nuevo");
        }

    }

    public void eliminar() {
        if (jTable1.getSelectedRowCount() != 0) {
            String[] datos = {jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString()};
            control.manipularTablasBD("delete from alumnos where id =?", datos);
            control.llenarTabla(jTable1, "select alumnos.id,nombres,apellidos,codigo,email,telefono,escuela,condicionBeneficiado from alumnos inner join escuelas on alumnos.escuelas_id=escuelas.id", new Object[]{actualizar, eliminar});
        } else {
            JOptionPane.showMessageDialog(this, "selecionar la fila que desea eliminar");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(33, 76, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "datos de los alumnos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setBackground(new java.awt.Color(33, 76, 102));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("nombres");

        jLabel2.setBackground(new java.awt.Color(33, 76, 102));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("apellidos");

        jLabel3.setBackground(new java.awt.Color(33, 76, 102));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("codigo");

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("correo");

        jLabel5.setBackground(new java.awt.Color(33, 76, 102));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("telefono");

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("beneficiario");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setText("no beneficiario");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(33, 76, 102));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("condicion del estudiante");

        jLabel7.setBackground(new java.awt.Color(33, 76, 102));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("escuela");

        jLabel8.setBackground(new java.awt.Color(33, 76, 102));
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("facultad");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel6)
                        .addGap(63, 63, 63)
                        .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(46, 46, 46)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, 383, Short.MAX_VALUE))
                                .addGap(46, 46, 46)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel2)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addGap(10, 10, 10))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jTable1ComponentAdded(evt);
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jTable1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTable1PropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setBackground(new java.awt.Color(33, 76, 102));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("insertar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(33, 76, 102));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("actualizar");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(33, 76, 102));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("borrar");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 965, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
        if (jComboBox1.getSelectedIndex() != -1) {
            control.LlenarCombo(jComboBox2, "select escuela from escuelas where facultades_id=(select id from facultades where facultad='" + jComboBox1.getSelectedItem().toString() + "')", 1);
           
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        String nombre = jTextField1.getText().trim();
        String apell = jTextField2.getText().trim();
        String cod = jTextField3.getText().trim();
        String correo = jTextField4.getText().trim();
        String tel = jTextField5.getText().trim();
        String condicion = null;

        if (jRadioButton1.isSelected()) {
            condicion = "si";

        } else if (jRadioButton2.isSelected()) {
            condicion = "no";

        }

        if (nombre.length() != 0 && apell.length() != 0 && cod.length() != 0 && correo.length() != 0 && tel.length() != 0 && condicion != null && jComboBox2.getSelectedIndex() != -1) {
            String escuela = jComboBox2.getSelectedItem().toString();
            String datos[] = {nombre, apell, cod, correo, tel, escuela, condicion};

            control.manipularTablasBD("insert into alumnos values(null,?,?,?,?,?,(select id from escuelas where escuela =?),?)", datos);

            //  control.llenarTabla(jTable1, "select alumnos.id,nombres,apellidos,codigo,email,telefono,escuela,condicionBeneficiado from alumnos inner join escuelas on alumnos.escuelas_id=escuelas.id");
        } else {
            JOptionPane.showMessageDialog(this, "todo los campos son requeridos. verifiquie y intente de nuevo");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        actualizar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        eliminar();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTable1PropertyChange
        // TODO add your handling code here:


    }//GEN-LAST:event_jTable1PropertyChange

    private void jTable1ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jTable1ComponentAdded
        // TODO add your handling code here:

    }//GEN-LAST:event_jTable1ComponentAdded

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        // TODO add your handling code here:
        String nombre = jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString();
        String apell = jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString();
        String cod = jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString();
        String correo = jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString();
        String tel = jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString();

        jTextField1.setText(nombre);
        jTextField2.setText(apell);
        jTextField3.setText(cod);
        jTextField4.setText(correo);
        jTextField5.setText(tel);
        try {
            ResultSet f = control.devolverUnaFila("select facultad from facultades inner join escuelas on facultades.id=escuelas.facultades_id where escuela='" + jTable1.getValueAt(jTable1.getSelectedRow(), 6).toString() + "' ");
            f.next();
            jComboBox1.setSelectedItem(f.getString(1));
            jComboBox2.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(), 6));
        } catch (SQLException ex) {
            Logger.getLogger(alumnos.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (jTable1.getValueAt(jTable1.getSelectedRow(), 7).toString().equals("true")) {
            jRadioButton1.setSelected(true);
        } else {
            jRadioButton2.setSelected(true);
        }

        if (jTable1.getSelectedRowCount() != 0) {
            jButton2.setEnabled(true);
            jButton3.setEnabled(true);
        } else {
            jButton2.setEnabled(false);
            jButton3.setEnabled(false);
        }

        Object comp = control.getComponente(evt, jTable1);
        if (comp instanceof JButton) {
            if (((JButton) comp).getName().equals("actualizar")) {
                int res = JOptionPane.showConfirmDialog((JButton) comp, "¿desea actualizar la fila seleccionada?");
                if (res == 0) {//codigo para actualizar
                    String condicion = "no";
                    System.out.println(jTable1.getValueAt(jTable1.getSelectedRow(), 7).toString());
                    if (jTable1.getValueAt(jTable1.getSelectedRow(), 7).toString() == "true") {
                        condicion = "si";

                    } else if (jTable1.getValueAt(jTable1.getSelectedRow(), 7).toString() == "false") {
                        condicion = "no";

                    }

                    String datos[] = {jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString(),
                        jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString(),
                        jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString(),
                        jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString(),
                        jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString(),
                        jTable1.getValueAt(jTable1.getSelectedRow(), 6).toString(),
                        condicion, jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString(),};

                    control.manipularTablasBD("update alumnos set nombres=?,apellidos=?,codigo=?,email=?,telefono=?,escuelas_id=(select id from escuelas where escuela=?),condicionBeneficiado=? where id=?", datos);
                    control.llenarTabla(jTable1, "select alumnos.id,nombres,apellidos,codigo,email,telefono,escuela,condicionBeneficiado from alumnos inner join escuelas on alumnos.escuelas_id=escuelas.id", new Object[]{actualizar, eliminar});
                    (jTable1.getColumnModel().getColumn(7)).setCellEditor(new DefaultCellEditor(new JCheckBox()));
                    (jTable1.getColumnModel().getColumn(6)).setCellEditor(new DefaultCellEditor(esc));
                }
            } else if (((JButton) comp).getName().equals("eliminar")) {
                int res = JOptionPane.showConfirmDialog((JButton) comp, "¿desea eliminar la fila seleccionada?");
                if (res == 0) {//codigo eliminar

                }

            }
        }

    }//GEN-LAST:event_jTable1MousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                alumnos dialog = new alumnos(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables

}
