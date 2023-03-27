package PaqC01;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class miPanel extends JFrame{
    private JPanel MiPanel;
    private JTextField txtnumid;
    private JTextField txtpeso;
    private JTextArea txtareadescripcion;
    private JTextField txtremitente;
    private JTextField txtreceptor;
    private JRadioButton RBoton1;
    private JRadioButton RBoton2;
    private JRadioButton RBoton3;
    private JCheckBox cBoxaduana;
    private JLabel lnumid;
    private JLabel lpeso;
    private JLabel ldescripcion;
    private JLabel lremirente;
    private JLabel lreceptor;
    private JLabel lprocedencia;
    private JLabel lprioridad;
    private JButton botonapilar;
    private JButton botondesapilar;
    private JButton Botonmostrar;
    private JButton botoncuantos;
    private JTextField txtnumcol;
    private JTextField txtIDCont;
    private JTextField txtcuantos;
    private JTextArea txtAreaEstado;
    private JLabel txtEstado;
    private JPanel MiPanel2;
    private JTextField txtpais;
    private JTextField txtidpais;

    public miPanel(){
        setTitle("Trabajo");
        setSize(1200,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setContentPane(MiPanel);
        Hub h= null;


        botonapilar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            int id=Integer.parseInt(txtnumid.getText());
            float peso=Float.parseFloat(txtpeso.getText());
            String descripcion=txtareadescripcion.getText();
            String empresa=txtremitente.getText();
            String recep=txtreceptor.getText();
            boolean aduana=cBoxaduana.getVerifyInputWhenFocusTarget();
            String pais=txtpais.getText();
            int prioridad=0;
            if(RBoton1.getVerifyInputWhenFocusTarget()) prioridad=1;
            else if(RBoton2.getVerifyInputWhenFocusTarget()) prioridad=2;
            else prioridad=3;
            Contenedor c=new Contenedor(id,peso,prioridad,pais,descripcion,empresa,recep);
            h.apilar(c);
            }

        });
        botondesapilar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int columna=Integer.parseInt(txtIDCont.getText());
                if(h!=null) h.desapilar(columna);

            }
        });
        Botonmostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(h==null) System.out.println("No hay contenedores");
                else h.toString();
            }
        });
        txtcuantos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (h != null) {
                    int cont = 0;
                    String pais = txtidpais.getText();
                    for (int i = 0; i < h.getMatriz().length; i++) {
                        for (int j = 0; j < h.getMatriz()[i].length; j++) {

                            if (pais==h.getMatriz()[i][j].getPais()){

                                cont++;
                            }


                        }

                    }

                    if(cont>0) System.out.println("Hay "+cont+" contenedores de "+pais);
                    else System.out.println("No hay ningun contenedor de "+pais);
                }
            }
        });
    }

    public static void main(String[] args) {
        new miPanel();
    }

}
