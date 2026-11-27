package api;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.User;


import static io.restassured.RestAssured.given;
import static utils.Constants.*;

public class UserSteps {

    @Step("Создать пользователя через API")
    public Response create(User user) {
        return given().baseUri(BASE_URI).contentType(ContentType.JSON).body(user)
                .post(REGISTER_API);
    }

    @Step("Авторизоваться через API")
    public Response login(User user) {
        return given().baseUri(BASE_URL).contentType(ContentType.JSON)
                .body("{\"email\":\"" + user.getEmail() + "\",\"password\":\"" + user.getPassword() + "\"}")
                .post(LOGIN_API);
    }

    @Step("Удалить пользователя через API")
    public Response delete(String accessToken) {
        return given().baseUri(BASE_URL).header("Authorization", accessToken)
                .delete(USER_API);
    }

    @Step("Удалить пользователя, если он существует")
    public void deleteIfExists(User user) {
        Response response = login(user);
        if (response.statusCode() == 200) {
            delete(response.path("accessToken"));
        }
    }
}
