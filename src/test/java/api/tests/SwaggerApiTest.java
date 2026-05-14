package api.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class SwaggerApiTest {

    @BeforeAll
    public static void setup() {
        // Test edeceğimiz YENİ ana URL: Swagger Petstore API
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    @Test
    public void testGetAvailableRecords() {
        // GET İsteği: "available" (müsait) statüsündeki kayıtları getir
        given()
            .queryParam("status", "available") // URL'nin sonuna ?status=available ekler
        .when()
            .get("/pet/findByStatus")
        .then()
            .statusCode(200) // 1. İster: Status code kontrolü
            .time(lessThan(3000L)) // 3. İster: x süre altında cevap dönme kontrolü
            .body("[0].status", equalTo("available")); // Dönen listedeki ilk kaydın statüsünü doğrula
    }

    @Test
    public void testPostCreateCustomRecord() {
        // POST İsteği: Sisteme sana özgü, yepyeni bir "Sumo Robot" kaydı ekleyelim
        String requestBody = "{\n" +
                "  \"id\": 887,\n" +
                "  \"category\": {\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"Elektronik\"\n" +
                "  },\n" +
                "  \"name\": \"Sumo Robot\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"yarisma\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";

        // POST İsteği: Yeni kaydı oluştur ve sonucu doğrula
        given()
            .contentType(ContentType.JSON)
            .body(requestBody)
        .when()
            .post("/pet")
        .then()
            .log().all() // Sunucunun verdiği tüm cevabı konsola yazdırır
            .statusCode(200) // Swagger API başarılı kayıt işlemine 200 döndürür
            .body("name", equalTo("Sumo Robot")) // İsmin doğru kaydedildiğini onayla
            .body("id", equalTo(887)) // ID'nin doğru atandığını onayla
            .body("category.name", equalTo("Elektronik")); // Alt kategorinin doğruluğunu onayla
    }
}