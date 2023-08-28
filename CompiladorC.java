import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.tools.ToolProvider;

public class CompiladorC {

    public static void main(String[] ar) {
        // lectura del fuente linea a linea

        String todo[] = new String[100];// codigo
        char[] letras = new char[30];
        String cad = "prueba.c";
        TablaC cts = new TablaC();
        Estructuras exp = new Estructuras();
        CodigoLimpiaC clc = new CodigoLimpiaC(cad);
        PalabrasReservadas prc = new PalabrasReservadas();
        Errores error = new Errores();
        boolean s[] = new boolean[15];
        // cad =ptr.nextLine(); //manual
        CompiladorC ptr = new CompiladorC();
        // todo= ptr.lineaCodigo(cad,todo);
        int estado = 1;
        int paso = 1;
        boolean romperPrograma = false;
        int posicion = 0;
        int estado3 = 0;
        todo = clc.LimpiarArchivoFuente();
        // clc.ImprimirCidigoLimpio();

        // main
        try {
            File file = new File("CodigoLimpio.txt");
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            // ******************************
            boolean bandera = false;

            while (todo[posicion] != null) {

                //System.out.println(todo[posicion]);
                if (todo[posicion].startsWith("#include")) {
                    bandera = exp.metodo_Librerias(todo[posicion]);
                    //System.out.println(bandera);
                    paso = 1;
                } else {
                    estado = 2;
                    if (paso == 1) {
                        s[0] = exp.metodo_Char(todo[posicion]);
                        s[1] = exp.metodo_VoidMain(todo[posicion]);
                        s[2] = exp.metodo_DoWhile(todo[posicion]);
                        s[3] = exp.metodo_Double(todo[posicion]);
                        s[4] = exp.metodo_Float(todo[posicion]);
                        s[5] = exp.metodo_For(todo[posicion]);
                        s[6] = exp.metodo_If(todo[posicion]);
                        s[7] = exp.metodo_Int(todo[posicion]);
                        s[8] = exp.metodo_Getch(todo[posicion]);
                        s[9] = exp.metodo_Librerias(todo[posicion]);
                        s[10] = exp.metodo_llaves(todo[posicion]);
                        s[11] = exp.metodo_Printf(todo[posicion]);
                        s[12] = exp.metodo_Scanf(todo[posicion]);
                        s[13] = exp.metodo_If2(todo[posicion]);
                        s[14] = exp.metodo_llaves(todo[posicion]);

                        if (s[14] == true || s[0] == true || s[1] == true || s[2] == true || s[3] == true || s[4] == true
                                || s[5] == true || s[6] == true || s[7] == true || s[8] == true || s[9] == true
                                || s[10] == true || s[11] == true || s[12] == true || s[13] == true) {

                            if (s[0] || s[3] || s[4] || s[7]) {
                                cts.PonerVariablesEnTabla(todo[posicion]);
                            }
                            
                        }
                         else {
                            error.setError("Error Sintaxis","Token Invalido", (posicion+1));
                            //System.out.println("Error en linea[" + (posicion+1) + "]: " + todo[posicion]);
                        }
                    }
                }
                bw.write(todo[posicion] + "\n");
                posicion++;
            }
            bw.close();
            //cts.ImprimirTablaSimbolos();
            error.getLista();
        } catch (Exception e) {
            System.out.println("Error al crear");
        }
    }

}
