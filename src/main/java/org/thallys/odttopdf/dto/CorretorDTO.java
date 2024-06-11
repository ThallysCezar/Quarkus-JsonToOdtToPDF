package org.thallys.odttopdf.dto;

public class CorretorDTO {
    private String nome;
    private String susep;
    private String telefone;
    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSusep() {
        return susep;
    }

    public void setSusep(String susep) {
        this.susep = susep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}