/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unirio.ccet.soa.service;

import br.unirio.ccet.soa.persistence.Autor;
import br.unirio.ccet.soa.persistence.PublicacaoAutor;
import br.unirio.ccet.soa.persistence.dao.AutorDAO;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


@WebService(serviceName = "AutorService")
public class AutorService {
    
    /*Select Autor */
    @WebMethod(operationName = "consultarAutor") 
    public List<Autor> consultarAutor(@WebParam(name = "nome") String nome) throws Exception {
        
        AutorDAO dao = new AutorDAO();
        List<Autor> listaAutores = dao.consultarAutor(nome);
        
        return listaAutores;
    }
    
    /*Atualizar Autor*/
    @WebMethod(operationName = "atualizarAutor") 
    public void atualizarAutor(@WebParam(name = "nome") String nome,
                               @WebParam(name = "cpf") String cpf )throws Exception {
        
        AutorDAO dao = new AutorDAO();
       dao.atualizarAutorCpf(nome,cpf);
        
    }
    
    /*Criar Autor */
    @WebMethod(operationName = "criarAutor") 
    public void criarAutor(@WebParam(name = "nome") String nome,
                                  @WebParam(name = "cpf") String cpf,
                                  @WebParam(name = "nomeCitacao")String nomeCitacao) throws Exception {
        
        AutorDAO dao = new AutorDAO();
        dao.criarAutor(nome,cpf,nomeCitacao);
    }
    
    /*Deletar Autor*/
    @WebMethod(operationName = "deleteAutor") 
    public void deleteAutor(@WebParam(name = "nome") String nome) throws Exception {
        
        AutorDAO dao = new AutorDAO();
        dao.deletarAutor(nome);
    }
    
        /*Select Autor */
    @WebMethod(operationName = "consultarReferenciasBibliograficasAutor") 
    public List<PublicacaoAutor> consultarReferenciasBibliograficasAutor(@WebParam(name = "nome") String nome) throws Exception {
        
        AutorDAO dao = new AutorDAO();
        List<PublicacaoAutor> referenciasAutor = dao.consultarReferenciasBibliograficasAutor(nome);
        
        return referenciasAutor;
    }
    
    @WebMethod(operationName = "consultarCep") 
    public List<String> consultarCep(@WebParam(name = "cep") String cep) throws Exception {
        
        WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);
        List<String> endereço = new ArrayList<>();
        if (webServiceCep.wasSuccessful()) {
            endereço.add(webServiceCep.getLogradouroFull());
            endereço.add(webServiceCep.getBairro());
            endereço.add(webServiceCep.getCidade());
            endereço.add(webServiceCep.getUf());
        } 
        
        return endereço;
    }
    
}
