


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpresionesC {
     public boolean leer_Librerias(String cadena) {
        boolean flag = false;
        Pattern pat = Pattern.compile("#\\s*include\\s*<[ ]*(stdio|stdlib|conio|dos|string|math)\\.h\\s*>\\s*");
        Matcher mat = pat.matcher(cadena);
        if (mat.matches()) {
            flag = true;
        }
        return flag;
    }

    public boolean leer_VoidMain(String cadena) {
        boolean flag = false;
        Pattern pat = Pattern.compile("\\s*void\\s+main\\s*\\(\\s*(void)?\\s*\\)\\s*\\{.*\\}\\s*");
        Matcher mat = pat.matcher(cadena);
        if (mat.matches()) {
            flag = true;
        }
        return flag;
    }

    public boolean leer_Int(String cadena) {
        boolean flag = false;
        Pattern pat = Pattern.compile("\\s*int\\s+[a-zA-Z][a-zA-Z0-9]*\\s*(=\\s*([0-9]+|[a-zA-Z][a-zA-Z0-9]*)\\s*)?"+
                                      "(\\,\\s*[a-zA-Z][a-zA-Z0-9]*\\s*(=\\s*([0-9]+|[a-zA-Z][a-zA-Z0-9]*)\\s*)?)*\\;");
        Matcher mat = pat.matcher(cadena);
        if (mat.matches()) {
            flag = true;
        }
        return flag;
    }
    
    public boolean leer_Char(String cadena) {
        boolean flag = false;
        Pattern pat = Pattern.compile("\\s*char\\s+[a-zA-Z][a-zA-Z0-9]*\\s*(=\\s*(\\'.\\'|[a-zA-Z][a-zA-Z0-9]*)\\s*)?"+
                                      "(\\,\\s*[a-zA-Z][a-zA-Z0-9]*\\s*(=\\s*(\'.\'|[a-zA-Z][a-zA-Z0-9]*)\\s*)?)*\\;\\s*");
        Matcher mat = pat.matcher(cadena);
        if (mat.matches()) {
            flag = true;
        }
        return flag;
    }

     public boolean leer_Double(String cadena) {
        boolean flag = false;
        Pattern pat = Pattern.compile("\\s*double\\s+[a-zA-Z][a-zA-Z0-9]*\\s*(=\\s*([0-9]+(\\.[0-9]+)?|[a-zA-Z][a-zA-Z0-9]*)\\s*)?"+
                                      "(\\,\\s*[a-zA-Z][a-zA-Z0-9]*\\s*(=\\s*([0-9]+(\\.[0-9]+)?|[a-zA-Z][a-zA-Z0-9]*)\\s*)?)*\\;\\s*");
        Matcher mat = pat.matcher(cadena);
        if (mat.matches()) {
            flag = true;
        }
        return flag;
    }
}
