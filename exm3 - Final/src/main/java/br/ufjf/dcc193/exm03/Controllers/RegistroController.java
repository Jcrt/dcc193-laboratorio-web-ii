package br.ufjf.dcc193.exm03.Controllers;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.ufjf.dcc193.exm03.Entities.Usuario;
import br.ufjf.dcc193.exm03.Models.Registro;
import br.ufjf.dcc193.exm03.Services.UsuarioService;

@Controller
public class RegistroController {

  @Autowired
  UsuarioService usuarioService;

  @GetMapping("/registro")
  public String getRegistro(@ModelAttribute Registro dados, Model model){
    Map<String, String> status = new LinkedHashMap();
    status.put("Estudante", "true");
    status.put("Profissional", "false");
    model.addAttribute("status", status);
    return "login/registro";
  }
  
  @PostMapping("/registro")
  public String postRegistro(@ModelAttribute @Validated Registro dados, BindingResult bindingResult, Model model){
    if(bindingResult.hasErrors()){
      return getRegistro(dados, model);
    } 
    else {
      Usuario usuario = new Usuario();
      usuario.setBirthday(dados.getBirthday());
      usuario.setFullname(dados.getFullname());
      usuario.setPassword(dados.getPassword());
      usuario.setPets(dados.getPets());
      usuario.setStatus(dados.getStatus());
      usuario.setUsermail(dados.getUsermail());
      usuario.setRole("COMUM");
      
      if(usuarioService.insert(usuario)){
        return "redirect:home";
      }

      return "redirect:login";
    }
  }
}
