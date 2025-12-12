package com.hito2.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsuarioController {
	
	@Autowired
    private Environment env;  // Para leer las credenciales desde application.properties

    @GetMapping("/login")
    public String loginPage() {
        return "login";  // login.fxml
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam String user, @RequestParam String pass) {

        // ADMIN
        if (user.equals(env.getProperty("user.admin")) &&
            pass.equals(env.getProperty("user.admin.pass"))) {
            return "redirect:/admin/home";
        }

        // PROFESOR
        if (user.equals(env.getProperty("user.prof")) &&
            pass.equals(env.getProperty("user.prof.pass"))) {
            return "redirect:/profesor/home";
        }

        // CREDENCIALES INCORRECTAS
        return "redirect:/login?error=true";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login";
    }
}

