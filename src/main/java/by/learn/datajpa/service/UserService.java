package by.learn.datajpa.service;

import by.learn.datajpa.entity.User;
import by.learn.datajpa.repository.AddressRepository;
import by.learn.datajpa.repository.TelephoneRepository;
import by.learn.datajpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private TelephoneRepository telephoneRepository;

    public User add(User user){
        addressRepository.save(user.getAddress());
        telephoneRepository.save(user.getTelephone());
        return userRepository.save(user);
    }

    public List<User> findAllByName(String name){
        return userRepository.findAllByName(name);
    }

    public User findById(long id){
        return userRepository.findById(id).get();
    }

    public User authoriz(String login, String password){
        User byLogin = userRepository.findByLogin(login);
        if (byLogin.getPassword().equals(password)) {
            return byLogin;
        }
        return null;
    }
}
