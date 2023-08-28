import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class TablaC {
    private int direccion = 100001, fila = 0;
    private String TS[][] = new String[20][5];// tamaño del vector fila y columna
    private String vector[], subvector[];
    private String cadena = "";
    private String tipo = "";
    Errores er = new Errores();

    public void PonerVariablesEnTabla(String cadena) { // intrega valores en ts
        this.cadena = cadena;
        AsignarEnTabla();
    }

    private boolean validaVariable() {
        String aux;
        String auxiliar = subvector[0];
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 5; j++) {
                if (auxiliar.equals(TS[i][j])) {
                    aux = "La variable: [" + auxiliar + "] ya a sido declarada";
                    er.setError("Sintaxis", aux, i);
                    er.getLista();
                    System.out.println("Error: "+aux);
                    return false;
                }
            }
        }
        return true;
    }

    private void AsignarEnTabla() {
        AnalizarTipoVariablesEnCadena();
        SepararVariablesDeCadenaEnVector();
        for (int i = 0; i < NumeroVariableEnCadena(); i++) {
            SepararValoresDeUnaVariablesEnSubvector(i);
            if (validaVariable() == false)
                break;
            if (tipo == "int") {
                AsignarNombreYValorEnTS();
                TS[fila][1] = "int";
                TS[fila][2] = "4";
                direccion = direccion + 4;
                TS[fila][4] = String.valueOf(direccion);
                fila++;
            } else if (tipo == "float") {
                AsignarNombreYValorEnTS();
                TS[fila][1] = "float";
                TS[fila][2] = "4";
                direccion = direccion + 4;
                TS[fila][4] = String.valueOf(direccion);
                fila++;
            } else if (tipo == "double") {
                AsignarNombreYValorEnTS();
                TS[fila][1] = "double";
                TS[fila][2] = "8";
                direccion = direccion + 8;
                TS[fila][4] = String.valueOf(direccion);
                fila++;
            } else if (tipo == "char") {
                AsignarNombreYValorEnTS();
                TS[fila][1] = "char";
                TS[fila][2] = "1";
                direccion = direccion + 1;
                TS[fila][4] = String.valueOf(direccion);
                fila++;
            }

        }
    }

    private void AsignarNombreYValorEnTS() {
        if (subvector.length == 1) {
            TS[fila][0] = subvector[0];
            TS[fila][3] = "0";
        } else {
            TS[fila][0] = subvector[0];
            TS[fila][3] = subvector[1];
        }
    }

    private void AnalizarTipoVariablesEnCadena() {
        LimpiarCadena();
        if (cadena.startsWith("int ")) {
            cadena = cadena.replace("int ", "");
            cadena = cadena.replace(" ", "");
            tipo = "int";
        } else if (cadena.startsWith("float ")) {
            cadena = cadena.replace("float ", "");
            cadena = cadena.replace(" ", "");
            tipo = "float";
        } else if (cadena.startsWith("double ")) {
            cadena = cadena.replace("double ", "");
            cadena = cadena.replace(" ", "");
            tipo = "double";
        } else if (cadena.startsWith("char ")) {
            cadena = cadena.replace("char ", "");
            cadena = cadena.replace(" ", "");
            tipo = "char";
        }

    }

    private void LimpiarCadena() {
        cadena = cadena.trim().replace(";", ",");
    }

    private int NumeroVariableEnCadena() {
        return vector.length;
    }

    private void SepararVariablesDeCadenaEnVector() {
        vector = cadena.split(",");
    }

    private void SepararValoresDeUnaVariablesEnSubvector(int posicion) {
        subvector = vector[posicion].split("=");
    }

    public void ImprimirTablaSimbolos() {
        try {
            File file = new File("CodigoVariables.txt");
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            System.out.println(" nombreID  tipo  tama\u00f1o    valor    direccion  ");
            for (int j = 0; j < 20; j++) {
                System.out.println("  " + TS[j][0] + "      " + TS[j][1] + "       " + TS[j][2] + "     " + TS[j][3]
                        + "     " + TS[j][4]);
                if (TS[j][0] != null)
                    bw.write(TS[j][0] + "-" + TS[j][1] + "-" + TS[j][2] + "-" + TS[j][3] + "-" + TS[j][4] + "\n");
            }
            bw.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void LimpiarEspaciosEnCadena() {
        cadena = cadena.trim().replace(" ", "");
        cadena = cadena.replace(";", ",");
        cadena = cadena.replace("=", ",");
        cadena = cadena.replace("+", ",");
        cadena = cadena.replace("-", ",");
        cadena = cadena.replace("*", ",");
        cadena = cadena.replace("/", ",");

    }

    public boolean VerificarOperacionVariablesEnTablaSimbolos(String cadena) {
        this.cadena = cadena;
        LimpiarEspaciosEnCadena();
        SepararVariablesDeCadenaEnVector();
        boolean flag = false;
        int tamano = NumeroVariableEnCadena();
        int contador = 0;
        for (int i = 0; i < tamano; i++) {

            for (int j = 0; j < TS.length; j++) {
                if (vector[i].equals(TS[j][0]) && TS[j][1].equals("int") ||
                        vector[i].equals(TS[j][0]) && TS[j][1].equals("float") ||
                        vector[i].equals(TS[j][0]) && TS[j][1].equals("double")) {
                    contador++;
                    j = TS.length;
                }

            }
        }
        if (contador == tamano) {
            flag = true;
        }

        return flag;
    }

}