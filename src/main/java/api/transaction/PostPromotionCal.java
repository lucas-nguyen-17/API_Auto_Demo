package api.transaction;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.request.transaction.TransactionObject;

import static utilities.LoadConfig.CONFIG;

public class PostPromotionCal {

    public Response callAPI(TransactionObject object) {
        return RestAssured.given().contentType(ContentType.JSON)
                .header("Authorization", "Bearer 75773721-5ef3-4d41-a611-2fbf87af6f52")
                .body(object)
                .post(CONFIG.getProperty("baseUrl") +"/api/v2/reward/hq-portal/promotions/cal");
    }
}
