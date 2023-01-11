package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TastBase{

    @BeforeMethod
    public void preCondition(){
        if(app.getHelperUser().isLogOutPresent()){
            app.getHelperUser().logout();
        }
    }
    @Test
    public void registrationSuccess(){
        int index = (int)(System.currentTimeMillis()/1000)%36000;
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm("lia", "Snow", "lia"+index+"@gmail.com","Llia12345$");
        //app.getHelperUser().checkPolicy();

        app.getHelperUser().checkPolicyXY();

        app.getHelperUser().submit();
        app.getHelperUser().pause(1000);

        Assert.assertEquals(app.getHelperUser().checkMessage(),"You are logged in success");
    }

    @Test
    public void registrationSuccessModel(){
        int index = (int)(System.currentTimeMillis()/1000)%3600;
        User user = new User().withName("Lia").withLastName("Snow").withEmail("lia"+index+"@gmail.com").withPassword("Llia12345$");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        //app.getHelperUser().checkPolicy();

        app.getHelperUser().checkPolicyXY();

        app.getHelperUser().submit();
        //app.getHelperUser().pause(1000);

        Assert.assertEquals(app.getHelperUser().checkMessage(),"You are logged in success");
    }

    @Test
    public void registrationWrongPasswordModel(){
        //int index = (int)(System.currentTimeMillis()/1000)%3600;
        User user = new User()
                .withName("Lia")
                .withLastName("Snow")
                .withEmail("laliun@gmail.com")
                .withPassword("12345");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();
        app.getHelperUser().submit();
        // error + button not active
        Assert.assertTrue(app.getHelperUser().isErrorPasswordDisplayedSize());
        Assert.assertTrue(app.getHelperUser().isErrorPasswordFormat());
        Assert.assertFalse(app.getHelperUser().isYallaButtonNotActive());
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotClickable());
        Assert.assertTrue(app.getHelperUser().isYallaButtonDisabled());





        //Assert.assertEquals(app.getHelperUser().checkMessage(),"You are logged in success");
    }
    @AfterMethod
    public void postCondition(){
        app.getHelperUser().submitOkButton();
    }
}
