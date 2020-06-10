/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.Controller;

import Dao.Class.Cidade;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Conexao;

/**
 *
 * @author Leandro Baroni
 */
public class CidadeControlador {
    private Cidade Cid;
    private Conexao C;
    String erroConexao;

    public CidadeControlador() {
        C = new Conexao("jdbc:mysql://localhost:3306/db_svp", "root", "");
        erroConexao = C.getMensagemErro();
    }

    public String getMensagemErro() {
        return erroConexao;
    }

    public boolean inserir(Cidade novo) {
        int resp = C.manipular("INSERT INTO cidade (cidade) VALUES ('"+novo.getCidade()+"')");
        String sql = "INSERT INTO cidade (cidade) VALUES ('"+novo.getCidade()+"')";
        System.out.println(sql);
        if (resp == 0) {
            erroConexao = C.getMensagemErro();
            return false;
        }
        return true;
    }
    
    public Cidade buscar(int valor){
        String sql = "SELECT * FROM cidade WHERE codigo = '"+valor+"'";
        //System.out.println(sql);
        ResultSet rs = C.consultar(sql);
        if (rs != null) {
            try {
                if ( rs.next() ) {
                    int codigo = rs.getInt("codigo");
                    String cidade = rs.getString("cidade");
                    Cidade c = new Cidade(codigo, cidade);
                    return c;
                } 
            }
            catch (SQLException sqlex) {
                erroConexao = "Erro ao buscar usuário";
            }
        } 
        return null;
    }

    public Cidade buscarCodigo(Cidade valor){
        System.out.println("VALOR : " + valor);
        String sql = "SELECT codigo FROM cidade WHERE cidade = '"+valor+"'";
        System.out.println(sql);
        ResultSet rs = C.consultar(sql);
        if (rs != null) {
            try {
                if ( rs.next() ) {
                    int codigo = rs.getInt("codigo");
                    Cidade c = new Cidade(codigo);
                    return c;
                } 
            }
            catch (SQLException sqlex) {
                erroConexao = "Erro ao buscar usuário";
            }
        } 
        return null;
    }
    
    public Cidade buscarCidade(String busca){
        System.out.println("111111111111111111");
        String sql = "SELECT * FROM cidade WHERE cidade = '"+busca+"'";
        System.out.println(sql);
        ResultSet rs = C.consultar(sql);
        if (rs != null) {
            try {
                if ( rs.next() ) {
                    int codigo = rs.getInt("codigo");
                    String cidade = rs.getString("cidade");
                    Cidade c = new Cidade(codigo, cidade);
                    return c;
                } 
            }
            catch (SQLException sqlex) {
                erroConexao = "Erro ao buscar usuário";
            }
        } 
        return null;
    }
    
    public Cidade buscarCidadeMaior(String busca){
        String sql = "SELECT * FROM cidade WHERE prefixo = '"+busca+"' ORDER BY preco_total DESC";
        ResultSet rs = C.consultar(sql);
        if (rs != null) {
            try {
                if ( rs.next() ) {
                    int codigo = rs.getInt("codigo");
                    String cidade = rs.getString("cidade");
                    Cidade c = new Cidade(codigo, cidade);
                    return c;
                } 
            }
            catch (SQLException sqlex) {
                erroConexao = "Erro ao buscar usuário";
            }
        } 
        return null;
    }
    
    public List<Cidade> buscarCods() {
        List<Cidade> cidades = new ArrayList<>();
        String sql = "SELECT * FROM cidade ORDER BY cidade";
        ResultSet res = C.consultar(sql);
        if (res!= null) {
            try {
                while ( res.next() ) {
                    int codigo = res.getInt("codigo");
                    String cidade = res.getString("cidade");
                    Cidade c = new Cidade(codigo, cidade);
                    cidades.add(c);
                }
                return cidades;
            }
            catch (SQLException sqlex) {
                erroConexao = "Erro ao buscar cidade: "+sqlex.getMessage();
            }
        }
        return null;
    }
    
    public boolean excluir(int id) {
        String sql = "DELETE FROM cidade WHERE codigo = '"+id+"'";
        int i = C.manipular(sql);
        if (i > 0) {
            return true;
        }
        return false;
    }
}