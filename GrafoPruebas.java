import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

/*
* Oscar Fernando López Barrios
* Carné 20679
*/

public class GrafoPruebas {
    
    @Test
    public void insertar(){
        Graph graph = new Graph(3);
        graph.insert(1, 2);
        assertEquals(1, graph.returnvalue(1, 2));
    }

    @Test
    public void retornar(){
        Graph graph = new Graph(3);
        for(int i = 0; i < 100; i++){
            graph.insert(1, 2);
        }
        assertEquals(100, graph.returnvalue(1, 2));
    }

    @Test
    public void remover(){
        Graph graph = new Graph(3);
        for(int i = 0; i < 100; i++){
            graph.insert(1, 2);
        }
        graph.remove(1, 2);
        assertEquals(99, graph.returnvalue(1, 2));
    }

}
