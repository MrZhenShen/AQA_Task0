package testFramework.credentials;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Stream;

public class CredentialsFileReader {

    public static void setupCredentials(Class<?> credentialClass) {
        String className = credentialClass.toString().split("\\.")[2].split("Credentials")[0];
        AtomicBoolean credentialReadStater = new AtomicBoolean(false);

        try (Stream<String> lines = Files.lines(Paths.get("credentials.txt"))) {
            lines.forEach(line -> {
                if (line.equals(";")) {
                    credentialReadStater.set(false);
                }

                if (credentialReadStater.get()) {
                    String[] credential = line.split("=");

                    try {
                        if (DuolingoCredentials.class.equals(credentialClass)) {
                            DuolingoCredentials.valueOf(credential[0]).setCode(credential[1]);
                        } else if (UnsplashCredentials.class.equals(credentialClass)) {
                            UnsplashCredentials.valueOf(credential[0]).setCode(credential[1]);
                        }
                    } catch (IllegalArgumentException e) {
                        System.err.printf("[%s] is not field for %s enum\n", credential[0], credentialClass);
                        e.printStackTrace();
                        System.exit(1);
                    }
                }
                if (line.equals(className)) {
                    credentialReadStater.set(true);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
