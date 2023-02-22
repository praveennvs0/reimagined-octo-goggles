
import java.util.List;
import java.util.ArrayList;

public class Merge
{

    public static void main(String args[])
    {
        List<Float> a = new ArrayList<>();
        List<Float> b = new ArrayList<>();

        a.add(1.0f);
        a.add(3.8f);

        b.add(2.3f);
        b.add(4.5f);

        System.out.println(merge(a, b));
    }

    public static <E extends Comparable<E>> List<E> merge(List<E> a, List<E> b)
    {
        List<E> m = new ArrayList<E>();

        int i1 = 0, i2 = 0;

        while (i1 < a.size() && i2 < b.size())
        {
            if (a.get(i1).compareTo(b.get(i2)) <= 0)
            {
                m.add(a.get(i1++));
            }
            else
            {
                m.add(b.get(i2++));
            }
        }

        while (i1 < a.size())
        {
            m.add(a.get(i1++));
        }

        while (i2 < b.size())
        {
            m.add(b.get(i2++));
        }

        return m;
    }
}