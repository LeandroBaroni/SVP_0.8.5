/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Venda;

import View.*;
import Dao.Class.Cidade;
import Dao.Controller.CidadeControlador;
import Dao.Class.Funcionario;
import Dao.Class.Linha;
import Dao.Class.Servico;
import Dao.Class.Venda;
import Dao.Controller.FuncionarioControlador;
import Dao.Controller.LinhaControlador;
import Dao.Controller.ServicoControlador;
import View.Itinerarios.ItinerarioBus;
import View.Menu.MapaDeViagem;
import View.MenuPrincipal;
import View.Poltronas.G7_1200_38P;
import View.Poltronas.G7_1200_42;
import View.Poltronas.G7_1600_27;
import View.Venda.PoltronaRemarcacao.G7_1200_38Remarcacao;
import View.Venda.PoltronaRemarcacao.G7_1200_42Remarcacao;
import View.Venda.PoltronaRemarcacao.G7_1600_27Remarcacao;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ConnectionFactory;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author Leandro Baroni
 */
public class TelaVendaRemarcacao extends javax.swing.JDialog {
    FuncionarioControlador FC = new FuncionarioControlador();
    Funcionario F = new Funcionario();
    CidadeControlador CidC = new CidadeControlador();
    ServicoControlador SC = new ServicoControlador();
    Linha L = new Linha();
    LinhaControlador LC = new LinhaControlador();
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Date date = new Date();

    public List<Venda> vBilheteAntigo = new ArrayList<>();

    public ArrayList<Venda> list = new ArrayList<>();
    public String usuario;
    public String login;
    public int qtdValorArray;
    public int qtdPoltrona;
    String data_abertura = date.toString();
    int totalPoltronaLayout = -1;
    public String c;
    public String poltrona;
    public String dataV;
    Date dia;
    int servico;
    public int linhaSelec;
    int linhaDaTabela;

    /**
     * Creates new form TelaVenda
     */

    public TelaVendaRemarcacao(/*java.awt.Frame parent, boolean modal*/) {
        //super(parent, modal);
        initComponents();
    }

    public void setValores(){
        System.out.println("000");
        System.out.println(usuario);
        F = FC.buscar(usuario);
        for (Venda venda : vBilheteAntigo) {
            System.out.println("valor do bilhete antigo: " + venda.getValor());
        }
        usuario = F.getLogin();
        System.out.println("usuario; "+ usuario);
        System.out.println(F.getNome());
        String tipo = F.getTipo();
        System.out.println("TIPO: " + tipo);
        tela();
        for (Cidade c: CidC.buscarCods()){
            cbCod1.addItem(Integer.toString(c.getCodigo()));
            cbCod2.addItem(Integer.toString(c.getCodigo()));
            cbCid1.addItem(c.getCidade());
            cbCid2.addItem(c.getCidade());
        }
        System.out.println("1");
        if("vendedor".equals(tipo)){
            System.out.println("entrou no IF");
        }else{
            System.out.println("veio no else");
        }
    }

    public void mostrar(){
        System.out.println("-------------------------------");
        for (Venda venda : list) {
            System.out.println(venda.toString());
        }
    }

    public void itinBuscaTelaVenda(int v1, int v2, Date dia, int servico){
        jDateChooser.setDate(dia);
        DecimalFormat df = new DecimalFormat("#,###.00");
        tela();
        List<Servico> serv = SC.buscarVendaPServico(v1, v2, dia, servico);
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        Object rowData[] = new Object[8];
        model.setRowCount(0);
        for(int i =0; i< serv.size(); i++){
            rowData[0] = serv.get(i).getCodigo();
            rowData[1] = serv.get(i).getdViagem();
            rowData[2] = serv.get(i).gethViagem();
            rowData[3] = v1;
            rowData[4] = v2;
            rowData[5] = df.format(serv.get(i).getlPreco().getPrecoTotal());
            rowData[6] = serv.get(i).getQtdPoltronas();
            rowData[7] = serv.get(i).getCodPrefixo();
            model.addRow(rowData);
        }
        limpa();
    }

    public void tela(){
        if(jTable.isEnabled() == false){
            jTable.setEnabled(true);
        }else{
            jTable.setEnabled(false);
        }
    }

    public void limpa(){
        txtServico.setText("");
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
        cbCod1 = new javax.swing.JComboBox<>();
        cbCid1 = new javax.swing.JComboBox<>();
        cbCod2 = new javax.swing.JComboBox<>();
        cbCid2 = new javax.swing.JComboBox<>();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        btBuscar = new javax.swing.JButton();
        btFechar = new javax.swing.JButton();
        txtServico = new javax.swing.JFormattedTextField();
        btItinerario = new javax.swing.JButton();
        btPassageiros = new javax.swing.JButton();
        btVerMap = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Venda");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(204, 255, 204));
        setResizable(false);

        jTable.setBackground(new java.awt.Color(204, 204, 204));
        jTable.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Servico", "Data", "Horário", "Cod Origem", "Cod Destino", "R$", "Dispon.", "Prefixo", "Tot. Poltronas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTableMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);
        if (jTable.getColumnModel().getColumnCount() > 0) {
            jTable.getColumnModel().getColumn(0).setMaxWidth(60);
            jTable.getColumnModel().getColumn(1).setMaxWidth(100);
            jTable.getColumnModel().getColumn(2).setMaxWidth(80);
            jTable.getColumnModel().getColumn(3).setMaxWidth(65);
            jTable.getColumnModel().getColumn(4).setMaxWidth(65);
            jTable.getColumnModel().getColumn(5).setMaxWidth(100);
            jTable.getColumnModel().getColumn(6).setMaxWidth(60);
            jTable.getColumnModel().getColumn(7).setMaxWidth(70);
            jTable.getColumnModel().getColumn(8).setMaxWidth(60);
        }

        cbCod1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbCod1ItemStateChanged(evt);
            }
        });

        cbCid1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbCid1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cbCid1MouseExited(evt);
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

        cbCod2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbCod2ItemStateChanged(evt);
            }
        });

        cbCid2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbCid2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cbCid2MouseEntered(evt);
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

        btBuscar.setText("Buscar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        btFechar.setText("Fechar");
        btFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFecharActionPerformed(evt);
            }
        });

        txtServico.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#"))));

        btItinerario.setText("Itinerário");
        btItinerario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btItinerarioActionPerformed(evt);
            }
        });

        btPassageiros.setText("Passageiros");
        btPassageiros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPassageirosActionPerformed(evt);
            }
        });

        btVerMap.setText("Mapa Ônibus");
        btVerMap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVerMapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(btFechar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btItinerario, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btPassageiros)
                .addGap(12, 12, 12))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbCod1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbCid1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtServico, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbCod2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbCid2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btVerMap))
                .addContainerGap(102, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbCod1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbCid1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbCod2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbCid2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btBuscar)
                        .addComponent(btVerMap)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btItinerario)
                    .addComponent(btPassageiros)
                    .addComponent(btFechar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbCod1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbCod1ItemStateChanged
        int valor1 = Integer.parseInt(cbCod1.getSelectedItem().toString());
        Cidade c;
        c = CidC.buscar(valor1);
        String cidade = c.getCidade();
        System.out.println(cidade);
        cbCid1.setSelectedItem(c.getCidade());
    }//GEN-LAST:event_cbCod1ItemStateChanged

    private void cbCod2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbCod2ItemStateChanged
        int valor2 = Integer.parseInt(cbCod2.getSelectedItem().toString());
        Cidade c;
        c = CidC.buscar(valor2);
        String cidade = c.getCidade();
        System.out.println(cidade);
        cbCid2.setSelectedItem(c.getCidade());
    }//GEN-LAST:event_cbCod2ItemStateChanged

    private void btFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharActionPerformed
        RemarcarBilhetes form = new RemarcarBilhetes();
        form.usuario = F.getLogin();
        form.setValores();
        this.list.clear();
        this.list = null;
        this.dispose();
        form.setLocationRelativeTo(null);
        form.setVisible(true);
    }//GEN-LAST:event_btFecharActionPerformed

    private void jTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMousePressed
        jTable.editingCanceled(null);
    }//GEN-LAST:event_jTableMousePressed

    private void cbCid1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbCid1KeyPressed
        String cidade1 = cbCid1.getSelectedItem().toString();
        Cidade c;
        c = CidC.buscarCidade(cidade1);
        cbCod1.setSelectedItem(Integer.toString(c.getCodigo()));
    }//GEN-LAST:event_cbCid1KeyPressed

    private void cbCid2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbCid2KeyPressed
        String cidade2 = cbCid2.getSelectedItem().toString();
        Cidade c;
        c = CidC.buscarCidade(cidade2);
        cbCod2.setSelectedItem(Integer.toString(c.getCodigo()));
    }//GEN-LAST:event_cbCid2KeyPressed

    private void cbCid1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbCid1KeyTyped
        String cidade1 = cbCid1.getSelectedItem().toString();
        Cidade c;
        c = CidC.buscarCidade(cidade1);
        cbCod1.setSelectedItem(Integer.toString(c.getCodigo()));
    }//GEN-LAST:event_cbCid1KeyTyped

    private void cbCid1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbCid1MouseClicked
        String cidade1 = cbCid1.getSelectedItem().toString();
        Cidade c;
        c = CidC.buscarCidade(cidade1);
        cbCod1.setSelectedItem(Integer.toString(c.getCodigo()));
    }//GEN-LAST:event_cbCid1MouseClicked

    private void cbCid1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbCid1MouseExited
        String cidade1 = cbCid1.getSelectedItem().toString();
        Cidade c;
        c = CidC.buscarCidade(cidade1);
        cbCod1.setSelectedItem(Integer.toString(c.getCodigo()));
    }//GEN-LAST:event_cbCid1MouseExited

    private void cbCid2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbCid2KeyTyped
        String cidade2 = cbCid2.getSelectedItem().toString();
        Cidade c;
        c = CidC.buscarCidade(cidade2);
        cbCod2.setSelectedItem(Integer.toString(c.getCodigo()));
    }//GEN-LAST:event_cbCid2KeyTyped

    private void cbCid2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbCid2MouseClicked
        String cidade2 = cbCid2.getSelectedItem().toString();
        Cidade c;
        c = CidC.buscarCidade(cidade2);
        cbCod2.setSelectedItem(Integer.toString(c.getCodigo()));
    }//GEN-LAST:event_cbCid2MouseClicked

    private void cbCid2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbCid2MouseEntered
        String cidade2 = cbCid2.getSelectedItem().toString();
        Cidade c;
        c = CidC.buscarCidade(cidade2);
        cbCod2.setSelectedItem(Integer.toString(c.getCodigo()));
    }//GEN-LAST:event_cbCid2MouseEntered

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        DecimalFormat df = new DecimalFormat("#,###.00");
        tela();
        Date dia = jDateChooser.getDate();
        java.sql.Date sqlDia = new java.sql.Date(dia.getTime());
        int v1 = Integer.parseInt(cbCod1.getSelectedItem().toString());
        int v2 = Integer.parseInt(cbCod2.getSelectedItem().toString());
        
        //String serviceP = txtServico.getText();
        //System.out.println("servico: " + servico);

        if(txtServico.getText().trim().equals("")){
            System.out.println("if");
            List<Servico> serv = SC.buscarVenda(v1, v2, sqlDia);
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();
            Object rowData[] = new Object[9];
            model.setRowCount(0);
            for(int i =0; i< serv.size(); i++){
                rowData[0] = serv.get(i).getCodigo();
                rowData[1] = serv.get(i).getdViagem();
                rowData[2] = serv.get(i).gethViagem();
                rowData[3] = v1;
                rowData[4] = v2;
                rowData[5] = df.format(serv.get(i).getlPreco().getPrecoTotal());
                rowData[6] = serv.get(i).getQtdPoltronas() - serv.get(i).getQtdPoltronasOcup();
                rowData[7] = serv.get(i).getCodPrefixo();
                rowData[8] = serv.get(i).getQtdPoltronas();
                model.addRow(rowData);
            }
            System.out.println("DEPOIS");
            limpa();
        }else{
            System.out.println("else");
            int servico = Integer.parseInt(txtServico.getText());
            List<Servico> serv = SC.buscarVendaPServico(v1, v2, sqlDia, servico);
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();
            Object rowData[] = new Object[9];
            model.setRowCount(0);
            for(int i =0; i< serv.size(); i++){
                rowData[0] = serv.get(i).getCodigo();
                rowData[1] = serv.get(i).getdViagem();
                rowData[2] = serv.get(i).gethViagem();
                rowData[3] = v1;
                rowData[4] = v2;
                rowData[5] = df.format(serv.get(i).getlPreco().getPrecoTotal());
                rowData[6] = serv.get(i).getQtdPoltronas() - serv.get(i).getQtdPoltronasOcup();
                rowData[7] = serv.get(i).getCodPrefixo();
                rowData[8] = serv.get(i).getQtdPoltronas();
                model.addRow(rowData);
            }
            System.out.println("DEPOIS");
            limpa();
        }
    }//GEN-LAST:event_btBuscarActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        jTable.editingCanceled(null);
        //mostrarPanel();
    }//GEN-LAST:event_jTableMouseClicked

    private void jTableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseEntered
        jTable.editingCanceled(null);
    }//GEN-LAST:event_jTableMouseEntered

    private void jTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseReleased
        jTable.editingCanceled(null);
    }//GEN-LAST:event_jTableMouseReleased

    private void btItinerarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btItinerarioActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        linhaSelec = jTable.getSelectedRow();
        if(jTable.getSelectedRow() == -1){
            if(jTable.getSelectedRowCount() == 0){
                JOptionPane.showMessageDialog(null, "Tabela está vazia", "Não Encontrado", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Selecione um Perfil !!!", "Não Encontrado", JOptionPane.INFORMATION_MESSAGE);
            }
        }else{
            System.out.println("000");
            int prefixo = Integer.parseInt(model.getValueAt(linhaSelec, 7).toString());
            servico = Integer.parseInt(model.getValueAt(linhaSelec, 0).toString());
            System.out.println("servico: " + servico);
            dia = jDateChooser.getDate();
            System.out.println(dia);
            java.sql.Date sqlDia = new java.sql.Date(dia.getTime());
            int v1 = Integer.parseInt(cbCod1.getSelectedItem().toString());
            int v2 = Integer.parseInt(cbCod2.getSelectedItem().toString());
            ItinerarioBus tela = new ItinerarioBus(null, true);
            System.out.println("001");

            tela.usuario = this.usuario;
            tela.origem = v1;
            tela.destino = v2;
            tela.pref = prefixo;
            tela.servico = servico;
            tela.dia = sqlDia;
            tela.buscarDadosItinerario();
            System.out.println("002");
            this.toBack();
            tela.toFront();
            //this.dispose();
            tela.setLocationRelativeTo(null);
            tela.setVisible(true);
        }
    }//GEN-LAST:event_btItinerarioActionPerformed

    private void btVerMapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVerMapActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        System.out.println("000");
        linhaSelec = jTable.getSelectedRow();
        System.out.println("001");
        if(jTable.getSelectedRow() == -1){
            if(jTable.getSelectedRowCount() == 0){
                JOptionPane.showMessageDialog(null, "Tabela está vazia", "Não Encontrado", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Selecione um Perfil !!!", "Não Encontrado", JOptionPane.INFORMATION_MESSAGE);
            }
        }else{
            try{
                int v1 = Integer.parseInt(model.getValueAt(linhaSelec, 3).toString());
                int v2 = Integer.parseInt(model.getValueAt(linhaSelec, 4).toString());
                int qtdPTotal = Integer.parseInt(model.getValueAt(linhaSelec, 8).toString());
                int pref = Integer.parseInt(model.getValueAt(linhaSelec, 7).toString());
                int serv = Integer.parseInt(model.getValueAt(linhaSelec, 0).toString());
                String hora = model.getValueAt(linhaSelec, 2).toString();
                String data = model.getValueAt(linhaSelec, 1).toString();
                String precoString = model.getValueAt(linhaSelec, 5).toString();
                Double preco = Double.parseDouble(precoString.replace(",", "."));
                switch (qtdPTotal) {
                    case 27:
                        G7_1600_27Remarcacao t27 = new G7_1600_27Remarcacao();
                        System.out.println(F.getLogin());
                        System.out.println("---------->");
                        t27.usuario = F.getLogin();
                        t27.lista = this.list;
                        t27.vBilheteAntigo = this.vBilheteAntigo;
                        t27.qtdValorArray = this.qtdValorArray;
                        t27.prefixo = pref;
                        t27.servico = serv;
                        t27.dataViagem = data;
                        t27.horaViagem = hora;
                        t27.valViagem = preco;
                        t27.cidade1 = v1;
                        t27.cidade2 = v2;
                        t27.setValores();
                        t27.setLocationRelativeTo(null);
                        t27.setVisible(true);
                        this.dispose();
                        System.out.println("<--------");
                        break;
                    case 38:
                        System.out.println("1313");
                        G7_1200_38Remarcacao t38 = new G7_1200_38Remarcacao();
                        System.out.println(F.getLogin());
                        System.out.println("---------->");
                        t38.usuario = F.getLogin();
                        t38.lista = this.list;
                        t38.vBilheteAntigo = this.vBilheteAntigo;
                        t38.qtdValorArray = this.qtdValorArray;
                        t38.prefixo = pref;
                        t38.servico = serv;
                        t38.dataViagem = data;
                        t38.horaViagem = hora;
                        t38.valViagem = preco;
                        t38.cidade1 = v1;
                        t38.cidade2 = v2;
                        t38.setValores();
                        t38.setLocationRelativeTo(null);
                        t38.setVisible(true);
                        this.dispose();
                        System.out.println("<--------");
                        break;
                    case 42:
                        G7_1200_42Remarcacao t42 = new G7_1200_42Remarcacao();
                        System.out.println(F.getLogin());
                        System.out.println("---------->");
                        t42.usuario = F.getLogin();
                        t42.lista = this.list;
                        t42.vBilheteAntigo = this.vBilheteAntigo;
                        t42.qtdValorArray = this.qtdValorArray;
                        t42.prefixo = pref;
                        t42.servico = serv;
                        t42.dataViagem = data;
                        t42.horaViagem = hora;
                        t42.valViagem = preco;
                        t42.cidade1 = v1;
                        t42.cidade2 = v2;
                        t42.setValores();
                        t42.setLocationRelativeTo(null);
                        t42.setVisible(true);
                        this.dispose();
                        System.out.println("<--------");
                        break;
                    default:
                        break;
                }
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, ex, "Erro", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btVerMapActionPerformed

    private void btPassageirosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPassageirosActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        System.out.println("000");
        linhaSelec = jTable.getSelectedRow();
        System.out.println("001");
        if(jTable.getSelectedRow() == -1){
            if(jTable.getSelectedRowCount() == 0){
                JOptionPane.showMessageDialog(null, "Tabela está vazia", "Não Encontrado", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Selecione um Perfil !!!", "Não Encontrado", JOptionPane.INFORMATION_MESSAGE);
            }
        }else{
            String diaViagem = model.getValueAt(linhaSelec, 1).toString();
            int codServico = Integer.parseInt(model.getValueAt(linhaSelec, 0).toString());
            Connection conn = ConnectionFactory.getConnection();
            System.out.println("000");
            try{
                this.toBack();
                System.out.println("dia: " + diaViagem);
                System.out.println("cod: " + codServico);
                Map<String, Object> parametros = new HashMap<>();
                parametros.put("dataViagem", diaViagem);
                parametros.put("codServico", codServico);
                JasperPrint jp = JasperFillManager.fillReport("src/Reports/iReportMapaViagem.jasper", parametros, conn);
                JasperViewer.viewReport(jp, false);
            }catch(JRException ex){
                System.out.println("Erro ex: " + ex);
                Logger.getLogger(TelaVendaRemarcacao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btPassageirosActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btFechar;
    private javax.swing.JButton btItinerario;
    private javax.swing.JButton btPassageiros;
    private javax.swing.JButton btVerMap;
    private javax.swing.JComboBox<String> cbCid1;
    private javax.swing.JComboBox<String> cbCid2;
    private javax.swing.JComboBox<String> cbCod1;
    private javax.swing.JComboBox<String> cbCod2;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JFormattedTextField txtServico;
    // End of variables declaration//GEN-END:variables

}
