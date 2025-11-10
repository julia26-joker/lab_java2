import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Быстрое тестирование графа!");

        Graph<String> graph = new Graph<>(false);
        

        String[] vertices = {"A", "B", "C", "D", "E"};
        for (String v : vertices) {
            graph.addVertex(v);
            System.out.println("Добавлена вершина: " + v);
        }

        String[][] edges = {
            {"A", "B", "2"}, {"A", "C", "3"}, 
            {"B", "D", "1"}, {"C", "D", "4"}, 
            {"D", "E", "5"}
        };
        
        for (String[] edge : edges) {
            graph.addEdge(edge[0], edge[1], Integer.parseInt(edge[2]));
            System.out.println("Добавлено ребро: " + edge[0] + " - " + edge[1] + " (вес: " + edge[2] + ")");
        }
        
        Scanner sc = new Scanner(System.in);
        
        while (true)
        {
            System.out.println("\n=== БЫСТРОЕ МЕНЮ ===");
            System.out.println("1 - Показать смежные вершины");
            System.out.println("2 - DFS обход");
            System.out.println("3 - BFS обход"); 
            System.out.println("4 - Удалить вершину");
            System.out.println("5 - Удалить ребро");
            System.out.println("0 - Выход");
            System.out.print("Выбор: ");

            int c = sc.nextInt();
            sc.nextLine();

            if (c == 0) break;

            switch (c)
            {
                case 1:
                    System.out.print("Вершина (A,B,C,D,E): ");
                    String av = sc.nextLine();
                    MyList<String> adj = graph.getAdjacent(av);
                    System.out.println("Смежные вершины: " + adj);
                    break;

                case 2:
                    System.out.print("Стартовая вершина (A,B,C,D,E): ");
                    String ds = sc.nextLine();
                    System.out.print("DFS: ");
                    graph.dfs(ds);
                    System.out.println();
                    break;

                case 3:
                    System.out.print("Стартовая вершина (A,B,C,D,E): ");
                    String bs = sc.nextLine();
                    System.out.print("BFS: ");
                    graph.bfs(bs);
                    System.out.println();
                    break;

                case 4:
                    System.out.print("Вершина для удаления (A,B,C,D,E): ");
                    String rv = sc.nextLine();
                    graph.removeVertex(rv);
                    System.out.println("Вершина " + rv + " удалена");
                    break;

                case 5:
                    System.out.print("Из вершины: ");
                    String rf = sc.nextLine();
                    System.out.print("В вершину: ");
                    String rt = sc.nextLine();
                    graph.removeEdge(rf, rt);
                    System.out.println("Ребро " + rf + "-" + rt + " удалено");
                    break;

                default:
                    System.out.println("Некорректный выбор!");
            }
        }

        sc.close();
        System.out.println("Тестирование завершено!");
    }
}