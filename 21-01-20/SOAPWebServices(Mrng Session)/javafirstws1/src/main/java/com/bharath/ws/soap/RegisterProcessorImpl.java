package com.bharath.ws.soap;

import java.util.*;
import com.bharath.ws.soap.dto.RegisterProcessorRequest;
import com.bharath.ws.soap.dto.RegisterProcessorResponse;

public class RegisterProcessorImpl implements RegisterProcessor {
	
	public RegisterProcessorResponse processRegister(RegisterProcessorRequest registerProcessorRequest) {
		RegisterProcessorResponse registerProcessorResponse = new RegisterProcessorResponse();
		// Business Logic or a call to a Business Logic Class Goes Here.
		if(registerProcessorRequest.getName().length()<3) {
			throw new RuntimeException("Please enter a valid length Name.");
		}
		registerProcessorResponse.setResult(true, registerProcessorRequest.getName());
		return registerProcessorResponse;
	}

	@Override
	public RegisterProcessorResponse processPayment(RegisterProcessorRequest registerProcessorRequest) {
		return null;
	}
}
