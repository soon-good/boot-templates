package io.study.tdd.weblayer.employee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

//@SpringBootTest
@WebMvcTest // SpringBootTest 역시 가능하다.
public class EmployeeControllerTest {

    @Autowired
    private EmployeeController controller;

    private MockMvc mockMvc;

    @BeforeEach
    void setup(){
        mockMvc = MockMvcBuilders
                // MockMvc 인스턴스는 보통 MockMvcBuilders 클래스의 standaloneSetup(Controller) 메서드를 사용한다.
                // 인자값으로 사용되는 controller 는 Spring 컨테이너 내에 존재하는 Controller 인스턴스이다.
                .standaloneSetup(controller)
                // MockMvc 객체를 최종적으로 반환해주는 것은 build() 메서드이다.
                .build();
    }

    @Test
    @DisplayName("MockMvc_테스트_1")
    void MockMvc_테스트_1() throws Exception{
        mockMvc
                // perform 은 RequestBuilders 를 인자로 받는다.
                // 일반적으로 MockMvc 를 접두사로 하는 MockMvcRequestBuilders 의 get() 메서드를 사용한다.
                .perform(MockMvcRequestBuilders.get("/employees"))
                // andDo 는 ResultHandlers 를 인자로 받는다.
                // 일반적으로 MockMvc 를 접두사로 하는 MockMvcResultHandlers 의 print()를 사용하는 편이다.
                .andDo(MockMvcResultHandlers.print())
                // andExpect 는 ResultMatcher 를 인자로 받는다.
                // 일반적으로 MockMvc 를 접두사로 하는 MockMvcResultMatchers 의 메서드 들을 사용하는 편이다.
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("MockMvc_테스트_2")
    void MockMvc_테스트_2() throws Exception{
        mockMvc
                // perform 은 RequestBuilders 를 인자로 받는다.
                // 일반적으로 MockMvc 를 접두사로 하는 MockMvcRequestBuilders 의 get() 메서드를 사용한다.
                .perform(MockMvcRequestBuilders.get("/employee/servertime"))
                // andDo 는 ResultHandlers 를 인자로 받는다.(do - handler)
                // 일반적으로 MockMvc 를 접두사로 하는 MockMvcResultHandlers 의 print()를 사용하는 편이다.
                .andDo(MockMvcResultHandlers.print())
                // andExpect 는 ResultMatcher 를 인자로 받는다.(expect - resultMatcher)
                // 일반적으로 MockMvc 를 접두사로 하는 MockMvcResultMatchers 의 메서드 들을 사용하는 편이다.
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("serverTime"));
    }
}
