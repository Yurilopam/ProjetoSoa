/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unirio.ccet.soa.persistence.dao;

import br.unirio.ccet.soa.persistence.Autor;
import br.unirio.ccet.soa.persistence.PublicacaoAutor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author labccet
 */
public class AutorDAO {

    private static String dbUrl = "jdbc:postgresql://localhost:5432/Publikation";
    private static Connection conn = null;
    
    private static void abrirConexao() {
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            
            conn = DriverManager.getConnection(dbUrl, "postgres", "admin");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void fecharConexao() {
        try {
            
            if (!conn.isClosed()) {
                conn.close();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<Autor> consultarAutor(String nome) throws Exception{
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Autor> listaAutor = new ArrayList<Autor>();
        Autor autor = null;
        try {
            abrirConexao();
            String sql = "select * from autor where nome = ? ";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            rs = stmt.executeQuery();
            while (rs.next()) {
                autor = new Autor();
                autor.setId(rs.getInt("id"));
                autor.setNome(rs.getString("nome"));
                autor.setCpf(rs.getString("cpf"));
                autor.setCitacaoAutor(rs.getString("nome_citacao"));
                listaAutor.add(autor);
            }
        } finally {
            fecharConexao();
        }
        return listaAutor;
    }
    
    public void atualizarAutorCpf(String nome, String cpf) throws Exception {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Autor autor = null;
       
        try {
            abrirConexao();
            String sql = "update autor set cpf=? where nome=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cpf);
            stmt.setString(2, nome);
            rs = stmt.executeQuery();
            
        } finally {
            fecharConexao();
        }
    }
    public void criarAutor(String nome,String cpf,String nomeCitacao)throws Exception{
        
        PreparedStatement stmt;
        
        try {
            abrirConexao();
            String sql = "insert into autor values(default,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, cpf);
            stmt.setString(3, nomeCitacao);
            
            stmt.executeUpdate();
            
        } finally {
            
            fecharConexao();
        }  
    }
    public void deletarAutor(String nome)throws Exception{
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Autor autor = null;
        
        try {
            abrirConexao();
            String sql = "delete Autor where nome = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, sql);
            
            rs = stmt.executeQuery();
            
        } finally {
            fecharConexao();  
        }   
    }
    
    public List<PublicacaoAutor> consultarReferenciasBibliograficasAutor(String nome) throws Exception{
        
        PreparedStatement stmt = null;
        List<PublicacaoAutor> lista = new ArrayList<PublicacaoAutor>();
        ResultSet rs = null;
        PublicacaoAutor publicacaoAutor = null;
        try {
            abrirConexao();
            
            String query = "select a.nome_citacao, p.titulo, p.data_publicacao " +
                            "from autor a " +
                            "join publicacao_autor pa on a.id = pa.id_autor " +
                            "join publicacao p on p.id = pa.id_publicacao " +
                            "where a.nome = ?";

            stmt = conn.prepareStatement(query);
            stmt.setString(1, nome);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                publicacaoAutor = new PublicacaoAutor();
                publicacaoAutor.setNome(rs.getString("nome_citacao"));
                publicacaoAutor.setTitulo(rs.getString("titulo"));
                publicacaoAutor.setDataPublicacao(rs.getString("data_publicacao"));
                lista.add(publicacaoAutor);
            }            
            
        } finally {
            fecharConexao();
        }
        
        return lista;
    }
    
}
