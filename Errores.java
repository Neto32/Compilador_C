import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.ArrayList;

public class Errores {
    private ArrayList lista = new ArrayList<>();
    private File file;
    private FileWriter fw;
    private BufferedWriter bw;

    public void setError(String type, String msge, int line) {
        this.lista.add(type + "-" + msge + "-" + line);
    }

    public void getLista() {
        int size = this.lista.size();
        try {
            this.file = new File("CodigoErrores.txt");
            if (!this.file.exists()) {
                this.file.createNewFile();
            }

            this.fw = new FileWriter(this.file, true);
            this.bw = new BufferedWriter(this.fw);

            for (int i = 0; i < size; i++) {
                System.out.println(this.lista.get(i));
                bw.write(this.lista.get(i) + "\n");
            }
            bw.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
