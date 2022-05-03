
package Encriptacion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import javax.crypto.Cipher;

public class DesencriptadorRSA {

    //Variables para coneectar los archivos al sistema
    public static void desencriptadorRSA(PrivateKey clavePrivada)throws Exception{
String rutaProyecto =  System.getProperty( "user.dir" );  
String separador =  System.getProperty( "file.separator" );
 FileInputStream fileEncrypted = new FileInputStream(rutaProyecto + separador +  "src"  + separador +  "ficheroClavePublica.dat");
 ObjectInputStream dataEncrypted = new ObjectInputStream(fileEncrypted);
 Object de = dataEncrypted.readObject(); 
 byte[] datosEncriptados = (byte[]) de; 
  System.out.println("PUINTO CONTROL " + new String (datosEncriptados));
 // Leemos la llave privada del fichero
 //PrivateKey privateKey = leerLlavePrivada(rutaProyecto + separador +  "src"  + separador +  "ficheroClavePrivada.dat");
// Creamos una instancia del objeto Cipher para decifrar.
Cipher d = Cipher.getInstance("RSA");
 
 // Desencriptamos
 d.init(Cipher.DECRYPT_MODE, clavePrivada);
 byte[] bytesDesencriptados = d.doFinal(datosEncriptados);
 String msgDesencriptado = new String(bytesDesencriptados);
System.out.println("PUINTO CONTROL " + new String (bytesDesencriptados));
 // Mostramos el mensaje desencriptado
 System.out.println("Mensaje desencriptado: " + msgDesencriptado);
 
 //Creamos el fichero
 FileOutputStream fileDecrypted = new FileOutputStream(rutaProyecto + separador +  "src"  + separador +  "fichero_desencriptado.dat");
 ObjectOutputStream dataDecrypted = new ObjectOutputStream(fileDecrypted);
 
//Escribimos el mensaje desencriptado en el fichero
 dataDecrypted.writeObject(msgDesencriptado); 
 fileDecrypted.close();
 dataDecrypted.close();
}

}