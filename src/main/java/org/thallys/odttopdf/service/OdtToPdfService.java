package org.thallys.odttopdf.service;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import jakarta.inject.Inject;
import org.jboss.logging.Logger;
import org.thallys.odttopdf.dto.*;
import org.thallys.odttopdf.utils.PopulateDTOs;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class OdtToPdfService {
    private static final Logger LOG = Logger.getLogger(OdtToPdfService.class);

    @Inject
    PopulateDTOs populateDTOs;

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

        if (templateName.equals("template_1")) {
            LOG.info("Adicionando informacoes do template_1 JSON");
            data.put("veiculo", populateDTOs.populateVeiculoDTO(jsonObject));

        } else if (templateName.equals("template_2")) {
            LOG.info("Adicionando informacoes do template_2 JSON");
            data.put("seguroVida", populateDTOs.populateSeguroVidaDTO(jsonObject));
        }

        // Carrega o documento
        IXDocReport report = XDocReportRegistry.getRegistry().loadReport(templateStream, TemplateEngineKind.Freemarker);

        // Criar metadados de campos para definir campos como texto simples
//        FieldsMetadata metadata = new FieldsMetadata();
//        metadata.addFieldAsTextStyling("name", DocumentKind.ODT.name());
//        metadata.addFieldAsTextStyling("age", DocumentKind.ODT.name());
//        metadata.addFieldAsTextStyling("location", DocumentKind.ODT.name());
//        report.setFieldsMetadata(metadata);

        // Criar contexto e mesclar com o modelo
        IContext context = report.createContext();
        context.putMap(data);

        // Cria o contexto e preenche com os dados do JSON
        ByteArrayOutputStream pdfOutputStream = new ByteArrayOutputStream();
        Options options = Options.getFrom("ODT").to(ConverterTypeTo.PDF);

        report.convert(context, options, pdfOutputStream);

        // Retorna o PDF como InputStream
        LOG.info("Fase final, convertendo JSON para PDF, aguarde...");
        return new ByteArrayInputStream(pdfOutputStream.toByteArray());
    }

    private void populateCommonData(Map<String, Object> data, JSONObject jsonObject) {
        data.put("policyNumber", jsonObject.getString("policyNumber"));
        data.put("produto", jsonObject.getString("produto"));
        data.put("processoSusep", jsonObject.getString("processoSusep"));
        data.put("codigoRamo", jsonObject.getString("codigoRamo"));
        data.put("proposta", jsonObject.getString("proposta"));
        data.put("apoliceRenovar", jsonObject.getString("apoliceRenovar"));
        data.put("endosso", jsonObject.getString("endosso"));
        data.put("dataEmissao", jsonObject.getString("dataEmissao"));
        data.put("vigenciaSeguro", jsonObject.getString("vigenciaSeguro"));

        data.put("seguradora", populateDTOs.populateSeguradoraDTO(jsonObject));
        data.put("segurado", populateDTOs.populateSeguradoDTO(jsonObject));
        data.put("pagamento", populateDTOs.populatePagamentoDTO(jsonObject));
        data.put("corretor", populateDTOs.populateCorretorDTO(jsonObject));

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