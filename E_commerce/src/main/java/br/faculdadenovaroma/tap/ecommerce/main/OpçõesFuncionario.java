package br.faculdadenovaroma.tap.ecommerce.main;

import br.faculdadenovaroma.tap.ecommerce.entidade.Fornecedor;
import br.faculdadenovaroma.tap.ecommerce.entidade.Produto;
import br.faculdadenovaroma.tap.ecommerce.negocio.Fachada;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class OpçõesFuncionario extends javax.swing.JDialog {

    public OpçõesFuncionario() {
        initComponents();
        listarFornecedor();
        listaProdutos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFornecedores = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProdutos = new javax.swing.JTable();
        jMenuBarDoFuncionario = new javax.swing.JMenuBar();
        jMenuCadastra = new javax.swing.JMenu();
        jMenuItemCadasrarProduto = new javax.swing.JMenuItem();
        jMenuItemCadastarFuncionario = new javax.swing.JMenuItem();
        jMenuItemCadastrarDepartamento = new javax.swing.JMenuItem();
        jMenuItemCadastrarFornecedor = new javax.swing.JMenuItem();
        jMenu2Remover = new javax.swing.JMenu();
        jMenuItemRemoverProduto = new javax.swing.JMenuItem();
        jMenuItemRemoverFuncionario = new javax.swing.JMenuItem();
        jMenuItemRemoverDepartamento = new javax.swing.JMenuItem();
        jMenuItemRemoverFornecedor = new javax.swing.JMenuItem();
        jMenuAtualizar = new javax.swing.JMenu();
        jMenuItemAtualizarFuncionario = new javax.swing.JMenuItem();
        jMenuItemAtualizarProduto = new javax.swing.JMenuItem();
        jMenuItemAtualizarDepartamento = new javax.swing.JMenuItem();
        jMenuItemAtualizarFornecedor = new javax.swing.JMenuItem();
        jMenuListar = new javax.swing.JMenu();
        jMenuItemListarFuncionario = new javax.swing.JMenuItem();
        jMenuItemListarProdutos = new javax.swing.JMenuItem();
        jMenuItemListarDepartamento = new javax.swing.JMenuItem();
        jMenuItemListarFornecedor = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTableFornecedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Nome Representante"
            }
        ));
        jScrollPane1.setViewportView(jTableFornecedores);

        jTableProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Quantidade"
            }
        ));
        jScrollPane2.setViewportView(jTableProdutos);

        jMenuCadastra.setText("Cadastra");

        jMenuItemCadasrarProduto.setText("Produto");
        jMenuItemCadasrarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadasrarProdutoActionPerformed(evt);
            }
        });
        jMenuCadastra.add(jMenuItemCadasrarProduto);

        jMenuItemCadastarFuncionario.setText("Funcionário");
        jMenuItemCadastarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastarFuncionarioActionPerformed(evt);
            }
        });
        jMenuCadastra.add(jMenuItemCadastarFuncionario);

        jMenuItemCadastrarDepartamento.setText("Departamento");
        jMenuItemCadastrarDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastrarDepartamentoActionPerformed(evt);
            }
        });
        jMenuCadastra.add(jMenuItemCadastrarDepartamento);

        jMenuItemCadastrarFornecedor.setText("Fornecedor");
        jMenuItemCadastrarFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastrarFornecedorActionPerformed(evt);
            }
        });
        jMenuCadastra.add(jMenuItemCadastrarFornecedor);

        jMenuBarDoFuncionario.add(jMenuCadastra);

        jMenu2Remover.setText("Remover");

        jMenuItemRemoverProduto.setText("Produto");
        jMenuItemRemoverProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRemoverProdutoActionPerformed(evt);
            }
        });
        jMenu2Remover.add(jMenuItemRemoverProduto);

        jMenuItemRemoverFuncionario.setText("Funcionário");
        jMenuItemRemoverFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRemoverFuncionarioActionPerformed(evt);
            }
        });
        jMenu2Remover.add(jMenuItemRemoverFuncionario);

        jMenuItemRemoverDepartamento.setText("Departamento");
        jMenuItemRemoverDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRemoverDepartamentoActionPerformed(evt);
            }
        });
        jMenu2Remover.add(jMenuItemRemoverDepartamento);

        jMenuItemRemoverFornecedor.setText("Fornecedor");
        jMenuItemRemoverFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRemoverFornecedorActionPerformed(evt);
            }
        });
        jMenu2Remover.add(jMenuItemRemoverFornecedor);

        jMenuBarDoFuncionario.add(jMenu2Remover);

        jMenuAtualizar.setText("Atualizar");

        jMenuItemAtualizarFuncionario.setText("Funcionário");
        jMenuItemAtualizarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAtualizarFuncionarioActionPerformed(evt);
            }
        });
        jMenuAtualizar.add(jMenuItemAtualizarFuncionario);

        jMenuItemAtualizarProduto.setText("Produto");
        jMenuItemAtualizarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAtualizarProdutoActionPerformed(evt);
            }
        });
        jMenuAtualizar.add(jMenuItemAtualizarProduto);

        jMenuItemAtualizarDepartamento.setText("Departamento");
        jMenuItemAtualizarDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAtualizarDepartamentoActionPerformed(evt);
            }
        });
        jMenuAtualizar.add(jMenuItemAtualizarDepartamento);

        jMenuItemAtualizarFornecedor.setText("Fornecedor");
        jMenuItemAtualizarFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAtualizarFornecedorActionPerformed(evt);
            }
        });
        jMenuAtualizar.add(jMenuItemAtualizarFornecedor);

        jMenuBarDoFuncionario.add(jMenuAtualizar);

        jMenuListar.setText("Listar");

        jMenuItemListarFuncionario.setText("Funcionário");
        jMenuItemListarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListarFuncionarioActionPerformed(evt);
            }
        });
        jMenuListar.add(jMenuItemListarFuncionario);

        jMenuItemListarProdutos.setText("Produto");
        jMenuItemListarProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListarProdutosActionPerformed(evt);
            }
        });
        jMenuListar.add(jMenuItemListarProdutos);

        jMenuItemListarDepartamento.setText("Departamento");
        jMenuItemListarDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListarDepartamentoActionPerformed(evt);
            }
        });
        jMenuListar.add(jMenuItemListarDepartamento);

        jMenuItemListarFornecedor.setText("Fornecedor");
        jMenuItemListarFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListarFornecedorActionPerformed(evt);
            }
        });
        jMenuListar.add(jMenuItemListarFornecedor);

        jMenuBarDoFuncionario.add(jMenuListar);

        setJMenuBar(jMenuBarDoFuncionario);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemCadasrarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadasrarProdutoActionPerformed
        CadastraProduto cadastrarProduto = new CadastraProduto();
        cadastrarProduto.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadasrarProdutoActionPerformed

    private void jMenuItemCadastarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastarFuncionarioActionPerformed
        CadastraFuncionario cadastrarFuncionario = new CadastraFuncionario();
        cadastrarFuncionario.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadastarFuncionarioActionPerformed

    private void jMenuItemCadastrarDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastrarDepartamentoActionPerformed
        CadastraDepartamento cadastrarDepartamento = new CadastraDepartamento();
        cadastrarDepartamento.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadastrarDepartamentoActionPerformed

    private void jMenuItemCadastrarFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastrarFornecedorActionPerformed
        CadastraDepartamento cadastraFonecedor = new CadastraDepartamento();
        cadastraFonecedor.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadastrarFornecedorActionPerformed

    private void jMenuItemRemoverProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRemoverProdutoActionPerformed
        ExcluirProduto removerProduto = new ExcluirProduto();
        removerProduto.setVisible(true);
    }//GEN-LAST:event_jMenuItemRemoverProdutoActionPerformed

    private void jMenuItemRemoverFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRemoverFuncionarioActionPerformed
        ExcluirFuncionario removerFuncionario = new ExcluirFuncionario();
        removerFuncionario.setVisible(true);
    }//GEN-LAST:event_jMenuItemRemoverFuncionarioActionPerformed

    private void jMenuItemRemoverDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRemoverDepartamentoActionPerformed
        ExcluirDepartamento excluirDepartamento = new ExcluirDepartamento();
        excluirDepartamento.setVisible(true);
    }//GEN-LAST:event_jMenuItemRemoverDepartamentoActionPerformed

    private void jMenuItemRemoverFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRemoverFornecedorActionPerformed
        ExcluirFornecedor excluirFornecedor = new ExcluirFornecedor();
        excluirFornecedor.setVisible(true);
    }//GEN-LAST:event_jMenuItemRemoverFornecedorActionPerformed

    private void jMenuItemAtualizarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAtualizarFuncionarioActionPerformed
        AlterarFuncionario alterarFuncionario = new AlterarFuncionario();
        alterarFuncionario.setVisible(true);
    }//GEN-LAST:event_jMenuItemAtualizarFuncionarioActionPerformed

    private void jMenuItemAtualizarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAtualizarProdutoActionPerformed
        AlterarProduto alterarProduto = new AlterarProduto();
        alterarProduto.setVisible(true);
    }//GEN-LAST:event_jMenuItemAtualizarProdutoActionPerformed

    private void jMenuItemAtualizarDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAtualizarDepartamentoActionPerformed
        AlterarDepartamento alterarDepartamento = new AlterarDepartamento();
        alterarDepartamento.setVisible(true);
    }//GEN-LAST:event_jMenuItemAtualizarDepartamentoActionPerformed

    private void jMenuItemAtualizarFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAtualizarFornecedorActionPerformed
        AlterarFornecedor alterarFornecedro = new AlterarFornecedor();
        alterarFornecedro.setVisible(true);
    }//GEN-LAST:event_jMenuItemAtualizarFornecedorActionPerformed

    private void jMenuItemListarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListarFuncionarioActionPerformed
        ListarFuncionario listarFincionario = new ListarFuncionario();
        listarFincionario.setVisible(true);
    }//GEN-LAST:event_jMenuItemListarFuncionarioActionPerformed

    private void jMenuItemListarProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListarProdutosActionPerformed
        ListarProduto listarproduto = new ListarProduto();
        listarproduto.setVisible(true);
    }//GEN-LAST:event_jMenuItemListarProdutosActionPerformed

    private void jMenuItemListarDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListarDepartamentoActionPerformed
        ListarDepartamento listarDepartamento = new ListarDepartamento();
        listarDepartamento.setVisible(true);
    }//GEN-LAST:event_jMenuItemListarDepartamentoActionPerformed

    private void jMenuItemListarFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListarFornecedorActionPerformed
        ListarFornecedor listarFornecedro = new ListarFornecedor();
        listarFornecedro.setVisible(true);
    }//GEN-LAST:event_jMenuItemListarFornecedorActionPerformed

    private void listarFornecedor() {
        try {
            ArrayList<Fornecedor> listaFornecedor = Fachada.getInstancia().listarFornecedor();

            for (int i = 0; i < listaFornecedor.size(); i++) {
                DefaultTableModel listarFornecedores = (DefaultTableModel) jTableFornecedores.getModel();

                listarFornecedores.addRow(new String[]{listaFornecedor.get(i).getNome(),
                    listaFornecedor.get(i).getNomeRepresentante()});
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nenhum fornecedor encontrado!", "Aviso", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro interno!", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void listaProdutos() {
        try {
            ArrayList<Produto> listarProdutos = Fachada.getInstancia().listarProduto();

            for (int i = 0; i < listarProdutos.size(); i++) {
                DefaultTableModel listaProdutos = (DefaultTableModel) jTableProdutos.getModel();

                listaProdutos.addRow(new String[]{listarProdutos.get(i).getNome(),
                    String.valueOf(listarProdutos.get(i).getQtdEstoque())});

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nenhum produto encontrado!", "Aviso", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro interno!", "Aviso", JOptionPane.ERROR_MESSAGE);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu2Remover;
    private javax.swing.JMenu jMenuAtualizar;
    private javax.swing.JMenuBar jMenuBarDoFuncionario;
    private javax.swing.JMenu jMenuCadastra;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItemAtualizarDepartamento;
    private javax.swing.JMenuItem jMenuItemAtualizarFornecedor;
    private javax.swing.JMenuItem jMenuItemAtualizarFuncionario;
    private javax.swing.JMenuItem jMenuItemAtualizarProduto;
    private javax.swing.JMenuItem jMenuItemCadasrarProduto;
    private javax.swing.JMenuItem jMenuItemCadastarFuncionario;
    private javax.swing.JMenuItem jMenuItemCadastrarDepartamento;
    private javax.swing.JMenuItem jMenuItemCadastrarFornecedor;
    private javax.swing.JMenuItem jMenuItemListarDepartamento;
    private javax.swing.JMenuItem jMenuItemListarFornecedor;
    private javax.swing.JMenuItem jMenuItemListarFuncionario;
    private javax.swing.JMenuItem jMenuItemListarProdutos;
    private javax.swing.JMenuItem jMenuItemRemoverDepartamento;
    private javax.swing.JMenuItem jMenuItemRemoverFornecedor;
    private javax.swing.JMenuItem jMenuItemRemoverFuncionario;
    private javax.swing.JMenuItem jMenuItemRemoverProduto;
    private javax.swing.JMenu jMenuListar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableFornecedores;
    private javax.swing.JTable jTableProdutos;
    // End of variables declaration//GEN-END:variables
}
