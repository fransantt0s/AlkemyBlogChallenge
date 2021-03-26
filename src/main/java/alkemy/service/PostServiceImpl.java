package alkemy.service;

import alkemy.PostNotFoundException;
import alkemy.dao.PostDao;
import alkemy.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostDao postDao;

    @Override
    @Transactional(readOnly = true)
    public List<Post> listaPorFecha() {
        return postDao.findAll(Sort.by(Sort.Direction.DESC, "fechaCreacion"));
    }

    @Override
    @Transactional
    public void guardarPost(Post post) {
        postDao.save(post);

    }

    @Override
    @Transactional
    public void borrarPost(Post post) {
        if(post==null){
            throw new PostNotFoundException("El post que desea borrar no existe");
        }
        postDao.delete(post);

    }

    @Override
    @Transactional(readOnly = true)
    public Post encontrarPost(Post post) {
        if(post==null){
            throw new PostNotFoundException("El post que desea visitar no existe");
        }
        return postDao.findById(post.getId()).orElse(null);
    }

    @Override
    @Transactional
    public void actualizarTitulo(Long id, String titulo){
        Post post = postDao.getOne(id);
        if(post == null){
            throw new PostNotFoundException("El post que desea actualizar no existe");
        }
        post.setCategoria(titulo);
    }

    @Override
    public void actualizarCategoria(Long id, String categoria) {
        Post  post= postDao.getOne(id);
        if(post == null){
            throw new PostNotFoundException("El post que desea actualizar no existe");
        }
        post.setCategoria(categoria);
    }

    @Override public void actualizarContenido(Long id, String contenido){
        Post post = postDao.getOne(id);
        if(post == null){
            throw new PostNotFoundException("El post que desea actualizar no existe");
        }
        post.setContenido(contenido);
    }

}
