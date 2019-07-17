package com.xiaomi.mipush.sdk;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.a.a.e.d;
import com.xiaomi.push.service.b;

class o extends ContentObserver
{
  o(n paramn, Handler paramHandler)
  {
    super(paramHandler);
  }

  public void onChange(boolean paramBoolean)
  {
    n.a(this.a, Integer.valueOf(b.a(n.a(this.a)).b()));
    if (n.b(this.a).intValue() != 0)
    {
      n.a(this.a).getContentResolver().unregisterContentObserver(this);
      if (d.d(n.a(this.a)))
        this.a.c();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.mipush.sdk.o
 * JD-Core Version:    0.6.0
 */