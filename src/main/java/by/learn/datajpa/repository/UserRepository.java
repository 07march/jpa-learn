package by.learn.datajpa.repository;

import by.learn.datajpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByName(String name);

    User findByLogin(String login);
}
