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

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class OdtToPdfService {
    public InputStream convertJsonToPdf(String json, String templateName) throws IOException, XDocReportException {
        JSONObject jsonObject = new JSONObject(json);
        Map<String, Object> data = new HashMap<>();
        data.put("name", jsonObject.getString("name"));
        data.put("age", jsonObject.getInt("age"));
        data.put("location", jsonObject.getString("location"));

        // Carrega o template ODT
        InputStream templateStream = getClass().getResourceAsStream("/" + templateName + ".odt");
        if (templateStream == null) {
            throw new FileNotFoundException("Template ODT não encontrado em: /" + templateName + ".odt");
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
}