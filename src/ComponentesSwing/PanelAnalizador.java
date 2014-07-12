/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ComponentesSwing;
import java.awt.Color;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Cliente
 */
public class PanelAnalizador extends JPanel{

 private JLabel jlanalisis;
 private JLabel jltexto;
 private JScrollPane jsptexto;
 private JScrollPane jsptabla;
 private JTextArea jtatexto;
 private JTable jttabla;

 public PanelAnalizador(){
  this.setLayout(null);
  jlanalisis=new JLabel("Analisis");
  jltexto=new JLabel("Cadena");
  jsptexto=new JScrollPane();
  jsptabla=new JScrollPane();
  jtatexto=new JTextArea();
  jttabla=new JTable();
  jttabla.setEnabled(false);
  jttabla.setBorder(BorderFactory.createEtchedBorder());
  jttabla.setGridColor(Color.DARK_GRAY);
  jttabla.setModel(new DefaultTableModel(
   new Object[500][],
   new String[]{
    "Lexema","Token","Info","Estado"
   }
  )
  );
  jtatexto.setBorder(BorderFactory.createEtchedBorder());
  jsptexto.setViewportView(jtatexto);
  jsptabla.setViewportView(jttabla);
  jsptexto.setBounds(15,20,350,200);
  jsptabla.setBounds(380,20,525,200);
  jltexto.setBounds(15,0,60,20);
  jlanalisis.setBounds(380,0,60,20);

  this.add(jltexto);
  this.add(jlanalisis);
  this.add(jsptexto);
  this.add(jsptabla);
 }

 public JTextArea getJtatexto() {
  return jtatexto;
 }

 public void setJtatexto(JTextArea jtatexto) {
  this.jtatexto = jtatexto;
 }

 public JTable getJttabla() {
  return jttabla;
 }

 public void setJttabla(JTable jttabla) {
  this.jttabla = jttabla;
 }

}
