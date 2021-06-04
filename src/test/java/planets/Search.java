package planets;


import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Planet;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import steps.planets.SearchSteps;
import utils.TestHelper;

import java.io.IOException;


public class Search {

    private SearchSteps searchSteps = new SearchSteps();

    @Description("Поиск планеты")
    @Test(description = "Поиск планеты")
    public void searchSimplePlanet() throws IOException {
        Planet actualPlanet = searchSteps.searchPlanet("Alderaan");
        ObjectMapper mapper = new ObjectMapper();
        Planet expectedPlanet = mapper.readValue(TestHelper.readJson("Alderaan.json"), Planet.class);
        searchSteps.checkAllFieldsPlanet(actualPlanet, expectedPlanet);
    }

}
