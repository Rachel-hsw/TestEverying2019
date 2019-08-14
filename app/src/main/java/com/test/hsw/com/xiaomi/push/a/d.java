package com.xiaomi.push.a;

import java.util.concurrent.ConcurrentLinkedQueue;

class d extends com.xiaomi.a.a.d.b.b
{
  com.xiaomi.a.a.d.b.b a;

  d(b paramb)
  {
  }

  public void b()
  {
    b.b localb = (b.b)b.b(this.b).peek();
    if ((localb != null) && (localb.d()))
    {
      this.a = ((com.xiaomi.a.a.d.b.b)b.b(this.b).remove());
      this.a.b();
    }
  }

  public void c()
  {
    if (this.a != null)
      this.a.c();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.a.d
 * JD-Core Version:    0.6.0
 */