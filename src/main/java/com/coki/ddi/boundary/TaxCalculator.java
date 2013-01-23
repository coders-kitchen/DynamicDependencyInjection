/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coki.ddi.boundary;

import com.coki.ddi.control.TaxCalculation;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author peter
 */
@Stateless
public class TaxCalculator implements Serializable{
	@Inject
	List<String> taxCalculationNames;
	
	@Inject
    TaxCalculationFactory factory;
	
	public BigDecimal calculatedTaxForIncomeBasedOnModel(String modelName, BigDecimal income) {
		TaxCalculation calculationModel = factory.getTaxCalculationForName(modelName);
		return calculationModel.calculateBasedOnMonthlyIncome(income);
	}
	
	public List<String> getTaxCalculationModelNames() {
		return taxCalculationNames;
	}
}
