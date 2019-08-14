package com.umeng.message;

import com.umeng.b.a.a;
import com.umeng.message.b.dl;
import com.umeng.message.b.ep.e;
import com.umeng.message.b.fb;
import com.umeng.message.protobuffer.PushResponse;
import com.umeng.message.protobuffer.PushResponse.responseCode;
import org.json.JSONObject;

class UTrack$6
  implements Runnable
{
  public void run()
  {
    try
    {
      JSONObject localJSONObject = UTrack.b(this.a);
      String str = UTrack.c(this.a);
      if (!dl.d(str))
      {
        a.c(UTrack.a(), "TestDevice sign =" + str);
        localJSONObject.put("TD", str);
      }
      fb localfb = new fb(UTrack.a(this.a));
      PushResponse localPushResponse = localfb.a(localfb.a(localJSONObject), MsgConstant.REGISTER_ENDPOINT);
      if ((localPushResponse != null) && (localPushResponse.code.equals(PushResponse.responseCode.SUCCESS)))
        UmengRegistrar.a(UTrack.a(this.a), true);
      return;
    }
    catch (ep.e locale)
    {
      locale.printStackTrace();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      UTrack.d(false);
    }
    throw localObject;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.UTrack.6
 * JD-Core Version:    0.6.0
 */