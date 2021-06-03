/**
 * Codigo obtenido de https://www.youtube.com/watch?v=KwWu9sXdnaY
 **/
public class Graph {

    private int n;
    private int[][] matriz;

    /* 
     *  n numero de nodos
     */
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

    public void insert(int i, int j){
        matriz[i][j] += 1;
    }

    public void remove(int i, int j){
        if(matriz[i][j]>0)
            matriz[i][j] -= 1;
    }
    
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
    public int[][] matrix(){
        return matriz;
    }

    public int returnvalue(int a, int b){
        return matriz[a][b];
    }
}