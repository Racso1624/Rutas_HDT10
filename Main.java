import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        //Se instancian las variables y clases
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        Grafo grafo;

        //Se busca si existe el archivo
        try {
            File obj = new File("guategrafo.txt");
            Scanner myReader = new Scanner(obj);
            int contador = 1;
            //Si existe se hace un ciclo
            while (myReader.hasNextLine()) {
                //Se realiza un contador
                String data = myReader.nextLine();//Se toma la linea de texto
                String[] datasplit = data.split(" ");//Se hace el split del texto
                if(!hashMap.containsKey(datasplit[0])){
                    hashMap.put(datasplit[0], contador);
                    contador++;
                }
                else if(!hashMap.containsKey(datasplit[1])){
                    hashMap.put(datasplit[1], contador);
                    contador++;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");//Se muestra el error
            e.printStackTrace();
            System.exit(1);//Sale del programa
        }

        //Se busca si existe el archivo
        try {
            File obj = new File("guategrafo.txt");
            Scanner myReader = new Scanner(obj);
            //Si existe se hace un ciclo
            while (myReader.hasNextLine()) {
                //Se realiza un contador
                contador++;
                String data = myReader.nextLine();//Se toma la linea de texto
                String[] datasplit = data.split(" ");//Se hace el split del texto

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");//Se muestra el error
            e.printStackTrace();
            System.exit(1);//Sale del programa
        }

        System.out.println("\nBienvenido al Traductor");
        	
		boolean var = false;
        a: while(var == false){//Se realiza el ciclo principal
     
            boolean var2 = false;
            while(var2 == false){
                System.out.println("\n\nIngrese la opcion que desea:");
                System.out.println("1) Ver Ruta Mas Corta");
                System.out.println("2) Agregar Elementos");
                System.out.println("3) Salir\n");

                try {
                    
                    int opcion = scanner.nextInt();//Se verifica el numero

                    if(opcion == 1){

                        var2 = true;
                    }
                    else if(opcion == 2){
                        var2 = true;
                    }
                    else if(opcion == 3){
                        System.out.println("Saliendo del Programa");
                        break a;//Se termina el ciclo principal
                    }
                    else{
                        System.out.println("\nOpcion Incorrecta, Ingresela de Nuevo");
                    }

                } catch (InputMismatchException e) {
                    System.out.println("\nOpcion Incorrecta, Ingresela de Nuevo");
                    scanner.nextLine();
                }
            }
            
        }    
    }
}