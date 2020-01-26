package com.bharath.ws.soap.dto;

import javax.xml.bind.annotation.XmlType;

@XmlType(name="RegisterProcessorResponse")
public class RegisterProcessorResponse {
	private boolean result;
	private String resName;

	public String isResult() {
		return "Hello! Your name is "+resName+".";
	}

	public void setResult(boolean result, String name) {
		this.result = result;
		this.resName = name;
	}
}
