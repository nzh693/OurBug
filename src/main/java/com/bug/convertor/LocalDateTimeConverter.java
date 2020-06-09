package com.bug.convertor;


import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Locale;

/*
 *   Author = Liewona
 *   Date = 2020/6/9 19:57
 */
public class LocalDateTimeConverter implements Converter<Object, LocalDateTime> {


    @Override
    public LocalDateTime convert(Object source) {

        System.out.println("-----------converter-------------");
        System.out.println(source);

//        String[] ts = source.split(" |[:T-]");
//        LocalDateTime time = LocalDateTime.of
//                (LocalDate.of(Integer.parseInt(ts[0]), Integer.parseInt(ts[1]), Integer.parseInt(ts[2])),
//                LocalTime.of(Integer.parseInt(ts[3]), Integer.parseInt(ts[4]), Integer.parseInt(ts[5])));

        return null;
    }
}
