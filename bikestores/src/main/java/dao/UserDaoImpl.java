package dao;

import entity.User;
import exception.DAOException;
import util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDAO {
    @Override
    public List<User> findAll() throws DAOException {
        List<User> list = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                list.add(new User(rs.getInt("user_id"), rs.getString("username"), rs.getString("password_hash"), rs.getString("role")));
            }

        } catch (SQLException e) {
            throw new DAOException("Failed to get user list.", e);
        }
        return list;
    }

    @Override
    public void insert(User user) throws DAOException {
        String sql = "INSERT INTO users (username, password_hash, role) VALUES (?, ?, ?)";

        try (Connection conn = JDBCUtil.getConnection();

             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getRole());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("Failed to insert user.", e);
        }
    }

    @Override
    public void update(User user) throws DAOException {
        String sql = "UPDATE users SET username=?, password_hash=? WHERE user_id=?";

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setInt(3, user.getUser_id());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Failed to update user.", e);
        }
    }

    @Override
    public void delete(int userId) throws DAOException {
        String sql = "DELETE FROM users WHERE user_id=?";

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("Failed to delete user.", e);
        }
    }

    @Override
    public User findById(int userId) throws DAOException {

        String sql = "SELECT * FROM users WHERE user_id=?";

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new User(rs.getInt("user_id"), rs.getString("username"), rs.getString("password_hash"), rs.getString("role"));
            }

        } catch (SQLException e) {
            throw new DAOException("Failed to find user by ID.", e);
        }

        return null;
    }

    @Override
    public User findByUsername(String username)
            throws DAOException {

        String sql = "SELECT * FROM users WHERE username = ?";

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new User(rs.getInt("user_id"), rs.getString("username"), rs.getString("password_hash"), rs.getString("role"));
            }
            return null;

        } catch (SQLException e) {
            throw new DAOException("Login query failed", e);
        }
    }

}
