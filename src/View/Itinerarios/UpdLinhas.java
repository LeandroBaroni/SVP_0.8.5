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
import javax.swing.JOptionPane;

/**
 *
 * @author Leandro Baroni
 */
public class UpdLinhas extends javax.swing.JDialog {
    LinhaControlador LC = new LinhaControlador();
    Linha l = new Linha();
    CidadeControlador CC = new CidadeControlador();
    Cidade ci = new Cidade();
    FuncionarioControlador FC = new FuncionarioControlador();
    Funcionario F = new Funcionario();
    DecimalFormat format = new DecimalFormat();
    public int valorId;
    public String cidId1;
    public String cidId2;
    public String usuario;
    public String login;
    public int id;
    
    /**
     * Creates new form UpdLinhas
     * @param parent
     * @param modal
     */
    public UpdLinhas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        txtTarifa.setDocument(new FormatNum());
        txtTaxa.setDocument(new FormatNum());
        txtPedagio.setDocument(new FormatNum());
    }
    
    public void setValores(){
        setUsuario();
        setButtons();
        System.out.println("valorId: " + valorId);
        setCidades();
    }
    public void setButtons(){
        txtCodPrefixo.setEnabled(false);
        txtCodPrefixo.setEditable(false);
        txtTarifa.setFocusable(true);
    }
    public void setUsuario(){
        F = FC.buscar(usuario);
    }
    public void setCidades(){
        l = LC.buscar(valorId, cidId1, cidId2);
        System.out.println("VALOR ID: " + valorId);
        id = l.getId();
        System.out.println("VALOR DO ID: " + id);
        String codigo = String.valueOf(l.getPrefixo());
        txtCodPrefixo.setText(codigo);
        for (Cidade c: CC.buscarCods()){
            cbCodCidade1.addItem(Integer.toString(c.getCodigo()));
            cbCodCidade2.addItem(Integer.toString(c.getCodigo()));
            cbNomeCidade1.addItem(c.getCidade());
            cbNomeCidade2.addItem(c.getCidade());
        }
        cbNomeCidade1.setSelectedItem(l.getCidadeInicial());
        cbNomeCidade2.setSelectedItem(l.getCidadeFinal());
        String v = Double.toString(l.getPedagio());
        double rTar = l.getTarifa();
        double rTax = l.getTaxaRod();
        double rPed = l.getPedagio();
        txtTarifa.setText(String.valueOf(rTar).format("%.2f", rTar));
        txtTaxa.setText(String.valueOf(rTax).format("%.2f", rTax));
        txtPedagio.setText(String.valueOf(rPed).format("%.2f", rPed));
        txtDuracao.setText(l.getDuracao());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCodPrefixo = new javax.swing.JTextField();
        cbCodCidade1 = new javax.swing.JComboBox<>();
        cbNomeCidade1 = new javax.swing.JComboBox<>();
        cbCodCidade2 = new javax.swing.JComboBox<>();
        cbNomeCidade2 = new javax.swing.JComboBox<>();
        txtTarifa = new javax.swing.JTextField();
        txtPedagio = new javax.swing.JTextField();
        txtTaxa = new javax.swing.JTextField();
        btRegistrar = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbDisp = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtDuracao = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alterar Registro de Linha");
        setAlwaysOnTop(true);
        setResizable(false);

        cbCodCidade1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbCodCidade1ItemStateChanged(evt);
            }
        });
        cbCodCidade1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbCodCidade1MouseClicked(evt);
            }
        });
        cbCodCidade1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbCodCidade1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cbCodCidade1KeyTyped(evt);
            }
        });

        cbNomeCidade1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                cbNomeCidade1MouseMoved(evt);
            }
        });
        cbNomeCidade1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbNomeCidade1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cbNomeCidade1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cbNomeCidade1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cbNomeCidade1MouseReleased(evt);
            }
        });
        cbNomeCidade1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbNomeCidade1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cbNomeCidade1KeyTyped(evt);
            }
        });

        cbCodCidade2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbCodCidade2ItemStateChanged(evt);
            }
        });

        cbNomeCidade2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                cbNomeCidade2MouseMoved(evt);
            }
        });
        cbNomeCidade2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbNomeCidade2MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cbNomeCidade2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cbNomeCidade2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cbNomeCidade2MouseReleased(evt);
            }
        });
        cbNomeCidade2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbNomeCidade2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cbNomeCidade2KeyTyped(evt);
            }
        });

        btRegistrar.setText("Registrar");
        btRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegistrarActionPerformed(evt);
            }
        });

        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        jLabel2.setText("Pedágio");

        jLabel3.setText("Taxa Rodoviaria");

        jLabel4.setText("Tarifa");

        jLabel5.setText("Disponibilidade");

        cbDisp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "S", "N" }));

        jLabel6.setText("Duração");

        try {
            txtDuracao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##:00")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTarifa, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtPedagio, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(cbDisp, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtCodPrefixo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbCodCidade2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel4)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel5))
                            .addComponent(cbNomeCidade2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(283, 283, 283)
                        .addComponent(txtDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbCodCidade1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbNomeCidade1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btRegistrar)
                        .addGap(18, 18, 18)
                        .addComponent(btVoltar)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(28, 28, 28))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(txtCodPrefixo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCodCidade1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbNomeCidade1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbCodCidade2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbNomeCidade2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTarifa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPedagio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbDisp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btVoltar)
                            .addComponent(btRegistrar))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)))
                            .addComponent(jLabel4))
                        .addGap(71, 71, 71))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegistrarActionPerformed
        int slctId = valorId;
        int slctPref = Integer.parseInt(txtCodPrefixo.getText());
        String slct1 = cbCodCidade1.getSelectedItem().toString();
        int slctCod1 = Integer.parseInt(cbCodCidade1.getSelectedItem().toString());
        String slct2 = cbCodCidade2.getSelectedItem().toString();
        int slctCod2 = Integer.parseInt(slct2);
        double sTar = Double.parseDouble(txtTarifa.getText().replaceAll(",", "."));
        double sTax = Double.parseDouble(txtTaxa.getText().replaceAll(",", "."));
        double sPed = Double.parseDouble(txtPedagio.getText().replaceAll(",", "."));
        double sTot = sTar + sTax + sPed;
        String duracao = txtDuracao.getText();
        String disp = cbDisp.getSelectedItem().toString();
        
        
        System.out.println(sTar + " + " + sTax + " + " + sPed+ " = " + sTot);
        if(!slct1.equals(slct2)){
            Linha novo = new Linha(id, slctPref, slctCod1, slctCod2, sTar, sTax, sPed, sTot, duracao, disp);
            if(LC.alterar(novo) == true){
                JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!", "certo", JOptionPane.OK_OPTION);
                GerenciarLinhas form = new GerenciarLinhas(null, true);
                form.usuario = F.getLogin();
                form.setValores();
                this.dispose();
                form.setLocationRelativeTo(null);
                form.setVisible(true);
            }else{
                System.out.println("erro");
                JOptionPane.showMessageDialog(null, "Cadastro cadastro não efetuado!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Nome das cidades são iguais!!!", "Erro", JOptionPane.NO_OPTION);
        }
    }//GEN-LAST:event_btRegistrarActionPerformed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        GerenciarLinhas form = new GerenciarLinhas(null, true);
        form.usuario = F.getLogin();
        form.setValores();
        this.dispose();
        form.setLocationRelativeTo(null);
        form.setVisible(true);
    }//GEN-LAST:event_btVoltarActionPerformed

    private void cbCodCidade1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbCodCidade1ItemStateChanged
        int valor1 = Integer.parseInt(cbCodCidade1.getSelectedItem().toString());
        Cidade c;
        c = CC.buscar(valor1);
        cbNomeCidade1.setSelectedItem(c.getCidade());
    }//GEN-LAST:event_cbCodCidade1ItemStateChanged

    private void cbCodCidade2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbCodCidade2ItemStateChanged
        int valor1 = Integer.parseInt(cbCodCidade2.getSelectedItem().toString());
        Cidade c;
        c = CC.buscar(valor1);
        cbNomeCidade2.setSelectedItem(c.getCidade());
    }//GEN-LAST:event_cbCodCidade2ItemStateChanged

    private void cbCodCidade1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbCodCidade1KeyPressed
        int valor1 = Integer.parseInt(cbCodCidade1.getSelectedItem().toString());
        Cidade c;
        c = CC.buscar(valor1);
        cbNomeCidade1.setSelectedItem(c.getCidade());
    }//GEN-LAST:event_cbCodCidade1KeyPressed

    private void cbCodCidade1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbCodCidade1KeyTyped
        int valor1 = Integer.parseInt(cbCodCidade1.getSelectedItem().toString());
        Cidade c;
        c = CC.buscar(valor1);
        cbNomeCidade1.setSelectedItem(c.getCidade());
    }//GEN-LAST:event_cbCodCidade1KeyTyped

    private void cbCodCidade1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbCodCidade1MouseClicked
        int valor1 = Integer.parseInt(cbCodCidade1.getSelectedItem().toString());
        Cidade c;
        c = CC.buscar(valor1);
        cbNomeCidade1.setSelectedItem(c.getCidade());
    }//GEN-LAST:event_cbCodCidade1MouseClicked

    private void cbNomeCidade1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbNomeCidade1MouseMoved
        String cidade1 = cbNomeCidade1.getSelectedItem().toString();
        Cidade c;
        c = CC.buscarCidade(cidade1);
        cbCodCidade1.setSelectedItem(Integer.toString(c.getCodigo()));
    }//GEN-LAST:event_cbNomeCidade1MouseMoved

    private void cbNomeCidade1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbNomeCidade1KeyPressed
        String cidade1 = cbNomeCidade1.getSelectedItem().toString();
        Cidade c;
        c = CC.buscarCidade(cidade1);
        cbCodCidade1.setSelectedItem(Integer.toString(c.getCodigo()));
    }//GEN-LAST:event_cbNomeCidade1KeyPressed

    private void cbNomeCidade1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbNomeCidade1KeyTyped
        String cidade1 = cbNomeCidade1.getSelectedItem().toString();
        Cidade c;
        c = CC.buscarCidade(cidade1);
        cbCodCidade1.setSelectedItem(Integer.toString(c.getCodigo()));
    }//GEN-LAST:event_cbNomeCidade1KeyTyped

    private void cbNomeCidade1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbNomeCidade1MouseClicked
        String cidade1 = cbNomeCidade1.getSelectedItem().toString();
        Cidade c;
        c = CC.buscarCidade(cidade1);
        cbCodCidade1.setSelectedItem(Integer.toString(c.getCodigo()));
    }//GEN-LAST:event_cbNomeCidade1MouseClicked

    private void cbNomeCidade1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbNomeCidade1MouseExited
        String cidade1 = cbNomeCidade1.getSelectedItem().toString();
        Cidade c;
        c = CC.buscarCidade(cidade1);
        cbCodCidade1.setSelectedItem(Integer.toString(c.getCodigo()));
    }//GEN-LAST:event_cbNomeCidade1MouseExited

    private void cbNomeCidade1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbNomeCidade1MousePressed
        String cidade1 = cbNomeCidade1.getSelectedItem().toString();
        Cidade c;
        c = CC.buscarCidade(cidade1);
        cbCodCidade1.setSelectedItem(Integer.toString(c.getCodigo()));
    }//GEN-LAST:event_cbNomeCidade1MousePressed

    private void cbNomeCidade1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbNomeCidade1MouseReleased
        String cidade1 = cbNomeCidade1.getSelectedItem().toString();
        Cidade c;
        c = CC.buscarCidade(cidade1);
        cbCodCidade1.setSelectedItem(Integer.toString(c.getCodigo()));
    }//GEN-LAST:event_cbNomeCidade1MouseReleased

    private void cbNomeCidade2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbNomeCidade2KeyPressed
        String cidade2 = cbNomeCidade2.getSelectedItem().toString();
        Cidade c;
        c = CC.buscarCidade(cidade2);
        cbCodCidade2.setSelectedItem(Integer.toString(c.getCodigo()));
    }//GEN-LAST:event_cbNomeCidade2KeyPressed

    private void cbNomeCidade2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbNomeCidade2KeyTyped
        String cidade2 = cbNomeCidade2.getSelectedItem().toString();
        Cidade c;
        c = CC.buscarCidade(cidade2);
        cbCodCidade2.setSelectedItem(Integer.toString(c.getCodigo()));
    }//GEN-LAST:event_cbNomeCidade2KeyTyped

    private void cbNomeCidade2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbNomeCidade2MouseMoved
        String cidade2 = cbNomeCidade2.getSelectedItem().toString();
        Cidade c;
        c = CC.buscarCidade(cidade2);
        cbCodCidade2.setSelectedItem(Integer.toString(c.getCodigo()));
    }//GEN-LAST:event_cbNomeCidade2MouseMoved

    private void cbNomeCidade2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbNomeCidade2MouseClicked
        String cidade2 = cbNomeCidade2.getSelectedItem().toString();
        Cidade c;
        c = CC.buscarCidade(cidade2);
        cbCodCidade2.setSelectedItem(Integer.toString(c.getCodigo()));
    }//GEN-LAST:event_cbNomeCidade2MouseClicked

    private void cbNomeCidade2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbNomeCidade2MouseExited
        String cidade2 = cbNomeCidade2.getSelectedItem().toString();
        Cidade c;
        c = CC.buscarCidade(cidade2);
        cbCodCidade2.setSelectedItem(Integer.toString(c.getCodigo()));
    }//GEN-LAST:event_cbNomeCidade2MouseExited

    private void cbNomeCidade2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbNomeCidade2MousePressed
        String cidade2 = cbNomeCidade2.getSelectedItem().toString();
        Cidade c;
        c = CC.buscarCidade(cidade2);
        cbCodCidade2.setSelectedItem(Integer.toString(c.getCodigo()));
    }//GEN-LAST:event_cbNomeCidade2MousePressed

    private void cbNomeCidade2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbNomeCidade2MouseReleased
        String cidade2 = cbNomeCidade2.getSelectedItem().toString();
        Cidade c;
        c = CC.buscarCidade(cidade2);
        cbCodCidade2.setSelectedItem(Integer.toString(c.getCodigo()));
    }//GEN-LAST:event_cbNomeCidade2MouseReleased

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btRegistrar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JComboBox<String> cbCodCidade1;
    private javax.swing.JComboBox<String> cbCodCidade2;
    private javax.swing.JComboBox<String> cbDisp;
    private javax.swing.JComboBox<String> cbNomeCidade1;
    private javax.swing.JComboBox<String> cbNomeCidade2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtCodPrefixo;
    private javax.swing.JFormattedTextField txtDuracao;
    private javax.swing.JTextField txtPedagio;
    private javax.swing.JTextField txtTarifa;
    private javax.swing.JTextField txtTaxa;
    // End of variables declaration//GEN-END:variables
}