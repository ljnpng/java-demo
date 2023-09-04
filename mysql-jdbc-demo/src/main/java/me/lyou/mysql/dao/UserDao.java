package me.lyou.mysql.dao;

import me.lyou.mysql.po.User;

import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    /**
     * 连接的字符集要设置, 不然中文会乱码
     */
    private final String url = "jdbc:mysql://localhost:13306/test?useSSL=false&serverTimezone=UTC&characterEncoding=utf-8&useUnicode=true";
    private final String root = "root";
    private final String password = "123456";

    public List<User> select() {
        String sql = "select * from user";
        try {
            return selectInternal(sql);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    private List<User> selectInternal(String sql) throws ClassNotFoundException {
        // Class.forName("com.mysql.cj.jdbc.Driver"); 不需要这个, 实际上在 是 DriveManager 中 ServiceLoader 加载 META-INF/services 中的配置

        List<User> users = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, root, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            users = getUsers(resultSet);
        } catch (SQLException throwables) {
            System.out.println(throwables.getErrorCode());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        return users;
    }

    private List<User> getUsers(ResultSet resultSet) throws SQLException, UnsupportedEncodingException {
        List<User> users = new ArrayList<>();
        while (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setAge(resultSet.getInt("age"));
            user.setGender(resultSet.getBoolean("gender"));
            users.add(user);
        }
        return users;
    }

    public void insert(User user) {
        insertInternal("Insert into user (name, age, gender) values (?,?,?)", user);
    }

    private void insertInternal(String sql, User user) {
        try (Connection connection = DriverManager.getConnection(url, root, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, user.getName());
            statement.setInt(2, user.getAge());
            statement.setBoolean(3, user.getGender());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void remove(User user) {
        removeInternal("delete from user where id=?", user);
    }

    private void removeInternal(String sql, User user) {
        try (Connection connection = DriverManager.getConnection(url, root, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, user.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
