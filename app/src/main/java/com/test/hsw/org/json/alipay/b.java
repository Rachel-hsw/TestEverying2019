package org.json.alipay;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class b
{
  public static final Object a = new a(0);
  private Map b;

  public b()
  {
    this.b = new HashMap();
  }

  public b(String paramString)
  {
    this(new c(paramString));
  }

  public b(Map paramMap)
  {
    if (paramMap == null)
      paramMap = new HashMap();
    this.b = paramMap;
  }

  public b(c paramc)
  {
    this();
    if (paramc.c() != '{')
      throw paramc.a("A JSONObject text must begin with '{'");
    do
    {
      paramc.a();
      String str;
      int i;
      switch (paramc.c())
      {
      default:
        paramc.a();
        str = paramc.d().toString();
        i = paramc.c();
        if (i == 61)
        {
          if (paramc.b() == '>')
            break;
          paramc.a();
        }
      case '\000':
        Object localObject;
        while (true)
        {
          localObject = paramc.d();
          if (str != null)
            break;
          throw new JSONException("Null key.");
          throw paramc.a("A JSONObject text must end with '}'");
          if (i == 58)
            continue;
          throw paramc.a("Expected a ':' after a key");
        }
        if (localObject != null)
        {
          b(localObject);
          this.b.put(str, localObject);
        }
        while (true)
          switch (paramc.c())
          {
          default:
            throw paramc.a("Expected a ',' or '}'");
            this.b.remove(str);
          case ',':
          case ';':
          case '}':
          }
      case '}':
      }
    }
    while (paramc.c() != '}');
  }

  static String a(Object paramObject)
  {
    String str;
    if ((paramObject == null) || (paramObject.equals(null)))
      str = "null";
    while (true)
    {
      return str;
      if (!(paramObject instanceof Number))
        break;
      Number localNumber = (Number)paramObject;
      if (localNumber == null)
        throw new JSONException("Null pointer");
      b(localNumber);
      str = localNumber.toString();
      if ((str.indexOf('.') <= 0) || (str.indexOf('e') >= 0) || (str.indexOf('E') >= 0))
        continue;
      while (str.endsWith("0"))
        str = str.substring(0, -1 + str.length());
      if (str.endsWith("."))
        return str.substring(0, -1 + str.length());
    }
    if (((paramObject instanceof Boolean)) || ((paramObject instanceof b)) || ((paramObject instanceof a)))
      return paramObject.toString();
    if ((paramObject instanceof Map))
      return new b((Map)paramObject).toString();
    if ((paramObject instanceof Collection))
      return new a((Collection)paramObject).toString();
    if (paramObject.getClass().isArray())
      return new a(paramObject).toString();
    return c(paramObject.toString());
  }

  private static void b(Object paramObject)
  {
    if (paramObject != null)
      if ((paramObject instanceof Double))
      {
        if ((((Double)paramObject).isInfinite()) || (((Double)paramObject).isNaN()))
          throw new JSONException("JSON does not allow non-finite numbers.");
      }
      else if (((paramObject instanceof Float)) && ((((Float)paramObject).isInfinite()) || (((Float)paramObject).isNaN())))
        throw new JSONException("JSON does not allow non-finite numbers.");
  }

  public static String c(String paramString)
  {
    int i = 0;
    if ((paramString == null) || (paramString.length() == 0))
      return "\"\"";
    int j = paramString.length();
    StringBuffer localStringBuffer = new StringBuffer(j + 4);
    localStringBuffer.append('"');
    int k = 0;
    if (i < j)
    {
      int m = paramString.charAt(i);
      switch (m)
      {
      default:
        if ((m >= 32) && ((m < 128) || (m >= 160)) && ((m < 8192) || (m >= 8448)))
          break;
        String str = "000" + Integer.toHexString(m);
        localStringBuffer.append("\\u" + str.substring(-4 + str.length()));
      case 34:
      case 92:
      case 47:
      case 8:
      case 9:
      case 10:
      case 12:
      case 13:
      }
      while (true)
      {
        i++;
        k = m;
        break;
        localStringBuffer.append('\\');
        localStringBuffer.append(m);
        continue;
        if (k == 60)
          localStringBuffer.append('\\');
        localStringBuffer.append(m);
        continue;
        localStringBuffer.append("\\b");
        continue;
        localStringBuffer.append("\\t");
        continue;
        localStringBuffer.append("\\n");
        continue;
        localStringBuffer.append("\\f");
        continue;
        localStringBuffer.append("\\r");
        continue;
        localStringBuffer.append(m);
      }
    }
    localStringBuffer.append('"');
    return localStringBuffer.toString();
  }

  public final Object a(String paramString)
  {
    if (paramString == null);
    for (Object localObject = null; localObject == null; localObject = this.b.get(paramString))
      throw new JSONException("JSONObject[" + c(paramString) + "] not found.");
    return localObject;
  }

  public final Iterator a()
  {
    return this.b.keySet().iterator();
  }

  public final boolean b(String paramString)
  {
    return this.b.containsKey(paramString);
  }

  public String toString()
  {
    try
    {
      Iterator localIterator = a();
      StringBuffer localStringBuffer = new StringBuffer("{");
      while (localIterator.hasNext())
      {
        if (localStringBuffer.length() > 1)
          localStringBuffer.append(',');
        Object localObject = localIterator.next();
        localStringBuffer.append(c(localObject.toString()));
        localStringBuffer.append(':');
        localStringBuffer.append(a(this.b.get(localObject)));
      }
      localStringBuffer.append('}');
      String str = localStringBuffer.toString();
      return str;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  private static final class a
  {
    protected final Object clone()
    {
      return this;
    }

    public final boolean equals(Object paramObject)
    {
      return (paramObject == null) || (paramObject == this);
    }

    public final String toString()
    {
      return "null";
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.json.alipay.b
 * JD-Core Version:    0.6.0
 */