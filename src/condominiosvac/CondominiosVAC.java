package condominiosvac;

import vista.condominios;


import Vistas.index;

/* @author Jefte Vega, Bryan Abarca, Hillary Cruz */
public class CondominiosVAC {

    public static void main(String[] args) {

        condominios newframe= new condominios();
        newframe.setVisible(true);


       index index=new index();
       index.iniciar();

    }

}
