package a.a.a.e;

import a.a.a.i;
import java.util.Date;
import java.util.List;

public abstract interface k
{
  public abstract void a(StringBuilder paramStringBuilder, String paramString);

  public abstract void a(List<Object> paramList);

  public static abstract class a
    implements k
  {
    protected final boolean a;
    protected final Object b;
    protected final Object[] c;

    public a()
    {
      this.a = false;
      this.b = null;
      this.c = null;
    }

    public a(Object paramObject)
    {
      this.b = paramObject;
      this.a = true;
      this.c = null;
    }

    public a(Object[] paramArrayOfObject)
    {
      this.b = null;
      this.a = false;
      this.c = paramArrayOfObject;
    }

    public void a(List<Object> paramList)
    {
      if (this.a)
        paramList.add(this.b);
      while (true)
      {
        return;
        if (this.c == null)
          continue;
        Object[] arrayOfObject = this.c;
        int i = arrayOfObject.length;
        for (int j = 0; j < i; j++)
          paramList.add(arrayOfObject[j]);
      }
    }
  }

  public static class b extends k.a
  {
    public final i d;
    public final String e;

    public b(i parami, String paramString)
    {
      this.d = parami;
      this.e = paramString;
    }

    public b(i parami, String paramString, Object paramObject)
    {
      super();
      this.d = parami;
      this.e = paramString;
    }

    public b(i parami, String paramString, Object[] paramArrayOfObject)
    {
      super();
      this.d = parami;
      this.e = paramString;
    }

    private static Object a(i parami, Object paramObject)
    {
      if ((paramObject != null) && (paramObject.getClass().isArray()))
        throw new a.a.a.d("Illegal value: found array, but simple object required");
      if (parami.b == Date.class)
        if ((paramObject instanceof Date))
          paramObject = Long.valueOf(((Date)paramObject).getTime());
      do
        while (true)
        {
          return paramObject;
          if ((paramObject instanceof Long))
            continue;
          throw new a.a.a.d("Illegal date value: expected java.util.Date or Long for value " + paramObject);
          if ((parami.b != Boolean.TYPE) && (parami.b != Boolean.class))
            continue;
          if ((paramObject instanceof Boolean))
          {
            if (((Boolean)paramObject).booleanValue());
            for (int j = 1; ; j = 0)
              return Integer.valueOf(j);
          }
          if (!(paramObject instanceof Number))
            break;
          int i = ((Number)paramObject).intValue();
          if ((i == 0) || (i == 1))
            continue;
          throw new a.a.a.d("Illegal boolean value: numbers must be 0 or 1, but was " + paramObject);
        }
      while (!(paramObject instanceof String));
      String str = (String)paramObject;
      if ("TRUE".equalsIgnoreCase(str))
        return Integer.valueOf(1);
      if ("FALSE".equalsIgnoreCase(str))
        return Integer.valueOf(0);
      throw new a.a.a.d("Illegal boolean value: Strings must be \"TRUE\" or \"FALSE\" (case insesnsitive), but was " + paramObject);
    }

    private static Object[] a(i parami, Object[] paramArrayOfObject)
    {
      for (int i = 0; ; i++)
      {
        if (i >= paramArrayOfObject.length)
          return paramArrayOfObject;
        paramArrayOfObject[i] = a(parami, paramArrayOfObject[i]);
      }
    }

    public void a(StringBuilder paramStringBuilder, String paramString)
    {
      a.a.a.d.d.a(paramStringBuilder, paramString, this.d).append(this.e);
    }
  }

  public static class c extends k.a
  {
    protected final String d;

    public c(String paramString)
    {
      this.d = paramString;
    }

    public c(String paramString, Object paramObject)
    {
      super();
      this.d = paramString;
    }

    public c(String paramString, Object[] paramArrayOfObject)
    {
      super();
      this.d = paramString;
    }

    public void a(StringBuilder paramStringBuilder, String paramString)
    {
      paramStringBuilder.append(this.d);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     a.a.a.e.k
 * JD-Core Version:    0.6.0
 */