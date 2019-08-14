package com.umeng.message;

import com.umeng.b.a.a;
import com.umeng.message.b.fb;
import com.umeng.message.protobuffer.PushResponse;
import com.umeng.message.protobuffer.PushResponse.Info;
import com.umeng.message.protobuffer.PushResponse.responseCode;
import org.json.JSONException;
import org.json.JSONObject;

class UTrack$5
  implements Runnable
{
  public void run()
  {
    int i = -1;
    while (true)
    {
      try
      {
        boolean bool = UmengRegistrar.isRegistered(UTrack.a(this.a));
        if (!bool)
          return;
        JSONObject localJSONObject = UTrack.b(this.a);
        fb localfb = new fb(UTrack.a(this.a));
        PushResponse localPushResponse = localfb.a(localfb.a(localJSONObject), MsgConstant.LAUNCH_ENDPOINT);
        if ((localPushResponse == null) || (!localPushResponse.code.equals(PushResponse.responseCode.SUCCESS)))
          continue;
        MsgLogStore.getInstance(UTrack.a(this.a)).setMsgConfigInfo_AppLaunchAt(System.currentTimeMillis());
        if (localPushResponse.info != null)
        {
          j = localPushResponse.info.launchPolicy.intValue();
          a.c(UTrack.a(), "launch_policy:" + j);
          if (localPushResponse.info == null)
            continue;
          i = localPushResponse.info.tagPolicy.intValue();
          a.c(UTrack.a(), "tag_policy:" + i);
          if (j <= 0)
            continue;
          MessageSharedPrefs.getInstance(UTrack.a(this.a)).setAppLaunchLogSendPolicy(j);
          if (i <= 0)
            continue;
          MessageSharedPrefs.getInstance(UTrack.a(this.a)).setTagSendPolicy(i);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        a.c(UTrack.a(), localJSONException.toString());
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        a.c(UTrack.a(), localException.toString());
        return;
      }
      finally
      {
        UTrack.c(false);
      }
      int j = i;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.UTrack.5
 * JD-Core Version:    0.6.0
 */