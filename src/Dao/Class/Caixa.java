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
public class Caixa {
    private int sessao;
    private Funcionario codUsuario;
    private String dataAbertura;
    private String horaAbertura;
    private String dataFechamento;
    private String horaFechamento;
    private double valorTotal;

    public int getSessao() {
        return sessao;
    }

    public void setSessao(int sessao) {
        this.sessao = sessao;
    }

    public Funcionario getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Funcionario codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(String dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getHoraAbertura() {
        return horaAbertura;
    }

    public void setHoraAbertura(String horaAbertura) {
        this.horaAbertura = horaAbertura;
    }

    public String getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(String dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public String getHoraFechamento() {
        return horaFechamento;
    }

    public void setHoraFechamento(String horaFechamento) {
        this.horaFechamento = horaFechamento;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Caixa() {
    }

    public Caixa(int sessao) {
        this.sessao = sessao;
    }

    public Caixa(Funcionario codUsuario, String dataAbertura, String horaAbertura, String dataFechamento, String horaFechamento, double valorTotal) {
        this.codUsuario = codUsuario;
        this.dataAbertura = dataAbertura;
        this.horaAbertura = horaAbertura;
        this.dataFechamento = dataFechamento;
        this.horaFechamento = horaFechamento;
        this.valorTotal = valorTotal;
    }

    public Caixa(int sessao, Funcionario codUsuario, String dataAbertura, String horaAbertura, String dataFechamento, String horaFechamento, double valorTotal) {
        this.sessao = sessao;
        this.codUsuario = codUsuario;
        this.dataAbertura = dataAbertura;
        this.horaAbertura = horaAbertura;
        this.dataFechamento = dataFechamento;
        this.horaFechamento = horaFechamento;
        this.valorTotal = valorTotal;
    }
}