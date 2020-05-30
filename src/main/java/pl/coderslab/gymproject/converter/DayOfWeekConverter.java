package pl.coderslab.gymproject.converter;

import org.springframework.core.convert.converter.Converter;

import java.time.DayOfWeek;

public class DayOfWeekConverter implements Converter<String, DayOfWeek> {
    @Override
    public DayOfWeek convert(String s) {
        return DayOfWeek.valueOf(s);
    }
}
