package apiApplication.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "prices")
public class Price {
	@Id
	private Integer id;
	private BigDecimal value;
	private String currencyCode;
	
	public Price() {
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
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
