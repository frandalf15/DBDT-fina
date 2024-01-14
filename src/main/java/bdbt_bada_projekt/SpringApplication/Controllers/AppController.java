package bdbt_bada_projekt.SpringApplication.Controllers;

import bdbt_bada_projekt.SpringApplication.DAO.*;
import bdbt_bada_projekt.SpringApplication.Services.UserAlreadyExistsException;
import bdbt_bada_projekt.SpringApplication.Services.UserService;
import bdbt_bada_projekt.SpringApplication.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
        @Autowired
        private UserDAO userDAO;

        @Autowired
        private ZamowieniaDAO zamowieniaDAO;

        @Autowired
        private MagazynyDAO magazynyDAO;

        @Autowired
        private TowaryDAO towaryDAO;

        @Autowired
        private RabatyDAO rabatyDAO;

        @RequestMapping(value = {"/main_admin"})
        public String showAdminPage(Model model) {
            return "admin/main_admin";
        }

        @GetMapping("/Orders")
        public String showZamowienieUserPage(Model model) {
            model.addAttribute("ordersTable", zamowieniaDAO.list());
            return "admin/Orders";
        }

        @PostMapping("/updateUserRole")
        public String updateUserRole(@RequestParam("id") int id, @RequestParam("role") String role) {
            User user = userDAO.get(id);
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

        @PostMapping("/updateOrder")
        public String updateOrder(@ModelAttribute("zamowienie") Zamowienia zamowienie) {
            zamowieniaDAO.update(zamowienie);
            return "redirect:/Orders";
        }



        @GetMapping("/Towary")
        public String showZamowienieAdminPage(Model model) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            model.addAttribute("productsTable", towaryDAO.list());
            return "admin/Towary";
        }

        @PostMapping("/addProduct")
        public String addProduct(Towary product) {
            towaryDAO.save(product);
            return "redirect:/Towary";
        }

        @GetMapping("/editProduct/{id}")
        public String showEditProductForm(@PathVariable("id") int id, Model model) {
            Towary product = towaryDAO.get(id);
            model.addAttribute("product", product);
            return "admin/editProduct";
        }

        @PostMapping("/updateProduct")
        public String updateProduct(@ModelAttribute Towary product) {
            towaryDAO.save(product);
            return "redirect:/Towary";
        }

        @PostMapping("/deleteProduct")
        public String deleteProduct(@RequestParam("idTowaru") int idTowaru) {
            towaryDAO.delete(idTowaru);
            return "redirect:/Towary";
        }
        @GetMapping("/Magazyny")
        public String showMagazynyAdminPage(Model model) {
            model.addAttribute("magazynyTable", magazynyDAO.list());
            return "admin/Magazyny";
        }
        @PostMapping("/deleteMagazyn")
        public String deleteMagazyn(@RequestParam("idmagazynu") int idmagazynu) {
            magazynyDAO.delete(idmagazynu);
            return "redirect:/Magazyny";
        }

        @PostMapping("/addMagazyn")
        public String addPMagazyn(Magazyny magazyny) {
            magazynyDAO.save(magazyny);
            return "redirect:/Magazyny";
        }

        @GetMapping("/admin/editMagazyn/{id}")
        public String showEditMagazynPage(@PathVariable("id") int id, Model model) {
            Magazyny magazyn = magazynyDAO.get(id);
            if (magazyn != null) {
                model.addAttribute("magazyn", magazyn);
                return "admin/editMagazyn";
            } else {
                return "redirect:/admin/Magazyny";
            }
        }

        @PostMapping("/editMagazyn")
        public String updateMagazyn(@ModelAttribute("magazyn") Magazyny magazyn, BindingResult result) {
            if (result.hasErrors()) {
                return "admin/editMagazyn"; // повернення до форми редагування у разі помилок
            }
            magazynyDAO.update(magazyn); // виклик DAO для оновлення магазину
            return "redirect:/Magazyny"; // перенаправлення до списку магазинів після оновлення
        }


        @GetMapping("/Rabaty")
        public String showRabatyAdminPage(Model model) {
            model.addAttribute("rabatyTable", rabatyDAO.list());
            return "admin/Rabaty";
        }

        @PostMapping("/addRabat")
        public String addPMagazyn(Rabaty rabaty) {
            rabatyDAO.save(rabaty);
            return "redirect:/Rabaty";
        }

        @PostMapping("/deleteRabat")
        public String deleteRabat(@RequestParam("id") int id) {
            rabatyDAO.delete(id);
            return "redirect:/Rabaty";
        }

        @GetMapping("/editRabat/{id}")
        public String showEditRabatPage(@PathVariable("id") int id, Model model) {
            Rabaty rabaty = rabatyDAO.get(id);
            if (rabaty != null) {
                model.addAttribute("rabaty", rabaty);
                return "admin/editRabat";
            } else {
                return "redirect:/admin/Rabaty";
            }
        }

        @PostMapping("/editRabat")
        public String updateRabat(@ModelAttribute("rabaty") Rabaty rabaty, BindingResult result) {
            if (result.hasErrors()) {
                return "admin/editRabat"; // повернення до форми редагування у разі помилок
            }
            rabatyDAO.update(rabaty); // виклик DAO для оновлення магазину
            return "redirect:/Rabaty"; // перенаправлення до списку магазинів після оновлення
        }


    }

    @Controller
    public class showStaffPage {
        @RequestMapping(value = {"/main_staff"})
        public String showAdminPage(Model model) {
            return "staff/main_staff";
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
                user.setRole("USER");
                userService.register(user);
                return "redirect:/login";
            } catch (UserAlreadyExistsException e) {
                model.addAttribute("error", "Username already taken");
                return "register";
            }
        }

    }

    @Controller
    public class showUserPage {

        private TowaryDAO towaryDAO;
        private ZamowieniaDAO zamowieniaDAO;

        @Autowired
        private RabatyDAO rabatyDAO;

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
            private final RabatyDAO rabatyDAO;

            @Autowired
            public ZamowieniaController(TowaryDAO towaryDAO, ZamowieniaDAO zamowieniaDAO, UserService userService, RabatyDAO rabatyDAO) {
                this.towaryDAO = towaryDAO;
                this.zamowieniaDAO = zamowieniaDAO;
                this.userService = userService;
                this.rabatyDAO = rabatyDAO;
            }

            @PostMapping("/placeOrder")
            public String placeOrder(@RequestParam("IDTowaru") int IDTowaru,
                                     @RequestParam("quantity") int quantity,
                                     @RequestParam("rabat") String rabat,
                                     HttpServletRequest request) {
                Towary towary = towaryDAO.get(IDTowaru);

                if (towary != null) {
                    double totalPrice = towary.getCena() * quantity;
                    Rabaty discount = rabatyDAO.findByNazwa(rabat);

                    Zamowienia zamowienia = new Zamowienia();
                    zamowienia.setIDUser(userService.getCurrentUserId());
                    zamowienia.setILOSC(quantity);
                    zamowienia.setIDTowaru(IDTowaru);
                    zamowienia.setStatus("W trakcie realizacji");
                    Date now = new Date();
                    zamowienia.setData(new java.sql.Date(now.getTime()));

                    if (discount != null) {
                        double discountAmount = totalPrice * discount.getRabat();
                        totalPrice -= discountAmount;
                        zamowienia.setRabat(discount.getRabat()); // Set the discount rate
                    } else {
                        zamowienia.setRabat(0.00);
                    }
                    zamowienia.setTotalPrice(totalPrice);
                    zamowieniaDAO.save(zamowienia);
                }
                return "redirect:/ZamowieniaUser";
            }



        }
}}
