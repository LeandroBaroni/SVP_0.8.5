/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Venda;

import View.*;
import Dao.Class.Funcionario;
import Dao.Class.Venda;
import Dao.Controller.FuncionarioControlador;
import View.Poltronas.G7_1200_38P;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Leandro Baroni
 */
public class CarrinhoCompraRemarcacao extends javax.swing.JFrame {

    Funcionario F = new Funcionario();
    FuncionarioControlador FC = new FuncionarioControlador();
    public ArrayList<Venda> lista = new ArrayList<>();
    public ArrayList<Venda> lista2 = new ArrayList<>();
    DefaultTableModel model;

    public List<Venda> vBilheteAntigo = new ArrayList<>();

    public int servico;
    public int prefixo;
    public double valor;
    public int poltrona;
    public String usuario;
    public String data;
    public String hora;

    public int cidade1;
    public int cidade2;
    /**
     * Creates new form CarrinhoCompra
     */
    public CarrinhoCompraRemarcacao() {
        initComponents();
    }

    public void setUsuario(){
        System.out.println(usuario);
        F = FC.buscar(usuario);
        System.out.println("aaaaaaa codFunci: " + F.getCodigo());
        System.out.println(F.getNome());
    }

    public void setValores(){
        setUsuario();
        double total = 0;
        model = (DefaultTableModel) jTable.getModel();
        Object rowData[] = new Object[11];
        model.setRowCount(0);
        for (int i = 0; i < lista.size(); i++) {
            rowData[0] = lista.get(i).getCodBilhete();
            rowData[1] = lista.get(i).getNomeCliente();
            rowData[2] = lista.get(i).getRg();
            rowData[3] = lista.get(i).getCpfCnpj();
            rowData[4] = lista.get(i).getServico();
            rowData[5] = lista.get(i).getDataViagem().dViagem;
            rowData[6] = this.hora;
            rowData[7] = lista.get(i).getNumPoltrona();
            rowData[8] = lista.get(i).getValor();
            rowData[9] = lista.get(i).getLinhaId();
            rowData[10] = lista.get(i).getTelefone();

            model.addRow(rowData);
            total += lista.get(i).getValor();
        }
        txtValorTotal.setText(String.format("%.2f", total));
        setButtons();
    }

    public void setButtons(){
        txtValorTotal.setEditable(false);
    }

    public void changeContentLists(){
        F = FC.buscar(usuario);
        System.out.println("0");
        model = (DefaultTableModel) jTable.getModel();
        int selecLinha = jTable.getSelectedRow();
        lista2.clear();
        for (int i = 0; i < lista.size(); i++) {
            String nome = model.getValueAt(i, 1).toString();
            String rg = model.getValueAt(i, 2).toString();
            String cpfCnpj = model.getValueAt(i, 3).toString();
            int serv = Integer.parseInt(model.getValueAt(i, 4).toString());
            String dataViagem = model.getValueAt(i, 5).toString();
            String horaViagem = model.getValueAt(i, 6).toString();
            int polt = Integer.parseInt(model.getValueAt(i, 7).toString());
            double preco = Double.parseDouble(model.getValueAt(i, 8).toString());
            int pref = Integer.parseInt(model.getValueAt(i, 9).toString());
            String telefone = model.getValueAt(i, 10).toString();

            String dataVenda = "";
            String horaVenda = "";
            int idFunc = F.getCodigo();
            String estBil = "V";
            String estPolt = "O";
            lista2.add(new Venda(i, 0, preco, nome, rg, cpfCnpj, polt, pref, serv, idFunc, estBil, estPolt, dataVenda, horaVenda,telefone, dataViagem, horaViagem));
        }
        model.fireTableDataChanged();
        lista.clear();
        lista = null;
        lista = new ArrayList<>(lista2);
        lista.forEach((produto) -> {
            System.out.println("\n" + produto.getCodBilhete());
        });
        setValores();
    }

    public int setarValorDaTable(){
        F = FC.buscar(usuario);
        System.out.println("0");
        model = (DefaultTableModel) jTable.getModel();
        int selecLinha = jTable.getSelectedRow();
        lista2.clear();
        try{
            for (int i = 0; i < lista.size(); i++) {
                String nome;
                String rg;
                String cpfCnpj;

                if (model.getValueAt(i, 1).toString().trim().equalsIgnoreCase("")) {
                    nome = "";
                }else{
                    nome = model.getValueAt(i, 1).toString().toUpperCase();
                }
                
                if (model.getValueAt(i, 2).toString().trim().equalsIgnoreCase("")) {
                    rg = "";
                }else{
                    rg = model.getValueAt(i, 2).toString();
                }
                
                if (model.getValueAt(i, 3).toString().trim().equals("")) {
                    cpfCnpj = "0";
                }else{
                    cpfCnpj = model.getValueAt(i, 3).toString();
                }
                
                int serv = Integer.parseInt(model.getValueAt(i, 4).toString());
                String dataViagem = model.getValueAt(i, 5).toString();
                String horaViagem = model.getValueAt(i, 6).toString();
                int polt = Integer.parseInt(model.getValueAt(i, 7).toString());
                double preco = Double.parseDouble(model.getValueAt(i, 8).toString());
                int pref = Integer.parseInt(model.getValueAt(i, 9).toString());
                String telefone = model.getValueAt(i, 10).toString();
                String dataVenda = "";
                String horaVenda = "";
                int idFunc = F.getCodigo();
                String estBil = "V";
                String estPolt = "O";
                //lista.add(new Venda(i, 0, preco, nome, rg, cpfCnpj, polt, pref, serv, idFunc, estBil, estPolt, dataVenda, horaVenda,telefone, dataViagem, horaViagem));
                return 1;
            }
        }catch(HeadlessException | NumberFormatException ex){
            System.out.println(ex);
            return 0;
        }
        //return 0;
        //model.fireTableDataChanged();
        //lista.clear();
        //lista = null;
        //lista = new ArrayList<>(lista2);
        //lista.forEach((produto) -> {
            //System.out.println("\n" + produto.getCodBilhete());
            //System.out.println("\n" + produto.getNomeCliente());
            //System.out.println("\n" + produto.getRg());
            //System.out.println("\n" + produto.getCpfCnpj());
        //});
        //setValores();
        return 0;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtValorTotal = new javax.swing.JTextField();
        btFinalizar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Finalizar Venda");
        setAlwaysOnTop(true);

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Documento 1", "CPF", "Servico", "Data Viagem", "Horario", "Poltrona", "Preço", "Prefixo", "Telefone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Long.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable);
        if (jTable.getColumnModel().getColumnCount() > 0) {
            jTable.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTable.getColumnModel().getColumn(2).setPreferredWidth(200);
            jTable.getColumnModel().getColumn(3).setPreferredWidth(200);
            jTable.getColumnModel().getColumn(5).setPreferredWidth(170);
            jTable.getColumnModel().getColumn(6).setPreferredWidth(170);
            jTable.getColumnModel().getColumn(8).setPreferredWidth(100);
            jTable.getColumnModel().getColumn(10).setPreferredWidth(180);
        }

        jLabel1.setText("Total: ");

        btFinalizar.setText("Finalizar");
        btFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFinalizarActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Cesta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btFinalizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btVoltar)
                .addGap(18, 18, 18)
                .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(354, 354, 354))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btExcluir)
                    .addComponent(btVoltar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(btFinalizar))
                    .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        model = (DefaultTableModel) jTable.getModel();
        int selecLinha = jTable.getSelectedRow();
        if (jTable.getSelectedRow() == -1) {
            if (jTable.getSelectedRow() == 0) {
                JOptionPane.showMessageDialog(null, "Tabela está vazia!!!", "Erro", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Selecione um!!!", "Erro", JOptionPane.INFORMATION_MESSAGE);
            }
        }else{
            try{
                int idValid = Integer.parseInt(model.getValueAt(selecLinha, 0).toString());
                lista.remove(idValid);
                model.removeRow(selecLinha);
                changeContentLists();
            }catch(IndexOutOfBoundsException | NullPointerException ex){
                System.out.println("Erro: " + ex);
                System.out.println("Erro-> " + ex.getMessage());
                JOptionPane.showMessageDialog(null , "Erro: " + ex, "Erro", JOptionPane.OK_OPTION);
            }
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFinalizarActionPerformed
        System.out.println(jTable.getRowCount());
        model = (DefaultTableModel) jTable.getModel();
        lista2.clear();
        if (jTable.getRowCount() > 0) {
            try{
                for (int i = 0; i < lista.size(); i++) {
                    String nome;
                    String rg;
                    String cpfCnpj;
                    if (model.getValueAt(i, 1).toString().trim().equalsIgnoreCase("")) {
                        nome = "";
                    }else{
                        nome = model.getValueAt(i, 1).toString().toUpperCase();
                    }
                    if (model.getValueAt(i, 2).toString().trim().equalsIgnoreCase("")) {
                        rg = "";
                    }else{
                        rg = model.getValueAt(i, 2).toString();
                    }
                    if (model.getValueAt(i, 3).toString().trim().equals("")) {
                        cpfCnpj = "0";
                    }else{
                        cpfCnpj = model.getValueAt(i, 3).toString();
                    }
                    int serv = Integer.parseInt(model.getValueAt(i, 4).toString());
                    String dataViagem = model.getValueAt(i, 5).toString();
                    String horaViagem = model.getValueAt(i, 6).toString();
                    int polt = Integer.parseInt(model.getValueAt(i, 7).toString());
                    double preco = Double.parseDouble(model.getValueAt(i, 8).toString());
                    int pref = Integer.parseInt(model.getValueAt(i, 9).toString());
                    String telefone = model.getValueAt(i, 10).toString();
                    String dataVenda = "";
                    String horaVenda = "";
                    int idFunc = F.getCodigo();
                    System.out.println("fCodigo: " + F.getCodigo());
                    String estBil = "V";
                    String estPolt = "O";
                    lista2.add(new Venda(i, 3, preco, nome, rg, cpfCnpj, polt, pref, serv, idFunc, estBil, estPolt, dataVenda, horaVenda,telefone, dataViagem, horaViagem));
                }
                model.fireTableDataChanged();
                lista.clear();
                lista = null;
                lista = new ArrayList<>(lista2);

                for (Venda venda : vBilheteAntigo) {
                    System.out.println("valor: " + venda.getValor());
                }

                PagamentoRemarcacao tela = new PagamentoRemarcacao();
                tela.usuario = this.usuario;
                tela.lista = this.lista;
                tela.cidade1 = this.cidade1;
                tela.cidade2 = this.cidade2;
                tela.vBilheteAntigo = this.vBilheteAntigo;
                tela.setValores();
                this.dispose();
                tela.setLocationRelativeTo(null);
                tela.setVisible(true);
            }catch(IndexOutOfBoundsException ex){
                JOptionPane.showMessageDialog(null, ex, "Erro", JOptionPane.INFORMATION_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Não existe produto na cesta de compras.", "Erro", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btFinalizarActionPerformed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        TelaVenda tela = new TelaVenda();
        tela.usuario = this.usuario;
        tela.list = this.lista;
        tela.setValores();
        this.dispose();
        tela.setLocationRelativeTo(null);
        tela.setVisible(true);
    }//GEN-LAST:event_btVoltarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btFinalizar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField txtValorTotal;
    // End of variables declaration//GEN-END:variables
}
