/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package AnalizadorSintactico;

import AnalizadorLexico.Token;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author TV
 */
public class AnalizadorSintactico {

    String codigo;
    StringTokenizer cadena;
    ArrayList<String> tokens = new ArrayList<String>();
    ArrayList<Token> alt=new ArrayList<Token>();
   

    public void separar(String txt){

        String palabras = "";
        codigo = txt;
        cadena = new StringTokenizer(codigo);
        while(cadena.hasMoreTokens()){
            tokens.add(cadena.nextToken());
        }
        tokens.add("$");
       
        /*for(int i =0; i<tokens.size();i++){
            palabras = palabras +(" palabra "+ i +": "+ tokens.get(i)+"\n");
        }*/
    
    }

    

}
