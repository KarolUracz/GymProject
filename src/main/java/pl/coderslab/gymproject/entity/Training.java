package pl.coderslab.gymproject.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private User trainer;
    private DayOfWeek dayOfWeek;
    private LocalTime startHour;
    @OneToMany
    private Set<User> participants;

}
