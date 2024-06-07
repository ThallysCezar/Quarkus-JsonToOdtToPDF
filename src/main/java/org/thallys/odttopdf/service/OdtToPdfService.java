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
            JSONObject parteVeiculo = new JSONObject("veiculo");
            data.put("veiculo.nome", parteVeiculo.getString("nome"));
            data.put("veiculo.marca", parteVeiculo.getString("marca"));
            data.put("veiculo.anomodelo", parteVeiculo.getString("anomodelo"));
            data.put("veiculo.km", parteVeiculo.getString("km"));
            data.put("veiculo.datasaida", parteVeiculo.getString("datasaida"));
            data.put("veiculo.combustivel", parteVeiculo.getString("combustivel"));
            data.put("veiculo.categoria", parteVeiculo.getString("categoria"));
            data.put("veiculo.chassi", parteVeiculo.getString("chassi"));
            data.put("veiculo.placa", parteVeiculo.getString("placa"));
            data.put("veiculo.proprietario", parteVeiculo.getString("proprietario"));
        } else if (templateName.equals("template_2.odt")) {
            // Dados do seguro de vida
            LOG.info("Adicionando informacoes do template_2 JSON");
            JSONObject parteVida = new JSONObject("segurovida");
            data.put("segurovida.nome", parteVida.getString("nome"));
            data.put("segurovida.idade", parteVida.getInt("idade"));
            data.put("segurovida.valor", parteVida.getDouble("valor"));
            data.put("segurovida.cobertura", parteVida.getString("cobertura"));
            data.put("segurovida.beneficiarios", parteVida.getString("beneficiarios"));

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
        data.put("policynumber", jsonObject.getString("policynumber"));
        data.put("produto", jsonObject.getString("produto"));
        data.put("processosusep", jsonObject.getString("processosusep"));
        data.put("codigoramo", jsonObject.getString("codigoramo"));
        data.put("proposta", jsonObject.getString("proposta"));
        data.put("apolicerenovar", jsonObject.getString("apolicerenovar"));
        data.put("endosso", jsonObject.getString("endosso"));
        data.put("dataemissao", jsonObject.getString("dataemissao"));
        data.put("vigenciaseguro", jsonObject.getString("vigenciaseguro"));

        JSONObject parteSeguradora = new JSONObject("seguradora");
        data.put("seguradora.cnpj", parteSeguradora.getString("seguradoracnpj"));
        data.put("seguradora.codigosusep", parteSeguradora.getString("seguradoracodigosusep"));
        data.put("seguradora.endereco", parteSeguradora.getString("seguradoraendereco"));
        data.put("seguradora.celular", parteSeguradora.getString("seguradoracelular"));

        JSONObject parteSegurado = new JSONObject("segurado");
        data.put("segurado.nome", parteSegurado.getString("nome"));
        data.put("segurado.cpfcnpj", parteSegurado.getString("cpfcnpj"));
        data.put("segurado.datanascimento", parteSegurado.getString("datanascimento"));
        data.put("segurado.sexo", parteSegurado.getString("sexo"));
        data.put("segurado.profativ", parteSegurado.getString("profativ"));
        data.put("segurado.salario", parteSegurado.getString("salario"));
        data.put("segurado.endereco", parteSegurado.getString("endereco"));
        data.put("segurado.numero", parteSegurado.getString("numero"));
        data.put("segurado.comp", parteSegurado.getString("comp"));
        data.put("segurado.bairro", parteSegurado.getString("bairro"));
        data.put("segurado.cep", parteSegurado.getString("cep"));
        data.put("segurado.cidade", parteSegurado.getString("cidade"));
        data.put("segurado.estado", parteSegurado.getString("estado"));
        data.put("segurado.telefone", parteSegurado.getString("telefone"));
        data.put("segurado.celular", parteSegurado.getString("celular"));
        data.put("segurado.email", parteSegurado.getString("email"));

        JSONObject partePagamento = new JSONObject("pagamento");
        data.put("pagamento.premio", partePagamento.getString("premio"));
        data.put("pagamento.custo", partePagamento.getString("custo"));
        data.put("pagamento.juros", partePagamento.getString("juros"));
        data.put("pagamento.iof", partePagamento.getString("iof"));
        data.put("pagamento.premiototal", partePagamento.getString("premiototal"));
        data.put("pagamento.formapagamento", partePagamento.getString("formapagamento"));
        data.put("pagamento.parcelas", partePagamento.getString("parcelas"));

        JSONObject parteCorretor = new JSONObject("corretor");
        data.put("corretor.nome", parteCorretor.getString("nome"));
        data.put("corretor.susep", parteCorretor.getString("susep"));
        data.put("corretor.telefone", parteCorretor.getString("telefone"));
        data.put("corretor.email", parteCorretor.getString("email"));

        data.put("coberturacontratadas", jsonObject.getString("coberturacontratadas"));
        data.put("premio", jsonObject.getString("premio"));
        data.put("capitalsegurado", jsonObject.getString("capitalsegurado"));

        data.put("cobertura", jsonObject.getString("cobertura"));
        data.put("franquia", jsonObject.getString("franquia"));
        data.put("tipofranquia", jsonObject.getString("tipofranquia"));

        data.put("assistenciacontratada", jsonObject.getString("assistenciacontratada"));
        data.put("telefoneacionamento", jsonObject.getString("telefoneacionamento"));
    }
}