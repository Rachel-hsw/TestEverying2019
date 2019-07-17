package com.xiaomi.d;

import com.xiaomi.d.c.b.a;
import com.xiaomi.d.c.d;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

class g
{
  private Thread a;
  private l b;
  private XmlPullParser c;
  private boolean d;

  protected g(l paraml)
  {
    this.b = paraml;
    a();
  }

  private void a(d paramd)
  {
    if (paramd == null);
    while (true)
    {
      return;
      Iterator localIterator = this.b.e.values().iterator();
      while (localIterator.hasNext())
        ((a.a)localIterator.next()).a(paramd);
    }
  }

  private void e()
  {
    this.c = XmlPullParserFactory.newInstance().newPullParser();
    this.c.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
    this.c.setInput(this.b.h);
  }

  private void f()
  {
    int i;
    Object localObject;
    String str1;
    while (true)
    {
      try
      {
        e();
        i = this.c.getEventType();
        localObject = "";
        this.b.o();
        if (i != 2)
          break label567;
        str1 = this.c.getName();
        if (!this.c.getName().equals("message"))
          break label160;
        a(com.xiaomi.d.e.c.a(this.c));
        localObject = str1;
        i = this.c.next();
        if ((!this.d) && (i != 1))
          continue;
        if (i != 1)
          break label159;
        throw new Exception("SMACK: server close the connection or timeout happened, last element name=" + (String)localObject + " host=" + this.b.c());
      }
      catch (Exception localException)
      {
        com.xiaomi.a.a.c.c.a(localException);
        if (this.d)
          break label599;
      }
      a(9, localException);
      label159: return;
      label160: if (this.c.getName().equals("iq"))
      {
        a(com.xiaomi.d.e.c.a(this.c, this.b));
        localObject = str1;
        continue;
      }
      if (!this.c.getName().equals("presence"))
        break;
      a(com.xiaomi.d.e.c.b(this.c));
      localObject = str1;
    }
    String str2;
    if (this.c.getName().equals("stream"))
      str2 = "";
    for (int j = 0; ; j++)
      if (j < this.c.getAttributeCount())
      {
        if (this.c.getAttributeName(j).equals("from"))
        {
          this.b.l.a(this.c.getAttributeValue(j));
        }
        else if (this.c.getAttributeName(j).equals("challenge"))
        {
          str2 = this.c.getAttributeValue(j);
        }
        else
        {
          if (!"ps".equals(this.c.getAttributeName(j)))
            continue;
          String str3 = this.c.getAttributeValue(j);
          com.xiaomi.d.c.b localb = new com.xiaomi.d.c.b();
          localb.l("0");
          localb.k("0");
          localb.a("ps", str3);
          localb.a(b.a.b);
          a(localb);
        }
      }
      else
      {
        this.b.a(str2);
        localObject = str1;
        break;
        if (this.c.getName().equals("error"))
          throw new p(com.xiaomi.d.e.c.d(this.c));
        if (this.c.getName().equals("warning"))
        {
          this.c.next();
          if (this.c.getName().equals("multi-login"))
          {
            a(6, null);
            localObject = str1;
            break;
          }
        }
        else if (this.c.getName().equals("bind"))
        {
          a(com.xiaomi.d.e.c.c(this.c));
          localObject = str1;
          break;
          label567: if ((i != 3) || (!this.c.getName().equals("stream")))
            break;
          a(13, null);
          break;
          label599: com.xiaomi.a.a.c.c.c("reader is shutdown, ignore the exception.");
          return;
        }
        localObject = str1;
        break;
      }
  }

  protected void a()
  {
    this.d = false;
    this.a = new h(this, "Smack Packet Reader (" + this.b.k + ")");
  }

  void a(int paramInt, Exception paramException)
  {
    this.d = true;
    this.b.a(paramInt, paramException);
  }

  public void b()
  {
    this.a.start();
  }

  public void c()
  {
    this.d = true;
  }

  void d()
  {
    this.b.e.clear();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.d.g
 * JD-Core Version:    0.6.0
 */