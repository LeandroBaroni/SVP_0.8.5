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
public class Cidade {
    private int codigo;
    private String cidade;

    public Cidade() {
    }

    public Cidade(int codigo) {
        this.codigo = codigo;
    }

    public Cidade(String cidade) {
        this.cidade = cidade;
    }
    
    public Cidade(int codigo, String cidade) {
        this.codigo = codigo;
        this.cidade = cidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
