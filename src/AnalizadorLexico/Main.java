/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package AnalizadorLexico;
import ComponentesSwing.*;
/**
 *
 * @author TV
 */
public class Main {
    public static void main(String[] args){
     String[] sa=new String[4];
     AnalizadorLexico al=new AnalizadorLexico();
     //al.analizar(".¬¬ privado;abc 234 super <= 4.5 ##@d1## @ a.12 '@'\"f¬¬adf123@..*/;\" + ==[]{}; '\n' \\ ads.ff para  ++ ** +-+ -- *= mientras");
     //.¬¬ privado;abc 234 super <= 4.5 ##@d1## @ a.12 '@'"f¬¬adf123@..*/;" + ==[]{}; 'n' \ads.ff para  ++ ** +-+ -- *= mientras //Cadena a insertar
     //for(int i=0;i<al.getAlstrings().size();i++){
      //sa=al.getAlstrings().get(i);
      //System.out.println(sa[0]+" "+sa[1]+" "+sa[2]+" "+sa[3]);
     //}
    VentanaAnalizador va=new VentanaAnalizador();
    va.setVisible(true);
    }
}
