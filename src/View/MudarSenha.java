/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Dao.Class.Funcionario;
import Dao.Controller.FuncionarioControlador;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;

/**
 *
 * @author Nair Andrade
 */
public class MudarSenha extends javax.swing.JFrame {

    public String usuario;
    Funcionario F = new Funcionario();
    FuncionarioControlador FC = new FuncionarioControlador();
    /**
     * Creates new form MudarSenha
     */
    public MudarSenha() {
        initComponents();
    }

    public void setValores(){
        setUsuarios();
    }

    public void setUsuarios(){
        F = FC.buscar(usuario);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtSenhaAtual = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        txtNewSenha = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNewSenha2 = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        btRegistrar = new javax.swing.JButton();

        setAlwaysOnTop(true);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Digite senha Atual:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Digite a nova senha:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Digite a nova senha:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Altere a Senha");

        btRegistrar.setText("Registrar");
        btRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(txtSenhaAtual)
                    .addComponent(txtNewSenha)
                    .addComponent(txtNewSenha2, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addComponent(btRegistrar)
                .addGap(65, 65, 65))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btRegistrar)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSenhaAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNewSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNewSenha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegistrarActionPerformed
        String senhaAtual = txtSenhaAtual.getText();
        String newSenha = txtNewSenha.getText();
        String newSenha2 = txtNewSenha2.getText();

        System.out.println("senha: " + F.getSenha());
        try{
            if(senhaAtual.equalsIgnoreCase(F.getSenha()) && !senhaAtual.trim().equalsIgnoreCase(newSenha)){
                if(newSenha.equalsIgnoreCase(newSenha2)){
                    F.setSenha(newSenha);
                    if(FC.alterarSenha(F) == true){
                        System.out.println("sim");
                        MenuPrincipal tela = new MenuPrincipal(null ,true);
                        tela.usuario = usuario;
                        this.dispose();
                        tela.setLocationRelativeTo(null);
                        tela.setValores();
                        tela.setVisible(true);
                    }else{
                        this.toBack();
                        JOptionPane.showMessageDialog(null, "Alteração não efetuada", "Erro", JOptionPane.INFORMATION_MESSAGE);
                    }
                }else{
                    this.toBack();
                    JOptionPane.showMessageDialog(null, "Senhas incorretas", "Erro", JOptionPane.INFORMATION_MESSAGE);
                }
            }else{
                this.toBack();
                JOptionPane.showMessageDialog(null, "Senha atual está incorreta!!!", "Erro", JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(HeadlessException ex){
            this.toBack();
            JOptionPane.showMessageDialog(null , ex, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btRegistrarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField txtNewSenha;
    private javax.swing.JPasswordField txtNewSenha2;
    private javax.swing.JPasswordField txtSenhaAtual;
    // End of variables declaration//GEN-END:variables
}