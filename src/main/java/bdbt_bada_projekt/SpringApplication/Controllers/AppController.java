package bdbt_bada_projekt.SpringApplication.Controllers;

import bdbt_bada_projekt.SpringApplication.Services.UserService;
import bdbt_bada_projekt.SpringApplication.models.Adresy;
import bdbt_bada_projekt.SpringApplication.DAO.AdresyDAO;
import bdbt_bada_projekt.SpringApplication.models.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;

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
    public class RegistrationController {

        // Сервіс для роботи з користувачами (потрібно створити)
        private final UserService userService;

        // Конструктор
        public RegistrationController(UserService userService) {
            this.userService = userService;
        }

        // Показує форму реєстрації
        @GetMapping("/register")
        public String showRegistrationForm(Model model) {
            model.addAttribute("user", new User());
            return "register";
        }

        // Обробляє запит на реєстрацію
        @PostMapping("/register")
        public String registerUser(@ModelAttribute("user") User user) {
            userService.register(user);
            return "redirect:/login";
        }
    }



    @Controller
    public class showUserPage {

//        private AdresyDAO adresyDao;
//
//        public showUserPage(AdresyDAO adresyDao) {
//            this.adresyDao = adresyDao;
//        }
//
//        @RequestMapping(value = {"/main_user"})
//        public String showUserPage(Model model) {
//            model.addAttribute("adresyTable", adresyDao.list());
//            return "user/main_user";
//        }
//
//        @RequestMapping(value = "/newAddressRecord")
//        public String addNewRecord(Model model) {
//            model.addAttribute("adresy", new Adresy());
//            return "user/newAddressRecord";
//        }
//
//        @RequestMapping(value = "/save", method = RequestMethod.POST)
//        public String save(@ModelAttribute("adresy") Adresy adresy) {
//            adresyDao.save(adresy);
//            return "redirect:/";
//        }
//
//        @RequestMapping("/edit/{idadresu}")
//        public ModelAndView showEditForm(@PathVariable(name = "idadresu") int idadresu) {
//            ModelAndView mav = new ModelAndView("user/edit_form");
//            Adresy adresy = adresyDao.get(idadresu);
//            mav.addObject("adresy", adresy);
//            return mav;
//        }
//
//        @RequestMapping(value = "/update", method = RequestMethod.POST)
//        public String update(@ModelAttribute("adresy") Adresy adresy){
//            adresyDao.update(adresy);
//            return "redirect:/";
//        }
//
//        @RequestMapping("/delete/{IDADRESU}")
//        public String delete(@PathVariable(name = "IDADRESU") int IDADRESU){
//            adresyDao.delete(IDADRESU);
//            return "redirect:/";
//        }
//
//    }

    }
}
