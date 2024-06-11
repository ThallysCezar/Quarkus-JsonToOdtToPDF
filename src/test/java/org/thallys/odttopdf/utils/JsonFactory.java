package org.thallys.odttopdf.utils;

import fr.opensagres.xdocreport.document.json.JSONObject;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class JsonFactory {
    public static JSONObject createTemplate1Json() {
        JSONObject json = new JSONObject();
        // Dados principais
        json.put("policyNumber", "123456789");
        json.put("produto", "Seguro Automóvel");
        json.put("processoSusep", "987654");
        json.put("codigoRamo", "001");
        json.put("proposta", "789456");
        json.put("apoliceRenovar", "456789");
        json.put("endosso", "654321");
        json.put("dataEmissao", "2024-06-06");
        json.put("vigenciaSeguro", "2024-06/2025-06");

        // Seguradora
        JSONObject seguradora = new JSONObject();
        seguradora.put("cnpj", "12345678000199");
        seguradora.put("codigoSusep", "123456");
        seguradora.put("endereco", "Rua Seguradora, 123");
        seguradora.put("celular", "(11) 98765-4321");
        json.put("seguradora", seguradora);

        // Segurado
        JSONObject segurado = getJsonObject();
        json.put("segurado", segurado);

        // Veículo
        JSONObject veiculo = getObject();
        json.put("veiculo", veiculo);

        // Pagamento
        JSONObject pagamento = new JSONObject();
        pagamento.put("premio", "2000");
        pagamento.put("custo", "50");
        pagamento.put("juros", "20");
        pagamento.put("iof", "25");
        pagamento.put("premioTotal", "2095");
        pagamento.put("formaPagamento", "Cartão de Crédito");
        pagamento.put("parcelas", "12");
        json.put("pagamento", pagamento);

        // Corretor
        JSONObject corretor = new JSONObject();
        corretor.put("nome", "Corretor de Seguros");
        corretor.put("susep", "789456");
        corretor.put("telefone", "(11) 1234-5678");
        corretor.put("email", "corretorexample.com");
        json.put("corretor", corretor);

        // Outros dados
        json.put("coberturaContratadas", "Cobertura Completa");
        json.put("premio", "2000");
        json.put("capitalSegurado", "50000");
        json.put("cobertura", "Colisão");
        json.put("franquia", "500");
        json.put("tipoFranquia", "Reduzida");
        json.put("assistenciaContratada", "Assistência 24h");
        json.put("telefoneAcionamento", "(11) 987654321");

        return json;
    }

    private static JSONObject getObject() {
        JSONObject veiculo = new JSONObject();
        veiculo.put("nome", "Carro Modelo X");
        veiculo.put("marca", "Marca Y");
        veiculo.put("anoModelo", "2022");
        veiculo.put("km", "0");
        veiculo.put("dataSaida", "2024-06-01");
        veiculo.put("combustivel", "Gasolina");
        veiculo.put("categoria", "Passeio");
        veiculo.put("chassi", "9BWZZZ377VT004251");
        veiculo.put("placa", "ABC-1234");
        veiculo.put("proprietario", "João Silva");
        return veiculo;
    }

    public static JSONObject createTemplate2Json() {
        JSONObject json = new JSONObject();
        // Dados principais
        json.put("policyNumber", "123456789");
        json.put("produto", "Seguro Vida");
        json.put("processoSusep", "987654");
        json.put("codigoRamo", "001");
        json.put("proposta", "789456");
        json.put("apoliceRenovar", "456789");
        json.put("endosso", "654321");
        json.put("dataEmissao", "2024-06-06");
        json.put("vigenciaSeguro", "2024-06/2025-06");

        // Seguradora
        JSONObject seguradora = new JSONObject();
        seguradora.put("cnpj", "12345678000199");
        seguradora.put("codigoSusep", "123456");
        seguradora.put("endereco", "Rua Seguradora, 123");
        seguradora.put("celular", "(11) 98765-4321");
        json.put("seguradora", seguradora);

        // Segurado
        JSONObject segurado = getJsonObject();
        json.put("segurado", segurado);

        // Veículo
        JSONObject seguroVida = new JSONObject();
        seguroVida.put("nome", "Maria Souza");
        seguroVida.put("idade", "49");
        seguroVida.put("valor", "100000");
        seguroVida.put("cobertura", "Cobertura Completa");
        seguroVida.put("beneficiarios", "João Souza");
        json.put("seguroVida", seguroVida);

        // Pagamento
        JSONObject pagamento = new JSONObject();
        pagamento.put("premio", "2000");
        pagamento.put("custo", "50");
        pagamento.put("juros", "20");
        pagamento.put("iof", "25");
        pagamento.put("premioTotal", "2095");
        pagamento.put("formaPagamento", "Cartão de Crédito");
        pagamento.put("parcelas", "12");
        json.put("pagamento", pagamento);

        // Corretor
        JSONObject corretor = new JSONObject();
        corretor.put("nome", "Corretor de Seguros");
        corretor.put("susep", "789456");
        corretor.put("telefone", "(11) 1234-5678");
        corretor.put("email", "corretorexample.com");
        json.put("corretor", corretor);

        // Outros dados
        json.put("coberturaContratadas", "Cobertura Completa");
        json.put("premio", "2000");
        json.put("capitalSegurado", "50000");
        json.put("cobertura", "Colisão");
        json.put("franquia", "500");
        json.put("tipoFranquia", "Reduzida");
        json.put("assistenciaContratada", "Assistência 24h");
        json.put("telefoneAcionamento", "(11) 987654321");

        return json;
    }

    private static JSONObject getJsonObject() {
        JSONObject segurado = new JSONObject();
        segurado.put("nome", "João Silva");
        segurado.put("cpfCnpj", "12345678901");
        segurado.put("dataNascimento", "1980-01-01");
        segurado.put("sexo", "Masculino");
        segurado.put("profAtiv", "Engenheiro");
        segurado.put("salario", "5000");
        segurado.put("endereco", "Rua Segurado, 456");
        segurado.put("numero", "456");
        segurado.put("comp", "Apto 101");
        segurado.put("bairro", "Bairro Seguro");
        segurado.put("cep", "12345-678");
        segurado.put("cidade", "São Paulo");
        segurado.put("estado", "SP");
        segurado.put("telefone", "(11) 1234-5678");
        segurado.put("celular", "(11) 98765-4321");
        segurado.put("email", "joao.silva@example.com");
        return segurado;
    }

}
