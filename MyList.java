// реализация простого списка без коллекций
public class MyList<T>
{
    private Object[] a; 
    private int s; // размер текущего списка

    // создаю пустой список
    public MyList()
    {
        a = new Object[10];
        s = 0;
    }

    // добавляю элемент
    public void add(T v)
    {
        if (s == a.length)
        {
            grow();
        }
        a[s] = v;
        s++;
    }

    // нахожу элемент по индексу
    @SuppressWarnings("unchecked")
    public T get(int i)
    {
        return (T) a[i];
    }

    // удаляю элемент по индексу
    public void remove(int i)
    {
        for (int j = i; j < s - 1; j++)
        {
            a[j] = a[j + 1];
        }
        s--;
    }

    // возвращаю колво элементов
    public int size()
    {
        return s;
    }

    // проверяю, есть ли элемент в списке
    public boolean contains(T v)
    {
        for (int i = 0; i < s; i++)
        {
            if (a[i].equals(v))
            {
                return true;
            }
        }
        return false;
    }

    // увеличиваю массив при переполнении
    private void grow()
    {
        Object[] n = new Object[a.length * 2];
        for (int i = 0; i < a.length; i++)
        {
            n[i] = a[i];
        }
        a = n;
    }
        @Override
    public String toString() {
        if (s == 0) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < s; i++) {
            sb.append(a[i]);
            if (i < s - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}