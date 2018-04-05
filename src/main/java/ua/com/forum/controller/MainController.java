package ua.com.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.com.forum.domain.Comment;
import ua.com.forum.domain.Theme;
import ua.com.forum.domain.User;
import ua.com.forum.service.CommentService;
import ua.com.forum.service.ThemeService;
import ua.com.forum.service.UserService;

@Controller
@SessionAttributes(types = User.class)
public class MainController {

    @Autowired
    private ThemeService themeService;
    @Autowired
    private UserService userService;
    @Autowired
    private CommentService commentService;

    /**
     * @return to "index.jsp" with param:allThemes (load all themes from database).
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView showThemes() {
        return new ModelAndView("index", "allThemes", themeService.getAll());
    }

    /**
     * @param id selected from main page by the click and find by this id theme.
     * @return to "theme.jsp" with param:selectedTheme (load theme by id and comments).
     */
    @RequestMapping("/id")
    public ModelAndView themesId(@RequestParam Long id) {
        return new ModelAndView("theme", "selectedTheme", themeService.findById(id));
    }

    /**
     * @param comment is your comment when added comment,
     * @param id is themes param for update themes Set with comments,
     * @param user from Spring SessionAttributes for check did login user or no,
     * @param map ModelMap for add param:selectedTheme (load theme by id and comments).
     * @return to "theme.jsp" where you can see you added comment.
     */
    @RequestMapping("/addComment")
    public String addComment(@RequestParam String comment, @RequestParam Long id, User user, ModelMap map) {
        if (user.getEmail() == null) {
            return "registration";
        }
        Theme byId = themeService.findById(id);
        Comment comment1 = new Comment();
        comment1.setName(comment);
        Comment save = commentService.save(comment1);

        byId.getCommentsThemes().add(save);
        byId.getUsersTheme().getComments().add(save);
        themeService.update(byId);

        map.addAttribute("selectedTheme", themeService.findById(id));
        return "theme";
    }

    /**
     * @return to "registration.jsp" for registration new User.
     */
    @RequestMapping("/register")
    public String regPage() {
        return "registration";
    }

    /**
     * @param user from Spring SessionAttributes for check did login user or no.
     * @return to "add_new_theme.jsp" if user was login or to "registration.jsp" for create new User.
     */
    @RequestMapping("/add_theme")
    public String addThemePage(User user) {
        if (user.getEmail() != null) {
            return "add_new_theme";
        }
        return "registration";
    }

    /**
     * @param user from Spring SessionAttributes for check did login user or no,
     * @param map for add param:allThemes (and see new theme in list),
     * @param title for new creates theme,
     * @param body for new creates theme.
     * @return to "index.jsp".
     *
     * Here creates new Theme and save to database;
     * after, save this theme to Set themes of User in this session and update it.
     */
    @RequestMapping("/save_new_theme")
    public String saveNewTheme(User user, ModelMap map,
                               @RequestParam String title,
                               @RequestParam String body) {
        User byEmail = userService.findByEmail(user.getEmail());
        Theme theme = new Theme();
        theme.setTitle(title);
        theme.setBody(body);
        theme.setUsersTheme(byEmail);
        themeService.save(theme);
        byEmail.getThemes().add(theme);
        userService.update(byEmail);

        map.addAttribute("allThemes", themeService.getAll());
        return "index";
    }


    /**
     * @return new User if without params if don`t have User in this Session.
     */
    @ModelAttribute("user")
    public User createUser() {
        return new User();
    }
}
