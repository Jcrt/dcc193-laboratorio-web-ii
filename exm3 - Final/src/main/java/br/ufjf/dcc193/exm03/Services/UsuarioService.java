package br.ufjf.dcc193.exm03.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufjf.dcc193.exm03.DAO.IUsuarioDAO;
import br.ufjf.dcc193.exm03.Entities.Usuario;

@Service
public class UsuarioService {
  @Autowired
  IUsuarioDAO dao;

  public boolean insert(Usuario usuario){
    int n = dao.insertOne(usuario);
    return n > 0;
  }

  public List<Usuario> getAll(){
    return dao.selectAll();
  }
}
