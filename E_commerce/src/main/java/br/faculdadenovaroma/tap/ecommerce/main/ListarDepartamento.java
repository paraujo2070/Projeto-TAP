package br.faculdadenovaroma.tap.ecommerce.main;

import br.faculdadenovaroma.tap.ecommerce.entidade.Departamento;
import br.faculdadenovaroma.tap.ecommerce.negocio.Fachada;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ListarDepartamento extends javax.swing.JDialog {

    public ListarDepartamento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    ListarDepartamento() {
        initComponents();
        listaDepartamento();
    }

    private void listaDepartamento() {
        try {
            ArrayList<Departamento> listarDepartamento = Fachada.getInstancia().listarDepartamento();

            for (int i = 0; i < listarDepartamento.size(); i++) {

                DefaultTableModel listaDepartamento = (DefaultTableModel) jTableDepartementos.getModel();

                listaDepartamento.addRow(new String[]{listarDepartamento.get(i).getNome()});
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nenhum departamento encontrado!", "Aviso", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro interno!", "Aviso", JOptionPane.ERROR_MESSAGE);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDepartementos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listar Departamento");

        jTableDepartementos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome"
            }
        ));
        jScrollPane1.setViewportView(jTableDepartementos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 3, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableDepartementos;
    // End of variables declaration//GEN-END:variables
}
