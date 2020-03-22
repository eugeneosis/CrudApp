package com.ru;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
    }

    public static List<Post> getPosts() throws ClassNotFoundException, SQLException {
        try (Connection connection = getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement("SELECT * from posts");

             ResultSet resultSet = prepareStatement.executeQuery()) {

            ArrayList<Post> posts = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String surname = resultSet.getString(3);

                posts.add(new Post(id, name, surname));
            }
            return posts;
        }
    }

    public static void deletePosts(int id) throws SQLException, ClassNotFoundException {
        try (Connection connection = getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement("DELETE FROM posts WHERE id=?")) {
            prepareStatement.setInt(1, id);
            prepareStatement.executeUpdate();
        }
    }

    public static void addPost(String name, String surname) throws SQLException, ClassNotFoundException {
        try (Connection connection = getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(
                     "INSERT INTO posts (name, surname) VALUES (?, ?)");

        ) {
            prepareStatement.setString(1, name);
            prepareStatement.setString(2, surname);

            prepareStatement.executeUpdate();
        }
    }
}
