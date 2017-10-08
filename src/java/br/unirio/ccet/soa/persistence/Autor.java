/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unirio.ccet.soa.persistence;

/**
 *
 * @author labccet
 */
public class Autor {
    
     private int id;
     private String nome;
     private String cpf;
     private String citacaoAutor;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the citacaoAutor
     */
    public String getCitacaoAutor() {
        return citacaoAutor;
    }

    /**
     * @param citacaoAutor the citacaoAutor to set
     */
    public void setCitacaoAutor(String citacaoAutor) {
        this.citacaoAutor = citacaoAutor;
    }
}
