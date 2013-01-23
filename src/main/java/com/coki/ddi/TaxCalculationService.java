/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coki.ddi;

import com.coki.ddi.boundary.TaxCalculator;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 *
 * @author peter
 */
@Model
@SessionScoped
public class TaxCalculationService implements Serializable{
	@Inject
	TaxCalculator calculator;
	
	String selectedCalculatorModelName;
	
	Long income;
	
	public List<String> getTaxCalculatorModelNames() {
		return calculator.getTaxCalculationModelNames();
	}
	
	public BigDecimal calculateTaxBasedOnIncomeAndModel() {
		if(selectedCalculatorModelName != null && income != null) {
			return calculator.calculatedTaxForIncomeBasedOnModel(selectedCalculatorModelName, BigDecimal.valueOf(income));
		}
		return BigDecimal.ZERO;
	}
	
	public void setIncome(Long income) {
		this.income = income;
	}
	
	public Long getIncome() {
		return income;
	}

	public String getSelectedCalculatorModelName() {
		return selectedCalculatorModelName;
	}

	public void setSelectedCalculatorModelName(String selectedCalculatorModelName) {
		this.selectedCalculatorModelName = selectedCalculatorModelName;
	}
	
	
	
}
