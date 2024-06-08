package org.thallys.odttopdf.service;

import fr.opensagres.xdocreport.converter.ConverterTypeTo;
import fr.opensagres.xdocreport.converter.Options;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.core.document.DocumentKind;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.json.JSONObject;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;
import jakarta.enterprise.context.ApplicationScoped;
import org.jboss.logging.Logger;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class OdtToPdfService {

    private static final Logger LOG = Logger.getLogger(OdtToPdfService.class);

    public InputStream convertJsonToPdf(String json, String templateName) throws IOException, XDocReportException {
        JSONObject jsonObject = new JSONObject(json);
        Map<String, Object> data = new HashMap<>();
        LOG.info("Adicionando informacoes do comum no JSON");
        populateCommonData(data, jsonObject);

        // Carrega o template ODT
        InputStream templateStream = getClass().getResourceAsStream("/" + templateName + ".odt");
        if (templateStream == null) {
            throw new FileNotFoundException("Template ODT não encontrado em: /" + templateName + ".odt");
        }

        if (templateName.equals("template_1.odt")) {
            // Dados do veículo
            LOG.info("Adicionando informacoes do template_1 JSON");
//            JSONObject parteVeiculo = jsonObject.getJSONObject("veiculo");
            data.put("veiculoNome", jsonObject.getString("veiculoNome"));
            data.put("veiculoMarca", jsonObject.getString("veiculoMarca"));
            data.put("veiculoAnoModelo", jsonObject.getString("veiculoAnoModelo"));
            data.put("veiculoKm", jsonObject.getString("veiculoKm"));
            data.put("veiculoDataSaida", jsonObject.getString("veiculoDataSaida"));
            data.put("veiculoCombustivel", jsonObject.getString("veiculoCombustivel"));
            data.put("veiculoCategoria", jsonObject.getString("veiculoCategoria"));
            data.put("veiculoChassi", jsonObject.getString("veiculoChassi"));
            data.put("veiculoPlaca", jsonObject.getString("veiculoPlaca"));
            data.put("veiculoProprietario", jsonObject.getString("veiculoProprietario"));
        } else if (templateName.equals("template_2.odt")) {
            // Dados do seguro de vida
            LOG.info("Adicionando informacoes do template_2 JSON");
//            JSONObject parteVida = jsonObject.getJSONObject("segurovida");
            data.put("seguroVidaNome", jsonObject.getString("seguroVidaNome"));
            data.put("seguroVidaIdade", jsonObject.getString("seguroVidaIdade"));
            data.put("seguroVidaValor", jsonObject.getString("seguroVidaValor"));
            data.put("seguroVidaCobertura", jsonObject.getString("seguroVidaCobertura"));
            data.put("seguroVidaBeneficiario", jsonObject.getString("seguroVidaBeneficiario"));

        }

        // Carrega o documento
        IXDocReport report = XDocReportRegistry.getRegistry().loadReport(templateStream, TemplateEngineKind.Freemarker);

        // Criar metadados de campos para definir campos como texto simples
        FieldsMetadata metadata = new FieldsMetadata();
        metadata.addFieldAsTextStyling("name", DocumentKind.ODT.name());
        metadata.addFieldAsTextStyling("age", DocumentKind.ODT.name());
        metadata.addFieldAsTextStyling("location", DocumentKind.ODT.name());
        report.setFieldsMetadata(metadata);

        // Criar contexto e mesclar com o modelo
        IContext context = report.createContext();
        context.putMap(data);

        // Cria o contexto e preenche com os dados do JSON
        ByteArrayOutputStream pdfOutputStream = new ByteArrayOutputStream();
        Options options = Options.getFrom("ODT").to(ConverterTypeTo.PDF);

        report.convert(context, options, pdfOutputStream);

        // Retorna o PDF como InputStream
        return new ByteArrayInputStream(pdfOutputStream.toByteArray());
    }

    private void populateCommonData(Map<String, Object> data, JSONObject jsonObject) {
        // Dados comuns a ambos os templates
        data.put("policyNumber", jsonObject.getString("policyNumber"));
        data.put("produto", jsonObject.getString("produto"));
        data.put("processoSusep", jsonObject.getString("processoSusep"));
        data.put("codigoRamo", jsonObject.getString("codigoRamo"));
        data.put("proposta", jsonObject.getString("proposta"));
        data.put("apoliceRenovar", jsonObject.getString("apoliceRenovar"));
        data.put("endosso", jsonObject.getString("endosso"));
        data.put("dataEmissao", jsonObject.getString("dataEmissao"));
        data.put("vigenciaSeguro", jsonObject.getString("vigenciaSeguro"));

//        JSONObject parteSeguradora = jsonObject.getJSONObject("seguradora");
//        System.out.println("Seguradora: " +  parteSeguradora);
        data.put("seguradoraCnpj", jsonObject.getString("seguradoraCnpj"));
        data.put("seguradoraCodigoSusep", jsonObject.getString("seguradoraCodigoSusep"));
        data.put("seguradoraEndereco", jsonObject.getString("seguradoraEndereco"));
        data.put("seguradoraCelular", jsonObject.getString("seguradoraCelular"));

//        JSONObject parteSegurado = jsonObject.getJSONObject("segurado");
        data.put("seguradoNome", jsonObject.getString("seguradoNome"));
        data.put("seguradoCpfCnpj", jsonObject.getString("seguradoCpfCnpj"));
        data.put("seguradoDataNascimento", jsonObject.getString("seguradoDataNascimento"));
        data.put("seguradoSexo", jsonObject.getString("seguradoSexo"));
        data.put("seguradoProfAtiv", jsonObject.getString("seguradoProfAtiv"));
        data.put("seguradoSalario", jsonObject.getString("seguradoSalario"));
        data.put("seguradoEndereco", jsonObject.getString("seguradoEndereco"));
        data.put("seguradoNumero", jsonObject.getString("seguradoNumero"));
        data.put("seguradoComp", jsonObject.getString("seguradoComp"));
        data.put("seguradoBairro", jsonObject.getString("seguradoBairro"));
        data.put("seguradoCep", jsonObject.getString("seguradoCep"));
        data.put("seguradoCidade", jsonObject.getString("seguradoCidade"));
        data.put("seguradoEstado", jsonObject.getString("seguradoEstado"));
        data.put("seguradoTelefone", jsonObject.getString("seguradoTelefone"));
        data.put("seguradoCelular", jsonObject.getString("seguradoCelular"));
        data.put("seguradoEmail", jsonObject.getString("seguradoEmail"));

//        JSONObject partePagamento = jsonObject.getJSONObject("pagamento");
        data.put("pagamentoPremio", jsonObject.getString("pagamentoPremio"));
        data.put("pagamentoCusto", jsonObject.getString("pagamentoCusto"));
        data.put("pagamentoJuros", jsonObject.getString("pagamentoJuros"));
        data.put("pagamentoIof", jsonObject.getString("pagamentoIof"));
        data.put("pagamentoPremioTotal", jsonObject.getString("pagamentoPremioTotal"));
        data.put("pagamentoFormaPagamento", jsonObject.getString("pagamentoFormaPagamento"));
        data.put("pagamentoParcelas", jsonObject.getString("pagamentoParcelas"));

//        JSONObject parteCorretor = jsonObject.getJSONObject("corretor");
        data.put("corretorNome", jsonObject.getString("corretorNome"));
        data.put("corretorSusep", jsonObject.getString("corretorSusep"));
        data.put("corretorTelefone", jsonObject.getString("corretorTelefone"));
        data.put("corretorEmail", jsonObject.getString("corretorEmail"));

        data.put("coberturaContratadas", jsonObject.getString("coberturaContratadas"));
        data.put("premio", jsonObject.getString("premio"));
        data.put("capitalSegurado", jsonObject.getString("capitalSegurado"));

        data.put("cobertura", jsonObject.getString("cobertura"));
        data.put("franquia", jsonObject.getString("franquia"));
        data.put("tipoFranquia", jsonObject.getString("tipoFranquia"));

        data.put("assistenciaContratada", jsonObject.getString("assistenciaContratada"));
        data.put("telefoneAcionamento", jsonObject.getString("telefoneAcionamento"));
    }
}