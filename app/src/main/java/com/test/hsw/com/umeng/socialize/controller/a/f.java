package com.umeng.socialize.controller.a;

import android.content.Context;
import android.os.Bundle;
import com.umeng.socialize.a.a;
import com.umeng.socialize.bean.ay;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.controller.listener.SocializeListeners.UMAuthListener;
import com.umeng.socialize.utils.k;

class f
  implements SocializeListeners.UMAuthListener
{
  f(c paramc, Context paramContext, SocializeListeners.UMAuthListener paramUMAuthListener, SocializeListeners.UMAuthListener[] paramArrayOfUMAuthListener)
  {
  }

  public void a(Bundle paramBundle, p paramp)
  {
    int i = 0;
    if (paramBundle != null)
    {
      this.d.a.b(this.a, paramp, 1);
      c.a(this.d, this.a, paramp, paramBundle);
    }
    while (true)
    {
      if (this.b != null)
        this.b.a(paramBundle, paramp);
      if (this.c == null)
        break;
      SocializeListeners.UMAuthListener[] arrayOfUMAuthListener = this.c;
      int j = arrayOfUMAuthListener.length;
      while (i < j)
      {
        arrayOfUMAuthListener[i].a(paramBundle, paramp);
        i++;
      }
      this.d.a.b(this.a, paramp, 0);
    }
  }

  public void a(a parama, p paramp)
  {
    int i = 0;
    this.d.a.b(this.a, paramp, 0);
    k.g(this.a, paramp);
    k.d(this.a, paramp);
    if (this.b != null)
      this.b.a(parama, paramp);
    if (this.c != null)
    {
      SocializeListeners.UMAuthListener[] arrayOfUMAuthListener = this.c;
      int j = arrayOfUMAuthListener.length;
      while (i < j)
      {
        arrayOfUMAuthListener[i].a(parama, paramp);
        i++;
      }
    }
  }

  public void a(p paramp)
  {
    int i = 0;
    this.d.a.b(this.a, paramp, 0);
    k.g(this.a, paramp);
    k.d(this.a, paramp);
    if (this.b != null)
      this.b.a(paramp);
    if (this.c != null)
    {
      SocializeListeners.UMAuthListener[] arrayOfUMAuthListener = this.c;
      int j = arrayOfUMAuthListener.length;
      while (i < j)
      {
        arrayOfUMAuthListener[i].a(paramp);
        i++;
      }
    }
  }

  public void b(p paramp)
  {
    if (this.b != null)
      this.b.b(paramp);
    if (this.c != null)
    {
      SocializeListeners.UMAuthListener[] arrayOfUMAuthListener = this.c;
      int i = arrayOfUMAuthListener.length;
      for (int j = 0; j < i; j++)
        arrayOfUMAuthListener[j].b(paramp);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.controller.a.f
 * JD-Core Version:    0.6.0
 */