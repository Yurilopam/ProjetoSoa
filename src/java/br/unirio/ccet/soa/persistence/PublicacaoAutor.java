package br.unirio.ccet.soa.persistence;

/**
 *
 * @author Tiago,Yuri,Natasha
 */
public class PublicacaoAutor {
    
    private String nome;
    private String titulo;
    private String dataPublicacao;

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
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the dataPublicacao
     */
    public String getDataPublicacao() {
        return dataPublicacao;
    }

    /**
     * @param dataPublicacao the dataPublicacao to set
     */
    public void setDataPublicacao(String dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }
    
}
