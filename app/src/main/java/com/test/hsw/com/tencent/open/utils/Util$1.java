package com.tencent.open.utils;

import android.content.Context;
import android.os.Bundle;
import com.tencent.open.a.f;

final class Util$1 extends Thread
{
  public void run()
  {
    try
    {
      HttpUtils.openUrl2(this.a, "http://cgi.qplus.com/report/report", "GET", this.b);
      return;
    }
    catch (Exception localException)
    {
      f.e(Util.a(), "reportBernoulli has exception: " + localException.getMessage());
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.open.utils.Util.1
 * JD-Core Version:    0.6.0
 */