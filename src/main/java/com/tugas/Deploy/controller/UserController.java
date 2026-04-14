package com.tugas.Deploy.controller;

import com.tugas.Deploy.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private List<User> dataMahasiswa = new ArrayList<>();

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String username, @RequestParam String password, Model model) {
        // Mengubah username dan password sesuai request kamu
        if ("Haris".equals(username) && "20230140235".equals(password)) {
            return "redirect:/home";
        }
        model.addAttribute("error", "Username atau Password salah!");
        return "login";
    }

    @GetMapping({"/", "/home"})
    public String showHome(Model model) {
        model.addAttribute("mahasiswaList", dataMahasiswa);
        return "home";
    }

    @GetMapping("/form")
    public String showForm() {
        return "form";
    }

    @PostMapping("/form")
    public String processForm(@RequestParam String nama, @RequestParam String nim, @RequestParam String jenisKelamin) {
        dataMahasiswa.add(new User(nama, nim, jenisKelamin));
        return "redirect:/home";
    }
}