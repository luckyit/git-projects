package pl.luckyit.test.properties;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import pl.luckyit.test.model.User;
import java.util.List;

/**
 * Created by Lucjan.Kornacki on 2018-06-13.
 */
@Component
@ConfigurationProperties
public class UserConfigurationProperties {

    @JsonProperty("users")
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
