package br.unirio.ccet.soa.persistence;

/**
 *
 * @author Tiago,Yuri,Natasha
 */
public class Publicacao {
    
    private int id;
    private String titulo;
    private String paginaInicial;
    private String paginaFinal;
    private String dataPublicacao;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getPaginaInicial() {
        return paginaInicial;
    }

    public void setPaginaInicial(String paginaInicial) {
        this.paginaInicial = paginaInicial;
    }

    public String getPaginaFinal() {
        return paginaFinal;
    }

    public void setPaginaFinal(String paginaFinal) {
        this.paginaFinal = paginaFinal;
    }

    public String getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(String dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }
}
