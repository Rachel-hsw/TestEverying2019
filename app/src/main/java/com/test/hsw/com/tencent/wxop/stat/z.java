package com.tencent.wxop.stat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.wxop.stat.b.f;

final class z extends BroadcastReceiver
{
  z(g paramg)
  {
  }

  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (g.a(this.cm) != null)
      g.a(this.cm).a(new ae(this));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.wxop.stat.z
 * JD-Core Version:    0.6.0
 */