package ComponentesSwing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextArea;


public class DialogAyuda extends JDialog implements ActionListener{
	
private JTextArea jta;
private JScrollPane jsp;
private JButton jbcerrar;

public DialogAyuda( JFrame jf, String titulo, String archivoayuda ){
   
super(jf,titulo,true);
setResizable(false);
this.setLayout(null);
this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//Coloca en una posicion cercana al jf
this.setLocationRelativeTo(jf);

//Tamaño del JDialog
this.setSize(440,440);

jta = new JTextArea();
jta.setEditable(false);
jta.setFont(new java.awt.Font("Lucida Console",0,11));

jsp = new JScrollPane();
jsp.setViewportView(jta);

jbcerrar = new JButton();
jbcerrar.setText("Cerrar");
jbcerrar.addActionListener(this);

//Coordenadas de los componentes
jsp.setBounds(30,30,385,320);
jbcerrar.setBounds(jsp.getX()+145,jsp.getY()+jsp.getHeight()+20,80,30);

try{
 InsertarTextodeArchivo( new Scanner( new FileInputStream( archivoayuda ) ) );
}catch(FileNotFoundException fnfe){
 System.err.println("Error:"+fnfe.getLocalizedMessage());
}
//Añadiendo los componentes al JDialog
this.getContentPane().add(jsp);
this.getContentPane().add(jbcerrar);

}

//Metodo para insertar el texto del documento en el textfield
private void InsertarTextodeArchivo( Scanner scanner ) {
while ( scanner.hasNext() ){
 jta.append( scanner.nextLine() + "\n" );
}
}

public void actionPerformed(ActionEvent e){
if(e.getSource() == jbcerrar ){
 this.dispose();
}
}

	
}