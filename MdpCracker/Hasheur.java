import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class Hasheur {
    public static String hasheur(String motAhacher, String algo) throws Exception{
      String hashe = "";
        MessageDigest msg = MessageDigest.getInstance(algo);
        byte[] hash = msg.digest(motAhacher.getBytes(StandardCharsets.UTF_8));
        // convertir bytes en hexadécimal
        StringBuilder s = new StringBuilder();
        for (byte b : hash) {
            s.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        }
        hashe = s.toString();
      return hashe;
    }

}
