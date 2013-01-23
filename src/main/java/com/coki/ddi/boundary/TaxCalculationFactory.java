/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coki.ddi.boundary;

import com.coki.ddi.control.TaxCalculation;
import com.coki.ddi.control.TaxCalculationName;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author peter
 */
public class TaxCalculationFactory {

	@Inject
	@Any
	Instance<TaxCalculation> taxCalculations;

	public TaxCalculation getTaxCalculationForName(String humanName) {
		TaxCalculation selectedTaxCalculation = null;
        Instance<TaxCalculation> selectedTaxCalculations = taxCalculations.select(new TaxCalculationNameLiteral(humanName));
        for(TaxCalculation cal : selectedTaxCalculations) {
            selectedTaxCalculation = cal;
        }
		return selectedTaxCalculation;
	}

    @Produces
    public List<String> getAvailableTaxCalculationNames() {

        List<String> names = new ArrayList<String>();
        for (TaxCalculation taxCalculation : taxCalculations) {
            String name = taxCalculation.getClass().getAnnotation(TaxCalculationName.class).value();
            names.add(name);
        }
        return names;
    }
    class TaxCalculationNameLiteral extends AnnotationLiteral<TaxCalculationName> implements TaxCalculationName {

        final String expectedName;

        TaxCalculationNameLiteral(String expectedName) {
            this.expectedName = expectedName;
        }

        @Override
        public String value() {
            return expectedName;
        }
    }

}
