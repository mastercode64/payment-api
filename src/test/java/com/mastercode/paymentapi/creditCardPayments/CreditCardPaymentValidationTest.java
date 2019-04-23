package com.mastercode.paymentapi.creditCardPayments;

import java.time.LocalDate;

import org.json.JSONObject;
import org.junit.BeforeClass;
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

import com.mastercode.paymentapi.util.LocalDateUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CreditCardPaymentValidationTest {

	@Autowired
	private MockMvc mockMvc;
	
	private static LocalDate validCreditCardExpirationDate;
	private static LocalDate invalidCreditCardExpirationDate;
	
	@BeforeClass
	public static void setup() {
		validCreditCardExpirationDate = LocalDate.now().plusMonths(2);
		invalidCreditCardExpirationDate = LocalDate.now().minusMonths(2);
		System.out.println("---------Valid expiration date variable: " + validCreditCardExpirationDate);
		System.out.println("---------Invalid expiration date variable: " + invalidCreditCardExpirationDate);
	}
	
	@Test
	public void validCreditCardPaymenShouldBeCreated() throws Exception {
		JSONObject json = new JSONObject();
		json.put("value", 50);
		json.put("clientID", "123");
		
		json.put("buyer", new JSONObject()
				.put("name", "João")
				.put("email", "joao@email.com")
				.put("cpf", "41863021892"));
		
		json.put("creditCard", new JSONObject()
				.put("holderName", "João")
				.put("expiration", LocalDateUtils.localDateToString(validCreditCardExpirationDate))
				.put("number", "1234567890123")
				.put("cvv", "720"));

		mockMvc.perform(MockMvcRequestBuilders
				.post("/payments/credit-card")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json.toString()))
		.andExpect(MockMvcResultMatchers.status().isCreated());
	}
	
	
	@Test
	public void creditCardPaymentWithNegativeValueShouldNotBeCreated() throws Exception {
		JSONObject json = new JSONObject();
		json.put("value", -50);
		json.put("clientID", "123");
		
		json.put("buyer", new JSONObject()
				.put("name", "João")
				.put("email", "joao@email.com")
				.put("cpf", "41863021892"));
		
		json.put("creditCard", new JSONObject()
				.put("holderName", "João")
				.put("expiration", LocalDateUtils.localDateToString(validCreditCardExpirationDate))
				.put("number", "1234567890123")
				.put("cvv", "720"));

		mockMvc.perform(MockMvcRequestBuilders
				.post("/payments/credit-card")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json.toString()))
		.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
	
	@Test
	public void creditCardPaymentWithZeroValueShouldNotBeCreated() throws Exception {
		JSONObject json = new JSONObject();
		json.put("value", 0);
		json.put("clientID", "123");
		
		json.put("buyer", new JSONObject()
				.put("name", "João")
				.put("email", "joao@email.com")
				.put("cpf", "41863021892"));
		
		json.put("creditCard", new JSONObject()
				.put("holderName", "João")
				.put("expiration", LocalDateUtils.localDateToString(validCreditCardExpirationDate))
				.put("number", "1234567890123")
				.put("cvv", "720"));

		mockMvc.perform(MockMvcRequestBuilders
				.post("/payments/credit-card")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json.toString()))
		.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
	
	
	@Test
	public void invalidCreditCardNumberShouldNotBeCreated() throws Exception {
		JSONObject json = new JSONObject();
		json.put("value", 50);
		json.put("clientID", "123");
		
		json.put("buyer", new JSONObject()
				.put("name", "João")
				.put("email", "joao@email.com")
				.put("cpf", "41863021892"));
		
		json.put("creditCard", new JSONObject()
				.put("holderName", "João")
				.put("expiration", LocalDateUtils.localDateToString(validCreditCardExpirationDate))
				.put("number", "abc")
				.put("cvv", "720"));

		mockMvc.perform(MockMvcRequestBuilders
				.post("/payments/credit-card")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json.toString()))
		.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
	
	@Test
	public void invalidCvvCodeShouldNotBeCreated() throws Exception {
		JSONObject json = new JSONObject();
		json.put("value", 50);
		json.put("clientID", "123");
		
		json.put("buyer", new JSONObject()
				.put("name", "João")
				.put("email", "joao@email.com")
				.put("cpf", "41863021892"));
		
		json.put("creditCard", new JSONObject()
				.put("holderName", "João")
				.put("expiration", LocalDateUtils.localDateToString(validCreditCardExpirationDate))
				.put("number", "1234567890124")
				.put("cvv", "c"));

		mockMvc.perform(MockMvcRequestBuilders
				.post("/payments/credit-card")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json.toString()))
		.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
	
	@Test
	public void creditCardWithExpiredDateShouldNotBeCreated() throws Exception {
		JSONObject json = new JSONObject();
		json.put("value", 50);
		json.put("clientID", "123");
		
		json.put("buyer", new JSONObject()
				.put("name", "João")
				.put("email", "joao@email.com")
				.put("cpf", "41863021892"));
		
		json.put("creditCard", new JSONObject()
				.put("holderName", "João")
				.put("expiration", LocalDateUtils.localDateToString(invalidCreditCardExpirationDate))
				.put("number", "1234567890123")
				.put("cvv", "790"));

		mockMvc.perform(MockMvcRequestBuilders
				.post("/payments/credit-card")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json.toString()))
		.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
	
	
}
