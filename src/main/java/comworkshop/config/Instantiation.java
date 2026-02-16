package comworkshop.config;

import comworkshop.DTO.AuthorDTO;
import comworkshop.DTO.CommentDTO;
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

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem!", "Vou viajar para São Paulo", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz", new AuthorDTO(maria));

        CommentDTO c1 = new CommentDTO("Boa viagem", sdf.parse("01/04/2025"), new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO("Aproveita", sdf.parse("10/10/2022"), new AuthorDTO(bob));
        CommentDTO c3 = new CommentDTO("Boa noite", sdf.parse("10/06/2022"), new AuthorDTO(alex));

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPost().addAll(Arrays.asList(post1, post2));

        userRepository.save(maria);
    }
}
