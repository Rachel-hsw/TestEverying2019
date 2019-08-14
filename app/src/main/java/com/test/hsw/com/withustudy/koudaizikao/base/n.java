package com.withustudy.koudaizikao.base;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import java.lang.ref.WeakReference;

public abstract class n<T extends Fragment> extends Handler
{
  private final WeakReference<T> a;

  public n(T paramT)
  {
    this.a = new WeakReference(paramT);
  }

  protected abstract void a(T paramT, Message paramMessage);

  public final void handleMessage(Message paramMessage)
  {
    Fragment localFragment = (Fragment)this.a.get();
    if (localFragment == null)
      return;
    a(localFragment, paramMessage);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.base.n
 * JD-Core Version:    0.6.0
 */