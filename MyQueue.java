// Создаю очередь
public class MyQueue<T>
{
    private Object[] a;
    private int h, t, s;
    public MyQueue()
    {
        a = new Object[10];
        h = 0;
        t = 0;
        s = 0;
    }
    // добавляю элемент
    public void add(T v)
    {
        if (s == a.length)
        {
            grow();
        }
        a[t] = v;
        t = (t + 1) % a.length;
        s++;
    }
    // удаляю элемент
    @SuppressWarnings("unchecked")
    public T poll()
    {
        if (isEmpty())
        {
            return null;
        }
        T v = (T) a[h];
        h = (h + 1) % a.length;
        s--;
        return v;
    }
    // проверяю на пустоту
    public boolean isEmpty()
    {
        return s == 0;
    }
    private void grow()
    {
        Object[] n = new Object[a.length * 2];
        for (int i = 0; i < s; i++)
        {
            n[i] = a[(h + i) % a.length];
        }
        a = n;
        h = 0;
        t = s;
    }
}