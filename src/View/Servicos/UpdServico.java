/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Servicos;

import Dao.Class.Funcionario;
import Dao.Class.Servico;
import Dao.Controller.FuncionarioControlador;
import Dao.Controller.ServicoControlador;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Nair Andrade
 */
public class UpdServico extends javax.swing.JDialog {

    Funcionario F = new Funcionario();
    FuncionarioControlador FC = new FuncionarioControlador();
    Servico S = new Servico();
    ServicoControlador SC = new ServicoControlador();

    public String usuario;
    public int codUsu;
    public int codServico;
    public int codPref;
    public String data;
    public String hora;

    /**
     * Creates new form UpdServico
     */
    public UpdServico(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public void setUsuarios(){
        F = FC.buscar(usuario);
        String tipo = F.getTipo();
        System.out.println("USUARIO: " + F.getLogin() + "/ "
                + "Tipo: "+ tipo);
    }

    public void setValores(){
        setUsuarios();
        setBotao();
        System.out.println("------------------------------");
    }

    public void setBotao(){
        txtServico.setText(Integer.toString(codServico));
        txtPrefixo.setText(Integer.toString(codPref));
        jDateChooser.setDate(Date.valueOf(data));
        txtHora.setText(this.hora);
        txtPrefixo.setOpaque(true);
        txtPrefixo.setEditable(false);
        txtServico.setEditable(false);
        txtServico.setOpaque(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btAlterar = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtServico = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPrefixo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        txtHora = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(383, 241));

        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        jLabel1.setText("Cod. Serviço: ");

        jLabel2.setText("Prefixo: ");

        jLabel3.setText("Data/Horário: ");

        try {
            txtHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btAlterar)
                .addGap(18, 18, 18)
                .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtPrefixo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtServico, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrefixo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAlterar)
                    .addComponent(btSair))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        GerenciarServicos form = new GerenciarServicos(null, true);
        form.usuario = F.getLogin();
        form.setValores();
        this.dispose();
        form.setLocationRelativeTo(null);
        form.setVisible(true);
    }//GEN-LAST:event_btSairActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        int pref = Integer.parseInt(txtPrefixo.getText());
        int serv = Integer.parseInt(txtServico.getText());
        String dat = sdf.format(jDateChooser.getDate());
        System.out.println(dat);
        String hor = txtHora.getText() + ":00";
        System.out.println("hor: " + hor);
        if(hor.length() != 8){
            JOptionPane.showMessageDialog(null, "Hora de viagem Inválida", "Erro", JOptionPane.INFORMATION_MESSAGE);
        }else{
            S = new Servico(serv, dat, hor, pref);
            SC.alterar(S);
            JOptionPane.showMessageDialog(null, "Serviço de viagem alterado com sucesso", "Erro", JOptionPane.OK_OPTION);
            GerenciarServicos form = new GerenciarServicos(null ,true);
            form.usuario = F.getLogin();
            form.setValores();
            this.dispose();
            form.setLocationRelativeTo(null);
            form.setVisible(true);
        }
    }//GEN-LAST:event_btAlterarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btSair;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JFormattedTextField txtHora;
    private javax.swing.JTextField txtPrefixo;
    private javax.swing.JTextField txtServico;
    // End of variables declaration//GEN-END:variables
}
