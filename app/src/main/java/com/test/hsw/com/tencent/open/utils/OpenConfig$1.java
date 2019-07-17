package com.tencent.open.utils;

import android.os.Bundle;
import org.json.JSONObject;

class OpenConfig$1 extends Thread
{
  public void run()
  {
    try
    {
      JSONObject localJSONObject = Util.parseJson(HttpUtils.openUrl2(OpenConfig.a(this.b), "http://cgi.connect.qq.com/qqconnectopen/openapi/policy_conf", "GET", this.a).response);
      OpenConfig.a(this.b, localJSONObject);
      OpenConfig.a(this.b, 0);
      return;
    }
    catch (Exception localException)
    {
      while (true)
        localException.printStackTrace();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.open.utils.OpenConfig.1
 * JD-Core Version:    0.6.0
 */