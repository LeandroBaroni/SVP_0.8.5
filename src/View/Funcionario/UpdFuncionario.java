/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Funcionario;

import Dao.Class.Funcionario;
import Dao.Controller.FuncionarioControlador;
import javax.swing.JOptionPane;

/**
 *
 * @author Leandro Baroni
 */
public class UpdFuncionario extends javax.swing.JDialog {

    Funcionario F = new Funcionario();
    FuncionarioControlador FC = new FuncionarioControlador();
    public String usuario;
    public int codUsu;
    public int val;

    /**
     * Creates new form UpdFuncionario
     */
    public UpdFuncionario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public void setValores(){
        System.out.println("a");
        setUsuarios();
        System.out.println("b");
        setTipo();
        System.out.println("c");
        setBotao();
        System.out.println("d");
        refresh();
        System.out.println("e");
        buscar();
        System.out.println("f");
    }
    public void setUsuarios(){
        F = FC.buscar(usuario);
        String tipo = F.getTipo();
        System.out.println("TIPO DE USUARIO: "+ tipo);
    }
    
    public void setBotao(){
        lblResult.setOpaque(false);
    }
    
    public void setTipo(){
        for (Funcionario f: FC.buscarTipo()){
            cbTipo.addItem(f.getTipo());
        }
    }
    
    public void refresh(){
        lblResult.setOpaque(true);
        txtNome.setText("");
        txtPass.setText("");
        txtPass2.setText("");
    }
    
    public void buscar(){
        String cod = String.valueOf(codUsu);
        System.out.println("1");
        F = FC.buscarC(cod);
        System.out.println("3");
        txtNome.setText(F.getNome());
        System.out.println("4");
        txtPass.setText(F.getSenha());
        System.out.println("5");
        txtPass2.setText(F.getSenha());
        System.out.println("6");
        cbTipo.setSelectedItem(F.getTipo());
        System.out.println("7");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtPass2 = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        cbTipo = new javax.swing.JComboBox<>();
        btRegistrar = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        lblResult = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTitulo.setText("ALTERE O REGISTRO DE UM NOVO FUNCIONARIO");

        jLabel2.setText("NOME: ");

        jLabel4.setText("SENHA: ");

        jLabel5.setText("DIGITE NOVAMENTE");

        jLabel7.setText(" A SENHA: ");

        jLabel6.setText("FUNCIONARIO");

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        btRegistrar.setText("REGISTRAR");
        btRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegistrarActionPerformed(evt);
            }
        });

        btSair.setText("FECHAR");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        lblResult.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblResult.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(lblResult, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(164, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btRegistrar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btSair)
                            .addGap(8, 8, 8))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(69, 69, 69)
                            .addComponent(lblTitulo))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel5))
                                        .addComponent(jLabel4))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtPass2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(38, 38, 38)
                            .addComponent(jLabel6)
                            .addGap(18, 18, 18)
                            .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(11, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(lblResult, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(173, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(lblTitulo)
                    .addGap(53, 53, 53)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(jLabel5)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtPass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btSair)
                        .addComponent(btRegistrar))
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegistrarActionPerformed
        String nome = txtNome.getText().toUpperCase();
        System.out.println(nome);
        String senha = txtPass.getText();
        String senha2 = txtPass2.getText();
        String tipo = cbTipo.getSelectedItem().toString();
        int tot = FC.countCod() + 1;
        int nCod = codUsu;
        System.out.println("TOTAL: " + nCod);
        System.out.println(tipo);
        System.out.println("TAM: " + nome.length());
        if(senha != null && senha2 != null && tipo != null && !tipo.isEmpty() && !nome.isEmpty() && !senha.isEmpty() && !senha2.isEmpty()){
            if(nome.length() > 3 && nome.length() < 15){
                if(senha.length() > 4 && senha2.length() > 4){
                    if(senha.equals(senha2)){
                        System.out.println("8");
                        Funcionario novo = new Funcionario(nCod, senha, nome, tipo);
                        FC.alterar(novo);
                        System.out.println("deu certo");
                        JOptionPane.showMessageDialog(null, "REGISTRO ALTERADO COM SUCESSO!", "certo", JOptionPane.OK_OPTION);
                        refresh();
                    }else{
                        System.out.println("1");
                        lblResult.setText("DIGITE SENHAS DIFERENTES !!!");
                    }
                }else{
                    lblResult.setText("SENHAS MUITO CURTAS !!!");
                }
            }else{
                JOptionPane.showMessageDialog(null, "NOME DE USUARIO MUITO CURTO OU MUITO LONGO\nDIGITE ENTRE 3 E 15 CARACTERES!!!", "ERRO", JOptionPane.INFORMATION_MESSAGE);
            }
        }else{
            System.out.println("0");
            lblResult.setText("PREENCHA OS CAMPOS!!!");
        }
    }//GEN-LAST:event_btRegistrarActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        GerenciarFuncionario form = new GerenciarFuncionario(null, true);
        System.out.println("USUARIO QUE ESTÁ VOLTANDO: " + usuario);
        form.usuario = usuario;
        form.setValores();
        this.dispose();
        form.setLocationRelativeTo(null);
        form.setVisible(true);
    }//GEN-LAST:event_btSairActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btRegistrar;
    private javax.swing.JButton btSair;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lblResult;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JPasswordField txtPass2;
    // End of variables declaration//GEN-END:variables
}
