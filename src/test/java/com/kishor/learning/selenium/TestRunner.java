package com.kishor.learning.selenium;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@SpringBootTest
@CucumberOptions(
features = "src/test/resources/bdd",
plugin = {"pretty", "html:target/cucumber"})
public class TestRunner {

}
