
package Encriptacion;
import static Encriptacion.DesencriptadorRSA.desencriptadorRSA;
import static Encriptacion.EncriptadorRSA.encriptadorRSA;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.PrivateKey;
import javax.crypto.Cipher;


public class MenuRSA {
    public static void main(String[] args) throws Exception {
    
        
    String textoCifrado = "";  

    //Creamos un bucle while donde pedimos la frase y la pasamos a los distintos 
    //metodos de algoritmos y el hash
    while(!"salir".equals(textoCifrado)){
    System.out.println("escriba 'salir' para cerrar el programa. "
    + "\nIntrodusca el texto que quiere cifrar no puede ser mayor a 240 digitos.");
    textoCifrado = pedirString();
    if(!"salir".equals(textoCifrado)){  
    PrivateKey cipher = encriptadorRSA(textoCifrado);
    desencriptadorRSA(cipher);
    }}}
  
 
    //Funcion para pedirr String
    public static String pedirString(){
    String cadenaRetorno="";
        double clave;
        do{ clave=0;
        try{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cadenaRetorno= br. readLine();
        clave=0;
        if(cadenaRetorno.length() == 0 || cadenaRetorno.length()>240){clave=-1; System.out.println("El texto es muy largo");}
        }catch(Exception e){ clave=-1; System.out.println("Intentelo de nuevo");}
        }while(! (clave==0));
        return cadenaRetorno;}

    }
