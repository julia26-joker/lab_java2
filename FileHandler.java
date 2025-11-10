// создаюфайл для чтения и обработки исключений
import java.io.*;
public class FileHandler
{
    public static void save(String f, String d)
    {
        try
        {
            FileWriter w = new FileWriter(f);
            w.write(d);
            w.close();
            System.out.println("Файл сохранён: " + f);
        }
        catch (IOException e)
        {
            System.err.println("Ошибка записи: " + e.getMessage());
        }
    }
    public static String load(String f)
    {
        StringBuilder s = new StringBuilder();
        try
        {
            BufferedReader r = new BufferedReader(new FileReader(f));
            String l;
            while ((l = r.readLine()) != null)
            {
                s.append(l).append("\n");
            }
            r.close();
            System.out.println("Файл прочитан: " + f);
        }
        catch (FileNotFoundException e)
        {
            System.err.println("Файл не найден: " + f);
        }
        catch (IOException e)
        {
            System.err.println("Ошибка чтения: " + e.getMessage());
        }
        return s.toString();
    }
}