package com.umeng.message;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.mipush.sdk.PushMessageReceiver;
import com.xiaomi.mipush.sdk.e;
import com.xiaomi.mipush.sdk.f;
import java.util.List;
import org.android.agoo.b.a;
import org.json.JSONObject;

public class MiPushBroadcastReceiver extends PushMessageReceiver
{
  private static final String a = "MiPushBroadcastReceiver";
  private static final String b = "time";

  public void onCommandResult(Context paramContext, e parame)
  {
    Log.i("MiPushBroadcastReceiver", "onCommandResult");
    List localList = parame.b();
    String str = null;
    if (localList != null)
    {
      boolean bool = localList.isEmpty();
      str = null;
      if (!bool)
        str = (String)localList.get(0);
    }
    if (!TextUtils.isEmpty(str))
    {
      SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("pref_xiaomi", 4).edit();
      localEditor.putString("xiaomi_regid", str);
      localEditor.commit();
    }
    if (!TextUtils.isEmpty(str))
      a.a(paramContext, str, "1");
    Log.v("MiPushBroadcastReceiver", "onCommandResult is called. regid=" + str);
  }

  public void onReceiveMessage(Context paramContext, f paramf)
  {
    try
    {
      String str1 = paramf.d();
      JSONObject localJSONObject = new JSONObject(str1);
      String str2 = localJSONObject.getString("id");
      String str3 = localJSONObject.getString("type");
      String str4 = localJSONObject.getString("body");
      if ((!TextUtils.isEmpty(str3)) && (!TextUtils.isEmpty(str2)))
      {
        if (TextUtils.isEmpty(str4))
          return;
        String str5 = localJSONObject.getString("encrypted");
        Log.d("MiPushBroadcastReceiver", "mipush onReceive head=" + str5);
        Intent localIntent = new Intent();
        localIntent.putExtra("id", str2);
        localIntent.putExtra("type", str3);
        localIntent.putExtra("body", str4);
        localIntent.putExtra("encrypted", str5);
        if (str1.contains("flag"))
          localIntent.putExtra("flag", localJSONObject.getString("flag"));
        if (str1.contains("report"))
          localIntent.putExtra("report", localJSONObject.getString("report"));
        if (str1.contains("notify"))
          localIntent.putExtra("notify", localJSONObject.getString("notify"));
        if (str1.contains("task_id"))
          localIntent.putExtra("task_id", localJSONObject.getString("task_id"));
        if (str1.contains("time"))
          localIntent.putExtra("time", localJSONObject.getString("time"));
        Log.d("MiPushBroadcastReceiver", "xiaomi MiPushBroadcastReceiver onReceive intent=" + localIntent.toString());
        a.a(paramContext, localIntent, "xiaomi");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      Log.d("MiPushBroadcastReceiver", "xiaomi onReceive error=" + localThrowable);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.MiPushBroadcastReceiver
 * JD-Core Version:    0.6.0
 */