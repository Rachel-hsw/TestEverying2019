package com.xiaomi.c.a;

import com.xiaomi.d.e.m;
import java.io.Reader;
import java.io.Writer;
import java.text.SimpleDateFormat;

public class a
  implements com.xiaomi.d.a.a
{
  public static boolean a = false;
  private SimpleDateFormat b = new SimpleDateFormat("hh:mm:ss aaa");
  private com.xiaomi.d.a c = null;
  private com.xiaomi.d.f d = null;
  private com.xiaomi.d.d e = null;
  private Writer f;
  private Reader g;
  private com.xiaomi.d.e.f h;
  private m i;

  public a(com.xiaomi.d.a parama, Writer paramWriter, Reader paramReader)
  {
    this.c = parama;
    this.f = paramWriter;
    this.g = paramReader;
    e();
  }

  private void e()
  {
    com.xiaomi.d.e.a locala = new com.xiaomi.d.e.a(this.g);
    this.h = new b(this);
    locala.a(this.h);
    com.xiaomi.d.e.b localb = new com.xiaomi.d.e.b(this.f);
    this.i = new c(this);
    localb.a(this.i);
    this.g = locala;
    this.f = localb;
    this.d = new d(this);
    this.e = new e(this);
  }

  public Reader a()
  {
    return this.g;
  }

  public Reader a(Reader paramReader)
  {
    ((com.xiaomi.d.e.a)this.g).b(this.h);
    com.xiaomi.d.e.a locala = new com.xiaomi.d.e.a(paramReader);
    locala.a(this.h);
    this.g = locala;
    return this.g;
  }

  public Writer a(Writer paramWriter)
  {
    ((com.xiaomi.d.e.b)this.f).b(this.i);
    com.xiaomi.d.e.b localb = new com.xiaomi.d.e.b(paramWriter);
    localb.a(this.i);
    this.f = localb;
    return this.f;
  }

  public Writer b()
  {
    return this.f;
  }

  public com.xiaomi.d.f c()
  {
    return this.d;
  }

  public com.xiaomi.d.f d()
  {
    return null;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.c.a.a
 * JD-Core Version:    0.6.0
 */