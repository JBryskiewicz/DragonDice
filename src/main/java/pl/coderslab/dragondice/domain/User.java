package pl.coderslab.dragondice.domain;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(max = 20, message = "Username cannot be longer than 20 characters")
    @NotNull(message = "Username required")
    @Column(nullable = false, unique = true)
    private String userName;

    @Email
    @NotNull(message = "Email required")
    @Column(nullable = false, unique = true)
    private String email;

    @NotNull(message = "Password required")
    @Column(nullable = false)
    private String password;

    private int enabled;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Role> roles;

}
