import java.io.IOException;
import java.io.InputStream;

public class Main {
    Process process = new ProcessBuilder("java", "-version").start();

    public Main() throws IOException {
        InputStream inputStream = process.getInputStream();
        System.out.println(inputStream);
    }
}
