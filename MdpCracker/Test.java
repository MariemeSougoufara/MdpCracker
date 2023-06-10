import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class Test {
    public static void main(String[] args) throws Exception {
        String str = "WayToLearnX";
        MessageDigest msg = MessageDigest.getInstance("SHA-256");
        byte[] hash = msg.digest(str.getBytes(StandardCharsets.UTF_8));
        // convertir bytes en hexadécimal
        StringBuilder s = new StringBuilder();
        for (byte b : hash) {
            s.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        }
        System.out.println(s.toString());
    }
}
