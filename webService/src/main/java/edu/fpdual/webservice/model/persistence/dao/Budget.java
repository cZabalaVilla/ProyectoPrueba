package edu.fpdual.webservice.model.persistence.dao;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor

public class Budget {
    int userId;
    int budgetId;
    String budgetName;
    //Tenemos que decidir el tipo de dato para las fechas
    Date creationDate;

    //Atributo de datos

    //Si queremos poner que se pueda elegir el tipo de moneda en la que se hará el presupuesto.
    //Habría que crear un enum o una tabla en bbdd con la moneda y el símbolo
    //Moneda moneda;
}
