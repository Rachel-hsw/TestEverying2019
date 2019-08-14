package com.umeng.socialize.common;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.umeng.socialize.controller.a.x;

public abstract class s<Result>
{
  private static final HandlerThread a = new HandlerThread(x.class.getName(), 10);

  static
  {
    a.start();
  }

  protected void a()
  {
  }

  protected void a(Result paramResult)
  {
  }

  protected abstract Result b();

  public final s<Result> c()
  {
    Handler localHandler1 = new Handler(Looper.getMainLooper());
    Handler localHandler2 = new Handler(a.getLooper());
    a();
    localHandler2.post(new t(this, localHandler1));
    return this;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.common.s
 * JD-Core Version:    0.6.0
 */