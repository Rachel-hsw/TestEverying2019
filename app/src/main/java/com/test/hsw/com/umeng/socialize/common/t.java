package com.umeng.socialize.common;

import android.os.Handler;

class t
  implements Runnable
{
  t(s params, Handler paramHandler)
  {
  }

  public void run()
  {
    Object localObject = this.b.b();
    this.a.post(new u(this, localObject));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.common.t
 * JD-Core Version:    0.6.0
 */