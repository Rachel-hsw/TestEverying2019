package com.xiaomi.push.a;

import android.util.Log;
import com.xiaomi.a.a.b.c;
import com.xiaomi.a.a.d.b.b;
import java.util.List;

class g extends b.b
{
  g(f paramf)
  {
  }

  public void b()
  {
    if (f.a().isEmpty())
      return;
    try
    {
      if (!c.d())
      {
        Log.w(f.a(this.a), "SDCard is unavailable.");
        return;
      }
    }
    catch (Exception localException)
    {
      Log.e(f.a(this.a), "", localException);
      return;
    }
    f.b(this.a);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.a.g
 * JD-Core Version:    0.6.0
 */