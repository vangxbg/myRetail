package apiApplication.model;

import java.math.BigDecimal;


import org.springframework.data.annotation.Id;

public class Price {
	@Id
	public Long id;
	public BigDecimal value;
	public String currencyCode;
	
	public Price() {
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
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
