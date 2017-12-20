package br.faculdadenovaroma.tap.ecommerce.main;

import br.faculdadenovaroma.tap.ecommerce.entidade.Funcionario;
import br.faculdadenovaroma.tap.ecommerce.entidade.Produto;
import br.faculdadenovaroma.tap.ecommerce.negocio.Fachada;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ListarProduto extends javax.swing.JDialog {

    public ListarProduto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    ListarProduto() {
        initComponents();
        listarProdutos();
    }

    private void listarProdutos() {
        try {
            ArrayList<Produto> listarProduto = Fachada.getInstancia().listarProduto();

            for (int i = 0; i < listarProduto.size(); i++) {

                DefaultTableModel listaProduto = (DefaultTableModel) jTableProduto.getModel();

                listaProduto.addRow(new String[]{listarProduto.get(i).getNome(), listarProduto.get(i).getDepartamento().getNome(),
                    listarProduto.get(i).getInformacoes().getMarca()});

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nenhum produto encontrado!", "Aviso", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro interno!", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProduto = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTableProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Nome do departamento", "marca"
            }
        ));
        jScrollPane1.setViewportView(jTableProduto);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProduto;
    // End of variables declaration//GEN-END:variables
}
