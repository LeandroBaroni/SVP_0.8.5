/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Itinerarios;

import Dao.Class.Cidade;
import Dao.Class.Funcionario;
import Dao.Class.Linha;
import Dao.Controller.CidadeControlador;
import Dao.Controller.FormatNum;
import Dao.Controller.FuncionarioControlador;
import Dao.Controller.LinhaControlador;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author Leandro Baroni
 */

public class CriarPrefixo extends javax.swing.JDialog {
    Funcionario F = new Funcionario();
    FuncionarioControlador FC = new FuncionarioControlador();
    CidadeControlador CC = new CidadeControlador();
    Cidade C1 = new Cidade();
    Cidade C2 = new Cidade();
    Linha L = new Linha();
    LinhaControlador LC = new LinhaControlador();
    
    DecimalFormat df = new DecimalFormat("#0.00");
    public String usuario;
    
    /**
     * Creates new form CriarPrefixo
     */
    
    public CriarPrefixo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        txtTarifa.setDocument(new FormatNum());
        txtTaxaRod.setDocument(new FormatNum());
        txtPedagio.setDocument(new FormatNum());
        txtPrefixo.setDocument(new FormatNum());
    }

    public void setValores(){
        setUsuario();
        refresh();
        setCidades();
    }
    public void setCidades(){
        for (Cidade c: CC.buscarCods()){
            cbCod1.addItem(Integer.toString(c.getCodigo()));
            cbCod2.addItem(Integer.toString(c.getCodigo()));
            cbCid1.addItem(c.getCidade());
            cbCid2.addItem(c.getCidade());
        }
        double rTar = L.getTarifa();
        double rTax = L.getTaxaRod();
        double rPed = L.getPedagio();
        txtTarifa.setText(String.valueOf(rTar).format("%.2f", rTar));
        txtTaxaRod.setText(String.valueOf(rTax).format("%.2f", rTax));
        txtPedagio.setText(String.valueOf(rPed).format("%.2f", rPed));
    }
    public void setUsuario(){
        F = FC.buscar(usuario);
    }
    public void refresh(){
        txtPrefixo.setText(null);
        txtTarifa.setText(null);
        txtPedagio.setText(null);
        txtTaxaRod.setText(null);
        txtDuracao.setText(null);
        cbDisp.setSelectedItem("S");
        List<Cidade> cli = CC.buscarCods();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbCod1 = new javax.swing.JComboBox<>();
        txtPrefixo = new javax.swing.JTextField();
        cbCod2 = new javax.swing.JComboBox<>();
        cbCid1 = new javax.swing.JComboBox<>();
        cbCid2 = new javax.swing.JComboBox<>();
        btSair = new javax.swing.JButton();
        btInserir = new javax.swing.JButton();
        txtTarifa = new javax.swing.JTextField();
        txtPedagio = new javax.swing.JTextField();
        txtTaxaRod = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDuracao = new javax.swing.JFormattedTextField();
        cbDisp = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Criar Registro de Linha");
        setPreferredSize(new java.awt.Dimension(386, 283));
        setResizable(false);

        cbCod1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbCod1ItemStateChanged(evt);
            }
        });

        cbCod2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbCod2ItemStateChanged(evt);
            }
        });

        cbCid1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                cbCid1MouseMoved(evt);
            }
        });
        cbCid1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbCid1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cbCid1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cbCid1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cbCid1MouseReleased(evt);
            }
        });
        cbCid1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbCid1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cbCid1KeyTyped(evt);
            }
        });

        cbCid2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                cbCid2MouseMoved(evt);
            }
        });
        cbCid2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbCid2MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cbCid2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cbCid2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cbCid2MouseReleased(evt);
            }
        });
        cbCid2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbCid2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cbCid2KeyTyped(evt);
            }
        });

        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        btInserir.setText("Inserir");
        btInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInserirActionPerformed(evt);
            }
        });

        jLabel5.setText("Tarifa");

        jLabel6.setText("Pedágio");

        jLabel7.setText("Taxa Rodoviaria");

        jLabel1.setText("Prefixo: ");

        jLabel3.setText("Duração");

        try {
            txtDuracao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##:00")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        cbDisp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "S", "N" }));

        jLabel4.setText("Disponibilidade");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbCod1, 0, 60, Short.MAX_VALUE)
                    .addComponent(cbCod2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbCid1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCid2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPrefixo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTarifa, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel7))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPedagio, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtTaxaRod, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(cbDisp, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)))))
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrefixo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCod1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCid1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbCod2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbCid2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTarifa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPedagio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTaxaRod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbDisp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSair)
                    .addComponent(btInserir))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInserirActionPerformed
        int prefixo = Integer.parseInt(txtPrefixo.getText());
        String tam = txtPrefixo.getText();
        String cod1 = cbCod1.getSelectedItem().toString();
        String cod2 = cbCod2.getSelectedItem().toString();
        int v1 = Integer.parseInt(cod1);
        System.out.println("7");
        int v2 = Integer.parseInt(cod2);
        System.out.println("Cod 1: " + cod1 + "\t Cod 2: " + cod2);
        System.out.println("Cod 1: " + v1 + "\t Cod 2: " + v2);
        String duracao = txtDuracao.getText();
        double tarif = Double.parseDouble(txtTarifa.getText().replaceAll(",", "."));
        double pedag = Double.parseDouble(txtPedagio.getText().replaceAll(",", "."));
        double taxa = Double.parseDouble(txtTaxaRod.getText().replaceAll(",", "."));
        double pTotal = tarif + pedag + taxa;
        String disp = cbDisp.getSelectedItem().toString();
        
        if(!cod1.equals(cod2)){
            if(tam.length() == 8){
                Linha novo = new Linha(prefixo, v1, v2, tarif, pedag, taxa, pTotal, duracao, disp);
                if(LC.inserir(novo) == true){
                    JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!", "", JOptionPane.OK_OPTION);
                    refresh();
                }else{
                    JOptionPane.showMessageDialog(null, "Cadastro cadastro não efetuado!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Preencha corretamente o Prefixo", "Erro", JOptionPane.INFORMATION_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Cidades iguais", "Erro", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btInserirActionPerformed

    private void cbCod1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbCod1ItemStateChanged
        int valor1 = Integer.parseInt(cbCod1.getSelectedItem().toString());
        C1 = CC.buscar(valor1);
        cbCid1.setSelectedItem(C1.getCidade());
    }//GEN-LAST:event_cbCod1ItemStateChanged

    private void cbCod2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbCod2ItemStateChanged
        int valor2 = Integer.parseInt(cbCod2.getSelectedItem().toString());
        C2 = CC.buscar(valor2);
        cbCid2.setSelectedItem(C2.getCidade());
    }//GEN-LAST:event_cbCod2ItemStateChanged

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        GerenciarLinhas form = new GerenciarLinhas(null, true);
        form.usuario = F.getLogin();
        form.setValores();
        this.dispose();
        form.setLocationRelativeTo(null);
        form.setVisible(false);
    }//GEN-LAST:event_btSairActionPerformed

    private void cbCid1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbCid1KeyPressed
        String cidade1 = cbCid1.getSelectedItem().toString();
        Cidade c;
        c = CC.buscarCidade(cidade1);
        cbCod1.setSelectedItem(Integer.toString(c.getCodigo()));
    }//GEN-LAST:event_cbCid1KeyPressed

    private void cbCid1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbCid1KeyTyped
        String cidade1 = cbCid1.getSelectedItem().toString();
        Cidade c;
        c = CC.buscarCidade(cidade1);
        cbCod1.setSelectedItem(Integer.toString(c.getCodigo()));
    }//GEN-LAST:event_cbCid1KeyTyped

    private void cbCid1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbCid1MouseClicked
        String cidade1 = cbCid1.getSelectedItem().toString();
        Cidade c;
        c = CC.buscarCidade(cidade1);
        cbCod1.setSelectedItem(Integer.toString(c.getCodigo()));
    }//GEN-LAST:event_cbCid1MouseClicked

    private void cbCid1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbCid1MouseExited
        String cidade1 = cbCid1.getSelectedItem().toString();
        Cidade c;
        c = CC.buscarCidade(cidade1);
        cbCod1.setSelectedItem(Integer.toString(c.getCodigo()));
    }//GEN-LAST:event_cbCid1MouseExited

    private void cbCid2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbCid2KeyPressed
        String cidade2 = cbCid2.getSelectedItem().toString();
        Cidade c;
        c = CC.buscarCidade(cidade2);
        cbCod2.setSelectedItem(Integer.toString(c.getCodigo()));
    }//GEN-LAST:event_cbCid2KeyPressed

    private void cbCid2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbCid2KeyTyped
        String cidade2 = cbCid2.getSelectedItem().toString();
        Cidade c;
        c = CC.buscarCidade(cidade2);
        cbCod2.setSelectedItem(Integer.toString(c.getCodigo()));
    }//GEN-LAST:event_cbCid2KeyTyped

    private void cbCid2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbCid2MouseClicked
        String cidade2 = cbCid2.getSelectedItem().toString();
        Cidade c;
        c = CC.buscarCidade(cidade2);
        cbCod2.setSelectedItem(Integer.toString(c.getCodigo()));
    }//GEN-LAST:event_cbCid2MouseClicked

    private void cbCid2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbCid2MouseExited
        String cidade2 = cbCid2.getSelectedItem().toString();
        Cidade c;
        c = CC.buscarCidade(cidade2);
        cbCod2.setSelectedItem(Integer.toString(c.getCodigo()));
    }//GEN-LAST:event_cbCid2MouseExited

    private void cbCid1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbCid1MouseReleased
        String cidade1 = cbCid1.getSelectedItem().toString();
        Cidade c;
        c = CC.buscarCidade(cidade1);
        cbCod1.setSelectedItem(Integer.toString(c.getCodigo()));
    }//GEN-LAST:event_cbCid1MouseReleased

    private void cbCid1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbCid1MouseMoved
        String cidade1 = cbCid1.getSelectedItem().toString();
        Cidade c;
        c = CC.buscarCidade(cidade1);
        cbCod1.setSelectedItem(Integer.toString(c.getCodigo()));
    }//GEN-LAST:event_cbCid1MouseMoved

    private void cbCid1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbCid1MousePressed
        String cidade1 = cbCid1.getSelectedItem().toString();
        Cidade c;
        c = CC.buscarCidade(cidade1);
        cbCod1.setSelectedItem(Integer.toString(c.getCodigo()));
    }//GEN-LAST:event_cbCid1MousePressed

    private void cbCid2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbCid2MousePressed
        String cidade2 = cbCid2.getSelectedItem().toString();
        Cidade c;
        c = CC.buscarCidade(cidade2);
        cbCod2.setSelectedItem(Integer.toString(c.getCodigo()));
    }//GEN-LAST:event_cbCid2MousePressed

    private void cbCid2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbCid2MouseReleased
        String cidade2 = cbCid2.getSelectedItem().toString();
        Cidade c;
        c = CC.buscarCidade(cidade2);
        cbCod2.setSelectedItem(Integer.toString(c.getCodigo()));
    }//GEN-LAST:event_cbCid2MouseReleased

    private void cbCid2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbCid2MouseMoved
        String cidade2 = cbCid2.getSelectedItem().toString();
        Cidade c;
        c = CC.buscarCidade(cidade2);
        cbCod2.setSelectedItem(Integer.toString(c.getCodigo()));
    }//GEN-LAST:event_cbCid2MouseMoved

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btInserir;
    private javax.swing.JButton btSair;
    private javax.swing.JComboBox<String> cbCid1;
    private javax.swing.JComboBox<String> cbCid2;
    private javax.swing.JComboBox<String> cbCod1;
    private javax.swing.JComboBox<String> cbCod2;
    private javax.swing.JComboBox<String> cbDisp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JFormattedTextField txtDuracao;
    private javax.swing.JTextField txtPedagio;
    private javax.swing.JTextField txtPrefixo;
    private javax.swing.JTextField txtTarifa;
    private javax.swing.JTextField txtTaxaRod;
    // End of variables declaration//GEN-END:variables
}