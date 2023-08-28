


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class CodigoLimpiaC {
String[] todo = new String[100];
    String cad = "";

    public CodigoLimpiaC(String ruta) {
        this.cad = ruta;

    }

    public String[] LimpiarArchivoFuente() {
        LimpiarEspaciosYCoemntariosUnaLinea();
        
        return todo;
    }

    private void LimpiarEspaciosYCoemntariosUnaLinea() {

        String linea = "", subcadena = "";
        boolean cerrado=false;
        char caracter;
        int tamano = 0;
        try {
            File fuenteC = new File(cad);
            BufferedReader obj = new BufferedReader(new FileReader(fuenteC));
            int posicion = 0;
            while ((linea = obj.readLine()) != null) {

                String resultado = linea.trim();

                for (int i = 0; i < resultado.length(); i++) {
                    if (resultado.substring(i).startsWith("//")||resultado.substring(i).startsWith("/*")) {

                        break;
                    } else {
                        caracter = (char) resultado.charAt(i);
                        
                        subcadena = subcadena + caracter;
                    }
                    if(resultado.substring(i).startsWith("*/") || resultado.substring(i).startsWith("*")){
                        subcadena="";
                        break;
                        
                    }
                }
                
                if (subcadena != "") {
                    //cerrado=false;
                    todo[posicion] = subcadena;

                } else {
                    posicion--;
                }
                subcadena = "";

                posicion++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

       
    

    public void ImprimirCidigoLimpio() {
        int posicion = 0;
        while (todo[posicion] != null) {
            System.out.println(todo[posicion]);
            posicion++;
        }
    }

}