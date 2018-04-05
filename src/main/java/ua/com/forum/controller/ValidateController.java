package ua.com.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import ua.com.forum.domain.Role;
import ua.com.forum.domain.User;
import ua.com.forum.service.RoleService;
import ua.com.forum.service.ThemeService;
import ua.com.forum.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@SessionAttributes(types = User.class)
public class ValidateController {

    @Autowired
    private UserService userService;
    @Autowired
    private ThemeService themeService;
    @Autowired
    private RoleService roleService;

    /**
     * @param user Spring SessionAttribute for save User in session,
     * @param session for save some attributes to HttpSession,
     * @param model for add param:allThemes (load all themes on main page),
     * @param email for test login,
     * @param password for test login.
     *
     * @return to "registration.jsp" if don`t have entered e-mail or wrong password, and SessionAttribute = null;
     *      OR to "index.jsp" with write attribute to HttpSession:
     *      "role" if it = ADMIN for moderate data later if will need,
     *      "email" with user`s email.
     */
    @PostMapping(value = "/login")
    public String login(User user, HttpSession session, Model model,
                        @RequestParam String email,
                        @RequestParam String password) {
        User byEmail = userService.findByEmail(email);
        if (byEmail == null) {
            user = null;
            return "registration";
        }
        if (!byEmail.getPassword().equals(password)) {
            user = null;
            return "registration";
        }
        user = byEmail;
        List<Role> admin = user.getRoles().stream().filter(role -> role.getName().equals("ADMIN"))
                .collect(Collectors.toList());
        if (admin.size() != 0) {
            session.setAttribute("role", admin.get(0).getName());
        }
        session.setAttribute("email", user.getEmail());
        model.addAttribute("allThemes", themeService.getAll());
        return "index";
    }

    /**
     * @param user for save params to SessionAttribute when register,
     * @param model for add param:allThemes (load all themes after registration,
     * @param session for save "email" to HttpSession,
     * @param name for register new User,
     * @param nick for register new User,
     * @param email for register new User,
     * @param password for register new User,
     * @param age for register new User,
     * @return to "oops.jsp" if entered e-mail saved early in database;
     *      OR to "index.jsp" if new User was created.
     */
    @PostMapping("/registrations")
    public String reg(User user, ModelMap model, HttpSession session,
                      @RequestParam String name,
                      @RequestParam String nick,
                      @RequestParam String email,
                      @RequestParam String password,
                      @RequestParam int age) {
        User byEmail = userService.findByEmail(email);
        if (byEmail != null) {
            user = null;
            model.addAttribute(("allThemes"), themeService.getAll());
            return "oops";
        }
        Role roleById = roleService.getById(1L);
        user.getRoles().add(roleById);
        User save = userService.save(user);

        model.addAttribute(("allThemes"), themeService.getAll());
        session.setAttribute("email", save.getEmail());
        return "index";
    }

    /**
     * @param status for completed SessionStatus,
     * @param user for delete user from SessionAttributes,
     * @param model for add param:allThemes (load all themes in main page),
     * @param session for invalidate HttpSession.
     * @return to "index.jsp" after logout.
     */
    @RequestMapping("/logout")
    public String logout(SessionStatus status, User user, Model model, HttpSession session) {
        user = null;
        status.setComplete();
        session.invalidate();
        model.addAttribute("allThemes", themeService.getAll());
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
