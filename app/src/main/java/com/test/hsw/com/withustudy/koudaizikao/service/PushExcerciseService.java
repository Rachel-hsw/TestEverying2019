package com.withustudy.koudaizikao.service;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.android.http.n.a;
import com.google.gson.Gson;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.entity.req.UserSubject;
import com.withustudy.koudaizikao.entity.req.push.PushState;
import com.withustudy.koudaizikao.entity.req.push.UserAnswers;
import com.withustudy.koudaizikao.g.h;
import java.util.HashMap;
import java.util.Map;

public class PushExcerciseService extends Service
  implements n.a
{
  public HashMap<Integer, UserAnswers> a = new HashMap();
  private PushState b;
  private String c;

  public void a(UserSubject paramUserSubject)
  {
    new Thread(new a(this, paramUserSubject)).start();
  }

  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }

  public void onError(String paramString1, String paramString2, int paramInt)
  {
  }

  public void onRequest()
  {
  }

  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramIntent != null)
    {
      h.a("onStartCommand");
      h.a("onStartCommand");
      h.a("onStartCommand");
      h.a("onStartCommand");
      this.c = paramIntent.getExtras().getString("excerciseBrushId");
      h.a("启动服务excerciseBrushId=" + this.c);
    }
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    Gson localGson;
    if (paramString1 != null)
    {
      h.a("推送回复:: " + paramString1);
      localGson = c.a();
    }
    switch (paramInt)
    {
    default:
      return;
    case 0:
    }
    try
    {
      this.b = ((PushState)localGson.fromJson(paramString1, PushState.class));
      if (this.b != null)
      {
        "OK".equals(this.b.getStatus());
        return;
      }
    }
    catch (Exception localException)
    {
      h.a("推送答案解析异常:: " + localException.getMessage());
      return;
    }
    h.a("推送异常:: ");
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.service.PushExcerciseService
 * JD-Core Version:    0.6.0
 */