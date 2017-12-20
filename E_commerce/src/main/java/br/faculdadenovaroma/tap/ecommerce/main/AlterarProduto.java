package br.faculdadenovaroma.tap.ecommerce.main;

public class AlterarProduto extends javax.swing.JDialog {

    public AlterarProduto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    AlterarProduto() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNomeProduto = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabelDescrição = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelFornecedor = new javax.swing.JLabel();
        jComboBoxFornecedor = new javax.swing.JComboBox<>();
        jLabelTextoInformações = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDescrição = new javax.swing.JTextArea();
        jLabelTipo = new javax.swing.JLabel();
        jTextFieldTipo = new javax.swing.JTextField();
        jLabelProcessador = new javax.swing.JLabel();
        jTextFieldProcessador = new javax.swing.JTextField();
        jLabelTamanho = new javax.swing.JLabel();
        jTextFieldTamanho = new javax.swing.JTextField();
        jLabelTela = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabelMegaPixels = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabelMemoria = new javax.swing.JLabel();
        jTextFieldMemoria = new javax.swing.JTextField();
        jLabelPlacaGrafica = new javax.swing.JLabel();
        jTextFieldPlacaGrafica = new javax.swing.JTextField();
        jLabelArmazenamento = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabelVelocidade = new javax.swing.JLabel();
        jTextFieldVelocidade = new javax.swing.JTextField();
        jLabelPotencia = new javax.swing.JLabel();
        jTextFieldPotencia = new javax.swing.JTextField();
        jLabelMarca = new javax.swing.JLabel();
        jTextFieldMarca = new javax.swing.JTextField();
        jButtonAlterar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelNomeProduto.setText("Nome do produto");

        jLabelDescrição.setText("Descrição");

        jLabelFornecedor.setText("Fornecedor");

        jComboBoxFornecedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabelTextoInformações.setText("Informações gerais do produto");

        jTextAreaDescrição.setColumns(20);
        jTextAreaDescrição.setRows(5);
        jScrollPane1.setViewportView(jTextAreaDescrição);

        jLabelTipo.setText("Tipo");

        jLabelProcessador.setText("Processador");

        jLabelTamanho.setText("Tamanho");

        jLabelTela.setText("Tela");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabelMegaPixels.setText("Mega Pixels");

        jTextField1.setText("jTextField1");

        jLabelMemoria.setText("Memoria");

        jLabelPlacaGrafica.setText("Placa Grafica");

        jLabelArmazenamento.setText("Armazenamento");

        jLabelVelocidade.setText("Velocidade");

        jLabelPotencia.setText("Potencia");

        jLabelMarca.setText("Marca");

        jButtonAlterar.setText("Salvar Alterações");

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelNomeProduto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNome)
                        .addGap(124, 124, 124)
                        .addComponent(jLabelFornecedor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxFornecedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelPotencia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldPotencia, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelPlacaGrafica)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldPlacaGrafica))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelDescrição)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1)
                                .addGap(62, 62, 62)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelMarca)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelArmazenamento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelTipo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldTipo))
                            .addComponent(jLabelTextoInformações)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelProcessador)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldProcessador))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelTamanho)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldTamanho)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelTela)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelMegaPixels)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelMemoria)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldMemoria))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelVelocidade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldVelocidade))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(507, 507, 507)
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldNome)
                        .addComponent(jLabelFornecedor)
                        .addComponent(jComboBoxFornecedor))
                    .addComponent(jLabelNomeProduto))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTextoInformações)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTipo)
                            .addComponent(jTextFieldTipo)
                            .addComponent(jLabelTela)
                            .addComponent(jComboBox1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelProcessador)
                            .addComponent(jTextFieldProcessador)
                            .addComponent(jLabelMegaPixels)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTamanho)
                            .addComponent(jTextFieldTamanho)
                            .addComponent(jLabelMemoria)
                            .addComponent(jTextFieldMemoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jLabelDescrição))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelPlacaGrafica)
                            .addComponent(jTextFieldPlacaGrafica)
                            .addComponent(jLabelArmazenamento)
                            .addComponent(jTextField2)
                            .addComponent(jLabelVelocidade)
                            .addComponent(jTextFieldVelocidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelPotencia)
                            .addComponent(jTextFieldPotencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelMarca)
                            .addComponent(jTextFieldMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAlterar)
                    .addComponent(jButtonCancelar))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBoxFornecedor;
    private javax.swing.JLabel jLabelArmazenamento;
    private javax.swing.JLabel jLabelDescrição;
    private javax.swing.JLabel jLabelFornecedor;
    private javax.swing.JLabel jLabelMarca;
    private javax.swing.JLabel jLabelMegaPixels;
    private javax.swing.JLabel jLabelMemoria;
    private javax.swing.JLabel jLabelNomeProduto;
    private javax.swing.JLabel jLabelPlacaGrafica;
    private javax.swing.JLabel jLabelPotencia;
    private javax.swing.JLabel jLabelProcessador;
    private javax.swing.JLabel jLabelTamanho;
    private javax.swing.JLabel jLabelTela;
    private javax.swing.JLabel jLabelTextoInformações;
    private javax.swing.JLabel jLabelTipo;
    private javax.swing.JLabel jLabelVelocidade;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextAreaDescrição;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextFieldMarca;
    private javax.swing.JTextField jTextFieldMemoria;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldPlacaGrafica;
    private javax.swing.JTextField jTextFieldPotencia;
    private javax.swing.JTextField jTextFieldProcessador;
    private javax.swing.JTextField jTextFieldTamanho;
    private javax.swing.JTextField jTextFieldTipo;
    private javax.swing.JTextField jTextFieldVelocidade;
    // End of variables declaration//GEN-END:variables
}
