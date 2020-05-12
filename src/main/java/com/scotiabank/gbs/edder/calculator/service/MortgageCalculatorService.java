package com.scotiabank.gbs.edder.calculator.service;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.scotiabank.gbs.edder.calculator.model.LoanData;
import com.scotiabank.gbs.edder.calculator.validation.MaximumDownPayment;

@RestController
public class MortgageCalculatorService {

  @PostMapping(value = "/calculate")
  @MaximumDownPayment
  public ResponseEntity<JSONObject> calculatePayment(
      @Valid @RequestBody @MaximumDownPayment LoanData request) {

    JSONObject jsonObject = calculateLoanMonthlyPayment(request);
    ResponseEntity<JSONObject> response = new ResponseEntity<JSONObject>(jsonObject, HttpStatus.OK);
    return response;
  }

  private JSONObject calculateLoanMonthlyPayment(LoanData request) {
    LoanData data = (LoanData) request;
    double p = data.getPropertyPrice();
    double d = data.getDownPayment();
    p -= d;
    double r = data.getAnnualRate() / 12;
    int n = data.getYears() * 12;
    int monthlyPayment = (int) (p * ((r * Math.pow(1 + r, n)) / (Math.pow(1 + r, n) - 1)));
    Map<String, Integer> mapValues = new HashMap<>();
    mapValues.put("monthlyPayment", monthlyPayment);
    return new JSONObject(mapValues);
  }

}
