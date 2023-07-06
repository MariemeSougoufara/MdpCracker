import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * Classe utilitaire pour le hachage des mots de passe.
 */
public class Hasheur {
    public static void main(String[] args) throws Exception {
        System.out.println(hasheur("joie", "SHA-256")); 
    }
    
    /**
     * Effectue le hachage d'un mot de passe donné avec l'algorithme spécifié.
     *
     * @param motAhacher Le mot de passe à hacher.
     * @param algo      L'algorithme de hachage à utiliser.
     * @return Le mot de passe haché.
     * @throws Exception Si une erreur se produit lors de l'utilisation de l'algorithme de hachage.
     */
    public static String hasheur(String motAhacher, String algo) throws Exception {
        String hashe = "";
        MessageDigest msg = MessageDigest.getInstance(algo);
        byte[] hash = msg.digest(motAhacher.getBytes(StandardCharsets.UTF_8));
        
        // Convertir les bytes en hexadécimal
        StringBuilder s = new StringBuilder();
        for (byte b : hash) {
            s.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        }
        hashe = s.toString();
        
        return hashe;
    }
}
