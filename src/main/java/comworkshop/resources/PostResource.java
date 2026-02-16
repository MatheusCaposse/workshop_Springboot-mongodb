package comworkshop.resources;

import comworkshop.domain.Post;
import comworkshop.service.PostService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/post")
public class PostResource {

    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> findAll(){
        return ResponseEntity.ok().body(postService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Post>> findById(@PathVariable String id){
        Optional<Post> post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }
}
