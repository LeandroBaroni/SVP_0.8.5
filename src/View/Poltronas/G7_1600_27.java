/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Poltronas;

import Dao.Class.Funcionario;
import Dao.Class.Venda;
import Dao.Controller.FuncionarioControlador;
import Dao.Controller.VendaControlador;
import View.CarrinhoCompra;
import View.TelaVenda;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Leandro Baroni
 */
public class G7_1600_27 extends javax.swing.JFrame {

    Funcionario F = new Funcionario();
    FuncionarioControlador FC = new FuncionarioControlador();
    VendaControlador VC = new VendaControlador();

    int poltrona;
    boolean clicked = true;
    boolean cor;

    public ArrayList<Venda> lista = new ArrayList<>();
    public ArrayList<Venda> lista2 = new ArrayList<>();
    public ArrayList<Venda> listaVenda = new ArrayList<>();
    public ArrayList<Venda> setPoltOcupada = new ArrayList<>();

    public List<Venda> V = new ArrayList<>();

    public String usuario;
    public int qtdValorArray;
    public int prefixo;
    public int servico;
    public String dataViagem;
    public String horaViagem;
    public double valViagem;
    
    
    
    public int cidade1;
    public int cidade2;
    JButton jButton = new JButton();

    /**
     * Creates new form G7_1600_27
     */

    public G7_1600_27() {
        initComponents();
    }

    public void aviso(){
        JOptionPane.showMessageDialog(null, "Para declinar de poltrona, siga para a Cesta de Compras.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }
    public void setValores(){
        F = FC.buscar(usuario);
        usuario = F.getLogin();
        verificarPoltrona();
        verifPoltCesta();
    }

    public void verifPoltCesta(){
        for (Venda venda : lista) {
            System.out.println("poltronas na cesta: " + venda.getNumPoltrona());
            if(jButton01.getText().trim().equalsIgnoreCase("0"+Integer.toString(venda.getNumPoltrona())) && this.servico == venda.getServico()){
                jButton01.setBackground(Color.green);
            }
            if(jButton02.getText().trim().equalsIgnoreCase("0"+Integer.toString(venda.getNumPoltrona())) && this.servico == venda.getServico()){
                jButton02.setBackground(Color.green);
            }
            if(jButton03.getText().trim().equalsIgnoreCase("0"+Integer.toString(venda.getNumPoltrona())) && this.servico == venda.getServico()){
                jButton03.setBackground(Color.green);
            }
            if(jButton04.getText().trim().equalsIgnoreCase("0"+Integer.toString(venda.getNumPoltrona())) && this.servico == venda.getServico()){
                jButton04.setBackground(Color.green);
            }
            if(jButton05.getText().trim().equalsIgnoreCase("0"+Integer.toString(venda.getNumPoltrona())) && this.servico == venda.getServico()){
                jButton05.setBackground(Color.green);
            }
            if(jButton06.getText().trim().equalsIgnoreCase("0"+Integer.toString(venda.getNumPoltrona())) && this.servico == venda.getServico()){
                jButton06.setBackground(Color.green);
            }
            if(jButton07.getText().trim().equalsIgnoreCase("0"+Integer.toString(venda.getNumPoltrona())) && this.servico == venda.getServico()){
                jButton07.setBackground(Color.green);
            }
            if(jButton08.getText().trim().equalsIgnoreCase("0"+Integer.toString(venda.getNumPoltrona())) && this.servico == venda.getServico()){
                jButton08.setBackground(Color.green);
            }
            if(jButton09.getText().trim().equalsIgnoreCase("0"+Integer.toString(venda.getNumPoltrona())) && this.servico == venda.getServico()){
                jButton09.setBackground(Color.green);
            }
            if(jButton10.getText().trim().equalsIgnoreCase(Integer.toString(venda.getNumPoltrona())) && this.servico == venda.getServico()){
                jButton10.setBackground(Color.green);
            }
            if(jButton11.getText().trim().equalsIgnoreCase(Integer.toString(venda.getNumPoltrona())) && this.servico == venda.getServico()){
                jButton11.setBackground(Color.green);
            }
            if(jButton12.getText().trim().equalsIgnoreCase(Integer.toString(venda.getNumPoltrona())) && this.servico == venda.getServico()){
                jButton12.setBackground(Color.green);
            }
            if(jButton13.getText().trim().equalsIgnoreCase(Integer.toString(venda.getNumPoltrona())) && this.servico == venda.getServico()){
                jButton13.setBackground(Color.green);
            }
            if(jButton14.getText().trim().equalsIgnoreCase(Integer.toString(venda.getNumPoltrona())) && this.servico == venda.getServico()){
                jButton14.setBackground(Color.green);
            }
            if(jButton15.getText().trim().equalsIgnoreCase(Integer.toString(venda.getNumPoltrona())) && this.servico == venda.getServico()){
                jButton15.setBackground(Color.green);
            }
            if(jButton16.getText().trim().equalsIgnoreCase(Integer.toString(venda.getNumPoltrona())) && this.servico == venda.getServico()){
                jButton16.setBackground(Color.green);
            }
            if(jButton17.getText().trim().equalsIgnoreCase(Integer.toString(venda.getNumPoltrona())) && this.servico == venda.getServico()){
                jButton17.setBackground(Color.green);
            }
            if(jButton18.getText().trim().equalsIgnoreCase(Integer.toString(venda.getNumPoltrona())) && this.servico == venda.getServico()){
                jButton18.setBackground(Color.green);
            }
            if(jButton19.getText().trim().equalsIgnoreCase(Integer.toString(venda.getNumPoltrona())) && this.servico == venda.getServico()){
                jButton19.setBackground(Color.green);
            }
            if(jButton20.getText().trim().equalsIgnoreCase(Integer.toString(venda.getNumPoltrona())) && this.servico == venda.getServico()){
                jButton20.setBackground(Color.green);
            }
            if(jButton21.getText().trim().equalsIgnoreCase(Integer.toString(venda.getNumPoltrona())) && this.servico == venda.getServico()){
                jButton21.setBackground(Color.green);
            }
            if(jButton22.getText().trim().equalsIgnoreCase(Integer.toString(venda.getNumPoltrona())) && this.servico == venda.getServico()){
                jButton22.setBackground(Color.green);
            }
            if(jButton23.getText().trim().equalsIgnoreCase(Integer.toString(venda.getNumPoltrona())) && this.servico == venda.getServico()){
                jButton23.setBackground(Color.green);
            }
            if(jButton24.getText().trim().equalsIgnoreCase(Integer.toString(venda.getNumPoltrona())) && this.servico == venda.getServico()){
                jButton24.setBackground(Color.green);
            }
            if(jButton25.getText().trim().equalsIgnoreCase(Integer.toString(venda.getNumPoltrona())) && this.servico == venda.getServico()){
                jButton25.setBackground(Color.green);
            }
            if(jButton26.getText().trim().equalsIgnoreCase(Integer.toString(venda.getNumPoltrona())) && this.servico == venda.getServico()){
                jButton26.setBackground(Color.green);
            }
            if(jButton27.getText().trim().equalsIgnoreCase(Integer.toString(venda.getNumPoltrona())) && this.servico == venda.getServico()){
                jButton27.setBackground(Color.green);
            }
        }
    }

    public void verificarPoltrona(){
        setPoltOcupada = (ArrayList<Venda>) VC.buscarPoltOcupada(dataViagem, servico);
        for (Venda venda : setPoltOcupada) {
            System.out.println("cod: " + venda.getCodBilhete());
            System.out.println("numPoltrona: " + venda.getNumPoltrona());
            System.out.println("cod: " + venda.getNomeCliente());
            System.out.println("-----------------------------------");
            if(jButton01.getText().trim().equalsIgnoreCase("0"+Integer.toString(venda.getNumPoltrona()))){
                jButton01.setBackground(Color.red);
            }
            if(jButton02.getText().trim().equalsIgnoreCase("0"+Integer.toString(venda.getNumPoltrona()))){
                jButton02.setBackground(Color.red);
            }
            if(jButton03.getText().trim().equalsIgnoreCase("0"+Integer.toString(venda.getNumPoltrona()))){
                jButton03.setBackground(Color.red);
            }
            if(jButton04.getText().trim().equalsIgnoreCase("0"+Integer.toString(venda.getNumPoltrona()))){
                jButton04.setBackground(Color.red);
            }
            if(jButton05.getText().trim().equalsIgnoreCase("0"+Integer.toString(venda.getNumPoltrona()))){
                jButton05.setBackground(Color.red);
            }
            if(jButton06.getText().trim().equalsIgnoreCase("0"+Integer.toString(venda.getNumPoltrona()))){
                jButton06.setBackground(Color.red);
            }
            if(jButton07.getText().trim().equalsIgnoreCase("0"+Integer.toString(venda.getNumPoltrona()))){
                jButton07.setBackground(Color.red);
            }
            if(jButton08.getText().trim().equalsIgnoreCase("0"+Integer.toString(venda.getNumPoltrona()))){
                jButton08.setBackground(Color.red);
            }
            if(jButton09.getText().trim().equalsIgnoreCase("0"+Integer.toString(venda.getNumPoltrona()))){
                jButton09.setBackground(Color.red);
            }
            if(jButton10.getText().trim().equalsIgnoreCase(Integer.toString(venda.getNumPoltrona()))){
                jButton10.setBackground(Color.red);
            }
            if(jButton11.getText().trim().equalsIgnoreCase(Integer.toString(venda.getNumPoltrona()))){
                jButton11.setBackground(Color.red);
            }
            if(jButton12.getText().trim().equalsIgnoreCase(Integer.toString(venda.getNumPoltrona()))){
                jButton12.setBackground(Color.red);
            }
            if(jButton13.getText().trim().equalsIgnoreCase(Integer.toString(venda.getNumPoltrona()))){
                jButton13.setBackground(Color.red);
            }
            if(jButton14.getText().trim().equalsIgnoreCase(Integer.toString(venda.getNumPoltrona()))){
                jButton14.setBackground(Color.red);
            }
            if(jButton15.getText().trim().equalsIgnoreCase(Integer.toString(venda.getNumPoltrona()))){
                jButton15.setBackground(Color.red);
            }
            if(jButton16.getText().trim().equalsIgnoreCase(Integer.toString(venda.getNumPoltrona()))){
                jButton16.setBackground(Color.red);
            }
            if(jButton17.getText().trim().equalsIgnoreCase(Integer.toString(venda.getNumPoltrona()))){
                jButton17.setBackground(Color.red);
            }
            if(jButton18.getText().trim().equalsIgnoreCase(Integer.toString(venda.getNumPoltrona()))){
                jButton18.setBackground(Color.red);
            }
            if(jButton19.getText().trim().equalsIgnoreCase(Integer.toString(venda.getNumPoltrona()))){
                jButton19.setBackground(Color.red);
            }
            if(jButton20.getText().trim().equalsIgnoreCase(Integer.toString(venda.getNumPoltrona()))){
                jButton20.setBackground(Color.red);
            }
            if(jButton21.getText().trim().equalsIgnoreCase(Integer.toString(venda.getNumPoltrona()))){
                jButton21.setBackground(Color.red);
            }
            if(jButton22.getText().trim().equalsIgnoreCase(Integer.toString(venda.getNumPoltrona()))){
                jButton22.setBackground(Color.red);
            }
            if(jButton23.getText().trim().equalsIgnoreCase(Integer.toString(venda.getNumPoltrona()))){
                jButton23.setBackground(Color.red);
            }
            if(jButton24.getText().trim().equalsIgnoreCase(Integer.toString(venda.getNumPoltrona()))){
                jButton24.setBackground(Color.red);
            }
            if(jButton25.getText().trim().equalsIgnoreCase(Integer.toString(venda.getNumPoltrona()))){
                jButton25.setBackground(Color.red);
            }
            if(jButton26.getText().trim().equalsIgnoreCase(Integer.toString(venda.getNumPoltrona()))){
                jButton26.setBackground(Color.red);
            }
            if(jButton27.getText().trim().equalsIgnoreCase(Integer.toString(venda.getNumPoltrona()))){
                jButton27.setBackground(Color.red);
            }
        }
    }

    public void addList(int a){
        F = FC.buscar(usuario);
        Double valor = this.valViagem; 
        int polt = a;
        int idPrefixo = this.prefixo;
        int idServico = this.servico;
        int codFunc = F.getCodigo();
        String estBil = "V";
        String estPolt = "O";
        String data = this.dataViagem;
        String dataVenda = "";
        String hora = this.horaViagem;
        String horaVenda = "";
        String telefone = "";
        lista.add(new Venda(lista.size(), 0, valor, "", "", "", polt, idPrefixo, idServico, codFunc, estBil, estPolt, dataVenda, horaVenda, telefone, data, hora));
        listaVenda.add(new Venda(listaVenda.size(), 0, valor, "", "", "", polt, idPrefixo, idServico, codFunc, estBil, estPolt, dataVenda, horaVenda, telefone, data, hora));
        mostrarValores();
    }

    public void mostrarValores(){
        System.out.println("------------");
        double totalValor = 0.0;
        for (Venda venda : lista) {
            totalValor = totalValor + venda.getValor();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton01 = new javax.swing.JButton();
        jButton02 = new javax.swing.JButton();
        jButton03 = new javax.swing.JButton();
        jButton04 = new javax.swing.JButton();
        jButton05 = new javax.swing.JButton();
        jButton07 = new javax.swing.JButton();
        jButton06 = new javax.swing.JButton();
        jButton08 = new javax.swing.JButton();
        jButton09 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();
        btCarrinho = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jButton01.setText("01");
        jButton01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton01ActionPerformed(evt);
            }
        });

        jButton02.setText("02");
        jButton02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton02ActionPerformed(evt);
            }
        });

        jButton03.setText("03");
        jButton03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton03ActionPerformed(evt);
            }
        });

        jButton04.setText("04");
        jButton04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton04ActionPerformed(evt);
            }
        });

        jButton05.setText("05");
        jButton05.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton05ActionPerformed(evt);
            }
        });

        jButton07.setText("07");
        jButton07.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton07ActionPerformed(evt);
            }
        });

        jButton06.setText("06");
        jButton06.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton06ActionPerformed(evt);
            }
        });

        jButton08.setText("08");
        jButton08.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton08ActionPerformed(evt);
            }
        });

        jButton09.setText("09");
        jButton09.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton09ActionPerformed(evt);
            }
        });

        jButton10.setText("10");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setText("11");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("12");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setText("13");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setText("14");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setText("15");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setText("16");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setText("17");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setText("18");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setText("19");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton20.setText("20");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton21.setText("21");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jButton22.setText("22");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton23.setText("23");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jButton24.setText("24");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jButton25.setText("25");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        jButton26.setText("26");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jButton27.setText("27");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        btCarrinho.setText("Cesta de Com...");
        btCarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCarrinhoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(btVoltar)
                .addGap(18, 18, 18)
                .addComponent(btCarrinho))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton01)
                        .addGap(10, 10, 10)
                        .addComponent(jButton04)
                        .addGap(14, 14, 14)
                        .addComponent(jButton06)
                        .addGap(18, 18, 18)
                        .addComponent(jButton09)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(258, 258, 258)
                                .addComponent(jButton24)
                                .addGap(18, 18, 18)
                                .addComponent(jButton27))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton12)
                                .addGap(18, 18, 18)
                                .addComponent(jButton15)
                                .addGap(24, 24, 24)
                                .addComponent(jButton18)
                                .addGap(18, 18, 18)
                                .addComponent(jButton21))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton02)
                            .addComponent(jButton03))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jButton05)
                                .addGap(18, 18, 18)
                                .addComponent(jButton08)
                                .addGap(18, 18, 18)
                                .addComponent(jButton11)
                                .addGap(18, 18, 18)
                                .addComponent(jButton14)
                                .addGap(18, 18, 18)
                                .addComponent(jButton17)
                                .addGap(18, 18, 18)
                                .addComponent(jButton20)
                                .addGap(18, 18, 18)
                                .addComponent(jButton23)
                                .addGap(18, 18, 18)
                                .addComponent(jButton26))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(jButton07)
                                .addGap(18, 18, 18)
                                .addComponent(jButton10)
                                .addGap(18, 18, 18)
                                .addComponent(jButton13)
                                .addGap(18, 18, 18)
                                .addComponent(jButton16)
                                .addGap(18, 18, 18)
                                .addComponent(jButton19)
                                .addGap(18, 18, 18)
                                .addComponent(jButton22)
                                .addGap(18, 18, 18)
                                .addComponent(jButton25)))
                        .addGap(51, 51, 51))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btVoltar)
                    .addComponent(btCarrinho))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jButton02))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton10)
                                .addComponent(jButton07)
                                .addComponent(jButton03))
                            .addComponent(jButton13)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton16)
                                .addComponent(jButton19)
                                .addComponent(jButton22)
                                .addComponent(jButton25)))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton11)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton14)
                                .addComponent(jButton17)
                                .addComponent(jButton20)
                                .addComponent(jButton23)
                                .addComponent(jButton26))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton08)
                                .addComponent(jButton05)))))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton18)
                        .addComponent(jButton21))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton24)
                        .addComponent(jButton27))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton01)
                            .addComponent(jButton04)
                            .addComponent(jButton06)
                            .addComponent(jButton09)
                            .addComponent(jButton12)
                            .addComponent(jButton15))))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton01ActionPerformed
        if(clicked){
            if(jButton01.getBackground() == Color.green){
                aviso();
            }else if(jButton01.getBackground() == Color.red){
                jButton01.isOpaque();
            }else{
                jButton01.setBackground(Color.green);
                this.poltrona = Integer.parseInt(jButton01.getText());
                addList(this.poltrona);
            }
        }
    }//GEN-LAST:event_jButton01ActionPerformed

    private void jButton02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton02ActionPerformed
        if(clicked){
            if(jButton18.getBackground() == Color.green){
                aviso();
            }else if(jButton18.getBackground() == Color.red){
                jButton18.isOpaque();
            }else{
                jButton18.setBackground(Color.green);
                this.poltrona = Integer.parseInt(jButton18.getText());
                addList(this.poltrona);
            }
        }
    }//GEN-LAST:event_jButton02ActionPerformed

    private void jButton03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton03ActionPerformed
        if(clicked){
            if(jButton03.getBackground() == Color.green){
                aviso();
            }else if(jButton03.getBackground() == Color.red){
                jButton03.isOpaque();
            }else{
                jButton03.setBackground(Color.green);
                this.poltrona = Integer.parseInt(jButton03.getText());
                addList(this.poltrona);
            }
        }
    }//GEN-LAST:event_jButton03ActionPerformed

    private void jButton04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton04ActionPerformed
        if(clicked){
            if(jButton04.getBackground() == Color.green){
                aviso();
            }else if(jButton04.getBackground() == Color.red){
                jButton04.isOpaque();
            }else{
                jButton04.setBackground(Color.green);
                this.poltrona = Integer.parseInt(jButton04.getText());
                addList(this.poltrona);
            }
        }
    }//GEN-LAST:event_jButton04ActionPerformed

    private void jButton05ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton05ActionPerformed
        if(clicked){
            if(jButton05.getBackground() == Color.green){
                aviso();
            }else if(jButton05.getBackground() == Color.red){
                jButton05.isOpaque();
            }else{
                jButton05.setBackground(Color.green);
                this.poltrona = Integer.parseInt(jButton05.getText());
                addList(this.poltrona);
            }
        }
    }//GEN-LAST:event_jButton05ActionPerformed

    private void jButton06ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton06ActionPerformed
        if(clicked){
            if(jButton06.getBackground() == Color.green){
                aviso();
            }else if(jButton06.getBackground() == Color.red){
                jButton06.isOpaque();
            }else{
                jButton06.setBackground(Color.green);
                this.poltrona = Integer.parseInt(jButton06.getText());
                addList(this.poltrona);
            }
        }
    }//GEN-LAST:event_jButton06ActionPerformed

    private void jButton07ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton07ActionPerformed
        if(clicked){
            if(jButton07.getBackground() == Color.green){
                aviso();
            }else if(jButton07.getBackground() == Color.red){
                jButton07.isOpaque();
            }else{
                jButton07.setBackground(Color.green);
                this.poltrona = Integer.parseInt(jButton07.getText());
                addList(this.poltrona);
            }
        }
    }//GEN-LAST:event_jButton07ActionPerformed

    private void jButton08ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton08ActionPerformed
        if(clicked){
            if(jButton08.getBackground() == Color.green){
                aviso();
            }else if(jButton08.getBackground() == Color.red){
                jButton08.isOpaque();
            }else{
                jButton08.setBackground(Color.green);
                this.poltrona = Integer.parseInt(jButton08.getText());
                addList(this.poltrona);
            }
        }
    }//GEN-LAST:event_jButton08ActionPerformed

    private void jButton09ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton09ActionPerformed
        if(clicked){
            if(jButton09.getBackground() == Color.green){
                aviso();
            }else if(jButton09.getBackground() == Color.red){
                jButton09.isOpaque();
            }else{
                jButton09.setBackground(Color.green);
                this.poltrona = Integer.parseInt(jButton09.getText());
                addList(this.poltrona);
            }
        }
    }//GEN-LAST:event_jButton09ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        if(clicked){
            if(jButton10.getBackground() == Color.green){
                aviso();
            }else if(jButton10.getBackground() == Color.red){
                jButton10.isOpaque();
            }else{
                jButton10.setBackground(Color.green);
                this.poltrona = Integer.parseInt(jButton10.getText());
                addList(this.poltrona);
            }
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        if(clicked){
            if(jButton11.getBackground() == Color.green){
                aviso();
            }else if(jButton11.getBackground() == Color.red){
                jButton11.isOpaque();
            }else{
                jButton11.setBackground(Color.green);
                this.poltrona = Integer.parseInt(jButton11.getText());
                addList(this.poltrona);
            }
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        if(clicked){
            if(jButton12.getBackground() == Color.green){
                aviso();
            }else if(jButton12.getBackground() == Color.red){
                jButton12.isOpaque();
            }else{
                jButton12.setBackground(Color.green);
                this.poltrona = Integer.parseInt(jButton12.getText());
                addList(this.poltrona);
            }
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        if(clicked){
            if(jButton13.getBackground() == Color.green){
                aviso();
            }else if(jButton13.getBackground() == Color.red){
                jButton13.isOpaque();
            }else{
                jButton13.setBackground(Color.green);
                this.poltrona = Integer.parseInt(jButton13.getText());
                addList(this.poltrona);
            }
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        if(clicked){
            if(jButton14.getBackground() == Color.green){
                aviso();
            }else if(jButton14.getBackground() == Color.red){
                jButton14.isOpaque();
            }else{
                jButton14.setBackground(Color.green);
                this.poltrona = Integer.parseInt(jButton14.getText());
                addList(this.poltrona);
            }
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        if(clicked){
            if(jButton15.getBackground() == Color.green){
                aviso();
            }else if(jButton15.getBackground() == Color.red){
                jButton15.isOpaque();
            }else{
                jButton15.setBackground(Color.green);
                this.poltrona = Integer.parseInt(jButton15.getText());
                addList(this.poltrona);
            }
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        if(clicked){
            if(jButton16.getBackground() == Color.green){
                aviso();
            }else if(jButton16.getBackground() == Color.red){
                jButton16.isOpaque();
            }else{
                jButton16.setBackground(Color.green);
                this.poltrona = Integer.parseInt(jButton16.getText());
                addList(this.poltrona);
            }
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        if(clicked){
            if(jButton17.getBackground() == Color.green){
                aviso();
            }else if(jButton17.getBackground() == Color.red){
                jButton17.isOpaque();
            }else{
                jButton17.setBackground(Color.green);
                this.poltrona = Integer.parseInt(jButton17.getText());
                addList(this.poltrona);
            }
        }
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        if(clicked){
            if(jButton18.getBackground() == Color.green){
                aviso();
            }else if(jButton18.getBackground() == Color.red){
                jButton18.isOpaque();
            }else{
                jButton18.setBackground(Color.green);
                this.poltrona = Integer.parseInt(jButton18.getText());
                addList(this.poltrona);
            }
        }
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        if(clicked){
            if(jButton19.getBackground() == Color.green){
                aviso();
            }else if(jButton19.getBackground() == Color.red){
                jButton19.isOpaque();
            }else{
                jButton19.setBackground(Color.green);
                this.poltrona = Integer.parseInt(jButton19.getText());
                addList(this.poltrona);
            }
        }
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        if(clicked){
            if(jButton20.getBackground() == Color.green){
                aviso();
            }else if(jButton20.getBackground() == Color.red){
                jButton20.isOpaque();
            }else{
                jButton20.setBackground(Color.green);
                this.poltrona = Integer.parseInt(jButton20.getText());
                addList(this.poltrona);
            }
        }
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        if(clicked){
            if(jButton21.getBackground() == Color.green){
                aviso();
            }else if(jButton21.getBackground() == Color.red){
                jButton21.isOpaque();
            }else{
                jButton21.setBackground(Color.green);
                this.poltrona = Integer.parseInt(jButton21.getText());
                addList(this.poltrona);
            }
        }
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        if(clicked){
            if(jButton22.getBackground() == Color.green){
                aviso();
            }else if(jButton22.getBackground() == Color.red){
                jButton22.isOpaque();
            }else{
                jButton22.setBackground(Color.green);
                this.poltrona = Integer.parseInt(jButton22.getText());
                addList(this.poltrona);
            }
        }
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        if(clicked){
            if(jButton23.getBackground() == Color.green){
                aviso();
            }else if(jButton23.getBackground() == Color.red){
                jButton23.isOpaque();
            }else{
                jButton23.setBackground(Color.green);
                this.poltrona = Integer.parseInt(jButton23.getText());
                addList(this.poltrona);
            }
        }
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        if(clicked){
            if(jButton24.getBackground() == Color.green){
                aviso();
            }else if(jButton24.getBackground() == Color.red){
                jButton24.isOpaque();
            }else{
                jButton24.setBackground(Color.green);
                this.poltrona = Integer.parseInt(jButton24.getText());
                addList(this.poltrona);
            }
        }
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        if(clicked){
            if(jButton25.getBackground() == Color.green){
                aviso();
            }else if(jButton25.getBackground() == Color.red){
                jButton25.isOpaque();
            }else{
                jButton25.setBackground(Color.green);
                this.poltrona = Integer.parseInt(jButton25.getText());
                addList(this.poltrona);
            }
        }
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        if(clicked){
            if(jButton26.getBackground() == Color.green){
                aviso();
            }else if(jButton26.getBackground() == Color.red){
                jButton26.isOpaque();
            }else{
                jButton26.setBackground(Color.green);
                this.poltrona = Integer.parseInt(jButton26.getText());
                addList(this.poltrona);
            }
        }
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        if(clicked){
            if(jButton27.getBackground() == Color.green){
                aviso();
            }else if(jButton27.getBackground() == Color.red){
                jButton27.isOpaque();
            }else{
                jButton27.setBackground(Color.green);
                this.poltrona = Integer.parseInt(jButton27.getText());
                addList(this.poltrona);
            }
        }
    }//GEN-LAST:event_jButton27ActionPerformed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        TelaVenda tela = new TelaVenda();
        tela.usuario = this.usuario;
        tela.list = this.lista;
        tela.setValores();
        this.dispose();
        tela.setLocationRelativeTo(null);
        tela.setVisible(true);
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCarrinhoActionPerformed
        System.out.println("----------------------------------");
        CarrinhoCompra tela = new CarrinhoCompra();
        tela.lista = this.lista;
        tela.usuario = this.usuario;
        System.out.println("this.usuario: " + F.getLogin());
        tela.servico = this.servico;
        tela.prefixo = this.prefixo;
        tela.valor = this.valViagem;
        tela.data = this.dataViagem;
        tela.hora = this.horaViagem;
        tela.cidade1 = this.cidade1;
        tela.cidade2 = this.cidade2;
        tela.setValores();
        tela.setLocationRelativeTo(null);
        tela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btCarrinhoActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCarrinho;
    private javax.swing.JButton btVoltar;
    private javax.swing.JButton jButton01;
    private javax.swing.JButton jButton02;
    private javax.swing.JButton jButton03;
    private javax.swing.JButton jButton04;
    private javax.swing.JButton jButton05;
    private javax.swing.JButton jButton06;
    private javax.swing.JButton jButton07;
    private javax.swing.JButton jButton08;
    private javax.swing.JButton jButton09;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    // End of variables declaration//GEN-END:variables
}
