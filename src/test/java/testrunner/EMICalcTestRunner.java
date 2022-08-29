package testrunner;

import base.Setup;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import screens.EMICalcScreen;
import utilities.DataSet;

public class EMICalcTestRunner extends Setup {

    @BeforeTest
    public void startEMICalculation(){
        EMICalcScreen emiCalcScreen = new EMICalcScreen(driver);
        emiCalcScreen.btnEMICalc.click();
    }

    @Test(dataProvider = "data-provider", dataProviderClass = DataSet.class, priority = 2)
    public void doEMICalculation(double amount, double interest, int year, double processingFee, double mEMI, double tInterest, double pFee, double tPayment){

        EMICalcScreen emiCalcScreen = new EMICalcScreen(driver);
        emiCalcScreen.doCalculation(amount, interest, year, processingFee);
        double monthlyEMI = emiCalcScreen.getmEMI();
        double totalInterest = emiCalcScreen.gettInterest();
        double totalProcessingFee = emiCalcScreen.getpFee();
        double totalPayment = emiCalcScreen.gettPayment();

        System.out.println(monthlyEMI);
        System.out.println(totalInterest);
        System.out.println(totalProcessingFee);
        System.out.println(totalPayment);

        Assert.assertEquals(monthlyEMI, mEMI);
        Assert.assertEquals(totalInterest, tInterest);
        Assert.assertEquals(totalProcessingFee, pFee);
        Assert.assertEquals(totalPayment, tPayment);

        emiCalcScreen.btnReset.click();
    }
}
