package reabilityApp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        try {
            new readabilityApp(
                    TextStatistics.from(
                            Files.readString(
                                    Path.of(args[0])))
            ).run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
