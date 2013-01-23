/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coki.ddi.control;

import java.math.BigDecimal;

/**
 *
 * @author peter
 */
@TaxCalculationName("fixed grade calculation")
public class FixedGradedTaxCalculation implements TaxCalculation{

	@Override
	public BigDecimal calculateBasedOnMonthlyIncome(BigDecimal monthlyIncome) {
		if(monthlyIncome.compareTo(BigDecimal.valueOf(1000)) < 0) {
			return BigDecimal.ZERO;
		}
		if(monthlyIncome.compareTo(BigDecimal.valueOf(10000)) < 0) {
			return monthlyIncome.multiply(BigDecimal.valueOf(0.3));
		}
		return monthlyIncome.multiply(BigDecimal.valueOf(0.5));
	}
	
}
