package comworkshop.config;

import comworkshop.domain.User;
import comworkshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    UserRepository repository;

    @Override
    public void run(String... args) throws Exception {

        repository.deleteAll();

        User maria = new User(null, "Maria Brown" ,"maria@gmail.com");
        User alex = new User(null, "Alex Green" ,"alex@gmail.com");
        User bob = new User(null, "Bob Chawnton" ,"bob@yahoo.com");

        repository.saveAll(Arrays.asList(maria, alex, bob));
    }
}
