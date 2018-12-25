package com.myRetail.apiApplication.Controllers.Resources;
import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

public class PriceResource {
	@NotNull(message="you must enter an amount for value")
	@DecimalMin("0.01")
	@Digits(integer=10, fraction=2)
	public BigDecimal value;
	public String currencyCode;
	
	public PriceResource() {
	}
	
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	
	public BigDecimal getValue() {
		return value;
	}
	
	public String getCurrencyCode() {
		return currencyCode;
	}
}
