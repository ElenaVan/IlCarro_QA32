package manager;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CarHelper extends HelperBase{

    public CarHelper(WebDriver wd) {
        super(wd);
    }

    public void openCarForm() {
        pause(1000);
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
        type(By.id("about"), car.getAbout());


    }

    private void select(By locator, String option) {
//        new Select(wd.findElement(locator)).selectByIndex(1);
//        new Select(wd.findElement(locator)).selectByVisibleText(" Diesel ");
        new Select(wd.findElement(locator)).selectByValue(option);
    }

    public void typeLocation(String address) {
        type(By.id("pickUpPlace"), address);
        click(By.cssSelector(".pac-item"));


    }

    public void attachPhoto(String link) {
    wd.findElement(By.id("photos")).sendKeys(link);
    pause(3000);

    }

    public boolean isCarAdded() {
        new WebDriverWait(wd,10)
                .until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector("div.dialog-container"))));
        String message = wd.findElement(By.cssSelector("div.dialog-container h1")).getText();
        click(By.xpath("//button[text()='Search cars']"));
        return message.equals("Car added");
    }
}
