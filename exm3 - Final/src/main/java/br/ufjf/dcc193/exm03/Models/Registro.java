package br.ufjf.dcc193.exm03.Models;

import java.util.Date;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Registro {
  @NotBlank
  @Email
  String usermail;

  @NotBlank
  String fullname;

  @NotBlank
  @Pattern(regexp = "^[a-zA-Z0-9]+$")
  String password;

  @NotBlank
  @Pattern(regexp = "^[a-zA-Z0-9]+$")
  String password2;

  @Min(0)
  @Max(20)
  Integer pets;

  @NotNull
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  Date birthday;

  @AssertTrue
  Boolean status;
}
