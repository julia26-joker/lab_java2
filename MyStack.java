// Создаю стек
public class MyStack<T>
{
    private Object[] a;
    private int t;
    public MyStack()
    {
        a = new Object[10];
        t = -1;
    }

    // добавляю элемент в стек
    public void push(T v)
    {
        if (t == a.length - 1)
        {
            grow();
        }
        a[++t] = v;
    }
    // беру верхний элемент
    @SuppressWarnings("unchecked")
    public T pop()
    {
        if (isEmpty())
        {
            return null;
        }
        return (T) a[t--];
    }
    // проверяю на пустоту
    public boolean isEmpty()
    {
        return t == -1;
    }
    private void grow()
    {
        Object[] n = new Object[a.length * 2];
        for (int i = 0; i < a.length; i++)
        {
            n[i] = a[i];
        }
        a = n;
    }
}