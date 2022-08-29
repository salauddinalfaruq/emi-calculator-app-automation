package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class EMICalcScreen {

    @FindBy(id = "com.continuum.emi.calculator:id/btnStart")
    public AndroidElement btnEMICalc;
    @FindBy(id = "com.continuum.emi.calculator:id/etLoanAmount")
    AndroidElement txtAmount;
    @FindBy(id = "com.continuum.emi.calculator:id/etInterest")
    AndroidElement txtInterest;
    @FindBy(id = "com.continuum.emi.calculator:id/etYears")
    AndroidElement txtYears;
    @FindBy(id = "com.continuum.emi.calculator:id/etMonths")
    AndroidElement txtMonth;
    @FindBy(id = "com.continuum.emi.calculator:id/etEMI")
    AndroidElement txtEMIRes;
    @FindBy(id = "com.continuum.emi.calculator:id/etFee")
    AndroidElement txtProcessingFee;
    @FindBy(id = "com.continuum.emi.calculator:id/btnCalculate")
    AndroidElement btnCalculation;
    @FindBy(id = "com.continuum.emi.calculator:id/btnReset")
    public AndroidElement btnReset;
    @FindBy(id = "com.continuum.emi.calculator:id/monthly_emi_result")
    AndroidElement lblMonthlyEMI;
    @FindBy(id = "com.continuum.emi.calculator:id/total_interest_result")
    AndroidElement lblInterest;
    @FindBy(id = "com.continuum.emi.calculator:id/processing_fee_result")
    AndroidElement lblProcessingFee;
    @FindBy(id = "com.continuum.emi.calculator:id/total_payment_result")
    AndroidElement lblTotalPayment;

    private double mEMI;
    private double tInterest;
    private double pFee;
    private double tPayment;

    public double getmEMI() {
        return mEMI;
    }

    public void setmEMI(double mEMI) {

        this.mEMI = mEMI;
    }

    public double gettInterest() {
        return tInterest;
    }

    public void settInterest(double tInterest) {
        this.tInterest = tInterest;
    }

    public double getpFee() {
        return pFee;
    }

    public void setpFee(double pFee) {
        this.pFee = pFee;
    }

    public double gettPayment() {
        return tPayment;
    }

    public void settPayment(double tPayment) {
        this.tPayment = tPayment;
    }

    public EMICalcScreen(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(2)), this);
    }

    public void doCalculation(double amount, double interest, int years, double processingFee) {

        txtAmount.sendKeys("" + amount + "");
        txtInterest.sendKeys("" + interest + "");
        txtYears.sendKeys("" + years + "");
        txtProcessingFee.sendKeys("" + processingFee + "");
        btnCalculation.click();

        setmEMI(Double.parseDouble(lblMonthlyEMI.getText().replace(",", "")));
        settInterest(Double.parseDouble(lblInterest.getText().replace(",", "")));
        setpFee(Double.parseDouble(lblProcessingFee.getText().replace(",", "")));
        settPayment(Double.parseDouble(lblTotalPayment.getText().replace(",", "")));
    }
}
