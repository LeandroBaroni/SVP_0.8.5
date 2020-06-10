/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.Class;

/**
 *
 * @author Leandro Baroni
 */
public class Funcionario {
    int codigo;
    String login;
    String senha;
    String nome;
    String tipo;
    int contLogin;

    public Funcionario() {
    }

    public Funcionario(String tipo) {
        this.tipo = tipo;
    }

    public Funcionario(int contLogin) {
        this.contLogin = contLogin;
    }

    public Funcionario(int codigo, int contLogin) {
        this.codigo = codigo;
        this.contLogin = contLogin;
    }

    public Funcionario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public Funcionario(String login, String senha, int contLogin) {
        this.login = login;
        this.senha = senha;
        this.contLogin = contLogin;
    }

    public Funcionario(String login, String senha, String nome, String tipo) {
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.tipo = tipo;
    }

    public Funcionario(int codigo, String senha, String nome, String tipo) {
        this.codigo = codigo;
        this.senha = senha;
        this.nome = nome;
        this.tipo = tipo;
    }
    
    public Funcionario(int codigo, String login, String senha, String nome, String tipo) {
        this.codigo = codigo;
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.tipo = tipo;
    }

    public Funcionario(int codigo, String login, String senha, String nome, String tipo, int contLogin) {
        this.codigo = codigo;
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.tipo = tipo;
        this.contLogin = contLogin;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getContLogin() {
        return contLogin;
    }

    public void setContLogin(int contLogin) {
        this.contLogin = contLogin;
    }
}