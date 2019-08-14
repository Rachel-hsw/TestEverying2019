package com.tencent.mm.sdk.openapi;

import android.util.Log;
import com.tencent.wxop.stat.e;

class WXApiImplV10$ActivityLifecycleCb$2
  implements Runnable
{
  public void run()
  {
    if ((WXApiImplV10.access$100() != null) && (!WXApiImplV10.ActivityLifecycleCb.access$200(this.this$0)))
    {
      Log.v("MicroMsg.SDK.WXApiImplV10.ActivityLifecycleCb", "WXStat trigger onForeground");
      e.d(WXApiImplV10.ActivityLifecycleCb.access$300(this.this$0), "onForeground_WX");
      WXApiImplV10.ActivityLifecycleCb.access$202(this.this$0, true);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.openapi.WXApiImplV10.ActivityLifecycleCb.2
 * JD-Core Version:    0.6.0
 */