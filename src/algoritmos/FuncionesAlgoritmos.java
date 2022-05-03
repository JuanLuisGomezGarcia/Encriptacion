
package algoritmos;
import java.io.FileNotFoundException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;


public class FuncionesAlgoritmos {
public  static void aes (String mensageSecreto) throws Exception{
//Creamos clave secreta usando algoritmo AES
KeyGenerator kg = KeyGenerator.getInstance("AES");
//Elegimos el tamaño en bits
kg.init(128);
SecretKey clave= kg.generateKey();
//Creamos un ojeto cipher
Cipher c = Cipher.getInstance("AES");
c.init(Cipher.ENCRYPT_MODE, clave);
//Realizamos e cifrado de la informacion
byte textoPlano[] = mensageSecreto.getBytes();
byte textoCifrado[] = c.doFinal(textoPlano);
System.out.println("Emcriptado con AES:\n" + new String(textoCifrado));
}



public  static void rsa (String mensageSecreto) throws Exception{
//Creamos clave secreta usando algoritmo AES
KeyPairGenerator kg = KeyPairGenerator.getInstance("RSA");
//Elegimos el tamaño en bits
kg.initialize(2048);
KeyPair clave = kg.generateKeyPair();
PublicKey clavePublica = clave.getPublic();
//Creamos un ojeto cipher
Cipher c = Cipher.getInstance("RSA");
c.init(Cipher.ENCRYPT_MODE, clavePublica);
//Realizamos e cifrado de la informacion
byte textoPlano[] = mensageSecreto.getBytes();
byte textoCifrado[] = c.doFinal(textoPlano);
System.out.println("Emcriptado con RSA:\n" + new String(textoCifrado));}


public  static void des (String mensageSecreto) throws Exception{
//Creamos clave secreta usando algoritmo DES
KeyGenerator kg = KeyGenerator.getInstance("DES");
//Elegimos el tamaño en bits
kg.init(56);
SecretKey clave= kg.generateKey();
//Creamos un ojeto cipher
Cipher c = Cipher.getInstance("DES");
c.init(Cipher.ENCRYPT_MODE, clave);
//Realizamos e cifrado de la informacion
byte textoPlano[] = mensageSecreto.getBytes();
byte textoCifrado[] = c.doFinal(textoPlano);
System.out.println("Emcriptado con DES:\n" + new String(textoCifrado));}

public  static void tripleDES (String mensageSecreto) throws Exception{
//Creamos clave secreta usando algoritmo DES
KeyGenerator kg = KeyGenerator.getInstance("tripleDES");
//Elegimos el tamaño en bits
kg.init(168);
SecretKey clave= kg.generateKey();
//Creamos un ojeto cipher
Cipher c = Cipher.getInstance("tripleDES");
c.init(Cipher.ENCRYPT_MODE, clave);
//Realizamos el cifrado de la informacion
byte textoPlano[] = mensageSecreto.getBytes();
byte textoCifrado[] = c.doFinal(textoPlano);
System.out.println("Emcriptado con tripleDES:\n" + new String(textoCifrado));}

public static void resumenHash(String mensageSecreto) throws FileNotFoundException, NoSuchAlgorithmException{
//Creamos un objeto de messageDigest y pasamos la frase a databytes y se lo pasamos al objeto recien creado
MessageDigest md = MessageDigest.getInstance("SHA");
byte dataBytes[] = mensageSecreto.getBytes();
md.update(dataBytes);
//Volvemos a pasar el objeto a bytes y mostramos el resultado por pantalla
byte resumen[] = md.digest();
System.out.println("Resumen hash:\n" +resumen + "\n"); }}

