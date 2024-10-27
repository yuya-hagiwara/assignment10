package com.tutorial.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    UserService userService;

    @Mock
    UserMapper userMapper;


    @Test
    public void 全てのユーザーが取得できること() {
        List<User> users = List.of(
                new User(1, "yuya", "1990/03/25"),
                new User(2, "taka", "1992/05/10"),
                new User(3, "hiro", "1995/12/23")
        );

        doReturn(users).when(userMapper).findAll();
        List<User> actual = userService.findAll();
        assertThat(actual).isEqualTo(users);
        verify(userMapper).findAll();
    }

    @Test
    public void 指定したIDで存在するユーザーを習得すること() {
        doReturn(Optional.of(new User(1, "yuya", "1990/03/25"))).when(userMapper).findById(1);
        User actual = userService.findUser(1);
        assertThat(actual).isEqualTo(new User(1, "yuya", "1990/03/25"));
        verify(userMapper, times(1)).findById(1);
    }


    @Test
    void 存在しないIDを指定したとき例外処理を返すこと() throws RuntimeException {
        doReturn(Optional.empty()).when(userMapper).findById(99);
        assertThrows(RuntimeException.class, () -> {
            userService.findUser(99);
        });
    }
}
