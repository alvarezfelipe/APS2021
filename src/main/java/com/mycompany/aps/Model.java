package com.mycompany.aps;

public class Model {

    private String fauna, grupo, familia, especie, nomeComum, categoria, bioma, ameaca, estado;

    public Model() { //Construtor padrão
    }

    public Model(String fauna, String grupo, String familia,
            String especie, String nomeComum, String categoria, String bioma,
            String ameaca, String estado) {
        this.fauna = fauna;
        this.grupo = grupo;
        this.familia = familia;
        this.especie = especie;
        this.nomeComum = nomeComum;
        this.categoria = categoria;
        this.bioma = bioma;
        this.ameaca = ameaca;
        this.estado = estado;
    }

    //Getters e Setters   
    public String getFauna() {
        return fauna;
    }

    public void setFauna(String fauna) {
        this.fauna = fauna;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getNomeComum() {
        return nomeComum;
    }

    public void setNomeComum(String nomeComum) {
        this.nomeComum = nomeComum;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getBioma() {
        return bioma;
    }

    public void setBioma(String bioma) {
        this.bioma = bioma;
    }

    public String getAmeaca() {
        return ameaca;
    }

    public void setAmeaca(String ameaca) {
        this.ameaca = ameaca;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
