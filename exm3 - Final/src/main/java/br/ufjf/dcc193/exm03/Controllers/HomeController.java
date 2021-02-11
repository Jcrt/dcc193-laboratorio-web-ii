package br.ufjf.dcc193.exm03.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.ufjf.dcc193.exm03.Entities.Usuario;
import br.ufjf.dcc193.exm03.Services.UsuarioService;

@Controller
public class HomeController {
  
  @Autowired
  UsuarioService usuarioService;

  @GetMapping("/home")
  public String getHome(Model model){
    model.addAttribute("conteudo", "login/home::conteudo");
    return "login/defaultLayout";
  }

  @GetMapping("/usuarios")
  public String getUsuarios(Model model){
    List<Usuario> usuarios = usuarioService.getAll();

    model.addAttribute("conteudo", "login/usuarios::conteudo");
    model.addAttribute("usuarios", usuarios);
    
    return "login/defaultLayout";
  }

  @GetMapping("/detalhes")
  public String getDetalhes(Model model){
    model.addAttribute("conteudo", "login/detalhes::conteudo");
    return "login/defaultLayout";
  }
}
