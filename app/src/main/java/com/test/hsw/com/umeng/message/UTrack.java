package com.umeng.message;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.message.b.dd;
import com.umeng.message.b.ep;
import com.umeng.message.b.ep.e;
import com.umeng.message.b.fb;
import com.umeng.message.protobuffer.PushResponse;
import com.umeng.message.protobuffer.PushResponse.responseCode;
import java.util.Random;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.android.agoo.client.f;
import org.android.agoo.client.h;
import org.json.JSONException;
import org.json.JSONObject;

public class UTrack
{
  private static final String a = UTrack.class.getName();
  private static UTrack d;
  private static boolean h = false;
  private static boolean i = false;
  private static boolean j = false;
  private static boolean k = false;
  private JSONObject b;
  private JSONObject c;
  private ScheduledThreadPoolExecutor e;
  private Context f;
  private boolean g;

  private UTrack(Context paramContext)
  {
    this.f = paramContext.getApplicationContext();
    b();
    this.e = new ScheduledThreadPoolExecutor(4 * Runtime.getRuntime().availableProcessors());
  }

  private JSONObject a(JSONObject paramJSONObject, String paramString)
    throws ep.e, JSONException, Exception
  {
    String str = ep.c(paramString).H().r("application/json").i(paramJSONObject.toString()).b("UTF-8");
    com.umeng.b.a.a.c(a, "sendRequest() url=" + paramString + "\n request = " + paramJSONObject + "\n response = " + str);
    return new JSONObject(str);
  }

  private void a(String paramString, int paramInt, long paramLong)
  {
    if (!c())
      return;
    if (TextUtils.isEmpty(paramString))
    {
      com.umeng.b.a.a.b(a, "trackMsgLog: empty msgId");
      return;
    }
    long l1 = System.currentTimeMillis();
    try
    {
      MsgLogStore.getInstance(this.f).addLog(paramString, paramInt, l1);
      UTrack.1 local1 = new UTrack.1(this, paramString, paramInt, l1);
      if ((paramLong > 0L) && (paramInt != 1))
      {
        l2 = Math.abs(new Random().nextLong() % paramLong);
        String str = a;
        Object[] arrayOfObject = new Object[4];
        arrayOfObject[0] = paramString;
        arrayOfObject[1] = Integer.valueOf(paramInt);
        arrayOfObject[2] = Long.valueOf(paramLong);
        arrayOfObject[3] = Long.valueOf(l2);
        com.umeng.b.a.a.c(str, String.format("trackMsgLog(msgId=%s, actionType=%d, random=%d, delay=%d)", arrayOfObject));
        this.e.schedule(local1, l2, TimeUnit.MILLISECONDS);
        return;
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        localException.printStackTrace();
        com.umeng.b.a.a.c(a, "trackMsgLog: " + localException.toString());
        continue;
        long l2 = 0L;
      }
    }
  }

  private void a(String paramString1, String paramString2, int paramInt)
  {
    MessageSharedPrefs.getInstance(this.f).addFailAliasTypeSingle(paramString1, paramString2, paramInt);
    MessageSharedPrefs.getInstance(this.f).addFailAlias(paramString1, paramString2, paramInt);
    switch (paramInt)
    {
    default:
      return;
    case 0:
      b(paramString1, paramString2, 1);
      return;
    case 1:
    }
    b(paramString1, paramString2, 0);
  }

  private void a(String paramString1, String paramString2, String paramString3)
  {
    if (!c())
      return;
    if (TextUtils.isEmpty(paramString1))
    {
      com.umeng.b.a.a.b(a, "trackMsgLogForAgoo: empty msgId");
      return;
    }
    long l = System.currentTimeMillis();
    try
    {
      MsgLogStore.getInstance(this.f).addLogForAgoo(paramString1, paramString2, paramString3, l);
      UTrack.2 local2 = new UTrack.2(this, paramString1, paramString2, paramString3, l);
      this.e.submit(local2);
      return;
    }
    catch (Exception localException)
    {
      while (true)
      {
        localException.printStackTrace();
        com.umeng.b.a.a.c(a, "trackMsgLog: " + localException.toString());
      }
    }
  }

  private void b()
  {
    dd localdd1;
    if (this.b == null)
    {
      localdd1 = new dd();
      localdd1.b(this.f, new String[0]);
      Context localContext1 = this.f;
      String[] arrayOfString1 = new String[2];
      arrayOfString1[0] = PushAgent.getInstance(this.f).getMessageAppkey();
      arrayOfString1[1] = PushAgent.getInstance(this.f).getMessageChannel();
      localdd1.a(localContext1, arrayOfString1);
      this.b = new JSONObject();
    }
    try
    {
      localdd1.b(this.b);
      if (this.c == null)
      {
        localdd2 = new dd();
        localdd2.c(this.f, new String[0]);
        Context localContext2 = this.f;
        String[] arrayOfString2 = new String[2];
        arrayOfString2[0] = PushAgent.getInstance(this.f).getMessageAppkey();
        arrayOfString2[1] = PushAgent.getInstance(this.f).getMessageChannel();
        localdd2.a(localContext2, arrayOfString2);
        this.c = new JSONObject();
      }
    }
    catch (Exception localException1)
    {
      try
      {
        dd localdd2;
        localdd2.c(this.c);
        return;
        localException1 = localException1;
        localException1.printStackTrace();
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
    }
  }

  // ERROR //
  private void b(String paramString, int paramInt, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 282	com/umeng/message/UTrack:f	()Lorg/json/JSONObject;
    //   6: astore 8
    //   8: aload 8
    //   10: ldc_w 284
    //   13: aload_1
    //   14: invokevirtual 288	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   17: pop
    //   18: aload 8
    //   20: ldc_w 290
    //   23: iload_2
    //   24: invokevirtual 293	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   27: pop
    //   28: aload 8
    //   30: ldc_w 295
    //   33: lload_3
    //   34: invokevirtual 298	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   37: pop
    //   38: new 300	com/umeng/message/b/fb
    //   41: dup
    //   42: aload_0
    //   43: getfield 51	com/umeng/message/UTrack:f	Landroid/content/Context;
    //   46: invokespecial 302	com/umeng/message/b/fb:<init>	(Landroid/content/Context;)V
    //   49: astore 12
    //   51: aload 12
    //   53: aload 12
    //   55: aload 8
    //   57: invokevirtual 305	com/umeng/message/b/fb:a	(Lorg/json/JSONObject;)[B
    //   60: getstatic 310	com/umeng/message/MsgConstant:LOG_ENDPOINT	Ljava/lang/String;
    //   63: invokevirtual 313	com/umeng/message/b/fb:a	([BLjava/lang/String;)Lcom/umeng/message/protobuffer/PushResponse;
    //   66: astore 13
    //   68: aload 13
    //   70: ifnull +51 -> 121
    //   73: aload 13
    //   75: getfield 319	com/umeng/message/protobuffer/PushResponse:code	Lcom/umeng/message/protobuffer/PushResponse$responseCode;
    //   78: getstatic 324	com/umeng/message/protobuffer/PushResponse$responseCode:SUCCESS	Lcom/umeng/message/protobuffer/PushResponse$responseCode;
    //   81: invokevirtual 328	com/umeng/message/protobuffer/PushResponse$responseCode:equals	(Ljava/lang/Object;)Z
    //   84: ifeq +37 -> 121
    //   87: aload_0
    //   88: getfield 51	com/umeng/message/UTrack:f	Landroid/content/Context;
    //   91: invokestatic 159	com/umeng/message/MsgLogStore:getInstance	(Landroid/content/Context;)Lcom/umeng/message/MsgLogStore;
    //   94: aload_1
    //   95: iload_2
    //   96: invokevirtual 332	com/umeng/message/MsgLogStore:removeLog	(Ljava/lang/String;I)Z
    //   99: pop
    //   100: iload_2
    //   101: ifeq +20 -> 121
    //   104: iload_2
    //   105: iconst_3
    //   106: if_icmpeq +15 -> 121
    //   109: aload_0
    //   110: getfield 51	com/umeng/message/UTrack:f	Landroid/content/Context;
    //   113: invokestatic 159	com/umeng/message/MsgLogStore:getInstance	(Landroid/content/Context;)Lcom/umeng/message/MsgLogStore;
    //   116: aload_1
    //   117: invokevirtual 336	com/umeng/message/MsgLogStore:removeLogIdType	(Ljava/lang/String;)Z
    //   120: pop
    //   121: aload_0
    //   122: monitorexit
    //   123: return
    //   124: astore 7
    //   126: aload 7
    //   128: invokevirtual 337	org/json/JSONException:printStackTrace	()V
    //   131: getstatic 31	com/umeng/message/UTrack:a	Ljava/lang/String;
    //   134: aload 7
    //   136: invokevirtual 338	org/json/JSONException:toString	()Ljava/lang/String;
    //   139: invokestatic 129	com/umeng/b/a/a:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   142: goto -21 -> 121
    //   145: astore 6
    //   147: aload_0
    //   148: monitorexit
    //   149: aload 6
    //   151: athrow
    //   152: astore 5
    //   154: aload 5
    //   156: invokevirtual 211	java/lang/Exception:printStackTrace	()V
    //   159: getstatic 31	com/umeng/message/UTrack:a	Ljava/lang/String;
    //   162: aload 5
    //   164: invokevirtual 214	java/lang/Exception:toString	()Ljava/lang/String;
    //   167: invokestatic 129	com/umeng/b/a/a:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   170: goto -49 -> 121
    //
    // Exception table:
    //   from	to	target	type
    //   2	68	124	org/json/JSONException
    //   73	100	124	org/json/JSONException
    //   109	121	124	org/json/JSONException
    //   2	68	145	finally
    //   73	100	145	finally
    //   109	121	145	finally
    //   126	142	145	finally
    //   154	170	145	finally
    //   2	68	152	java/lang/Exception
    //   73	100	152	java/lang/Exception
    //   109	121	152	java/lang/Exception
  }

  private void b(String paramString1, String paramString2, int paramInt)
  {
    if (MessageSharedPrefs.getInstance(this.f).isFailAliasType(paramString2, paramInt))
    {
      MessageSharedPrefs.getInstance(this.f).removeFailAliasTypeSingle(paramString2, paramInt);
      MessageSharedPrefs.getInstance(this.f).removeFailAlias(paramString1, paramString2, paramInt);
    }
  }

  private boolean c()
  {
    if (TextUtils.isEmpty(com.umeng.b.a.b.z(this.f)))
    {
      com.umeng.b.a.a.b(a, "UTDID is empty");
      return false;
    }
    if (TextUtils.isEmpty(UmengRegistrar.getRegistrationId(this.f)))
    {
      com.umeng.b.a.a.b(a, "RegistrationId is empty");
      return false;
    }
    return true;
  }

  // ERROR //
  @android.annotation.SuppressLint({"NewApi"})
  private String d()
  {
    // Byte code:
    //   0: invokestatic 378	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   3: ldc_w 380
    //   6: invokevirtual 381	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9: ifne +5 -> 14
    //   12: aconst_null
    //   13: areturn
    //   14: new 107	java/lang/StringBuilder
    //   17: dup
    //   18: invokestatic 385	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   21: invokevirtual 390	java/io/File:getPath	()Ljava/lang/String;
    //   24: invokestatic 393	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   27: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   30: ldc_w 395
    //   33: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_0
    //   37: getfield 51	com/umeng/message/UTrack:f	Landroid/content/Context;
    //   40: invokevirtual 398	android/content/Context:getPackageName	()Ljava/lang/String;
    //   43: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: ldc_w 400
    //   49: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: astore_2
    //   56: getstatic 31	com/umeng/message/UTrack:a	Ljava/lang/String;
    //   59: new 107	java/lang/StringBuilder
    //   62: dup
    //   63: ldc_w 402
    //   66: invokespecial 112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   69: aload_2
    //   70: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 129	com/umeng/b/a/a:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: new 387	java/io/File
    //   82: dup
    //   83: aload_2
    //   84: ldc_w 404
    //   87: invokespecial 406	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   90: astore_3
    //   91: aload_3
    //   92: invokevirtual 409	java/io/File:exists	()Z
    //   95: istore 4
    //   97: iload 4
    //   99: ifeq +212 -> 311
    //   102: new 411	java/io/BufferedReader
    //   105: dup
    //   106: new 413	java/io/FileReader
    //   109: dup
    //   110: aload_3
    //   111: invokespecial 416	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   114: invokespecial 419	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   117: astore 5
    //   119: aload 5
    //   121: invokevirtual 422	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   124: astore 12
    //   126: aload 12
    //   128: ifnonnull +31 -> 159
    //   131: aload 5
    //   133: ifnull +178 -> 311
    //   136: aload 5
    //   138: invokevirtual 425	java/io/BufferedReader:close	()V
    //   141: aconst_null
    //   142: areturn
    //   143: astore 15
    //   145: aload 15
    //   147: invokevirtual 426	java/io/IOException:printStackTrace	()V
    //   150: aconst_null
    //   151: areturn
    //   152: astore_1
    //   153: aload_1
    //   154: invokevirtual 211	java/lang/Exception:printStackTrace	()V
    //   157: aconst_null
    //   158: areturn
    //   159: aload 12
    //   161: ldc_w 428
    //   164: invokevirtual 431	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   167: ifeq -48 -> 119
    //   170: aload 12
    //   172: ldc_w 428
    //   175: invokevirtual 434	java/lang/String:length	()I
    //   178: invokevirtual 438	java/lang/String:substring	(I)Ljava/lang/String;
    //   181: astore 13
    //   183: aload 5
    //   185: ifnull +8 -> 193
    //   188: aload 5
    //   190: invokevirtual 425	java/io/BufferedReader:close	()V
    //   193: aload 13
    //   195: areturn
    //   196: astore 14
    //   198: aload 14
    //   200: invokevirtual 426	java/io/IOException:printStackTrace	()V
    //   203: goto -10 -> 193
    //   206: astore 6
    //   208: aconst_null
    //   209: astore 5
    //   211: aload 6
    //   213: invokevirtual 439	java/io/FileNotFoundException:printStackTrace	()V
    //   216: aload 5
    //   218: ifnull +93 -> 311
    //   221: aload 5
    //   223: invokevirtual 425	java/io/BufferedReader:close	()V
    //   226: aconst_null
    //   227: areturn
    //   228: astore 9
    //   230: aload 9
    //   232: invokevirtual 426	java/io/IOException:printStackTrace	()V
    //   235: aconst_null
    //   236: areturn
    //   237: astore 10
    //   239: aconst_null
    //   240: astore 5
    //   242: aload 10
    //   244: invokevirtual 426	java/io/IOException:printStackTrace	()V
    //   247: aload 5
    //   249: ifnull +62 -> 311
    //   252: aload 5
    //   254: invokevirtual 425	java/io/BufferedReader:close	()V
    //   257: aconst_null
    //   258: areturn
    //   259: astore 11
    //   261: aload 11
    //   263: invokevirtual 426	java/io/IOException:printStackTrace	()V
    //   266: aconst_null
    //   267: areturn
    //   268: astore 7
    //   270: aconst_null
    //   271: astore 5
    //   273: aload 5
    //   275: ifnull +8 -> 283
    //   278: aload 5
    //   280: invokevirtual 425	java/io/BufferedReader:close	()V
    //   283: aload 7
    //   285: athrow
    //   286: astore 8
    //   288: aload 8
    //   290: invokevirtual 426	java/io/IOException:printStackTrace	()V
    //   293: goto -10 -> 283
    //   296: astore 7
    //   298: goto -25 -> 273
    //   301: astore 10
    //   303: goto -61 -> 242
    //   306: astore 6
    //   308: goto -97 -> 211
    //   311: aconst_null
    //   312: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   136	141	143	java/io/IOException
    //   0	12	152	java/lang/Exception
    //   14	97	152	java/lang/Exception
    //   136	141	152	java/lang/Exception
    //   145	150	152	java/lang/Exception
    //   188	193	152	java/lang/Exception
    //   198	203	152	java/lang/Exception
    //   221	226	152	java/lang/Exception
    //   230	235	152	java/lang/Exception
    //   252	257	152	java/lang/Exception
    //   261	266	152	java/lang/Exception
    //   278	283	152	java/lang/Exception
    //   283	286	152	java/lang/Exception
    //   288	293	152	java/lang/Exception
    //   188	193	196	java/io/IOException
    //   102	119	206	java/io/FileNotFoundException
    //   221	226	228	java/io/IOException
    //   102	119	237	java/io/IOException
    //   252	257	259	java/io/IOException
    //   102	119	268	finally
    //   278	283	286	java/io/IOException
    //   119	126	296	finally
    //   159	183	296	finally
    //   211	216	296	finally
    //   242	247	296	finally
    //   119	126	301	java/io/IOException
    //   159	183	301	java/io/IOException
    //   119	126	306	java/io/FileNotFoundException
    //   159	183	306	java/io/FileNotFoundException
  }

  private JSONObject e()
    throws JSONException
  {
    String str1 = UmengRegistrar.getRegistrationId(this.f);
    String str2 = com.umeng.b.a.b.z(this.f);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("header", this.b);
    localJSONObject.put("utdid", str2);
    localJSONObject.put("device_token", str1);
    return localJSONObject;
  }

  private JSONObject f()
    throws JSONException
  {
    String str1 = UmengRegistrar.getRegistrationId(this.f);
    String str2 = com.umeng.b.a.b.z(this.f);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("header", this.c);
    localJSONObject.put("utdid", str2);
    localJSONObject.put("device_token", str1);
    return localJSONObject;
  }

  public static UTrack getInstance(Context paramContext)
  {
    monitorenter;
    try
    {
      if (d == null)
        d = new UTrack(paramContext);
      UTrack localUTrack = d;
      return localUTrack;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  void a(com.umeng.message.a.a parama)
  {
    if ((parama == null) || (parama.h == null))
      return;
    a(parama.h, 0, 60000L * parama.D);
  }

  public boolean addAlias(String paramString1, String paramString2)
  {
    int m = 1;
    if (TextUtils.isEmpty(paramString2))
      com.umeng.b.a.a.b(a, "addAlias: empty type");
    do
      return false;
    while (!c());
    if (MessageSharedPrefs.getInstance(this.f).isAliasSet(paramString1, paramString2))
    {
      String str2 = a;
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = paramString1;
      arrayOfObject2[m] = paramString2;
      com.umeng.b.a.a.c(str2, String.format("addAlias: <%s, %s> has been synced to the server before. Ingore this request.", arrayOfObject2));
      return m;
    }
    if ((MessageSharedPrefs.getInstance(this.f).getAliasCount() >= 20) && (!MessageSharedPrefs.getInstance(this.f).isAliaseTypeSet(paramString2)))
    {
      String str1 = a;
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = paramString1;
      arrayOfObject1[m] = paramString2;
      com.umeng.b.a.a.b(str1, String.format("addAlias: <%s, %s>, More than 20 types of alias have been added. Ignore this request", arrayOfObject1));
      return false;
    }
    while (true)
    {
      try
      {
        JSONObject localJSONObject = e();
        localJSONObject.put("alias", paramString1);
        localJSONObject.put("type", paramString2);
        localJSONObject.put("last_alias", MessageSharedPrefs.getInstance(this.f).getLastAlias(paramString2));
        localJSONObject.put("ts", System.currentTimeMillis());
        fb localfb = new fb(this.f);
        PushResponse localPushResponse = localfb.a(localfb.a(localJSONObject), MsgConstant.ALIAS_ENDPOINT);
        if (localPushResponse == null)
          continue;
        com.umeng.b.a.a.c(a, "addAlias: " + localPushResponse.code + ", " + localPushResponse.description);
        if ((localPushResponse == null) || (!localPushResponse.code.equals(PushResponse.responseCode.SUCCESS)))
          continue;
        MessageSharedPrefs.getInstance(this.f).addAlias(paramString1, paramString2);
        b(paramString1, paramString2, 0);
        return m;
        if ((localPushResponse == null) || (localPushResponse.description == null))
          continue;
        if ((!localPushResponse.description.contains("Alias in process, try later!")) && (!localPushResponse.description.contains("Request time out!")))
        {
          n = 0;
          if ((n != 0) || (localPushResponse.description.contains("Server exception!")))
            continue;
          m = 0;
          if (m == 0)
            break label429;
          a(paramString1, paramString2, 0);
          if (localPushResponse != null)
            break;
          a(paramString1, paramString2, 0);
          return false;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        a(paramString1, paramString2, 0);
        return false;
      }
      int n = m;
      continue;
      label429: b(paramString1, paramString2, 0);
    }
  }

  public boolean addExclusiveAlias(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2))
      com.umeng.b.a.a.b(a, "addExclusiveAlias: empty type");
    do
      return false;
    while (!c());
    if (MessageSharedPrefs.getInstance(this.f).isAliasSet(paramString1, paramString2))
    {
      com.umeng.b.a.a.c(a, String.format("addExclusiveAlias: <%s, %s> has been synced to the server before. Ingore this request.", new Object[] { paramString1, paramString2 }));
      return true;
    }
    if ((MessageSharedPrefs.getInstance(this.f).getAliasCount() >= 20) && (!MessageSharedPrefs.getInstance(this.f).isAliaseTypeSet(paramString2)))
    {
      com.umeng.b.a.a.b(a, String.format("addAlias: <%s, %s>, More than 20 types of alias have been added. Ignore this request", new Object[] { paramString1, paramString2 }));
      return false;
    }
    while (true)
    {
      try
      {
        JSONObject localJSONObject = e();
        localJSONObject.put("alias", paramString1);
        localJSONObject.put("type", paramString2);
        localJSONObject.put("last_alias", MessageSharedPrefs.getInstance(this.f).getLastAlias(paramString2));
        localJSONObject.put("ts", System.currentTimeMillis());
        fb localfb = new fb(this.f);
        PushResponse localPushResponse = localfb.a(localfb.a(localJSONObject), MsgConstant.ALIAS_EXCLUSIVE_ENDPOINT);
        if (localPushResponse == null)
          continue;
        com.umeng.b.a.a.c(a, "addExclusiveAlias: " + localPushResponse.code + ", " + localPushResponse.description);
        if ((localPushResponse == null) || (!localPushResponse.code.equals(PushResponse.responseCode.SUCCESS)))
          continue;
        MessageSharedPrefs.getInstance(this.f).addAlias(paramString1, paramString2);
        b(paramString1, paramString2, 1);
        return true;
        if ((localPushResponse == null) || (localPushResponse.description == null))
          continue;
        if ((!localPushResponse.description.contains("Alias in process, try later!")) && (!localPushResponse.description.contains("Request time out!")))
        {
          m = 0;
          if ((m != 0) || (localPushResponse.description.contains("Server exception!")))
            break label411;
          n = 0;
          if (n == 0)
            break label417;
          a(paramString1, paramString2, 1);
          if (localPushResponse != null)
            break;
          a(paramString1, paramString2, 1);
          return false;
        }
      }
      catch (Exception localException)
      {
        if (localException == null)
          continue;
        localException.printStackTrace();
        a(paramString1, paramString2, 1);
        return false;
      }
      int m = 1;
      continue;
      label411: int n = 1;
      continue;
      label417: b(paramString1, paramString2, 1);
    }
  }

  public JSONObject getHeader()
  {
    return this.b;
  }

  public boolean removeAlias(String paramString1, String paramString2)
    throws ep.e, JSONException, Exception
  {
    if (TextUtils.isEmpty(paramString2))
      com.umeng.b.a.a.b(a, "removeAlias: empty type");
    PushResponse localPushResponse;
    do
    {
      do
        return false;
      while (!c());
      JSONObject localJSONObject = e();
      localJSONObject.put("alias", paramString1);
      localJSONObject.put("type", paramString2);
      localJSONObject.put("ts", System.currentTimeMillis());
      fb localfb = new fb(this.f);
      localPushResponse = localfb.a(localfb.a(localJSONObject), MsgConstant.DELETE_ALIAS_ENDPOINT);
      if (localPushResponse == null)
        continue;
      com.umeng.b.a.a.c(a, "removeAlias: " + localPushResponse.code + ", " + localPushResponse.description);
    }
    while ((localPushResponse == null) || (!localPushResponse.code.equals(PushResponse.responseCode.SUCCESS)));
    MessageSharedPrefs.getInstance(this.f).removeAlias(paramString1, paramString2);
    return true;
  }

  public void sendCachedMsgLog(long paramLong)
  {
    if (!c())
      return;
    if ((h) || (i))
    {
      com.umeng.b.a.a.c(a, "sendCachedMsgLog already in queue, abort this request.");
      return;
    }
    com.umeng.b.a.a.c(a, "sendCachedMsgLog start, set cacheLogSending flag");
    h = true;
    i = true;
    UTrack.3 local3 = new UTrack.3(this);
    String str = a;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Long.valueOf(paramLong);
    com.umeng.b.a.a.c(str, String.format("sendCachedMsgLog(delay=%d)", arrayOfObject));
    this.e.schedule(local3, paramLong, TimeUnit.MILLISECONDS);
    UTrack.4 local4 = new UTrack.4(this);
    this.e.submit(local4);
  }

  public void sendMsgLogForAgoo(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    monitorenter;
    try
    {
      com.umeng.b.a.a.c(a, "sendMsgLogForAgoo:msgId=" + paramString1 + ",taskId=" + paramString2 + ",msgStatus=" + paramString3 + ",time=" + paramLong);
      try
      {
        f localf = new f();
        localf.b("mtop.push.msg.report");
        localf.c("1.0");
        if (!TextUtils.isEmpty(paramString2))
          localf.a("task_id", paramString2);
        localf.a("messageId", paramString1);
        localf.a("mesgStatus", paramString3);
        org.android.agoo.b localb = UmengRegistrar.getIMtopService(this.f);
        if ((localb != null) && (localb.getV3(this.f, localf).a()))
        {
          MsgLogStore.getInstance(this.f).removeLogForAgoo(paramString1, paramString3);
          if (!paramString3.equals("7"))
            MsgLogStore.getInstance(this.f).removeLogIdTypeForAgoo(paramString1);
        }
        monitorexit;
        return;
      }
      catch (Exception localException)
      {
        while (true)
        {
          localException.printStackTrace();
          com.umeng.b.a.a.c(a, localException.toString());
        }
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void setClearPrevMessage(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }

  public void trackAppLaunch(long paramLong)
  {
    if (!c())
      return;
    if (j)
    {
      com.umeng.b.a.a.c(a, "trackAppLaunch already in queue, abort this request.");
      return;
    }
    com.umeng.b.a.a.c(a, "trackAppLaunch start, set appLaunchSending flag");
    j = true;
    UTrack.5 local5 = new UTrack.5(this);
    String str = a;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Long.valueOf(paramLong);
    com.umeng.b.a.a.c(str, String.format("trackAppLaunch(delay=%d)", arrayOfObject));
    this.e.schedule(local5, paramLong, TimeUnit.MILLISECONDS);
  }

  public void trackMsgClick(com.umeng.message.a.a parama)
  {
    if ((parama != null) && (parama.h != null))
      a(parama.h, 1, 60000L * parama.D);
    if ((parama != null) && (parama.i != null))
      a(parama.i, parama.j, "8");
    if (this.g)
      ((UmengMessageHandler)PushAgent.getInstance(this.f).getMessageHandler()).setPrevMessage(null);
  }

  public void trackMsgDismissed(com.umeng.message.a.a parama)
  {
    if ((parama != null) && (parama.h != null))
      a(parama.h, 2, 60000L * parama.D);
    if ((parama != null) && (parama.i != null))
      a(parama.i, parama.j, "9");
    if (this.g)
      ((UmengMessageHandler)PushAgent.getInstance(this.f).getMessageHandler()).setPrevMessage(null);
  }

  public void trackMsgDisplay(com.umeng.message.a.a parama)
  {
    if ((parama != null) && (parama.h != null))
      a(parama.h, 3, 60000L * parama.D);
  }

  public void trackRegister()
  {
    if (!c())
      return;
    if (k)
    {
      com.umeng.b.a.a.c(a, "sendRegisterLog already in queue, abort this request.");
      return;
    }
    com.umeng.b.a.a.c(a, "trackRegisterLog start, set registerSending flag");
    k = true;
    UTrack.6 local6 = new UTrack.6(this);
    String str = a;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(0);
    com.umeng.b.a.a.c(str, String.format("trackRegister(delay=%d)", arrayOfObject));
    this.e.schedule(local6, 0L, TimeUnit.MILLISECONDS);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.UTrack
 * JD-Core Version:    0.6.0
 */