package org.thallys.odttopdf.dto;

public class PagamentoDTO {
    private String premio;
    private String custo;
    private String juros;
    private String iof;
    private String premioTotal;
    private String formaPagamento;
    private String parcelas;

    public String getPremio() {
        return premio;
    }

    public void setPremio(String premio) {
        this.premio = premio;
    }

    public String getCusto() {
        return custo;
    }

    public void setCusto(String custo) {
        this.custo = custo;
    }

    public String getJuros() {
        return juros;
    }

    public void setJuros(String juros) {
        this.juros = juros;
    }

    public String getIof() {
        return iof;
    }

    public void setIof(String iof) {
        this.iof = iof;
    }

    public String getPremioTotal() {
        return premioTotal;
    }

    public void setPremioTotal(String premioTotal) {
        this.premioTotal = premioTotal;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getParcelas() {
        return parcelas;
    }

    public void setParcelas(String parcelas) {
        this.parcelas = parcelas;
    }

}