package org.json.alipay;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

public class a
{
  private ArrayList a;

  public a()
  {
    this.a = new ArrayList();
  }

  public a(Object paramObject)
  {
    this();
    if (paramObject.getClass().isArray())
    {
      int i = Array.getLength(paramObject);
      for (int j = 0; j < i; j++)
      {
        Object localObject = Array.get(paramObject, j);
        this.a.add(localObject);
      }
    }
    throw new JSONException("JSONArray initial value should be a string or collection or array.");
  }

  public a(String paramString)
  {
    this(new c(paramString));
  }

  public a(Collection paramCollection)
  {
    if (paramCollection == null);
    for (ArrayList localArrayList = new ArrayList(); ; localArrayList = new ArrayList(paramCollection))
    {
      this.a = localArrayList;
      return;
    }
  }

  public a(c paramc)
  {
    this();
    int i = paramc.c();
    char c1;
    if (i == 91)
    {
      c1 = ']';
      if (paramc.c() != ']')
        break label47;
    }
    label47: char c2;
    do
    {
      return;
      if (i == 40)
      {
        c1 = ')';
        break;
      }
      throw paramc.a("A JSONArray text must start with '['");
      paramc.a();
      while (true)
      {
        if (paramc.c() == ',')
        {
          paramc.a();
          this.a.add(null);
        }
        while (true)
        {
          c2 = paramc.c();
          switch (c2)
          {
          default:
            throw paramc.a("Expected a ',' or ']'");
            paramc.a();
            this.a.add(paramc.d());
          case ',':
          case ';':
          case ')':
          case ']':
          }
        }
        if (paramc.c() == ']')
          break;
        paramc.a();
      }
    }
    while (c1 == c2);
    throw paramc.a("Expected a '" + new Character(c1) + "'");
  }

  private String a(String paramString)
  {
    int i = this.a.size();
    StringBuffer localStringBuffer = new StringBuffer();
    for (int j = 0; j < i; j++)
    {
      if (j > 0)
        localStringBuffer.append(paramString);
      localStringBuffer.append(b.a(this.a.get(j)));
    }
    return localStringBuffer.toString();
  }

  public final int a()
  {
    return this.a.size();
  }

  public final Object a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.a.size()));
    for (Object localObject = null; localObject == null; localObject = this.a.get(paramInt))
      throw new JSONException("JSONArray[" + paramInt + "] not found.");
    return localObject;
  }

  public String toString()
  {
    try
    {
      String str = "[" + a(",") + ']';
      return str;
    }
    catch (Exception localException)
    {
    }
    return null;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.json.alipay.a
 * JD-Core Version:    0.6.0
 */