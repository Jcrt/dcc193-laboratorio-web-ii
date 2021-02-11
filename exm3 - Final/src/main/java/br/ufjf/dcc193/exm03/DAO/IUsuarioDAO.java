package br.ufjf.dcc193.exm03.DAO;

import java.util.List;

import org.springframework.dao.DataAccessException;

import br.ufjf.dcc193.exm03.Entities.Usuario;

public interface IUsuarioDAO {
  public int count() throws DataAccessException;
  public int insertOne(Usuario usuario) throws DataAccessException;
  public Usuario selectOne(String username) throws DataAccessException;
  public int updateOne(Usuario usuario) throws DataAccessException;
  public int deleteOne(Usuario usuario) throws DataAccessException;
  public List<Usuario> selectAll() throws DataAccessException;
}
