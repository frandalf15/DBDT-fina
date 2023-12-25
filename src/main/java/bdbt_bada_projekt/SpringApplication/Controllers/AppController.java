package bdbt_bada_projekt.SpringApplication.Controllers;

import bdbt_bada_projekt.SpringApplication.models.Adresy;
import bdbt_bada_projekt.SpringApplication.tables.AdresyDAO;
import bdbt_bada_projekt.SpringApplication.tables.MagazynyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Configuration
public class AppController implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/login").setViewName("login");

        registry.addViewController("/main_admin").setViewName("admin/main_admin");
        registry.addViewController("/main_user").setViewName("user/main_user");
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
    public class showAdminPage{
        @RequestMapping(value = {"/main_admin"})
        public String showAdminPage(Model model) {
            return "admin/main_admin";
        }
    }


    @Controller
    public class showUserPage{
        private AdresyDAO adresyDao;

        public showUserPage(AdresyDAO adresyDao) {
            this.adresyDao = adresyDao;
        }

        @RequestMapping(value = {"/main_user"})
        public String showUserPage(Model model){
            model.addAttribute("adresyTable", adresyDao.list());
            return "user/main_user";
        }
    }

}
