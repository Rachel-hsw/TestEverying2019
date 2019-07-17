package com.himamis.retex.editor.a.e;

import java.util.HashMap;
import java.util.Map;

public class a
  implements g
{
  private Map<String, d> a = new HashMap();

  public e a(String paramString)
  {
    d locald1 = null;
    if (paramString != null)
    {
      int i = paramString.length();
      locald1 = null;
      if (i == 1)
        break label20;
    }
    label20: 
    do
    {
      boolean bool;
      do
      {
        return locald1;
        char c1 = paramString.charAt(0);
        if (Character.isLetter(c1))
          break;
        bool = Character.isDigit(c1);
        locald1 = null;
      }
      while (!bool);
      locald1 = (d)this.a.get(paramString);
    }
    while (locald1 != null);
    int j = paramString.length();
    char c2 = '\000';
    if (j > 0)
      c2 = paramString.charAt(0);
    d locald2 = new d(paramString, paramString, paramString, c2, c2, 1);
    this.a.put(paramString, locald2);
    return locald2;
  }

  public String a()
  {
    return "Characters";
  }

  public String b()
  {
    return a();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.editor.a.e.a
 * JD-Core Version:    0.6.0
 */