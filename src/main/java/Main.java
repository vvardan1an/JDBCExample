import jdbcexample.db.manager.UserManager;
import jdbcexample.db.model.User;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args){
        UserManager userManager = new UserManager();
        try {
            User user = new User("poxos","poxosyan","pox@mail.ru","poxos");
            userManager.addUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
