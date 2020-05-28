package pl.coderslab.gymproject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

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
    @ManyToOne
    private User user;

//    @PrePersist
//    public void prePersist() {
//        startDate = LocalDate.now();
//        endDate = startDate.plus(type, ChronoUnit.MONTHS);
//    }


}
