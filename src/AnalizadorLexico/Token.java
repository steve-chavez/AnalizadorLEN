/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package AnalizadorLexico;

/**
 *
 * @author TV
 */
public class Token {

 private String nombre;
 private int numero;
 private String info;
 private int estado;

 public Token(){}

 public Token(int num,String i,int e){
  this.numero=num;
  this.info=i;
  this.estado=e;
 }

 public Token(String n,int e){
  this.nombre=n;
  this.estado=e;
 }

 public Token(int num,String i,String n,int e){
  this.numero=num;
  this.info=i;
  this.nombre=n;
  this.estado=e;
 }

 public String getInfo(){
  return info;
 }

 public void setInfo(String i){
  this.info=i;
 }

 public int getNumero(){
  return numero;
 }

 public void setNumero(int num){
  this.numero=num;
 }

 public int getEstado(){
  return estado;
 }

 public void setEstado(int e){
  this.estado=e;
 }

 public String getNombre() {
  return nombre;
 }

 public void setNombre(String nombre) {
  this.nombre = nombre;
 }

}
