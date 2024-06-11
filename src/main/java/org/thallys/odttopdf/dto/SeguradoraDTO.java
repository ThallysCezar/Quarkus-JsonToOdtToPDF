package org.thallys.odttopdf.dto;

public class SeguradoraDTO {
    private String cnpj;
    private String codigoSusep;
    private String endereco;
    private String celular;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCodigoSusep() {
        return codigoSusep;
    }

    public void setCodigoSusep(String codigoSusep) {
        this.codigoSusep = codigoSusep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

}