package edu.fpdual.webapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Currency {
    private int currencyId;
    private String currencyName;
    private String currencySymbol;

    public Currency(String currencyName, String currencySymbol) {
        this.currencyName = currencyName;
        this.currencySymbol = currencySymbol;
    }

}