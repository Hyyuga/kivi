/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.zapp.peristence.converter;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.AttributeConverter;
import org.springframework.stereotype.Service;

/**
 *
 * @author Steppo
 */
//@Converter(autoApply = true)
@Service
public class StringToSQLDatePersistenceConverter implements
        AttributeConverter<Date, String> {

    @Override
    public String convertToDatabaseColumn(Date databaseValue) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        return format.format(databaseValue);
    }

    @Override
    public Date convertToEntityAttribute(String entityValue) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        java.util.Date parsed = null;
        try {
            parsed = (java.util.Date) format.parse(entityValue);
        } catch (ParseException ex) {
            Logger.getLogger(StringToSQLDatePersistenceConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Date(parsed.getTime());
    }
}
