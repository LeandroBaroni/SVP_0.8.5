/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.Controller;

import Dao.Class.Servico;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Conexao;

/**
 *
 * @author Leandro Baroni
 */

public class ServicoControlador {
    private Servico S;
    private Conexao C;
    String erroConexao;

    public ServicoControlador() {
        C = new Conexao("jdbc:mysql://localhost:3306/db_svp", "root", "");
        erroConexao = C.getMensagemErro();
    }
    
    public String getMensagemErro() {
        System.out.println(erroConexao);
        return erroConexao;
    }

    public boolean inserir(Servico novo) {
        System.out.println("inserir cadastro");
        int resp = C.manipular("INSERT INTO servico (codigo, data_viagem, horario_viagem, qtd_poltronas, qtd_poltronas_ocup, numero_carro, motorista, mensagem, codPrefixo)"
                + " VALUES ('"+novo.getCodigo()+"', '"+novo.getdViagem()+"','"+novo.gethViagem()+"', '"+novo.getQtdPoltronas()+"', '"+novo.getQtdPoltronasOcup()+"', '"+novo.getNumCarro()+"', '"+novo.getNomeMotorista()+"', '"+novo.getMensagem()+"', '"+novo.getCodPrefixo()+"')");
        System.out.println("INSERT INTO servico (codigo, data_viagem, horario_viagem, qtd_poltronas, qtd_poltronas_ocup, numero_carro, motorista, mensagem, codPrefixo)"
                + " VALUES ('"+novo.getCodigo()+"', '"+novo.getdViagem()+"','"+novo.gethViagem()+"', '"+novo.getQtdPoltronas()+"', '"+novo.getQtdPoltronasOcup()+"', '"+novo.getNumCarro()+"', '"+novo.getNomeMotorista()+"', '"+novo.getMensagem()+"', '"+novo.getCodPrefixo()+"'");
        System.out.println("passou da sql: " + resp);
        if (resp == 0) {
            System.out.println("Erro de inserção");
            erroConexao = C.getMensagemErro();
            return false;
        }
        return true;
    }
    
    public Servico buscar(String busca)  {
        System.out.println("Entrou em busca");
        String sql = "SELECT * FROM servico WHERE codigo = '"+busca+"'";
        System.out.println(sql);
        ResultSet rs = C.consultar(sql);
        if (rs != null) {
            try {
                if ( rs.next() ) {
                    int codigo = rs.getInt("codigo");
                    String dtViagem = rs.getString("data_viagem");
                    String hViagem = rs.getString("horario_viagem");
                    int qtdPoltronas = rs.getInt("qtd_poltronas");
                    int poltOcupadas = rs.getInt("qtd_poltronas_ocup");
                    int nCarro = rs.getInt("numero_carro");
                    String motorista = rs.getString("motorista");
                    String mensagem = rs.getString("mensagem");
                    int codLinha = rs.getInt("linhaId");
                    Servico S = new Servico(codigo, dtViagem, hViagem, qtdPoltronas, poltOcupadas, nCarro, motorista, mensagem, codLinha);
                    return S;
                } 
            }
            catch (SQLException sqlex) {
                erroConexao = "Erro ao buscar dados de funcionário. Erro: " + sqlex;
            }
        } 
        return null;
    }

    public int findMaxId() {
        String sql = "SELECT MAX(codigo) FROM servico";
        System.out.println(sql);
        ResultSet res = C.consultar(sql);
        if(res != null){
            int max = 0;
            try{
                while ( res.next() ) {
                    max = res.getInt("MAX(codigo)");
                    System.out.println("MAX: " + max);
                }
                return max;
            }catch(SQLException sqlex){
                erroConexao = "Erro ao buscar usuario: "+sqlex.getMessage();
            }
        }
        return 0;
    }

    public List<Servico> buscarVenda(int v1, int v2, Date busca){
        List<Servico> servicos = new ArrayList<>();
        String sql = "SELECT s.codigo, s.data_viagem, s.horario_viagem, l.cidade_inicial, l.cidade_final, l.preco_total, s.qtd_poltronas, s.qtd_poltronas_ocup, s.codPrefixo" +
                    " FROM servico s, linha l" +
                    " WHERE l.prefixo = s.codPrefixo AND l.cidade_inicial = '"+ v1 +"' AND l.cidade_final = '"+ v2 +"' AND l.disp = 'S' AND s.data_viagem = '"+ busca +"'" +
                    " ORDER BY s.data_viagem, s.horario_viagem";
        System.out.println(sql);
        ResultSet rs = C.consultar(sql);
        System.out.println(rs);
        if(rs != null){
            try{
                System.out.println("2");
                while(rs.next()){
                    int codigo = rs.getInt("s.codigo");
                    String dia = rs.getDate("s.data_viagem").toString();
                    String hora = rs.getTime("s.horario_viagem").toString();
                    int cid_1 = rs.getInt("l.cidade_inicial");
                    int cid_2 = rs.getInt("l.cidade_final");
                    double preco = rs.getInt("l.preco_total");
                    int qtdP = rs.getInt("s.qtd_poltronas");
                    int qtdPOcup = rs.getInt("s.qtd_poltronas_ocup");
                    int prefixo = rs.getInt("s.codPrefixo");

                    System.out.println(codigo + ", " + dia + ", " + hora + ", " + cid_1 + ", " + cid_2 + ", " + qtdP + ", " 
                            + qtdPOcup + ", "+ preco + ", " + prefixo);
                    S = new Servico(codigo, dia, hora, cid_1, cid_2, preco, qtdP, qtdPOcup, prefixo);
                    servicos.add(S);
                }
                return servicos;
            }catch(SQLException sqlex){
                erroConexao = "Erro ao buscar dados: " + sqlex;
            }
        }
        System.out.println("erro");
        return null;
    }

    public List<Servico> buscarVendaPServico(int v1, int v2, Date busca, int servico){
        List<Servico> servicos = new ArrayList<>();
        String sql = "SELECT s.codigo, s.data_viagem, s.horario_viagem, l.cidade_inicial, l.cidade_final, l.preco_total, s.qtd_poltronas, s.codPrefixo" +
                    " FROM servico s, linha l" +
                    " WHERE l.prefixo = s.codPrefixo AND s.codigo = '"+servico+"' AND l.cidade_inicial = '"+ v1 +"' AND l.cidade_final = '"+ v2 +"' AND l.disp = 'S' AND s.data_viagem = '"+ busca +"'" +
                    " ORDER BY s.data_viagem, s.horario_viagem";
        System.out.println(sql);
        ResultSet rs = C.consultar(sql);
        System.out.println(rs);
        if(rs != null){
            try{
                System.out.println("2");
                while(rs.next()){
                    int codigo = rs.getInt("s.codigo");
                    String dia = rs.getDate("s.data_viagem").toString();
                    String hora = rs.getTime("s.horario_viagem").toString();
                    int cid_1 = rs.getInt("l.cidade_inicial");
                    int cid_2 = rs.getInt("l.cidade_final");
                    double preco = rs.getInt("l.preco_total");
                    int qtd = rs.getInt("s.qtd_poltronas");
                    int prefixo = rs.getInt("s.codPrefixo");

                    System.out.println(codigo + ", " + dia + ", " + hora + ", " + cid_1 + ", " + cid_2 + ", " + qtd + ", " 
                            + preco + ", " + prefixo);
                    S = new Servico(codigo, dia, hora, cid_1, cid_2, preco, qtd, prefixo);
                    servicos.add(S);
                }
                return servicos;
            }catch(SQLException sqlex){
                erroConexao = "Erro ao buscar dados: " + sqlex;
            }
        }
        System.out.println("erro");
        return null;
    }

    public List<Servico> buscarServico() {
        System.out.println("xixixxi");
        List<Servico> servicos = new ArrayList<>(); 
        String sql = "SELECT * FROM servico ORDER BY codigo";
        ResultSet res = C.consultar(sql);
        if (res!= null) {
            try {
                while ( res.next() ) {
                    int codigo = res.getInt("codigo");
                    String dia = res.getString("data_viagem");
                    String hora = res.getString("horario_viagem");
                    int poltTotal = res.getInt("qtd_poltronas");
                    int poltOcup = res.getInt("qtd_poltronas_ocup");
                    int numCarro = res.getInt("numero_carro");
                    String motorista = res.getString("motorista");
                    String mens = res.getString("mensagem");
                    int pref = res.getInt("codPrefixo");
                    Servico l = new Servico(codigo, dia, hora, poltTotal, poltOcup, numCarro, motorista, mens, pref);
                    System.out.println("saiu");
                    servicos.add(l);
                }
                return servicos;
            }
            catch (SQLException sqlex) {
                erroConexao = "Erro ao buscar cidade: "+sqlex.getMessage();
            }
        }
        return null;
    }

    public List<Servico> buscarTodosServicos(int servico, String data) {
        System.out.println("xaxaaxaxa");
        List<Servico> servicos = new ArrayList<>(); 
        String sql = "SELECT * FROM servico WHERE data_viagem = '"+ data +"' and codigo = '"+servico+"'  ORDER BY codigo";
        System.out.println(sql);
        ResultSet res = C.consultar(sql);
        if (res!= null) {
            try {
                while ( res.next() ) {
                    System.out.println("bbbbbbbbbbbbbbbbbbbbbb");
                    int codigo = res.getInt("codigo");
                    String dia = res.getString("data_viagem");
                    String hora = res.getString("horario_viagem");
                    int poltTotal = res.getInt("qtd_poltronas");
                    int poltOcup = res.getInt("qtd_poltronas_ocup");
                    int numCarro = res.getInt("numero_carro");
                    String motorista = res.getString("motorista");
                    String mens = res.getString("mensagem");
                    int pref = res.getInt("codPrefixo");
                    Servico l = new Servico(codigo, dia, hora, poltTotal, poltOcup, numCarro, motorista, mens, pref);
                    System.out.println("saiu");
                    servicos.add(l);
                }
                return servicos;
            }
            catch (SQLException sqlex) {
                erroConexao = "Erro ao buscar cidade: "+sqlex.getMessage();
            }
        }
        return null;
    }

    public List<Servico> buscarTodosServicos(int servico, int prefixo, String data) {
        System.out.println("xixixxi");
        List<Servico> servicos = new ArrayList<>(); 
        String sql = "SELECT * FROM servico WHERE data_viagem = '"+ data +"' and codigo = '"+servico+"' and codPrefixo = '"+prefixo+"' ORDER BY codigo";
        System.out.println(sql);
        ResultSet res = C.consultar(sql);
        if (res!= null) {
            try {
                while ( res.next() ) {
                    System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
                    int codigo = res.getInt("codigo");
                    String dia = res.getString("data_viagem");
                    String hora = res.getString("horario_viagem");
                    int poltTotal = res.getInt("qtd_poltronas");
                    int poltOcup = res.getInt("qtd_poltronas_ocup");
                    int numCarro = res.getInt("numero_carro");
                    String motorista = res.getString("motorista");
                    String mens = res.getString("mensagem");
                    int pref = res.getInt("codPrefixo");
                    Servico l = new Servico(codigo, dia, hora, poltTotal, poltOcup, numCarro, motorista, mens, pref);
                    System.out.println("saiu");
                    servicos.add(l);
                }
                return servicos;
            }
            catch (SQLException sqlex) {
                erroConexao = "Erro ao buscar cidade: "+sqlex.getMessage();
            }
        }
        return null;
    }

    public Servico getDadosViagem(int busca, String data)  {
        String sql = "SELECT numero_carro, motorista, mensagem FROM servico WHERE codigo = '"+busca+"' AND data_viagem = '"+data+"'";
        System.out.println(sql);
        ResultSet rs = C.consultar(sql);
        if (rs != null) {
            try {
                if ( rs.next() ) {
                    int nCarro = rs.getInt("numero_carro");
                    String motorista = rs.getString("motorista");
                    String mensagem = rs.getString("mensagem");
                    Servico S = new Servico(nCarro, motorista, mensagem);
                    return S;
                } 
            }
            catch (SQLException sqlex) {
                erroConexao = "Erro ao buscar dados de funcionário. Erro: " + sqlex;
            }
        } 
        return null;
    }

    public boolean alterar(Servico s) {
        System.out.println("entrou no metodo 'alterar'");
        String sql = "UPDATE servico SET data_viagem = '"+s.getdViagem()+"', "
                + "horario_viagem = '"+s.gethViagem()+"' WHERE codigo = '"+s.getCodigo()+"' and codPrefixo = '"+s.getCodPrefixo()+"'";
        System.out.println(sql);
        int i = C.manipular(sql);
        if (i > 0) {
            return true;
        }
        return false;
    }

    public boolean setDadosViagem(Servico s) {
        String sql = "UPDATE servico SET numero_carro = '"+s.getNumCarro()+"', "
                + "motorista = '"+s.nomeMotorista+"', mensagem = '"+s.getMensagem()+"' WHERE codigo = '"+s.getCodigo()+"' AND data_viagem = '"+s.getdViagem()+"'";
        System.out.println(sql);
        int i = C.manipular(sql);
        if (i > 0) {
            return true;
        }
        return false;
    }

    public boolean excluir(int identified) {
        String sql = "DELETE FROM servico WHERE codigo = '"+identified+"'";
        System.out.println(sql);
        int i = C.manipular(sql);
        if (i > 0) {
            return true;
        }
        return false;
    }
}