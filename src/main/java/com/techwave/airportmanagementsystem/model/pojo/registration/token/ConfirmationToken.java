package com.techwave.airportmanagementsystem.model.pojo.registration.token;

import com.techwave.airportmanagementsystem.model.pojo.user.Login;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ConfirmationToken {
    @Id
    @SequenceGenerator(
            name = "token_sequence",
            sequenceName = "token_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "token_sequence"
    )
    private Long id;
    @Column(nullable = false)
    private String token;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime expiresAt;
    private LocalDateTime confirmedAt;
    @ManyToOne
    @JoinColumn(
            nullable = false,
            name= "login_id"
    )
    private Login login;

    public ConfirmationToken(String token, LocalDateTime createdAt, LocalDateTime expiresAt, Login login) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.login = login;
    }
}
