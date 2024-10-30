package com.tutorial.user.integrationtest;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DBRider
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserApiIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DataSet(value = "datasets/users.yml")
    @Transactional
    void 全てのユーザー取得できること() throws Exception {
        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        """
                                 [
                                      {
                                          "id": 1,
                                          "name": "yuya",
                                          "dateOfBirth": "1990/03/25"
                                      },
                                      {
                                          "id": 2,
                                          "name": "taka",
                                          "dateOfBirth": "1992/05/10"
                                      },
                                      {
                                          "id": 3,
                                          "name": "hiro",
                                          "dateOfBirth": "1995/12/23"
                                      }
                                 ]
                                 
                                """
                ));

    }


    @Test
    @DataSet(value = "datasets/users.yml")
    @Transactional
    void 指定したIDで存在するユーザーを取得すること() throws Exception {
        mockMvc.perform(get("/users/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        """
                                                                
                                     {
                                         "id": 1,
                                         "name": "yuya",
                                         "dateOfBirth": "1990/03/25"
                                     }
                                                                
                                """
                ));
    }


    @Test
    @DataSet(value = "datasets/users.yml")
    @Transactional
    void 存在しないIDを指定したとき例外処理を返すこと() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/99"))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.timestamp").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("404"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.error").value("Not Found"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("user not found with id: " + 99))
                .andExpect(MockMvcResultMatchers.jsonPath("$.path").value("/users/99"));

    }
}
