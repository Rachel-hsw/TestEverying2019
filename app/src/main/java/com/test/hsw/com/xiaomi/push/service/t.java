package com.xiaomi.push.service;

import com.xiaomi.d.c.a;
import com.xiaomi.d.d.b;
import com.xiaomi.d.d.c;
import com.xiaomi.d.e.g;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public class t
  implements b
{
  public static a a(XmlPullParser paramXmlPullParser)
  {
    if (paramXmlPullParser.getEventType() != 2)
      return null;
    String str1 = paramXmlPullParser.getName();
    String str2 = paramXmlPullParser.getNamespace();
    String[] arrayOfString1;
    String[] arrayOfString2;
    int i;
    ArrayList localArrayList;
    if (paramXmlPullParser.getAttributeCount() > 0)
    {
      arrayOfString1 = new String[paramXmlPullParser.getAttributeCount()];
      arrayOfString2 = new String[paramXmlPullParser.getAttributeCount()];
      int j = 0;
      while (true)
        if (j < paramXmlPullParser.getAttributeCount())
        {
          arrayOfString1[j] = paramXmlPullParser.getAttributeName(j);
          arrayOfString2[j] = g.b(paramXmlPullParser.getAttributeValue(j));
          j++;
          continue;
          if (i != 2)
            break;
          if (localArrayList == null)
            localArrayList = new ArrayList();
          a locala = a(paramXmlPullParser);
          if (locala == null)
            break;
          localArrayList.add(locala);
        }
    }
    while (true)
    {
      i = paramXmlPullParser.next();
      if (i != 3)
      {
        if (i != 4)
          break;
        str3 = paramXmlPullParser.getText().trim();
        continue;
      }
      return new a(str1, str2, arrayOfString1, arrayOfString2, str3, localArrayList);
      String str3 = null;
      localArrayList = null;
      continue;
      arrayOfString1 = null;
      arrayOfString2 = null;
      str3 = null;
      localArrayList = null;
    }
  }

  public void a()
  {
    c.a().a("all", "xm:chat", this);
  }

  public a b(XmlPullParser paramXmlPullParser)
  {
    for (int i = paramXmlPullParser.getEventType(); (i != 1) && (i != 2); i = paramXmlPullParser.next());
    if (i == 2)
      return a(paramXmlPullParser);
    return null;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.t
 * JD-Core Version:    0.6.0
 */