package pl.coderslab.gymproject.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
@Component
public class StartHourConverter implements Converter<String, LocalTime> {
    @Override
    public LocalTime convert(String s) {
        int hour = Integer.parseInt(s);
        int mins = 0;
        return LocalTime.of(hour, mins);
    }
}
