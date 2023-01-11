package manager;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CarHelper extends HelperBase{

    public CarHelper(WebDriver wd) {
        super(wd);
    }

    public void openCarForm() {
        click(By.id("1"));
    }

    public void fillCarForm(Car car) {
        typeLocation(car.getAddress());
        type(By.id("make"), car.getMake());
        type(By.id("model"), car.getModel());
        type(By.id("year"), car.getYear());
        select(By.id("fuel"),car.getFuel());
        type(By.id("seats"), car.getSeats());
        type(By.id("class"), car.getCarClass());
        type(By.id("serialNumber"), car.getCarNumber());
        type(By.id("price"), car.getPrice());


    }

    private void select(By locator, String option) {
//        new Select(wd.findElement(locator)).selectByIndex(1);
//        new Select(wd.findElement(locator)).selectByVisibleText(" Diesel ");
        new Select(wd.findElement(locator)).selectByValue(option);
    }

    public void typeLocation(String address) {
        type(By.id("pickUpPlace"), address);
        click(By.cssSelector(".pac-item"));
        pause(500);

    }
}
