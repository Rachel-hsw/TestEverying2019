package com.squareup.a.a.b;

import b.i;
import b.j;
import b.p;
import b.q;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class k
{
  private final p a = new p(new l(this, parami), new m(this));
  private int b;
  private final i c = q.a(this.a);

  public k(i parami)
  {
  }

  private j b()
    throws IOException
  {
    int i = this.c.l();
    return this.c.c(i);
  }

  private void c()
    throws IOException
  {
    if (this.b > 0)
    {
      this.a.b();
      if (this.b != 0)
        throw new IOException("compressedLimit > 0: " + this.b);
    }
  }

  public List<d> a(int paramInt)
    throws IOException
  {
    this.b = (paramInt + this.b);
    int i = this.c.l();
    if (i < 0)
      throw new IOException("numberOfPairs < 0: " + i);
    if (i > 1024)
      throw new IOException("numberOfPairs > 1024: " + i);
    ArrayList localArrayList = new ArrayList(i);
    for (int j = 0; j < i; j++)
    {
      j localj1 = b().d();
      j localj2 = b();
      if (localj1.f() == 0)
        throw new IOException("name.size == 0");
      localArrayList.add(new d(localj1, localj2));
    }
    c();
    return localArrayList;
  }

  public void a()
    throws IOException
  {
    this.c.close();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.a.b.k
 * JD-Core Version:    0.6.0
 */