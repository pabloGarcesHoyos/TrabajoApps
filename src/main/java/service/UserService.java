package service;

import dto.UserDto;
import jakarta.persistence.*;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();

    }

    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    public User saveUsers(UserDto userDto) {
        User user = new User();
        user.setName(user.getName());
        user.setLastName(user.getLastName());
        user.setAdress(user.getAdress());
        user.setPassword(user.getPassword());
        user.setUsername(user.getUsername());
        user.setProduct(user.getProduct());
        return userRepository.save(user);
    }

    public User updateUsers(UserDto userDto){
        User user = new User();
        user.setId(user.getId());
        user.setName(user.getName());
        user.setLastName(user.getLastName());
        user.setAdress(user.getAdress());
        user.setPassword(user.getPassword());
        user.setUsername(user.getUsername());
        user.setProduct(user.getProduct());
        return userRepository.save(user);
    }

    public void deleteProductsById(long id){
        userRepository.deleteById(id);
    }
}
