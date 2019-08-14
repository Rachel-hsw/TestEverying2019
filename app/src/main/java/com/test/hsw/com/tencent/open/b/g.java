package com.tencent.open.b;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.open.utils.Global;
import com.tencent.open.utils.OpenConfig;
import com.tencent.open.utils.ThreadManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class g
{
  protected static final String a = com.tencent.open.a.f.d + ".ReportManager";
  protected static g b;
  protected Random c = new Random();
  protected List<Serializable> d = Collections.synchronizedList(new ArrayList());
  protected List<Serializable> e = Collections.synchronizedList(new ArrayList());
  protected HandlerThread f = null;
  protected Handler g;

  private g()
  {
    if (this.f == null)
    {
      this.f = new HandlerThread("opensdk.report.handlerthread", 10);
      this.f.start();
    }
    if ((this.f.isAlive()) && (this.f.getLooper() != null))
      this.g = new g.1(this, this.f.getLooper());
  }

  public static g a()
  {
    monitorenter;
    try
    {
      if (b == null)
        b = new g();
      g localg = b;
      return localg;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  protected int a(int paramInt)
  {
    int i;
    if (paramInt == 0)
    {
      i = OpenConfig.getInstance(Global.getContext(), null).getInt("Common_CGIReportFrequencySuccess");
      if (i == 0)
        i = 10;
    }
    do
    {
      return i;
      i = OpenConfig.getInstance(Global.getContext(), null).getInt("Common_CGIReportFrequencyFailed");
    }
    while (i != 0);
    return 100;
  }

  public void a(Bundle paramBundle, String paramString, boolean paramBoolean)
  {
    if (paramBundle == null);
    do
    {
      return;
      com.tencent.open.a.f.b(a, "-->reportVia, bundle: " + paramBundle.toString());
    }
    while ((!a("report_via", paramString)) && (!paramBoolean));
    this.g.post(new g.2(this, paramBundle, paramBoolean));
  }

  public void a(String paramString, long paramLong1, long paramLong2, long paramLong3, int paramInt)
  {
    a(paramString, paramLong1, paramLong2, paramLong3, paramInt, "", false);
  }

  public void a(String paramString1, long paramLong1, long paramLong2, long paramLong3, int paramInt, String paramString2, boolean paramBoolean)
  {
    com.tencent.open.a.f.b(a, "-->reportCgi, command: " + paramString1 + " | startTime: " + paramLong1 + " | reqSize:" + paramLong2 + " | rspSize: " + paramLong3 + " | responseCode: " + paramInt + " | detail: " + paramString2);
    if ((!a("report_cgi", "" + paramInt)) && (!paramBoolean))
      return;
    this.g.post(new g.3(this, paramLong1, paramString1, paramString2, paramInt, paramLong2, paramLong3, paramBoolean));
  }

  public void a(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean)
  {
    ThreadManager.executeOnSubThread(new g.6(this, paramBundle, paramString1, paramBoolean, paramString2));
  }

  protected boolean a(String paramString, int paramInt)
  {
    int i = 5;
    int m;
    if (paramString.equals("report_cgi"))
    {
      m = OpenConfig.getInstance(Global.getContext(), null).getInt("Common_CGIReportMaxcount");
      if (m != 0);
    }
    while (true)
    {
      com.tencent.open.a.f.b(a, "-->availableCount, report: " + paramString + " | dataSize: " + paramInt + " | maxcount: " + i);
      int j = 0;
      if (paramInt >= i)
        j = 1;
      return j;
      i = m;
      continue;
      if (paramString.equals("report_via"))
      {
        int k = OpenConfig.getInstance(Global.getContext(), null).getInt("Agent_ReportBatchCount");
        if (k == 0)
          continue;
        i = k;
        continue;
      }
      i = 0;
    }
  }

  protected boolean a(String paramString1, String paramString2)
  {
    boolean bool1 = true;
    com.tencent.open.a.f.b(a, "-->availableFrequency, report: " + paramString1 + " | ext: " + paramString2);
    if (TextUtils.isEmpty(paramString1))
      return false;
    if (paramString1.equals("report_cgi"));
    while (true)
    {
      try
      {
        int k = Integer.parseInt(paramString2);
        int m = a(k);
        if (this.c.nextInt(100) >= m)
          continue;
        bool2 = bool1;
        i = m;
        com.tencent.open.a.f.b(a, "-->availableFrequency, result: " + bool2 + " | frequency: " + i);
        return bool2;
        bool1 = false;
        continue;
        if (paramString1.equals("report_via"))
        {
          int j = e.a(paramString2);
          if (this.c.nextInt(100) >= j)
            continue;
          bool2 = bool1;
          i = j;
          continue;
          i = j;
          bool2 = false;
          continue;
        }
      }
      catch (Exception localException)
      {
        return false;
      }
      int i = 100;
      boolean bool2 = false;
    }
  }

  protected void b()
  {
    ThreadManager.executeOnNetWorkThread(new g.4(this));
  }

  protected Bundle c()
  {
    if (this.d.size() == 0)
      return null;
    b localb1 = (b)this.d.get(0);
    if (localb1 == null)
    {
      com.tencent.open.a.f.b(a, "-->prepareCgiData, the 0th cgireportitem is null.");
      return null;
    }
    String str1 = (String)localb1.a.get("appid");
    List localList = f.a().a("report_cgi");
    if (localList != null)
      this.d.addAll(localList);
    com.tencent.open.a.f.b(a, "-->prepareCgiData, mCgiList size: " + this.d.size());
    if (this.d.size() == 0)
      return null;
    Bundle localBundle = new Bundle();
    try
    {
      localBundle.putString("appid", str1);
      localBundle.putString("releaseversion", "OpenSdk_2.8.lite");
      localBundle.putString("device", Build.DEVICE);
      localBundle.putString("qua", "V1_AND_OpenSDK_2.8.lite_1077_RDM_B");
      localBundle.putString("key", "apn,frequency,commandid,resultcode,tmcost,reqsize,rspsize,detail,touin,deviceinfo");
      for (int i = 0; i < this.d.size(); i++)
      {
        b localb2 = (b)this.d.get(i);
        localBundle.putString(i + "_1", (String)localb2.a.get("apn"));
        localBundle.putString(i + "_2", (String)localb2.a.get("frequency"));
        localBundle.putString(i + "_3", (String)localb2.a.get("commandid"));
        localBundle.putString(i + "_4", (String)localb2.a.get("resultCode"));
        localBundle.putString(i + "_5", (String)localb2.a.get("timeCost"));
        localBundle.putString(i + "_6", (String)localb2.a.get("reqSize"));
        localBundle.putString(i + "_7", (String)localb2.a.get("rspSize"));
        localBundle.putString(i + "_8", (String)localb2.a.get("detail"));
        localBundle.putString(i + "_9", (String)localb2.a.get("uin"));
        String str2 = c.e(Global.getContext()) + "&" + (String)localb2.a.get("deviceInfo");
        localBundle.putString(i + "_10", str2);
      }
    }
    catch (Exception localException)
    {
      com.tencent.open.a.f.b(a, "-->prepareCgiData, exception.", localException);
      return null;
    }
    com.tencent.open.a.f.b(a, "-->prepareCgiData, end. params: " + localBundle.toString());
    return localBundle;
  }

  protected Bundle d()
  {
    List localList = f.a().a("report_via");
    if (localList != null)
      this.e.addAll(localList);
    com.tencent.open.a.f.b(a, "-->prepareViaData, mViaList size: " + this.e.size());
    if (this.e.size() == 0)
      return null;
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator1 = this.e.iterator();
    while (localIterator1.hasNext())
    {
      Serializable localSerializable = (Serializable)localIterator1.next();
      JSONObject localJSONObject2 = new JSONObject();
      b localb = (b)localSerializable;
      Iterator localIterator2 = localb.a.keySet().iterator();
      while (localIterator2.hasNext())
      {
        String str1 = (String)localIterator2.next();
        try
        {
          String str2 = (String)localb.a.get(str1);
          if (str2 == null)
            str2 = "";
          localJSONObject2.put(str1, str2);
        }
        catch (JSONException localJSONException2)
        {
          com.tencent.open.a.f.a(a, "-->prepareViaData, put bundle to json array exception", localJSONException2);
        }
      }
      localJSONArray.put(localJSONObject2);
    }
    com.tencent.open.a.f.b(a, "-->prepareViaData, JSONArray array: " + localJSONArray.toString());
    Bundle localBundle = new Bundle();
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("data", localJSONArray);
      localBundle.putString("data", localJSONObject1.toString());
      return localBundle;
    }
    catch (JSONException localJSONException1)
    {
      com.tencent.open.a.f.a(a, "-->prepareViaData, put bundle to json array exception", localJSONException1);
    }
    return null;
  }

  protected void e()
  {
    ThreadManager.executeOnNetWorkThread(new g.5(this));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.open.b.g
 * JD-Core Version:    0.6.0
 */