package c.a;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;

public class h extends ab
  implements ev
{
  public h()
  {
    a(System.currentTimeMillis());
    a(ad.a);
  }

  public h(String paramString)
  {
    this();
    a(paramString);
  }

  public h(Throwable paramThrowable)
  {
    this();
    a(a(paramThrowable));
  }

  private String a(Throwable paramThrowable)
  {
    String str = null;
    if (paramThrowable == null)
      return null;
    try
    {
      StringWriter localStringWriter = new StringWriter();
      PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
      paramThrowable.printStackTrace(localPrintWriter);
      for (Throwable localThrowable = paramThrowable.getCause(); ; localThrowable = localThrowable.getCause())
      {
        str = null;
        if (localThrowable == null)
          break;
        localThrowable.printStackTrace(localPrintWriter);
      }
      str = localStringWriter.toString();
      localPrintWriter.close();
      localStringWriter.close();
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return str;
  }

  public h a(boolean paramBoolean)
  {
    if (paramBoolean);
    for (ad localad = ad.a; ; localad = ad.b)
    {
      a(localad);
      return this;
    }
  }

  public void a(bn parambn, String paramString)
  {
    as localas;
    if (parambn.s() > 0)
    {
      Iterator localIterator = parambn.u().iterator();
      do
      {
        if (!localIterator.hasNext())
          break;
        localas = (as)localIterator.next();
      }
      while (!paramString.equals(localas.c()));
    }
    while (true)
    {
      if (localas == null)
      {
        localas = new as();
        localas.a(paramString);
        parambn.a(localas);
      }
      localas.a(this);
      return;
      localas = null;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     c.a.h
 * JD-Core Version:    0.6.0
 */