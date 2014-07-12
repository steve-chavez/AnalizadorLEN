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
public class AutomataLEN {

 private Tabladesimbolos tds;
 private ArrayList<Token> altokens;
 private int estado;
 private String aux="";
 private char[] letras={'a','b','c','d','e','f','g','h','i','j','k','l','m',
 'n','ñ','o','p','q','r','s','t','u','v','w','x','y','z',
 'A','B','C','D','E','F','G','H','I','J','K','L','M','N','Ñ','O','P','Q','R',
 'S','T','U','V','W','X','Y','Z','_'};// '_' también se considera una letra.
 private char[] numeros={'0','1','2','3','4','5','6','7','8','9'};
 private char[] operadores={'+','-','*','/','&','|','^','=','!','<','>','%'};
 private char[] delimitadores={',',';',':','{','}','(',')','[',']'};

 public AutomataLEN(){
  estado=0;
  altokens=new ArrayList<Token>();
  tds=new Tabladesimbolos();
 }

 private boolean i(char c){
  if(c=='\n')
   return true;
  else
   return false;
 }

 private boolean d(char c){
  boolean b=false;
   for(int i=0;i<9;i++){
    if(c==delimitadores[i]){
     b=true;
     i=9;
    }
   }
 return b;
 }

 private boolean e(char c){
  if(c==' ')
   return true;
  else
   return false;
 }

 private boolean l(char c){
  boolean b=false;
   for(int i=0;i<55;i++){
    if(c==letras[i]){
     b=true;
     i=55;
    }
   }
 return b;
 }

 private boolean n(char c){
  boolean b=false;
   for(int i=0;i<10;i++){
    if(c==numeros[i]){
     b=true;
     i=10;
    }
   }
 return b;
 }

 private boolean o(char c){
  boolean b=false;
   for(int i=0;i<12;i++){
    if(c==operadores[i]){
     b=true;
     i=12;
    }
   }
 return b;
 }

 public void reconocer(String st){
  String s=st+"\n";
  char c=' ';
  for(int i=0;i<s.length();i++){
   c=s.charAt(i);
   switch(estado){
    case 0:
     if(i(c)){
      estado=0;
     }
     else if(d(c)){
      getAltokens().add(new Token(""+c,0));
      aux="";
      estado=0;
     }
     else if(e(c)){
      estado=0;
     }
     else if(l(c)){
      aux=aux+c;     
      estado=1;
     }
     else if(n(c)){
      aux=aux+c;     
      estado=2;
     }
     else if(o(c)){
      aux=aux+c;    
      estado=10;
     }
     else if(c=='\"'){
      aux=aux+c;   
      estado=4;
     }
     else if(c=='\''){
      aux=aux+c;   
      estado=7;
     }
     else if(c=='.'){
      getAltokens().add(new Token(""+c,13));
      aux="";
      estado=13;
     }
     else if(c=='#'){
      aux=aux+c;   
      estado=15;
     }
     else{
      getAltokens().add(new Token(""+c,20));
      aux="";
      estado=20;//El resto de caracteres(C).
     }
    break;
    case 1:
     if(i(c)){
      getAltokens().add(new Token(600,"Identificador",aux,1));
      if(!getTds().getHmtabla().containsKey(aux))
       getTds().InsertarIdentificador(aux);
      aux="";
      estado=0;
     }
     else if(d(c)){
      getAltokens().add(new Token(600,"Identificador",aux,1));
      if(!getTds().getHmtabla().containsKey(aux))
       getTds().InsertarIdentificador(aux);
      getAltokens().add(new Token(""+c,0));
      aux="";
      estado=0;
     }
     else if(e(c)){
      getAltokens().add(new Token(600,"Identificador",aux,1));
      if(!getTds().getHmtabla().containsKey(aux))
       getTds().InsertarIdentificador(aux);
      aux="";   
      estado=0;
     }
     else if(l(c)){
      aux=aux+c;   
      estado=1;
     }
     else if(n(c)){
      aux=aux+c;   
      estado=1;
     }
     else if(o(c)){
      getAltokens().add(new Token(600,"Identificador",aux,1));
      if(!getTds().getHmtabla().containsKey(aux))
       getTds().InsertarIdentificador(aux);
      aux="";
      aux=aux+c;
      estado=10;
     }
     else if(c=='\"'){
      getAltokens().add(new Token(600,"Identificador",aux,1));
      if(!getTds().getHmtabla().containsKey(aux))
       getTds().InsertarIdentificador(aux);
      aux="";
      aux=aux+c;   
      estado=4;
     }
     else if(c=='\''){
      getAltokens().add(new Token(600,"Identificador",aux,1));
      if(!getTds().getHmtabla().containsKey(aux))
       getTds().InsertarIdentificador(aux);
      aux="";
      aux=aux+c;   
      estado=7;
     }
     else if(c=='.'){
      getAltokens().add(new Token(600,"Identificador",aux,1));
      if(!getTds().getHmtabla().containsKey(aux))
       getTds().InsertarIdentificador(aux);
      getAltokens().add(new Token(""+c,13));
      aux="";
      estado=13;
     }
     else if(c=='#'){
      getAltokens().add(new Token(600,"Identificador",aux,1));
      if(!getTds().getHmtabla().containsKey(aux))
       getTds().InsertarIdentificador(aux);
      aux="";
      aux=aux+c;   
      estado=15;
     }
     else{
      getAltokens().add(new Token(600,"Identificador",aux,1));
      if(!getTds().getHmtabla().containsKey(aux))
       getTds().InsertarIdentificador(aux);
      getAltokens().add(new Token(""+c,20));
      aux="";   
      estado=20;//El resto de caracteres(C).
     }
    break;
    case 2:
     if(i(c)){
      getAltokens().add(new Token(500,"Numero",aux,2));
      getTds().InsertarNumero(aux);
      aux="";
      estado=0;
     }
     else if(d(c)){
      getAltokens().add(new Token(500,"Numero",aux,2));
      getTds().InsertarNumero(aux);
      getAltokens().add(new Token(""+c,0));
      aux="";   
      estado=0;
     }
     else if(e(c)){
      getAltokens().add(new Token(500,"Numero",aux,2));
      getTds().InsertarNumero(aux);
      aux="";   
      estado=0;
     }
     else if(l(c)){
      getAltokens().add(new Token(500,"Numero",aux,2));
      getTds().InsertarNumero(aux);
      aux="";
      aux=aux+c;
      estado=1;
     }
     else if(n(c)){
      aux=aux+c;   
      estado=2;
     }
     else if(o(c)){
      getAltokens().add(new Token(500,"Numero",aux,2));
      getTds().InsertarNumero(aux);
      aux="";
      aux=aux+c;
      estado=10;
     }
     else if(c=='\"'){
      getAltokens().add(new Token(500,"Numero",aux,2));
      getTds().InsertarNumero(aux);
      aux="";
      aux=aux+c;
      estado=4;
     }
     else if(c=='\''){
      getAltokens().add(new Token(500,"Numero",aux,2));
      getTds().InsertarNumero(aux);
      aux="";
      aux=aux+c;   
      estado=7;
     }
     else if(c=='.'){
      aux=aux+c;   
      estado=3;
     }
     else if(c=='#'){
      getAltokens().add(new Token(500,"Numero",aux,2));
      getTds().InsertarNumero(aux);
      aux="";
      aux=aux+c;    
      estado=15;
     }
     else{
      getAltokens().add(new Token(500,"Numero",aux,2));
      getTds().InsertarNumero(aux);
      getAltokens().add(new Token(""+c,20));
      aux="";
      estado=20;//El resto de caracteres(C).
     }
    break;
    case 3:
     if(i(c)){
      getAltokens().add(new Token(500,"Numero",aux,3));
      getTds().InsertarNumero(aux);
      aux="";
      estado=0;
     }
     else if(d(c)){
      getAltokens().add(new Token(500,"Numero",aux,3));
      getTds().InsertarNumero(aux);
      getAltokens().add(new Token(""+c,0));
      aux="";
      estado=0;
     }
     else if(e(c)){
      getAltokens().add(new Token(500,"Numero",aux,3));
      getTds().InsertarNumero(aux);
      aux="";   
      estado=0;
     }
     else if(l(c)){
      getAltokens().add(new Token(500,"Numero",aux,3));
      getTds().InsertarNumero(aux);
      aux="";
      aux=aux+c;
      estado=1;
     }
     else if(n(c)){
      aux=aux+c;   
      estado=3;
     }
     else if(o(c)){
      getAltokens().add(new Token(500,"Numero",aux,3));
      getTds().InsertarNumero(aux);
      aux="";
      aux=aux+c;
      estado=10;
     }
     else if(c=='\"'){
      getAltokens().add(new Token(500,"Numero",aux,3));
      getTds().InsertarNumero(aux);
      aux="";
      aux=aux+c;
      estado=4;
     }
     else if(c=='\''){
      getAltokens().add(new Token(500,"Numero",aux,3));
      getTds().InsertarNumero(aux);
      aux="";
      aux=aux+c;   
      estado=7;
     }
     else if(c=='.'){
      getAltokens().add(new Token(500,"Numero",aux,3));
      getTds().InsertarNumero(aux);
      getAltokens().add(new Token(""+c,13));
      aux="";   
      estado=13;
     }
     else if(c=='#'){
      getAltokens().add(new Token(500,"Numero",aux,3));
      getTds().InsertarNumero(aux);
      aux="";
      aux=aux+c;
      estado=15;
     }
     else{
      getAltokens().add(new Token(500,"Numero",aux,3));
      getTds().InsertarNumero(aux);
      aux="";
      aux=aux+c;
      getAltokens().add(new Token(""+c,20));
      estado=20;//El resto de caracteres(C).
     }
    break;
    case 4:
     if(i(c)){
      getAltokens().add(new Token(aux,6));
      aux="";
      estado=6;
     }
     else if(d(c)){
      aux=aux+c;
      estado=4;
     }
     else if(e(c)){
      aux=aux+c;
      estado=4;
     }
     else if(l(c)){
      aux=aux+c;
      estado=4;
     }
     else if(n(c)){
      aux=aux+c;
      estado=4;
     }
     else if(o(c)){
      aux=aux+c;
      estado=4;
     }
     else if(c=='\"'){
      aux=aux+c;
      getAltokens().add(new Token(800,"Cadena",aux,5));
      getTds().InsertarCadena(aux);
      aux="";
      estado=5;
     }
     else if(c=='\''){
      aux=aux+c;
      estado=4;
     }
     else if(c=='.'){
      aux=aux+c;
      estado=4;
     }
     else if(c=='#'){
      aux=aux+c;
      estado=4;
     }
     else{
      aux=aux+c;
      estado=4;//El resto de caracteres(C).
     }
    break;
    case 5:
     if(i(c)){
      estado=0;
     }
     else if(d(c)){
      getAltokens().add(new Token(""+c,0));
      aux="";
      estado=0;
     }
     else if(e(c)){
      estado=0;
     }
     else if(l(c)){
      aux=aux+c;
      estado=1;
     }
     else if(n(c)){
      aux=aux+c;
      estado=2;
     }
     else if(o(c)){
      aux=aux+c;
      estado=10;
     }
     else if(c=='\"'){
      aux=aux+c;
      estado=4;
     }
     else if(c=='\''){
      aux=aux+c;
      estado=7;
     }
     else if(c=='.'){
      getAltokens().add(new Token(""+c,13));
      aux="";
      estado=13;
     }
     else if(c=='#'){
      aux=aux+c;
      estado=15;
     }
     else{
      getAltokens().add(new Token(""+c,20));
      aux="";
      estado=20;//El resto de caracteres(C).
     }
    break;
    case 6:
     if(i(c)){
      estado=0;
     }
     else if(d(c)){
      getAltokens().add(new Token(""+c,0));
      aux="";
      estado=0;
     }
     else if(e(c)){
      estado=0;
     }
     else if(l(c)){
      aux=aux+c;
      estado=1;
     }
     else if(n(c)){
      aux=aux+c;
      estado=2;
     }
     else if(o(c)){
      aux=aux+c;
      estado=10;
     }
     else if(c=='\"'){
      aux=aux+c;
      estado=4;
     }
     else if(c=='\''){
      aux=aux+c;
      estado=7;
     }
     else if(c=='.'){
      getAltokens().add(new Token(""+c,13));
      aux="";
      estado=13;
     }
     else if(c=='#'){
      aux=aux+c;
      estado=15;
     }
     else{
      getAltokens().add(new Token(""+c,20));
      aux="";
      estado=20;//El resto de caracteres(C).
     }
    break;
    case 7:
     if(i(c)){
      getAltokens().add(new Token(aux,14));
      aux="";
      estado=14;
     }
     else if(d(c)){
      aux=aux+c;
      estado=8;
     }
     else if(e(c)){
      aux=aux+c;
      estado=8;
     }
     else if(l(c)){
      aux=aux+c;
      estado=8;
     }
     else if(n(c)){
      aux=aux+c;
      estado=8;
     }
     else if(o(c)){
      aux=aux+c;
      estado=8;
     }
     else if(c=='\"'){
      aux=aux+c;
      estado=8;
     }
     else if(c=='\''){
      getAltokens().add(new Token(aux,14));
      aux="";
      estado=14;
     }
     else if(c=='.'){
      aux=aux+c;
      estado=8;
     }
     else if(c=='#'){
      aux=aux+c;
      estado=8;
     }
     else{
      aux=aux+c;
      estado=8;//El resto de caracteres(C).
     }
    break;
    case 8:
     if(i(c)){
      getAltokens().add(new Token(aux,14));
      aux="";
      estado=14;
     }
     else if(d(c)){
      aux=aux+c;
      getAltokens().add(new Token(aux,14));
      aux="";
      estado=14;
     }
     else if(e(c)){
      aux=aux+c;
      getAltokens().add(new Token(aux,14));
      aux="";
      estado=14;
     }
     else if(l(c)){
      aux=aux+c;
      getAltokens().add(new Token(aux,14));
      aux="";
      estado=14;
     }
     else if(n(c)){
      aux=aux+c;
      getAltokens().add(new Token(aux,14));
      aux="";
      estado=14;
     }
     else if(o(c)){
      aux=aux+c;
      getAltokens().add(new Token(aux,14));
      aux="";
      estado=14;
     }
     else if(c=='\"'){
      aux=aux+c;
      getAltokens().add(new Token(aux,14));
      aux="";
      estado=14;
     }
     else if(c=='\''){
      aux=aux+c;
      getAltokens().add(new Token(700,"Caracter",aux,9));
      getTds().InsertarCaracter(aux);
      aux="";
      estado=9;
     }
     else if(c=='.'){
      aux=aux+c;
      getAltokens().add(new Token(aux,14));
      aux="";
      estado=14;
     }
     else if(c=='#'){
      aux=aux+c;
      getAltokens().add(new Token(aux,14));
      aux="";
      estado=14;
     }
     else{
      aux=aux+c;
      getAltokens().add(new Token(aux,14));
      aux="";
      estado=20;//El resto de caracteres(C).
     }
    break;
    case 9:
     if(i(c)){
      estado=0;
     }
     else if(d(c)){
      getAltokens().add(new Token(""+c,0));
      aux="";
      estado=0;
     }
     else if(e(c)){
      estado=0;
     }
     else if(l(c)){
      aux=aux+c;
      estado=1;
     }
     else if(n(c)){
      aux=aux+c;
      estado=2;
     }
     else if(o(c)){
      aux=aux+c;
      estado=10;
     }
     else if(c=='\"'){
      aux=aux+c;
      estado=4;
     }
     else if(c=='\''){
      aux=aux+c;
      estado=7;
     }
     else if(c=='.'){
      getAltokens().add(new Token(""+c,13));
      aux="";
      estado=13;
     }
     else if(c=='#'){
      aux=aux+c;
      estado=15;
     }
     else{
      getAltokens().add(new Token(""+c,20));
      aux="";
      estado=20;//El resto de caracteres(C).
     }
    break;
    case 10:
     if(i(c)){
      getAltokens().add(new Token(aux,10));
      aux="";
      estado=0;
     }
     else if(d(c)){
      getAltokens().add(new Token(aux,10));
      getAltokens().add(new Token(""+c,0));
      aux="";
      estado=0;
     }
     else if(e(c)){
      getAltokens().add(new Token(aux,10));
      aux="";
      estado=0;
     }
     else if(l(c)){
      getAltokens().add(new Token(aux,10));
      aux="";
      aux=aux+c;
      estado=1;
     }
     else if(n(c)){
      getAltokens().add(new Token(aux,10));
      aux="";
      aux=aux+c;
      estado=2;
     }
     else if(o(c)){
      aux=aux+c;
      estado=11;
     }
     else if(c=='\"'){
      getAltokens().add(new Token(aux,10));
      aux="";
      aux=aux+c;
      estado=4;
     }
     else if(c=='\''){
      getAltokens().add(new Token(aux,10));
      aux="";
      aux=aux+c;
      estado=7;
     }
     else if(c=='.'){
      getAltokens().add(new Token(aux,10));
      getAltokens().add(new Token(""+c,13));
      aux="";
      estado=13;
     }
     else if(c=='#'){
      getAltokens().add(new Token(aux,10));
      aux="";
      aux=aux+c;
      estado=15;
     }
     else{
      getAltokens().add(new Token(aux,10));
      getAltokens().add(new Token(""+c,20));
      aux="";
      estado=20;//El resto de caracteres(C).
     }
    break;
    case 11:
     if(i(c)){
      getAltokens().add(new Token(aux,11));
      aux="";
      estado=0;
     }
     else if(d(c)){
      getAltokens().add(new Token(aux,11));
      getAltokens().add(new Token(""+c,0));
      aux="";
      estado=0;
     }
     else if(e(c)){
      getAltokens().add(new Token(aux,11));
      aux="";
      estado=0;
     }
     else if(l(c)){
      getAltokens().add(new Token(aux,11));
      aux="";
      aux=aux+c;
      estado=1;
     }
     else if(n(c)){
      getAltokens().add(new Token(aux,11));
      aux="";
      aux=aux+c;
      estado=2;
     }
     else if(o(c)){
      aux=aux+c;
      estado=12;
     }
     else if(c=='\"'){
      getAltokens().add(new Token(aux,11));
      aux="";
      aux=aux+c;
      estado=4;
     }
     else if(c=='\''){
      getAltokens().add(new Token(aux,11));
      aux="";
      aux=aux+c;
      estado=7;
     }
     else if(c=='.'){
      getAltokens().add(new Token(aux,11));
      getAltokens().add(new Token(""+c,13));
      aux="";
      estado=13;
     }
     else if(c=='#'){
      getAltokens().add(new Token(aux,11));
      aux="";
      aux=aux+c;
      estado=15;
     }
     else{
      getAltokens().add(new Token(aux,11));
      getAltokens().add(new Token(""+c,20));
      aux="";
      estado=20;//El resto de caracteres(C).
     }
    break;
    case 12:
     if(i(c)){
      getAltokens().add(new Token(aux,12));
      aux="";
      estado=0;
     }
     else if(d(c)){
      getAltokens().add(new Token(aux,12));
      getAltokens().add(new Token(""+c,0));
      aux="";
      estado=0;
     }
     else if(e(c)){
      getAltokens().add(new Token(aux,12));
      aux="";
      estado=0;
     }
     else if(l(c)){
      getAltokens().add(new Token(aux,12));
      aux="";
      aux=aux+c;
      estado=1;
     }
     else if(n(c)){
      getAltokens().add(new Token(aux,12));
      aux="";
      aux=aux+c;
      estado=2;
     }
     else if(o(c)){
      aux=aux+c;
      estado=12;
     }
     else if(c=='\"'){
      getAltokens().add(new Token(aux,12));
      aux="";
      aux=aux+c;
      estado=4;
     }
     else if(c=='\''){
      getAltokens().add(new Token(aux,12));
      aux="";
      aux=aux+c;
      estado=7;
     }
     else if(c=='.'){
      getAltokens().add(new Token(aux,12));
      getAltokens().add(new Token(""+c,13));
      aux="";
      estado=13;
     }
     else if(c=='#'){
      getAltokens().add(new Token(aux,12));
      aux="";
      aux=aux+c;
      estado=15;
     }
     else{
      getAltokens().add(new Token(aux,12));
      getAltokens().add(new Token(""+c,20));
      aux="";
      estado=20;//El resto de caracteres(C).
     }
    break;
    case 13:
     if(i(c)){
      estado=0;
     }
     else if(d(c)){
      getAltokens().add(new Token(""+c,0));
      aux="";
      estado=0;
     }
     else if(e(c)){
      estado=0;
     }
     else if(l(c)){
      aux=aux+c;
      estado=1;
     }
     else if(n(c)){
      aux=aux+c;
      estado=2;
     }
     else if(o(c)){
      aux=aux+c;
      estado=10;
     }
     else if(c=='\"'){
      aux=aux+c;
      estado=4;
     }
     else if(c=='\''){
      aux=aux+c;
      estado=7;
     }
     else if(c=='.'){
      getAltokens().add(new Token(""+c,13));
      aux="";
      estado=13;
     }
     else if(c=='#'){
      aux=aux+c;
      estado=15;
     }
     else{
      getAltokens().add(new Token(""+c,20));
      aux="";
      estado=20;//El resto de caracteres(C).
     }
    break;
    case 14:
     if(i(c)){
      getAltokens().add(new Token(aux,14));
      aux="";
      estado=0;
     }
     else if(d(c)){
      aux=aux+c;
      estado=14;
     }
     else if(e(c)){
      aux=aux+c;
      estado=14;
     }
     else if(l(c)){
      aux=aux+c;
      estado=14;
     }
     else if(n(c)){
      aux=aux+c;
      estado=14;
     }
     else if(o(c)){
      aux=aux+c;
      estado=14;
     }
     else if(c=='\"'){
      aux=aux+c;
      estado=14;
     }
     else if(c=='\''){
      getAltokens().add(new Token(aux,14));
      aux="";
      estado=0;
     }
     else if(c=='.'){
      aux=aux+c;
      estado=14;
     }
     else if(c=='#'){
      aux=aux+c;
      estado=14;
     }
     else{
      aux=aux+c;
      estado=14;//El resto de caracteres(C).
     }
    break;
    case 15:
     if(i(c)){
      getAltokens().add(new Token(aux,19));
      aux="";
      estado=19;
     }
     else if(d(c)){
      aux=aux+c;
      getAltokens().add(new Token(aux,19));
      aux="";
      estado=19;
     }
     else if(e(c)){
      aux=aux+c;
      getAltokens().add(new Token(aux,19));
      aux="";
      estado=19;
     }
     else if(l(c)){
      aux=aux+c;
      getAltokens().add(new Token(aux,19));
      aux="";
      estado=19;
     }
     else if(n(c)){
      aux=aux+c;
      getAltokens().add(new Token(aux,19));
      aux="";
      estado=19;
     }
     else if(o(c)){
      aux=aux+c;
      getAltokens().add(new Token(aux,19));
      aux="";
      estado=19;
     }
     else if(c=='\"'){
      aux=aux+c;
      getAltokens().add(new Token(aux,19));
      aux="";
      estado=19;
     }
     else if(c=='\''){
      aux=aux+c;
      getAltokens().add(new Token(aux,19));
      aux="";
      estado=19;
     }
     else if(c=='.'){
      aux=aux+c;
      getAltokens().add(new Token(aux,19));
      aux="";
      estado=19;
     }
     else if(c=='#'){
      aux=aux+c;
      estado=16;
     }
     else{
      aux=aux+c;
      getAltokens().add(new Token(aux,19));
      aux="";
      estado=19;//El resto de caracteres(C).
     }
    break;
    case 16:
     if(i(c)){
      getAltokens().add(new Token(aux,19));
      aux="";
      estado=19;
     }
     else if(d(c)){
      aux=aux+c;
      estado=16;
     }
     else if(e(c)){
      aux=aux+c;
      estado=16;
     }
     else if(l(c)){
      aux=aux+c;
      estado=16;
     }
     else if(n(c)){
      aux=aux+c;
      estado=16;
     }
     else if(o(c)){
      aux=aux+c;
      estado=16;
     }
     else if(c=='\"'){
      aux=aux+c;
      estado=16;
     }
     else if(c=='\''){
      aux=aux+c;
      estado=16;
     }
     else if(c=='.'){
      aux=aux+c;
      estado=16;
     }
     else if(c=='#'){
      aux=aux+c;
      estado=17;
     }
     else{
      aux=aux+c;
      estado=16;//El resto de caracteres(C).
     }
    break;
    case 17:
     if(i(c)){
      getAltokens().add(new Token(aux,19));
      aux="";
      estado=19;
     }
     else if(d(c)){
      aux=aux+c;
      getAltokens().add(new Token(aux,19));
      aux="";
      estado=19;
     }
     else if(e(c)){
      aux=aux+c;
      getAltokens().add(new Token(aux,19));
      aux="";
      estado=19;
     }
     else if(l(c)){
      aux=aux+c;
      getAltokens().add(new Token(aux,19));
      aux="";
      estado=19;
     }
     else if(n(c)){
      aux=aux+c;
      getAltokens().add(new Token(aux,19));
      aux="";
      estado=19;
     }
     else if(o(c)){
      aux=aux+c;
      getAltokens().add(new Token(aux,19));
      aux="";
      estado=19;
     }
     else if(c=='\"'){
      aux=aux+c;
      getAltokens().add(new Token(aux,19));
      aux="";
      estado=19;
     }
     else if(c=='\''){
      aux=aux+c;
      getAltokens().add(new Token(aux,19));
      aux="";
      estado=19;
     }
     else if(c=='.'){
      aux=aux+c;
      getAltokens().add(new Token(aux,19));
      aux="";
      estado=19;
     }
     else if(c=='#'){
      aux=aux+c;
      getAltokens().add(new Token(aux,18));
      getTds().InsertarComentario(aux);
      aux="";
      estado=18;
     }
     else{
      aux=aux+c;
      getAltokens().add(new Token(aux,19));
      aux="";
      estado=19;//El resto de caracteres(C).
     }
    break;
    case 18:
     if(i(c)){
      estado=0;
     }
     else if(d(c)){
      getAltokens().add(new Token(""+c,0));
      estado=0;
     }
     else if(e(c)){
      estado=0;
     }
     else if(l(c)){
      aux=aux+c;
      estado=1;
     }
     else if(n(c)){
      aux=aux+c;
      estado=2;
     }
     else if(o(c)){
      aux=aux+c;
      estado=10;
     }
     else if(c=='\"'){
      aux=aux+c;
      estado=4;
     }
     else if(c=='\''){
      aux=aux+c;
      estado=7;
     }
     else if(c=='.'){
      getAltokens().add(new Token(""+c,13));
      aux="";
      estado=13;
     }
     else if(c=='#'){
      aux=aux+c;
      estado=15;
     }
     else{
      getAltokens().add(new Token(""+c,20));
      aux="";
      estado=20;//El resto de caracteres(C).
     }
    break;
    case 19:
     if(i(c)){
      estado=0;
     }
     else if(d(c)){
      getAltokens().add(new Token(""+c,0));
      aux="";
      estado=0;
     }
     else if(e(c)){
      estado=0;
     }
     else if(l(c)){
      aux=aux+c;
      estado=1;
     }
     else if(n(c)){
      aux=aux+c;
      estado=2;
     }
     else if(o(c)){
      aux=aux+c;
      estado=10;
     }
     else if(c=='\"'){
      aux=aux+c;
      estado=4;
     }
     else if(c=='\''){
      aux=aux+c;
      estado=7;
     }
     else if(c=='.'){
      getAltokens().add(new Token(""+c,13));
      aux="";
      estado=13;
     }
     else if(c=='#'){
      aux=aux+c;
      estado=15;
     }
     else{
      getAltokens().add(new Token(""+c,20));
      aux="";
      estado=20;//El resto de caracteres(C).
     }
    break;
    case 20:
     if(i(c)){
      estado=0;
     }
     else if(d(c)){
      getAltokens().add(new Token(""+c,0));
      aux="";
      estado=0;
     }
     else if(e(c)){
      estado=0;
     }
     else if(l(c)){
      aux=aux+c;
      estado=1;
     }
     else if(n(c)){
      aux=aux+c;
      estado=2;
     }
     else if(o(c)){
      aux=aux+c;
      estado=10;
     }
     else if(c=='\"'){
      aux=aux+c;
      estado=4;
     }
     else if(c=='\''){
      aux=aux+c;
      estado=7;
     }
     else if(c=='.'){
      getAltokens().add(new Token(""+c,13));
      aux="";
      estado=13;
     }
     else if(c=='#'){
      aux=aux+c; 
      estado=15;
     }
     else{
      getAltokens().add(new Token(""+c,20));
      aux="";
      estado=20;//El resto de caracteres(C).
     }
    break;
   }
  }
 }

 public Tabladesimbolos getTds() {
  return tds;
 }

 public void setTds(Tabladesimbolos tds) {
  this.tds = tds;
 }

 public ArrayList<Token> getAltokens() {
  return altokens;
 }

 public void setAltokens(ArrayList<Token> altokens) {
  this.altokens = altokens;
 }

 public void borrar(int i){
  this.altokens.remove(i);
 }
}
