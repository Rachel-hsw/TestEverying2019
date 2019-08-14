package com.umeng.message;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.umeng.b.a.b;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MessageSharedPrefs
{
  private static final String a = MessageSharedPrefs.class.getName();
  private static MessageSharedPrefs d;
  private Context b;
  private SharedPreferences c;
  private int e;

  private MessageSharedPrefs(Context paramContext)
  {
    this.b = paramContext;
    this.e = 0;
    if (Build.VERSION.SDK_INT > 11)
      this.e = (0x4 | this.e);
    this.c = paramContext.getSharedPreferences("umeng_message_state", this.e);
    Log.d(a, "Constructor()");
  }

  public static MessageSharedPrefs getInstance(Context paramContext)
  {
    monitorenter;
    try
    {
      if (d == null)
        d = new MessageSharedPrefs(paramContext);
      MessageSharedPrefs localMessageSharedPrefs = d;
      return localMessageSharedPrefs;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  int a()
  {
    return this.c.getInt("KEY_NO_DISTURB_START_HOUR", 23);
  }

  void a(int paramInt)
  {
    this.c.edit().putInt("mute_duration", paramInt).commit();
  }

  void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.c.edit().putInt("KEY_NO_DISTURB_START_HOUR", paramInt1).putInt("KEY_NO_DISTURB_START_MINUTE", paramInt2).putInt("KEY_NO_DISTURB_END_HOUR", paramInt3).putInt("KEY_NO_DISTURB_END_MINUTE", paramInt4).commit();
  }

  void a(String paramString, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = this.c.edit();
    Map localMap = this.c.getAll();
    Iterator localIterator;
    if ((localMap != null) && (localMap.size() > 0))
      localIterator = localMap.entrySet().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        localEditor.putBoolean("KEY_REGISTERED_TO_UMENG_" + paramString, paramBoolean).commit();
        return;
      }
      String str = (String)((Map.Entry)localIterator.next()).getKey();
      if (!str.startsWith("KEY_REGISTERED_TO_UMENG_"))
        continue;
      localEditor.remove(str);
    }
  }

  void a(boolean paramBoolean)
  {
    this.b.getSharedPreferences("umeng_message_state", this.e).edit().putBoolean("KEY_SET_LOCALNOTIFICATION_INTERVAL_LIMIT", paramBoolean).commit();
  }

  boolean a(String paramString)
  {
    String str = "KEY_REGISTERED_TO_UMENG_" + paramString;
    return this.b.getSharedPreferences("umeng_message_state", this.e).getBoolean(str, false);
  }

  public void addAlias(String paramString1, String paramString2)
  {
    String str1 = String.format("ALIAS_%s", new Object[] { paramString2 });
    String str2 = this.c.getString(str1, null);
    int i = getAliasCount();
    SharedPreferences.Editor localEditor = this.c.edit();
    if (str2 == null)
      localEditor.putInt("ALIAS_COUNT", i + 1);
    localEditor.putString(str1, paramString1).commit();
  }

  public void addFailAlias(String paramString1, String paramString2, int paramInt)
  {
    SharedPreferences.Editor localEditor = this.c.edit();
    localEditor.putString("ALIASFAIL_" + paramInt + "_" + paramString2, paramString1);
    localEditor.commit();
  }

  public void addFailAliasTypeSingle(String paramString1, String paramString2, int paramInt)
  {
    String str = getInstance(this.b).getFailAliasType(paramInt);
    if (!getInstance(this.b).isFailAliasType(paramString2, paramInt))
      if (!str.equals(""))
        break label83;
    label83: for (str = str + paramString2; ; str = str + ";" + paramString2)
    {
      if (!str.equals(""))
        getInstance(this.b).saveFailAliasType(str, paramInt);
      return;
    }
  }

  public void addTags(String[] paramArrayOfString)
  {
    SharedPreferences.Editor localEditor = this.c.edit();
    int i = paramArrayOfString.length;
    for (int j = 0; ; j++)
    {
      if (j >= i)
      {
        localEditor.commit();
        return;
      }
      String str = String.format("UMENG_TAG_%s", new Object[] { paramArrayOfString[j] });
      if (this.c.getBoolean(str, false))
        continue;
      localEditor.putBoolean(str, true);
      localEditor.putInt("UMENG_TAG_COUNT", 1 + getTagCount());
    }
  }

  int b()
  {
    return this.c.getInt("KEY_NO_DISTURB_START_MINUTE", 0);
  }

  boolean b(String paramString)
  {
    return this.c.getBoolean("KEY_MSG_RESOURCE_DOWNLOAD_PREFIX" + paramString, false);
  }

  int c()
  {
    return this.c.getInt("KEY_NO_DISTURB_END_HOUR", 7);
  }

  void c(String paramString)
  {
    this.c.edit().putBoolean("KEY_MSG_RESOURCE_DOWNLOAD_PREFIX" + paramString, true).commit();
  }

  int d()
  {
    return this.c.getInt("KEY_NO_DISTURB_END_MINUTE", 0);
  }

  void d(String paramString)
  {
    this.c.edit().remove("KEY_MSG_RESOURCE_DOWNLOAD_PREFIX" + paramString).commit();
  }

  void e()
  {
    this.c.edit().putBoolean("KEY_ENEABLED", true).commit();
  }

  void e(String paramString)
  {
    this.c.edit().putString("last_msg_id", paramString).commit();
  }

  void f()
  {
    this.c.edit().putBoolean("KEY_ENEABLED", false).commit();
  }

  boolean g()
  {
    return this.c.getBoolean("KEY_ENEABLED", false);
  }

  public int getAliasCount()
  {
    return this.c.getInt("ALIAS_COUNT", 0);
  }

  public int getAppLaunchLogSendPolicy()
  {
    return this.c.getInt("KEY_APP_LAUNCH_LOG_SEND_POLICY", -1);
  }

  public long getAppLaunchLogSentAt()
  {
    return this.c.getLong("KEY_LAUNCH_LOG_SENT_MARK", 0L);
  }

  public String getFailAlias(String paramString, int paramInt)
  {
    String str = "ALIASFAIL_" + paramInt + "_" + paramString;
    return this.c.getString(str, "");
  }

  public String getFailAliasType(int paramInt)
  {
    String str = "ALIASFAIL_" + paramInt;
    return this.c.getString(str, "");
  }

  public String getLastAlias(String paramString)
  {
    String str = String.format("ALIAS_%s", new Object[] { paramString });
    return this.c.getString(str, "");
  }

  public boolean getMergeNotificaiton()
  {
    return this.c.getBoolean("KEY_MERGE_NOTIFICATION", true);
  }

  public String getMessageAppKey()
  {
    return this.c.getString("KEY_UMENG_MESSAGE_APP_KEY", "");
  }

  public String getMessageAppSecret()
  {
    return this.c.getString("KEY_UMENG_MESSAGE_APP_SECRET", "");
  }

  public String getMessageChannel()
  {
    return this.c.getString("KEY_UMENG_MESSAGE_APP_CHANNEL", "");
  }

  public boolean getNotificaitonOnForeground()
  {
    return this.c.getBoolean("KEY_SET_NOTIFICATION_ON_FOREGROUND", true);
  }

  public int getNotificationPlayLights()
  {
    return this.c.getInt("KEY_SET_NOTIFICATION_PLAY_LIGHTS", 0);
  }

  public int getNotificationPlaySound()
  {
    return this.c.getInt("KEY_SET_NOTIFICATION_PLAY_SOUND", 0);
  }

  public int getNotificationPlayVibrate()
  {
    return this.c.getInt("KEY_SET_NOTIFICATION_PLAY_VIBRATE", 0);
  }

  public String getPushIntentServiceClass()
  {
    String str1 = this.c.getString("KEY_PUSH_INTENT_SERVICE_CLASSNAME", MsgConstant.DEFAULT_INTENT_SERVICE_CLASS_NAME);
    String str2 = this.c.getString("KEY_SET_PUSH_INTENT_SERVICE_VERSION_CODE", null);
    String str3 = b.d(this.b);
    try
    {
      Class.forName(str1);
      if ((TextUtils.equals(str2, str3)) && (!TextUtils.equals(str3, "Unknown")))
        return str1;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      return MsgConstant.DEFAULT_INTENT_SERVICE_CLASS_NAME;
    }
    return MsgConstant.DEFAULT_INTENT_SERVICE_CLASS_NAME;
  }

  public String getResourcePackageName()
  {
    return this.c.getString("KEY_SET_RESOURCE_PACKAGENAME", "");
  }

  public int getSerialNo()
  {
    return this.b.getSharedPreferences("umeng_message_state", this.e).getInt("serial_no", 1);
  }

  public int getTagCount()
  {
    return this.c.getInt("UMENG_TAG_COUNT", 0);
  }

  public int getTagRemain()
  {
    return this.c.getInt("UMENG_TAG_REMAIN", 64);
  }

  public int getTagSendPolicy()
  {
    return this.c.getInt("KEY_TAG_SEND_POLICY", -1);
  }

  boolean h()
  {
    return this.c.getBoolean("KEY_CACHE_FILE_TRANSFER_TO_SQL", false);
  }

  public boolean hasAppLaunchLogSentToday()
  {
    Calendar localCalendar1 = Calendar.getInstance();
    try
    {
      localCalendar1.setTimeInMillis(MsgLogStore.getInstance(this.b).getMsgConfigInfo_AppLaunchAt());
      Calendar localCalendar2 = Calendar.getInstance();
      if ((localCalendar1.get(6) == localCalendar2.get(6)) && (localCalendar1.get(1) == localCalendar2.get(1)))
        return true;
    }
    catch (Exception localException)
    {
      while (true)
      {
        localException.printStackTrace();
        Log.d(a, localException.toString());
      }
    }
    return false;
  }

  boolean i()
  {
    return this.c.edit().putBoolean("KEY_CACHE_FILE_TRANSFER_TO_SQL", true).commit();
  }

  public boolean isAliasSet(String paramString1, String paramString2)
  {
    String str1 = String.format("ALIAS_%s", new Object[] { paramString2 });
    String str2 = this.c.getString(str1, null);
    return (paramString1 != null) && (paramString1.equals(str2));
  }

  public boolean isAliaseTypeSet(String paramString)
  {
    String str = String.format("ALIAS_%s", new Object[] { paramString });
    return this.c.contains(str);
  }

  public boolean isFailAliasType(String paramString, int paramInt)
  {
    String str = getInstance(this.b).getFailAliasType(paramInt);
    String[] arrayOfString;
    if (str.equals(""))
      arrayOfString = new String[0];
    for (int i = 0; ; i++)
    {
      if (i >= arrayOfString.length)
      {
        return false;
        arrayOfString = str.split(";");
        break;
      }
      if (paramString.equals(arrayOfString[i]))
        return true;
    }
  }

  public boolean isTagSet(String paramString)
  {
    String str = String.format("UMENG_TAG_%s", new Object[] { paramString });
    return this.c.getBoolean(str, false);
  }

  String j()
  {
    return this.c.getString("last_msg_id", "");
  }

  int k()
  {
    return this.c.getInt("mute_duration", 60);
  }

  boolean l()
  {
    return this.c.getBoolean("KEY_SET_LOCALNOTIFICATION_INTERVAL_LIMIT", true);
  }

  public void removeAlias(String paramString1, String paramString2)
  {
    String str = String.format("ALIAS_%s", new Object[] { paramString2 });
    if (this.c.contains(str))
    {
      int i = -1 + getAliasCount();
      SharedPreferences.Editor localEditor = this.c.edit();
      localEditor.remove(str);
      localEditor.putInt("ALIAS_COUNT", i);
      localEditor.commit();
    }
  }

  public void removeFailAlias(String paramString1, String paramString2, int paramInt)
  {
    SharedPreferences.Editor localEditor = this.c.edit();
    localEditor.remove("ALIASFAIL_" + paramInt + "_" + paramString2);
    localEditor.commit();
  }

  public void removeFailAliasType(int paramInt)
  {
    SharedPreferences.Editor localEditor = this.c.edit();
    localEditor.remove("ALIASFAIL_" + paramInt);
    localEditor.commit();
  }

  public void removeFailAliasTypeSingle(String paramString, int paramInt)
  {
    String str1 = getInstance(this.b).getFailAliasType(paramInt);
    String[] arrayOfString;
    if (str1.equals(""))
      arrayOfString = new String[0];
    String str2;
    while (true)
    {
      str2 = "";
      int i = 0;
      if (i >= arrayOfString.length)
      {
        if (!str2.equals(""))
          break;
        getInstance(this.b).removeFailAliasType(paramInt);
        return;
        arrayOfString = str1.split(";");
        continue;
      }
      else
      {
        if (!paramString.equals(arrayOfString[i]))
          if (!str2.equals(""))
            break label128;
        label128: for (str2 = str2 + arrayOfString[i]; ; str2 = str2 + ";" + arrayOfString[i])
        {
          i++;
          break;
        }
      }
    }
    getInstance(this.b).saveFailAliasType(str2, paramInt);
  }

  public void removeTags(String[] paramArrayOfString)
  {
    SharedPreferences.Editor localEditor = this.c.edit();
    int i = paramArrayOfString.length;
    for (int j = 0; ; j++)
    {
      if (j >= i)
      {
        localEditor.commit();
        return;
      }
      String str = String.format("UMENG_TAG_%s", new Object[] { paramArrayOfString[j] });
      if (!this.c.getBoolean(str, false))
        continue;
      localEditor.remove(str);
      localEditor.putInt("UMENG_TAG_COUNT", -1 + getTagCount());
    }
  }

  public void resetTags()
  {
    SharedPreferences.Editor localEditor = this.c.edit();
    Map localMap = this.c.getAll();
    Iterator localIterator;
    if ((localMap != null) && (localMap.size() > 0))
      localIterator = localMap.entrySet().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        localEditor.commit();
        return;
      }
      String str = (String)((Map.Entry)localIterator.next()).getKey();
      if (!str.startsWith("UMENG_TAG_"))
        continue;
      localEditor.remove(str);
    }
  }

  public void saveFailAliasType(String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor = this.c.edit();
    localEditor.putString("ALIASFAIL_" + paramInt, paramString);
    localEditor.commit();
  }

  public void setAppLaunchLogSendPolicy(int paramInt)
  {
    this.c.edit().putInt("KEY_APP_LAUNCH_LOG_SEND_POLICY", paramInt).commit();
  }

  public void setAppLaunchLogSentAt(long paramLong)
  {
    this.c.edit().putLong("KEY_LAUNCH_LOG_SENT_MARK", Calendar.getInstance().getTimeInMillis()).commit();
  }

  public void setMergeNotificaiton(boolean paramBoolean)
  {
    this.c.edit().putBoolean("KEY_MERGE_NOTIFICATION", paramBoolean).commit();
  }

  public void setMessageAppKey(String paramString)
  {
    this.c.edit().putString("KEY_UMENG_MESSAGE_APP_KEY", paramString).commit();
  }

  public void setMessageAppSecret(String paramString)
  {
    this.c.edit().putString("KEY_UMENG_MESSAGE_APP_SECRET", paramString).commit();
  }

  public void setMessageChannel(String paramString)
  {
    this.c.edit().putString("KEY_UMENG_MESSAGE_APP_CHANNEL", paramString).commit();
  }

  public void setNotificaitonOnForeground(boolean paramBoolean)
  {
    this.c.edit().putBoolean("KEY_SET_NOTIFICATION_ON_FOREGROUND", paramBoolean).commit();
  }

  public void setNotificationPlayLights(int paramInt)
  {
    this.c.edit().putInt("KEY_SET_NOTIFICATION_PLAY_LIGHTS", paramInt).commit();
  }

  public void setNotificationPlaySound(int paramInt)
  {
    this.c.edit().putInt("KEY_SET_NOTIFICATION_PLAY_SOUND", paramInt).commit();
  }

  public void setNotificationPlayVibrate(int paramInt)
  {
    this.c.edit().putInt("KEY_SET_NOTIFICATION_PLAY_VIBRATE", paramInt).commit();
  }

  public <U extends UmengBaseIntentService> void setPushIntentServiceClass(Class<U> paramClass)
  {
    if (paramClass == null)
    {
      this.c.edit().remove("KEY_PUSH_INTENT_SERVICE_CLASSNAME").remove("KEY_SET_PUSH_INTENT_SERVICE_VERSION_CODE").commit();
      return;
    }
    String str1 = paramClass.getName();
    String str2 = b.d(this.b);
    this.c.edit().putString("KEY_PUSH_INTENT_SERVICE_CLASSNAME", str1).putString("KEY_SET_PUSH_INTENT_SERVICE_VERSION_CODE", str2).commit();
  }

  public void setResourcePackageName(String paramString)
  {
    this.c.edit().putString("KEY_SET_RESOURCE_PACKAGENAME", paramString).commit();
  }

  public void setSerialNo(int paramInt)
  {
    this.b.getSharedPreferences("umeng_message_state", this.e).edit().putInt("serial_no", paramInt).commit();
  }

  public void setTagRemain(int paramInt)
  {
    SharedPreferences.Editor localEditor = this.c.edit();
    localEditor.putInt("UMENG_TAG_REMAIN", paramInt);
    localEditor.commit();
  }

  public void setTagSendPolicy(int paramInt)
  {
    this.c.edit().putInt("KEY_TAG_SEND_POLICY", paramInt).commit();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.MessageSharedPrefs
 * JD-Core Version:    0.6.0
 */