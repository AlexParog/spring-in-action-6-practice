package com.springinaction.parogcloud;

import com.springinaction.parogcloud.controller.HomeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HomeController.class)
public class HomeControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHomePage() throws Exception {
        mockMvc.perform(get("/")) // выполнить запрос GET
                .andExpect(status().isOk()) // ожидается статус 200
                .andExpect(view().name("home")) // ожидается имя представления home
                .andExpect(content().string( // наличие строки
                        containsString("Welcome to...")));
    }
}
