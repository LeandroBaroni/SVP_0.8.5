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
public class Venda {
    private int codBilhete;
    private int idCliente;
    private double valor;
    private String nomeCliente;
    private String rg;
    private String cpfCnpj;
    private int numPoltrona;
    private int linhaId;
    private int servico;
    private int idFuncionario;
    private String estadoBilhete;
    private String dispPolt;
    private String dataVenda;
    private String horaVenda;
    private String telefone;
    
    private Servico dataViagem;
    private Servico horaViagem;

    public int getCodBilhete() {
        return codBilhete;
    }

    public void setCodBilhete(int codBilhete) {
        this.codBilhete = codBilhete;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public int getNumPoltrona() {
        return numPoltrona;
    }

    public void setNumPoltrona(int numPoltrona) {
        this.numPoltrona = numPoltrona;
    }

    public int getLinhaId() {
        return linhaId;
    }

    public void setLinhaId(int linhaId) {
        this.linhaId = linhaId;
    }

    public int getServico() {
        return servico;
    }

    public void setServico(int servico) {
        this.servico = servico;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getEstadoBilhete() {
        return estadoBilhete;
    }

    public void setEstadoBilhete(String estadoBilhete) {
        this.estadoBilhete = estadoBilhete;
    }

    public String getDispPolt() {
        return dispPolt;
    }

    public void setDispPolt(String dispPolt) {
        this.dispPolt = dispPolt;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getHoraVenda() {
        return horaVenda;
    }

    public void setHoraVenda(String horaVenda) {
        this.horaVenda = horaVenda;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Servico getDataViagem() {
        return dataViagem;
    }

    public void setDataViagem(Servico dataViagem) {
        this.dataViagem = dataViagem;
    }

    public Servico getHoraViagem() {
        return horaViagem;
    }

    public void setHoraViagem(Servico horaViagem) {
        this.horaViagem = horaViagem;
    }


    //contrutores
    public Venda() {
    }

    public Venda(int codBilhete){
        this.codBilhete = codBilhete;
        this.numPoltrona = codBilhete;
    }

    public Venda (int codBilhete, int numPoltrona){
        this.codBilhete = codBilhete;
        this.numPoltrona = numPoltrona;
    }

    public Venda (int codBilhete, String nomeCliente){
        this.codBilhete = codBilhete;
        this.nomeCliente = nomeCliente;
    }

    public Venda (int codBilhete, String nomeCliente, int numPoltrona){
        this.codBilhete = codBilhete;
        this.nomeCliente = nomeCliente;
        this.numPoltrona = numPoltrona;
    }

    public Venda (int codBilhete, double valor, String nomeCliente, int numPoltrona){
        this.codBilhete = codBilhete;
        this.valor = valor;
        this.nomeCliente = nomeCliente;
        this.numPoltrona = numPoltrona;
    }

    public Venda(String nomeCliente) {
        this.nomeCliente = nomeCliente;
        this.dataVenda = nomeCliente;
        this.horaVenda = nomeCliente;
    }

    public Venda(int idCliente, double valor, String nomeCliente, String rg, String cpfCnpj, int numPoltrona, int linhaId, int servico, int idFuncionario, String estadoBilhete, String dispPolt, String dataVenda, String horaVenda) {
        this.idCliente = idCliente;
        this.valor = valor;
        this.nomeCliente = nomeCliente;
        this.rg = rg;
        this.cpfCnpj = cpfCnpj;
        this.numPoltrona = numPoltrona;
        this.linhaId = linhaId;
        this.servico = servico;
        this.idFuncionario = idFuncionario;
        this.estadoBilhete = estadoBilhete;
        this.dispPolt = dispPolt;
        this.dataVenda = dataVenda;
        this.horaVenda = horaVenda;
    }

    public Venda(int codBilhete, int idCliente, double valor, String nomeCliente, String rg, String cpfCnpj, int numPoltrona, int linhaId, int servico, int idFuncionario, String estadoBilhete, String dispPolt, String dataVenda, String horaVenda) {
        this.codBilhete = codBilhete;
        this.idCliente = idCliente;
        this.valor = valor;
        this.nomeCliente = nomeCliente;
        this.rg = rg;
        this.cpfCnpj = cpfCnpj;
        this.numPoltrona = numPoltrona;
        this.linhaId = linhaId;
        this.servico = servico;
        this.idFuncionario = idFuncionario;
        this.estadoBilhete = estadoBilhete;
        this.dispPolt = dispPolt;
        this.dataVenda = dataVenda;
        this.horaVenda = horaVenda;
    }

    public Venda(int codBilhete, int idCliente, double valor, String nomeCliente, String rg, String cpfCnpj, int numPoltrona, int linhaId, int servico, int idFuncionario, String estadoBilhete, String dispPolt, String dataVenda, String horaVenda, String telefone) {
        this.codBilhete = codBilhete;
        this.idCliente = idCliente;
        this.valor = valor;
        this.nomeCliente = nomeCliente;
        this.rg = rg;
        this.cpfCnpj = cpfCnpj;
        this.numPoltrona = numPoltrona;
        this.linhaId = linhaId;
        this.servico = servico;
        this.idFuncionario = idFuncionario;
        this.estadoBilhete = estadoBilhete;
        this.dispPolt = dispPolt;
        this.dataVenda = dataVenda;
        this.horaVenda = horaVenda;
        this.telefone = telefone;
    }

    public Venda(int idCliente, double valor, String nomeCliente, String rg, String cpfCnpj, int numPoltrona, int linhaId, int servico, int idFuncionario, String estadoBilhete, String dispPolt, String dataVenda, String horaVenda, String telefone) {
        this.idCliente = idCliente;
        this.valor = valor;
        this.nomeCliente = nomeCliente;
        this.rg = rg;
        this.cpfCnpj = cpfCnpj;
        this.numPoltrona = numPoltrona;
        this.linhaId = linhaId;
        this.servico = servico;
        this.idFuncionario = idFuncionario;
        this.estadoBilhete = estadoBilhete;
        this.dispPolt = dispPolt;
        this.dataVenda = dataVenda;
        this.horaVenda = horaVenda;
        this.telefone = telefone;
    }

    public Venda(int codBilhete, int idCliente, double valor, String nomeCliente, String rg, String cpfCnpj, int numPoltrona, int linhaId, int servico, int idFuncionario, String estadoBilhete, String dispPolt, String dataVenda, String horaVenda, String telefone, String dataViagem, String horaViagem) {
        this.codBilhete = codBilhete;
        this.idCliente = idCliente;
        this.valor = valor;
        this.nomeCliente = nomeCliente;
        this.rg = rg;
        this.cpfCnpj = cpfCnpj;
        this.numPoltrona = numPoltrona;
        this.linhaId = linhaId;
        this.servico = servico;
        this.idFuncionario = idFuncionario;
        this.estadoBilhete = estadoBilhete;
        this.dispPolt = dispPolt;
        this.dataVenda = dataVenda;
        this.horaVenda = horaVenda;
        this.telefone = telefone;
        this.dataViagem = new Servico(dataViagem);
        this.horaViagem = new Servico(horaViagem);
    }
}