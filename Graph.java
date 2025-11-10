// делаю Граф
public class Graph<V>
{
    private MyList<V> vs;                /
    private MyList<MyList<Edge<V>>> adj; 
    private boolean dir;                

    private static class Edge<V>
    {
        V to;
        int w;

        Edge(V to, int w)
        {
            this.to = to;
            this.w = w;
        }
    }
    public Graph(boolean dir)
    {
        this.dir = dir;
        vs = new MyList<>();
        adj = new MyList<>();
    }

    // добавляю вершины
    public void addVertex(V v)
    {
        if (vs.contains(v))
        {
            System.out.println("Вершина уже существует: " + v);
            return;
        }
        vs.add(v);
        adj.add(new MyList<Edge<V>>());
    }

    // добавляю ребра
    public void addEdge(V f, V t, int w)
    {
        int i1 = find(f);
        int i2 = find(t);
        if (i1 == -1 || i2 == -1)
        {
            System.out.println("Ошибка: одна из вершин не найдена!");
            return;
        }

        adj.get(i1).add(new Edge<>(t, w));
        if (!dir)
        {
            adj.get(i2).add(new Edge<>(f, w));
        }
    }
    public void removeVertex(V v)
    {
        int idx = find(v);
        if (idx == -1)
        {
            System.out.println("Вершина " + v + " не найдена!");
            return;
        }

        vs.remove(idx);
        adj.remove(idx);

        for (int i = 0; i < adj.size(); i++)
        {
            MyList<Edge<V>> list = adj.get(i);
            for (int j = 0; j < list.size(); j++)
            {
                if (list.get(j).to.equals(v))
                {
                    list.remove(j);
                    j--;
                }
            }
        }

        System.out.println("Вершина " + v + " и все связанные рёбра удалены!");
    }

    // удаляю ребра
    public void removeEdge(V f, V t)
    {
        int i1 = find(f);
        int i2 = find(t);
        if (i1 == -1 || i2 == -1)
        {
            System.out.println("Ошибка: вершины нет!");
            return;
        }

        MyList<Edge<V>> list1 = adj.get(i1);
        for (int j = 0; j < list1.size(); j++)
        {
            if (list1.get(j).to.equals(t))
            {
                list1.remove(j);
                break;
            }
        }

        if (!dir)
        {
            MyList<Edge<V>> list2 = adj.get(i2);
            for (int j = 0; j < list2.size(); j++)
            {
                if (list2.get(j).to.equals(f))
                {
                    list2.remove(j);
                    break;
                }
            }
        }

        System.out.println("Ребро между " + f + " и " + t + " удалено!");
    }

    //  вывожу список смежных вершин
    public MyList<V> getAdjacent(V v)
    {
        MyList<V> res = new MyList<>();
        int i = find(v);
        if (i == -1)
        {
            System.out.println("Ошибка: вершины нет!");
            return res;
        }

        MyList<Edge<V>> list = adj.get(i);
        for (int j = 0; j < list.size(); j++)
        {
            res.add(list.get(j).to);
        }
        return res;
    }

    // обход в глубину
    public void dfs(V start)
    {
        boolean[] vis = new boolean[vs.size()];
        int idx = find(start);
        if (idx == -1)
        {
            System.out.println("Ошибка: вершины нет!");
            return;
        }
        dfsRec(idx, vis);
    }

    private void dfsRec(int i, boolean[] vis)
    {
        vis[i] = true;
        System.out.println("DFS visit: " + vs.get(i));
        MyList<Edge<V>> list = adj.get(i);
        for (int j = 0; j < list.size(); j++)
        {
            V to = list.get(j).to;
            int k = find(to);
            if (!vis[k]){
                dfsRec(k, vis);
            }
        }
    }

    // обход в ширину
    public void bfs(V start)
    {
        boolean[] vis = new boolean[vs.size()];
        MyQueue<Integer> q = new MyQueue<>();
        int s = find(start);
        if (s == -1)
        {
            System.out.println("Ошибка: вершина не найдена!");
            return;
        }

        q.add(s);
        vis[s] = true;

        while (!q.isEmpty())
        {
            int i = q.poll();
            System.out.println("BFS visit: " + vs.get(i));
            MyList<Edge<V>> list = adj.get(i);
            for (int j = 0; j < list.size(); j++)
            {
                V to = list.get(j).to;
                int k = find(to);
                if (!vis[k])
                {
                    q.add(k);
                    vis[k] = true;
                }
            }
        }
    }
    // ищу вершины
    private int find(V v)
    {
        for (int i = 0; i < vs.size(); i++)
        {
            if (vs.get(i).equals(v))
            {
                return i;
            }
        }
        return -1;
    }
}