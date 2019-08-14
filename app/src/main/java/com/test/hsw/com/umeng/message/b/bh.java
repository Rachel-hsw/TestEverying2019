package com.umeng.message.b;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.android.agoo.c.b.b;
import org.android.agoo.c.b.b.a;
import org.android.agoo.c.b.c;
import org.android.agoo.c.b.c.a;
import org.android.agoo.c.b.e;
import org.android.agoo.c.b.f;
import org.android.agoo.c.b.j;
import org.android.agoo.c.b.l;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bh extends bb
{
  private static final String A = "ping_reconnect";
  private static final String B = "hb";
  private static final String C = "x-at";
  private static final int D = 10000;
  private static final int E = 30000;
  private static final int F = 60000;
  private static final long G = 60000L;
  private static final long H = 0L;
  private static final int I = 128;
  private static final String ae = "5";
  private static int af = 0;
  private static final Random ah;
  public static final String g = "10";
  public static final String h = "11";
  public static final String i = "12";
  public static final String j = "13";
  public static final String k = "14";
  private static final String l = bh.class.getSimpleName();
  private static final String m = "agoo_action_re_connect";
  private static final String n = "agoo_action_heart";
  private static final String o = "action_get_his_message";
  private static final String p = "action_ping";
  private static final String q = "action_connect_unlock";
  private static final String r = "action_ping_unlock";
  private static final String s = "network_error_connect";
  private static final String t = "CONNECT_REFRESH_HOST";
  private static final String u = "init_connect";
  private static final String v = "screen_on_connect";
  private static final String w = "network_change_connect";
  private static final String x = "error_connect";
  private static final String y = "heart_connect_timeout";
  private static final String z = "ping_channge_channle_type_reconnect";
  private volatile long J = this.X.c();
  private volatile long K = -1L;
  private volatile long L = this.X.i();
  private volatile long M = this.X.f();
  private long N = this.X.j();
  private long O = this.X.a();
  private long P = this.X.b();
  private long Q = -1L;
  private long R = -1L;
  private long S = -1L;
  private long T = -1L;
  private long U = -1L;
  private c V = null;
  private c.a W = null;
  private bg X = new bg(af.F(paramContext), super.d());
  private String Y = null;
  private boolean Z = false;
  private boolean aa = false;
  private boolean ab = false;
  private f ac = f.b;
  private String ad = null;
  private final j ag = new bi(this);

  static
  {
    af = 0;
    ah = new Random();
  }

  public bh(Context paramContext, be parambe)
  {
    super(paramContext, parambe);
    this.Y = af.p(paramContext);
    this.ad = org.android.agoo.b.a.a(paramContext);
    this.ab = false;
  }

  private Bundle a(long paramLong)
  {
    Bundle localBundle = new Bundle();
    try
    {
      char[] arrayOfChar = Long.toBinaryString(paramLong).toCharArray();
      if ((arrayOfChar != null) && (8 <= arrayOfChar.length))
      {
        if (8 <= arrayOfChar.length)
        {
          localBundle.putString("encrypted", "" + Integer.parseInt(new StringBuilder().append("").append(arrayOfChar[1]).append(arrayOfChar[2]).append(arrayOfChar[3]).append(arrayOfChar[4]).toString(), 2));
          if (arrayOfChar[6] == '1')
            localBundle.putString("report", "1");
          if (arrayOfChar[7] == '1')
            localBundle.putString("notify", "1");
        }
        if ((9 <= arrayOfChar.length) && (arrayOfChar[8] == '1'))
          localBundle.putString("has_test", "1");
        if ((10 <= arrayOfChar.length) && (arrayOfChar[9] == '1'))
          localBundle.putString("duplicate", "1");
      }
      return localBundle;
    }
    catch (Throwable localThrowable)
    {
    }
    return localBundle;
  }

  private final void a(long paramLong, String paramString)
  {
    a(paramLong, paramString, true, false, -1);
  }

  private final void a(long paramLong, String paramString, int paramInt)
  {
    a(paramLong, paramString, false, true, paramInt);
  }

  private final void a(long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    String str;
    long l2;
    try
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramString;
      arrayOfObject[1] = Integer.valueOf(ah.nextInt(10000));
      str = String.format("%s_%d", arrayOfObject);
      long l1 = System.currentTimeMillis();
      if (this.U <= l1)
      {
        ay.a(l, "reConnect[mLastConnectTime:" + this.U + "]<[currentTime:" + l1 + "]");
        this.U = -1L;
      }
      l2 = l1 + paramLong;
      if ((l2 > this.U) && (this.U != -1L))
      {
        ay.a(l, "reConnect[interval:" + l2 + "]>[" + this.U + "][state:" + str + "]");
        return;
      }
      if (!paramBoolean2)
        break label386;
      if (this.Z)
      {
        ay.c(l, "tryConnect[interval:" + paramLong + "][connectContext:" + str + "][connnectLock:true]");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      ay.d(l, "reConnect", localThrowable);
      return;
    }
    this.Z = true;
    ay.c(l, "tryConnect[interval:" + paramLong + "][connectContext:" + str + "]");
    a("action_connect_unlock", paramInt);
    while (true)
    {
      this.U = l2;
      if (this.V == null)
        break;
      e locale = this.V.b();
      if (locale == null)
        break;
      if (locale == e.a)
      {
        ay.c(l, "reConnect[connectContext:" + str + "][connecting]");
        return;
        label386: ay.c(l, "forceConnect[interval:" + paramLong + "][connectContext:" + str + "]");
        continue;
      }
      if (locale != e.b)
        break;
      ay.d(l, "disconnect[connectContext:" + str + "]");
      this.V.d();
    }
    e("agoo_action_heart");
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("CONNECT_REFRESH_HOST", paramBoolean1);
    localBundle.putString("CONNECT_STATE", str);
    a("agoo_action_re_connect", localBundle, paramLong);
  }

  private void a(Context paramContext)
  {
    try
    {
      f localf;
      if (this.V != null)
      {
        if (e(paramContext))
          ay.c(l, "[onHandlerScreenOnOrUserPresent][AirplaneModeOn]");
        if (!bk.a(paramContext))
        {
          ay.c(l, "[onHandlerScreenOnOrUserPresent][network connected failed]");
          return;
        }
        long l1 = System.currentTimeMillis() - this.Q;
        if (l1 >= this.T)
        {
          ay.c(l, "onHandlerScreenOnOrUserPresent-->timeout[" + l1 / 1000L + "]");
          a(this.J, "screen_on_connect", 60000);
          return;
        }
        c(paramContext);
        e locale = this.V.b();
        if ((locale != e.b) && (locale != e.a))
        {
          ay.c(l, "onHandlerScreenOn-->state[" + locale + "]");
          a(this.J, "screen_on_connect", 60000);
          return;
        }
        localf = this.V.a();
      }
      switch (1.a[localf.ordinal()])
      {
      case 1:
        ay.c(l, "onHandlerScreenOnOrUserPresent-->[send heart]");
        this.V.f();
        return;
      case 2:
        ay.c(l, "onHandlerScreenOnOrUserPresent-->[connect successfully]");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      return;
    }
  }

  private void a(Object paramObject, long paramLong, String paramString)
  {
    if (!TextUtils.isEmpty(paramString));
    try
    {
      int i1 = Integer.parseInt(paramString);
      if (i1 >= 20)
        this.O = (i1 * 1000);
      if (this.O <= this.N)
      {
        this.P = this.O;
        this.T = (5L * this.O);
        ay.c(l, "heart[onh" + paramObject.toString() + "]heart--->[start checktime:" + this.P / 1000L + "|timeout:" + this.T / 1000L + "s]");
        this.S = -1L;
        b("agoo_action_heart", this.P);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      while (true)
        ay.e(l, "startHeart(" + paramString + ")", localThrowable);
    }
    if (new bk(this.c).a());
    for (this.P = ()(0.5D * this.O); ; this.P = ()(0.7D * this.O))
    {
      this.T = ()(1.1D * this.O);
      break;
    }
  }

  private final void a(Object paramObject, b paramb, Map<String, String> paramMap, Throwable paramThrowable)
  {
    if (paramObject != null)
      ay.d(l, "handlerError[" + paramObject.toString() + "]");
    if (paramb != null)
      ay.d(l, "handlerError[" + paramb.b() + "]");
    if ((paramMap != null) && (!paramMap.isEmpty()))
      ay.d(l, "handlerError[" + paramMap.toString() + "]");
    if (paramThrowable != null)
      ay.d(l, "handlerError", paramThrowable);
    Context localContext = this.c;
    long l1 = this.R;
    if (paramb == null);
    for (String str = ""; ; str = "" + paramb.b())
    {
      aq.a(localContext, l1, "onError", str);
      return;
    }
  }

  private final void b(long paramLong, String paramString)
  {
    a(paramLong, paramString, 30000);
  }

  private void b(Context paramContext)
  {
    try
    {
      f localf;
      if (this.V != null)
      {
        long l1 = System.currentTimeMillis();
        long l2 = l1 - this.Q;
        if (l2 >= this.T)
        {
          aq.a(this.c, l2, this.R);
          long l3 = p();
          ay.c(l, "onHandlerHeart-->[" + l3 + "]timeout[" + l2 / 1000L + "]ms");
          a(l3, "heart_connect_timeout");
          return;
        }
        ay.c(l, "onHandlerHeart-->[currentTime：" + l1 + "][mLastSendDataTime:" + this.S + "][checkHeartInterval:" + this.P + "]");
        if (this.V.b() == e.b)
        {
          localf = this.V.a();
          this.S = l1;
        }
      }
      switch (1.a[localf.ordinal()])
      {
      case 1:
        ay.c(l, "onHandlerHeart-->[send heart]");
        c(paramContext);
        this.V.f();
        return;
      case 2:
        ay.c(l, "onHandlerHeart-->[check heart]");
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  private void b(Context paramContext, Intent paramIntent)
  {
    try
    {
      Bundle localBundle = paramIntent.getExtras();
      if (localBundle != null)
      {
        boolean bool = localBundle.getBoolean("state");
        ay.c(l, "onHandlerAirplaneMode[" + bool + "]");
      }
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  private final void b(Object paramObject, b paramb, Map<String, String> paramMap, Throwable paramThrowable)
  {
    if (paramb != null)
    {
      try
      {
        if (this.V == null)
          break label332;
        if (this.W == null)
          return;
        a(paramObject, paramb, paramMap, paramThrowable);
        b.a locala = paramb.a();
        e("agoo_action_re_connect");
        e("agoo_action_heart");
        aq.m(this.c);
        switch (1.b[locala.ordinal()])
        {
        case 1:
          ay.d(l, "handlerError[sign error]");
          this.b.onHandleError("ERRCODE_AUTH_REJECT");
          return;
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        case 7:
        case 8:
        }
      }
      catch (Throwable localThrowable)
      {
        ay.d(l, "handlerError", localThrowable);
        return;
      }
      ay.d(l, "handlerError[connect pause]");
      return;
      ay.d(l, "handlerError[force_chunked]");
      aq.a(this.c, paramThrowable);
      this.ac = f.a;
      this.W.a(f.a);
      a(this.J, "error_connect");
      return;
      ay.d(l, "handlerError[spdy_reload]");
      this.W.b();
      this.W.a();
      a(this.J, "error_connect");
      return;
      ay.d(l, "handlerError[clear_x_token]");
      this.W.c("x-at");
      this.W.a();
      a(this.J, "error_connect");
      return;
      ay.d(l, "handlerError[refresh_host]");
      this.W.a();
      a(p(), "error_connect");
      return;
      ay.d(l, "handlerError[only_reconnect]");
      a(p(), "error_connect");
      return;
      ay.c(l, "handlerError[unnecessary]");
    }
    label332: return;
  }

  private void c(Context paramContext)
  {
    if (paramContext != null);
    try
    {
      if (!TextUtils.isEmpty(this.ad))
      {
        Intent localIntent = new Intent(this.ad);
        localIntent.setPackage(paramContext.getPackageName());
        paramContext.sendOrderedBroadcast(localIntent, null);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  private void c(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("CONNECT_STATE");
    boolean bool = paramIntent.getBooleanExtra("CONNECT_REFRESH_HOST", true);
    if (TextUtils.isEmpty(str))
    {
      ay.a(l, "onHandlerConnect[" + paramIntent.getExtras().toString() + "]");
      return;
    }
    int i1 = org.android.a.x(paramContext);
    int i2 = org.android.a.w(paramContext);
    Log.d(l, "onHandlerConnect spdyCount=" + i1 + ",httpCount=" + i2);
    this.V = this.W.c();
    c localc = this.V;
    f localf = null;
    if (localc != null)
      localf = this.V.a();
    if ((i1 > 6) && (localf != null) && (localf.equals(f.b)))
    {
      org.android.a.d(paramContext, 0);
      aq.o(paramContext);
      this.ac = f.a;
      this.W.a(f.a);
      a(this.J, "error_connect");
      return;
    }
    if ((i2 > 2) && (localf != null) && (localf.equals(f.a)))
    {
      org.android.a.c(paramContext, 0);
      this.ac = f.b;
      this.W.a(f.b);
      a(this.J, "error_connect");
      return;
    }
    if (e(paramContext))
    {
      ay.c(l, "[airplaneModeOn][true]state[" + str + "]");
      return;
    }
    d(paramContext);
    o();
    if (bool)
      this.W.a();
    ay.a(l, "onHandlerConnect refreshhost[" + bool + "]state[" + str + "][threadName:" + Thread.currentThread().getName() + "]");
    if (this.V.b() == e.a)
    {
      ay.a(l, "onHandlerConnect[connecting]");
      return;
    }
    this.ac = this.V.a();
    if (this.ac.equals(f.b))
      org.android.a.d(paramContext, -1);
    while (true)
    {
      this.V.a(str);
      this.V.a(org.android.a.g(paramContext));
      return;
      if (!this.ac.equals(f.a))
        continue;
      org.android.a.c(paramContext, -1);
    }
  }

  private void d(Context paramContext)
  {
    this.O = this.X.a();
    this.W.b("hb", "" + this.O / 1000L);
    if (TextUtils.indexOf(this.Y, 'r') != -1)
    {
      this.W.a(l.a);
      return;
    }
    this.W.a(l.b);
  }

  private void d(Context paramContext, Intent paramIntent)
  {
    ay.c(l, "onHandlerNetWork");
    b(this.M, "network_change_connect");
  }

  private void e(Context paramContext, Intent paramIntent)
  {
    try
    {
      if (this.V != null)
      {
        if (this.ac != f.b)
        {
          this.W.a(f.b);
          a(this.J, "ping_channge_channle_type_reconnect");
          return;
        }
        e locale = this.V.b();
        switch (1.c[locale.ordinal()])
        {
        default:
          b(paramContext);
          return;
        case 1:
        }
        a(this.M, "ping_reconnect");
      }
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  private static boolean e(Context paramContext)
  {
    return false;
  }

  private final void f(Context paramContext, Intent paramIntent)
  {
    try
    {
      if ((this.V != null) && (this.V.b() == e.b))
      {
        Bundle localBundle = paramIntent.getExtras();
        Iterator localIterator = localBundle.keySet().iterator();
        while (true)
          if (localIterator.hasNext())
          {
            String str1 = (String)localIterator.next();
            if (TextUtils.isEmpty(str1))
            {
              ay.c(l, "path[" + str1 + "][data==null]");
              continue;
            }
            byte[] arrayOfByte = localBundle.getByteArray(str1);
            if (arrayOfByte == null)
              continue;
            if (arrayOfByte.length >= 128)
            {
              ay.c(l, "path[" + str1 + "][" + arrayOfByte.length + ">=" + 128 + "]");
              continue;
            }
            try
            {
              String str2 = new String(arrayOfByte, "utf-8");
              ay.c(l, "path[" + str1 + "][" + str2 + "]");
              try
              {
                label245: this.V.a(str1, arrayOfByte, new bj(this));
              }
              catch (Throwable localThrowable3)
              {
              }
            }
            catch (Throwable localThrowable2)
            {
              break label245;
            }
          }
      }
    }
    catch (Throwable localThrowable1)
    {
    }
  }

  private void m()
  {
    String[] arrayOfString = new String[11];
    arrayOfString[0] = "agoo_action_re_connect";
    arrayOfString[1] = "agoo_action_heart";
    arrayOfString[2] = "action_get_his_message";
    arrayOfString[3] = "action_ping";
    arrayOfString[4] = "action_connect_unlock";
    arrayOfString[5] = "action_ping_unlock";
    arrayOfString[6] = "android.net.conn.CONNECTIVITY_CHANGE";
    arrayOfString[7] = this.ad;
    arrayOfString[8] = "android.intent.action.SCREEN_ON";
    arrayOfString[9] = "android.intent.action.USER_PRESENT";
    arrayOfString[10] = "android.intent.action.AIRPLANE_MODE";
    a(arrayOfString);
    this.W = new c.a(this.c, b(), d());
    this.W.a(this.X.g());
    this.W.a("m");
    this.W.a(this.ag);
    af.a locala = af.H(this.c);
    if ((locala == af.a.c) || (locala == af.a.b) || (locala == af.a.a))
      this.W.a(locala.d(), locala.b());
    this.W.a(locala.c(), af.a());
    this.W.b(a());
    this.W.a(f.b);
    this.W.a(false);
    this.W.a(org.android.a.e(this.c), cm.a(this.c), cm.b(this.c));
    this.Z = false;
    this.aa = false;
  }

  private void n()
  {
    try
    {
      if (this.V != null)
      {
        e locale = this.V.b();
        if ((this.V.a() == f.b) && (locale == e.b))
        {
          ay.c(l, "onHandlerHisMessage()");
          this.V.c();
          this.S = System.currentTimeMillis();
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      ay.e(l, "onHandlerHisMessage error," + localThrowable.toString());
    }
  }

  private void o()
  {
    this.W.a(org.android.agoo.c.b.a.a);
  }

  private long p()
  {
    long l1;
    if (this.R != 0L)
    {
      long l3 = System.currentTimeMillis() - this.R;
      this.R = 0L;
      l1 = l3;
    }
    while (true)
    {
      long l2;
      if (l1 == 0L)
      {
        this.K = (2L * this.K);
        if (this.K < this.L)
          break label160;
        l2 = this.L;
      }
      while (true)
      {
        this.K = l2;
        ay.c(l, "nextErrorInterval [connectInterval:" + l1 + "][nextConnectInterval:" + this.K + "]");
        return this.K;
        if ((0L <= l1) && (l1 < 60000L))
        {
          this.K = (2L * this.K);
          break;
        }
        this.K = this.X.h();
        break;
        label160: l2 = this.K;
      }
      l1 = 0L;
    }
  }

  public void a(Context paramContext, Intent paramIntent)
  {
    String str;
    if ((paramContext != null) && (paramIntent != null))
    {
      str = paramIntent.getAction();
      if (!TextUtils.isEmpty(str))
        break label21;
    }
    label21: 
    do
    {
      while (true)
      {
        return;
        if (TextUtils.equals(str, "action_ping"))
        {
          e(paramContext, paramIntent);
          return;
        }
        if (TextUtils.equals(str, "action_ping_unlock"))
        {
          this.aa = false;
          return;
        }
        if (TextUtils.equals(str, "agoo_action_re_connect"))
        {
          c(paramContext, paramIntent);
          return;
        }
        if (TextUtils.equals(str, "action_connect_unlock"))
        {
          this.Z = false;
          return;
        }
        if (TextUtils.equals(str, "agoo_action_heart"))
        {
          b(paramContext);
          return;
        }
        if (TextUtils.equals(str, "action_get_his_message"))
        {
          n();
          return;
        }
        if (!TextUtils.equals(str, "android.net.conn.CONNECTIVITY_CHANGE"))
          break;
        Log.d(l, "NewMessagePush connect is change.....current connect=android.net.conn.CONNECTIVITY_CHANGE");
        if (!bk.a(paramContext))
          continue;
        org.android.a.d(paramContext, 0);
        org.android.a.c(paramContext, 0);
        ay.c(l, "[network connected success]state[isconnected]");
        a(this.M, "network_error_connect");
        return;
      }
      if ((TextUtils.equals(str, "android.intent.action.SCREEN_ON")) || (TextUtils.equals(str, "android.intent.action.USER_PRESENT")))
      {
        a(paramContext);
        return;
      }
      if (!TextUtils.equals(str, this.ad))
        continue;
      f(paramContext, paramIntent);
      return;
    }
    while (!TextUtils.equals(str, "android.intent.action.AIRPLANE_MODE"));
    org.android.a.d(paramContext, 0);
    org.android.a.c(paramContext, 0);
    b(paramContext, paramIntent);
  }

  public void a(String paramString1, String paramString2, String paramString3)
  {
    while (true)
    {
      int i2;
      try
      {
        if (this.V == null)
          continue;
        e locale = this.V.b();
        f localf = this.V.a();
        if ((localf != f.b) || (locale != e.b))
          continue;
        this.V.a(paramString1, paramString2, paramString3);
        this.S = System.currentTimeMillis();
        ay.c(l, "handlerACKMessage,mLastHeartTime--->[" + this.Q + "]");
        if ((localf != f.a) || (locale != e.b) || (TextUtils.isEmpty(paramString1)))
          continue;
        if (TextUtils.isEmpty(paramString1))
          continue;
        String[] arrayOfString = paramString1.split(",");
        if ((arrayOfString == null) || (arrayOfString.length <= 0))
          continue;
        int i1 = arrayOfString.length;
        i2 = 0;
        if (i2 >= i1)
          continue;
        String str = arrayOfString[i2];
        if (!TextUtils.isEmpty(str))
        {
          bf.a(this.c).a(str, null, "1", "apoll", null, null, "5", paramString2);
          break label294;
          bq localbq = new bq(this.c, "httpAckMsg");
          LinkedHashMap localLinkedHashMap = cm.g(this.c);
          localLinkedHashMap.put("msgIds", paramString1);
          localbq.a(localLinkedHashMap);
          ay.c(l, "handlerACKMessage,CHUNKED,mLastHeartTime--->[" + this.Q + "]");
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        ay.e(l, "handlerReportMessages", localThrowable);
        return;
      }
      label294: i2++;
    }
  }

  protected void a(Map<String, String> paramMap)
  {
    if (paramMap == null);
    String str;
    do
    {
      return;
      str = (String)paramMap.get("x-at");
    }
    while (TextUtils.isEmpty(str));
    this.W.b("x-at", str);
  }

  public void e()
  {
    try
    {
      if (!this.ab)
      {
        this.ab = true;
        ay.c(l, "MessagePush [starting]");
        m();
        a(this.J, "init_connect");
      }
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public void f(String paramString)
  {
    while (true)
    {
      int i1;
      Bundle localBundle1;
      StringBuilder localStringBuilder1;
      StringBuilder localStringBuilder2;
      int i2;
      JSONObject localJSONObject;
      String str1;
      String str2;
      String str3;
      long l1;
      try
      {
        if (TextUtils.isEmpty(paramString))
          return;
        JSONArray localJSONArray = new JSONArray(paramString);
        i1 = localJSONArray.length();
        localBundle1 = new Bundle();
        localStringBuilder1 = new StringBuilder();
        localStringBuilder2 = new StringBuilder();
        i2 = 0;
        if (i2 >= i1)
          break label418;
        localJSONObject = localJSONArray.getJSONObject(i2);
        if (localJSONObject == null)
          break label464;
        str1 = localJSONObject.getString("p");
        str2 = localJSONObject.getString("i");
        str3 = localJSONObject.getString("b");
        l1 = localJSONObject.getLong("f");
        localStringBuilder1.append(str2);
        if (i2 >= i1 - 1)
          continue;
        localStringBuilder1.append(",");
        if (TextUtils.isEmpty(str3))
          a(localStringBuilder1.toString(), localStringBuilder2.toString(), "11");
      }
      catch (JSONException localJSONException)
      {
        aq.d(this.c, paramString);
        ay.e(l, "handlerMessage", localJSONException);
        return;
      }
      if (TextUtils.isEmpty(str1))
      {
        a(localStringBuilder1.toString(), localStringBuilder2.toString(), "12");
      }
      else if (l1 == -1L)
      {
        a(localStringBuilder1.toString(), localStringBuilder2.toString(), "13");
      }
      else if (!ao.a(this.c, str1))
      {
        localStringBuilder2.append(str1);
        if (i2 < i1 - 1)
          localStringBuilder2.append(",");
      }
      else
      {
        localBundle1.putString("id", str2);
        localBundle1.putString("body", str3);
        Bundle localBundle2 = a(l1);
        if (localBundle2 != null)
          localBundle1.putAll(localBundle2);
        try
        {
          String str4 = localJSONObject.getString("t");
          if (!TextUtils.isEmpty(str4))
            localBundle1.putString("time", str4);
          label353: localBundle1.putLong("trace", System.currentTimeMillis());
          bq localbq = new bq(this.c, "ackMessage");
          LinkedHashMap localLinkedHashMap = org.android.a.B(this.c);
          localLinkedHashMap.put("messageId", str2);
          localbq.a(localLinkedHashMap);
          a(str1, localBundle1);
          break label464;
          label418: if ((localStringBuilder2 != null) && (localStringBuilder2.length() > 0))
            a(localStringBuilder1.toString(), localStringBuilder2.toString(), "10");
          a(localStringBuilder1.toString(), null, null);
          return;
        }
        catch (Throwable localThrowable)
        {
          break label353;
        }
      }
      label464: i2++;
    }
  }

  public boolean f()
  {
    if (this.aa)
      return true;
    this.aa = true;
    if (this.ab)
    {
      a("action_ping", 5000L);
      a("action_ping_unlock", 10000L);
      return true;
    }
    return false;
  }

  public final void i()
  {
    try
    {
      if (this.ab)
      {
        this.ab = false;
        super.g();
        ay.c(l, "[destroying]");
        if (this.V != null)
        {
          this.V.e();
          this.V = null;
        }
        ay.c(l, "[destroyed]");
      }
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.bh
 * JD-Core Version:    0.6.0
 */