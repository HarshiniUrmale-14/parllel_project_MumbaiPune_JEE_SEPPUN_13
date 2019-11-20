package com.capgemini.medicalstore.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features="Feature",glue= {"com.capgemini.medicalstore"},tags= {"@RegistrationOperation"})
public class Runner {

}
