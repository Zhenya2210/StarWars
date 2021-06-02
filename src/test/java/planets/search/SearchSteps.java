package planets.search;

import entities.Planet;
import entities.SearchResult;
import io.qameta.allure.Step;
import org.testng.asserts.SoftAssert;

import static utils.PropertyLoader.loadProperty;
import static utils.RequestSpecificationProvider.getDefaultRequestSpecificationForGet;

public class SearchSteps {

    private static String URI = loadProperty("search_planet_url");

    @Step(value = "Поиск планеты")
    public Planet searchPlanet(String planet) {
        return getDefaultRequestSpecificationForGet()
                .pathParam("planet", planet)
                .get(URI)
                .then()
                .extract().as(SearchResult.class).getResults().get(0);
    }

    @Step(value = "Проверка всех полей планеты")
    public void checkAllFieldsPlanet(Planet actualPlanet, Planet expectedPlanet) {
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
        softAssert.assertEquals(actualPlanet.getUrl(), expectedPlanet.getUrl(), String.format("Значение поля url [%s] не равно ожидаемому [%s]", actualPlanet.getUrl(), expectedPlanet.getUrl()));
        softAssert.assertEquals(actualPlanet.getResidents(), expectedPlanet.getResidents(), String.format("Массив объектов residents [%s] не равен ожидаемому [%s]", actualPlanet.getResidents(), expectedPlanet.getResidents()));
        softAssert.assertEquals(actualPlanet.getFilms(), expectedPlanet.getFilms(), String.format("Массив объектов films [%s] не равен ожидаемому [%s]", actualPlanet.getFilms(), expectedPlanet.getFilms()));
        softAssert.assertAll();
    }
}
