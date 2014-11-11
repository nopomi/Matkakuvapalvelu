package wadp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wadp.domain.Image;
import wadp.domain.Post;
import wadp.domain.User;
import wadp.repository.PostRepository;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public Post createPost(Image image, String imageText, User poster) {
        Post post = new Post();
        post.setImageText(imageText);
        post.setImage(image);
        post.setPoster(poster);

        return postRepository.save(post);
    }

    @Transactional
    public List<Post> getUserPosts(User user) {

        return postRepository.findByPoster(user);
    }

    @Transactional
    public Object getPost(Long id) {
        return postRepository.findOne(id);
    }
}