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
public class Linha {
    private int id;
    private int prefixo;
    private int cidadeInicial;
    private int cidadeFinal;
    private double tarifa;
    private double taxaRod;
    private double pedagio;
    private double precoTotal;
    private String duracao;
    private String disp;

    Cidade cidade1;
    Cidade cidade2;

    public Linha() {
    }


    public Linha(int cidadeInicial, String cidade1, int cidadeFinal, String cidade2, String duracao) {
        this.cidadeInicial = cidadeInicial;
        this.cidade1 = new Cidade(cidade1);
        this.cidadeFinal = cidadeFinal;
        this.cidade2 = new Cidade(cidade2);
        this.duracao = duracao;
    }

    public Linha(int valor) {
        this.prefixo = valor;
        this.cidadeInicial = valor;
        this.cidadeFinal = valor;
    }

    public Linha(double precoTotal){
        this.precoTotal = precoTotal;
    }

    public Linha(String cidadeInicial) {
        this.cidadeInicial = Integer.parseInt(cidadeInicial);
    }

    public Linha(int id, int prefixo, int c1, int c2) {
        this.id = id;
        this.prefixo = prefixo;
        this.cidadeInicial = c1;
        this.cidadeFinal = c2;
    }

    public Linha(int prefixo, int cidadeInicial, int cidadeFinal, double tarifa, double taxaRod, double pedagio, double precoTotal, String duracao, String disp) {
        this.prefixo = prefixo;
        this.cidadeInicial = cidadeInicial;
        this.cidadeFinal = cidadeFinal;
        this.tarifa = tarifa;
        this.taxaRod = taxaRod;
        this.pedagio = pedagio;
        this.precoTotal = precoTotal;
        this.duracao = duracao;
        this.disp = disp;
    }

    public Linha(int id, int prefixo, int cidadeInicial, int cidadeFinal, double tarifa, double taxaRod, double pedagio, double precoTotal, String duracao, String disp) {
        this.id = id;
        this.prefixo = prefixo;
        this.cidadeInicial = cidadeInicial;
        this.cidadeFinal = cidadeFinal;
        this.tarifa = tarifa;
        this.taxaRod = taxaRod;
        this.pedagio = pedagio;
        this.precoTotal = precoTotal;
        this.duracao = duracao;
        this.disp = disp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrefixo() {
        return prefixo;
    }

    public void setPrefixo(int prefixo) {
        this.prefixo = prefixo;
    }

    public int getCidadeInicial() {
        return cidadeInicial;
    }

    public void setCidadeInicial(int cidadeInicial) {
        this.cidadeInicial = cidadeInicial;
    }

    public int getCidadeFinal() {
        return cidadeFinal;
    }

    public void setCidadeFinal(int cidadeFinal) {
        this.cidadeFinal = cidadeFinal;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public double getTaxaRod() {
        return taxaRod;
    }

    public void setTaxaRod(double taxaRod) {
        this.taxaRod = taxaRod;
    }

    public double getPedagio() {
        return pedagio;
    }

    public void setPedagio(double pedagio) {
        this.pedagio = pedagio;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = tarifa + taxaRod + pedagio;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getDisp() {
        return disp;
    }

    public void setDisp(String disp) {
        this.disp = disp;
    }

    public Cidade getCidade1() {
        return cidade1;
    }

    public void setCidade1(Cidade cidade1) {
        this.cidade1 = cidade1;
    }

    public Cidade getCidade2() {
        return cidade2;
    }

    public void setCidade2(Cidade cidade2) {
        this.cidade2 = cidade2;
    }
}