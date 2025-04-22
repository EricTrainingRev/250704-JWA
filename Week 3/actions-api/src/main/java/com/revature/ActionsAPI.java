package com.revature;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsAPI {

    public static void main(String[] args) {
        /*
            Anytime you need to automate keystrokes, mouse
            actions, scroll wheel actions, or pen input, the
            Actions API can be used to accomplish this. Unlike
            the base WebDriver, which uses HTTP to interact
            with the browser, the Actions API utilizes your
            hardware to perform actions. This is particularly
            useful when you need to validate your service
            manages hardware interactions, or for interacting
            with elements that require manual interaction, such
            as input elements that use a slider
         */
        WebDriver driver = null;
        try{
            driver = new ChromeDriver();
            driver.get("C:\\Users\\EricSuminski\\Desktop\\250704-JWA\\Week 3\\actions-api\\src\\main\\resources\\actions-api-example.html");
            WebElement slider = driver.findElement(By.id("slider"));
        /*
            the base webdriver does not provide the tools we need to manage the slider, so we can use the Actions API
            The Actions class takes in a driver and then follows the Builder design pattern to chain a sequence
            of actions together you want to perform
         */
            new Actions(driver)
                    // moveToElement moves the mouse to the center of the target element
                    .moveToElement(slider)
                    // to actually perform the click and drag we need to make sure we tell Selenium to click on the element and hold
                    .clickAndHold()
                    // if you need to move a specific distance along an x/y grid you use moveByOffset
                    // the top left corner of the rendered content is position 0,0 which everything else
                    // is based off. To move to the right you increase the value of x, to move down you
                    // increase the value of y. Movement is pixel based, so if you provide 10 as the value
                    // for x then the mouse will move 10 pixels to the right
                    .moveByOffset(15,0)
                    // make sure to release the mouse button when done, otherwise all other actions will
                    // be run with the left mouse button clicked and held, which can cause unexpected issues
                    .release()
                    // once your action chain is complete you can either "build" and use it later or
                    // "perform" the actions right away
                    .perform();
            System.out.println(driver.findElement(By.id("sliderValue")).getText());
        } finally {
            if(driver != null) driver.quit();
        }


    }

}
