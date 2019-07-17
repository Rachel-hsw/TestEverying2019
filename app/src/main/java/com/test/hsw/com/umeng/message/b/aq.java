package com.umeng.message.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.ta.utdid2.device.UTDevice;
import java.util.LinkedHashMap;
import java.util.Map;
import org.android.agoo.e.b;

public final class aq
{
  private static final String A = "agoo_checkpackage_stop";
  private static final String B = "agoo_start_method";
  private static final String C = "agoo_pushService_connect_success";
  private static final String D = "agoo_pushservice_connect_error";
  private static final String E = "agoo_somanager_start";
  private static final String F = "agoo_event_register_log";
  private static final String G = "agoo_event_election_log";
  private static final String H = "agoo_event_election_result_log";
  private static final String I = "agoo_event_register_begin_log";
  private static final String J = "agoo_event_force_http";
  private static final String K = "agoo_event_force_WifiProxy";
  private static volatile boolean L = false;
  private static volatile org.android.agoo.e.a M = null;
  private static final String N = "utdid_null";
  private static final String O = "utdid_error";
  private static final int a = 273791437;
  private static final int b = 66002;
  private static final String c = "agoo_connect";
  private static final String d = "agoo_connect_timeout";
  private static final String e = "agoo_service";
  private static final String f = "agoo_ervice_sec_error_start";

  @Deprecated
  private static final String g = "agoo_service_error_start";
  private static final String h = "agoo_message";

  @Deprecated
  private static final String i = "agoo_message_http_error";
  private static final String j = "agoo_message_parse_error";
  private static final String k = "agoo_message_decrypted_error";
  private static final String l = "agoo_message_body_null";

  @Deprecated
  private static final String m = "agoo_message_size_large";

  @Deprecated
  private static final String n = "agoo_event_message_notify";
  private static final String o = "agoo_election_times";

  @Deprecated
  private static final String p = "agoo_election";
  private static final String q = "agoo_election_no_result";

  @Deprecated
  private static final String r = "agoo_election_error";

  @Deprecated
  private static final String s = "agoo_election_register";
  private static final String t = "agoo_sysfile_error";
  private static final String u = "agoo_register_error";

  @Deprecated
  private static final String v = "agoo_unregister";
  private static final String w = "agoo_register";

  @Deprecated
  private static final String x = "agoo_app_ping";

  @Deprecated
  private static final String y = "agoo_android_module";
  private static final String z = "agoo_spyd_force_chunked";

  public static final void a(Context paramContext)
  {
    try
    {
      if (L)
        return;
      M = b.a().a(paramContext);
      if (M != null)
      {
        L = true;
        return;
      }
    }
    catch (Throwable localThrowable)
    {
    }
  }

  @Deprecated
  public static final void a(Context paramContext, int paramInt, String paramString)
  {
    try
    {
      String str = af.n(paramContext);
      a(paramContext);
      if (M != null)
        M.a(273791437, "agoo_connect", Integer.valueOf(paramInt), paramString, new String[] { str });
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static final void a(Context paramContext, long paramLong)
  {
    try
    {
      String str = af.n(paramContext);
      long l1 = System.currentTimeMillis() - paramLong;
      a(paramContext);
      if (M != null)
        M.a(273791437, "agoo_service", "" + paramLong, "" + l1, new String[] { str });
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static final void a(Context paramContext, long paramLong1, long paramLong2)
  {
    try
    {
      String str = af.n(paramContext);
      a(paramContext);
      if (M != null)
        M.a(273791437, "agoo_connect_timeout", "" + paramLong1, "" + paramLong2, new String[] { str });
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static final void a(Context paramContext, long paramLong, String paramString)
  {
    a(paramContext, paramLong, paramString, null);
  }

  public static final void a(Context paramContext, long paramLong, String paramString1, String paramString2)
  {
    if (paramLong != -1L);
    while (true)
    {
      try
      {
        l1 = System.currentTimeMillis() - paramLong;
        String str = af.n(paramContext);
        a(paramContext);
        if (M == null)
          continue;
        M.a(273791437, "agoo_connect", "" + l1, "" + paramLong, new String[] { str, paramString1, paramString2 });
        return;
      }
      catch (Throwable localThrowable)
      {
        return;
      }
      long l1 = 0L;
    }
  }

  @Deprecated
  public static final void a(Context paramContext, Object paramObject, String[] paramArrayOfString)
  {
    try
    {
      String str = af.n(paramContext);
      a(paramContext);
      if (M != null)
        M.a(273791437, "agoo_android_module", str, paramObject, paramArrayOfString);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  @Deprecated
  public static final void a(Context paramContext, String paramString)
  {
    try
    {
      String str = af.n(paramContext);
      a(paramContext);
      if (M != null)
        M.a(273791437, "agoo_app_ping", paramString, str);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  @Deprecated
  public static final void a(Context paramContext, String paramString, long paramLong1, long paramLong2)
  {
    try
    {
      String str1 = af.n(paramContext);
      a(paramContext);
      if (M != null)
      {
        org.android.agoo.e.a locala = M;
        String str2 = "" + paramLong1;
        String[] arrayOfString = new String[2];
        arrayOfString[0] = str1;
        arrayOfString[1] = ("" + paramLong2);
        locala.a(273791437, "agoo_election_register", paramString, str2, arrayOfString);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  @Deprecated
  public static final void a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      String str = af.n(paramContext);
      a(paramContext);
      if (M != null)
        M.a(273791437, "agoo_event_message_notify", paramString1, paramString2, new String[] { str });
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static final void a(Context paramContext, Throwable paramThrowable)
  {
    try
    {
      String str = af.n(paramContext);
      a(paramContext);
      if (M != null)
        M.a(273791437, "agoo_spyd_force_chunked", str, paramThrowable);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static final void a(Throwable paramThrowable)
  {
    try
    {
      if (M != null)
        M.a(paramThrowable);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static final void b(Context paramContext)
  {
    try
    {
      if (!L)
        return;
      L = false;
      if (M != null)
      {
        M.a(paramContext);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static final void b(Context paramContext, String paramString)
  {
    try
    {
      String str = af.n(paramContext);
      a(paramContext);
      if (M != null)
        M.a(273791437, "agoo_message", paramString, str);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  @Deprecated
  public static final void b(Context paramContext, String paramString, long paramLong1, long paramLong2)
  {
    try
    {
      String str1 = af.n(paramContext);
      a(paramContext);
      if (M != null)
      {
        org.android.agoo.e.a locala = M;
        String str2 = "" + paramLong1;
        String[] arrayOfString = new String[2];
        arrayOfString[0] = str1;
        arrayOfString[1] = ("" + paramLong2);
        locala.a(273791437, "agoo_election", paramString, str2, arrayOfString);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static final void b(Context paramContext, String paramString1, String paramString2)
  {
    String str = af.n(paramContext);
    a(paramContext);
    if (M != null)
      M.a(273791437, "agoo_message_decrypted_error", paramString1, paramString2, new String[] { str });
  }

  public static final String c(Context paramContext)
  {
    String str = "utdid_error";
    try
    {
      a(paramContext);
      str = UTDevice.getUtdid(paramContext);
      if (TextUtils.isEmpty(str))
        str = "utdid_null";
      return str;
    }
    catch (Throwable localThrowable)
    {
    }
    return str;
  }

  @Deprecated
  public static final void c(Context paramContext, String paramString)
  {
    try
    {
      String str = af.n(paramContext);
      a(paramContext);
      if (M != null)
        M.a(273791437, "agoo_message_http_error", paramString, str);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static final void c(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      String str1 = af.n(paramContext);
      String str2 = paramContext.getPackageName();
      a(paramContext);
      if (M != null)
        M.a(273791437, "agoo_start_method", str1, paramString1, new String[] { paramString2, str2 });
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static final void d(Context paramContext)
  {
    try
    {
      String str = af.n(paramContext);
      a(paramContext);
      if (M != null)
        M.a(273791437, "agoo_ervice_sec_error_start", str);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static final void d(Context paramContext, String paramString)
  {
    try
    {
      String str = af.n(paramContext);
      a(paramContext);
      if (M != null)
        M.a(273791437, "agoo_message_parse_error", paramString, str);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static final void d(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      String str = af.n(paramContext);
      a(paramContext);
      if (M != null)
        M.a(66002, "agoo_event_register_log", str, paramString1, new String[] { paramString2 });
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  @Deprecated
  public static final void e(Context paramContext)
  {
    try
    {
      String str = af.n(paramContext);
      a(paramContext);
      if (M != null)
        M.a(273791437, "agoo_service_error_start", str);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static final void e(Context paramContext, String paramString)
  {
    try
    {
      String str = af.n(paramContext);
      a(paramContext);
      if (M != null)
        M.a(273791437, "agoo_message_body_null", paramString, str);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static final void e(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      String str = af.n(paramContext);
      a(paramContext);
      if (M != null)
        M.a(66002, "agoo_event_election_log", str, paramString1, new String[] { paramString2 });
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.d("UTHelper", "doElectionLog error,exception=" + localThrowable);
    }
  }

  @Deprecated
  public static final void f(Context paramContext)
  {
    try
    {
      String str = af.n(paramContext);
      a(paramContext);
      if (M != null)
        M.a(273791437, "agoo_message_size_large", "5", str);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  @Deprecated
  public static final void f(Context paramContext, String paramString)
  {
    try
    {
      String str = af.n(paramContext);
      a(paramContext);
      if (M != null)
        M.a(273791437, "agoo_election_error", str);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static final void g(Context paramContext)
  {
    try
    {
      String str = af.n(paramContext);
      if (M != null)
        M.a(273791437, "agoo_election_times", str);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static final void g(Context paramContext, String paramString)
  {
    try
    {
      String str = af.n(paramContext);
      a(paramContext);
      if (M != null)
        M.a(273791437, "agoo_sysfile_error", paramString, str);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static final void h(Context paramContext)
  {
    try
    {
      String str = af.n(paramContext);
      if (M != null)
        M.a(273791437, "agoo_election_no_result", str);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static final void h(Context paramContext, String paramString)
  {
    try
    {
      String str = af.n(paramContext);
      a(paramContext);
      if (M != null)
        M.a(273791437, "agoo_register_error", paramString, str);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static final void i(Context paramContext)
  {
    try
    {
      String str = af.n(paramContext);
      a(paramContext);
      if (M != null)
        M.a(273791437, "agoo_register", str);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static final void i(Context paramContext, String paramString)
  {
    try
    {
      String str = af.n(paramContext);
      a(paramContext);
      if (M != null)
        M.a(273791437, paramString, str);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  @Deprecated
  public static final void j(Context paramContext)
  {
    try
    {
      String str = af.n(paramContext);
      a(paramContext);
      if (M != null)
        M.a(273791437, "agoo_unregister", str);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static final void j(Context paramContext, String paramString)
  {
    if (paramString == null);
    while (true)
    {
      return;
      try
      {
        String str = af.n(paramContext);
        a(paramContext);
        if (M == null)
          continue;
        M.a(66002, "agoo_event_election_result_log", str, null, new String[] { paramString });
        return;
      }
      catch (Throwable localThrowable)
      {
        Log.d("UTHelper", "doConnectLog error,exception=" + localThrowable);
      }
    }
  }

  public static final void k(Context paramContext)
  {
    try
    {
      String str1 = af.n(paramContext);
      String str2 = paramContext.getPackageName();
      a(paramContext);
      if (M != null)
        M.a(273791437, "agoo_checkpackage_stop", str1, str2);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static final void k(Context paramContext, String paramString)
  {
    if (paramString == null);
    while (true)
    {
      return;
      try
      {
        String str = af.n(paramContext);
        a(paramContext);
        if (M == null)
          continue;
        M.a(66002, "agoo_event_register_begin_log", str, null, new String[] { paramString });
        return;
      }
      catch (Throwable localThrowable)
      {
        Log.d("UTHelper", "doConnectLog error,exception=" + localThrowable);
      }
    }
  }

  public static final void l(Context paramContext)
  {
    try
    {
      String str1 = af.n(paramContext);
      SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("AGOO_CONNECT", 4);
      String str2 = localSharedPreferences.getString("AGOO_CONNECT_HOST", null);
      int i1 = localSharedPreferences.getInt("AGOO_CONNECT_PORT", -1);
      String str3 = paramContext.getSharedPreferences("AppStore", 4).getString("agoo_connect_type", null);
      String str4 = new bk(paramContext).c();
      a(paramContext);
      if (M != null)
      {
        org.android.agoo.e.a locala = M;
        String[] arrayOfString = new String[1];
        arrayOfString[0] = ("ip=" + str2 + "&port=" + Integer.toString(i1) + "&netType" + str4 + "&sdkVersion=" + af.a());
        locala.a(273791437, "agoo_pushService_connect_success", str1, str3, arrayOfString);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static final void m(Context paramContext)
  {
    try
    {
      String str1 = af.n(paramContext);
      SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("AGOO_CONNECT", 4);
      String str2 = localSharedPreferences.getString("AGOO_CONNECT_HOST", null);
      int i1 = localSharedPreferences.getInt("AGOO_CONNECT_PORT", -1);
      String str3 = paramContext.getSharedPreferences("AppStore", 4).getString("agoo_connect_type", null);
      String str4 = new bk(paramContext).c();
      LinkedHashMap localLinkedHashMap1 = org.android.a.z(paramContext);
      a(paramContext);
      if ((localLinkedHashMap1 != null) && (localLinkedHashMap1.size() > 0) && (M != null))
      {
        org.android.agoo.e.a locala2 = M;
        String[] arrayOfString2 = new String[1];
        arrayOfString2[0] = ("ip=" + str2 + "&port=" + Integer.toString(i1) + "&netType=" + str4 + "&sdkVersion=" + af.a() + "&errorId=" + (String)localLinkedHashMap1.get("errorId") + "&url=" + (String)localLinkedHashMap1.get("url"));
        locala2.a(273791437, "agoo_pushservice_connect_error", str1, str3, arrayOfString2);
      }
      LinkedHashMap localLinkedHashMap2 = org.android.a.A(paramContext);
      if ((localLinkedHashMap2 != null) && (localLinkedHashMap2.size() > 0) && (M != null))
      {
        org.android.agoo.e.a locala1 = M;
        String[] arrayOfString1 = new String[1];
        arrayOfString1[0] = ("ip=" + str2 + "&port=" + Integer.toString(i1) + "&netType=" + str4 + "&sdkVersion=" + af.a() + "&dnsErrorId=" + (String)localLinkedHashMap2.get("dnsErrorId") + "&dnsUrl=" + (String)localLinkedHashMap2.get("dnsUrl"));
        locala1.a(273791437, "agoo_pushservice_connect_error", str1, str3, arrayOfString1);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static final void n(Context paramContext)
  {
    try
    {
      a(paramContext);
      if (M != null)
        M.a(273791437, "agoo_somanager_start", "");
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static final void o(Context paramContext)
  {
    try
    {
      String str1 = af.n(paramContext);
      a(paramContext);
      bk localbk = new bk(paramContext);
      String str2 = localbk.c();
      if (M != null)
        M.a(66002, "agoo_event_force_http", str1, "netType=" + str2 + "&isWapNetwork=" + localbk.a() + "&sdkVersion=" + af.a());
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.d("UTHelper", "doElectionLog error,exception=" + localThrowable);
    }
  }

  public static final void p(Context paramContext)
  {
    try
    {
      String str1 = af.n(paramContext);
      a(paramContext);
      bk localbk = new bk(paramContext);
      String str2 = localbk.c();
      if (M != null)
        M.a(66002, "agoo_event_force_WifiProxy", str1, "netType=" + str2 + "&isWapNetwork=" + localbk.a() + "&sdkVersion=" + af.a());
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.d("UTHelper", "doElectionLog error,exception=" + localThrowable);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.aq
 * JD-Core Version:    0.6.0
 */