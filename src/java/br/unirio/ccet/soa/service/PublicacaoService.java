/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unirio.ccet.soa.service;

import br.unirio.ccet.soa.persistence.Publicacao;
import br.unirio.ccet.soa.persistence.dao.PublicacaoDAO;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Tiago,Yuri, Natasha
 */
@WebService(serviceName = "PublicacaoService")
public class PublicacaoService {
    
    @WebMethod(operationName = "consultarPublicacao")
    public List<Publicacao> consultarPublicacao(@WebParam(name ="titulo") String titulo) throws Exception{
        
        PublicacaoDAO dao = new PublicacaoDAO();
        List<Publicacao> listaPublicacao = dao.consultarPublicacao(titulo);
        
        return listaPublicacao;
    }

    @WebMethod(operationName = "atualizarPublicacao")
    public void atualizarPublicacao(@WebParam(name = "titulo")String titulo,
                                    @WebParam(name = "dataPublicacao")String dataPub)throws Exception{
        
        PublicacaoDAO dao = new PublicacaoDAO();
        dao.atualizarPublicacaoDataPublicacao(titulo, dataPub);
        
    }
    
    @WebMethod(operationName = "criarPublicacao")
    public void criarPublicacao(@WebParam(name = "titulo")String titulo,
                                @WebParam(name = "paginaInicial")String pi,
                                @WebParam(name = "paginaFinal")String pf,
                                @WebParam(name = "dataPublicacao")String dataPub)throws Exception{
        
        PublicacaoDAO dao = new PublicacaoDAO();     
        dao.criarPublicacao(titulo, pi, pf, dataPub);
        
    }
    
    @WebMethod(operationName = "deletePublicacao")
    public void deletePublicacao(@WebParam(name = "titulo")String titulo)throws Exception{
        
        PublicacaoDAO dao = new PublicacaoDAO();
        dao.deletePublicacao(titulo);
        
    }
}
