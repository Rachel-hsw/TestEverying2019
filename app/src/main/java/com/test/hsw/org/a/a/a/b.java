package org.a.a.a;

import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.List;
import org.a.a.a.a.i;

class b extends i
{
  private static final long f = 1L;

  b()
  {
    e(true);
    f(true);
    a(true);
    b(true);
    c(false);
    d("(");
    e(")");
    g(", ");
    a("[");
    b("]");
  }

  protected String a(Class<?> paramClass)
  {
    Iterator localIterator = l.e(paramClass).iterator();
    Class localClass;
    do
    {
      if (!localIterator.hasNext())
        break;
      localClass = (Class)localIterator.next();
    }
    while (!Annotation.class.isAssignableFrom(localClass));
    while (true)
    {
      if (localClass == null);
      for (String str = ""; ; str = localClass.getName())
        return new StringBuilder(str).insert(0, '@').toString();
      localClass = null;
    }
  }

  protected void a(StringBuffer paramStringBuffer, String paramString, Object paramObject)
  {
    if ((paramObject instanceof Annotation))
      paramObject = a.b((Annotation)paramObject);
    super.a(paramStringBuffer, paramString, paramObject);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.b
 * JD-Core Version:    0.6.0
 */