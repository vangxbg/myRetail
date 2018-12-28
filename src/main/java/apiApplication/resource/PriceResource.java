package apiApplication.resource;
import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

public class PriceResource {
	@NotNull(message="you must enter an amount for value")
	@DecimalMin(".01")
	@Digits(integer=10, fraction=2)
	private BigDecimal value;
	private String currencyCode;
	
	public PriceResource() {
	}
	
	public void setValue(BigDecimal value) {
		this.value = value.setScale(2);
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
