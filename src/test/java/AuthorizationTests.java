import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import steps.Steps;


public class AuthorizationTests {
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
    public void successAuthorizationThroughPersonCabinet () {
        steps.createUserStep();
        steps.clickPersonCabinetButtonStep();
        steps.authorizationStep();
        steps.checkExistingConstructorSpaceStep();
    }

    @Test
    public void successAuthorizationThroughEntryToAccount () {
        steps.createUserStep();
        steps.clickEntryToAccountButtonStep();
        steps.authorizationStep();
        steps.checkExistingConstructorSpaceStep();
    }

    @Test
    public void successAuthorizationThroughRegistration () {
        steps.createUserStep();
        steps.clickEntryToAccountButtonStep();
        steps.clickToRegistrationButtonStep();
        steps.clickToAuthorizationButtonStep();
        steps.authorizationStep();
        steps.checkExistingConstructorSpaceStep();
    }

    @Test
    public void successAuthorizationThroughRecoveryPassword () {
        steps.createUserStep();
        steps.clickEntryToAccountButtonStep();
        steps.clickRestorePasswordButtonStep();
        steps.clickToAuthorizationButtonStep();
        steps.authorizationStep();
        steps.checkExistingConstructorSpaceStep();
    }

    @Test
    public void successAuthorizationAndMoveToPersonCabinet() {
        steps.createUserStep();
        steps.clickEntryToAccountButtonStep();
        steps.authorizationStep();
        steps.clickPersonCabinetButtonStep();
        steps.checkProfileLabelStep();
    }

    @Test
    public void successAuthorizationAndMoveToConstructor() {
        steps.createUserStep();
        steps.clickEntryToAccountButtonStep();
        steps.authorizationStep();
        steps.clickPersonCabinetButtonStep();
        steps.clickConstructorButtonStep();
        steps.checkExistingConstructorSpaceStep();
    }
}
