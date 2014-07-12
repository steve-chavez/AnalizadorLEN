/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package AnalizadorLexico;

import java.util.ArrayList;

/**
 *
 * @author TV
 */
public class AnalizadorLexico {

 private AutomataLEN alen;
 private ArrayList<String[]> alstrings;
 private Token taux;
 private Token taux2;
 private String saux1;

 public AnalizadorLexico(){
  alen=new AutomataLEN();
  alstrings=new ArrayList<String[]>();
 }

 public void analizar(String s){

  getAlen().reconocer(s);
  String estado="";
  for(int i=0;i<getAlen().getAltokens().size();i++){
   taux2=getAlen().getAltokens().get(i);
   saux1=taux2.getNombre();
   if(getAlen().getTds().getHmtabla().containsKey(saux1)){
    taux=(Token)getAlen().getTds().getHmtabla().get(saux1);
    if(taux2.getEstado()==0)
     estado="Delimitador";  
    if(taux2.getEstado()==1)
     estado="Identificador/Palabras reservada"; 
    if(taux2.getEstado()==2)
     estado="Numero entero";   
    if(taux2.getEstado()==3)
     estado="Numero real";
    if(taux2.getEstado()==5)
     estado="Cadena";
    if(taux2.getEstado()==9)
     estado="Caracter";
    if(taux2.getEstado()==10)
     estado="Operador simple";
    if(taux2.getEstado()==11)
     estado="Operador doble";
    if(taux2.getEstado()==13)
     estado="Punto/Llamada";
    if(taux2.getEstado()==18){
     estado="Comentario";
     getAlen().borrar(i);
     i--;
    }
    String[] saux2={saux1,""+taux.getNumero(),taux.getInfo(),""+estado};
    getAlstrings().add(saux2);
   }
   else{
    taux=getAlen().getAltokens().get(i);
    if(taux.getEstado()==6)
     estado="Cadena incorrecta";
    if(taux.getEstado()==11||taux.getEstado()==12)
     estado="Operador incorrecto";
    if(taux.getEstado()==14)
     estado="Caracter incorrecto";
    if(taux.getEstado()==19)
     estado="Comentario incorrecto";
    if(taux.getEstado()==20)
     estado="Caracter desconocido";
    String[] saux3={taux.getNombre()," "," ",estado};
    getAlstrings().add(saux3);
    getAlen().borrar(i);
    i--;
   }
  }
 }

 public AutomataLEN getAlen() {
  return alen;
 }

 public void setAlen(AutomataLEN alen) {
  this.alen = alen;
 }

 public ArrayList<String[]> getAlstrings() {
  return alstrings;
 }

 public void setAlstrings(ArrayList<String[]> alstrings) {
  this.alstrings = alstrings;
 }

}
