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
@TaxCalculationName("No tax")
public class NoTaxCalculation implements TaxCalculation{

	@Override
	public BigDecimal calculateBasedOnMonthlyIncome(BigDecimal monthlyIncome) {
		return BigDecimal.ZERO;
	}
	
}
