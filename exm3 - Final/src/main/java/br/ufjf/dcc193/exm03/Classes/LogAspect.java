package br.ufjf.dcc193.exm03.Classes;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

  @Around("execution(* *..*.*Controller.*(..))")
  public Object doLog(ProceedingJoinPoint joinpoint) throws Throwable{

    System.out.println("Método iniciado: " + joinpoint.getSignature());
    
    try {
      Object retorno = joinpoint.proceed();
      System.out.println("Método finalizado: " + joinpoint.getSignature());
      return retorno;  
    } catch (Exception e) {
      System.out.println("Método interrompido: " + joinpoint.getSignature());
      e.printStackTrace();
      throw e;
    }
  }

  @Around("execution(* *..*.*DAO*.*(..))")
  public Object doDAOLog(ProceedingJoinPoint joinpoint) throws Throwable{

    System.out.println("Método iniciado: " + joinpoint.getSignature());
    
    try {
      Object retorno = joinpoint.proceed();
      System.out.println("Método finalizado: " + joinpoint.getSignature());
      return retorno;  
    } catch (Exception e) {
      System.out.println("Método interrompido: " + joinpoint.getSignature());
      e.printStackTrace();
      throw e;
    }
  }
}
