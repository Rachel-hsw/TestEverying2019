package com.umeng.message;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.xiaomi.mipush.sdk.d;

class MiPushRegistar$2
  implements Runnable
{
  public void run()
  {
    d.h(this.a);
    SharedPreferences.Editor localEditor = this.a.getSharedPreferences("pref_xiaomi", 4).edit();
    localEditor.putString("xiaomi_regid", "");
    localEditor.commit();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.MiPushRegistar.2
 * JD-Core Version:    0.6.0
 */