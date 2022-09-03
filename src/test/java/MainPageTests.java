import java.util.Random;

import model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import steps.Steps;

public class MainPageTests {
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
    public void exitFromAccount () {
        steps.createUserStep(user);
        steps.clickPersonCabinetButtonStep();
        steps.authorizationStep(user);
        steps.clickPersonCabinetButtonStep();
        steps.clickExitButtonStep();
        steps.checkEntryLabelStep();
    }

    @Test
    public void toSauces() {
        steps.clickSaucesButtonStep();
        steps.checkSaucesLabelStep();
    }

    @Test
    public void toFillings () {
        steps.clickFillingsButtonStep();
        steps.checkFillingsLabelStep();
    }

    @Test
    public void toRolls () {
        steps.clickSaucesButtonStep();
        steps.clickRollsButtonStep();
        steps.checkRollsLabelStep();
    }
}
