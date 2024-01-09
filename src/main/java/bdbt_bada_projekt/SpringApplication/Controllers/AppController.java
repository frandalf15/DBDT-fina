package bdbt_bada_projekt.SpringApplication.Controllers;

import bdbt_bada_projekt.SpringApplication.DAO.TowaryDAO;
import bdbt_bada_projekt.SpringApplication.DAO.ZamowieniaDAO;
import bdbt_bada_projekt.SpringApplication.Services.UserService;
import bdbt_bada_projekt.SpringApplication.models.Adresy;
import bdbt_bada_projekt.SpringApplication.DAO.AdresyDAO;
import bdbt_bada_projekt.SpringApplication.models.Towary;
import bdbt_bada_projekt.SpringApplication.models.User;
import bdbt_bada_projekt.SpringApplication.models.Zamowienia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Date;
import java.sql.Timestamp;
@Configuration
public class AppController implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/login").setViewName("login");

        registry.addViewController("/main_admin").setViewName("admin/main_admin");
        registry.addViewController("/main_user").setViewName("user/main_user");
        registry.addViewController("/newAddressRecord").setViewName("user/newAddressRecord");
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
            } else if (request.isUserInRole("STAFF")){
                return "redirect:/main_staff";
            } else {
                return "redirect:/index";
            }
        }
    }


    @Controller
    public class showAdminPage {
        @RequestMapping(value = {"/main_admin"})
        public String showAdminPage(Model model) {
            return "admin/main_admin";
        }
    }


    @Controller
    public class showStaffPage {
        @RequestMapping(value = {"/main_staff"})
        public String showAdminPage(Model model) {
            return "admin/main_staff";
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
        public String registerUser(@ModelAttribute("user") User user) {
            user.setRole("USER");
            userService.register(user);
            return "redirect:/login";
        }
    }


    @Controller
    public class showUserPage {

        private TowaryDAO towaryDAO;
        private ZamowieniaDAO zamowieniaDAO;


        @Controller
        public class TowaryUserController {
            private final TowaryDAO towaryDAO;

            private final ZamowieniaDAO zamowieniaDAO;

            @GetMapping("/ZamowieniaUser")
            public String showZamowienieUserPage(Model model) {
                Authentication auth = SecurityContextHolder.getContext().getAuthentication();
                model.addAttribute("zamowienieTable", zamowieniaDAO.list(auth));
                return "user/ZamowieniaUser";
            }


            @Autowired
            public TowaryUserController(TowaryDAO towaryDAO, ZamowieniaDAO zamowieniaDAO) {
                this.towaryDAO = towaryDAO;
                this.zamowieniaDAO = zamowieniaDAO;
            }

            @GetMapping("/TowaryUser")
            public String showTowaryUserPage(Model model) {
                model.addAttribute("towaryTable", towaryDAO.list());
                return "user/TowaryUser";
            }



        }

        @Controller
        public class ZamowieniaController {

            private final TowaryDAO towaryDAO;
            private final ZamowieniaDAO zamowieniaDAO;
            private final UserService userService;

            @Autowired
            public ZamowieniaController(TowaryDAO towaryDAO, ZamowieniaDAO zamowieniaDAO, UserService userService) {
                this.towaryDAO = towaryDAO;
                this.zamowieniaDAO = zamowieniaDAO;
                this.userService = userService;
            }

            @PostMapping("/placeOrder")
            public String placeOrder(@RequestParam("IDTowaru") int IDTowaru,
                                     @RequestParam("quantity") int quantity,
                                     HttpServletRequest request) {
                Towary towary = towaryDAO.get(IDTowaru);
                if (towary != null) {
                    double totalPrice = towary.getCena() * quantity;
                    Zamowienia zamowienia = new Zamowienia();
                    zamowienia.setIDUser(userService.getCurrentUserId());
                    zamowienia.setILOSC(quantity);
                    zamowienia.setIDTowaru(IDTowaru);
                    zamowienia.setStatus("W trakcie realizacji");
                    Date now = new Date();
                    zamowienia.setData(new java.sql.Date(now.getTime()));
                    zamowienia.setRabat(0);
                    zamowieniaDAO.save(zamowienia);
                }
                return "redirect:/ZamowieniaUser"; // Redirect to the page with the order summary
            }
        }


    }
}
