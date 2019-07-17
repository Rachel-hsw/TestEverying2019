package com.tencent.open.b;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.open.a.f;
import com.tencent.open.utils.Global;
import com.tencent.open.utils.OpenConfig;
import com.tencent.open.utils.Util;
import java.util.List;
import java.util.TimeZone;

class g$2
  implements Runnable
{
  public void run()
  {
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("uin", "1000");
      localBundle.putString("imei", c.b(Global.getContext()));
      localBundle.putString("imsi", c.c(Global.getContext()));
      localBundle.putString("android_id", c.d(Global.getContext()));
      localBundle.putString("mac", c.a());
      localBundle.putString("platform", "1");
      localBundle.putString("os_ver", Build.VERSION.RELEASE);
      localBundle.putString("position", Util.getLocation(Global.getContext()));
      localBundle.putString("network", a.a(Global.getContext()));
      localBundle.putString("language", c.b());
      localBundle.putString("resolution", c.a(Global.getContext()));
      localBundle.putString("apn", a.b(Global.getContext()));
      localBundle.putString("model_name", Build.MODEL);
      localBundle.putString("timezone", TimeZone.getDefault().getID());
      localBundle.putString("sdk_ver", "2.8.lite");
      localBundle.putString("qz_ver", Util.getAppVersionName(Global.getContext(), "com.qzone"));
      localBundle.putString("qq_ver", Util.getVersionName(Global.getContext(), "com.tencent.mobileqq"));
      localBundle.putString("qua", Util.getQUA3(Global.getContext(), Global.getPackageName()));
      localBundle.putString("packagename", Global.getPackageName());
      localBundle.putString("app_ver", Util.getAppVersionName(Global.getContext(), Global.getPackageName()));
      if (this.a != null)
        localBundle.putAll(this.a);
      b localb = new b(localBundle);
      this.c.e.add(localb);
      int i = this.c.e.size();
      int j = OpenConfig.getInstance(Global.getContext(), null).getInt("Agent_ReportTimeInterval");
      if (j == 0)
        j = 10000;
      if ((this.c.a("report_via", i)) || (this.b))
      {
        this.c.e();
        this.c.g.removeMessages(1001);
        return;
      }
      if (!this.c.g.hasMessages(1001))
      {
        Message localMessage = Message.obtain();
        localMessage.what = 1001;
        this.c.g.sendMessageDelayed(localMessage, j);
        return;
      }
    }
    catch (Exception localException)
    {
      f.b(g.a, "--> reporVia, exception in sub thread.", localException);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.open.b.g.2
 * JD-Core Version:    0.6.0
 */