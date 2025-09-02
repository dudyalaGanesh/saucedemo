package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.pages.LoginPage;
import com.automation.pages.ProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SauceDemoTest extends BaseTest {

    @DataProvider(name = "sortOptions")
    public Object[][] sortOptions() {
        return new Object[][] {
                { "lohi" },
                { "hilo" },
                { "az" }
        };
    }

    @Test(dataProvider = "sortOptions")
    public void testAddProductBasedOnSort(String sortValue) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);

        // Step 1: Login
        loginPage.login("standard_user", "secret_sauce");

        // Step 2: Sort products
        productsPage.sortProducts(sortValue);
        Thread.sleep(1000); // Wait for sorting

        // Step 3: Validate first product exists
        WebElement firstProduct = productsPage.getFirstProduct();
        String productName = firstProduct.findElement(By.className("inventory_item_name")).getText();
        Assert.assertNotNull(productName, "First product should not be null!");
    }
}
