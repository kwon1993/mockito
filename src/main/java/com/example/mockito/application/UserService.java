package com.example.mockito.application;

import com.example.mockito.entity.User;
import com.example.mockito.form.UserForm;
import com.example.mockito.form.UserForm.Request.ChangePassword;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User signUp(User user) {
        return userRepository.save(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(RuntimeException::new);
    }

    @Transactional
    public User changePassword(ChangePassword changePassword) {
        User user = userRepository.findByEmail(changePassword.getEmail()).orElseThrow(RuntimeException::new);
        if (user.getPassword().equals(changePassword.getBeforePassword())) {
            user.changePassword(changePassword.getAfterPassword());
            return userRepository.findByEmail(changePassword.getEmail()).orElseThrow(RuntimeException::new);
        } else {
            throw new RuntimeException();
        }
    }
}
