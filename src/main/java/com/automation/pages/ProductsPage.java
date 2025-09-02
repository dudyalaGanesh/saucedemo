package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductsPage {
    private WebDriver driver;

    private By sortDropdown = By.className("product_sort_container");
    private By products = By.className("inventory_item");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void sortProducts(String sortValue) {
        new Select(driver.findElement(sortDropdown)).selectByValue(sortValue);
    }

    public WebElement getFirstProduct() {
        return driver.findElements(products).get(0);
    }

    public List<WebElement> getAllProducts() {
        return driver.findElements(products);
    }
}
