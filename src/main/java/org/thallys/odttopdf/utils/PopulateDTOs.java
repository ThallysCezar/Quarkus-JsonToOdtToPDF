package org.thallys.odttopdf.utils;

import fr.opensagres.xdocreport.document.json.JSONObject;
import jakarta.enterprise.context.ApplicationScoped;
import org.thallys.odttopdf.dto.*;

@ApplicationScoped
public class PopulateDTOs {

    public VeiculoDTO populateVeiculoDTO(JSONObject jsonObject) {
        JSONObject veiculoJson = jsonObject.getJSONObject("veiculo");
        VeiculoDTO veiculoDTO = new VeiculoDTO();
        veiculoDTO.setNome(veiculoJson.getString("nome"));
        veiculoDTO.setMarca(veiculoJson.getString("marca"));
        veiculoDTO.setAnoModelo(veiculoJson.getString("anoModelo"));
        veiculoDTO.setKm(veiculoJson.getString("km"));
        veiculoDTO.setDataSaida(veiculoJson.getString("dataSaida"));
        veiculoDTO.setCombustivel(veiculoJson.getString("combustivel"));
        veiculoDTO.setCategoria(veiculoJson.getString("categoria"));
        veiculoDTO.setChassi(veiculoJson.getString("chassi"));
        veiculoDTO.setPlaca(veiculoJson.getString("placa"));
        veiculoDTO.setProprietario(veiculoJson.getString("proprietario"));
        return veiculoDTO;
    }

    public SeguroVidaDTO populateSeguroVidaDTO(JSONObject jsonObject) {
        JSONObject seguroVidaJson = jsonObject.getJSONObject("seguroVida");
        SeguroVidaDTO seguroVidaDTO = new SeguroVidaDTO();
        seguroVidaDTO.setNome(seguroVidaJson.getString("nome"));
        seguroVidaDTO.setIdade(seguroVidaJson.getString("idade"));
        seguroVidaDTO.setCobertura(seguroVidaJson.getString("cobertura"));
        seguroVidaDTO.setValor(seguroVidaJson.getString("valor"));
        seguroVidaDTO.setBeneficiarios(seguroVidaJson.getString("beneficiarios"));
        return seguroVidaDTO;
    }

    public SeguradoraDTO populateSeguradoraDTO(JSONObject jsonObject) {
        JSONObject seguradoraJson = jsonObject.getJSONObject("seguradora");
        SeguradoraDTO seguradoraDTO = new SeguradoraDTO();
        seguradoraDTO.setCnpj(seguradoraJson.getString("cnpj"));
        seguradoraDTO.setCodigoSusep(seguradoraJson.getString("codigoSusep"));
        seguradoraDTO.setEndereco(seguradoraJson.getString("endereco"));
        seguradoraDTO.setCelular(seguradoraJson.getString("celular"));
        return seguradoraDTO;
    }

    public SeguradoDTO populateSeguradoDTO(JSONObject jsonObject) {
        JSONObject seguradoJson = jsonObject.getJSONObject("segurado");
        SeguradoDTO seguradoDTO = new SeguradoDTO();
        seguradoDTO.setNome(seguradoJson.getString("nome"));
        seguradoDTO.setCpfCnpj(seguradoJson.getString("cpfCnpj"));
        seguradoDTO.setDataNascimento(seguradoJson.getString("dataNascimento"));
        seguradoDTO.setSexo(seguradoJson.getString("sexo"));
        seguradoDTO.setProfAtividade(seguradoJson.getString("profAtiv"));
        seguradoDTO.setSalario(seguradoJson.getString("salario"));
        seguradoDTO.setEndereco(seguradoJson.getString("endereco"));
        seguradoDTO.setNumero(seguradoJson.getString("numero"));
        seguradoDTO.setComp(seguradoJson.getString("comp"));
        seguradoDTO.setBairro(seguradoJson.getString("bairro"));
        seguradoDTO.setCep(seguradoJson.getString("cep"));
        seguradoDTO.setCidade(seguradoJson.getString("cidade"));
        seguradoDTO.setTelefone(seguradoJson.getString("telefone"));
        seguradoDTO.setCelular(seguradoJson.getString("celular"));
        seguradoDTO.setEmail(seguradoJson.getString("email"));
        return seguradoDTO;
    }

    public PagamentoDTO populatePagamentoDTO(JSONObject jsonObject) {
        JSONObject pagamentoJson = jsonObject.getJSONObject("pagamento");
        PagamentoDTO pagamentoDTO = new PagamentoDTO();
        pagamentoDTO.setPremio(pagamentoJson.getString("premio"));
        pagamentoDTO.setCusto(pagamentoJson.getString("custo"));
        pagamentoDTO.setJuros(pagamentoJson.getString("juros"));
        pagamentoDTO.setIof(pagamentoJson.getString("iof"));
        pagamentoDTO.setPremioTotal(pagamentoJson.getString("premioTotal"));
        pagamentoDTO.setFormaPagamento(pagamentoJson.getString("formaPagamento"));
        pagamentoDTO.setParcelas(pagamentoJson.getString("parcelas"));
        return pagamentoDTO;
    }

    public CorretorDTO populateCorretorDTO(JSONObject jsonObject) {
        JSONObject corretorJson = jsonObject.getJSONObject("corretor");
        CorretorDTO corretorDTO = new CorretorDTO();
        corretorDTO.setNome(corretorJson.getString("nome"));
        corretorDTO.setSusep(corretorJson.getString("susep"));
        corretorDTO.setTelefone(corretorJson.getString("telefone"));
        corretorDTO.setEmail(corretorJson.getString("email"));
        return corretorDTO;
    }
}
