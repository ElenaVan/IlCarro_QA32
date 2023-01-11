package manager;

import models.User;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }


    public void openLoginForm() {
//        new WebDriverWait(wd, 5)
//                .until(ExpectedConditions
                        //.visibilityOf(wd.findElement(By.xpath("//a[@class='navigation-link'][normalize-space()='Log in']"))));
        click(By.xpath("//a[@class='navigation-link'][normalize-space()='Log in']"));

    }

    public void fillLoginForm(String email, String password) {
        type(By.id("email"), email);
        type(By.id("password"), password);
    }
    public void fillLoginForm(User user) {
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
    }



    public String checkMessage() {
        new WebDriverWait(wd,5)
                .until(ExpectedConditions.visibilityOf(wd.findElement((By.cssSelector(".dialog-container")))));

        String message = wd.findElement(By.cssSelector(".dialog-container h2")).getText();
        System.out.println(message);

        return message;
    }

    public void submitOkButton() {
        if(isElementPresent(By.xpath("//button[@type='button']"))){

            click(By.xpath("//button[@type='button']"));}
    }

    public boolean isLogOutPresent() {
        return isElementPresent(By.xpath("//a[text()=' Logout ']"));
    }

    public void logout() {
        click(By.xpath("//a[text()=' Logout ']"));
    }

    public void openRegistrationForm() {
        click(By.xpath("//a[text()=' Sign up ']"));
    }

    public void fillRegistrationForm(String name, String lastName, String email, String password) {
        type(By.id("name"), name);
        type(By.id("lastName"), lastName);
        type(By.id("email"), email);
        type(By.id("password"), password);

    }
    public void fillRegistrationForm(User user) {
        type(By.id("name"), user.getName());
        type(By.id("lastName"), user.getLastName());
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());

    }
// First variant click to check-box
    public void checkPolicy() {
        click(By.cssSelector("label[for='terms-of-use']"));
    }
// Second variant click to check-box
    public void checkPolicyJS(){
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('#terms-of-use').click();");
        js.executeScript("document.querySelector('#terms-of-use').checked=true;");
    }
 //Third variant click to check-box
    public void checkPolicyXY() {
        WebElement label = wd.findElement(By.cssSelector("label[for='terms-of-use']"));
        Rectangle rect = label.getRect();
        int offSetX = rect.getWidth()/2;
        int offSetY = rect.getHeight()/2;

        Actions actions= new Actions(wd);
        actions.moveToElement(label).release().perform();
        actions.moveByOffset(-offSetX,-offSetY).click().perform();




    }

    public boolean isErrorPasswordDisplayedSize() {
//Password must contain minimum 8 symbols   div[class*='error'] :first-child
        //Password must contain 1 uppercase letter, 1 lowercase letter, 1 number and one special symbol of [@$#^&*!]
        // div[class*='error'] :nth-child(2)

        Boolean firstChild = new WebDriverWait(wd, 5)
                .until(ExpectedConditions
                        .textToBePresentInElement(wd.findElement(By.cssSelector("div[class*='error'] :first-child")),
                                "Password must contain minimum 8 symbols"));
        return firstChild;
    }
    public boolean isErrorPasswordFormat(){
        Boolean lastChild= new WebDriverWait(wd, 5)
                .until(ExpectedConditions
                        .textToBePresentInElement(wd.findElement(By.cssSelector("div[class*='error'] :nth-child(2)")),
                        "Password must contain 1 uppercase letter, 1 lowercase letter, 1 number and one special symbol of [@$#^&*!]"));
        return lastChild;
    }

    public boolean isYallaButtonNotActive() {
        return wd.findElement(By.cssSelector("[type='submit']")).isEnabled();
    }

    public boolean isYallaButtonNotClickable() {
        return wd.findElement(By.cssSelector("button[disabled]")).isDisplayed();
    }

    public boolean isYallaButtonDisabled() {
        return isElementPresent(By.cssSelector("button[disabled]"));
    }
}
