package planets.get;

import com.fasterxml.jackson.databind.ObjectMapper;
import common.BaseSteps;
import entities.Planet;
import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import utils.TestHelper;

import java.io.IOException;


public class Get {

    private GetSteps getSteps = new GetSteps();
    private BaseSteps baseSteps = new BaseSteps();

    @Description("Получение планеты и проверка всех полей")
    @Test(groups = {"smoke"}, description = "Получение планеты и проверка всех полей")
    public void getSimplePlanet() throws IOException {
        Planet actualPlanet = getSteps.getPlanet(3);
        ObjectMapper mapper = new ObjectMapper();
        Planet expectedPlanet = mapper.readValue(TestHelper.readJson("Yavin_4.json"), Planet.class);
        getSteps.checkAllFieldsPlanetWithoutLinks(actualPlanet, expectedPlanet);
    }

    @Description("Получение несуществующей планеты")
    @Test(groups = {"smoke"}, description = "Получение несуществующей планеты")
    public void getNonexistentPlanet(){
        int actualStatusCode = getSteps.getPlanetStatusCode(0);
        int expectedStatusCode = HttpStatus.SC_NOT_FOUND;
        baseSteps.checkStatusCode(actualStatusCode, expectedStatusCode);
    }
}
