//ALBERTO PARLA ORTIZ
package PaqC01;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class miPanel2 extends JFrame{

    private JPanel MiPanel2;
    private JTextArea textAreaestadoID;
    private JLabel txtEstado2;

    public static void main(String[] args) {
        new miPanel2();
    }

    public miPanel2() {
        setTitle("Nueva ventana peso total");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,600,600);
        setLayout(null);
        setVisible(true);
        setContentPane(MiPanel2);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Hub h=new Hub();


        textAreaestadoID.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                if(h==null) textAreaestadoID.setText("No hay contenedores");
                else textAreaestadoID.setText(h.toString());
            }
        });
    }

    }
