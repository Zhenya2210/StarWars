package common;

import io.qameta.allure.Step;

import static org.testng.Assert.assertEquals;

public class BaseSteps {

    @Step(value = "Проверка http статус кодов")
    public void checkStatusCode(int actualHttpStatus, int expectedHttpStatus) {
        assertEquals(actualHttpStatus, expectedHttpStatus, String.format("Значение http статус кода [%s] не равно ожидаемому [%s]", actualHttpStatus, expectedHttpStatus));
    }
}
