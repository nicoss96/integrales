
package integrales;

import static integrales.metodos.alto;
import static integrales.metodos.ancho;
import java.awt.Color;
import java.awt.Container;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Integrales extends JFrame{
    
    metodos grafica = new metodos();
    
    JButton BotonGraficar = new JButton("Graficar");
    
    public static JTextField xmax = new JTextField("5");
    public static JTextField xmin = new JTextField("-5");
    public static JTextField ymax = new JTextField("5");
    public static JTextField ymin = new JTextField("-5");
    
    Container C = getContentPane();
    
    int m1 = 0, m2 = 0, m3 = 0, m4 = 0, longitud1 = 0, longitud2 = 0, ejex = 0, ejey = 0;
    int n = 1000;
    double h = 0.01;
    
    public Integrales(){
               
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(((Toolkit.getDefaultToolkit().getScreenSize().width - this.getSize().width)/4), 
						(Toolkit.getDefaultToolkit().getScreenSize().height -  this.getSize().height)/6);
                this.setVisible(true);
                
        C.setLayout(null);
        grafica.setBounds(25, 25, metodos.ancho, metodos.alto);
        C.add(grafica);
        
        BotonGraficar.setBounds(530, 100, 90, 250);
        xmin.setBounds(25, 415, 30, 20);
        xmax.setBounds(445, 415, 30, 20);
        ymax.setBounds(495, 25, 30, 20);
        ymin.setBounds(495, 380, 30, 20);
        
        C.add(BotonGraficar);
        C.add(xmin);
        C.add(xmax);
        C.add(ymax);
        C.add(ymin);
        
        BotonGraficar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                m1 = Integer.parseInt(Integrales.xmin.getText());
                m2 = Integer.parseInt(Integrales.xmax.getText());
                m3 = Integer.parseInt(Integrales.ymax.getText());
                m4 = Integer.parseInt(Integrales.ymin.getText());
                
                longitud1 = (int) ancho/(Math.abs(m1)+Math.abs(m2));
                longitud2 = (int) alto/(Math.abs(m3)+Math.abs(m4));
                
                double w = (0.004/2)*(m3+Math.abs(m4));
                double p = (0.50)/((Math.abs(m2)));
                
                for (int x = 0; x < 459; x++) {
                    double y = metodos.alto*p*metodos.f(w*(x+(m1*longitud1)))+(m3*longitud2);
                    metodos.ejeX[x] = x;
                    metodos.ejeY[x] = y;
                }
                
                for (int i = 0; i < 459; i++) {
                    double y = alto*p*((metodos.f((w*(i+(m1*longitud1)))+h)-metodos.f((i+(m1*longitud1))*w))/h)+(m3*longitud2);
                    metodos.ejeX1[i] = i;
                    metodos.ejeY1[i] = y; 
                }
                grafica.repaint();
                
            }
        });
        
        
    }
   
    public static void main(String[] args) {
        Integrales marco = new Integrales();
        marco.setSize(700, 510);
        marco.setVisible(true);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }   
}