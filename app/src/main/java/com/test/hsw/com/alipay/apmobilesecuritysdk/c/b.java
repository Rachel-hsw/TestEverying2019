package com.alipay.apmobilesecuritysdk.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.alipay.apmobilesecuritysdk.a.h;
import com.alipay.security.mobile.module.http.IUpload;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  private File a = null;
  private IUpload b = null;

  public b(String paramString, IUpload paramIUpload)
  {
    this.a = new File(paramString);
    this.b = paramIUpload;
  }

  private static String a(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", "id");
      localJSONObject.put("error", paramString);
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
    }
    return "";
  }

  private void a()
  {
    int i = 0;
    monitorenter;
    while (true)
    {
      String str1;
      int m;
      try
      {
        File localFile = this.a;
        if (localFile == null)
          return;
        if ((!this.a.exists()) || (!this.a.isDirectory()) || (this.a.list().length == 0))
          continue;
        ArrayList localArrayList = new ArrayList();
        String[] arrayOfString = this.a.list();
        int j = arrayOfString.length;
        int k = 0;
        if (k >= j)
          continue;
        localArrayList.add(arrayOfString[k]);
        k++;
        continue;
        Collections.sort(localArrayList);
        str1 = (String)localArrayList.get(-1 + localArrayList.size());
        m = localArrayList.size();
        Date localDate = Calendar.getInstance().getTime();
        String str2 = new SimpleDateFormat("yyyyMMdd").format(localDate);
        if (!str1.equals(str2 + ".log"))
          break label326;
        if (localArrayList.size() < 2)
          continue;
        String str6 = (String)localArrayList.get(-2 + localArrayList.size());
        int i2 = m - 1;
        str3 = str6;
        n = i2;
        String str4 = a(com.alipay.security.mobile.module.a.b.a(this.a.getAbsolutePath(), str3));
        if (!this.b.logCollect(str4))
        {
          i1 = n - 1;
          if (i >= i1)
            continue;
          String str5 = (String)localArrayList.get(i);
          new File(this.a, str5).delete();
          i++;
          continue;
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      int i1 = n;
      i = 0;
      continue;
      label326: String str3 = str1;
      int n = m;
    }
  }

  public final void a(Context paramContext)
  {
    ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    NetworkInfo localNetworkInfo;
    if (localConnectivityManager == null)
    {
      localNetworkInfo = null;
      if ((localNetworkInfo == null) || (!localNetworkInfo.isConnected()) || (localNetworkInfo.getType() != 1))
        break label81;
    }
    label81: for (int i = 1; ; i = 0)
    {
      boolean bool = h.a(paramContext);
      if ((i != 0) && (bool))
        new Thread(new c(this)).start();
      return;
      localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
      break;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.apmobilesecuritysdk.c.b
 * JD-Core Version:    0.6.0
 */