import java.util.Random;

import model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import steps.Steps;


public class AuthorizationTests {
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
    public void successAuthorizationThroughPersonCabinet () {
        steps.createUserStep(user);
        steps.clickPersonCabinetButtonStep();
        steps.authorizationStep(user);
        steps.checkExistingConstructorSpaceStep();
        steps.clickPersonCabinetButtonStep();
        steps.clickExitButtonStep();
    }

    @Test
    public void successAuthorizationThroughEntryToAccount () {
        steps.createUserStep(user);
        steps.clickEntryToAccountButtonStep();
        steps.authorizationStep(user);
        steps.checkExistingConstructorSpaceStep();
        steps.clickPersonCabinetButtonStep();
        steps.clickExitButtonStep();
    }

    @Test
    public void successAuthorizationThroughRegistration () {
        steps.createUserStep(user);
        steps.clickEntryToAccountButtonStep();
        steps.clickToRegistrationButtonStep();
        steps.clickToAuthorizationButtonStep();
        steps.authorizationStep(user);
        steps.checkExistingConstructorSpaceStep();
        steps.clickPersonCabinetButtonStep();
        steps.clickExitButtonStep();
    }

    @Test
    public void successAuthorizationThroughRecoveryPassword () {
        steps.createUserStep(user);
        steps.clickEntryToAccountButtonStep();
        steps.clickRestorePasswordButtonStep();
        steps.clickToAuthorizationButtonStep();
        steps.authorizationStep(user);
        steps.checkExistingConstructorSpaceStep();
        steps.clickPersonCabinetButtonStep();
        steps.clickExitButtonStep();
    }

    @Test
    public void successAuthorizationAndMoveToPersonCabinet() {
        steps.createUserStep(user);
        steps.clickEntryToAccountButtonStep();
        steps.authorizationStep(user);
        steps.clickPersonCabinetButtonStep();
        steps.checkProfileLabelStep();
        steps.clickExitButtonStep();
    }

    @Test
    public void successAuthorizationAndMoveToConstructor() {
        steps.createUserStep(user);
        steps.clickEntryToAccountButtonStep();
        steps.authorizationStep(user);
        steps.clickPersonCabinetButtonStep();
        steps.clickConstructorButtonStep();
        steps.checkExistingConstructorSpaceStep();
        steps.clickPersonCabinetButtonStep();
        steps.clickExitButtonStep();
    }
}
