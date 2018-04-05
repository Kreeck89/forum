package ua.com.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import ua.com.forum.domain.Comment;
import ua.com.forum.domain.Theme;
import ua.com.forum.domain.User;
import ua.com.forum.service.CommentService;
import ua.com.forum.service.ThemeService;

@Controller
@SessionAttributes(types = User.class)
public class ModeratedController {

    @Autowired
    private ThemeService themeService;
    @Autowired
    private CommentService commentService;

    private Long selectedThemeId;

    /**
     * If you logged in you can see Button "Moderate".
     *
     * @param map for add param:allThemes (for load all themes for moderate).
     * @return to "title_moderate_window.jsp" where can see all themes.
     */
    @RequestMapping("/moder_title")
    public String showThemesForModerate(ModelMap map) {
        map.addAttribute("allThemes", themeService.getAll());
        return "title_moderate_window";
    }

    /**
     * @param map for add param:selectedTheme (for load all values selected theme),
     * @param id selects from moderate page for load all params this themes.
     * @return to "theme_moderate_window.jsp" for change all params.
     *
     * here save themes id to the global variable:selectedTheme. (for work with this theme in other methods).
     */
    @RequestMapping("/theme_id")
    public String showSelectedTheme(ModelMap map, @RequestParam Long id) {
        selectedThemeId = id;
        map.addAttribute("selectedTheme", themeService.findById(id));
        return "theme_moderate_window";
    }

    /**
     * @param map for add param:selectedTheme and load on this page when will change,
     * @param id for find theme by id for change,
     * @param title with some change,
     * @param body with some changes.
     * @return to "theme_moderate_window" (stay on this page with some updates theme.
     */
    @RequestMapping("/change_theme")
    public String changeSelectedTheme(ModelMap map,
                                      @RequestParam Long id,
                                      @RequestParam String title,
                                      @RequestParam String body) {
        Theme byId = themeService.findById(id);
        byId.setTitle(title);
        byId.setBody(body);
        themeService.update(byId);
        map.addAttribute("selectedTheme", themeService.findById(id));
        return "theme_moderate_window";
    }

    /**
     * @param map for add param:allThemes for load all themes after delete,
     * @param id for delete theme by id.
     * @return to "title_moderate_window" where can select other theme for moderate.
     *
     * here before delete theme, cleaned theme Set with comments!
     */
    @RequestMapping("/delete_theme")
    public String deleteTheme(ModelMap map, @RequestParam Long id) {
        Theme byId = themeService.findById(selectedThemeId);
        byId.getCommentsThemes().clear();
        themeService.delete(id);
        map.addAttribute("allThemes", themeService.getAll());
        return "title_moderate_window";
    }

    /**
     * @param map for add param:allThemes and load on main page.
     * @return to "index.jsp" (step back).
     */
    @RequestMapping("/back_theme")
    public String backPageFromTheme(ModelMap map) {
        map.addAttribute("allThemes", themeService.getAll());
        return "index";
    }

    /**
     * @param map for add param:comment and load selected comment for moderate,
     * @param id for find selected comment theme.
     * @return on "comments_moderate_window.jsp" for moderate this comment.
     */
    @RequestMapping("/moder_comment")
    public String chowSelectedComment(ModelMap map, @RequestParam Long id) {
        map.addAttribute("comment", commentService.findById(id));
        return "comments_moderate_window";
    }

    /**
     * @param map for add param:comment and load selected comment for moderate,
     * @param id for update comment by selected id,
     * @param comment changed comment.
     * @return on "comments_moderate_window.jsp" for moderate this comment.
     */
    @RequestMapping("/change_comment")
    public String changeSelectedComment(ModelMap map,
                                        @RequestParam Long id,
                                        @RequestParam String comment) {
        Comment byId = commentService.findById(id);
        byId.setName(comment);
        commentService.update(byId);
        map.addAttribute("comment", commentService.findById(id));
        return "comments_moderate_window";
    }

    /**
     * @param map for add param:selectedTheme and selected theme with comments for other changes,
     * @param id for search selected comment and remove it.
     * @return to "theme_moderate_window.jsp".
     */
    @RequestMapping("/delete_comment")
    public String deleteComment(ModelMap map, @RequestParam Long id) {
        Comment commentById = commentService.findById(id);
        Theme themeById = themeService.findById(selectedThemeId);
        themeById.getCommentsThemes().remove(commentById);
        themeService.update(themeById);

        map.addAttribute("selectedTheme", themeService.findById(selectedThemeId));
        return "theme_moderate_window";
    }

    /**
     * @param map for add param:selectedTheme (load on page all data selected theme).
     * @return to "theme_moderate_window.jsp" (step back).
     */
    @RequestMapping("/back_comment")
    public String backPageFromComment(ModelMap map) {
        map.addAttribute("selectedTheme", themeService.findById(selectedThemeId));
        return "theme_moderate_window";
    }

    /**
     * @return new User if without params if don`t have User in this Session.
     */
    @ModelAttribute("user")
    public User createUser() {
        return new User();
    }
}
