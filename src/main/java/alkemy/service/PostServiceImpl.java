package alkemy.service;

import alkemy.dao.PostDao;
import alkemy.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

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
            throw  new NotFoundException("El post que desea borrar no existe");
        }
        postDao.delete(post);

    }

    @Override
    @Transactional(readOnly = true)
    public Post encontrarPost(Post post) {
        if(post==null){
            throw new NotFoundException("El post que desea visitrar no existe");
        }
        return postDao.findById(post.getId()).orElse(null);
    }



}
