package com.tencent.open.b;

import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.open.a.f;
import com.tencent.open.utils.Global;
import com.tencent.open.utils.OpenConfig;
import java.util.List;

class g$3
  implements Runnable
{
  public void run()
  {
    int i = 1;
    while (true)
    {
      int j;
      int k;
      try
      {
        long l = SystemClock.elapsedRealtime() - this.a;
        Bundle localBundle = new Bundle();
        String str = a.a(Global.getContext());
        localBundle.putString("apn", str);
        localBundle.putString("appid", "1000067");
        localBundle.putString("commandid", this.b);
        localBundle.putString("detail", this.c);
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("network=").append(str).append('&');
        StringBuilder localStringBuilder2 = localStringBuilder1.append("sdcard=");
        if (Environment.getExternalStorageState().equals("mounted"))
        {
          j = i;
          localStringBuilder2.append(j).append('&');
          localStringBuilder1.append("wifi=").append(a.e(Global.getContext()));
          localBundle.putString("deviceInfo", localStringBuilder1.toString());
          k = 100 / this.h.a(this.d);
          if (k > 0)
            break label505;
          label181: localBundle.putString("frequency", i + "");
          localBundle.putString("reqSize", this.e + "");
          localBundle.putString("resultCode", this.d + "");
          localBundle.putString("rspSize", this.f + "");
          localBundle.putString("timeCost", l + "");
          localBundle.putString("uin", "1000");
          b localb = new b(localBundle);
          this.h.d.add(localb);
          int m = this.h.d.size();
          int n = OpenConfig.getInstance(Global.getContext(), null).getInt("Agent_ReportTimeInterval");
          if (n != 0)
            continue;
          n = 10000;
          if ((!this.h.a("report_cgi", m)) && (!this.g))
            continue;
          this.h.b();
          this.h.g.removeMessages(1000);
          return;
          if (!this.h.g.hasMessages(1000))
          {
            Message localMessage = Message.obtain();
            localMessage.what = 1000;
            this.h.g.sendMessageDelayed(localMessage, n);
            return;
          }
        }
      }
      catch (Exception localException)
      {
        f.b(g.a, "--> reportCGI, exception in sub thread.", localException);
        return;
      }
      label505: 
      do
      {
        i = k;
        break label181;
        return;
        j = 0;
        break;
      }
      while (k <= 100);
      i = 100;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.open.b.g.3
 * JD-Core Version:    0.6.0
 */