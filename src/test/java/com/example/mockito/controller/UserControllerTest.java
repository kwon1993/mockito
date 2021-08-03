package com.example.mockito.controller;

import com.example.mockito.application.UserRepository;
import com.example.mockito.application.UserService;
import com.example.mockito.form.UserForm.Request.ChangePassword;
import com.example.mockito.form.UserForm.Request.SignUp;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback(value = true)
@ExtendWith(MockitoExtension.class)
class UserControllerTest {

//    @InjectMocks
//    private UserController userController;
//
//    @Mock
//    private UserService userService;
//
//    private MockMvc mockMvc;
//
//    @BeforeEach
//    public void init() {
//        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
//    }

    @Autowired
    UserController userController;

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @BeforeAll
    private static void init() {
        System.out.println("전체 테스트 시작 전에 실행");
    }

    @BeforeEach
    private void before() {
        System.out.println("테스트 메서드 시작 전마다 실행");

//        SignUp signUp = SignUp.builder()
//                .email("test@emai.com")
//                .password("password")
//                .build();
//        userController.signUp(signUp);
    }
    
    @AfterEach
    private void after() {
        System.out.println("테스트 메서드 종료 후마다 실행");
    }
    
    @AfterAll
    private static void close() {
        System.out.println("전체 테스트 종료 후에 실행");
    }

    @Test
    @DisplayName("회원 가입")
    void signUp() {
        SignUp signUp = SignUp.builder()
                .email("test2@emai.com")
                .password("password1")
                .build();
        String email = userController.signUp(signUp);

        Assertions.assertEquals(signUp.getPassword(), userService.findByEmail(email).getPassword());
    }

    @Test
    @DisplayName("비밀 번호 변경")
    void changePassword() {
        SignUp signUp = SignUp.builder()
                .email("test@emai.com")
                .password("password")
                .build();
        userController.signUp(signUp);

        String afterPassword = "changedPassword";

        ChangePassword changePassword = ChangePassword.builder()
                .email("test@email.com")
                .beforePassword("password")
                .afterPassword(afterPassword)
                .build();

        String changedPassword = userController.changePassword(changePassword);

        Assertions.assertEquals(changedPassword, changePassword.getAfterPassword());
    }

//    @DisplayName("회원 가입 성공")
//    @Test
//    void signUpSuccess() throws Exception {
//        // given
//        UserForm.Request.SignUp signUpDTO = signUpDTO();
//        doReturn(false).when(userService).isEmailDuplicated(signUpDTO.getEmail());
//        doReturn(new User("a", "b", UserRole.ROLE_USER)).when(userService).signUp(any(SignUpDTO.class));
//    }
//
//    private SignUpDTO signUpDTO() {
//        final SignUpDTO signUpDTO = new SignUpDTO();
//        signUpDTO.setEmail("test@test.test");
//        signUpDTO.setPw("test");
//        return signUpDTO;
//    }
}