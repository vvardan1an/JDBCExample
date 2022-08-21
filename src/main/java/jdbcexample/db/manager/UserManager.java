package jdbcexample.db.manager;

import jdbcexample.db.DBConnectionProvider;
import jdbcexample.db.model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UserManager {

    private Connection connection;

    public UserManager(){
        connection = DBConnectionProvider.getInstance().getConnection();
    }
    public void addUser(User user) throws SQLException {

        Statement statement = connection.createStatement();
        String query = "INSERT INTO USER(name,surname,email,password) VALUES('"
                + user.getName() + "','" + user.getSurname() +"','" + user.getEmail()
                + "','" + user.getPassword() + "')";
        statement.executeUpdate(query,Statement.RETURN_GENERATED_KEYS);
    }
}
