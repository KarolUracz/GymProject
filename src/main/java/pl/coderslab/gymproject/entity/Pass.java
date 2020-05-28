package pl.coderslab.gymproject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.PrePersist;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class Pass {

    private Integer type;

    private LocalDate startDate;

    @PrePersist
    public void prePersist() {
        startDate = LocalDate.now();
    }


}
