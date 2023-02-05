package Pages;

import Utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class RegistrationConfirmationPage extends BasePage {

    private String confirmationMessageSelector = "#info > div.alert.alert-danger"; //CSS
    private String myInfoLabelSelector = "#info > h2";
    private String nameLabelSelector = "#info > div.box-nice > div.clearfix > div.left > div > div.right.info-section > div:nth-child(1) > strong";
    private String nameValueSelector = "#info > div.box-nice > div.clearfix > div.left > div > div.right.info-section > div:nth-child(1) > span";
    private String emailLabelSelector = "#info > div.box-nice > div.clearfix > div.left > div > div.right.info-section > div:nth-child(2) > strong";
    private String emailValueSelector = "#info > div.box-nice > div.clearfix > div.left > div > div.right.info-section > div:nth-child(2) > span";
    private String phoneLabelSelector = "#info > div.box-nice > div.clearfix > div.left > div > div.right.info-section > div:nth-child(3) > strong";
    private String phoneValueSelector = "#info > div.box-nice > div.clearfix > div.left > div > div.right.info-section > div:nth-child(3) > span";
    private String changeButtonSelector = "#info > div.box-nice > div.clearfix > div.right.edit-section > a";

    public RegistrationConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public void registrationConfirmation() {

        WebElement confirmationMessage = SeleniumUtils.waitForGenericElement(driver, By.cssSelector(confirmationMessageSelector), 20);
        Assert.assertEquals(confirmationMessage.getText(), "ITI MULTUMIM, CONTUL TAU A FOST CREAT ! Vei primi confirmarea pe email.\n" +
                "Doresti sa plasezi o comanda ? Completeaza detaliile de livrare rapid, in doar cateva secunde.");
        Assert.assertEquals(driver.findElement(By.cssSelector(myInfoLabelSelector)).getText(), "Datele mele");
        Assert.assertEquals(driver.findElement(By.cssSelector(nameLabelSelector)).getText(), "Nume:");
        Assert.assertEquals(driver.findElement(By.cssSelector(emailLabelSelector)).getText(), "Adresa e-mail:");
        Assert.assertEquals(driver.findElement(By.cssSelector(phoneLabelSelector)).getText(), "Telefon:");
        WebElement changeButton = driver.findElement(By.cssSelector(changeButtonSelector));
        Assert.assertTrue(changeButton.isDisplayed());
        Assert.assertEquals(changeButton.getText(), "Modifica");
    }

    public String getNameValue() {
        return driver.findElement(By.cssSelector(nameValueSelector)).getText();
    }

    public String getEmailValue() {
        return driver.findElement(By.cssSelector(emailValueSelector)).getText();
    }

    public String getPhoneValue() {
        return driver.findElement(By.cssSelector(phoneValueSelector)).getText();
    }
}
