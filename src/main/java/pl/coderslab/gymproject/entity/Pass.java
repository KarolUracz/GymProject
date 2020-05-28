package pl.coderslab.gymproject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Pass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer type;
    private LocalDate startDate;
    private LocalDate endDate;

    @PrePersist
    public void prePersist() {
        startDate = LocalDate.now();
        endDate = startDate.plus(type, ChronoUnit.MONTHS);
    }


}
