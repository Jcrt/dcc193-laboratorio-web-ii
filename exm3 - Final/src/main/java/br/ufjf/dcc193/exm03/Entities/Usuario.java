package br.ufjf.dcc193.exm03.Entities;

import java.util.Date;

import lombok.Data;

@Data
public class Usuario {
  String usermail;
  String fullname;
  String password;
  Integer pets;
  Date birthday;
  Boolean status;
  String role;
}
