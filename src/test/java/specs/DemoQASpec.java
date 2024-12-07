package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.AllureRestAssuredFilter.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static io.restassured.http.ContentType.JSON;

public class DemoQASpec {
    public static ResponseSpecification responseSpec201 = new ResponseSpecBuilder()
            .expectStatusCode(201)
            .log(STATUS)
            .log(BODY)
            .build();

    public static ResponseSpecification responseSpec204 = new ResponseSpecBuilder()
            .expectStatusCode(204)
            .log(STATUS)
            .log(BODY)
            .build();

    public static ResponseSpecification responseSpec200 = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(STATUS)
            .log(BODY)
            .build();

    public static RequestSpecification requestSpec = with()
            .filter(withCustomTemplates())
            .contentType(JSON)
            .log().all();

    public static RequestSpecification loginUserRequestSpec = with()
            .filter(withCustomTemplates())
            .contentType(JSON)
            .log().uri()
            .log().method()
            .log().body();
}
