package com.example.mockito.controller;

import com.example.mockito.application.UserService;
import com.example.mockito.entity.User;
import com.example.mockito.form.UserForm;
import com.example.mockito.form.UserForm.Request.ChangePassword;
import com.example.mockito.form.UserForm.Request.SignUp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(value = "/signUp")
    public String signUp(@RequestBody SignUp signUp) {
        User user = User.builder()
                .email(signUp.getEmail())
                .password(signUp.getPassword())
                .build();
        return userService.signUp(user).getEmail();
    }

    @PostMapping(value = "/changePassword")
    public String changePassword(@RequestBody ChangePassword changePassword) {
        User user = userService.changePassword(changePassword);
        return user.getPassword();
    }

//    @PostMapping(value = "/signUp")
//    public ResponseEntity<String> signUp(@RequestBody final SignUpDTO signUpDTO) {
//        return userService.isEmailExists(signUpDTO.getEmail()) ? ResponseEntity.badRequest().build() : ResponseEntity.ok(TokenUtils.generateJwtToken(userService.signUp(signUpDTO)));
//    }
//
//    @GetMapping(value = "/list")
//    public ResponseEntity<UserListResponseDTO> findAll() {
//        final UserListResponseDTO userListResponseDTO = UserListResponseDTO.builder().userList(userService.findAll()).build();
//        return ResponseEntity.ok(userListResponseDTO);
//    }
}
