package org.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import org.android.agoo.e.b;

public class a
{
  public static final String A = "app_log_to_file";
  public static final String B = "logger_class_name";
  public static final String C = "agoo_release_time";
  public static final String D = "agoo_service_mode";
  public static final String E = "agoo_spdy_connect";
  public static final String F = "agoo_http_connect";
  public static final String G = "update_app_last_app_version ";
  public static final String H = "agoo_ping_message";
  public static final String I = "agoo_service_protect";
  public static final String J = "agoo_push_errorid";
  public static final String K = "agoo_push_path";
  public static final String L = "agoo_connect_type";
  public static final String M = "agoo_dns_errorid";
  public static final String N = "agoo_dns_path";
  public static final String O = "agoo_dns_eventid";
  public static final String P = "agoo_xtoken ";
  public static final String Q = "app_push_test_port";
  public static final String R = "app_push_test_host";
  public static final String S = "agoo_notic_election_result";
  public static final String T = "agoo_so_mangager_timeout";
  private static final String U = "old_app_device_token";
  public static final String a = "AppStore";
  public static final int b = 3000;
  public static final String c = "app_device_token";
  public static final String d = "app_version";
  public static final String e = "app_key";
  public static final String f = "app_sercet";
  public static final String g = "app_tt_id";
  public static final String h = "app_device_token_temp";
  public static final String i = "app_key_temp";
  public static final String j = "app_sercet_temp";
  public static final String k = "app_tt_id_temp";
  public static final String l = "unregister_flag";
  public static final String m = "app_push_user_token";
  public static final String n = "agoo_start_time";
  public static final String o = "agoo_autoupdate";
  public static final String p = "agoo_multiplex";
  public static final String q = "agoo_spdy";
  public static final String r = "agoo_updateCycle";
  public static final String s = "agoo_postData";
  public static final String t = "agoo_update_time";
  public static final String u = "agoo_ifNeedNotAutoUpdate";
  public static final String v = "agoo_ifNeedAutoUpdate";
  public static final String w = "agoo_end_time";
  public static final String x = "agoo_security_mode";
  public static final String y = "agoo_mode";
  public static final String z = "app_debug";

  // ERROR //
  public static java.util.LinkedHashMap<String, String> A(Context paramContext)
  {
    // Byte code:
    //   0: new 154	java/util/LinkedHashMap
    //   3: dup
    //   4: invokespecial 155	java/util/LinkedHashMap:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: invokestatic 158	org/android/a:H	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   12: astore_3
    //   13: aload_3
    //   14: ldc 44
    //   16: aconst_null
    //   17: invokeinterface 164 3 0
    //   22: astore 4
    //   24: aload_3
    //   25: ldc 47
    //   27: aconst_null
    //   28: invokeinterface 164 3 0
    //   33: astore 5
    //   35: aload_3
    //   36: ldc 50
    //   38: aconst_null
    //   39: invokeinterface 164 3 0
    //   44: astore 6
    //   46: aload_1
    //   47: ldc 166
    //   49: aload 4
    //   51: invokevirtual 170	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   54: pop
    //   55: aload_1
    //   56: ldc 172
    //   58: aload 5
    //   60: invokevirtual 170	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   63: pop
    //   64: aload_1
    //   65: ldc 174
    //   67: aload 6
    //   69: invokevirtual 170	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   72: pop
    //   73: aload_1
    //   74: areturn
    //   75: astore 10
    //   77: aconst_null
    //   78: areturn
    //   79: astore_2
    //   80: aload_1
    //   81: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   0	8	75	java/lang/Throwable
    //   8	73	79	java/lang/Throwable
  }

  // ERROR //
  public static java.util.LinkedHashMap<String, String> B(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 176
    //   3: iconst_4
    //   4: invokevirtual 182	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   7: astore 5
    //   9: aload 5
    //   11: ldc 184
    //   13: aconst_null
    //   14: invokeinterface 164 3 0
    //   19: astore 6
    //   21: aload 5
    //   23: ldc 186
    //   25: iconst_m1
    //   26: invokeinterface 190 3 0
    //   31: istore 7
    //   33: aload_0
    //   34: ldc 71
    //   36: iconst_4
    //   37: invokevirtual 182	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   40: ldc 41
    //   42: aconst_null
    //   43: invokeinterface 164 3 0
    //   48: astore 8
    //   50: new 154	java/util/LinkedHashMap
    //   53: dup
    //   54: invokespecial 155	java/util/LinkedHashMap:<init>	()V
    //   57: astore_2
    //   58: aload_2
    //   59: ldc 192
    //   61: aload 6
    //   63: invokevirtual 170	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   66: pop
    //   67: aload_2
    //   68: ldc 194
    //   70: iload 7
    //   72: invokestatic 200	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   75: invokevirtual 170	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   78: pop
    //   79: aload_2
    //   80: ldc 202
    //   82: aload 8
    //   84: invokevirtual 170	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   87: pop
    //   88: aload_2
    //   89: ldc 204
    //   91: aload_0
    //   92: invokestatic 207	org/android/a:d	(Landroid/content/Context;)Ljava/lang/String;
    //   95: invokevirtual 170	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   98: pop
    //   99: aload_2
    //   100: ldc 209
    //   102: aload_0
    //   103: invokestatic 211	org/android/a:g	(Landroid/content/Context;)Ljava/lang/String;
    //   106: invokevirtual 170	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   109: pop
    //   110: aload_2
    //   111: ldc 213
    //   113: aload_0
    //   114: invokestatic 216	org/android/a:s	(Landroid/content/Context;)J
    //   117: invokestatic 221	java/lang/Long:toString	(J)Ljava/lang/String;
    //   120: invokevirtual 170	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   123: pop
    //   124: aload_2
    //   125: areturn
    //   126: astore_1
    //   127: aconst_null
    //   128: astore_2
    //   129: aload_1
    //   130: astore_3
    //   131: ldc 223
    //   133: new 225	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   140: ldc 228
    //   142: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload_3
    //   146: invokevirtual 236	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   149: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 238	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokestatic 243	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   158: pop
    //   159: aload_2
    //   160: areturn
    //   161: astore_3
    //   162: goto -31 -> 131
    //
    // Exception table:
    //   from	to	target	type
    //   0	58	126	java/lang/Throwable
    //   58	124	161	java/lang/Throwable
  }

  // ERROR //
  public static java.util.LinkedHashMap<String, String> C(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 176
    //   3: iconst_4
    //   4: invokevirtual 182	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   7: astore 5
    //   9: aload 5
    //   11: ldc 184
    //   13: aconst_null
    //   14: invokeinterface 164 3 0
    //   19: astore 6
    //   21: aload 5
    //   23: ldc 186
    //   25: iconst_m1
    //   26: invokeinterface 190 3 0
    //   31: istore 7
    //   33: aload_0
    //   34: ldc 71
    //   36: iconst_4
    //   37: invokevirtual 182	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   40: ldc 41
    //   42: aconst_null
    //   43: invokeinterface 164 3 0
    //   48: astore 8
    //   50: new 154	java/util/LinkedHashMap
    //   53: dup
    //   54: invokespecial 155	java/util/LinkedHashMap:<init>	()V
    //   57: astore_2
    //   58: aload_2
    //   59: ldc 192
    //   61: aload 6
    //   63: invokevirtual 170	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   66: pop
    //   67: aload_2
    //   68: ldc 194
    //   70: iload 7
    //   72: invokestatic 200	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   75: invokevirtual 170	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   78: pop
    //   79: aload_2
    //   80: ldc 202
    //   82: aload 8
    //   84: invokevirtual 170	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   87: pop
    //   88: aload_2
    //   89: ldc 204
    //   91: aload_0
    //   92: invokestatic 207	org/android/a:d	(Landroid/content/Context;)Ljava/lang/String;
    //   95: invokevirtual 170	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   98: pop
    //   99: aload_2
    //   100: ldc 209
    //   102: aload_0
    //   103: invokestatic 211	org/android/a:g	(Landroid/content/Context;)Ljava/lang/String;
    //   106: invokevirtual 170	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   109: pop
    //   110: aload_2
    //   111: ldc 213
    //   113: aload_0
    //   114: invokestatic 216	org/android/a:s	(Landroid/content/Context;)J
    //   117: invokestatic 221	java/lang/Long:toString	(J)Ljava/lang/String;
    //   120: invokevirtual 170	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   123: pop
    //   124: aload_0
    //   125: invokestatic 245	org/android/a:z	(Landroid/content/Context;)Ljava/util/LinkedHashMap;
    //   128: astore 15
    //   130: aload 15
    //   132: ifnull +17 -> 149
    //   135: aload 15
    //   137: invokevirtual 249	java/util/LinkedHashMap:size	()I
    //   140: ifle +9 -> 149
    //   143: aload_2
    //   144: aload 15
    //   146: invokevirtual 253	java/util/LinkedHashMap:putAll	(Ljava/util/Map;)V
    //   149: aload_0
    //   150: invokestatic 255	org/android/a:A	(Landroid/content/Context;)Ljava/util/LinkedHashMap;
    //   153: astore 16
    //   155: aload 16
    //   157: ifnull +17 -> 174
    //   160: aload 16
    //   162: invokevirtual 249	java/util/LinkedHashMap:size	()I
    //   165: ifle +9 -> 174
    //   168: aload_2
    //   169: aload 16
    //   171: invokevirtual 253	java/util/LinkedHashMap:putAll	(Ljava/util/Map;)V
    //   174: aload_2
    //   175: areturn
    //   176: astore_1
    //   177: aconst_null
    //   178: astore_2
    //   179: aload_1
    //   180: astore_3
    //   181: ldc_w 257
    //   184: new 225	java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   191: ldc 228
    //   193: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: aload_3
    //   197: invokevirtual 236	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   200: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: invokevirtual 238	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: invokestatic 243	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   209: pop
    //   210: aload_2
    //   211: areturn
    //   212: astore_3
    //   213: goto -32 -> 181
    //
    // Exception table:
    //   from	to	target	type
    //   0	58	176	java/lang/Throwable
    //   58	130	212	java/lang/Throwable
    //   135	149	212	java/lang/Throwable
    //   149	155	212	java/lang/Throwable
    //   160	174	212	java/lang/Throwable
  }

  public static final boolean D(Context paramContext)
  {
    try
    {
      boolean bool = H(paramContext).getBoolean("agoo_notic_election_result", false);
      return bool;
    }
    catch (Throwable localThrowable)
    {
    }
    return false;
  }

  public static int E(Context paramContext)
  {
    try
    {
      int i1 = H(paramContext).getInt("agoo_mode", -1);
      return i1;
    }
    catch (Throwable localThrowable)
    {
    }
    return 0;
  }

  public static boolean F(Context paramContext)
  {
    try
    {
      boolean bool = H(paramContext).getBoolean("unregister_flag", false);
      return bool;
    }
    catch (Throwable localThrowable)
    {
    }
    return false;
  }

  public static int G(Context paramContext)
  {
    try
    {
      int i1 = H(paramContext).getInt("agoo_so_mangager_timeout", 600);
      return i1;
    }
    catch (Throwable localThrowable)
    {
    }
    return 0;
  }

  private static SharedPreferences H(Context paramContext)
  {
    return paramContext.getSharedPreferences("AppStore", 4);
  }

  public static final void a(Context paramContext)
  {
    try
    {
      SharedPreferences.Editor localEditor = H(paramContext).edit();
      localEditor.remove("agoo_xtoken ");
      localEditor.commit();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static final void a(Context paramContext, int paramInt)
  {
    try
    {
      SharedPreferences.Editor localEditor = H(paramContext).edit();
      localEditor.putInt("update_app_last_app_version ", paramInt);
      localEditor.commit();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = 0 + (60 * (paramInt1 * 60) + paramInt2 * 60);
    int i2 = 0 + (60 * (paramInt3 * 60) + paramInt4 * 60);
    try
    {
      SharedPreferences.Editor localEditor = H(paramContext).edit();
      localEditor.putInt("agoo_start_time", i1);
      localEditor.putInt("agoo_end_time", i2);
      localEditor.commit();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static void a(Context paramContext, long paramLong)
  {
    try
    {
      SharedPreferences.Editor localEditor = H(paramContext).edit();
      localEditor.putLong("agoo_update_time", paramLong);
      localEditor.commit();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static final void a(Context paramContext, String paramString)
  {
    try
    {
      SharedPreferences.Editor localEditor = H(paramContext).edit();
      localEditor.putString("agoo_xtoken ", paramString);
      localEditor.commit();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static void a(Context paramContext, String paramString, int paramInt)
  {
    try
    {
      SharedPreferences.Editor localEditor = H(paramContext).edit();
      localEditor.putInt("app_push_test_port", paramInt);
      localEditor.putString("app_push_test_host", paramString);
      localEditor.commit();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    try
    {
      SharedPreferences localSharedPreferences = H(paramContext);
      String str1 = localSharedPreferences.getString("app_key", null);
      String str2 = localSharedPreferences.getString("app_device_token", null);
      SharedPreferences.Editor localEditor = localSharedPreferences.edit();
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.equals(paramString1, str1)))
        h(paramContext);
      if (!TextUtils.isEmpty(str2))
        localEditor.putString("old_app_device_token", str2);
      localEditor.putString("app_key", paramString1);
      localEditor.putString("app_tt_id", paramString3);
      localEditor.putString("app_key_temp", paramString1);
      localEditor.putString("app_tt_id_temp", paramString3);
      if (!TextUtils.isEmpty(paramString2))
      {
        localEditor.putString("app_sercet", paramString2);
        localEditor.putString("app_sercet_temp", paramString2);
      }
      localEditor.commit();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static void a(Context paramContext, boolean paramBoolean)
  {
    if (paramContext != null);
    try
    {
      SharedPreferences.Editor localEditor = H(paramContext).edit();
      localEditor.putBoolean("agoo_security_mode", paramBoolean);
      localEditor.commit();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      SharedPreferences.Editor localEditor = H(paramContext).edit();
      localEditor.putBoolean("app_debug", paramBoolean1);
      localEditor.putBoolean("app_log_to_file", paramBoolean2);
      localEditor.commit();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong, boolean paramBoolean4)
  {
    try
    {
      SharedPreferences.Editor localEditor = H(paramContext).edit();
      localEditor.putBoolean("agoo_autoupdate", paramBoolean1);
      localEditor.putBoolean("agoo_multiplex", paramBoolean2);
      localEditor.putBoolean("agoo_spdy", paramBoolean2);
      localEditor.putLong("agoo_updateCycle", paramLong);
      localEditor.putBoolean("agoo_postData", paramBoolean4);
      localEditor.commit();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static final String b(Context paramContext)
  {
    try
    {
      String str = H(paramContext).getString("agoo_xtoken ", "");
      return str;
    }
    catch (Throwable localThrowable)
    {
    }
    return "";
  }

  public static void b(Context paramContext, int paramInt)
  {
    if (paramContext != null);
    try
    {
      SharedPreferences.Editor localEditor = H(paramContext).edit();
      localEditor.putInt("agoo_mode", paramInt);
      localEditor.commit();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static void b(Context paramContext, String paramString)
  {
    try
    {
      SharedPreferences.Editor localEditor = H(paramContext).edit();
      localEditor.putString("app_push_user_token", paramString);
      localEditor.commit();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static void b(Context paramContext, boolean paramBoolean)
  {
    try
    {
      SharedPreferences.Editor localEditor = H(paramContext).edit();
      localEditor.putBoolean("agoo_ifNeedNotAutoUpdate", paramBoolean);
      localEditor.commit();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static boolean b(Context paramContext, long paramLong)
  {
    try
    {
      SharedPreferences localSharedPreferences = H(paramContext);
      long l1 = localSharedPreferences.getLong("agoo_update_time", 0L);
      long l2 = localSharedPreferences.getLong("agoo_updateCycle", 86400L);
      long l3 = l1 + l2 * 1000L;
      if ((l3 != 0L) && (paramLong != 0L) && (paramLong - l3 > 0L))
        return true;
    }
    catch (Throwable localThrowable)
    {
    }
    return false;
  }

  public static int c(Context paramContext)
  {
    try
    {
      int i1 = H(paramContext).getInt("update_app_last_app_version ", 0);
      return i1;
    }
    catch (Throwable localThrowable)
    {
    }
    return 0;
  }

  public static void c(Context paramContext, int paramInt)
  {
    if (paramInt == -1);
    try
    {
      paramInt = 1 + w(paramContext);
      SharedPreferences.Editor localEditor = H(paramContext).edit();
      localEditor.putInt("agoo_http_connect", paramInt);
      localEditor.commit();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static void c(Context paramContext, long paramLong)
  {
    try
    {
      SharedPreferences.Editor localEditor = H(paramContext).edit();
      localEditor.putLong("agoo_release_time", paramLong);
      localEditor.commit();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static void c(Context paramContext, String paramString)
  {
    try
    {
      SharedPreferences.Editor localEditor = H(paramContext).edit();
      localEditor.putString("logger_class_name", paramString);
      localEditor.commit();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static void c(Context paramContext, boolean paramBoolean)
  {
    try
    {
      SharedPreferences.Editor localEditor = H(paramContext).edit();
      localEditor.putBoolean("agoo_ifNeedAutoUpdate", paramBoolean);
      localEditor.commit();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static String d(Context paramContext)
  {
    try
    {
      String str = H(paramContext).getString("app_key", "");
      return str;
    }
    catch (Throwable localThrowable)
    {
    }
    return "";
  }

  public static void d(Context paramContext, int paramInt)
  {
    if (paramInt == -1);
    try
    {
      paramInt = 1 + x(paramContext);
      SharedPreferences.Editor localEditor = H(paramContext).edit();
      localEditor.putInt("agoo_spdy_connect", paramInt);
      localEditor.commit();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static void d(Context paramContext, String paramString)
  {
    if (paramContext != null);
    try
    {
      SharedPreferences.Editor localEditor = H(paramContext).edit();
      localEditor.putString("agoo_service_mode", paramString);
      localEditor.commit();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static void d(Context paramContext, boolean paramBoolean)
  {
    try
    {
      SharedPreferences.Editor localEditor = H(paramContext).edit();
      localEditor.putBoolean("agoo_ping_message", paramBoolean);
      localEditor.commit();
      b localb = b.a();
      String[] arrayOfString = new String[2];
      arrayOfString[0] = "agoo_ping_message";
      arrayOfString[1] = ("ping=" + paramBoolean);
      localb.a(paramContext, "agoo_ping_message", arrayOfString);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static String e(Context paramContext)
  {
    try
    {
      String str = H(paramContext).getString("app_tt_id", "");
      return str;
    }
    catch (Throwable localThrowable)
    {
    }
    return "";
  }

  public static final void e(Context paramContext, int paramInt)
  {
    try
    {
      SharedPreferences.Editor localEditor = H(paramContext).edit();
      localEditor.putInt("agoo_so_mangager_timeout", paramInt);
      localEditor.commit();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static void e(Context paramContext, boolean paramBoolean)
  {
    try
    {
      SharedPreferences.Editor localEditor = H(paramContext).edit();
      localEditor.putBoolean("agoo_service_protect", paramBoolean);
      localEditor.commit();
      b localb = b.a();
      String[] arrayOfString = new String[2];
      arrayOfString[0] = "setServiceProtect";
      arrayOfString[1] = ("protect=" + paramBoolean);
      localb.a(paramContext, "setServiceProtect", arrayOfString);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static String f(Context paramContext)
  {
    try
    {
      String str = H(paramContext).getString("app_sercet", "");
      return str;
    }
    catch (Throwable localThrowable)
    {
    }
    return "";
  }

  public static final void f(Context paramContext, boolean paramBoolean)
  {
    try
    {
      SharedPreferences.Editor localEditor = H(paramContext).edit();
      localEditor.putBoolean("agoo_notic_election_result", paramBoolean);
      localEditor.commit();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  // ERROR //
  public static String g(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 158	org/android/a:H	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   4: astore_2
    //   5: aload_2
    //   6: ldc 76
    //   8: ldc_w 317
    //   11: invokeinterface 164 3 0
    //   16: astore_3
    //   17: aload_2
    //   18: ldc 79
    //   20: ldc_w 350
    //   23: invokeinterface 190 3 0
    //   28: istore 5
    //   30: aload_0
    //   31: invokestatic 352	org/android/a:p	(Landroid/content/Context;)I
    //   34: istore 6
    //   36: iload 5
    //   38: ldc_w 350
    //   41: if_icmpeq +58 -> 99
    //   44: iload 5
    //   46: iload 6
    //   48: if_icmpeq +51 -> 99
    //   51: aload_2
    //   52: invokeinterface 268 1 0
    //   57: astore 7
    //   59: aload 7
    //   61: ldc 79
    //   63: ldc_w 350
    //   66: invokeinterface 283 3 0
    //   71: pop
    //   72: aload 7
    //   74: ldc 76
    //   76: invokeinterface 274 2 0
    //   81: pop
    //   82: aload 7
    //   84: invokeinterface 278 1 0
    //   89: pop
    //   90: aconst_null
    //   91: areturn
    //   92: astore_1
    //   93: aconst_null
    //   94: areturn
    //   95: astore 4
    //   97: aload_3
    //   98: areturn
    //   99: aload_3
    //   100: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   0	17	92	java/lang/Throwable
    //   17	36	95	java/lang/Throwable
    //   51	90	95	java/lang/Throwable
  }

  public static final void g(Context paramContext, boolean paramBoolean)
  {
    try
    {
      SharedPreferences.Editor localEditor = H(paramContext).edit();
      localEditor.putBoolean("unregister_flag", paramBoolean);
      localEditor.commit();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static void h(Context paramContext)
  {
    try
    {
      SharedPreferences.Editor localEditor = H(paramContext).edit();
      localEditor.putInt("app_version", -2147483648);
      localEditor.remove("app_device_token");
      localEditor.remove("app_key");
      localEditor.remove("app_sercet");
      localEditor.remove("app_tt_id");
      localEditor.commit();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static String i(Context paramContext)
  {
    try
    {
      String str = H(paramContext).getString("app_push_user_token", "");
      return str;
    }
    catch (Throwable localThrowable)
    {
    }
    return null;
  }

  public static final void j(Context paramContext)
  {
    try
    {
      SharedPreferences.Editor localEditor = H(paramContext).edit();
      localEditor.remove("app_push_user_token");
      localEditor.commit();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static String k(Context paramContext)
  {
    try
    {
      String str = H(paramContext).getString("old_app_device_token", null);
      return str;
    }
    catch (Throwable localThrowable)
    {
    }
    return null;
  }

  public static String l(Context paramContext)
  {
    try
    {
      String str = H(paramContext).getString("logger_class_name", null);
      return str;
    }
    catch (Throwable localThrowable)
    {
    }
    return null;
  }

  public static String m(Context paramContext)
  {
    try
    {
      String str = H(paramContext).getString("agoo_service_mode", "taobao");
      return str;
    }
    catch (Throwable localThrowable)
    {
    }
    return "";
  }

  public static boolean n(Context paramContext)
  {
    return H(paramContext).getBoolean("agoo_security_mode", false);
  }

  public static String o(Context paramContext)
  {
    try
    {
      String str = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      return str;
    }
    catch (Throwable localThrowable)
    {
    }
    return null;
  }

  public static int p(Context paramContext)
  {
    try
    {
      PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      String str = localPackageInfo.versionName;
      int i1 = localPackageInfo.versionCode;
      int i2 = (str + "." + i1).hashCode();
      return i2;
    }
    catch (Throwable localThrowable)
    {
    }
    return -1;
  }

  public static boolean q(Context paramContext)
  {
    try
    {
      boolean bool = H(paramContext).getBoolean("agoo_ifNeedNotAutoUpdate", false);
      return bool;
    }
    catch (Throwable localThrowable)
    {
    }
    return false;
  }

  public static boolean r(Context paramContext)
  {
    try
    {
      boolean bool = H(paramContext).getBoolean("agoo_autoupdate", false);
      return bool;
    }
    catch (Throwable localThrowable)
    {
    }
    return false;
  }

  public static long s(Context paramContext)
  {
    try
    {
      long l1 = H(paramContext).getLong("agoo_release_time", 0L);
      return l1;
    }
    catch (Throwable localThrowable)
    {
    }
    return 0L;
  }

  public static boolean t(Context paramContext)
  {
    try
    {
      boolean bool = H(paramContext).getBoolean("agoo_ifNeedAutoUpdate", true);
      return bool;
    }
    catch (Throwable localThrowable)
    {
    }
    return false;
  }

  public static boolean u(Context paramContext)
  {
    try
    {
      boolean bool = H(paramContext).getBoolean("agoo_postData", false);
      return bool;
    }
    catch (Throwable localThrowable)
    {
    }
    return false;
  }

  public static boolean v(Context paramContext)
  {
    try
    {
      boolean bool = H(paramContext).getBoolean("agoo_ping_message", true);
      return bool;
    }
    catch (Throwable localThrowable)
    {
    }
    return false;
  }

  public static int w(Context paramContext)
  {
    try
    {
      int i1 = H(paramContext).getInt("agoo_http_connect", 0);
      return i1;
    }
    catch (Throwable localThrowable)
    {
    }
    return 0;
  }

  public static int x(Context paramContext)
  {
    try
    {
      int i1 = H(paramContext).getInt("agoo_spdy_connect", 0);
      return i1;
    }
    catch (Throwable localThrowable)
    {
    }
    return 0;
  }

  public static boolean y(Context paramContext)
  {
    try
    {
      boolean bool = H(paramContext).getBoolean("agoo_service_protect", true);
      return bool;
    }
    catch (Throwable localThrowable)
    {
    }
    return false;
  }

  // ERROR //
  public static java.util.LinkedHashMap<String, String> z(Context paramContext)
  {
    // Byte code:
    //   0: new 154	java/util/LinkedHashMap
    //   3: dup
    //   4: invokespecial 155	java/util/LinkedHashMap:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: invokestatic 158	org/android/a:H	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   12: astore_3
    //   13: aload_3
    //   14: ldc 35
    //   16: aconst_null
    //   17: invokeinterface 164 3 0
    //   22: astore 4
    //   24: aload_3
    //   25: ldc 38
    //   27: aconst_null
    //   28: invokeinterface 164 3 0
    //   33: astore 5
    //   35: aload_1
    //   36: ldc_w 385
    //   39: aload 4
    //   41: invokevirtual 170	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   44: pop
    //   45: aload_1
    //   46: ldc_w 387
    //   49: aload 5
    //   51: invokevirtual 170	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   54: pop
    //   55: aload_1
    //   56: areturn
    //   57: astore 8
    //   59: aconst_null
    //   60: areturn
    //   61: astore_2
    //   62: aload_1
    //   63: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   0	8	57	java/lang/Throwable
    //   8	55	61	java/lang/Throwable
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.android.a
 * JD-Core Version:    0.6.0
 */