package org.example.steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/org/example/features"},
        glue = {"org/example/steps"}, plugin = {"pretty"})

public class RunTest {
}