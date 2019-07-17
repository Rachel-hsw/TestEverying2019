package com.umeng.message;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.umeng.b.a.a;
import com.umeng.message.b.af;
import com.umeng.message.b.ao;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class UmengRegistrar extends org.android.agoo.client.b
{
  private static final String a = "android@umeng";
  private static final String b = UmengRegistrar.class.getName();

  static void a(Context paramContext, boolean paramBoolean)
  {
    if (paramContext == null)
    {
      a.b(b, "setRegisteredToUmeng: null context");
      return;
    }
    String str1 = getRegistrationId(paramContext);
    if (TextUtils.isEmpty(str1))
    {
      a.b(b, "setRegisteredToUmeng: empty registration id");
      return;
    }
    int i = Build.VERSION.SDK_INT;
    int j = 0;
    if (i > 11)
      j = 4;
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("umeng_message_state", j);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    Map localMap = localSharedPreferences.getAll();
    Iterator localIterator;
    if ((localMap != null) && (localMap.size() > 0))
      localIterator = localMap.entrySet().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        localEditor.putBoolean("KEY_REGISTERED_TO_UMENG_" + str1, paramBoolean).commit();
        return;
      }
      String str2 = (String)((Map.Entry)localIterator.next()).getKey();
      if (!str2.startsWith("KEY_REGISTERED_TO_UMENG_"))
        continue;
      localEditor.remove(str2);
    }
  }

  public static final void checkManifest(Context paramContext)
  {
  }

  public static void checkRegisteredToUmeng(Context paramContext)
  {
    if (!isRegisteredToUmeng(paramContext))
      registerToUmeng(paramContext);
  }

  public static org.android.agoo.b getIMtopService(Context paramContext)
  {
    return org.android.agoo.client.b.getMtopService(paramContext);
  }

  public static boolean isRegisteredToUmeng(Context paramContext)
  {
    if (paramContext == null)
    {
      a.b(b, "isRegisteredToUmeng: null context");
      return false;
    }
    String str = getRegistrationId(paramContext);
    if (TextUtils.isEmpty(str))
    {
      a.b(b, "isRegisteredToUmeng: empty registration id");
      return false;
    }
    return MessageSharedPrefs.getInstance(paramContext).a(str);
  }

  public static void register(Context paramContext, String paramString1, String paramString2)
  {
    if (Build.VERSION.SDK_INT < 8)
    {
      a.b(b, "Push SDK does not work for Android Verion < 8");
      return;
    }
    if (TextUtils.isEmpty(paramString1))
      throw new NullPointerException("appKey==null");
    if (TextUtils.isEmpty(paramString2))
      throw new NullPointerException("appSecret==null");
    ao.a(paramContext, new Class[] { SystemReceiver.class, RegistrationReceiver.class, MessageReceiver.class });
    af.e(paramContext, "umeng");
    a(paramContext, "umeng:" + paramString1, paramString2, "android@umeng");
  }

  public static void registerToUmeng(Context paramContext)
  {
    UTrack.getInstance(paramContext).trackRegister();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.UmengRegistrar
 * JD-Core Version:    0.6.0
 */