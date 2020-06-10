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
public class Cliente {
    private int id;
    private String nome;
    private String rg;
    private String cpf_cnpj;
    private String telefone;
    private String email;
    private String cep;
    private String endereco;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;

    public Cliente() {
    }

    public Cliente(int id, String nome, String rg, String cpf_cnpj, String telefone) {
        this.id = id;
        this.nome = nome;
        this.rg = rg;
        this.cpf_cnpj = cpf_cnpj;
        this.telefone = telefone;
    }
    public Cliente(String nome, String rg, String cpf_cnpj, String telefone) {
        this.nome = nome;
        this.rg = rg;
        this.cpf_cnpj = cpf_cnpj;
        this.telefone = telefone;
    }

    public Cliente(String nome, String rg, String cpf_cnpj, String telefone, String email, String cep, String endereco, String numero, String bairro, String cidade, String estado) {
        this.nome = nome;
        this.rg = rg;
        this.cpf_cnpj = cpf_cnpj;
        this.telefone = telefone;
        this.email = email;
        this.cep = cep;
        this.endereco = endereco;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    
    
    public Cliente(int id, String nome, String rg, String cpf_cnpj, String telefone, String email, String cep, String endereco, String numero, String bairro, String cidade, String estado) {
        this.id = id;
        this.nome = nome;
        this.rg = rg;
        this.cpf_cnpj = cpf_cnpj;
        this.telefone = telefone;
        this.email = email;
        this.cep = cep;
        this.endereco = endereco;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
