package planets.get;

import entities.Planet;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;

import static utils.PropertyLoader.loadProperty;
import static utils.RequestSpecificationProvider.getDefaultRequestSpecificationForGet;

public class GetSteps {

    private static String URI = loadProperty("get_planet_url");

    @Step(value = "Запрос на получение данных о планете")
    public Planet getPlanet(int planetId) {
        return getPlanetResponse(planetId)
                .then()
                .extract().as(Planet.class);
    }

    @Step(value = "Получение http статус кода после запроса планеты")
    public int getPlanetStatusCode(int planetId) {
        return getPlanetResponse(planetId)
                .then()
                .extract().statusCode();
    }

    @Step(value = "Проверка всех полей планеты кроме ссылок")
    public void checkAllFieldsPlanetWithoutLinks(Planet actualPlanet, Planet expectedPlanet) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualPlanet.getName(), expectedPlanet.getName(), String.format("Значение поля name [%s] не равно ожидаемому [%s]", actualPlanet.getName(), expectedPlanet.getName()));
        softAssert.assertEquals(actualPlanet.getRotation_period(), expectedPlanet.getRotation_period(), String.format("Значение поля rotation_period [%s] не равно ожидаемому [%s]", actualPlanet.getRotation_period(), expectedPlanet.getRotation_period()));
        softAssert.assertEquals(actualPlanet.getOrbital_period(), expectedPlanet.getOrbital_period(), String.format("Значение поля orbital_period [%s] не равно ожидаемому [%s]", actualPlanet.getOrbital_period(), expectedPlanet.getOrbital_period()));
        softAssert.assertEquals(actualPlanet.getDiameter(), expectedPlanet.getDiameter(), String.format("Значение поля diameter [%s] не равно ожидаемому [%s]", actualPlanet.getDiameter(), expectedPlanet.getDiameter()));
        softAssert.assertEquals(actualPlanet.getClimate(), expectedPlanet.getClimate(), String.format("Значение поля climate [%s] не равно ожидаемому [%s]", actualPlanet.getClimate(), expectedPlanet.getClimate()));
        softAssert.assertEquals(actualPlanet.getGravity(), expectedPlanet.getGravity(), String.format("Значение поля gravity [%s] не равно ожидаемому [%s]", actualPlanet.getGravity(), expectedPlanet.getGravity()));
        softAssert.assertEquals(actualPlanet.getTerrain(), expectedPlanet.getTerrain(), String.format("Значение поля terrain [%s] не равно ожидаемому [%s]", actualPlanet.getTerrain(), expectedPlanet.getTerrain()));
        softAssert.assertEquals(actualPlanet.getSurface_water(), expectedPlanet.getSurface_water(), String.format("Значение поля surface_water [%s] не равно ожидаемому [%s]", actualPlanet.getSurface_water(), expectedPlanet.getSurface_water()));
        softAssert.assertEquals(actualPlanet.getPopulation(), expectedPlanet.getPopulation(), String.format("Значение поля population [%s] не равно ожидаемому [%s]", actualPlanet.getPopulation(), expectedPlanet.getPopulation()));
        softAssert.assertEquals(actualPlanet.getCreated(), expectedPlanet.getCreated(), String.format("Значение поля created [%s] не равно ожидаемому [%s]", actualPlanet.getCreated(), expectedPlanet.getCreated()));
        softAssert.assertEquals(actualPlanet.getEdited(), expectedPlanet.getEdited(), String.format("Значение поля edited [%s] не равно ожидаемому [%s]", actualPlanet.getEdited(), expectedPlanet.getEdited()));
        softAssert.assertAll();
    }

    public Response getPlanetResponse(int planetId) {
        return getDefaultRequestSpecificationForGet()
                .get(URI + planetId +"/")
                .then()
                .extract().response();
    }
}
