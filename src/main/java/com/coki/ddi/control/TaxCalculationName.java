package com.coki.ddi.control;

import javax.inject.Qualifier;

@Qualifier
public @interface TaxCalculationName {
    String value();
}
