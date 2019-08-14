package com.ta.utdid2.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.ta.utdid2.b.a.c;
import com.ut.device.AidCallback;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.apache.http.client.methods.HttpPost;
import org.json.JSONException;
import org.json.JSONObject;

public class b
{
  private static final String a = b.class.getName();
  private static b b = null;
  private Context c;
  private Object d = new Object();

  private b(Context paramContext)
  {
    this.c = paramContext;
  }

  public static b a(Context paramContext)
  {
    monitorenter;
    try
    {
      if (b == null)
        b = new b(paramContext);
      b localb = b;
      return localb;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private static String b(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
      try
      {
        JSONObject localJSONObject1 = new JSONObject(paramString1);
        if (localJSONObject1.has("data"))
        {
          JSONObject localJSONObject2 = localJSONObject1.getJSONObject("data");
          if ((localJSONObject2.has("action")) && (localJSONObject2.has("aid")))
          {
            String str3 = localJSONObject2.getString("action");
            if ((str3.equalsIgnoreCase("new")) || (str3.equalsIgnoreCase("changed")))
              return localJSONObject2.getString("aid");
          }
        }
        else if ((localJSONObject1.has("isError")) && (localJSONObject1.has("status")))
        {
          String str1 = localJSONObject1.getString("isError");
          String str2 = localJSONObject1.getString("status");
          if ((str1.equalsIgnoreCase("true")) && ((str2.equalsIgnoreCase("404")) || (str2.equalsIgnoreCase("401"))))
          {
            if (c.a)
              Log.d(a, "remove the AID, status:" + str2);
            return "";
          }
        }
      }
      catch (JSONException localJSONException)
      {
        Log.e(a, localJSONException.toString());
        return paramString2;
      }
      catch (Exception localException)
      {
        Log.e(a, localException.toString());
      }
    return paramString2;
  }

  private static String b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      String str = URLEncoder.encode(paramString3, "UTF-8");
      paramString3 = str;
      return "http://hydra.alibaba.com/" + paramString1 + "/get_aid/?auth[token]=" + paramString2 + "&type=utdid&id=" + paramString3 + "&aid=" + paramString4;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      while (true)
        localUnsupportedEncodingException.printStackTrace();
    }
  }

  // ERROR //
  public final String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_2
    //   2: aload_3
    //   3: aload 4
    //   5: invokestatic 145	com/ta/utdid2/a/b:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   8: astore 5
    //   10: aload_0
    //   11: getfield 32	com/ta/utdid2/a/b:c	Landroid/content/Context;
    //   14: invokestatic 150	com/ta/utdid2/b/a/e:b	(Landroid/content/Context;)Z
    //   17: ifeq +139 -> 156
    //   20: sipush 3000
    //   23: istore 6
    //   25: getstatic 97	com/ta/utdid2/b/a/c:a	Z
    //   28: ifeq +37 -> 65
    //   31: getstatic 22	com/ta/utdid2/a/b:a	Ljava/lang/String;
    //   34: new 99	java/lang/StringBuilder
    //   37: dup
    //   38: ldc 152
    //   40: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   43: aload 5
    //   45: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: ldc 154
    //   50: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: iload 6
    //   55: invokevirtual 157	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   58: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 114	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   64: pop
    //   65: new 159	com/ta/utdid2/a/b$a
    //   68: dup
    //   69: aload_0
    //   70: new 161	org/apache/http/client/methods/HttpPost
    //   73: dup
    //   74: aload 5
    //   76: invokespecial 162	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   79: invokespecial 165	com/ta/utdid2/a/b$a:<init>	(Lcom/ta/utdid2/a/b;Lorg/apache/http/client/methods/HttpPost;)V
    //   82: astore 7
    //   84: aload 7
    //   86: invokevirtual 168	com/ta/utdid2/a/b$a:start	()V
    //   89: aload_0
    //   90: getfield 30	com/ta/utdid2/a/b:d	Ljava/lang/Object;
    //   93: astore 12
    //   95: aload 12
    //   97: monitorenter
    //   98: aload_0
    //   99: getfield 30	com/ta/utdid2/a/b:d	Ljava/lang/Object;
    //   102: iload 6
    //   104: i2l
    //   105: invokevirtual 172	java/lang/Object:wait	(J)V
    //   108: aload 12
    //   110: monitorexit
    //   111: aload 7
    //   113: invokevirtual 174	com/ta/utdid2/a/b$a:a	()Ljava/lang/String;
    //   116: astore 10
    //   118: getstatic 97	com/ta/utdid2/b/a/c:a	Z
    //   121: ifeq +27 -> 148
    //   124: getstatic 22	com/ta/utdid2/a/b:a	Ljava/lang/String;
    //   127: new 99	java/lang/StringBuilder
    //   130: dup
    //   131: ldc 176
    //   133: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   136: aload 10
    //   138: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokestatic 114	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   147: pop
    //   148: aload 10
    //   150: aload 4
    //   152: invokestatic 39	com/ta/utdid2/a/b:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   155: areturn
    //   156: sipush 1000
    //   159: istore 6
    //   161: goto -136 -> 25
    //   164: astore 13
    //   166: aload 12
    //   168: monitorexit
    //   169: aload 13
    //   171: athrow
    //   172: astore 8
    //   174: getstatic 22	com/ta/utdid2/a/b:a	Ljava/lang/String;
    //   177: aload 8
    //   179: invokevirtual 121	java/lang/Exception:toString	()Ljava/lang/String;
    //   182: invokestatic 120	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   185: pop
    //   186: goto -75 -> 111
    //
    // Exception table:
    //   from	to	target	type
    //   98	111	164	finally
    //   89	98	172	java/lang/Exception
    //   166	172	172	java/lang/Exception
  }

  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, AidCallback paramAidCallback)
  {
    String str = b(paramString1, paramString2, paramString3, paramString4);
    if (c.a)
      Log.d(a, "url:" + str + "; len:" + str.length());
    new a(new HttpPost(str), paramAidCallback, paramString4, paramString1, paramString2).start();
  }

  final class a extends Thread
  {
    HttpPost a;
    String b = "";
    AidCallback c;
    String d;
    String e;
    String f = "";

    public a(HttpPost arg2)
    {
      Object localObject;
      this.a = localObject;
    }

    public a(HttpPost paramAidCallback, AidCallback paramString1, String paramString2, String paramString3, String arg6)
    {
      this.a = paramAidCallback;
      this.c = paramString1;
      this.d = paramString2;
      this.e = paramString3;
      Object localObject;
      this.f = localObject;
    }

    public final String a()
    {
      return this.b;
    }

    // ERROR //
    public final void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 33	com/ta/utdid2/a/b$a:c	Lcom/ut/device/AidCallback;
      //   4: ifnull +19 -> 23
      //   7: aload_0
      //   8: getfield 33	com/ta/utdid2/a/b$a:c	Lcom/ut/device/AidCallback;
      //   11: sipush 1000
      //   14: aload_0
      //   15: getfield 35	com/ta/utdid2/a/b$a:d	Ljava/lang/String;
      //   18: invokeinterface 49 3 0
      //   23: new 51	org/apache/http/impl/client/DefaultHttpClient
      //   26: dup
      //   27: invokespecial 52	org/apache/http/impl/client/DefaultHttpClient:<init>	()V
      //   30: astore_1
      //   31: aload_1
      //   32: aload_0
      //   33: getfield 30	com/ta/utdid2/a/b$a:a	Lorg/apache/http/client/methods/HttpPost;
      //   36: invokeinterface 58 2 0
      //   41: astore 21
      //   43: aload 21
      //   45: astore 4
      //   47: aload 4
      //   49: ifnull +217 -> 266
      //   52: new 60	java/io/BufferedReader
      //   55: dup
      //   56: new 62	java/io/InputStreamReader
      //   59: dup
      //   60: aload 4
      //   62: invokeinterface 68 1 0
      //   67: invokeinterface 74 1 0
      //   72: ldc 76
      //   74: invokestatic 82	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
      //   77: invokespecial 85	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
      //   80: invokespecial 88	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
      //   83: astore 20
      //   85: aload 20
      //   87: astore 7
      //   89: aload 7
      //   91: ifnull +233 -> 324
      //   94: aload 7
      //   96: invokevirtual 91	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   99: astore 17
      //   101: aload 17
      //   103: ifnull +64 -> 167
      //   106: getstatic 96	com/ta/utdid2/b/a/c:a	Z
      //   109: ifeq +12 -> 121
      //   112: invokestatic 100	com/ta/utdid2/a/b:a	()Ljava/lang/String;
      //   115: aload 17
      //   117: invokestatic 105	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
      //   120: pop
      //   121: aload_0
      //   122: aload 17
      //   124: putfield 26	com/ta/utdid2/a/b$a:b	Ljava/lang/String;
      //   127: goto -33 -> 94
      //   130: astore 15
      //   132: aload_0
      //   133: getfield 33	com/ta/utdid2/a/b$a:c	Lcom/ut/device/AidCallback;
      //   136: ifnull +19 -> 155
      //   139: aload_0
      //   140: getfield 33	com/ta/utdid2/a/b$a:c	Lcom/ut/device/AidCallback;
      //   143: sipush 1002
      //   146: aload_0
      //   147: getfield 35	com/ta/utdid2/a/b$a:d	Ljava/lang/String;
      //   150: invokeinterface 49 3 0
      //   155: invokestatic 100	com/ta/utdid2/a/b:a	()Ljava/lang/String;
      //   158: aload 15
      //   160: invokevirtual 108	java/lang/Exception:toString	()Ljava/lang/String;
      //   163: invokestatic 110	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
      //   166: pop
      //   167: aload 7
      //   169: ifnull +23 -> 192
      //   172: aload 7
      //   174: invokevirtual 113	java/io/BufferedReader:close	()V
      //   177: getstatic 96	com/ta/utdid2/b/a/c:a	Z
      //   180: ifeq +12 -> 192
      //   183: invokestatic 100	com/ta/utdid2/a/b:a	()Ljava/lang/String;
      //   186: ldc 115
      //   188: invokestatic 105	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
      //   191: pop
      //   192: aload_0
      //   193: getfield 33	com/ta/utdid2/a/b$a:c	Lcom/ut/device/AidCallback;
      //   196: ifnonnull +165 -> 361
      //   199: aload_0
      //   200: getfield 19	com/ta/utdid2/a/b$a:g	Lcom/ta/utdid2/a/b;
      //   203: invokestatic 118	com/ta/utdid2/a/b:a	(Lcom/ta/utdid2/a/b;)Ljava/lang/Object;
      //   206: astore 10
      //   208: aload 10
      //   210: monitorenter
      //   211: aload_0
      //   212: getfield 19	com/ta/utdid2/a/b$a:g	Lcom/ta/utdid2/a/b;
      //   215: invokestatic 118	com/ta/utdid2/a/b:a	(Lcom/ta/utdid2/a/b;)Ljava/lang/Object;
      //   218: invokevirtual 123	java/lang/Object:notifyAll	()V
      //   221: aload 10
      //   223: monitorexit
      //   224: return
      //   225: astore_2
      //   226: aload_0
      //   227: getfield 33	com/ta/utdid2/a/b$a:c	Lcom/ut/device/AidCallback;
      //   230: ifnull +19 -> 249
      //   233: aload_0
      //   234: getfield 33	com/ta/utdid2/a/b$a:c	Lcom/ut/device/AidCallback;
      //   237: sipush 1002
      //   240: aload_0
      //   241: getfield 35	com/ta/utdid2/a/b$a:d	Ljava/lang/String;
      //   244: invokeinterface 49 3 0
      //   249: invokestatic 100	com/ta/utdid2/a/b:a	()Ljava/lang/String;
      //   252: aload_2
      //   253: invokevirtual 108	java/lang/Exception:toString	()Ljava/lang/String;
      //   256: invokestatic 110	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
      //   259: pop
      //   260: aconst_null
      //   261: astore 4
      //   263: goto -216 -> 47
      //   266: invokestatic 100	com/ta/utdid2/a/b:a	()Ljava/lang/String;
      //   269: ldc 125
      //   271: invokestatic 110	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
      //   274: pop
      //   275: aconst_null
      //   276: astore 7
      //   278: goto -189 -> 89
      //   281: astore 5
      //   283: aload_0
      //   284: getfield 33	com/ta/utdid2/a/b$a:c	Lcom/ut/device/AidCallback;
      //   287: ifnull +19 -> 306
      //   290: aload_0
      //   291: getfield 33	com/ta/utdid2/a/b$a:c	Lcom/ut/device/AidCallback;
      //   294: sipush 1002
      //   297: aload_0
      //   298: getfield 35	com/ta/utdid2/a/b$a:d	Ljava/lang/String;
      //   301: invokeinterface 49 3 0
      //   306: invokestatic 100	com/ta/utdid2/a/b:a	()Ljava/lang/String;
      //   309: aload 5
      //   311: invokevirtual 108	java/lang/Exception:toString	()Ljava/lang/String;
      //   314: invokestatic 110	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
      //   317: pop
      //   318: aconst_null
      //   319: astore 7
      //   321: goto -232 -> 89
      //   324: invokestatic 100	com/ta/utdid2/a/b:a	()Ljava/lang/String;
      //   327: ldc 127
      //   329: invokestatic 110	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
      //   332: pop
      //   333: goto -166 -> 167
      //   336: astore 12
      //   338: invokestatic 100	com/ta/utdid2/a/b:a	()Ljava/lang/String;
      //   341: aload 12
      //   343: invokevirtual 128	java/io/IOException:toString	()Ljava/lang/String;
      //   346: invokestatic 110	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
      //   349: pop
      //   350: goto -158 -> 192
      //   353: astore 11
      //   355: aload 10
      //   357: monitorexit
      //   358: aload 11
      //   360: athrow
      //   361: aload_0
      //   362: getfield 26	com/ta/utdid2/a/b$a:b	Ljava/lang/String;
      //   365: aload_0
      //   366: getfield 35	com/ta/utdid2/a/b$a:d	Ljava/lang/String;
      //   369: invokestatic 131	com/ta/utdid2/a/b:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   372: astore 9
      //   374: aload_0
      //   375: getfield 33	com/ta/utdid2/a/b$a:c	Lcom/ut/device/AidCallback;
      //   378: sipush 1001
      //   381: aload 9
      //   383: invokeinterface 49 3 0
      //   388: aload_0
      //   389: getfield 19	com/ta/utdid2/a/b$a:g	Lcom/ta/utdid2/a/b;
      //   392: invokestatic 134	com/ta/utdid2/a/b:b	(Lcom/ta/utdid2/a/b;)Landroid/content/Context;
      //   395: aload_0
      //   396: getfield 37	com/ta/utdid2/a/b$a:e	Ljava/lang/String;
      //   399: aload 9
      //   401: aload_0
      //   402: getfield 28	com/ta/utdid2/a/b$a:f	Ljava/lang/String;
      //   405: invokestatic 139	com/ta/utdid2/a/c:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
      //   408: return
      //
      // Exception table:
      //   from	to	target	type
      //   94	101	130	java/lang/Exception
      //   106	121	130	java/lang/Exception
      //   121	127	130	java/lang/Exception
      //   324	333	130	java/lang/Exception
      //   31	43	225	java/lang/Exception
      //   52	85	281	java/lang/Exception
      //   266	275	281	java/lang/Exception
      //   172	192	336	java/io/IOException
      //   211	224	353	finally
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.ta.utdid2.a.b
 * JD-Core Version:    0.6.0
 */