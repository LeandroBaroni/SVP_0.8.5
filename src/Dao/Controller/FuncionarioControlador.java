/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.Controller;

import Dao.Class.Funcionario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Conexao;

/**
 *
 * @author Leandro Baroni
 */
public class FuncionarioControlador {
    private Funcionario F;
    private Conexao C;
    String erroConexao;

    public FuncionarioControlador() {
        C = new Conexao("jdbc:mysql://localhost:3306/db_svp", "root", "");
        erroConexao = C.getMensagemErro();
    }
    
    public String getMensagemErro() {
        return erroConexao;
    }

    public boolean inserir(Funcionario novo) {
        System.out.println("inserir cadastro");
        int resp = C.manipular("INSERT INTO funcionario (login, senha, nome, tipo) VALUES ('"+novo.getLogin()+"', '"+novo.getSenha()+"','"+novo.getNome()+"', '"+novo.getTipo()+"')");
        //String sql = String.valueOf(C.manipular("INSERT INTO funcionario (login, senha, nome, tipo) VALUES ('"+novo.getLogin()+"', '"+novo.getSenha()+"','"+novo.getNome()+"', '"+novo.getTipo()+"')"));
        //System.out.println(sql);
        if (resp == 0) {
            System.out.println("Erro de inserção");
            erroConexao = C.getMensagemErro();
            return false;
        }
        return true;
    }

    public Funcionario buscar(String busca)  {
        System.out.println("Entrou em busca");
        String sql = "SELECT * FROM funcionario WHERE login = '"+busca+"'";
        System.out.println(sql);
        ResultSet rs = C.consultar(sql);
        if (rs != null) {
            try {
                if ( rs.next() ) {
                    int id = rs.getInt("codigo");
                    String login = rs.getString("login");
                    String senha = rs.getString("senha");
                    String nome = rs.getString("nome");
                    String tipo = rs.getString("tipo");
                    int contLogin = rs.getInt("contLogin");
                    Funcionario F = new Funcionario(id, login, senha, nome, tipo, contLogin);
                    return F;
                } 
            }
            catch (SQLException sqlex) {
                erroConexao = "Erro ao buscar dados de funcionário. Erro: " + sqlex;
            }
        } 
        return null;
    }

    public Funcionario buscarC(String busca)  {
        System.out.println("Entrou em busca");
        String sql = "SELECT * FROM funcionario WHERE codigo = '"+busca+"'";
        System.out.println(sql);
        ResultSet rs = C.consultar(sql);
        if (rs != null) {
            try {
                if ( rs.next() ) {
                    String login = rs.getString("login");
                    String senha = rs.getString("senha");
                    String nome = rs.getString("nome");
                    String tipo = rs.getString("tipo");
                    Funcionario F = new Funcionario(login, senha, nome, tipo);
                    return F;
                } 
            }
            catch (SQLException sqlex) {
                erroConexao = "Erro ao buscar dados de funcionário. Erro: " + sqlex;
            }
        } 
        return null;
    }
    
    public boolean validarUsuario(String login, String senha) {
        String sql = "SELECT * FROM funcionario WHERE login LIKE '"+login+"' AND senha LIKE '"+senha+"'";
        ResultSet rs = C.consultar(sql);
        if (rs == null) {
            erroConexao = C.getMensagemErro();
        }else {
            try {
                if ( rs.next() ) {
                    int cod = rs.getInt("codigo");
                    String nome = rs.getString("nome");
                    String tipo = rs.getString("tipo");
                    int contLogin = rs.getInt("contLogin");
                    F = new Funcionario(cod, login, senha, nome, tipo, contLogin);
                    return true;
                }else{
                    return false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(FuncionarioControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public List<Funcionario> buscarNomeParcial(String busca) {
        List<Funcionario> funcionarios = new ArrayList<>(); 
        String sql = "SELECT * FROM funcionario WHERE nome LIKE '%"+busca+"%'";
        System.out.println(sql);
        ResultSet res = C.consultar(sql);
        if (res!= null) {
            try {
                while ( res.next() ) {
                    int codigo = res.getInt("codigo");
                    String login = res.getString("login");
                    String senha = res.getString("senha");
                    String nome = res.getString("nome");
                    String tipo = res.getString("tipo");
                    
                    Funcionario f = new Funcionario(codigo, login, senha, nome, tipo);
                    funcionarios.add(f);
                }
                return funcionarios;
            }
            catch (SQLException sqlex) {
                erroConexao = "Erro ao buscar usuário: "+sqlex.getMessage();
            }
        }
        return null;
    }
    
    public List<Funcionario> buscarTipo() {
        List<Funcionario> funcionarios = new ArrayList<>(); 
        String sql = "SELECT tipo FROM funcionario GROUP BY tipo";
        ResultSet res = C.consultar(sql);
        if (res!= null) {
            try {
                while ( res.next() ) {
                    String tipo = res.getString("tipo");
                    Funcionario f = new Funcionario(tipo);
                    funcionarios.add(f);
                }
                return funcionarios;
            }
            catch (SQLException sqlex) {
                erroConexao = "Erro ao buscar usuario: "+sqlex.getMessage();
            }
        }
        return null;
    }

    public int countCod(){
        String sql = "SELECT max(codigo) FROM funcionario";
        System.out.println(sql);
        ResultSet res = C.consultar(sql);
        if(res != null){
            int max = 0;
            try{
                while ( res.next() ) {
                    max = res.getInt("max(codigo)");
                    System.out.println("MAX: " + max);
                }
                return max;
            }catch(SQLException sqlex){
                erroConexao = "Erro ao buscar usuario: "+sqlex.getMessage();
            }
        }
        return 0;
    }

    public boolean excluir(int identified) {
        String sql = "DELETE FROM funcionario WHERE codigo = '"+identified+"'";
        System.out.println(sql);
        int i = C.manipular(sql);
        if (i > 0) {
            return true;
        }
        return false;
    }
    
    public boolean alterar(Funcionario f) {
        System.out.println("entrou no metodo 'alterar'");
        String sql = "UPDATE funcionario SET senha = '"+f.getSenha()+"', "
                + "nome = '"+f.getNome()+"', tipo = '"+f.getTipo()+"' WHERE codigo = '"+f.getCodigo()+"'";
        System.out.println(sql);
        int i = C.manipular(sql);
        if (i > 0) {
            return true;
        }
        return false;
    }

    public boolean alterarSenha(Funcionario f) {
        System.out.println("entrou no metodo 'alterar'");
        String sql = "UPDATE funcionario SET senha = '"+f.getSenha()+"', contLogin = 0 WHERE codigo = '"+f.getCodigo()+"'";
        System.out.println(sql);
        int i = C.manipular(sql);
        if (i > 0) {
            return true;
        }
        return false;
    }

    public boolean alterarCont(Funcionario f) {
        System.out.println("entrou no metodo 'alterar'");
        String sql = "UPDATE funcionario SET contLogin = '"+f.getContLogin()+"' WHERE codigo = '"+f.getCodigo()+"'";
        System.out.println(sql);
        int i = C.manipular(sql);
        if (i > 0) {
            return true;
        }
        return false;
    }
}