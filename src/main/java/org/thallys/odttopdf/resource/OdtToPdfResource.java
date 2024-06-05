package org.thallys.odttopdf.resource;

import fr.opensagres.xdocreport.core.XDocReportException;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.thallys.odttopdf.service.OdtToPdfService;

import java.io.IOException;
import java.io.InputStream;

@Path("/convert")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_OCTET_STREAM)
public class OdtToPdfResource {

    @Inject
    OdtToPdfService odtToPdfService;

    @POST
    @Path("/odt-to-pdf")
    public Response convertOdtToPdf(@QueryParam("templateName") String templateName, String json) {
        try (InputStream pdfStream = odtToPdfService.convertJsonToPdf(json, templateName)) {
            byte[] pdfBytes = pdfStream.readAllBytes();
            return Response.ok(pdfBytes)
                    .header("Content-Disposition", "attachment; filename=\"output.pdf\"")
                    .build();
        } catch (IOException | XDocReportException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

}