/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ComponentesSwing;

import com.sun.java.swing.plaf.windows.WindowsMenuBarUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import AnalizadorLexico.*;
/**
 *
 * @author Cliente
 */
public class VentanaAnalizador extends JFrame implements ActionListener{

 private PanelAnalizador pa;
 private JMenuBar jmb;
 private JMenu jm1;
 private JMenuItem jmi1;
 private JSeparator js1;
 private JMenuItem jmi2;
 private JMenu jm2;
 private JMenuItem jmi3;
 private JSeparator js2;
 private JMenuItem jmi4;
 private JPanel jpva;
 private JButton jbanalizar;
 private AnalizadorLexico alva;
 private int tam;

 public VentanaAnalizador(){
  tam=-1;

  alva=new AnalizadorLexico();

  jmb = new JMenuBar();
  jmb.setUI(new WindowsMenuBarUI());
  this.setJMenuBar(jmb);

  jm1=new JMenu();
  jmb.add(jm1);
  jm1.setText("Inicio");

  jmi1 = new JMenuItem();
  jm1.add(jmi1);
  jmi1.setText("Analizar");
  jmi1.addActionListener(this);
  js1 = new JSeparator();
  jm1.add(js1);
  jmi2 = new JMenuItem();
  jmi2.setText("Salir");
  jmi2.addActionListener(this);
  jm1.add(jmi2);

  jm2=new JMenu();
  jmb.add(jm2);
  jm2.setText("Ayuda");

  jmi3 = new JMenuItem();
  jm2.add(jmi3);
  jmi3.setText("Tabla de transicion");
  jmi3.addActionListener(this);
  js2=new JSeparator();
  jm2.add(js2);
  jmi4 = new JMenuItem();
  jmi4.setText("Acerca de...");
  jmi4.addActionListener(this);
  jm2.add(jmi4);

  this.setLayout(null);
  this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);   
  this.setTitle("Analizador Lexico LEN");
  this.setBounds(200,200,940,420);
  jpva=new JPanel();
  pa=new PanelAnalizador();
  jbanalizar=new JButton("Analizar");
  jbanalizar.addActionListener(this);

  jpva.setLayout(null);
  this.setContentPane(jpva);
  jpva.setBounds(0,0,920,400);

  jpva.add(jbanalizar);
  jpva.add(pa);
  
  jbanalizar.setBounds(383,290,150,30);
  pa.setBounds(0,35,920,300);
 
 }

 public void actionPerformed(ActionEvent e){
  String[] sa=new String[4];
  if(e.getSource()==jbanalizar||e.getSource()==jmi1){
   String cadaux=pa.getJtatexto().getText();
   alva.analizar(cadaux);
   if(tam>=0){
    for(int i=0;i<tam;i++){
     pa.getJttabla().setValueAt("",i,0);
     pa.getJttabla().setValueAt("",i,1);
     pa.getJttabla().setValueAt("",i,2);
     pa.getJttabla().setValueAt("",i,3);
    }
   }
   for(int i=0;i<alva.getAlstrings().size();i++){
    sa=alva.getAlstrings().get(i);
    pa.getJttabla().setValueAt(sa[0],i,0);
    pa.getJttabla().setValueAt(sa[1],i,1);
    pa.getJttabla().setValueAt(sa[2],i,2);
    pa.getJttabla().setValueAt(sa[3],i,3);
   }
   tam=alva.getAlstrings().size();
   alva=new AnalizadorLexico();
  }
  if(e.getSource()==jmi2)
   System.exit(0);
  if(e.getSource()==jmi3){
   JDialog dlgHelp = new DialogAyuda( this,
   "Tabla transicion LEN", "ttlen.txt" );
   dlgHelp.setVisible( true );
  }
  if(e.getSource()==jmi4){
   JDialog dlgAbout = new DialogAcercaDe(this);
   dlgAbout.setVisible(true);
  }
 }


}
