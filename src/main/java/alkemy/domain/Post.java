package alkemy.domain;



import jdk.jfr.DataAmount;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.awt.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="post")
@SQLDelete(sql="UPDATE post SET deleted=1 WHERE id = ?")
public class Post implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String contenido;
    private String imagen;
    private String categoria;
    private Byte deleted;



    public String getContenido() {
        return contenido;
    }


    public void setContenido(String contenido) {
        this.contenido = contenido;
    }



    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaCreacion;

    public Long getId() {
        return id;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Post(Long id, String titulo, String imagen, String categoria, Date fechaCreacion) {
        this.id = id;
        this.titulo = titulo;
        this.imagen = imagen;
        this.categoria = categoria;
        this.fechaCreacion = fechaCreacion;
    }

    public Post() {
    }

    public Post(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }
}
