package org.thallys.odttopdf;

import fr.opensagres.xdocreport.document.json.JSONObject;
import io.quarkus.test.junit.QuarkusIntegrationTest;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.thallys.odttopdf.utils.JsonFactory;
import org.thallys.odttopdf.utils.PopulateDTOs;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

@QuarkusTest
public class OdtToPdfITTest {

    @Inject
    JsonFactory jsonFactory;

    @Test
    public void convertJsonToPdfTemplate1TestSuccess() {
        // Exemplo de JSON para teste
        JSONObject jsonObject = jsonFactory.createTemplate1Json();

        // Nome do template que será usado no teste
        String templateName = "template_1";
        String arquivoOdt = String.format("%s.odt", templateName);

        given()
                .queryParam("templateName", arquivoOdt)
                .contentType("application/json")
                .body(jsonObject)
                .when()
                .post("/convert/odt-to-pdf")
                .then()
                .statusCode(200)
                .header("Content-Disposition", is("attachment; filename=\"template1.pdf\""))
                .body(is(notNullValue())); // Verifica se o corpo da resposta não é nulo
    }

    @Test
    public void convertJsonToPdfTestTemplate1Exception() {
        // Exemplo de JSON para teste
        JSONObject jsonObject = jsonFactory.createTemplate1Json();

        // Nome do template que será usado no teste
        String templateName = "template_1";
        String arquivoOdt = String.format("%s.odt", templateName);

        given()
                .queryParam("templateName", arquivoOdt)
                .contentType("application/json")
                .body(jsonObject)
                .when()
                .post("/convert/odt-to-pdf")
                .then()
                .statusCode(200)
                .header("Content-Disposition", is("attachment; filename=\"template1.pdf\""))
                .body(is(notNullValue()));
    }

    @Test
    public void convertJsonToPdfTemplate2TestSuccess() {
        // Exemplo de JSON para teste
        JSONObject jsonObject = jsonFactory.createTemplate2Json();

        // Nome do template que será usado no teste
        String templateName = "template_2";
        String arquivoOdt = String.format("%s.odt", templateName);

        given()
                .queryParam("templateName", arquivoOdt)
                .contentType("application/json")
                .body(jsonObject)
                .when()
                .post("/convert/odt-to-pdf")
                .then()
                .statusCode(200)
                .header("Content-Disposition", is("attachment; filename=\"template2.pdf\""))
                .body(is(notNullValue())); // Verifica se o corpo da resposta não é nulo
    }

    @Test
    public void convertJsonToPdfTemplate2TestException() {
        // Exemplo de JSON para teste
        JSONObject jsonObject = jsonFactory.createTemplate1Json();

        // Nome do template que será usado no teste
        String templateName = "template_2";
        String arquivoOdt = String.format("%s.odt", templateName);

        given()
                .queryParam("templateName", arquivoOdt)
                .contentType("application/json")
                .body(jsonObject)
                .when()
                .post("/convert/odt-to-pdf")
                .then()
                .statusCode(200)
                .header("Content-Disposition", is("attachment; filename=\"template2.pdf\""))
                .body(is(notNullValue())); // Verifica se o corpo da resposta não é nulo
    }

}