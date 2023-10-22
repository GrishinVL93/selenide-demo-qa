package saucelab.authorization;

import com.codeborne.selenide.Condition;
import constants.Messages;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class BlockedUserAuthorizationTest {


    @Test
    public void blockedUserAuthorization(){
        open("https://www.saucedemo.com/");
        $("#user-name").setValue("locked_out_user");
        $("#password").setValue("secret_sauce");
        $("#login-button").click();

        $x("//h3[@data-test='error']").shouldHave(Condition.text(Messages.LOCKED_USER));
    }
}
