/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.Controller;

import Dao.Class.Caixa;
import model.Conexao;

/**
 *
 * @author Leandro Baroni
 */
public class CaixaControlador {
    private Caixa caixa;
    private Conexao C;
    String erroConexao;
    
    public CaixaControlador() {
        C = new Conexao("jdbc:mysql://localhost:3306/db_svp", "root", "");
        erroConexao = C.getMensagemErro();
    }
    
    public String getMensagemErro() {
        return erroConexao;
    }
    
    /*public boolean inserir(Caixa novo) {
        System.out.println("inserir cadastro");
        int resp = C.manipular("INSERT INTO caixa (data_abertura, horario_abertura, data_fechamento, horario_fechamento, valor_inicial, valor_final, funcionario) "
                + "VALUES ('"+novo.getData_abertura()+"', '"+novo.getHorario_abertura()+"','"+novo.getData_fechamento()+"', '"+novo.getHorario_fechamento()+"', '"+novo.getValor_inicial()+"', '"+novo.getValor_final()+"', '"+novo.getFuncionario()+"')");
        String sql = Integer.toString(resp);
        System.out.println(sql);
        System.out.println("antes do resp");
        System.out.println(resp);
        System.out.println("depois do resp");
        if (resp == 0) {
            System.out.println("Erro de inserção");
            erroConexao = C.getMensagemErro();
            return false;
        } 
        System.out.println("deu certo");
        return true;
    }*/
}
