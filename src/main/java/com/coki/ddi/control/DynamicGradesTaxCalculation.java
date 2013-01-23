/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coki.ddi.control;


import java.math.BigDecimal;
import java.util.List;
import javax.inject.Inject;
import com.coki.ddi.entity.TaxGrade;

/**
 *
 * @author peter
 */
@TaxCalculationName("dynamic grades calculation")
public class DynamicGradesTaxCalculation implements TaxCalculation{

	@Inject
	List<TaxGrade> taxGrades;

	@Override
	public BigDecimal calculateBasedOnMonthlyIncome(BigDecimal monthlyIncome) {
		TaxGrade matchingGrade = null;
		for(TaxGrade grade : taxGrades) {
			if(grade.getMinimalIncome().compareTo(monthlyIncome) < 0 && grade.getMaximalIncome().compareTo(monthlyIncome) >= 0) {
				matchingGrade = grade;
				break;
			}
		}
		return monthlyIncome.multiply(matchingGrade.getTaxRate());
	}
	
}
