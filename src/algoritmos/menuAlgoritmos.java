
package algoritmos;

import static algoritmos.FuncionesAlgoritmos.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class menuAlgoritmos {
 
    public static void main(String[] args) throws Exception {
        
    String textoCifrado = "";   
    //Creamos un bucle while donde pedimos la frase y la pasamos a los distintos 
    //metodos de algoritmos y el hash
    while(!"salir".equals(textoCifrado)){
    System.out.println("escriba 'salir' para cerrar el programa. "
    + "\nIntrodusca el texto que quiere cifrar no puede ser mayor a 240 digitos.");
    textoCifrado = pedirString();
    if(!"salir".equals(textoCifrado)){
    aes(textoCifrado);   des(textoCifrado); rsa(textoCifrado);
    tripleDES(textoCifrado); resumenHash(textoCifrado);}}}
  
 
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
        return cadenaRetorno;} }
