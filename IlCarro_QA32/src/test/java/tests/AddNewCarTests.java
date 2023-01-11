package tests;

import models.Car;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCarTests  extends TastBase{
    @BeforeMethod
    public void preCondition(){
        //if loginBTN -->login
    }

    @Test
    public void addNewCarSucces(){
        int index = (int)(System.currentTimeMillis()/1000)%36000;
        Car car = Car.builder()
                .address("Tel Aviv, Israel")
                .make("BMW")
                .model("M5")
                .year("2021")
                .fuel("Petrol")
                .seats("4")
                .carClass("Sedan")
                .carNumber("100-22-"+index)
                .price("65")
                .about("No smoking")

                .build();
        app.car().openCarForm();
        app.car().fillCarForm(car);
        //app.car().typeLocation("Tel Aviv");
//        app.car().attachPhoto("");
        app.car().submit();

    }

}
