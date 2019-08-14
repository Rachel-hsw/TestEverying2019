package com.android.volley.toolbox;

import android.os.Handler;
import android.os.Looper;
import com.android.volley.b;
import com.android.volley.l;
import com.android.volley.o;
import com.android.volley.o.b;
import com.android.volley.s;

public class f extends o<Object>
{
  private final b a;
  private final Runnable b;

  public f(b paramb, Runnable paramRunnable)
  {
    super(0, null, null);
    this.a = paramb;
    this.b = paramRunnable;
  }

  protected s<Object> a(l paraml)
  {
    return null;
  }

  protected void a(Object paramObject)
  {
  }

  public boolean p()
  {
    this.a.b();
    if (this.b != null)
      new Handler(Looper.getMainLooper()).postAtFrontOfQueue(this.b);
    return true;
  }

  public o.b w()
  {
    return o.b.d;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.android.volley.toolbox.f
 * JD-Core Version:    0.6.0
 */