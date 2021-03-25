package alkemy.dao;

import alkemy.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostDao  extends JpaRepository<Post,Long> {
//    @Query("SELECT p.id,p.titulo,p.imagen,p.categoria,p.fechaCreacion from Post  p  ORDER BY p.fechaCreacion DESC ")
//    public List<Post>listaOrdenadaPorFecha();

//    @Query("UPDATE Post p WHERE LOWER(p.id) = LOWER(:id) ")
//    public Post actualizarPost(@Param("id") Long id);

}
