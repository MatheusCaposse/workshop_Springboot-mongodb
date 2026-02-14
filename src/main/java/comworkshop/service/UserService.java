package comworkshop.service;

import comworkshop.DTO.UserDTO;
import comworkshop.domain.User;
import comworkshop.repository.UserRepository;
import comworkshop.service.exception.ObjectNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

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

    public User insert(User user){
        return userRepository.save(user);
    }

    public void delete(String id){
        findById(id);
        userRepository.deleteById(id);
    }

    public void updateData(User obj, User newObj){
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public User update(User obj){
        User newObj = findById(obj.getId());
        updateData(obj, newObj);
        return userRepository.save(newObj);
    }

    public User fromDTO(UserDTO obj){
        return new User(obj.getId(), obj.getName(), obj.getEmail());
    }
}
