package com.tutorial.user;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    @Sql(scripts = {"classpath:/sqlannotation/delete-users.sql", "classpath:/sqlannotation/insert-users.sql"},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
    )

    @Transactional
    void 全てのユーザーが取得できること() {
        List<User> users = userMapper.findAll();
        assertThat(users)
                .hasSize(3)
                .contains(
                        new User(1, "yuya", "1990/03/25"),
                        new User(2, "taka", "1992/05/10"),
                        new User(3, "hiro", "1995/12/23")
                );
    }

    @Test
    @Transactional
    void 指定したIDで存在するユーザーを取得すること() {
        Optional<User> user = userMapper.findById(1);
        assertThat(user).contains(new User(1, "yuya", "1990/03/25"));
    }

    @Test
    @Transactional
    void 存在しないIDを指定した時に空で返すこと() {
        Optional<User> user = userMapper.findById(99);
        assertThat(user).isEmpty();
    }
}
