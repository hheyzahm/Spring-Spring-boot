package springFrameworkSpringBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import springFrameworkSpringBoot.services.AuthorService;

/**
 * @Created 15 03 2023 - 12:36 PM
 * @Author Hazeem Hassan
 */
@Controller
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping("/authors")
    public String  findAllAuthor(Model model){

        model.addAttribute("authors",authorService.findAllAuthors());
        return "author";
    }
}
