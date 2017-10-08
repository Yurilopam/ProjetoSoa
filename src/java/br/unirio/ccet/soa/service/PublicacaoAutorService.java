/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unirio.ccet.soa.service;

import br.unirio.ccet.soa.persistence.dao.PublicacaoAutorDAO;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Tiago,Yuri, Natasha
 */
@WebService(serviceName = "PublicacaoAutorService")
public class PublicacaoAutorService {
    
    @WebMethod(operationName = "associarPublicacaoAAutor") 
    public void associarPublicacaoAAutor(@WebParam(name = "idAutor") int idAutor,
                                         @WebParam(name = "idPublicacao") int idPublicacao) throws Exception {
        
        PublicacaoAutorDAO dao = new PublicacaoAutorDAO();
        dao.associarPublicacaoAAutor(idAutor, idPublicacao);
        
    }
    
}
