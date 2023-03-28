package com.example.demo;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.example.soapclient.tempconvert.TempConvert;
import com.example.soapclient.tempconvert.TempConvertSoap;

@Component
public class JmsListener {

	@Autowired
	private JmsTemplate jmsTemplate;

	@org.springframework.jms.annotation.JmsListener(destination = "inputQueue")
	public void receiveMessage(TextMessage textMessage) throws JMSException {
		String payload = textMessage.getText();
		double result = convertTemperature(payload); // call the SOAP web service
		jmsTemplate.convertAndSend("outputQueue", Double.toString(result)); // send the response to the output queue
	}

	private double convertTemperature(String payload) {
		TempConvert tempConvert = new TempConvert();
		TempConvertSoap client = tempConvert.getTempConvertSoap12();
		String celsiusString = String.valueOf(payload);
		String resultString = client.celsiusToFahrenheit(celsiusString);
		double result = Double.parseDouble(resultString);
		return result;
	}
}
