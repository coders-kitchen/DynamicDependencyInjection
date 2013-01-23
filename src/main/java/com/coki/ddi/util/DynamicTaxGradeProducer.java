/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coki.ddi.util;

import com.coki.ddi.entity.TaxGrade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.inject.Produces;

/**
 *
 * @author peter
 */
public class DynamicTaxGradeProducer {

	@Produces
	public List<TaxGrade> createTaxGrades() {
		List<TaxGrade> taxGrades = new ArrayList<TaxGrade>();
		
		taxGrades.add(new TaxGrade(BigDecimal.ZERO, BigDecimal.valueOf(500), BigDecimal.ZERO));
		taxGrades.add(new TaxGrade(BigDecimal.valueOf(500), BigDecimal.valueOf(1000), BigDecimal.valueOf(0.01)));
		taxGrades.add(new TaxGrade(BigDecimal.valueOf(500), BigDecimal.valueOf(1000), BigDecimal.valueOf(0.10)));
		taxGrades.add(new TaxGrade(BigDecimal.valueOf(1000), BigDecimal.valueOf(2000), BigDecimal.valueOf(0.20)));
		taxGrades.add(new TaxGrade(BigDecimal.valueOf(2000), BigDecimal.valueOf(5000), BigDecimal.valueOf(0.30)));
		taxGrades.add(new TaxGrade(BigDecimal.valueOf(5000), BigDecimal.valueOf(10000), BigDecimal.valueOf(0.40)));
		
		return taxGrades;
	}
}
