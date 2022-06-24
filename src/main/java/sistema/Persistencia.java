package sistema;

import java.io.*;

public final class Persistencia {

    private Persistencia(){}
    public static void write(String nombreArchivo, Object obj) throws IOException {
        FileOutputStream file = new FileOutputStream(nombreArchivo);
        ObjectOutputStream out = new ObjectOutputStream(file);
        out.writeObject(obj);
        file.close();
        out.close();
    }

    public static Object read(String nombreArchivo) throws IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream(nombreArchivo);
        ObjectInputStream in = new ObjectInputStream(file);
        return in.readObject();
    }
}
