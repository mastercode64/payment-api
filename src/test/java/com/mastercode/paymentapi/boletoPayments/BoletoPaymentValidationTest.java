package com.mastercode.paymentapi.boletoPayments;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BoletoPaymentValidationTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void validBoletoShouldBeCreatedAndReturnNumber() throws Exception {
		JSONObject json = new JSONObject();
		json.put("value", 50);
		json.put("clientID", "123");
		json.put("buyer", new JSONObject()
				.put("name", "João")
				.put("email", "joao@email.com")
				.put("cpf", "41863021892"));

		mockMvc.perform(MockMvcRequestBuilders
				.post("/payments/boleto")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json.toString()))
		.andExpect(MockMvcResultMatchers.status().isCreated())
		.andExpect(MockMvcResultMatchers.jsonPath("$.boletoNumber").exists())
		.andExpect(MockMvcResultMatchers.jsonPath("$.boletoNumber").value(Matchers.notNullValue()));
	}
	
	@Test
	public void boletoWithNegativeValueShouldNotBeCreated() throws Exception {
		JSONObject json = new JSONObject();
		json.put("value", -50);
		json.put("clientID", "123");
		json.put("buyer", new JSONObject()
				.put("name", "João")
				.put("email", "joao@email.com")
				.put("cpf", "41863021892"));

		mockMvc.perform(MockMvcRequestBuilders
				.post("/payments/boleto")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json.toString()))
		.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
	
	@Test
	public void boletoWithZeroValueShouldNotBeCreated() throws Exception {
		JSONObject json = new JSONObject();
		json.put("value", 0);
		json.put("clientID", "123");
		json.put("buyer", new JSONObject()
				.put("name", "João")
				.put("email", "joao@email.com")
				.put("cpf", "41863021892"));

		mockMvc.perform(MockMvcRequestBuilders
				.post("/payments/boleto")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json.toString()))
		.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
}
