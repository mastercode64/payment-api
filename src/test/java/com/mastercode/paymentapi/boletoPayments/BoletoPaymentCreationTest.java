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
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BoletoPaymentCreationTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void createdBoletoShouldExists() throws Exception {
		JSONObject json = new JSONObject();
		json.put("value", 50);
		json.put("clientID", "123");
		json.put("buyer", new JSONObject()
				.put("name", "fulano")
				.put("email", "fulano@email.com")
				.put("cpf", "60915936097"));

		//Creating boleto payment request
		ResultActions result = mockMvc.perform(MockMvcRequestBuilders
				.post("/payments/boleto")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json.toString()))
		.andExpect(MockMvcResultMatchers.status().isCreated());		

		//Saving boleto number
		JSONObject jsonResponse = new JSONObject(result.andReturn().getResponse().getContentAsString());
		String boletoNumber = jsonResponse.get("boletoNumber").toString();		

		//Checking boleto number
		mockMvc.perform(MockMvcRequestBuilders
				.get("/payments/1"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.boletoNumber").value(Matchers.is(boletoNumber)));		
	}
}
