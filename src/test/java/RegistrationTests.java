import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import steps.Steps;

public class RegistrationTests {
    Steps steps = new Steps();

    @Before
    public void startUp() {
        steps.openPageStep();
    }

    @After
    public void tearDown() {
        steps.removeUserStep();
    }

    @Test
    public void successRegistration () {
        steps.successRegistrationStep();
        steps.checkEntryLabelStep();
    }

    @Test
    public void failRegistrationWithIncorrectPassword () {
        steps.failRegistrationStep();
        steps.checkTextForIncorrectPasswordStep();
    }
}
