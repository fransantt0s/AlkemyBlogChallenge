package alkemy.web;

import alkemy.domain.Post;
import alkemy.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller

public class HomeController {

    @Autowired
    private PostService postService;


    @GetMapping("/")
    public String home(Model model) {
        var posts = postService.listaPorFecha();
        model.addAttribute("posts", posts);
        return "index";
    }

    @GetMapping("/agregarPost")
    public String agregarPost(Post post) {
        return "editar";
    }


    @PostMapping("/save")
    public String savePost(@RequestParam(name = "file", required = false) MultipartFile file, Post post,
                           RedirectAttributes flash) {

        if (!file.isEmpty()) {
            String ruta = "C://Cursos//uploads";

            try {
                byte[] bytes = file.getBytes();
                Path rutaAbsoluta = Paths.get(ruta + "//" + file.getOriginalFilename());
                Files.write(rutaAbsoluta, bytes);
                post.setImagen(file.getOriginalFilename());

            } catch (Exception e) {

            }
            postService.guardarPost(post);
            flash.addFlashAttribute("success", "Foto subida!!");
        }
        return "redirect:/";


    }
    @GetMapping("/edit/{id}")
    public String editPost(Post post, Model model){
        post = postService.encontrarPost(post);
        model.addAttribute("post", post);
        return "editar";
    }

    @GetMapping("/detalles")
    public String verDetalles (Post post , Model model){
        post = postService.encontrarPost(post);
        model.addAttribute("post",post);
        return "paginaDetalles";
    }


    @GetMapping("/delete")
    public String deletePost(Post post){
        post = postService.encontrarPost(post);
        postService.borrarPost(post);
        return "redirect:/";
    }




}

