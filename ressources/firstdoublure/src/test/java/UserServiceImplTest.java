import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.Test;

public class UserServiceImplTest {

    @Test
    public void should_create_user_with_hashed_password() {
        HashProvider hashProvider = mock(HashProvider.class);

        UserService userService = new UserServiceImpl(hashProvider);

        User user = userService.createUser("Bob", "secret");

        assertEquals(user.firstName(), "Bob");
        assertEquals(user.hashedPassword(), hashProvider.hash("secret"));
    }
}

