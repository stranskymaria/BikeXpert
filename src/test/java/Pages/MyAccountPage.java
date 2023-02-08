package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class MyAccountPage extends BasePage {

    private String myInfoLabelSelector = "#info > h2";
    private String nameLabelSelector = "#info > div > div.clearfix > div.left > div > div.right.info-section > div:nth-child(1) > strong";
    private String nameValueSelector = "#info > div > div.clearfix > div.left > div > div.right.info-section > div:nth-child(1) > span";
    private String emailLabelSelector = "#info > div > div.clearfix > div.left > div > div.right.info-section > div:nth-child(2) > strong";
    private String emailValueSelector = "#info > div > div.clearfix > div.left > div > div.right.info-section > div:nth-child(2) > span";
    private String phoneLabelSelector = "#info > div > div.clearfix > div.left > div > div.right.info-section > div:nth-child(3) > strong";
    private String phoneValueSelector = "#info > div > div.clearfix > div.left > div > div.right.info-section > div:nth-child(3) > span";
    private String changeButtonSelector = "#info > div > div.clearfix > div.right.edit-section > a";

//   left box menu
    private String accountAdministrationButtonSelector = "#left-column > div > div > div.container-section.active > h2 > a > span";
    private String personalDataButtonSelector = "#left-column > div > div > div.container-section.active > ul > li.selected.t-background-footer.t-footer-text-color > a > span";
    private String changePasswordButtonSelector = "#left-column > div > div > div.container-section.active > ul > li:nth-child(2) > a > span";
    private String ordersButtonSelector = "#left-column > div > div > div.container-section.active > ul > li:nth-child(3) > a > span";
    private String addressesButtonSelector = "#left-column > div > div > div.container-section.active > ul > li:nth-child(4) > a > span";
    private String companiesButtonSelector = "#left-column > div > div > div.container-section.active > ul > li:nth-child(5) > a > span";
    private String favoriteProductsButtonSelector = "#left-column > div > div > div.container-section.active > ul > li:nth-child(6) > a > span";
    private String returnButtonSelector = "#left-column > div > div > div.container-section.active > ul > li:nth-child(7) > a > span";
    private String complaintsButtonSelector = "#left-column > div > div > div.container-section.active > ul > li:nth-child(8) > a > span";
    private String userRightsButtonSelector = "#left-column > div > div > div.container-section.active > ul > li:nth-child(9) > a > span";
    private String logoutButtonSelector = "#left-column > div > div > div:nth-child(2) > ul > li > a > span";

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public void myAccount() {
        WebElement changeButton = driver.findElement(By.cssSelector(changeButtonSelector));

        Assert.assertEquals(driver.findElement(By.cssSelector(myInfoLabelSelector)).getText(), "Datele mele");
        Assert.assertEquals(driver.findElement(By.cssSelector(nameLabelSelector)).getText(), "Nume:");
        Assert.assertEquals(driver.findElement(By.cssSelector(emailLabelSelector)).getText(), "Adresa e-mail:");
        Assert.assertEquals(driver.findElement(By.cssSelector(phoneLabelSelector)).getText(), "Telefon:");
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

    public void leftBoxMenuButtonsText () {
        Assert.assertEquals(driver.findElement(By.cssSelector(accountAdministrationButtonSelector)).getText(), "Administrare cont");
        Assert.assertEquals(driver.findElement(By.cssSelector(personalDataButtonSelector)).getText(), "Date personale");
        Assert.assertEquals(driver.findElement(By.cssSelector(changePasswordButtonSelector)).getText(), "Schimba parola");
        Assert.assertEquals(driver.findElement(By.cssSelector(ordersButtonSelector)).getText(), "Comenzi");
        Assert.assertEquals(driver.findElement(By.cssSelector(addressesButtonSelector)).getText(), "Adrese");
        Assert.assertEquals(driver.findElement(By.cssSelector(companiesButtonSelector)).getText(), "Companii");
        Assert.assertEquals(driver.findElement(By.cssSelector(favoriteProductsButtonSelector)).getText(), "Produse favorite");
        Assert.assertEquals(driver.findElement(By.cssSelector(returnButtonSelector)).getText(), "Retur");
        Assert.assertEquals(driver.findElement(By.cssSelector(complaintsButtonSelector)).getText(), "Sesizari");
        Assert.assertEquals(driver.findElement(By.cssSelector(userRightsButtonSelector)).getText(), "Drepturile utilizatorilor");
        Assert.assertEquals(driver.findElement(By.cssSelector(logoutButtonSelector)).getText(), "Logout");
    }

    public void logout() {
        WebElement logoutButton = driver.findElement(By.cssSelector(logoutButtonSelector));
        logoutButton.click();
    }

}

