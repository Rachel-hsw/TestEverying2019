package com.umeng.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import c.a.bt;
import c.a.bu;
import c.a.bz;
import c.a.ca;
import c.a.cb;
import c.a.ch;
import com.umeng.a.w;
import java.util.Iterator;
import org.json.JSONObject;

public class b
{
  public static final String a = "type";
  public static final String b = "package";
  public static final String c = "channel";
  public static final String d = "idmd5";
  public static final String e = "version_code";
  public static final String f = "appkey";
  public static final String g = "sdk_version";
  private static final long k = 600000L;
  private final String h = "last_config_time";
  private final String i = "report_policy";
  private final String j = "online_config";
  private a l = null;
  private d m = null;

  private void a(Context paramContext, c paramc)
  {
    if (paramc.c != -1)
      w.a(paramContext).a(paramc.c, paramc.d);
  }

  private void a(JSONObject paramJSONObject)
  {
    if (this.l != null)
      this.l.a(paramJSONObject);
  }

  private long b(Context paramContext)
  {
    return w.a(paramContext).j().getLong("oc_mdf_told", 0L);
  }

  private void b(Context paramContext, c paramc)
  {
    if ((paramc.a == null) || (paramc.a.length() == 0))
      return;
    SharedPreferences.Editor localEditor = w.a(paramContext).j().edit();
    JSONObject localJSONObject;
    try
    {
      localJSONObject = paramc.a;
      Iterator localIterator = localJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localEditor.putString(str, localJSONObject.getString(str));
      }
    }
    catch (Exception localException)
    {
      bu.c("MobclickAgent", "save online config params", localException);
      return;
    }
    localEditor.commit();
    bu.a("MobclickAgent", "get online setting params: " + localJSONObject);
  }

  public void a()
  {
    this.l = null;
  }

  public void a(Context paramContext)
  {
    if (paramContext == null);
    try
    {
      bu.b("MobclickAgent", "unexpected null context in updateOnlineConfig");
      return;
      new Thread(new b(paramContext.getApplicationContext())).start();
      return;
    }
    catch (Exception localException)
    {
      bu.b("MobclickAgent", "exception in updateOnlineConfig");
    }
  }

  public void a(a parama)
  {
    this.l = parama;
  }

  public void a(d paramd)
  {
    this.m = paramd;
  }

  public void b()
  {
    this.m = null;
  }

  class a extends ca
  {
    private final String e = "http://oc.umeng.com/v2/check_config_update";
    private JSONObject f;

    public a(Context arg2)
    {
      super();
      this.d = "http://oc.umeng.com/v2/check_config_update";
      Context localContext;
      this.f = a(localContext);
    }

    private JSONObject a(Context paramContext)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("type", "online_config");
        localJSONObject.put("appkey", com.umeng.a.a.a(paramContext));
        localJSONObject.put("version_code", bt.c(paramContext));
        localJSONObject.put("package", bt.u(paramContext));
        localJSONObject.put("sdk_version", com.umeng.a.a.a());
        localJSONObject.put("idmd5", ch.b(bt.f(paramContext)));
        localJSONObject.put("channel", com.umeng.a.a.b(paramContext));
        localJSONObject.put("report_policy", w.a(paramContext).c()[0]);
        localJSONObject.put("last_config_time", b.a(b.this, paramContext));
        return localJSONObject;
      }
      catch (Exception localException)
      {
        bu.b("MobclickAgent", "exception in onlineConfigInternal");
      }
      return null;
    }

    public JSONObject a()
    {
      return this.f;
    }

    public String b()
    {
      return this.d;
    }
  }

  public class b extends bz
    implements Runnable
  {
    Context a;

    public b(Context arg2)
    {
      Object localObject;
      this.a = localObject.getApplicationContext();
    }

    private void b()
    {
      c localc = (c)a(new b.a(b.this, this.a), c.class);
      if (localc == null)
      {
        b.a(b.this, null);
        return;
      }
      if (localc.b)
      {
        if (b.a(b.this) != null)
          b.a(b.this).a(localc.c, localc.d);
        b.a(b.this, this.a, localc);
        b.b(b.this, this.a, localc);
        b.a(b.this, localc.a);
        return;
      }
      b.a(b.this, null);
    }

    private boolean c()
    {
      int i = 1;
      if (TextUtils.isEmpty(com.umeng.a.a.a(this.a)))
        bu.b("MobclickAgent", "Appkey is missing ,Please check AndroidManifest.xml");
      label289: label292: 
      while (true)
      {
        return false;
        int j;
        if ((bu.a) && (bt.w(this.a)))
        {
          j = i;
          if (j != 0)
            break label289;
          SharedPreferences localSharedPreferences2 = w.a(this.a).j();
          long l1 = localSharedPreferences2.getLong("last_test_t", 0L);
          long l2 = System.currentTimeMillis();
          if (l2 - l1 <= localSharedPreferences2.getLong("oc_req_i", 600000L))
            break label289;
          localSharedPreferences2.edit().putLong("last_test_t", l2).commit();
        }
        for (int k = i; ; k = 0)
        {
          if ((j == 0) && (k == 0))
            break label292;
          b.d locald = (b.d)a(new b.c(b.this, this.a), b.d.class);
          if (locald == null)
            break;
          SharedPreferences localSharedPreferences1 = w.a(this.a).j();
          if (locald.a > localSharedPreferences1.getLong("oc_mdf_t", 0L));
          while (true)
          {
            SharedPreferences.Editor localEditor = localSharedPreferences1.edit();
            if (locald.b >= 0L)
              localEditor.putLong("oc_req_i", locald.b);
            if (locald.a >= 0L)
            {
              localEditor.putLong("oc_mdf_told", localSharedPreferences1.getLong("oc_mdf_t", 0L));
              localEditor.putLong("oc_mdf_t", locald.a);
            }
            localEditor.commit();
            return i;
            j = 0;
            break;
            i = 0;
          }
        }
      }
    }

    public boolean a()
    {
      return true;
    }

    public void run()
    {
      try
      {
        if (c())
          b();
        return;
      }
      catch (Exception localException)
      {
        b.a(b.this, null);
        bu.c("MobclickAgent", "request online config error", localException);
      }
    }
  }

  class c extends ca
  {
    private final String e = "http://oc.umeng.com/v2/get_update_time";
    private JSONObject f;

    public c(Context arg2)
    {
      super();
      this.d = "http://oc.umeng.com/v2/get_update_time";
      Context localContext;
      this.f = a(localContext);
    }

    private JSONObject a(Context paramContext)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("appkey", com.umeng.a.a.a(paramContext));
        localJSONObject.put("version_code", bt.c(paramContext));
        return localJSONObject;
      }
      catch (Exception localException)
      {
        bu.b("MobclickAgent", "exception in onlineConfigInternal");
      }
      return null;
    }

    public JSONObject a()
    {
      return this.f;
    }

    public String b()
    {
      return this.d;
    }
  }

  public static class d extends cb
  {
    public long a = -1L;
    public long b = -1L;

    public d(JSONObject paramJSONObject)
    {
      super();
      a(paramJSONObject);
    }

    private void a(JSONObject paramJSONObject)
    {
      if (paramJSONObject == null)
        return;
      try
      {
        this.a = paramJSONObject.optLong("last_config_time", -1L);
        this.b = (1000L * (60L * paramJSONObject.optLong("oc_interval", -1L)));
        return;
      }
      catch (Exception localException)
      {
        bu.e("MobclickAgent", "fail to parce online config response", localException);
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.a.a.b
 * JD-Core Version:    0.6.0
 */