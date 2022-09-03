import java.util.Random;

import model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import steps.Steps;

public class RegistrationTests {
    Steps steps = new Steps();
    User user;

    @Before
    public void startUp() {
        steps.openPageStep();
        int random = new Random().nextInt(10);
        user = new User("test_nt_" + random + "@ya.ru",
                "test_pass",
                "test_nt_" + random);
    }

    @After
    public void tearDown() {
        steps.removeUserStep();
    }

    @Test
    public void successRegistration () {
        steps.successRegistrationStep(user);
        steps.checkEntryLabelStep();
    }

    @Test
    public void failRegistrationWithIncorrectPassword () {
        user.setPassword("as");
        steps.failRegistrationStep(user);
        steps.checkTextForIncorrectPasswordStep();
    }
}
