package br.unirio.ccet.soa.persistence.dao;
/**
 *
 * @author Tiago,Yuri,Natasha 
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PublicacaoAutorDAO {

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
    
    public void associarPublicacaoAAutor(int idAutor, int idPublicacao)throws Exception{
        
        PreparedStatement stmt;
                
        try {
            abrirConexao();
            String sql = "insert into publicacao_autor values(default,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idAutor);
            stmt.setInt(2, idPublicacao);
            
            stmt.executeUpdate();
            
        } finally {
            fecharConexao();
        }
    }
    
}
