import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
* Oscar Fernando López Barrios
* Carné 20679
*/

//Se crea el Main
public class Main {

    public static void main(String[] args) {
        
        //Se instancian las variables y clases
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        Graph graph = null;

        //Se busca si existe el archivo
        try {
            File obj = new File("guategrafo.txt");
            Scanner myReader = new Scanner(obj);
            int contador = 0;
            //Si existe se hace un ciclo
            while (myReader.hasNextLine()) {
                //Se realiza un contador
                String data = myReader.nextLine();//Se toma la linea de texto
                String[] datasplit = data.split(" ");//Se hace el split del texto
                if(!hashMap.containsKey(datasplit[0])){//Se ingresa al HashMap para guardar los nombres
                    hashMap.put(datasplit[0], contador);
                    contador++;
                }
                if(!hashMap.containsKey(datasplit[1])){
                    hashMap.put(datasplit[1], contador);
                    contador++;
                }
            }
            graph = new Graph(contador);//Se crea el grafo
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
                String data = myReader.nextLine();//Se toma la linea de texto
                String[] datasplit = data.split(" ");//Se hace el split del texto
                int distancia = Integer.parseInt(datasplit[2]);//Se guarda la distancia
                for(int i = 0; i < distancia; i++){
                    graph.insert(hashMap.get(datasplit[0]), hashMap.get(datasplit[1]));//Se inserta en la matriz
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");//Se muestra el error
            e.printStackTrace();
            System.exit(1);//Sale del programa
        }


        System.out.println("\nBienvenido al Calculador de Rutas");
        	
		boolean var = false;
        a: while(var == false){//Se realiza el ciclo principal

            System.out.println("\n\nEl grafo es:");
            graph.printall();
     
            boolean var2 = false;
            while(var2 == false){
                System.out.println("\n\nIngrese la opcion que desea:");
                System.out.println("1) Ver Ruta Mas Corta");
                System.out.println("2) Agregar Elementos");
                System.out.println("3) Salir\n");

                try {
                    
                    int opcion = scanner.nextInt();//Se verifica el numero

                    if(opcion == 1){
                        FloydWarshall floydWarshall = new FloydWarshall();
                        floydWarshall.algoritmoFloyd(graph.matrix());
                        var2 = true;
                    }
                    else if(opcion == 2){
                        System.out.println("Ingresa la Primera Ciudad:");
                        String ciudad1 = scanner.next();
                        System.out.println("Ingresa la Segunda Ciudad:");
                        String ciudad2 = scanner.next();
                        System.out.println("Ingresa la distancia entre las dos ciudades:");
                        boolean verificador = false;
                        while(verificador == false){
                            try {
                                int distancia = scanner.nextInt();
                                //Se ingresa la ciudad al HaspMap
                                if(!hashMap.containsKey(ciudad1)){
                                    hashMap.put(ciudad1, hashMap.size() - 1);
                                }
                                if(!hashMap.containsKey(ciudad2)){
                                    hashMap.put(ciudad2, hashMap.size() - 1);
                                }
                                //Se busca si existe el archivo
                                try {
                                    File obj = new File("guategrafo.txt");
                                    Scanner myReader = new Scanner(obj);
                                    graph = new Graph(hashMap.size());
                                    //Si existe se hace un ciclo
                                    while (myReader.hasNextLine()) {
                                        String data = myReader.nextLine();//Se toma la linea de texto
                                        String[] datasplit = data.split(" ");//Se hace el split del texto
                                        int distancia2 = Integer.parseInt(datasplit[2]);
                                        for(int i = 0; i < distancia2; i++){
                                            graph.insert(hashMap.get(datasplit[0]), hashMap.get(datasplit[1]));
                                        }
                                    }
                                    myReader.close();
                                } catch (FileNotFoundException e) {
                                    System.out.println("Archivo no encontrado.");//Se muestra el error
                                    e.printStackTrace();
                                    System.exit(1);//Sale del programa
                                }
                                for(int i = 0; i < distancia; i++){
                                    graph.insert(hashMap.get(ciudad1), hashMap.get(ciudad2));
                                }
                                verificador = true;
                            } catch (InputMismatchException e) {
                                System.out.println("Error, Ingrese un numero:");
                                scanner.next();
                            }
                        }
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