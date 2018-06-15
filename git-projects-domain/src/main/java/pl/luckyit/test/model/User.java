package pl.luckyit.test.model;

import pl.luckyit.test.model.enums.Encoding;

/**
 * Created by Lucjan.Kornacki on 2018-06-13.
 */
public class User {

    private String login;
    private String password;
    private String[] roles;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasswordWithEncoding(Encoding encoding) {
        return encoding.getValue()+password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }
}
