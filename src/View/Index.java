/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Dao.Class.Funcionario;
import Dao.Controller.FuncionarioControlador;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Leandro Baroni
 */
public class Index extends javax.swing.JFrame {

    FuncionarioControlador FC = new FuncionarioControlador();
    Funcionario F = new Funcionario();
    /**
     * Creates new form index
     */
    public Index() {
        initComponents();
    }

    public void updCont(int cont){
        System.out.println("cont2: " + cont);
        System.out.println("cod: " + F.getCodigo());
        F = new Funcionario(F.getCodigo(), cont);
        FC.alterarCont(F);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btAcessar = new javax.swing.JToggleButton();
        jLabelLogin = new javax.swing.JLabel();
        jLabelSenha = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        jLabelSVP = new javax.swing.JLabel();
        jPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 153, 153));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        btAcessar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btAcessar.setText("Acessar");
        btAcessar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btAcessar.setMargin(new java.awt.Insets(10, 10, 10, 10));
        btAcessar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAcessarActionPerformed(evt);
            }
        });

        jLabelLogin.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelLogin.setText("Login");

        jLabelSenha.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelSenha.setText("Senha");

        jLabelSVP.setBackground(new java.awt.Color(255, 153, 153));
        jLabelSVP.setFont(new java.awt.Font("Calisto MT", 1, 14)); // NOI18N
        jLabelSVP.setText("SVP");

        jPassword.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelLogin)
                            .addComponent(jLabelSenha))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jLabelSVP)))
                .addContainerGap(107, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btAcessar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabelSVP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLogin)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSenha)
                    .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(btAcessar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAcessarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAcessarActionPerformed
        String login = txtLogin.getText();
        String password = jPassword.getText();
        if(login != null && password != null && !login.isEmpty() && !password.isEmpty()){
            boolean acessoOk = FC.validarUsuario(login, password);
            F = FC.buscar(login);
            if (acessoOk == true) {
                int cont = F.getContLogin() + 1;
                F.setContLogin(cont);
                FC.alterarCont(F);
                if (cont > 30) {
                    MudarSenha tela = new MudarSenha();
                    tela.usuario = login;
                    tela.setValores();
                    this.toBack();
                    this.dispose();
                    tela.setLocationRelativeTo(null);
                    tela.setVisible(true);
                }else{
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
                    MenuPrincipal form = new MenuPrincipal(frame, true);
                    form.usuario = login;
                    form.setValores();
                    limpar();
                    this.toBack();
                    this.dispose();
                    form.setLocationRelativeTo(null);
                    form.setVisible(true);
                }
            }
            else {
                this.toBack();
                JOptionPane.showMessageDialog(null, "Login e/ou Senha inválidos!", "Acesso Inválido", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            this.toBack();
            JOptionPane.showMessageDialog(null, "Digite login e Senha!!!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btAcessarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Index().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btAcessar;
    private javax.swing.JLabel jLabelLogin;
    private javax.swing.JLabel jLabelSVP;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JTextField txtLogin;
    // End of variables declaration//GEN-END:variables

    private void limpar() {
        txtLogin.setText("");
        jPassword.setText("");
        txtLogin.enable();
        jPassword.enable();
        btAcessar.disable();
    }
}
