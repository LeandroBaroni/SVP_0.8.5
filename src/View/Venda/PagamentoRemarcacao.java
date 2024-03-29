/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Venda;

import View.*;
import Dao.Class.BilhetePdf;
import Dao.Class.Funcionario;
import Dao.Class.Linha;
import Dao.Class.Venda;
import Dao.Controller.BilhetePdfControlador;
import Dao.Controller.FuncionarioControlador;
import Dao.Controller.LinhaControlador;
import Dao.Controller.VendaControlador;
import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Leandro Baroni
 */
public class PagamentoRemarcacao extends javax.swing.JFrame {

    Funcionario F = new Funcionario();
    FuncionarioControlador FC = new FuncionarioControlador();
    LinhaControlador LC = new LinhaControlador();
    //Linha L = new Linha();
    Linha L = new Linha();
    VendaControlador VC = new VendaControlador();
    Venda V;
    //ArrayList<BilhetePdf> B = new ArrayList<>();
    //ArrayList<BilhetePdf> B = new ArrayList<>();
    BilhetePdf B = new BilhetePdf();
    BilhetePdfControlador BC = new BilhetePdfControlador();

    public ArrayList<Venda> lista = new ArrayList<>();
    public ArrayList<Venda> lista2 = new ArrayList<>();

    public List<Venda> vBilheteAntigo = new ArrayList<>();

    public String usuario;

    public int qtdValorArray;
    public int prefixo;
    public int servico;
    public String dataViagem;
    public String horaViagem;
    public double valViagem;

    public int cidade1;
    public int cidade2;
    /**
     * Creates new form Pagamento
     */
    public PagamentoRemarcacao() {
        initComponents();
    }

    public void setValores(){
        double total = 0;
        setButtons();
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        Object rowData[] = new Object[2];
        model.setRowCount(0);
        for (Venda venda : lista) {
            total += venda.getValor();
        }
        for (int i = 1; i <= 5; i++) {
            rowData[0] = i;
            rowData[1] = total/i;
            model.addRow(rowData);
        }
        System.out.println("098");
        //showValoresDoBilheteAnterior();
        double vAntigo = 0;
        for (Venda antigo : vBilheteAntigo) {
            System.out.println("valor: " + antigo.getValor());
            vAntigo += antigo.getValor();
        }

        System.out.println("valor antigo: " + vAntigo);
        System.out.println("987");
        double valorFinal = total - vAntigo;
        txtValorTotal.setText(String.format("%.2f", valorFinal));
        if(valorFinal < 0){
            txtValorTotal.setBackground(Color.red);
        }else if(valorFinal > 0){
            txtValorTotal.setBackground(Color.green);
        }
    }

    public void setButtons(){
        txtValorTotal.setEditable(false);
        btVoltar.setVisible(false);
    }

    public void sairVenda(){
        limparValores();
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        this.setVisible(false);
        this.dispose();
        MenuPrincipal tela = new MenuPrincipal(frame, true);
        tela.usuario = this.usuario;
        tela.setValores();
        tela.setVisible(true);
    }

    public void limparValores(){
        lista.clear();
    }

    public void showValoresDoBilheteAnterior(){
        System.out.println("------");
        vBilheteAntigo.forEach((Venda venda) -> {
            System.out.println("cod: " + venda.getCodBilhete());
            System.out.println("nome: " + venda.getNomeCliente());
            System.out.println("valor: " + venda.getValor());
        });
        System.out.println("xxxxxxx");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btConfirmar = new javax.swing.JButton();
        btFechar = new javax.swing.JButton();
        txtValorTotal = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        cbFormaPagamento = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        btVoltar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Finalização da Troca de Bilhete");

        btConfirmar.setText("Confirmar");
        btConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmarActionPerformed(evt);
            }
        });

        btFechar.setText("Fechar");
        btFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFecharActionPerformed(evt);
            }
        });

        cbFormaPagamento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cbFormaPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DINHEIRO" }));

        jLabel1.setText("Forma de Pagamento");

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Parcelas", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable);

        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Valor Total: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(cbFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(39, 39, 39))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btConfirmar)
                        .addGap(18, 18, 18)
                        .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107)
                        .addComponent(btFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btConfirmar)
                    .addComponent(btFechar)
                    .addComponent(btVoltar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        CarrinhoCompra tela = new CarrinhoCompra();
        tela.lista = this.lista;
        tela.usuario = this.usuario;
        tela.servico = this.servico;
        tela.prefixo = this.prefixo;
        tela.valor = this.valViagem;
        tela.data = this.dataViagem;
        tela.hora = this.horaViagem;
        tela.setValores();
        tela.setLocationRelativeTo(null);
        tela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmarActionPerformed
        System.out.println("0");
        if (cbFormaPagamento.getSelectedItem().equals("DINHEIRO")) {
            System.out.println("1");
            for (Venda venda : lista) {
                int clienteId = venda.getIdCliente();
                Double valor = venda.getValor();
                String nome = venda.getNomeCliente();
                String rg = venda.getRg();
                String cpfCnpj = venda.getCpfCnpj();
                int polt = venda.getNumPoltrona();
                L = LC.buscarPref(cidade1, cidade2, venda.getLinhaId());
                int pref = L.getId();
                int serv = venda.getServico();
                int funcId = venda.getIdFuncionario();
                String estBilhete = venda.getEstadoBilhete();
                String dispP = venda.getDispPolt();
                System.out.println("1");
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
                Date date = new Date();
                System.out.println(pref);
                String dataAt = dateFormat.format(date);
                String hourAt = hourFormat.format(date);
                System.out.println("3");
                String telefone = venda.getTelefone();
                System.out.println("4");
                int remBilhete = 0;
                String remNome = "";
                int remNumPoltrona = 0;
                for (Venda valorRemarcar : vBilheteAntigo) {
                    remBilhete = valorRemarcar.getCodBilhete();
                    remNome = valorRemarcar.getNomeCliente();
                    remNumPoltrona = valorRemarcar.getNumPoltrona();
                }
                VC.remarcarBilhete(remBilhete, remNome, remNumPoltrona);
                System.out.println("passou da remarcacao");
                V = new Venda(clienteId, valor, nome, rg, cpfCnpj, polt, pref, serv, funcId, estBilhete, dispP, dataAt, hourAt, telefone);
                VC.inserir(V);
                System.out.println("ok");
                B = BC.getDadosBilhete(nome, polt, serv, dataAt, hourAt);
                System.out.println("------------");

                BC.createPdfFile(B);
            }
            sairVenda();
        }else{
            System.out.println("Forma de pagamento não selecionada!!!");
        }
    }//GEN-LAST:event_btConfirmarActionPerformed

    private void btFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharActionPerformed
        TelaVenda tela = new TelaVenda();
        tela.usuario = this.usuario;
        tela.list = this.lista;
        tela.setValores();
        this.dispose();
        tela.setLocationRelativeTo(null);
        tela.setVisible(true);
    }//GEN-LAST:event_btFecharActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConfirmar;
    private javax.swing.JButton btFechar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JComboBox<String> cbFormaPagamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField txtValorTotal;
    // End of variables declaration//GEN-END:variables
}