//FEN 2015.03.11
//CrocAir

import java.util.*;

public class Main {

    public static void main(String[] args)
    {      
        GraphIF crocAir = new LinkedGraph(10);
        List<Vertex> l;
        // Constructing Crocodile Airlines...
          
        System.out.println("IsEmpty() (should be true): " + crocAir.isEmpty());
    
        Vertex perth = new Vertex("Perth");
        Vertex blackStump = new Vertex("Black Stump");
        Vertex darwin = new Vertex("Darwin");
        Vertex brisbane = new Vertex("Brisbane");
        Vertex sydney = new Vertex("Sydney");
        Vertex canberra = new Vertex("Canberra");
        Vertex adelaide = new Vertex("Adelaide");
        Vertex melbourne = new Vertex("Melbourne");
        Vertex hobart = new Vertex("Hobart");
        Vertex aalborg = new Vertex("Aalborg");

        crocAir.addVertex(perth);
        crocAir.addVertex(blackStump);
        crocAir.addVertex(darwin);
        crocAir.addVertex(brisbane);
        crocAir.addVertex(sydney);
        crocAir.addVertex(canberra);
        crocAir.addVertex(adelaide);
        crocAir.addVertex(melbourne);
        crocAir.addVertex(hobart);
    
        //crocAir.AddVertex(aalborg);

        System.out.println("IsEmpty(): Should print false: " + crocAir.isEmpty());

        System.out.println("Should print the number '9': " + crocAir.getVertexCount());

        System.out.println("Testing search in the vertex list: 3 times 'true' - 1 times 'false'");
              
        System.out.println(crocAir.containsVertex(hobart));
        System.out.println(crocAir.containsVertex(perth));
        System.out.println(crocAir.containsVertex(sydney));
        System.out.println(crocAir.containsVertex(aalborg));

        crocAir.addEdge(perth, blackStump);
        crocAir.addEdge(blackStump, darwin);
        crocAir.addEdge(darwin, canberra);
        crocAir.addEdge(canberra, brisbane);
        crocAir.addEdge(brisbane, sydney);
        crocAir.addEdge(sydney, canberra);
        crocAir.addEdge(canberra, sydney);
        crocAir.addEdge(sydney, melbourne);
        crocAir.addEdge(canberra, adelaide);
        crocAir.addEdge(adelaide, perth);
        crocAir.addEdge(adelaide, melbourne);
        crocAir.addEdge(melbourne, canberra);
        crocAir.addEdge(melbourne, hobart);
        crocAir.addEdge(hobart, melbourne);

        System.out.println("Hobart - Melbourne? (true): "
                + crocAir.isAdjacent(hobart, melbourne));

        System.out.println("Hobart - Sydney? (false): "
                + crocAir.isAdjacent(hobart, sydney));
        
        l = crocAir.getAdjacencies(canberra);
        System.out.println("Testing adjacencies of Canberra (Brisbane, Sydney, Adelaide):");
        for (Vertex v : l)
            System.out.println(v.getName());

        System.out.println("Number of edges (14): " + crocAir.getEdgeCount());
        System.out.println("Dfs starting in Brisbane: ");
        crocAir.unMarkAll();
        crocAir.dfs(brisbane);
        System.out.println("Dfs starting in Perth: ");
        crocAir.unMarkAll();
        crocAir.dfs(perth);

        System.out.println("Bfs starting in Brisbane: ");
        crocAir.unMarkAll();
        crocAir.bfs(brisbane);

        crocAir.clear();
        System.out.println("IsEmpty(): Should print true: " + crocAir.isEmpty());

// 

        System.out.println("System end");

    }

}
