/**
 * Oscar Fernando López Barrios
 * Carné 20679
 * 
 * Codigo obtenido de https://www.youtube.com/watch?v=KwWu9sXdnaY
 **/
public class Graph {

    private int n;
    private int[][] matriz;

    // Se crea el Constructor
    public Graph(int n) {
        this.n = n;
        matriz = new int[this.n][this.n];
        //se inicializa matriz en 0
        for(int i=0; i< n; i++){
            for(int j=0; j< n; j++){
                matriz[i][j] = 0;
            }
        }
    }

    //Se inserta en la Matriz
    public void insert(int i, int j){
        matriz[i][j] += 1;
    }

    //Se remueve una relacion de la matriz
    public void remove(int i, int j){
        if(matriz[i][j]>0)
            matriz[i][j] -= 1;
    }
    
    //Se imprime la matriz
    public void printall(){
        for(int i=0; i< n; i++){
            System.out.print("\t");
            for(int j=0; j< n; j++){
                System.out.print( matriz[i][j] + "\t" );
            }
            System.out.print("");
            System.out.println();
        }
    }

    //Se imprime la matriz
    public void print(){
        for(int i=0; i< n; i++){
            for(int j=0; j< n; j++){
                if (matriz[i][j]==0){
                    matriz[i][j]=999999;
                }
            }

        }
        for(int i=0; i< n; i++){
            System.out.print("\t");
            for(int j=0; j< n; j++){
                System.out.print( matriz[i][j] + "\t" );
            }
            System.out.print("");
            System.out.println();
        }
    }

    //Se regresa la matriz
    public int[][] matrix(){
        return matriz;
    }

    //Se regresa el valor de la relacion
    public int returnvalue(int a, int b){
        return matriz[a][b];
    }
}