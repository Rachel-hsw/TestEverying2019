package com.xiaomi.d;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Base64;
import com.xiaomi.d.c.d;
import com.xiaomi.d.e.g;
import com.xiaomi.d.e.h;
import com.xiaomi.d.e.k;
import java.io.IOException;
import java.io.Writer;
import java.util.Locale;
import java.util.Map;

class i
{
  private Writer a;
  private l b;

  protected i(l paraml)
  {
    this.b = paraml;
    this.a = paraml.i;
  }

  private void b(d paramd)
  {
    synchronized (this.a)
    {
      try
      {
        String str1 = paramd.a();
        this.a.write(str1 + "\r\n");
        this.a.flush();
        String str2 = paramd.o();
        if (!TextUtils.isEmpty(str2))
          k.a(this.b.m, str2, k.a(str1), false, System.currentTimeMillis());
        return;
      }
      catch (IOException localIOException)
      {
        throw new p(localIOException);
      }
    }
  }

  void a()
  {
    this.b.f.clear();
  }

  public void a(d paramd)
  {
    b(paramd);
    this.b.b(paramd);
  }

  public void b()
  {
    synchronized (this.a)
    {
      this.a.write("</stream:stream>");
      this.a.flush();
      return;
    }
  }

  void c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<stream:stream");
    localStringBuilder.append(" xmlns=\"xm\"");
    localStringBuilder.append(" xmlns:stream=\"xm\"");
    localStringBuilder.append(" to=\"").append(this.b.b()).append("\"");
    localStringBuilder.append(" version=\"105\"");
    localStringBuilder.append(" model=\"").append(g.a(Build.MODEL)).append("\"");
    localStringBuilder.append(" os=\"").append(g.a(Build.VERSION.INCREMENTAL)).append("\"");
    String str = h.b();
    if (str != null)
      localStringBuilder.append(" uid=\"").append(str).append("\"");
    localStringBuilder.append(" sdk=\"").append(7).append("\"");
    localStringBuilder.append(" connpt=\"").append(g.a(this.b.d())).append("\"");
    localStringBuilder.append(" host=\"").append(this.b.c()).append("\"");
    localStringBuilder.append(" locale=\"").append(g.a(Locale.getDefault().toString())).append("\"");
    byte[] arrayOfByte = this.b.a().a();
    if (arrayOfByte != null)
      localStringBuilder.append(" ps=\"").append(Base64.encodeToString(arrayOfByte, 10)).append("\"");
    localStringBuilder.append(">");
    this.a.write(localStringBuilder.toString());
    this.a.flush();
  }

  public void d()
  {
    synchronized (this.a)
    {
      try
      {
        this.a.write(this.b.t() + "\r\n");
        this.a.flush();
        this.b.v();
        return;
      }
      catch (IOException localIOException)
      {
        throw new p(localIOException);
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.d.i
 * JD-Core Version:    0.6.0
 */