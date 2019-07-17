package org.android.agoo.c.b.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Log;
import com.umeng.message.b.ay;
import com.umeng.message.b.cp;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.android.agoo.c.b.e;
import org.android.agoo.c.b.h;
import org.android.agoo.c.b.i;
import org.android.agoo.c.b.j;
import org.android.spdy.RequestPriority;
import org.android.spdy.SessionCb;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdyDataProvider;
import org.android.spdy.SpdyRequest;
import org.android.spdy.SpdySession;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;
import org.android.spdy.Spdycb;
import org.android.spdy.SuperviseData;

public class a
  implements h, Spdycb
{
  public static final String b = "agoo_push_errorid";
  public static final String c = "agoo_push_path";
  public static final String d = "agoo_connect_type";
  private static final String f = "SpdyClient";
  private static final String g = ":status";
  protected volatile e a = e.d;
  protected volatile Context e;
  private volatile SpdyAgent h = null;
  private volatile SpdySession i = null;
  private volatile String j;
  private volatile j k;
  private volatile Map<String, a> l = new HashMap();
  private volatile Map<String, WeakReference<i>> m = new HashMap();
  private AtomicBoolean n;
  private volatile long o = -1L;
  private volatile URL p;
  private volatile Object q = null;
  private volatile long r = -1L;
  private volatile long s = -1L;
  private final SessionCb t = new c(this);

  public a()
  {
    try
    {
      this.n = new AtomicBoolean(false);
      this.h = SpdyAgent.getInstance(this.e, SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      a(org.android.agoo.c.b.b.g, new HashMap(), localUnsatisfiedLinkError);
      return;
    }
    catch (Throwable localThrowable)
    {
      a(org.android.agoo.c.b.b.f, new HashMap(), localThrowable);
    }
  }

  private final String a(List<String> paramList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i1 = paramList.size();
    for (int i2 = 0; i2 < i1; i2++)
    {
      localStringBuffer.append((String)paramList.get(i2));
      if (i2 >= i1 - 1)
        continue;
      localStringBuffer.append(",");
    }
    return localStringBuffer.toString();
  }

  private final Map<String, String> a(Map<String, List<String>> paramMap)
  {
    HashMap localHashMap = new HashMap();
    try
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        String str1 = (String)localEntry.getKey();
        if (TextUtils.isEmpty(str1))
          continue;
        String str2 = a((List)localEntry.getValue());
        if (TextUtils.isEmpty(str2))
          continue;
        if (!str1.startsWith(":"))
          str1 = str1.toLowerCase();
        localHashMap.put(str1, str2);
      }
    }
    catch (Throwable localThrowable)
    {
    }
    return localHashMap;
  }

  private final void a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("AppStore", 4).edit();
      localEditor.putString("agoo_push_errorid", paramString1);
      localEditor.putString("agoo_push_path", paramString2);
      localEditor.putString("agoo_connect_type", "spdy");
      localEditor.commit();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  private final void a(String paramString, Map<String, String> paramMap)
    throws Throwable
  {
    if (!TextUtils.isEmpty(paramString))
      ay.c("SpdyClient", "connect url[" + paramString + "]");
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (localEntry == null)
          continue;
        String str1 = (String)localEntry.getKey();
        String str2 = (String)localEntry.getValue();
        if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))
          continue;
        ay.c("SpdyClient", "header--->[" + str1 + ":" + str2 + "]");
      }
    }
  }

  private final void a(org.android.agoo.c.b.b paramb, Map<String, String> paramMap, Throwable paramThrowable)
  {
    if ((this.k != null) && (a()))
    {
      a(false);
      this.a = e.d;
      this.k.a(this.q, this.r, paramb, paramMap, paramThrowable);
    }
  }

  private final void b()
  {
    if (this.i != null);
    try
    {
      ay.d("SpdyClient", "session.streamReset(" + this.r + ")");
      this.i.streamReset(this.r, -2014);
      try
      {
        label56: ay.d("SpdyClient", "session.close()");
        this.i.closeSession();
        this.i = null;
        return;
      }
      catch (Throwable localThrowable2)
      {
        while (true)
          ay.d("SpdyClient", "disconnect", localThrowable2);
      }
    }
    catch (Throwable localThrowable1)
    {
      break label56;
    }
  }

  public final int a(String paramString, byte[] paramArrayOfByte, i parami)
  {
    int i1 = -1;
    try
    {
      if ((this.a == e.b) && (this.i != null) && (this.p != null) && (!TextUtils.isEmpty(paramString)))
      {
        String str1 = this.p.getHost();
        int i2 = this.p.getPort();
        Object[] arrayOfObject1 = new Object[3];
        arrayOfObject1[0] = str1;
        arrayOfObject1[1] = Integer.valueOf(i2);
        arrayOfObject1[2] = paramString;
        String str2 = String.format("http://%s:%d%s", arrayOfObject1);
        ay.c("SpdyClient", "send[baseUrl:" + str2 + "]");
        SpdyRequest localSpdyRequest = new SpdyRequest(new URL(str2), "POST", RequestPriority.DEFAULT_PRIORITY);
        int i3 = 0;
        SpdyDataProvider localSpdyDataProvider = null;
        if (paramArrayOfByte != null)
        {
          int i4 = paramArrayOfByte.length;
          i3 = 0;
          localSpdyDataProvider = null;
          if (i4 > 0)
          {
            localSpdyDataProvider = new SpdyDataProvider(paramArrayOfByte);
            i3 = Arrays.hashCode(paramArrayOfByte);
          }
        }
        Object[] arrayOfObject2 = new Object[2];
        arrayOfObject2[0] = str2;
        arrayOfObject2[1] = Integer.valueOf(i3);
        String str3 = String.format("%s_%d", arrayOfObject2);
        if (parami != null)
          this.m.put(str3, new WeakReference(parami));
        int i5 = this.i.submitRequest(localSpdyRequest, localSpdyDataProvider, str3, this);
        i1 = i5;
      }
      return i1;
    }
    catch (Throwable localThrowable)
    {
    }
    return i1;
  }

  public final void a(Object paramObject, Context paramContext, String paramString1, Map<String, String> paramMap, long paramLong, j paramj, String paramString2)
  {
    if ((paramObject == null) || (TextUtils.isEmpty(paramString1)) || (paramj == null))
      throw new NullPointerException("connectContext==null||url==null || eventHandler==null");
    this.e = paramContext;
    this.q = paramObject;
    a(true);
    this.k = paramj;
    try
    {
      SharedPreferences.Editor localEditor = this.e.getSharedPreferences("AppStore", 4).edit();
      localEditor.putString("agoo_connect_type", "spdy");
      localEditor.commit();
      try
      {
        label85: a(paramString1, paramMap);
        this.a = e.a;
        if (this.h != null)
        {
          this.j = paramString1;
          this.p = new URL(paramString1);
          SpdyRequest localSpdyRequest = new SpdyRequest(this.p, "GET", RequestPriority.DEFAULT_PRIORITY);
          if ((paramMap != null) && (paramMap.size() > 0))
            localSpdyRequest.addHeaders(paramMap);
          SpdyDataProvider localSpdyDataProvider = new SpdyDataProvider((byte[])null);
          this.i = this.h.submitRequest(localSpdyRequest, localSpdyDataProvider, this.j, this.j, this, this.t, 2);
        }
        return;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        a(org.android.agoo.c.b.b.g, new HashMap(), localUnsatisfiedLinkError);
        return;
      }
      catch (Throwable localThrowable2)
      {
        a(org.android.agoo.c.b.b.a, new HashMap(), localThrowable2);
        return;
      }
    }
    catch (Throwable localThrowable1)
    {
      break label85;
    }
  }

  public final void a(boolean paramBoolean)
  {
    this.n.set(paramBoolean);
  }

  public final boolean a()
  {
    return this.n.get();
  }

  public final boolean a(String paramString)
  {
    return TextUtils.equals(this.j, paramString);
  }

  @Deprecated
  public final void d()
  {
    this.a = e.c;
    b();
    a(false);
    this.a = e.d;
  }

  public final void e()
  {
    this.a = e.c;
    b();
    a(false);
    this.a = e.d;
  }

  public final e f()
  {
    return this.a;
  }

  public final long p()
  {
    int i1 = -1;
    try
    {
      if (this.i != null)
      {
        int i2 = this.i.submitPing();
        i1 = i2;
      }
      return i1;
    }
    catch (Throwable localThrowable)
    {
      while (true)
        a(org.android.agoo.c.b.b.e, new HashMap(), localThrowable);
    }
  }

  public final void q()
  {
    ay.d("SpdyClient", "shutdown.....");
    cp.a(new b(this));
  }

  public final void r()
  {
    try
    {
      if (this.h != null)
      {
        ay.d("SpdyClient", "closing");
        b();
        this.h.close();
        this.h = null;
        ay.d("SpdyClient", "closed");
      }
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public final void spdyDataChunkRecvCB(SpdySession paramSpdySession, boolean paramBoolean, long paramLong, byte[] paramArrayOfByte, int paramInt, Object paramObject)
  {
    String str;
    try
    {
      str = (String)paramObject;
      if (TextUtils.isEmpty(str))
        return;
      if (paramArrayOfByte == null)
        Log.d("SpdyClient", "spdyDataChunkRecvCB,data=null,streamId=" + paramLong);
      Log.d("SpdyClient", "spdyDataChunkRecvCB,data=" + paramArrayOfByte);
      if (TextUtils.equals(str, this.j))
      {
        if (!a())
          return;
        this.k.a(this.q, paramLong, str, paramArrayOfByte);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      a(org.android.agoo.c.b.b.c, new HashMap(), localThrowable);
      return;
    }
    a locala = (a)this.l.get(str);
    if (locala != null)
    {
      locala.a(paramArrayOfByte);
      this.l.put(str, locala);
    }
  }

  public final void spdyDataRecvCallback(SpdySession paramSpdySession, boolean paramBoolean, long paramLong, int paramInt, Object paramObject)
  {
    try
    {
      String str = (String)paramObject;
      if (TextUtils.isEmpty(str))
        return;
      WeakReference localWeakReference = (WeakReference)this.m.get(str);
      if (localWeakReference != null)
      {
        i locali = (i)localWeakReference.get();
        if (locali != null)
        {
          a locala = (a)this.l.get(str);
          if (locala != null)
          {
            locali.a(this.q, str, locala.b(), locala.c(), locala.a());
            this.m.remove(str);
            this.l.remove(str);
            return;
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      ay.e("SpdyClient", "spdyDataRecvCallback", localThrowable);
    }
  }

  public final void spdyDataSendCallback(SpdySession paramSpdySession, boolean paramBoolean, long paramLong, int paramInt, Object paramObject)
  {
  }

  public final void spdyOnStreamResponse(SpdySession paramSpdySession, long paramLong, Map<String, List<String>> paramMap, Object paramObject)
  {
    Map localMap = a(paramMap);
    while (true)
    {
      String str;
      try
      {
        str = (String)paramObject;
        if (localMap.get(":status") == null)
          break label263;
        i1 = Integer.parseInt((String)localMap.get(":status"));
        ay.c("SpdyClient", "spdyOnStreamResponse PATH[" + str + "][" + i1 + "]");
        if (a(str))
        {
          this.r = paramLong;
          if (i1 != 200)
            continue;
          this.a = e.b;
          this.k.a(this.q, paramLong, this.o, localMap);
          paramMap.remove(":status");
          return;
          a(org.android.agoo.c.b.b.b(i1), localMap, new Throwable("http httpStatusCode[" + str + "]==" + i1));
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        a(org.android.agoo.c.b.b.b, localMap, localThrowable);
        return;
      }
      a locala = (a)this.l.get(str);
      if (locala == null)
        locala = new a(i1, localMap);
      this.l.put(str, locala);
      return;
      label263: int i1 = -1;
    }
  }

  @Deprecated
  public final void spdyRequestRecvCallback(SpdySession paramSpdySession, long paramLong, Object paramObject)
  {
  }

  public void spdyStreamCloseCallback(SpdySession paramSpdySession, long paramLong, int paramInt, Object paramObject, SuperviseData paramSuperviseData)
  {
  }

  class a
  {
    private int b;
    private Map<String, String> c;
    private ByteArrayOutputStream d = null;

    public a(Map<String, String> arg2)
    {
      int i;
      this.b = i;
      Object localObject;
      this.c = localObject;
      this.d = new ByteArrayOutputStream();
    }

    public void a(byte[] paramArrayOfByte)
      throws IOException
    {
      this.d.write(paramArrayOfByte);
    }

    public byte[] a()
    {
      try
      {
        byte[] arrayOfByte = this.d.toByteArray();
        return arrayOfByte;
      }
      catch (Throwable localThrowable)
      {
      }
      return null;
    }

    public int b()
    {
      return this.b;
    }

    public Map<String, String> c()
    {
      return this.c;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.android.agoo.c.b.b.a
 * JD-Core Version:    0.6.0
 */