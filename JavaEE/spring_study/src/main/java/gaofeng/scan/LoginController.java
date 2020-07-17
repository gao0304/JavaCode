package gaofeng.scan;

import gaofeng.ioc.Duck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private Duck duck7;

    public LoginService getLoginService() {
        return loginService;
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    public Duck getDuck7() {
        return duck7;
    }

    public void setDuck7(Duck duck7) {
        this.duck7 = duck7;
    }
}

