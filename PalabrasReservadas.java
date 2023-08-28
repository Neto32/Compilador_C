


public class PalabrasReservadas {
    private String PS[] = {"auto","else","long","switch",
                           "break","enum","register","typedef",
                           "case","extern","return","union",
                           "char","float","short","unsigned",
                           "const","for","signed","void",
                           "continue","goto","sizeof","volatile",
                           "default","if","scanf","printf","while",
                           "do","int","struct","_Packed","getch","main",
                           "double","#include","stdio","stdlib","conio",
                           "cmath","ctime","cstring","algorithm","chrono",
                           "complex","exception","ratio","system_error"};
    
    private String cadena = "";
    private String vector[];
    
    
    public boolean RevisarPalabrasReservadas (String cadena){
        this.cadena = cadena;
        boolean retorno = AnalizarPS();
        return retorno;
    }
    
    
    private void LimpiarCadena() {
        cadena = cadena.trim().replace(";", ",");
        if(cadena.startsWith("int ")){
            
            cadena = cadena.substring(3);
            
            cadena = cadena.replace(" ","");
            
        }
        else if(cadena.startsWith("float ")){
            cadena = cadena.substring(5);
            cadena = cadena.replace(" ","");
        
        }
        else if(cadena.startsWith("double ")){
            cadena = cadena.substring(6);
            cadena = cadena.replace(" ","");
          
        }
        else if(cadena.startsWith("char ")){
            cadena = cadena.substring(4);
            cadena = cadena.replace(" ","");
        
        }
    }
    
    
    private boolean AnalizarPS(){ 
        LimpiarCadena();
        boolean ret = true;
        vector = cadena.split(",");
        String subvector[];
        String valor = "", valor2 = "";
        for(int i = 0;i<vector.length;i++){ //revisa que cada palabra si es reservada o no ,lo analice  en cada suubvector 
            valor = vector[i];            
            subvector=valor.split("=");
            
            valor2 = subvector[0];
            System.out.print(i);
            System.out.println(":::"+valor2);
            for(int j=0;j<PS.length;j++){
                if(valor2.equals(PS[j])){
                    System.out.println("entr-------------");
                    ret =false;
                }
                
            }
            
        }
        
        return ret;
    }
    
    
    
    
}