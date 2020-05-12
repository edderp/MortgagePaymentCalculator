package com.scotiabank.gbs.edder.calculator.service;

import static org.junit.jupiter.api.Assertions.*;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import com.scotiabank.gbs.edder.calculator.model.LoanData;
import com.scotiabank.gbs.edder.calculator.service.MortgageCalculatorService;

class MortgageCalculatorServiceTest {

  MortgageCalculatorService calculator;
  LoanData request;

  @BeforeEach
  private void setup() {
    calculator = new MortgageCalculatorService();
    
  }

  @Test
  void testCalculatePayment() {
    request = new LoanData(360000, 10000, 0.0269, 15);
    assertEquals(2365, calculator.calculatePayment(request).getBody().get("monthlyPayment"));
  }

  @Test
  void testCalculatePaymentWithNegativeNumbers() {
    request = new LoanData(360000, -10000, -0.0269, -15);
    ResponseEntity<JSONObject> response = calculator.calculatePayment(request);
    assertEquals("Only numerical and positive values are accepted",
        response.getBody().get("errorMessage"));
  }
}
