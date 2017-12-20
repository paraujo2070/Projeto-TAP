package br.faculdadenovaroma.tap.ecommerce.main;

import br.faculdadenovaroma.tap.ecommerce.entidade.Funcionario;
import br.faculdadenovaroma.tap.ecommerce.entidade.Produto;
import br.faculdadenovaroma.tap.ecommerce.negocio.Fachada;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ListarFuncionario extends javax.swing.JDialog {

    public ListarFuncionario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    ListarFuncionario() {
        initComponents();
        listaFuncionario();
    }

    private void listaFuncionario() {
        try {
            ArrayList<Funcionario> listarFuncionario;

            listarFuncionario = Fachada.getInstancia().listarFuncionario();

            for (int i = 0; i < listarFuncionario.size(); i++) {

                DefaultTableModel listaFuncionario = (DefaultTableModel) jTableFuncionario.getModel();

                listaFuncionario.addRow(new String[]{listarFuncionario.get(i).getPessoa().getNome(), listarFuncionario.get(i).getPessoa().getCpf(),
                    listarFuncionario.get(i).getPessoa().getCelular(), listarFuncionario.get(i).getPessoa().getEmail()});

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nenhum funcionário encontrado!", "Aviso", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro interno!", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFuncionario = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTableFuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "CPF", "Celular", "E-mail"
            }
        ));
        jScrollPane1.setViewportView(jTableFuncionario);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableFuncionario;
    // End of variables declaration//GEN-END:variables
}
