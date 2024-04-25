package ge.tbc.tbcitacademy.POM.DataProviders;

import ge.tbc.tbcitacademy.POM.Util.Util;
import org.testng.annotations.DataProvider;

public class SwoopDataProvider {

    @DataProvider
    public Object[][] priceProvider(){
        return new Object[][]{
                {Util.generateMinimum(), Util.generateMaximum()},
                {Util.generateMinimum(), Util.generateMaximum()},
                {Util.generateMinimum(), Util.generateMaximum()},
                {Util.generateMinimum(), Util.generateMaximum()},
                {Util.generateMinimum(), Util.generateMaximum()},
        };
    }
}
