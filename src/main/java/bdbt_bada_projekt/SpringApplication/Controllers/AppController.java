package bdbt_bada_projekt.SpringApplication.Controllers;

import bdbt_bada_projekt.SpringApplication.DAO.*;
import bdbt_bada_projekt.SpringApplication.Services.UserAlreadyExistsException;
import bdbt_bada_projekt.SpringApplication.Services.UserService;
import bdbt_bada_projekt.SpringApplication.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Date;

@Configuration
public class AppController implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("login");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("").setViewName("login");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/main_admin").setViewName("admin/main_admin");
        registry.addViewController("/Korty").setViewName("admin/Korty");
        registry.addViewController("/main_user").setViewName("user/main_user");
        registry.addViewController("/RezerwacjeUser").setViewName("user/RezerwacjeUser");
    }

    @Controller
    public class DashboardController {
        @RequestMapping("/main")
        public String defaultAfterLogin(HttpServletRequest request) {
            if
            (request.isUserInRole("ADMIN")) {
                return "redirect:/main_admin";
            } else if (request.isUserInRole("USER")) {
                return "redirect:/main_user";
            } else {
                return "redirect:/index";
            }
        }
    }

    @Controller
    public class showAdminPage {
        @Autowired
        private UserDAO userDAO;

        @Autowired
        private KortDAO kortDAO;


        @RequestMapping(value = {"/main_admin"})
        public String showAdminPage(Model model) {
            return "admin/main_admin";
        }

        @PostMapping("/updateUserRole")
        public String updateUserRole(@RequestParam("IDKortu") int IDKortu, @RequestParam("role") String role) {
            User user = userDAO.get(IDKortu);
            user.setRole(role);
            userDAO.update(user);
            return "redirect:/Users";
        }

        @GetMapping("/Users")
        public String showUsersAdminPage(Model model, Principal principal) {
            User loggedInUser = userDAO.findByUsername(principal.getName());
            int restrictedUserId = 31;
            model.addAttribute("loggedInUserId", loggedInUser.getId());
            model.addAttribute("restrictedUserId", restrictedUserId);
            model.addAttribute("usersTable", userDAO.list());


            return "admin/Users";
        }

        @GetMapping("/Korty")
        public String showKortyAdminPage(Model model) {
            model.addAttribute("kortTable", kortDAO.list());
            return "admin/Korty";
        }

        @PostMapping("/addKort")
        public String addKort(Kort kort) {
            kortDAO.save(kort);
            return "redirect:/Korty";
        }

        @GetMapping("/editKort/{IDKortu}")
        public String showEditProductForm(@PathVariable("IDKortu") int IDKortu, Model model) {
            Kort kort = kortDAO.get(IDKortu);
            model.addAttribute("kort", kort);
            return "admin/editKort";
        }


        @PostMapping("/updateProduct")
        public String updateProduct(@ModelAttribute Kort kort) {
            kortDAO.update(kort);
            return "redirect:/Kort";
        }

        @PostMapping("/deleteKort")
        public String deleteProduct(@RequestParam("IDKortu") int IDKortu) {
            kortDAO.delete(IDKortu);
            return "redirect:/Korty";
        }
    }

    @Controller
    public class RegistrationController {

        private final UserService userService;

        public RegistrationController(UserService userService) {
            this.userService = userService;
        }

        @GetMapping("/register")
        public String showRegistrationForm(Model model) {
            model.addAttribute("user", new User());
            return "register";
        }

        @PostMapping("/register")
        public String registerUser(@ModelAttribute("user") User user, Model model) {
            try {
                user.setRole("ADMIN");
                userService.register(user);
                return "redirect:/login";
            } catch (UserAlreadyExistsException e) {
                model.addAttribute("error", "Username already taken");
                return "register";
            }
        }

    }
}
