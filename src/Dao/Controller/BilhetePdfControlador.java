/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.Controller;

import Dao.Class.BilhetePdf;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.lowagie.text.Font;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Conexao;

/**
 *
 * @author Leandro Baroni
 */
public class BilhetePdfControlador {
    private BilhetePdf b;
    private Conexao C;
    String erroConexao;
    Paragraph p;
    Document doc;

    Date dataAtual = new Date();

    DateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
    DateFormat sdfHora = new SimpleDateFormat("hh:mm:ss");

    public BilhetePdfControlador() {
        C = new Conexao("jdbc:mysql://localhost:3306/db_svp", "root", "");
        erroConexao = C.getMensagemErro();
    }

    public String getMensagemErro() {
        return erroConexao;
    }


    public void createPdfFile(BilhetePdf bilhete){
        String file = bilhete.getCodBilhete().getCodBilhete() + ".pdf";
        String dataAt = sdfData.format(dataAtual);
        String horaAt = sdfHora.format(dataAtual);
        doc = new Document();
        //abaixo deve receber o numero de bilhete
        try{
            doc.isOpen();
            PdfWriter.getInstance(doc, new FileOutputStream(file));
            doc.open();
            p = new Paragraph("Cupom Não Fiscal");
            p.setAlignment(1);
            doc.add(p);
            p = new Paragraph("");
            doc.add(p);
            p = new Paragraph("Rua Terezina, 75. Vila Paulo Roberto, Presidente Prudente - SP");
            p.setAlignment(1);
            doc.add(p);
            p = new Paragraph("____________________________________________________________________________");
            doc.add(p);
            p = new Paragraph("Fatec");
            p.setAlignment(1);
            doc.add(p);
            p = new Paragraph("Faculdade de Tecnologia de Presidente Prudente");
            p.setAlignment(1);
            doc.add(p);
            p = new Paragraph("CNPJ: 62.823.257/0001-09");
            p.setAlignment(1);
            doc.add(p);
            p = new Paragraph("CEP: 19046-230");
            p.setAlignment(1);
            doc.add(p);
            p = new Paragraph("Tel: (18)3916-7887 / 3917-2064");
            p.setAlignment(1);
            doc.add(p);
            p = new Paragraph("");
            doc.add(p);
            p = new Paragraph("Documento Auxiliar do Bilhete de Passagem Eletrônico");
            p.setAlignment(1);
            doc.add(p);
            p = new Paragraph("____________________________________________________________________________");
            doc.add(p);


            p = new Paragraph("");
            doc.add(p);
            p = new Paragraph("Origem: " + bilhete.getCidadeOrigemCod().getCidadeInicial() + " " + bilhete.getCidadeOrigemNome().getCidade());
            p.setAlignment(1);
            doc.add(p);
            p = new Paragraph("Destino: " + bilhete.getCidadeDestinoCod().getCidadeFinal() + " " + bilhete.getCidadeDestinoNome().getCidade());
            p.setAlignment(1);
            doc.add(p);
            p = new Paragraph("Data: " + bilhete.getDataViagem().getdViagem() + " | " + bilhete.getHoraViagem().getdViagem() + " | " + "Poltrona: " + bilhete.getNumPoltrona().getNumPoltrona());
            p.setAlignment(1);
            doc.add(p);
            p = new Paragraph("Prefixo: " + bilhete.getCodPrefixo().getPrefixo());
            p.setAlignment(1);
            doc.add(p);
            p = new Paragraph("____________________________________________________________________________");
            doc.add(p);
            p = new Paragraph("Tarifa: " + bilhete.getValorTarifa().getPrecoTotal());
            doc.add(p);
            p = new Paragraph("Taxa de Embarque: " + bilhete.getValorTaxaRod().getPrecoTotal());
            doc.add(p);
            p = new Paragraph("Pedágio: " + bilhete.getValorPedagio().getPrecoTotal());
            doc.add(p);
            p = new Paragraph("Valor Total: " + bilhete.getValorTotal().getPrecoTotal());
            doc.add(p);
            p = new Paragraph("");
            doc.add(p);
            p = new Paragraph("PASSAGEIRO: " + bilhete.getNomeCliente().getNomeCliente());
            p.setAlignment(1);
            doc.add(p);
            p = new Paragraph("DOC RG: " + bilhete.getRgCliente().getNomeCliente());
            p.setAlignment(1);
            doc.add(p);
            p = new Paragraph("DOC CPF: " + bilhete.getCpfCnpjCliente().getNomeCliente());
            p.setAlignment(1);
            doc.add(p);
            p = new Paragraph("");
            doc.add(p);
            p = new Paragraph("Nº Bilhete: " + bilhete.getCodBilhete().getCodBilhete());
            p.setAlignment(1);
            doc.add(p);
            p = new Paragraph("____________________________________________________________________________");
            doc.add(p);
            p = new Paragraph("Lei Federal 12.741/2012");
            p.setAlignment(1);
            doc.add(p);
            p = new Paragraph("____________________________________________________________________________");
            doc.add(p);
            p = new Paragraph("leandro.baroni@fatec.sp.gov.br");
            p.setAlignment(1);
            doc.add(p);
            p = new Paragraph("____________________________________________________________________________");
            doc.add(p);
            p = new Paragraph("Emissão: " + dataAt + " | " + horaAt);
            p.setAlignment(1);
            doc.add(p);
            Desktop.getDesktop().open(new File(file));
        }catch(DocumentException | FileNotFoundException ex){
            System.out.println("Erro: " + ex);
        } catch (IOException ex) {
            Logger.getLogger(BilhetePdfControlador.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            doc.close();
        }
    }

    public BilhetePdf getDadosBilhete(String nomeB, int polt, int serv, String dataAt, String horaAt)  {
        String sql = "SELECT v.codigo_bilhete, v.nome, v.documento, v.documento2, v.telefone, v.num_poltrona, v.dataV, v.horaV, "
                        + "s.codigo, s.data_viagem, s.horario_viagem, "
                        + "l.prefixo, l.cidade_inicial, c1.cidade as nomeCidade1, l.cidade_final, c2.cidade as nomeCidade2, "
                        + "l.tarifa, l.taxa_rod, l.pedagio, l.preco_total " +
                     "FROM servico s, venda v, linha l, cidade c1, cidade c2 " +
                     "WHERE v.dataV = '"+dataAt+"' AND horaV = '"+horaAt+"' AND v.estado = 'V' AND v.nome = '"+nomeB+"' AND v.num_poltrona = '"+polt+"'"
                        + "AND v.servico_codigo = '"+serv+"' AND s.codigo = v.servico_codigo AND v.linha_id = l.id AND l.cidade_inicial = c1.codigo AND l.cidade_final = c2.codigo " +
                     "ORDER BY v.num_poltrona";
        System.out.println(sql);
        ResultSet rs = C.consultar(sql);
        if (rs != null) {
            try {
                if ( rs.next() ) {
                    int codBilhete = rs.getInt("v.codigo_bilhete");
                    String nome = rs.getString("v.nome");
                    String rg = rs.getString("v.documento");
                    String cpfCnpj = rs.getString("v.documento2");
                    String telefone = rs.getString("v.telefone");
                    int numPoltrona = rs.getInt("v.num_Poltrona");
                    String dataVenda = rs.getString("v.dataV");
                    String horaVenda = rs.getString("v.horaV");
                    int codServico = rs.getInt("s.codigo");
                    String dataViagem = rs.getString("s.data_Viagem");
                    String horaViagem = rs.getString("s.horario_Viagem");
                    int codPrefixo = rs.getInt("l.prefixo");
                    int cidadeOrigemCod = rs.getInt("l.cidade_inicial");
                    int cidadeDestinoCod = rs.getInt("l.cidade_final");
                    String cidadeOrigemNome = rs.getString("nomeCidade1");
                    String cidadeDestinoNome = rs.getString("nomeCidade2");
                    Double tarifa = rs.getDouble("l.tarifa");
                    Double taxaRod = rs.getDouble("l.taxa_rod");
                    Double pedagio = rs.getDouble("l.pedagio");
                    Double total = rs.getDouble("l.preco_total");

                    b = new BilhetePdf(codBilhete, nome, rg, cpfCnpj, telefone, numPoltrona, dataVenda, horaVenda, codServico, dataViagem, horaViagem, codPrefixo, cidadeOrigemCod, cidadeDestinoCod, tarifa, taxaRod, pedagio, total, cidadeOrigemNome, cidadeDestinoNome);
                    return b;
                } 
            }
            catch (SQLException sqlex) {
                erroConexao = "Erro ao buscar dados de funcionário. Erro: " + sqlex;
            }
        } 
        return null;
    }

    public List<BilhetePdf> getDadosBilheteCancelamento(String dataDaViagem, int serv, String nomeB, int bilhete)  {
        List<BilhetePdf> bilhetes = new ArrayList<>(); 
        String sql = "SELECT v.codigo_bilhete, v.nome, v.documento, v.documento2, v.telefone, v.num_poltrona, v.dataV, v.horaV, "
                        + "s.codigo, s.data_viagem, s.horario_viagem, "
                        + "l.prefixo, l.cidade_inicial, c1.cidade as nomeCidade1, l.cidade_final, c2.cidade as nomeCidade2, "
                        + "l.tarifa, l.taxa_rod, l.pedagio, l.preco_total " +
                     "FROM servico s, venda v, linha l, cidade c1, cidade c2 " +
                     "WHERE v.codigo_bilhete = '"+bilhete+"' AND s.data_viagem = '"+dataDaViagem+"' AND v.estado = 'V' AND v.nome LIKE '%"+nomeB+"%' "
                        + "AND v.servico_codigo = '"+serv+"' AND s.codigo = v.servico_codigo AND v.linha_id = l.id AND l.cidade_inicial = c1.codigo AND l.cidade_final = c2.codigo " +
                     "ORDER BY v.num_poltrona";
        System.out.println(sql);
        ResultSet rs = C.consultar(sql);
        if (rs != null) {
            try {
                while ( rs.next() ) {
                    int codBilhete = rs.getInt("v.codigo_bilhete");
                    String nome = rs.getString("v.nome");
                    String rg = rs.getString("v.documento");
                    String cpfCnpj = rs.getString("v.documento2");
                    String telefone = rs.getString("v.telefone");
                    int numPoltrona = rs.getInt("v.num_Poltrona");
                    String dataVenda = rs.getString("v.dataV");
                    String horaVenda = rs.getString("v.horaV");
                    int codServico = rs.getInt("s.codigo");
                    String dataViagem = rs.getString("s.data_Viagem");
                    String horaViagem = rs.getString("s.horario_Viagem");
                    int codPrefixo = rs.getInt("l.prefixo");
                    int cidadeOrigemCod = rs.getInt("l.cidade_inicial");
                    int cidadeDestinoCod = rs.getInt("l.cidade_final");
                    String cidadeOrigemNome = rs.getString("nomeCidade1");
                    String cidadeDestinoNome = rs.getString("nomeCidade2");
                    Double tarifa = rs.getDouble("l.tarifa");
                    Double taxaRod = rs.getDouble("l.taxa_rod");
                    Double pedagio = rs.getDouble("l.pedagio");
                    Double total = rs.getDouble("l.preco_total");
                    
                    b = new BilhetePdf(codBilhete, nome, rg, cpfCnpj, telefone, numPoltrona, dataVenda, horaVenda, codServico, dataViagem, horaViagem, codPrefixo, cidadeOrigemCod, cidadeDestinoCod, tarifa, taxaRod, pedagio, total, cidadeOrigemNome, cidadeDestinoNome);
                    bilhetes.add(b);
                }
                return bilhetes; 
            }catch (SQLException sqlex) {
                erroConexao = "Erro ao buscar dados de funcionário. Erro: " + sqlex;
            }
        } 
        return null;
    }

    public List<BilhetePdf> getDadosBilheteCancelamentoPorNome(String dataDaViagem, int serv, String nomeB) {
        List<BilhetePdf> bilhetes = new ArrayList<>(); 
        String sql = "SELECT v.codigo_bilhete, v.nome, v.documento, v.documento2, v.telefone, v.num_poltrona, v.dataV, v.horaV, "
                + "s.codigo, s.data_viagem, s.horario_viagem, "
                + "l.prefixo, l.cidade_inicial, c1.cidade as nomeCidade1, l.cidade_final, c2.cidade as nomeCidade2, "
                + "l.tarifa, l.taxa_rod, l.pedagio, l.preco_total "
                + "FROM servico s, venda v, linha l, cidade c1, cidade c2 "
                + "WHERE s.data_viagem = '"+dataDaViagem+"' AND v.estado = 'V' AND v.nome LIKE '%"+nomeB+"%' "
                + "AND v.servico_codigo = '"+serv+"' AND s.codigo = v.servico_codigo AND v.linha_id = l.id AND l.cidade_inicial = c1.codigo AND l.cidade_final = c2.codigo "
                + "ORDER BY v.num_poltrona";
        System.out.println(sql);
        ResultSet res = C.consultar(sql);
        if (res!= null) {
            try {
                while ( res.next() ) {
                    int codBilhete = res.getInt("v.codigo_bilhete");
                    String nome = res.getString("v.nome");
                    String rg = res.getString("v.documento");
                    String cpfCnpj = res.getString("v.documento2");
                    String telefone = res.getString("v.telefone");
                    int numPoltrona = res.getInt("v.num_Poltrona");
                    String dataVenda = res.getString("v.dataV");
                    String horaVenda = res.getString("v.horaV");
                    int codServico = res.getInt("s.codigo");
                    String dataViagem = res.getString("s.data_Viagem");
                    String horaViagem = res.getString("s.horario_Viagem");
                    int codPrefixo = res.getInt("l.prefixo");
                    int cidadeOrigemCod = res.getInt("l.cidade_inicial");
                    int cidadeDestinoCod = res.getInt("l.cidade_final");
                    String cidadeOrigemNome = res.getString("nomeCidade1");
                    String cidadeDestinoNome = res.getString("nomeCidade2");
                    Double tarifa = res.getDouble("l.tarifa");
                    Double taxaRod = res.getDouble("l.taxa_rod");
                    Double pedagio = res.getDouble("l.pedagio");
                    Double total = res.getDouble("l.preco_total");
                    
                    b = new BilhetePdf(codBilhete, nome, rg, cpfCnpj, telefone, numPoltrona, dataVenda, horaVenda, codServico, dataViagem, horaViagem, codPrefixo, cidadeOrigemCod, cidadeDestinoCod, tarifa, taxaRod, pedagio, total, cidadeOrigemNome, cidadeDestinoNome);
                    bilhetes.add(b);
                }
                return bilhetes;
            }
            catch (SQLException sqlex) {
                erroConexao = "Erro ao buscar usuário: "+sqlex.getMessage();
            }
        }
        return null;
    }

    public List<BilhetePdf> getDadosBilheteCancelamentoPorBilhete(String dataDaViagem, int serv, int bilhete) {
        List<BilhetePdf> bilhetes = new ArrayList<>(); 
        String sql = "SELECT v.codigo_bilhete, v.nome, v.documento, v.documento2, v.telefone, v.num_poltrona, v.dataV, v.horaV, "
                + "s.codigo, s.data_viagem, s.horario_viagem, "
                + "l.prefixo, l.cidade_inicial, c1.cidade as nomeCidade1, l.cidade_final, c2.cidade as nomeCidade2, "
                + "l.tarifa, l.taxa_rod, l.pedagio, l.preco_total "
                + "FROM servico s, venda v, linha l, cidade c1, cidade c2 "
                + "WHERE s.data_viagem = '"+dataDaViagem+"' AND v.estado = 'V' AND v.codigo_bilhete = '"+bilhete+"' "
                + "AND v.servico_codigo = '"+serv+"' AND s.codigo = v.servico_codigo AND v.linha_id = l.id AND l.cidade_inicial = c1.codigo AND l.cidade_final = c2.codigo "
                + "ORDER BY v.num_poltrona";
        System.out.println(sql);
        ResultSet res = C.consultar(sql);
        if (res!= null) {
            try {
                while ( res.next() ) {
                    int codBilhete = res.getInt("v.codigo_bilhete");
                    String nome = res.getString("v.nome");
                    String rg = res.getString("v.documento");
                    String cpfCnpj = res.getString("v.documento2");
                    String telefone = res.getString("v.telefone");
                    int numPoltrona = res.getInt("v.num_Poltrona");
                    String dataVenda = res.getString("v.dataV");
                    String horaVenda = res.getString("v.horaV");
                    int codServico = res.getInt("s.codigo");
                    String dataViagem = res.getString("s.data_Viagem");
                    String horaViagem = res.getString("s.horario_Viagem");
                    int codPrefixo = res.getInt("l.prefixo");
                    int cidadeOrigemCod = res.getInt("l.cidade_inicial");
                    int cidadeDestinoCod = res.getInt("l.cidade_final");
                    String cidadeOrigemNome = res.getString("nomeCidade1");
                    String cidadeDestinoNome = res.getString("nomeCidade2");
                    Double tarifa = res.getDouble("l.tarifa");
                    Double taxaRod = res.getDouble("l.taxa_rod");
                    Double pedagio = res.getDouble("l.pedagio");
                    Double total = res.getDouble("l.preco_total");
                    
                    b = new BilhetePdf(codBilhete, nome, rg, cpfCnpj, telefone, numPoltrona, dataVenda, horaVenda, codServico, dataViagem, horaViagem, codPrefixo, cidadeOrigemCod, cidadeDestinoCod, tarifa, taxaRod, pedagio, total, cidadeOrigemNome, cidadeDestinoNome);
                    bilhetes.add(b);
                }
                return bilhetes;
            }
            catch (SQLException sqlex) {
                erroConexao = "Erro ao buscar usuário: "+sqlex.getMessage();
            }
        }
        return null;
    }
}
