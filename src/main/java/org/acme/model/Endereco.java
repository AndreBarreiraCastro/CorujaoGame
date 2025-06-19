package org.acme.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Endereco {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    private Long id;
    
    @Column()
    private String quadra;

    @Column()
    private String alameda;

    @Column()
    private String lote;

    @ManyToOne
    @JoinColumn
    private Municipio endereMunicipio;
    
    @ManyToOne
    @JoinColumn
    private Usuario enderecUsuario;

    @Column()
    private String cep;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuadra() {
        return quadra;
    }

    public void setQuadra(String quadra) {
        this.quadra = quadra;
    }

    public String getAlameda() {
        return alameda;
    }

    public void setAlameda(String alameda) {
        this.alameda = alameda;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public Municipio getEndereMunicipio() {
        return endereMunicipio;
    }

    public void setEndereMunicipio(Municipio endereMunicipio) {
        this.endereMunicipio = endereMunicipio;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Usuario getEnderecUsuario() {
        return enderecUsuario;
    }

    public void setEnderecUsuario(Usuario enderecUsuario) {
        this.enderecUsuario = enderecUsuario;
    }

    
}
