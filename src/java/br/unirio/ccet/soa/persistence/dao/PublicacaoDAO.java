package br.unirio.ccet.soa.persistence.dao;
/**
 *
 * @author Tiago,Yuri,Natasha 
*/
import br.unirio.ccet.soa.persistence.Publicacao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PublicacaoDAO {

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
    
    public List<Publicacao> consultarPublicacao(String titulo) throws Exception{
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Publicacao> listaPublicacao = new ArrayList<Publicacao>();
        Publicacao publicacao = null;
        
        try {
            abrirConexao();
            String sql = "select * from Publicacao where Titulo = ? ";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, titulo);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
            }
                publicacao = new Publicacao();
                publicacao.setId(rs.getInt("id"));
                publicacao.setPaginaInicial(rs.getString("paginaInicial"));
                publicacao.setPaginaFinal(rs.getString("paginaFinal"));
                publicacao.setDataPublicacao(rs.getString("dataPublicacao"));
                listaPublicacao.add(publicacao);

        } finally {
            
            fecharConexao();
        }
        return listaPublicacao;
    }
    
    public void atualizarPublicacaoDataPublicacao(String titulo, String dataPublicacao) throws Exception {
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Publicacao publicacao = null;
        
        try {
            abrirConexao();
            String sql = "update Publicacao set dataPublicacao = ? where titulo = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, dataPublicacao);
            stmt.setString(2, titulo);
            rs = stmt.executeQuery();
          
        } finally {
            
            fecharConexao();
        }
    }
    public void criarPublicacao(String titulo,String pi,String pf,String dataPub)throws Exception{
        
        PreparedStatement stmt;
        
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date data = formato.parse(dataPub);
        java.sql.Date dateSql = new java.sql.Date(data.getTime());
        
        try {
            abrirConexao();
            String sql = "insert into Publicacao values(default,?,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, titulo);
            stmt.setString(2, pi);
            stmt.setString(3, pf);
            stmt.setDate(4, dateSql);
            
            stmt.executeUpdate();
            
        } finally {
            fecharConexao();
        }
    }
    public void deletePublicacao(String titulo)throws Exception{
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Publicacao publicacao = null;
        
        try {
            abrirConexao();
            String sql = "delete Publicacao where titulo = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, titulo);
            
            rs = stmt.executeQuery();
            
        } finally {   
            fecharConexao();
        }
    }
}
