package br.faculdadenovaroma.tap.ecommerce.main;

import br.faculdadenovaroma.tap.ecommerce.entidade.Fornecedor;
import br.faculdadenovaroma.tap.ecommerce.negocio.Fachada;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ListarFornecedor extends javax.swing.JDialog {

    public ListarFornecedor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    ListarFornecedor() {
        initComponents();
        listarFornecedor();
    }

    
    
    private void listarFornecedor(){
         try {
            ArrayList<Fornecedor> listarFornecedor = Fachada.getInstancia().listarFornecedor();

            for (int i = 0; i < listarFornecedor.size(); i++) {

                DefaultTableModel listaFornecedor = (DefaultTableModel) jTableFornecedor.getModel();

                listaFornecedor.addRow(new String[]{listarFornecedor.get(i).getNome(), listarFornecedor.get(i).getSigla()
                , listarFornecedor.get(i).getCnpj(), listarFornecedor.get(i).getNomeRepresentante(), listarFornecedor.get(i).getTelefone()
                , listarFornecedor.get(i).getEmail()});
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nenhum Fornecedor encontrado!", "Aviso", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro interno!", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFornecedor = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTableFornecedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Sigla", "CNPJ", "Nome do representante", "Telefone", "Email"
            }
        ));
        jScrollPane1.setViewportView(jTableFornecedor);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableFornecedor;
    // End of variables declaration//GEN-END:variables
}
