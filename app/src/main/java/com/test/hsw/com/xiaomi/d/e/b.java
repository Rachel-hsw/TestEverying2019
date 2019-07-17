package com.xiaomi.d.e;

import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class b extends Writer
{
  Writer a = null;
  List b = new ArrayList();

  public b(Writer paramWriter)
  {
    this.a = paramWriter;
  }

  private void a(String paramString)
  {
    synchronized (this.b)
    {
      m[] arrayOfm = new m[this.b.size()];
      this.b.toArray(arrayOfm);
      int i = 0;
      if (i < arrayOfm.length)
      {
        arrayOfm[i].a(paramString);
        i++;
      }
    }
  }

  public void a(m paramm)
  {
    if (paramm == null)
      return;
    synchronized (this.b)
    {
      if (!this.b.contains(paramm))
        this.b.add(paramm);
      return;
    }
  }

  public void b(m paramm)
  {
    synchronized (this.b)
    {
      this.b.remove(paramm);
      return;
    }
  }

  public void close()
  {
    this.a.close();
  }

  public void flush()
  {
    this.a.flush();
  }

  public void write(int paramInt)
  {
    this.a.write(paramInt);
  }

  public void write(String paramString)
  {
    this.a.write(paramString);
    a(paramString);
  }

  public void write(String paramString, int paramInt1, int paramInt2)
  {
    this.a.write(paramString, paramInt1, paramInt2);
    a(paramString.substring(paramInt1, paramInt1 + paramInt2));
  }

  public void write(char[] paramArrayOfChar)
  {
    this.a.write(paramArrayOfChar);
    a(new String(paramArrayOfChar));
  }

  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    this.a.write(paramArrayOfChar, paramInt1, paramInt2);
    a(new String(paramArrayOfChar, paramInt1, paramInt2));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.d.e.b
 * JD-Core Version:    0.6.0
 */