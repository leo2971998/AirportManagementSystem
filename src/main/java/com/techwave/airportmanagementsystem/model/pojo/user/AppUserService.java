package com.techwave.airportmanagementsystem.model.pojo.user;

import com.techwave.airportmanagementsystem.model.pojo.registration.token.ConfirmationToken;
import com.techwave.airportmanagementsystem.model.pojo.registration.token.ConfirmationTokenService;
import com.techwave.airportmanagementsystem.model.pojo.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {
    private final static String msg = "User with email %s not found";
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException(String.format(msg, username)));
    }

    public String signUpUser(Login login) {
        boolean userExist = userRepository.findByEmail(login.getEmail()).isPresent();
        if (userExist) {
            throw new IllegalStateException("Email already taken");
        }
        String password = bCryptPasswordEncoder.encode(login.getPassword());
        login.setPassword(password);
        userRepository.save(login);
        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(token, LocalDateTime.now(), LocalDateTime.now().plusMinutes(15), login);
        confirmationTokenService.saveConfirmationToken(confirmationToken);
        return token;
    }
    public int enableAppUser(String email) {
        return userRepository.enableAppUser(email);
    }
}
