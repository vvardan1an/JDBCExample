package jdbcexample.db.manager;

import jdbcexample.db.DBConnectionProvider;
import jdbcexample.db.model.User;

import java.sql.*;

public class UserManager {

    private Connection connection;

    public UserManager(){
        connection = DBConnectionProvider.getInstance().getConnection();
    }
    public void addUser(User user) throws SQLException {

        PreparedStatement preparedStatement =
                connection.prepareStatement("INSERT INTO USER(name,surname,email,password) VALUES(?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getSurname());
        preparedStatement.setString(3, user.getEmail());
        preparedStatement.setString(4, user.getPassword());
        preparedStatement.executeUpdate();

        ResultSet resultSet = preparedStatement.getGeneratedKeys();

        if(resultSet.next()){
            int id = resultSet.getInt(1);
            user.setId(id);
        }
    }
}
