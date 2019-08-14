package com.umeng.socialize.b.b;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.socialize.bean.ay;
import com.umeng.socialize.bean.l;
import com.umeng.socialize.common.r;
import com.umeng.socialize.utils.c;
import com.umeng.socialize.utils.i;
import com.umeng.socialize.utils.m;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class d
{
  private static final String a = d.class.getName();

  public static String a(String paramString, Map<String, Object> paramMap)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramMap == null) || (paramMap.size() == 0))
      return paramString;
    if (!paramString.endsWith("?"))
      paramString = paramString + "?";
    StringBuilder localStringBuilder1 = new StringBuilder();
    Iterator localIterator = paramMap.keySet().iterator();
    StringBuilder localStringBuilder2 = localStringBuilder1;
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      if (paramMap.get(str2) == null)
        continue;
      localStringBuilder2 = localStringBuilder2.append(str2 + "=" + URLEncoder.encode(paramMap.get(str2).toString()) + "&");
    }
    StringBuilder localStringBuilder3 = new StringBuilder(paramString);
    try
    {
      String str1 = a.a(localStringBuilder2.substring(0, -1 + localStringBuilder2.length()).toString(), "UTF-8");
      localStringBuilder3.append("ud_get=" + str1);
      return localStringBuilder3.toString();
    }
    catch (Exception localException)
    {
      while (true)
        localException.printStackTrace();
    }
  }

  public static Map<String, Object> a(Context paramContext, ay paramay, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    String str1 = c.b(paramContext);
    if (!TextUtils.isEmpty(str1))
    {
      localHashMap.put("imei", str1);
      localHashMap.put("md5imei", a.c(str1));
    }
    String str2 = c.g(paramContext);
    if (TextUtils.isEmpty(str2))
      i.e(a, "Get MacAddress failed. Check permission android.permission.ACCESS_WIFI_STATE [" + c.a(paramContext, "android.permission.ACCESS_WIFI_STATE") + "]");
    while (true)
    {
      if (!TextUtils.isEmpty(r.g))
        localHashMap.put("uid", r.g);
      try
      {
        localHashMap.put("en", c.c(paramContext)[0]);
        localHashMap.put("de", Build.MODEL);
        localHashMap.put("sdkv", "4.3.0150716");
        localHashMap.put("os", "Android");
        localHashMap.put("dt", Long.valueOf(System.currentTimeMillis()));
        localHashMap.put("opid", Integer.valueOf(paramInt));
        str3 = m.a(paramContext);
        if (TextUtils.isEmpty(str3))
        {
          throw new com.umeng.socialize.a.a("No found appkey.");
          localHashMap.put("mac", str2);
        }
      }
      catch (Exception localException1)
      {
        String str3;
        while (true)
          localHashMap.put("en", "Unknown");
        localHashMap.put("ak", str3);
        if (!TextUtils.isEmpty(paramay.a))
          localHashMap.put("ek", paramay.a);
        if (!TextUtils.isEmpty(paramay.b))
          localHashMap.put("sid", paramay.b);
        localHashMap.put(e.D, "2.0");
        try
        {
          localHashMap.put("tp", paramay.o().toString());
          return localHashMap;
        }
        catch (Exception localException2)
        {
        }
      }
    }
    return localHashMap;
  }

  // ERROR //
  public static byte[] a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: invokestatic 28	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifeq +5 -> 11
    //   9: aconst_null
    //   10: areturn
    //   11: new 244	java/io/ByteArrayOutputStream
    //   14: dup
    //   15: invokespecial 245	java/io/ByteArrayOutputStream:<init>	()V
    //   18: astore_2
    //   19: new 247	java/net/URL
    //   22: dup
    //   23: aload_0
    //   24: invokespecial 248	java/net/URL:<init>	(Ljava/lang/String;)V
    //   27: invokevirtual 252	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   30: invokevirtual 257	java/net/URLConnection:getContent	()Ljava/lang/Object;
    //   33: checkcast 259	java/io/InputStream
    //   36: astore 10
    //   38: sipush 4096
    //   41: newarray byte
    //   43: astore 13
    //   45: aload 10
    //   47: aload 13
    //   49: invokevirtual 263	java/io/InputStream:read	([B)I
    //   52: istore 14
    //   54: iload 14
    //   56: iconst_m1
    //   57: if_icmpeq +53 -> 110
    //   60: aload_2
    //   61: aload 13
    //   63: iconst_0
    //   64: iload 14
    //   66: invokevirtual 267	java/io/ByteArrayOutputStream:write	([BII)V
    //   69: goto -24 -> 45
    //   72: astore 12
    //   74: aload 10
    //   76: astore_1
    //   77: aload 12
    //   79: astore_3
    //   80: new 269	java/lang/RuntimeException
    //   83: dup
    //   84: aload_3
    //   85: invokespecial 272	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   88: athrow
    //   89: astore 4
    //   91: aload_1
    //   92: ifnull +15 -> 107
    //   95: aload_1
    //   96: invokevirtual 275	java/io/InputStream:close	()V
    //   99: aload_2
    //   100: ifnull +7 -> 107
    //   103: aload_2
    //   104: invokevirtual 276	java/io/ByteArrayOutputStream:close	()V
    //   107: aload 4
    //   109: athrow
    //   110: aload_2
    //   111: invokevirtual 280	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   114: astore 15
    //   116: aload 10
    //   118: ifnull +16 -> 134
    //   121: aload 10
    //   123: invokevirtual 275	java/io/InputStream:close	()V
    //   126: aload_2
    //   127: ifnull +7 -> 134
    //   130: aload_2
    //   131: invokevirtual 276	java/io/ByteArrayOutputStream:close	()V
    //   134: aload 15
    //   136: areturn
    //   137: astore 18
    //   139: aload_2
    //   140: ifnull -6 -> 134
    //   143: aload_2
    //   144: invokevirtual 276	java/io/ByteArrayOutputStream:close	()V
    //   147: goto -13 -> 134
    //   150: astore 19
    //   152: goto -18 -> 134
    //   155: astore 16
    //   157: aload_2
    //   158: ifnull +7 -> 165
    //   161: aload_2
    //   162: invokevirtual 276	java/io/ByteArrayOutputStream:close	()V
    //   165: aload 16
    //   167: athrow
    //   168: astore 7
    //   170: aload_2
    //   171: ifnull -64 -> 107
    //   174: aload_2
    //   175: invokevirtual 276	java/io/ByteArrayOutputStream:close	()V
    //   178: goto -71 -> 107
    //   181: astore 8
    //   183: goto -76 -> 107
    //   186: astore 5
    //   188: aload_2
    //   189: ifnull +7 -> 196
    //   192: aload_2
    //   193: invokevirtual 276	java/io/ByteArrayOutputStream:close	()V
    //   196: aload 5
    //   198: athrow
    //   199: astore 20
    //   201: goto -67 -> 134
    //   204: astore 17
    //   206: goto -41 -> 165
    //   209: astore 9
    //   211: goto -104 -> 107
    //   214: astore 6
    //   216: goto -20 -> 196
    //   219: astore 4
    //   221: aconst_null
    //   222: astore_1
    //   223: aconst_null
    //   224: astore_2
    //   225: goto -134 -> 91
    //   228: astore 11
    //   230: aload 10
    //   232: astore_1
    //   233: aload 11
    //   235: astore 4
    //   237: goto -146 -> 91
    //   240: astore_3
    //   241: aconst_null
    //   242: astore_1
    //   243: aconst_null
    //   244: astore_2
    //   245: goto -165 -> 80
    //   248: astore_3
    //   249: aconst_null
    //   250: astore_1
    //   251: goto -171 -> 80
    //
    // Exception table:
    //   from	to	target	type
    //   38	45	72	java/lang/Exception
    //   45	54	72	java/lang/Exception
    //   60	69	72	java/lang/Exception
    //   110	116	72	java/lang/Exception
    //   19	38	89	finally
    //   80	89	89	finally
    //   121	126	137	java/io/IOException
    //   143	147	150	java/io/IOException
    //   121	126	155	finally
    //   95	99	168	java/io/IOException
    //   174	178	181	java/io/IOException
    //   95	99	186	finally
    //   130	134	199	java/io/IOException
    //   161	165	204	java/io/IOException
    //   103	107	209	java/io/IOException
    //   192	196	214	java/io/IOException
    //   11	19	219	finally
    //   38	45	228	finally
    //   45	54	228	finally
    //   60	69	228	finally
    //   110	116	228	finally
    //   11	19	240	java/lang/Exception
    //   19	38	248	java/lang/Exception
  }

  public static boolean b(String paramString)
  {
    return (paramString.startsWith("http://")) || (paramString.startsWith("https://"));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.b.b.d
 * JD-Core Version:    0.6.0
 */