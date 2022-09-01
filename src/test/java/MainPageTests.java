import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import steps.Steps;

public class MainPageTests {
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
    public void exitFromAccount () {
        steps.createUserStep();
        steps.clickPersonCabinetButtonStep();
        steps.authorizationStep();
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
        steps.clickFillingsButtonStep();
        steps.clickRollsButtonStep();
        steps.checkRollsLabelStep();
    }
}
