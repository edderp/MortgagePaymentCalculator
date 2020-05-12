package com.scotiabank.gbs.edder.calculator.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

public class LoanData {

  @Positive(message = "Only numerical and positive values accepted")
  private double propertyPrice;
  @Positive(message = "Only numerical and positive values accepted")
  private double downPayment;
  @Min(value=0, message = "Only numerical and positive values accepted")
  private double annualRate;
  @Positive(message = "Only numerical and positive values accepted")
  @Max(value = 30, message = "Years of loan cannot be more than 30 years")
  private int years;

  
  public LoanData(double propertyPrice, double downPayment, double annualRate, int years) {
    super();
    this.propertyPrice = propertyPrice;
    this.downPayment = downPayment;
    this.annualRate = annualRate;
    this.years = years;
  }

  public LoanData() {
    super();
  }

  public double getPropertyPrice() {
    return propertyPrice;
  }

  public void setPropertyPrice(double propertyPrice) {
    this.propertyPrice = propertyPrice;
  }

  public double getDownPayment() {
    return downPayment;
  }

  public void setDownPayment(double downPayment) {
    this.downPayment = downPayment;
  }

  public double getAnnualRate() {
    return annualRate;
  }

  public void setAnnualRate(double annualRate) {
    this.annualRate = annualRate;
  }

  public int getYears() {
    return years;
  }

  public void setYears(int years) {
    this.years = years;
  }

}
