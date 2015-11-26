/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.zapp.service;

import java.sql.Date;
import java.time.LocalDate;
import org.springframework.stereotype.Service;

/**
 *
 * @author Steppo
 */
@Service
public class DatePickerService {
    public static LocalDate getLocalDate(Date date){
        return date.toLocalDate();
    }
}
