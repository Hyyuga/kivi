/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.zapp.service;

import java.sql.Date;
import java.time.LocalDate;
import javax.persistence.AttributeConverter;
import org.springframework.stereotype.Service;

/**
 *
 * @author Steppo
 */
//@Converter(autoApply = true)
@Service
public class LocalDatePersistenceConverter implements
        AttributeConverter<Date, LocalDate> {

    @Override
    public LocalDate convertToDatabaseColumn(Date databaseValue) {
         return databaseValue.toLocalDate();
    }
        
    @Override
    public Date convertToEntityAttribute(LocalDate entityValue) {
        return java.sql.Date.valueOf(entityValue);
    }
}
