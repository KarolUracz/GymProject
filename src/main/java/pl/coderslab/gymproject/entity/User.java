package pl.coderslab.gymproject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, length = 60)
    @Email
    private String username;
    @NotBlank
    private String password;
    private int enabled;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    private String email;
    @NotBlank
    private String address;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Pass> passes;

    @PrePersist
    public void prePersist() {
        this.email = username;
    }

}
