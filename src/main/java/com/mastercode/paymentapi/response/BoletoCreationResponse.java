package com.mastercode.paymentapi.response;

import lombok.Getter;

@Getter
public class BoletoCreationResponse {

	private String boletoNumber;

	public BoletoCreationResponse(String boletoNumber) {
		this.boletoNumber = boletoNumber;
	}

}
