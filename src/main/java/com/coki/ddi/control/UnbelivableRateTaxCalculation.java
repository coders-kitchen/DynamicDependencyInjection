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
@TaxCalculationName("You can't imagine that!")
public class UnbelivableRateTaxCalculation implements TaxCalculation{

	@Override
	public BigDecimal calculateBasedOnMonthlyIncome(BigDecimal monthlyIncome) {
		return monthlyIncome.multiply(BigDecimal.valueOf(0.99));
	}
	
}
