package com.umeng.message.b;

import android.os.SystemClock;
import org.android.agoo.c.b.b;
import org.android.agoo.c.b.e;
import org.apache.http.HttpException;

class bu
  implements Runnable
{
  bu(bs parambs, long paramLong)
  {
  }

  public void run()
  {
    try
    {
      SystemClock.sleep(this.a);
      label7: if ((this.b.a == e.a) && (!this.b.a()))
      {
        this.b.a(true);
        this.b.a(b.r, new HttpException("connectId:[" + this.b.c() + "] http Status code==" + b.r.b()));
        bs.a(this.b);
        this.b.k();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      break label7;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.bu
 * JD-Core Version:    0.6.0
 */