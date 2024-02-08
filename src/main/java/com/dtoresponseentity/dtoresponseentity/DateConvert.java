package com.dtoresponseentity.dtoresponseentity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class DateConvert {

    @GetMapping("/convert/{day}/{month}/{year}")
    public String convert(@PathVariable int day, @PathVariable int month, @PathVariable int year){
        if (day < 1 || day > 31) {
            return "Invalid day";
        }
        if (month < 1 || month > 12) {
            return "Invalid month";
        }
        if (year < 1900 || year > 2024) {
            return "Invalid year";
        }

        LocalDate fechaNacimiento= LocalDate.of(year, month, day);
        LocalDate fechaActual= LocalDate.now();

        return Period.between(fechaNacimiento, fechaActual).getYears() + "";
    }
}
