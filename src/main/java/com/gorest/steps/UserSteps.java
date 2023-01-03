package com.gorest.steps;

import com.gorest.constants.EndPoints;
import com.gorest.model.UserPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;

public class UserSteps {

    public ValidatableResponse createUser(String name, String email, String gender, String status) {
        UserPojo userPojo = new UserPojo();
        userPojo.setName(name);
        userPojo.setEmail(email);
        userPojo.setGender(gender);
        userPojo.setStatus(status);

        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 600f4364266ef9256401822c412cbfa2a4fe3c13c5c708bf2206cbb120f2a4c9")
                .when()
                .body(userPojo)
                .post().then();
    }

    @Step("Get product details of id : {0}")
    public HashMap<String, Object> getProductInfoById(int userId){
        HashMap<String, Object> productMap = SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .header("Authorization","Bearer 600f4364266ef9256401822c412cbfa2a4fe3c13c5c708bf2206cbb120f2a4c9")
                .when()
                .pathParams("id", userId)
                .get(EndPoints.GET_SINGLE_USER_BY_ID)
                .then()
                .statusCode(200)
                .extract()
                .path("");
        return productMap;

    }


    @Step("Update product details of id: {0}")
    public ValidatableResponse updateProduct(int productId, String name,String email,String gender,String status) {
        UserPojo userPojo = new UserPojo();
        userPojo.setName(name);
        userPojo.setEmail(email);
        userPojo.setGender(gender);
        userPojo.setStatus(status);
        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .header("Authorization","Bearer 600f4364266ef9256401822c412cbfa2a4fe3c13c5c708bf2206cbb120f2a4c9")
                .body(userPojo)
                .pathParam("id", productId)
                .when()
                .put(EndPoints.UPDATE_USER_BY_ID)
                .then();
    }
    @Step("Deleting student information with studentId: {0}")

    public ValidatableResponse deleteProduct(int userId){
        return  SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .header("Authorization","Bearer 600f4364266ef9256401822c412cbfa2a4fe3c13c5c708bf2206cbb120f2a4c9")
                .pathParam("id",userId)
                .when()
                .delete(EndPoints.DELETE_USER_BY_ID)
                .then();
    }
    @Step("Getting student information with studentId: {0}")

    public ValidatableResponse getProductId(int userId){
        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .header("Authorization","Bearer 600f4364266ef9256401822c412cbfa2a4fe3c13c5c708bf2206cbb120f2a4c9")
                .pathParam("id",userId)
                .when()
                .get(EndPoints.GET_SINGLE_USER_BY_ID)
                .then();

    }

}
























