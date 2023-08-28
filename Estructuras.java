import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Estructuras {

    public boolean metodo_Librerias(String cadena) {
        boolean flag = false;
        Pattern pat = Pattern.compile("#[ ]*iHBnclude[ ]*<[ ]*(stdio|stdlib|conio|dos|string|math)\\.h[ ]*>[ ]*");
        Matcher mat = pat.matcher(cadena);
        if (mat.matches()) {
            flag = true;
        }
        return flag;
    }

    public boolean metodo_VoidMain(String cadena) {
        boolean flag = false;
        Pattern pat = Pattern.compile("main\\s*\\(\\s*\\)\\s*\\{");
        Matcher mat = pat.matcher(cadena);
        if (mat.matches()) {
            flag = true;
        }
        return flag;
    }

    public boolean metodo_Int(String cadena) {
        boolean flag = false;
        Pattern pat = Pattern.compile(
                "int[ ]+[a-z,A-Z][a-z,A-Z,0-9]*[ ]*((,[ ]*[a-z,A-Z][a-z,A-Z,0-9]*[ ]*|=[ ]*([0-9]+|[a-z,A-Z][a-z,A-Z]*)|,[ ]*([a-z,A-Z][a-z,A-Z,0-9]*[ ]*=[ ]*([0-9]+|[a-z,A-Z][a-z,A-Z]*))*))*;");
        Matcher mat = pat.matcher(cadena);
        if (mat.matches()) {
            flag = true;
        } else {
            flag = false;

        }
        return flag;
    }

    public boolean metodo_IntVector(String cadena) {
        boolean flag = false;
        Pattern pat = Pattern
                .compile("[ ]*int[ ]+[a-zA-Z]+[a-zA-Z0-9]*[ ]*\\[[ ]*([0-9]+|[a-zA-Z][a-zA-Z0-9]*)[ ]*\\][ ]*" +
                        "([ ]*\\{[ ]*[0-9]+([ ]*\\}[ ]*|([ ]*\\,[ ]*[0-9]+)+[ ]*\\}[ ]*))?" +
                        "(\\,[ ]*[a-zA-Z][a-zA-Z0-9]*[ ]*\\[[ ]*([0-9]+|[a-zA-Z0-9]*)[ ]*\\][ ]*" +
                        "([ ]*\\{[ ]*[0-9]+([ ]*\\}[ ]*|([ ]*\\,[ ]*[0-9]+)+[ ]*\\}[ ]*))?)*\\:[ ]*");
        Matcher mat = pat.matcher(cadena);
        if (mat.matches()) {
            flag = true;
        }

        return flag;
    }

    public boolean metodo_CharVector(String cadena) {
        boolean flag = false;
        Pattern pat = Pattern.compile(
                "[ ]*char[ ]+(([a-zA-Z][a-zA-Z0-9]*[ ]*\\[[ ]*([0-9]+|[a-zA-Z][a-zA-Z0-9]*)[ ]*\\][ ]*" +
                        "(=[ ]*\".*\"[ ]*|=[ ]*\\{[ ]*\'.\'([ ]*\\}[ ]*|([ ]*\\,[ ]*\'.\')+[ ]*\\}[ ]*))?" +
                        "(\\,[ ]*[a-zA-Z][a-zA-Z0-9]*[ ]*\\[[ ]*([0-9]+|[a-zA-Z][a-zA-Z0-9]*)[ ]*\\][ ]*" +
                        "(=[ ]*\".*\"[ ]*|=[ ]*\\{[ ]*\'.\'([ ]*\\}[ ]*|([ ]*\\,[ ]*\'.\')+[ ]*\\}[ ]*))?)*\\;)|" +
                        "([a-zA-Z][a-zA-Z0-9]*[ ]*\\[[ ]*\\][ ]*" +
                        "(=[ ]*\".*\"[ ]*|=[ ]*\\{[ ]*\'.\'([ ]*\\}[ ]*|([ ]*\\,[ ]*\'.\')+[ ]*\\}[ ]*))" +
                        "(\\,[ ]*[a-zA-Z][a-zA-Z0-9]*[ ]*\\[[ ]*\\][ ]*" +
                        "(=[ ]*\".*\"|=[ ]*\\{[ ]*\'.\'([ ]*\\}[ ]*|([ ]*\\,[ ]*\'.\')+[ ]*\\}[ ]*)))*\\;))");
        Matcher mat = pat.matcher(cadena);
        if (mat.matches()) {
            flag = true;
        }
        return flag;
    }

    public boolean metodo_Char(String cadena) {
        boolean flag = false;
        Pattern pat = Pattern.compile("[ ]*char[ ]+[a-zA-Z][a-zA-Z0-9]*[ ]*(=[ ]*(\\'.\\'|[a-zA-Z][a-zA-Z0-9]*)[ ]*)?" +
                "(\\,[ ]*[a-zA-Z][a-zA-Z0-9]*[ ]*(=[ ]*(\'.\'|[a-zA-Z][a-zA-Z0-9]*)[ ]*)?)*\\;[ ]*");
        Matcher mat = pat.matcher(cadena);
        if (mat.matches()) {
            flag = true;
        }
        return flag;
    }

    public boolean metodo_Float(String cadena) {
        boolean flag = false;
        Pattern pat = Pattern
                .compile("[ ]*float[ ]+[a-zA-Z][a-zA-Z0-9]*[ ]*(=[ ]*([0-9]+(\\.[0-9]+)?|[a-zA-Z][a-zA-Z0-9]*)[ ]*)?" +
                        "(\\,[ ]*[a-zA-Z][a-zA-Z0-9]*[ ]*(=[ ]*([0-9]+(\\.[0-9]+)?|[a-zA-Z][a-zA-Z0-9]*)[ ]*)?)*\\;[ ]*");
        Matcher mat = pat.matcher(cadena);
        if (mat.matches()) {
            flag = true;
        }
        return flag;
    }

    public boolean metodo_Double(String cadena) {
        boolean flag = false;
        Pattern pat = Pattern
                .compile("[ ]*double[ ]+[a-zA-Z][a-zA-Z0-9]*[ ]*(=[ ]*([0-9]+(\\.[0-9]+)?|[a-zA-Z][a-zA-Z0-9]*)[ ]*)?" +
                        "(\\,[ ]*[a-zA-Z][a-zA-Z0-9]*[ ]*(=[ ]*([0-9]+(\\.[0-9]+)?|[a-zA-Z][a-zA-Z0-9]*)[ ]*)?)*\\;[ ]*");
        Matcher mat = pat.matcher(cadena);
        if (mat.matches()) {
            flag = true;
        }
        return flag;
    }

    public boolean metodo_If(String cadena) {
        boolean flag = false;
        Pattern pat = Pattern.compile(
                "if[ ]*\\((((int|double|char|float)[ ]*[a-z,A-Z][a-z,A-Z,0-9]*[ ]*(==|<|>|>=|<=)[ ]*([a-z,A-Z][a-z,A-Z,0-9]*|[0-9]))|([a-z,A-Z][a-z,A-Z,0-9]*[ ]*(==|<|>|>=|<=)[ ]*([a-z,A-Z][a-z,A-Z,0-9]*|[0-9])))[ ]*\\)[ ]*\\{");
        Matcher mat = pat.matcher(cadena);
        if (mat.matches()) {
            flag = true;
        }
        return flag;
    }

    public boolean metodo_If2(String cadena) {
        boolean flag = false;
        Pattern pat = Pattern.compile("else\\s*\\{");
        Matcher mat = pat.matcher(cadena);
        if (mat.matches()) {
            flag = true;
        }
        return flag;
    }

    public boolean metodo_While(String cadena) {
        boolean flag = false;
        Pattern Id = Pattern.compile("([0-9]+|[a-zA-Z][a-zA-Z0-9]*|\".*\")");
        Pattern Op = Pattern.compile("(>|<|>=|<=|!=|==)");
        Pattern Log = Pattern.compile("(&&|(\\|\\|))");
        Pattern pat = Pattern.compile(
                "[ ]*while[ ]*\\(" +
                        "[ ]*([ ]*\\([ ]*([ ]*\\([ ]*" + Id + "[ ]*" + Op + "[ ]*" + Id + "[ ]*\\)[ ]*" + // opcion 1
                        "(" + Log + "[ ]*\\([ ]*" + Id + "[ ]*" + Op + "[ ]*" + Id + "[ ]*\\)[ ]*)*[ ]*\\)[ ]*|[ ]*"
                        + Id + "[ ]*" + Op + "[ ]*" + Id + "[ ]*\\)[ ]*)" +
                        "([ ]*" + Log + "[ ]*\\([ ]*([ ]*" + Id + "[ ]*" + Op + "[ ]*" + Id + "[ ]*\\)[ ]*|[ ]*\\([ ]*"
                        + Id + "[ ]*" + Op + "[ ]*" + Id + "[ ]*\\)[ ]*" +
                        "(" + Log + "[ ]*\\([ ]*" + Id + "[ ]*" + Op + "[ ]*" + Id + "[ ]*\\)[ ]*)*[ ]*\\)[ ]*))*[ ]*" +
                        "|[ ]*" + Id + "[ ]*" + Op + "[ ]*" + Id + "[ ]*(" + Log + "[ ]*" + Id + "[ ]*" + Op + "[ ]*"
                        + Id + "[ ]*)*[ ]*" + // opcion 2
                        "|[ ]*" + Id + "[ ]*" + Op + "[ ]*" + Id + "[ ]*(" + Log + "[ ]*" + Id + "[ ]*" + Op + "[ ]*"
                        + Id + "[ ]*)*" + // opcion 3
                        Log + "[ ]*\\(([ ]*\\([ ]*" + Id + "[ ]*" + Op + "[ ]*" + Id + "[ ]*\\)[ ]*" +
                        "([ ]*" + Log + "[ ]*\\([ ]*" + Id + "[ ]*" + Op + "[ ]*" + Id + "[ ]*\\)[ ]*)*[ ]*\\)[ ]*|[ ]*"
                        + Id + "[ ]*" + Op + "[ ]*" + Id + "[ ]*\\)[ ]*)" +
                        "([ ]*" + Log + "[ ]*\\([ ]*(" + Id + "[ ]*" + Op + "[ ]*" + Id + "[ ]*\\)[ ]*|[ ]*\\([ ]*" + Id
                        + "[ ]*" + Op + "[ ]*" + Id + "[ ]*\\)[ ]*" +
                        "(" + Log + "[ ]*\\([ ]*" + Id + "[ ]*" + Op + "[ ]*" + Id + "[ ]*\\)[ ]*)*[ ]*\\)[ ]*))*)[ ]*"
                        +
                        "[ ]*\\)[ ]*" +
                        "[ ]*\\{.*\\}[ ]*");
        Matcher mat = pat.matcher(cadena);
        if (mat.matches()) {
            flag = true;
        }
        return flag;
    }

    public boolean metodo_DoWhile(String cadena) {
        boolean flag = false;
        Pattern Id = Pattern.compile("([0-9]+|[a-zA-Z][a-zA-Z0-9]*|\".*\")");
        Pattern Op = Pattern.compile("(>|<|>=|<=|!=|==)");
        Pattern Log = Pattern.compile("(&&|(\\|\\|))");
        Pattern pat = Pattern.compile(
                "[ ]*do[ ]*\\{.*\\}[ ]*while[ ]*\\(" +
                        "[ ]*([ ]*\\([ ]*([ ]*\\([ ]*" + Id + "[ ]*" + Op + "[ ]*" + Id + "[ ]*\\)[ ]*" + // opcion 1
                        "(" + Log + "[ ]*\\([ ]*" + Id + "[ ]*" + Op + "[ ]*" + Id + "[ ]*\\)[ ]*)*[ ]*\\)[ ]*|[ ]*"
                        + Id + "[ ]*" + Op + "[ ]*" + Id + "[ ]*\\)[ ]*)" +
                        "([ ]*" + Log + "[ ]*\\([ ]*([ ]*" + Id + "[ ]*" + Op + "[ ]*" + Id + "[ ]*\\)[ ]*|[ ]*\\([ ]*"
                        + Id + "[ ]*" + Op + "[ ]*" + Id + "[ ]*\\)[ ]*" +
                        "(" + Log + "[ ]*\\([ ]*" + Id + "[ ]*" + Op + "[ ]*" + Id + "[ ]*\\)[ ]*)*[ ]*\\)[ ]*))*[ ]*" +
                        "|[ ]*" + Id + "[ ]*" + Op + "[ ]*" + Id + "[ ]*(" + Log + "[ ]*" + Id + "[ ]*" + Op + "[ ]*"
                        + Id + "[ ]*)*[ ]*" + // opcion 2
                        "|[ ]*" + Id + "[ ]*" + Op + "[ ]*" + Id + "[ ]*(" + Log + "[ ]*" + Id + "[ ]*" + Op + "[ ]*"
                        + Id + "[ ]*)*" + // opcion 3
                        Log + "[ ]*\\(([ ]*\\([ ]*" + Id + "[ ]*" + Op + "[ ]*" + Id + "[ ]*\\)[ ]*" +
                        "([ ]*" + Log + "[ ]*\\([ ]*" + Id + "[ ]*" + Op + "[ ]*" + Id + "[ ]*\\)[ ]*)*[ ]*\\)[ ]*|[ ]*"
                        + Id + "[ ]*" + Op + "[ ]*" + Id + "[ ]*\\)[ ]*)" +
                        "([ ]*" + Log + "[ ]*\\([ ]*(" + Id + "[ ]*" + Op + "[ ]*" + Id + "[ ]*\\)[ ]*|[ ]*\\([ ]*" + Id
                        + "[ ]*" + Op + "[ ]*" + Id + "[ ]*\\)[ ]*" +
                        "(" + Log + "[ ]*\\([ ]*" + Id + "[ ]*" + Op + "[ ]*" + Id + "[ ]*\\)[ ]*)*[ ]*\\)[ ]*))*)[ ]*"
                        +
                        "[ ]*\\)[ ]*;[ ]*");
        Matcher mat = pat.matcher(cadena);
        if (mat.matches()) {
            flag = true;
        }
        return flag;
    }

    public boolean metodo_For(String cadena) {
        boolean flag = false;
        Pattern pat = Pattern.compile("^for\\(int\\s+[a-zA-Z]+\\s*=\\s*\\d+;\\s*[a-zA-Z]+\\s*<\\s*\\d+;\\s*[a-zA-Z]+\\+\\+\\)\\s*\\{.*}$");
        Matcher mat = pat.matcher(cadena);
        if (mat.matches()) {
            flag = true;
        }
        return flag;
    }

    public boolean metodo_Printf(String cadena) {
        cadena = cadena.trim();
        Pattern pat = Pattern.compile("printf\\s*\\(\\s*\\\"[^\"]*\\\"\\s*(,\\s*[^)]*\\s*)?\\)\\s*;");
        Matcher mat = pat.matcher(cadena);
        if (mat.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean metodo_OperacionTipoNumerico(String cadena) {
        boolean flag = false;

        Pattern pat = Pattern.compile("[ ]*[a-zA-Z][a-zA-Z0-9]*[ ]*\\=[ ]*[a-zA-Z][a-zA-Z0-9]*[ ]*"
                + "((\\+|\\-|\\*|\\/)[ ]*[a-zA-Z][a-zA-Z0-9]*[ ]*)*\\;[ ]*");
        Matcher mat = pat.matcher(cadena);
        if (mat.matches()) {
            flag = true;
        }
        return flag;
    }

    public boolean metodo_Scanf(String cadena) {
        boolean flag = false;

        Pattern pat = Pattern.compile("scanf\\(\"%d\",&[a-z]+\\);");
        Matcher mat = pat.matcher(cadena.trim());
        if (mat.matches()) {
            flag = true;
        }
        return flag;
    }

    public boolean metodo_Getch(String cadena) {
        boolean flag = false;

        Pattern pat = Pattern.compile("getch\\s*\\(\\s*\\)\\s*;");
        Matcher mat = pat.matcher(cadena.trim());
        if (mat.matches()) {
            flag = true;
        }
        return flag;
    }

    public boolean metodo_llaves(String cadena) {
        boolean flag = false;
        
        switch(cadena.charAt(cadena.length()-1)){
            case '{':
                flag = true;
            break;
            case '}':
                flag = true;
            break;
            case ';':
                flag = true;
            break;
            default:
                flag = false;
            break;
        }
        
        return flag;
    }

}
