
package Encriptacion;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.Cipher;

public class EncriptadorRSA  {
    public static PrivateKey encriptadorRSA(String mensageSecreto)throws Exception{
//Variables para coneectar los archivos al sistema
String rutaProyecto =  System.getProperty( "user.dir" );  
String separador =  System.getProperty( "file.separator" );
//Creamo los distintos archivos necesarios
FileOutputStream ficheroCifrado = new FileOutputStream(rutaProyecto + separador +  "src"  + separador +  "ficheroCifrado.dat" );
FileOutputStream ficheroClavePublica = new FileOutputStream(rutaProyecto + separador +  "src"  + separador +  "ficheroClavePublica.dat" );
FileOutputStream ficheroClavePrivada = new FileOutputStream(rutaProyecto + separador +  "src"  + separador +  "ficheroClavePrivada.dat" );
ObjectOutputStream datoFicheroCifrado = new ObjectOutputStream(ficheroCifrado);
ObjectOutputStream datoFicheroClavePublica = new ObjectOutputStream(ficheroClavePublica);
ObjectOutputStream datoFicheroClavePrivada = new ObjectOutputStream(ficheroClavePrivada);
//Creamos clave secreta usando algoritmo AES
KeyPairGenerator kg = KeyPairGenerator.getInstance("RSA");
//Elegimos el tamaño en bits
kg.initialize(512);
KeyPair clave = kg.generateKeyPair();
//Generamos la clave publica y privada
PublicKey clavePublica = clave.getPublic();
PrivateKey clavePrivada = clave.getPrivate();
//Creamos los ojeto cipher
Cipher cipher = Cipher.getInstance("RSA");
cipher.init(Cipher.ENCRYPT_MODE, clavePublica);
//Realizamos el cifrado de la informacion
byte textoPlano[] = mensageSecreto.getBytes();
byte textoCifradoPublico[] = cipher.doFinal(textoPlano);
cipher.init(Cipher.ENCRYPT_MODE, clavePrivada);
byte textoCifradoPrivado[] = cipher.doFinal(textoPlano);
//Escribimos en los archivos
datoFicheroCifrado.writeObject(textoPlano);
datoFicheroClavePublica.writeObject(textoCifradoPublico);
datoFicheroClavePrivada.writeObject(textoCifradoPrivado);
//Cerramos los archivos y objetos creados
ficheroCifrado.close();
ficheroClavePublica.close();
ficheroClavePrivada.close();
datoFicheroCifrado.close();
datoFicheroClavePublica.close();
datoFicheroClavePrivada.close();
return clavePrivada;
}
    
    /*//Lo desencriptamos
c.init(Cipher.DECRYPT_MODE, clavePrivada);
byte desencriptado[] = c.doFinal(textoCifrado);
System.out.println("Desencriptado: " + new String(desencriptado));*/
}
