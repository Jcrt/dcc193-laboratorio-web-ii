package br.ufjf.dcc193.exm03.DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.ufjf.dcc193.exm03.Entities.Usuario;

@Repository
public class UsuarioDAO implements IUsuarioDAO {

  static String countSql = "SELECT COUNT(1) FROM usuario";
  static String selectAllSql = "SELECT * FROM usuario";
  static String insertOneSql = "INSERT INTO usuario(username, fullname, password, birthday, pets, status, role) " +
    "VALUES(?, ?, ?, ?, ?, ?, ?)";


  @Autowired
  JdbcTemplate jdbc;

  @Override
  public int count() throws DataAccessException {
    return jdbc.queryForObject(countSql, Integer.class);
  }

  @Override
  public int insertOne(Usuario usuario) throws DataAccessException {
    jdbc.update(insertOneSql, 
      usuario.getUsermail(), 
      usuario.getFullname(), 
      usuario.getPassword(), 
      usuario.getBirthday(),
      usuario.getPets(), 
      usuario.getStatus(), 
      usuario.getRole()
    );
    return 0;
  }

  @Override
  public Usuario selectOne(String username) throws DataAccessException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int updateOne(Usuario usuario) throws DataAccessException {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int deleteOne(Usuario usuario) throws DataAccessException {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public List<Usuario> selectAll() throws DataAccessException {
    List<Usuario> usuarios = new ArrayList<>();
    List<Map<String, Object>> resultados = jdbc.queryForList(selectAllSql);

    resultados.forEach(item -> {
      Usuario u = new Usuario();
      u.setUsermail((String)item.get("username"));
      u.setFullname((String)item.get("fullname"));
      u.setPassword((String)item.get("password")); 
      u.setBirthday((Date)item.get("birthday"));
      u.setPets((Integer)item.get("pets"));
      u.setStatus((Boolean)item.get("status")); 
      u.setRole((String)item.get("role"));

      usuarios.add(u);
    });

    return usuarios;
  }
}
