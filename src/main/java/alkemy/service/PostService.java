package alkemy.service;

import alkemy.domain.Post;


import java.util.List;

public interface PostService{
    public List <Post> listaPorFecha();
    public void guardarPost(Post post);
    public void borrarPost(Post post);
    public Post encontrarPost(Post post);


}
