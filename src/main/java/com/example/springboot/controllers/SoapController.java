package com.example.springboot.controllers;

import java.math.BigInteger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.soapclient.numberconversion.NumberConversion;
import com.example.soapclient.numberconversion.NumberConversionSoapType;
import com.example.soapclient.tempconvert.TempConvert;
import com.example.soapclient.tempconvert.TempConvertSoap;

@RestController
public class SoapController {

	@GetMapping("/temperature")
	public double convertTemperature(@RequestParam("celsius") double celsius) {
	    TempConvert tempConvert = new TempConvert();
	    TempConvertSoap client = tempConvert.getTempConvertSoap12();
	    String celsiusString = String.valueOf(celsius);
	    String resultString = client.celsiusToFahrenheit(celsiusString);
	    double result = Double.parseDouble(resultString);
	    return result;
	}

	@GetMapping("/number")
	public String convertNumberToWords(@RequestParam("number") int number) {
	    NumberConversion numberConversion = new NumberConversion();
	    NumberConversionSoapType client = numberConversion.getNumberConversionSoap12();
	    BigInteger bigInteger = BigInteger.valueOf(number);
	    return client.numberToWords(bigInteger);
	}

}
