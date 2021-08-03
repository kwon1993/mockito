package com.example.mockito;

import com.example.mockito.application.UserService;
import com.example.mockito.controller.UserController;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
class MockitoApplicationTests {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    private MockMvc mockMvc;

    @BeforeEach
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    public void test1() {

    }

//    @Mock
//    List annotationMockedList;
//
//    List mockedList = Mockito.mock(List.class);
//
//    mockedList.add("one");
//    mockedList.clear();




}
