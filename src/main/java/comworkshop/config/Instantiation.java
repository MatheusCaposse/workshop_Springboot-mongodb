package comworkshop.config;

import comworkshop.domain.Post;
import comworkshop.domain.User;
import comworkshop.repository.PostRepository;
import comworkshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;


    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown" ,"maria@gmail.com");
        User alex = new User(null, "Alex Green" ,"alex@gmail.com");
        User bob = new User(null, "Bob Chawnton" ,"bob@yahoo.com");

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem!", "Vou viajar para São Paulo", maria);
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz", maria);

        userRepository.saveAll(Arrays.asList(maria, alex, bob));
        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
