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

public class Servico {
    public int codigo;
    public String dViagem;
    public String hViagem;
    public int qtdPoltronas;
    public int qtdPoltronasOcup;
    public int numCarro;
    public String nomeMotorista;
    public String mensagem;
    public int codPrefixo;
    
    Linha lCidadeI;
    Linha lCidadeF;
    Linha lPreco;
    Cidade c1;
    Cidade c2;

    public void setlCidadeF(Linha lCidadeF) {
        this.lCidadeF = lCidadeF;
    }

    public Linha getlPreco() {
        return lPreco;
    }

    public void setlPreco(Linha lPreco) {
        this.lPreco = lPreco;
    }

    public Servico() {
    }

    public Servico(int codigo) {
        this.codigo = codigo;
    }

    public Servico(String dViagem){
        this.dViagem = dViagem;
    }

    public Servico(int codigo, String dViagem, String hViagem, int codPrefixo) {
        this.codigo = codigo;
        this.dViagem = dViagem;
        this.hViagem = hViagem;
        this.codPrefixo = codPrefixo;
    }

    public Servico(int codigo, String dViagem, int numCarro, String nomeMotorista, String mensagem) {
        this.codigo = codigo;
        this.dViagem = dViagem;
        this.numCarro = numCarro;
        this.nomeMotorista = nomeMotorista;
        this.mensagem = mensagem;
    }

    public Servico(String dViagem, String hViagem, int qtdPoltronas, int qtdPoltronasOcup) {
        this.dViagem = dViagem;
        this.hViagem = hViagem;
        this.qtdPoltronas = qtdPoltronas;
        this.qtdPoltronasOcup = qtdPoltronasOcup;
    }

    public Servico(int numCarro, String nomeMotorista, String mensagem) {
        this.numCarro = numCarro;
        this.nomeMotorista = nomeMotorista;
        this.mensagem = mensagem;
    }

    public Servico(String dViagem, String hViagem, int qtdPoltronas, int qtdPoltronasOcup, int numCarro, String nomeMotorista, String mensagem, int codPrefixo) {
        this.dViagem = dViagem;
        this.hViagem = hViagem;
        this.qtdPoltronas = qtdPoltronas;
        this.qtdPoltronasOcup = qtdPoltronasOcup;
        this.numCarro = numCarro;
        this.nomeMotorista = nomeMotorista;
        this.mensagem = mensagem;
        this.codPrefixo = codPrefixo;
    }

    public Servico(int codigo, String dViagem, String hViagem, int qtdPoltronas, int qtdPoltronasOcup, int numCarro, String nomeMotorista, String mensagem, int codPrefixo) {
        this.codigo = codigo;
        this.dViagem = dViagem;
        this.hViagem = hViagem;
        this.qtdPoltronas = qtdPoltronas;
        this.qtdPoltronasOcup = qtdPoltronasOcup;
        this.numCarro = numCarro;
        this.nomeMotorista = nomeMotorista;
        this.mensagem = mensagem;
        this.codPrefixo = codPrefixo;
    }

    public Servico(int codigo, String dViagem, String hViagem, int lCidadeI, int lCidadeF, double lPreco, int qtdPoltronas, int codPrefixo) {
        this.codigo = codigo;
        this.dViagem = dViagem;
        this.hViagem = hViagem;
        this.lCidadeI = new Linha(lCidadeI);
        this.lCidadeF = new Linha(lCidadeF);
        this.lPreco = new Linha(lPreco);
        this.qtdPoltronas = qtdPoltronas;
        this.codPrefixo = codPrefixo;
    }

    public Servico(int codigo, String dViagem, String hViagem, int lCidadeI, int lCidadeF, double lPreco, int qtdPoltronas, int qtdPOcup, int codPrefixo) {
        this.codigo = codigo;
        this.dViagem = dViagem;
        this.hViagem = hViagem;
        this.lCidadeI = new Linha(lCidadeI);
        this.lCidadeF = new Linha(lCidadeF);
        this.lPreco = new Linha(lPreco);
        this.qtdPoltronas = qtdPoltronas;
        this.qtdPoltronasOcup = qtdPOcup;
        this.codPrefixo = codPrefixo;
    }

    public Servico(int codigo, String dViagem, String hViagem, int qtdPoltronas, int qtdPoltronasOcup, int numCarro, String nomeMotorista, String mensagem, int codPrefixo, int lCidadeI, int lCidadeF, double lPreco) {
        this.codigo = codigo;
        this.dViagem = dViagem;
        this.hViagem = hViagem;
        this.qtdPoltronas = qtdPoltronas;
        this.qtdPoltronasOcup = qtdPoltronasOcup;
        this.numCarro = numCarro;
        this.nomeMotorista = nomeMotorista;
        this.mensagem = mensagem;
        this.codPrefixo = codPrefixo;
        this.lCidadeI = new Linha(lCidadeI);
        this.lCidadeF = new Linha(lCidadeF);
        this.lPreco = new Linha(lPreco);
    }

    public Servico(int codigo, String dViagem, String hViagem, int lCidadeI, int lCidadeF, double lPreco, int qtdPoltronas, int codPrefixo, String c1, String c2) {
        this.codigo = codigo;
        this.dViagem = dViagem;
        this.hViagem = hViagem;
        this.lCidadeI = new Linha(lCidadeI);
        this.lCidadeF = new Linha(lCidadeF);
        this.lPreco = new Linha(lPreco);
        this.qtdPoltronas = qtdPoltronas;
        this.codPrefixo = codPrefixo;
        this.c1 = new Cidade(c1);
        this.c2 = new Cidade(c2);
    }

    public Servico(int codigo, String dViagem, String hViagem, int qtdPoltronas, int qtdPoltronasOcup, int numCarro, String nomeMotorista, String mensagem, int codPrefixo, int lCidadeI, int lCidadeF, double lPreco, String c1, String c2) {
        this.codigo = codigo;
        this.dViagem = dViagem;
        this.hViagem = hViagem;
        this.qtdPoltronas = qtdPoltronas;
        this.qtdPoltronasOcup = qtdPoltronasOcup;
        this.numCarro = numCarro;
        this.nomeMotorista = nomeMotorista;
        this.mensagem = mensagem;
        this.codPrefixo = codPrefixo;
        this.lCidadeI = new Linha(lCidadeI);
        this.lCidadeF = new Linha(lCidadeF);
        this.lPreco = new Linha(lPreco);
        this.c1 = new Cidade(c1);
        this.c2 = new Cidade(c2);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getdViagem() {
        return dViagem;
    }

    public void setdViagem(String dViagem) {
        this.dViagem = dViagem;
    }

    public String gethViagem() {
        return hViagem;
    }

    public void sethViagem(String hViagem) {
        this.hViagem = hViagem;
    }

    public int getQtdPoltronas() {
        return qtdPoltronas;
    }

    public void setQtdPoltronas(int qtdPoltronas) {
        this.qtdPoltronas = qtdPoltronas;
    }

    public int getQtdPoltronasOcup() {
        return qtdPoltronasOcup;
    }

    public void setQtdPoltronasOcup(int qtdPoltronasOcup) {
        this.qtdPoltronasOcup = qtdPoltronasOcup;
    }

    public int getNumCarro() {
        return numCarro;
    }

    public void setNumCarro(int numCarro) {
        this.numCarro = numCarro;
    }

    public String getNomeMotorista() {
        return nomeMotorista;
    }

    public void setNomeMotorista(String nomeMotorista) {
        this.nomeMotorista = nomeMotorista;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public int getCodPrefixo() {
        return codPrefixo;
    }

    public void setCodPrefixo(int codPrefixo) {
        this.codPrefixo = codPrefixo;
    }

    public Linha getlCidadeI() {
        return lCidadeI;
    }

    public void setlCidadeI(Linha lCidadeI) {
        this.lCidadeI = lCidadeI;
    }

    public Linha getlCidadeF() {
        return lCidadeF;
    }

    public Cidade getC1() {
        return c1;
    }

    public void setC1(Cidade c1) {
        this.c1 = c1;
    }

    public Cidade getC2() {
        return c2;
    }

    public void setC2(Cidade c2) {
        this.c2 = c2;
    }
}