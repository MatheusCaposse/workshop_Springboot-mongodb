package comworkshop.service;

import comworkshop.DTO.UserDTO;
import comworkshop.domain.User;
import comworkshop.repository.UserRepository;
import comworkshop.service.exception.ObjectNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id){
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Error! user not found"));
    }

    public User fromDTO(UserDTO obj){
        return new User(obj.getId(), obj.getName(), obj.getEmail());
    }

    public User insert(User user){
        return userRepository.save(user);
    }
}
