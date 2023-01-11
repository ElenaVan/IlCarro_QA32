package tests;

import models.User;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TastBase{
    @BeforeMethod
    public void preCondition(){
        //isLogin? -> logout()
        if(app.getHelperUser().isLogOutPresent()){
            app.getHelperUser().logout();
        }
    }
    @Test
    public void loginSuccess(){

        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("noa@gmail.com", "Nnoa12345$");
        app.getHelperUser().submit();
        app.getHelperUser().pause(1000);
        Assert.assertEquals(app.getHelperUser().checkMessage(), "Logged in success");



    }

    @Test
    public void loginSuccessNew(){

        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("noa@gmail.com", "Nnoa12345$");
        app.getHelperUser().submit();
        app.getHelperUser().pause(1000);
        Assert.assertEquals(app.getHelperUser().checkMessage(), "Logged in success");



    }

    @Test
    public void loginSuccessModel(){
        User user = new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$");


        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
        app.getHelperUser().pause(1000);
        Assert.assertEquals(app.getHelperUser().checkMessage(), "Logged in success");



    }
    @AfterMethod
    public void postCondition(){
        app.getHelperUser().submitOkButton();
    }
}
