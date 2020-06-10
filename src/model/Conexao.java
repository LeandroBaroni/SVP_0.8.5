/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Leandro Baroni
 */
public class Conexao {
    private Connection con;
    private boolean conectado;
    private String erro;

    public Conexao(String Caminho, String usuario, String Senha) {
        conectado = true;
        erro = "";
        try {
            Class.forName("com.mysql.jdbc.Driver")/*.newInstance()*/;
            con = DriverManager.getConnection(Caminho, usuario, Senha);
        }
        catch (ClassNotFoundException cnfex) {
            conectado = false;
            erro = "Driver do banco de dados não foi encontrado!";
        }
        catch (SQLException sqlex) {
            conectado = false;
            erro = "Não conectou ao banco de dados!!";
        }
        catch (Exception ex) {
            erro = "Ocorreu algum erro desconhecido: "+ex.getMessage();
        }
    }
    
    public boolean isConnected() {
        return conectado;
    }
    
    public String getMensagemErro() {
        return erro;
    }
    
    public ResultSet consultar(String comandoSQL) {
        erro = "";
        try {
            Statement acesso = con.createStatement();
            ResultSet rs = acesso.executeQuery(comandoSQL);
            return (rs);
        } catch (SQLException ex) {
            erro = "Erro ao acessar o banco: "+ex.getMessage() ;
        }
        return null;
    }
    
    public int manipular(String comandoSQL) {
        erro = "";
        try {
            Statement acesso = con.createStatement();
            int r = acesso.executeUpdate(comandoSQL);
            return r;
            }
        catch (SQLException ex) {
            erro = "Erro ao acessar o banco: "+ex.getMessage() ;
        }
        return 0;
    }
}
