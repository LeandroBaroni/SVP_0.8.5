/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.Controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;
import model.Conexao;
//Esta Classe deverá ser função de uma classe da finalização de venda
//Não esquecer
//disto
/**
 *
 * @author Leandro Baroni
 */
public class GerarPDFs {
    private Conexao C;
    String erroConexao;

    public String getMensagemErro() {
        return erroConexao;
    }
    public boolean criarPDfs(String id ){
        Document doc = new Document();
        int codBilhete = 0;
        String arquivo = codBilhete + ".pdf";
        try{
            PdfWriter.getInstance(doc, new FileOutputStream(arquivo));
            doc.open();
            Paragraph p = new Paragraph("TCC - Leandro da Silva Baroni");
            p.setAlignment(1);
            doc.add(p);
            p = new Paragraph("Espaço para criação de conteudo");
            p.setAlignment(1);
            doc.add(p);
            p = new Paragraph("sdfasdfsdafafd");
            p.setAlignment(1);
            doc.add(p);
            p = new Paragraph(" ");
            doc.add(p);
            p = new Paragraph(" ");
            doc.add(p);
            p = new Paragraph(" ");
            doc.add(p);
            p = new Paragraph("Espaço para criação de conteudo");
            doc.add(p);
            doc.close();//fechar criação de conteudo do PDF
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "BILHETE NÃO PODE SER GERADO!!!", "Erro", JOptionPane.OK_OPTION);
        }
        return true;//este return coloquei só por enfeite
                    //lembrar de mudar o aspecto do return
    }
}
