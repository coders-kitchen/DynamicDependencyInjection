/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coki.ddi.entity;

import java.math.BigDecimal;

/**
 *
 * @author peter
 */
public class TaxGrade {
	private BigDecimal minimalIncome;
	private BigDecimal maximalIncome;
	private BigDecimal taxRate;

	public TaxGrade(BigDecimal minimalIncome, BigDecimal maximalIncome, BigDecimal taxRate) {
		this.minimalIncome = minimalIncome;
		this.maximalIncome = maximalIncome;
		this.taxRate = taxRate;
	}

	
	
	public BigDecimal getMinimalIncome() {
		return minimalIncome;
	}

	public BigDecimal getMaximalIncome() {
		return maximalIncome;
	}
	
	public BigDecimal getTaxRate() {
		return taxRate;
	}	
	
}
