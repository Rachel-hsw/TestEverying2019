package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import com.xiaomi.a.a.c.c;
import com.xiaomi.d.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ab
{
  private static final Map<String, byte[]> a = new HashMap();
  private static ArrayList<Pair<String, byte[]>> b = new ArrayList();

  public static void a(Context paramContext, int paramInt, String paramString)
  {
    synchronized (a)
    {
      Iterator localIterator = a.keySet().iterator();
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        a(paramContext, str, (byte[])a.get(str), paramInt, paramString);
      }
    }
    a.clear();
    monitorexit;
  }

  public static void a(Context paramContext, String paramString1, byte[] paramArrayOfByte, int paramInt, String paramString2)
  {
    Intent localIntent = new Intent("com.xiaomi.mipush.ERROR");
    localIntent.setPackage(paramString1);
    localIntent.putExtra("mipush_payload", paramArrayOfByte);
    localIntent.putExtra("mipush_error_code", paramInt);
    localIntent.putExtra("mipush_error_msg", paramString2);
    paramContext.sendBroadcast(localIntent, s.a(paramString1));
  }

  public static void a(XMPushService paramXMPushService)
  {
    try
    {
      synchronized (a)
      {
        Iterator localIterator = a.keySet().iterator();
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          paramXMPushService.a(str, (byte[])a.get(str));
        }
      }
    }
    catch (p localp)
    {
      c.a(localp);
      paramXMPushService.a(10, localp);
      return;
    }
    a.clear();
    monitorexit;
  }

  public static void a(String paramString, byte[] paramArrayOfByte)
  {
    synchronized (a)
    {
      a.put(paramString, paramArrayOfByte);
      return;
    }
  }

  // ERROR //
  public static void b(XMPushService paramXMPushService)
  {
    // Byte code:
    //   0: getstatic 24	com/xiaomi/push/service/ab:b	Ljava/util/ArrayList;
    //   3: astore_2
    //   4: aload_2
    //   5: monitorenter
    //   6: getstatic 24	com/xiaomi/push/service/ab:b	Ljava/util/ArrayList;
    //   9: astore 4
    //   11: new 21	java/util/ArrayList
    //   14: dup
    //   15: invokespecial 22	java/util/ArrayList:<init>	()V
    //   18: putstatic 24	com/xiaomi/push/service/ab:b	Ljava/util/ArrayList;
    //   21: aload_2
    //   22: monitorexit
    //   23: aload 4
    //   25: invokevirtual 120	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   28: astore 5
    //   30: aload 5
    //   32: invokeinterface 43 1 0
    //   37: ifeq +50 -> 87
    //   40: aload 5
    //   42: invokeinterface 47 1 0
    //   47: checkcast 122	android/util/Pair
    //   50: astore 6
    //   52: aload_0
    //   53: aload 6
    //   55: getfield 126	android/util/Pair:first	Ljava/lang/Object;
    //   58: checkcast 49	java/lang/String
    //   61: aload 6
    //   63: getfield 129	android/util/Pair:second	Ljava/lang/Object;
    //   66: checkcast 55	[B
    //   69: invokevirtual 107	com/xiaomi/push/service/XMPushService:a	(Ljava/lang/String;[B)V
    //   72: goto -42 -> 30
    //   75: astore_1
    //   76: aload_1
    //   77: invokestatic 112	com/xiaomi/a/a/c/c:a	(Ljava/lang/Throwable;)V
    //   80: aload_0
    //   81: bipush 10
    //   83: aload_1
    //   84: invokevirtual 115	com/xiaomi/push/service/XMPushService:a	(ILjava/lang/Exception;)V
    //   87: return
    //   88: astore_3
    //   89: aload_2
    //   90: monitorexit
    //   91: aload_3
    //   92: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	6	75	com/xiaomi/d/p
    //   23	30	75	com/xiaomi/d/p
    //   30	72	75	com/xiaomi/d/p
    //   91	93	75	com/xiaomi/d/p
    //   6	23	88	finally
    //   89	91	88	finally
  }

  public static void b(String paramString, byte[] paramArrayOfByte)
  {
    synchronized (b)
    {
      b.add(new Pair(paramString, paramArrayOfByte));
      if (b.size() > 50)
        b.remove(0);
      return;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.ab
 * JD-Core Version:    0.6.0
 */