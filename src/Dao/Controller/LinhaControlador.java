/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.Controller;

import Dao.Class.Cidade;
import Dao.Class.Linha;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Conexao;

/**
 *
 * @author Leandro Baroni
 */
public class LinhaControlador {
    private Linha L;
    private final Conexao C;
    String erroConexao;
    
    public LinhaControlador() {
        C = new Conexao("jdbc:mysql://localhost:3306/db_svp", "root", "");
        erroConexao = C.getMensagemErro();
    }
    
    public String getMensagemErro() {
        return erroConexao;
    }
    
    public boolean inserir(Linha novo) {
        System.out.println("inserir cadastro");
        int resp = C.manipular("INSERT INTO linha (prefixo, cidade_inicial, cidade_final, tarifa, taxa_rod, pedagio, preco_total, duracao, disp) "
                + "VALUES ('"+novo.getPrefixo()+"', '"+novo.getCidadeInicial()+"', '"+novo.getCidadeFinal()+"', '"+novo.getTarifa()+"', '"+novo.getTaxaRod()+"', '"+novo.getPedagio()+"', '"+novo.getPrecoTotal()+"', '"+novo.getDuracao()+"', '"+novo.getDisp()+"')");

        String sql2 = "INSERT INTO linha (prefixo, cidade_inicial, cidade_final, tarifa, taxa_rod, pedagio, preco_total, duracao, disp) "
                + "VALUES ('"+novo.getPrefixo()+"', '"+novo.getCidadeInicial()+"', '"+novo.getCidadeFinal()+"', '"+novo.getTarifa()+"', '"+novo.getTaxaRod()+"', '"+novo.getPedagio()+"', '"+novo.getPrecoTotal()+"', '"+novo.getDuracao()+"', '"+novo.getDisp()+"')";
        System.out.println(sql2);
        if (resp == 0) {
            System.out.println("Erro de inserção");
            erroConexao = C.getMensagemErro();
            return false;
        } 
        System.out.println("deu certo");
        return true;
    }

    public Linha buscarPref(int c1, int c2, int valor){
        System.out.println("iniciou metodo buscar");
        String sql = "SELECT * FROM linha WHERE prefixo = '"+valor+"' AND cidade_inicial = '"+c1+"' AND cidade_final = '"+c2+"' ";
        System.out.println(sql);
        ResultSet rs = C.consultar(sql);
        if (rs != null) {
            try {
                if ( rs.next() ) {
                    Cidade cid = new Cidade();
                    int id = rs.getInt("id");
                    int prefixo = rs.getInt("prefixo");
                    int cidadeInicial = rs.getInt("cidade_inicial");
                    int cidadeFinal = rs.getInt("cidade_final");
                    L = new Linha(id, prefixo, cidadeInicial, cidadeFinal);
                    return L;
                } 
            }
            catch (SQLException sqlex) {
                erroConexao = "Erro ao buscar usuário";
            }
        } 
        return null;
    }

    public Linha buscar(int valor, String c1, String c2){
        System.out.println("iniciou metodo buscar");
        String sql = "SELECT * FROM linha WHERE prefixo = '"+valor+"' AND cidade_inicial = '"+c1+"' AND cidade_final = '"+c2+"' ";
        System.out.println(sql);
        ResultSet rs = C.consultar(sql);
        if (rs != null) {
            try {
                if ( rs.next() ) {
                    Cidade cid = new Cidade();
                    int id = rs.getInt("id");
                    int prefixo = rs.getInt("prefixo");
                    int cidadeInicial = rs.getInt("cidade_inicial");
                    int cidadeFinal = rs.getInt("cidade_final");
                    float tarifa = rs.getFloat("tarifa");
                    float taxaRod = rs.getFloat("taxa_rod");
                    float pedagio = rs.getFloat("pedagio");
                    float precoTotal = rs.getFloat("preco_total");
                    String duracao = rs.getString("duracao");
                    String disp = rs.getString("disp");
                    L = new Linha(id, prefixo, cidadeInicial, cidadeFinal, tarifa, taxaRod, pedagio, precoTotal, duracao, disp);
                    return L;
                } 
            }
            catch (SQLException sqlex) {
                erroConexao = "Erro ao buscar usuário";
            }
        } 
        return null;
    }

    public Linha buscarCidade(int valor){
        System.out.println("iniciou metodo buscar");
        String sql = "SELECT cidade_inicial FROM linha WHERE prefixo = '"+valor+"'";
        System.out.println(sql);
        ResultSet rs = C.consultar(sql);
        if (rs != null) {
            try {
                if ( rs.next() ) {
                    String cidadeInicial = rs.getString("cidade_inicial");
                    L = new Linha(cidadeInicial);
                    return L;
                } 
            }
            catch (SQLException sqlex) {
                erroConexao = "Erro ao buscar usuário";
            }
        } 
        return null;
    }
    
    public List<Linha> buscarPrefx() {
        List<Linha> linhas = new ArrayList<>(); 
        String sql = "SELECT prefixo FROM linha GROUP BY prefixo";
        ResultSet res = C.consultar(sql);
        if (res!= null) {
            try {
                while ( res.next() ) {
                    int prefixo = res.getInt("prefixo");
                    Linha l = new Linha(prefixo);
                    linhas.add(l);
                }
                return linhas;
            }
            catch (SQLException sqlex) {
                erroConexao = "Erro ao buscar cidade: "+sqlex.getMessage();
            }
        }
        return null;
    }
    
    public List<Linha> buscaPrefixo(int pref) {
        List<Linha> linhas = new ArrayList<>(); 
        String sql = "SELECT * FROM linha WHERE prefixo = '"+pref+"' ORDER BY id, cidade_inicial";
        System.out.println(sql);
        ResultSet res = C.consultar(sql);
        if (res!= null) {
            try {
                while ( res.next() ) {
                    int cod = res.getInt("id");
                    int prefixo = res.getInt("prefixo");
                    int cidadeInicial = res.getInt("cidade_inicial");
                    int cidadeFinal = res.getInt("cidade_final");
                    float tarifa = res.getFloat("tarifa");
                    float taxaRod = res.getFloat("taxa_rod");
                    float pedagio = res.getFloat("pedagio");
                    float precoTotal = res.getFloat("preco_total");
                    String duracao = res.getString("duracao");
                    String disp = res.getString("disp");
                    L = new Linha(cod, prefixo, cidadeInicial, cidadeFinal, tarifa, taxaRod, pedagio, precoTotal, duracao, disp);
                    linhas.add(L);
                }
                return linhas;
            }
            catch (SQLException sqlex) {
                erroConexao = "Erro ao buscar Linha: "+sqlex.getMessage();
            }
        }
        return null;
    }

    public List<Linha> buscaEspec(int id, String cityBegin, String cityFinal) {
        List<Linha> linhas = new ArrayList<>(); 
        String sql = "SELECT * FROM linha WHERE prefixo = '"+id+"' and cidade_inicial = '"+cityBegin+"' and cidade_final = '"+cityFinal+"'";
        System.out.println(sql);
        System.out.println("passou do sql");
        ResultSet res = C.consultar(sql);
        System.out.println("passou do resultSet");
        if (res!= null) {
            System.out.println("passou do if");
            try {
                //System.out.println("passou do try");
                while ( res.next() ) {
                    System.out.println("passou do while");
                    int prefixo = res.getInt("prefixo");
                    int cidadeInicial = res.getInt("cidade_inicial");
                    int cidadeFinal = res.getInt("cidade_final");
                    float tarifa = res.getFloat("tarifa");
                    float taxaRod = res.getFloat("taxa_rod");
                    float pedagio = res.getFloat("pedagio");
                    float precoTotal = res.getFloat("preco_total");
                    String duracao = res.getString("duracao");
                    String disp = res.getString("disp");
                    System.out.println("atribuiu atrib");
                    L = new Linha(prefixo, cidadeInicial, cidadeFinal, tarifa, taxaRod, pedagio, precoTotal, duracao, disp);
                    linhas.add(L);
                }
                return linhas;
            }
            catch (SQLException sqlex) {
                erroConexao = "Erro ao buscar Linha: "+sqlex.getMessage();
            }
        }
        return null;
    }
    
    public boolean alterar(Linha L) {
        System.out.println("entrou no metodo 'alterar'");
        String sql = "UPDATE linha SET cidade_inicial = '"+L.getCidadeInicial()+"', "
                + "cidade_final = '"+L.getCidadeFinal()+"', "
                + "tarifa = '"+L.getTarifa()+"', taxa_rod = '"+L.getTaxaRod()+"', pedagio = '"+L.getPedagio()+"', "
                + "preco_total = '"+L.getPrecoTotal()+"', duracao = '"+L.getDuracao()+"', disp = '"+L.getDisp()+"' WHERE prefixo = '"+L.getPrefixo()+"' AND id = '"+L.getId()+"'";
        System.out.println(sql);
        int i = C.manipular(sql);
        if (i > 0) {
            return true;
        }
        return false;
    }
    
    public boolean excluirEveryT(int id) {
        System.out.println("chegou na string");
        String sql = "DELETE FROM linha WHERE prefixo = '"+id+"'";
        System.out.println(sql);
        System.out.println("passou da sql");
        int i = C.manipular(sql);
        if (i > 0) {
            System.out.println("Deu certo!!!");
            return true;
        }
        return false;
    }
    
    public boolean excluirEspec(int id, String cityBegin, String cityFinal) {
        System.out.println("chegou na string");
        String sql = "DELETE FROM linha WHERE prefixo = '"+id+"' and cidade_inicial = '"+cityBegin+"' and cidade_final = '"+cityFinal+"'";
        System.out.println(sql);
        System.out.println("passou da sql");
        int i = C.manipular(sql);
        if (i > 0) {
            System.out.println("Deu certo!!!");
            return true;
        }
        return false;
    }

    public List<Linha> buscaItinerarioBus(int pref) {
        List<Linha> linhas = new ArrayList<>(); 
        String sql = "SELECT l.cidade_inicial, c1.cidade, l.cidade_final, c2.cidade, l.duracao"
                + " FROM linha l, cidade c1, cidade c2 "
                + "WHERE prefixo = '"+pref+"' AND  c1.codigo = l.cidade_inicial AND c2.codigo = l.cidade_final "
                + "GROUP BY cidade_inicial "
                + "ORDER BY id";
        System.out.println(sql);
        ResultSet res = C.consultar(sql);
        if (res!= null) {
            try {
                while ( res.next() ) {
                    int cidadeInicial = res.getInt("l.cidade_inicial");
                    String nome1 = res.getString("c1.cidade");
                    int cidadeFinal = res.getInt("l.cidade_final");
                    String nome2 = res.getString("c2.cidade");
                    String duracao = res.getString("duracao");
                    L = new Linha(cidadeInicial, nome1, cidadeFinal, nome2, duracao);
                    linhas.add(L);
                }
                return linhas;
            }
            catch (SQLException sqlex) {
                erroConexao = "Erro ao buscar Linha: "+sqlex.getMessage();
            }
        }
        return null;
    }
}