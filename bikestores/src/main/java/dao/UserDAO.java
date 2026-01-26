package dao;

import entity.User;
import exception.DAOException;

import java.util.List;

public interface UserDAO {
    List<User> findAll() throws DAOException;
    void insert(User user) throws DAOException;
    void update(User user) throws DAOException;
    void delete(int userId) throws DAOException;
    User findById(int userId) throws DAOException;
    User findByUsername(String username) throws DAOException;
}
