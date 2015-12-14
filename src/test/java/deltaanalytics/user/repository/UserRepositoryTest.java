package deltaanalytics.user.repository;

import deltaanalytics.user.entity.User;
import org.junit.After;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserRepositoryTest {

    @After
    public void tearDown(){
        CleanTestMemDB.cleanUp();
    }
    @Test
    public void create(){
        User user = new User();
        UserRepository userRepository = new UserRepository();

        userRepository.createOrUpdate(user);

        assertThat(userRepository.exists(user), is(equalTo(true)));
    }

    @Test
    public void existsByAccountPassword(){
        User user = new User();
        String account = "mala";
        user.setAccount(account);
        String password = "pawo";
        user.setPassword(password);
        UserRepository userRepository = new UserRepository();

        userRepository.createOrUpdate(user);

        assertThat(userRepository.exists(account, password), is(equalTo(true)));
    }

    @Test
    public void existsByAccountPasswordNotExist(){
        User user = new User();
        String account = "mala";
        user.setAccount(account);
        String password = "pawo";
        user.setPassword(password);
        UserRepository userRepository = new UserRepository();

        userRepository.createOrUpdate(user);

        assertThat(userRepository.exists("nicht", "bekannt"), is(equalTo(false)));
    }
}
