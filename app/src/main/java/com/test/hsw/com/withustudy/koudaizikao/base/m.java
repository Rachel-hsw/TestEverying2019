package com.withustudy.koudaizikao.base;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

public abstract class m<T extends Activity> extends Handler
{
  private final WeakReference<T> a;

  public m(T paramT)
  {
    this.a = new WeakReference(paramT);
  }

  protected abstract void a(T paramT, Message paramMessage);

  public final void handleMessage(Message paramMessage)
  {
    Activity localActivity = (Activity)this.a.get();
    if (localActivity == null)
      return;
    a(localActivity, paramMessage);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.base.m
 * JD-Core Version:    0.6.0
 */