package integrales;

     
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

class metodos extends Canvas{
    
    static int ancho = 460, alto = 380;
    static double [] ejeX = new double [ancho];
    static double [] ejeY = new double [ancho];
    static double [] ejeX1 = new double [ancho];
    static double [] ejeY1 = new double [ancho];
    static double [] ejeX2 = new double [ancho];
    static double [] ejeY2 = new double [ancho];
    
    int m1 = 0, m2 = 0, m3 = 0, m4 = 0, longitud1 = 0, longitud2 = 0, ejex = 0, ejey = 0;
    
    //definimos la funcion proncipal con la que se realizara la integral
    static double f (double x){
        double y;
       //y = -((Math.pow(x,3))-(Math.pow(x,2)*6)+(9*x)+5);
       //y = -Math.cos(x);
       //y = -((Math.pow(x,3))-(Math.pow(       //y = -((Math.pow(x,3))-(Math.pow(x,2)*6)+(8*x));x,2)*6)+(8*x));
       y = -Math.sin(x);
       return y;
    }
    
    @Override
    public void paint (Graphics g){
        
        m1 = Integer.parseInt(Integrales.xmax.getText());
        m2 = Integer.parseInt(Integrales.xmin.getText());
        m3 = Integer.parseInt(Integrales.ymax.getText());
        m4 = Integer.parseInt(Integrales.ymin.getText());
        
        ejex = (m1) + (m2);
        ejey = (m3) + (m4);
        
        longitud1 = (int) ancho/(Math.abs(m1)+Math.abs(m2));
        longitud2 = (int) alto/(Math.abs(m3)+Math.abs(m4));
        
        g.setColor(Color.black);
        g.fillRoundRect(0, 0, ancho, alto, 5, 5);
        g.setColor(Color.white);
        g.fillRoundRect(2, 2, ancho-4, alto-4, 3, 3);
        
        //Lineas horizontales de la cuadricula
        for (int i = 0; i <= ancho; i = i+longitud1) {
            g.setColor(Color.LIGHT_GRAY);
            g.drawLine(i, 0, i, alto);
        }
            //lineas verticales de la cuadricula
            for (int j = 0; j <= alto; j = j+longitud2) {
                g.setColor(Color.LIGHT_GRAY);
                g.drawLine(0, j, ancho, j);
            }
            //Ejes de la grafica
            g.setColor(Color.black);
            g.drawLine(-m2*longitud1, 0, -m2*longitud1, alto);
            g.setColor(Color.black);
            g.drawLine( 0, m3*longitud2, ancho, m3*longitud2);
        
        //Grafica la función
        for (int x = 1; x < 457; x++) {
            g.setColor(Color.blue);
            g.drawLine((int)ejeX[x], (int)ejeY[x], (int)ejeX[x+1], (int)ejeY[x+1]);
        }
        
        //Grafica la derivada
        for (int i = 1; i < 457; i++) {
            g.setColor(Color.red);
            g.drawLine((int)ejeX1[i], (int)ejeY1[i], (int)ejeX1[i+1], (int)ejeY1[i+1]);
        }
        
        for (int i = 0; i < 457; i++) {
            g.setColor(Color.black);
            g.drawLine((int)ejeX2[i], alto/2, (int)ejeX2[i], (int)ejeY2[i]);
            i++;
        }
    }
}
