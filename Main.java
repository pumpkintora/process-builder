import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        ProcessBuilder pb =
                new ProcessBuilder("java", "-version");
//        Map<String, String> env = pb.environment();
//        env.put("VAR1", "myValue");
//        env.remove("OTHERVAR");
//        env.put("VAR2", env.get("VAR1") + "suffix");
        pb.directory(new File(".\\myDir"));
        File log = new File(".\\myDir\\log");
        pb.redirectErrorStream(true);
        pb.redirectOutput(ProcessBuilder.Redirect.appendTo(log));
        Process p = pb.start();
        assert pb.redirectInput() == ProcessBuilder.Redirect.PIPE;
        assert pb.redirectOutput().file() == log;
        assert p.getInputStream().read() == -1;
    }
}
