package alkemy.service;

import alkemy.domain.Post;


import java.util.List;

public interface PostService{
    public List <Post> listaPorFecha();
    public void guardarPost(Post post);
    public void borrarPost(Post post);
    public Post encontrarPost(Post post);
    public void actualizarTitulo(Long id , String titulo);
    public void actualizarCategoria (Long id, String categoria);
    public void actualizarContenido (Long id,String contenido);


}
