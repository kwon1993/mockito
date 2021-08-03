package com.example.mockito.form;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

public class UserForm {

    public static class Request {

        @Getter
        @NoArgsConstructor
        public static class SignUp {

            @Email
            private String email;
            private String password;

            @Builder
            private SignUp(String email, String password) {
                this.email = email;
                this.password = password;
            }
        }

        @Getter
        @NoArgsConstructor
        public static class ChangePassword {

            @Email
            private String email;
            private String beforePassword;
            private String afterPassword;

            @Builder
            public ChangePassword(String email, String beforePassword, String afterPassword) {
                this.email = email;
                this.beforePassword = beforePassword;
                this.afterPassword = afterPassword;
            }
        }
    }

}
