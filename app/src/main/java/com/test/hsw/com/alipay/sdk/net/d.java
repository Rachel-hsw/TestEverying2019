package com.alipay.sdk.net;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.data.f;
import com.alipay.sdk.exception.NetErrorException;
import com.alipay.sdk.protocol.g;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.Calendar;
import java.util.Random;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
{
  private int a = 0;
  private com.alipay.sdk.data.c b;

  public d()
  {
  }

  public d(com.alipay.sdk.data.c paramc)
  {
    this.b = paramc;
  }

  private String a(Context paramContext, String paramString1, String paramString2, com.alipay.sdk.data.c paramc, f paramf)
    throws NetErrorException
  {
    while (true)
    {
      try
      {
        if (c.a != null)
          continue;
        c.a = new a(paramContext, paramString1);
        if (paramc != null)
        {
          localObject2 = c.a.a(paramString2, paramc);
          StatusLine localStatusLine = ((HttpResponse)localObject2).getStatusLine();
          paramf.c = localStatusLine.getStatusCode();
          paramf.d = localStatusLine.getReasonPhrase();
          com.alipay.sdk.data.c localc = this.b;
          Header[] arrayOfHeader = ((HttpResponse)localObject2).getHeaders("Msp-Param");
          if ((localc == null) || (arrayOfHeader.length <= 0))
            continue;
          localc.b = arrayOfHeader;
          String str = c.a((HttpResponse)localObject2);
          return str;
          if (TextUtils.equals(paramString1, c.a.a))
            continue;
          c.a.a = paramString1;
          continue;
        }
      }
      catch (Exception localException)
      {
        throw new NetErrorException();
      }
      finally
      {
        c.a = null;
      }
      HttpResponse localHttpResponse = c.a.a(paramString2, null);
      Object localObject2 = localHttpResponse;
    }
  }

  // ERROR //
  private static String a(String paramString)
  {
    // Byte code:
    //   0: new 88	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 91	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: new 93	java/io/BufferedReader
    //   12: dup
    //   13: new 95	java/io/InputStreamReader
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 98	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   21: invokespecial 101	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   24: astore_2
    //   25: sipush 2048
    //   28: newarray char
    //   30: astore 7
    //   32: new 103	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   39: astore 8
    //   41: aload_2
    //   42: aload 7
    //   44: invokevirtual 108	java/io/BufferedReader:read	([C)I
    //   47: istore 9
    //   49: iload 9
    //   51: ifle +29 -> 80
    //   54: aload 8
    //   56: aload 7
    //   58: iconst_0
    //   59: iload 9
    //   61: invokevirtual 112	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: goto -24 -> 41
    //   68: astore 5
    //   70: aload_1
    //   71: ifnull +7 -> 78
    //   74: aload_1
    //   75: invokevirtual 117	java/io/InputStream:close	()V
    //   78: aconst_null
    //   79: areturn
    //   80: aload_2
    //   81: invokevirtual 118	java/io/BufferedReader:close	()V
    //   84: aload 8
    //   86: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: astore 11
    //   91: aload_1
    //   92: invokevirtual 117	java/io/InputStream:close	()V
    //   95: aload 11
    //   97: areturn
    //   98: astore 12
    //   100: aload 11
    //   102: areturn
    //   103: astore 14
    //   105: aconst_null
    //   106: astore_1
    //   107: aload 14
    //   109: astore_3
    //   110: aload_1
    //   111: ifnull +7 -> 118
    //   114: aload_1
    //   115: invokevirtual 117	java/io/InputStream:close	()V
    //   118: aload_3
    //   119: athrow
    //   120: astore 6
    //   122: aconst_null
    //   123: areturn
    //   124: astore 4
    //   126: goto -8 -> 118
    //   129: astore_3
    //   130: goto -20 -> 110
    //   133: astore 13
    //   135: aconst_null
    //   136: astore_1
    //   137: goto -67 -> 70
    //
    // Exception table:
    //   from	to	target	type
    //   9	41	68	java/lang/Exception
    //   41	49	68	java/lang/Exception
    //   54	65	68	java/lang/Exception
    //   80	91	68	java/lang/Exception
    //   91	95	98	java/io/IOException
    //   0	9	103	finally
    //   74	78	120	java/io/IOException
    //   114	118	124	java/io/IOException
    //   9	41	129	finally
    //   41	49	129	finally
    //   54	65	129	finally
    //   80	91	129	finally
    //   0	9	133	java/lang/Exception
  }

  private JSONObject a(Context paramContext, com.alipay.sdk.data.e parame, f paramf)
    throws NetErrorException
  {
    int i = 0;
    Random localRandom = new Random();
    StringBuilder localStringBuilder = new StringBuilder();
    if (i < 24)
    {
      switch (localRandom.nextInt(3))
      {
      default:
      case 0:
      case 1:
      case 2:
      }
      while (true)
      {
        i++;
        break;
        localStringBuilder.append(String.valueOf((char)(int)Math.round(65.0D + 25.0D * Math.random())));
        continue;
        localStringBuilder.append(String.valueOf((char)(int)Math.round(97.0D + 25.0D * Math.random())));
        continue;
        localStringBuilder.append(String.valueOf(new Random().nextInt(10)));
      }
    }
    String str1 = localStringBuilder.toString();
    try
    {
      str2 = a(paramContext, parame.a.a, parame.a(str1).toString(), (com.alipay.sdk.data.c)parame.b.get(), paramf);
      paramf.e = Calendar.getInstance().getTimeInMillis();
      if (parame.c)
      {
        JSONObject localJSONObject2 = a(str2, paramf);
        if ((paramf.c == 1000) && (this.a < 3))
        {
          this.a = (1 + this.a);
          return a(paramContext, parame, paramf);
        }
        this.a = 0;
        String str3 = com.alipay.sdk.encrypt.e.b(str1, localJSONObject2.optString("res_data"));
        new StringBuilder("respData:").append(str3).toString();
        JSONObject localJSONObject3 = new JSONObject(str3);
        return localJSONObject3;
      }
    }
    catch (NetErrorException localNetErrorException)
    {
      String str2;
      throw localNetErrorException;
      JSONObject localJSONObject1 = a(str2, paramf);
      new StringBuilder("respData:").append(localJSONObject1.toString()).toString();
      return localJSONObject1;
    }
    catch (Exception localException)
    {
    }
    throw new NetErrorException();
  }

  private JSONObject a(Context paramContext, com.alipay.sdk.data.e parame, f paramf, String paramString1, String paramString2)
    throws JSONException, NetErrorException
  {
    JSONObject localJSONObject = a(paramString2, paramf);
    if ((paramf.c == 1000) && (this.a < 3))
    {
      this.a = (1 + this.a);
      return a(paramContext, parame, paramf);
    }
    this.a = 0;
    String str = com.alipay.sdk.encrypt.e.b(paramString1, localJSONObject.optString("res_data"));
    new StringBuilder("respData:").append(str).toString();
    return new JSONObject(str);
  }

  private static JSONObject a(f paramf, String paramString)
    throws JSONException
  {
    JSONObject localJSONObject = a(paramString, paramf);
    new StringBuilder("respData:").append(localJSONObject.toString()).toString();
    return localJSONObject;
  }

  private static JSONObject a(String paramString, f paramf)
    throws JSONException
  {
    JSONObject localJSONObject1 = new JSONObject(paramString).optJSONObject("data");
    if (localJSONObject1 != null)
    {
      paramf.c = localJSONObject1.optInt("code", 503);
      paramf.d = localJSONObject1.optString("error_msg", "");
      JSONObject localJSONObject2 = localJSONObject1.optJSONObject("params");
      if (localJSONObject2 != null)
      {
        if (paramf.c == 1000)
        {
          String str = localJSONObject2.optString("public_key");
          if (!TextUtils.isEmpty(str))
            com.alipay.sdk.sys.b.a().b.a(str);
        }
        com.alipay.sdk.data.a locala = new com.alipay.sdk.data.a();
        locala.c = localJSONObject2.optString("next_api_name");
        locala.d = localJSONObject2.optString("next_api_version");
        locala.b = localJSONObject2.optString("next_namespace");
        locala.a = localJSONObject2.optString("next_request_url");
        paramf.l = locala;
        return localJSONObject2;
      }
    }
    while (true)
    {
      return null;
      paramf.c = 503;
      paramf.d = "";
    }
  }

  private static void a(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("public_key");
    if (!TextUtils.isEmpty(str))
      com.alipay.sdk.sys.b.a().b.a(str);
  }

  public final com.alipay.sdk.protocol.c a(Context paramContext, com.alipay.sdk.data.e parame, boolean paramBoolean)
    throws NetErrorException
  {
    f localf1 = new f();
    JSONObject localJSONObject1 = a(paramContext, parame, localf1);
    byte[] arrayOfByte1;
    if (localJSONObject1.optBoolean("gzip"))
    {
      JSONObject localJSONObject5 = localJSONObject1.optJSONObject("form");
      if ((localJSONObject5 != null) && (localJSONObject5.has("quickpay")))
        arrayOfByte1 = com.alipay.sdk.encrypt.a.a(localJSONObject5.optString("quickpay"));
    }
    try
    {
      byte[] arrayOfByte2 = com.alipay.sdk.data.b.a(arrayOfByte1);
      if (TextUtils.equals(com.alipay.sdk.encrypt.c.a(arrayOfByte2), localJSONObject1.optString("md5")))
        localJSONObject1.put("form", new JSONObject(new String(arrayOfByte2, "utf-8")));
      while (true)
      {
        new StringBuilder("responsestring decoded ").append(localJSONObject1).toString();
        localObject1 = new com.alipay.sdk.protocol.c(parame, localf1);
        ((com.alipay.sdk.protocol.c)localObject1).a(localJSONObject1);
        if (!paramBoolean)
          break;
        return localObject1;
        localf1.k = false;
      }
      new com.alipay.sdk.protocol.e();
      localg = com.alipay.sdk.protocol.e.a((com.alipay.sdk.protocol.c)localObject1);
      if (localg == null)
      {
        f localf2 = ((com.alipay.sdk.protocol.c)localObject1).b;
        JSONObject localJSONObject2 = ((com.alipay.sdk.protocol.c)localObject1).c;
        com.alipay.sdk.data.a locala1 = ((com.alipay.sdk.protocol.c)localObject1).a.a;
        com.alipay.sdk.data.a locala2 = ((com.alipay.sdk.protocol.c)localObject1).b.l;
        if (TextUtils.isEmpty(locala2.c))
          locala2.c = locala1.c;
        if (TextUtils.isEmpty(locala2.d))
          locala2.d = locala1.d;
        if (TextUtils.isEmpty(locala2.b))
          locala2.b = locala1.b;
        if (TextUtils.isEmpty(locala2.a))
          locala2.a = locala1.a;
        JSONObject localJSONObject3 = localJSONObject2.optJSONObject("reflected_data");
        if (localJSONObject3 != null)
        {
          new StringBuilder("session = ").append(localJSONObject3.optString("session", "")).toString();
          ((com.alipay.sdk.protocol.c)localObject1).b.i = localJSONObject3;
        }
        while (true)
        {
          localf2.f = localJSONObject2.optString("end_code", "0");
          localf2.j = localJSONObject2.optString("user_id", "");
          Object localObject2 = localJSONObject2.optString("result");
          try
          {
            String str1 = URLDecoder.decode(localJSONObject2.optString("result"), "UTF-8");
            localObject2 = str1;
            label428: localf2.g = ((String)localObject2);
            localf2.h = localJSONObject2.optString("memo", "");
            return localObject1;
            if (!localJSONObject2.has("session"))
              continue;
            JSONObject localJSONObject4 = new JSONObject();
            try
            {
              localJSONObject4.put("session", localJSONObject2.optString("session"));
              String str2 = com.alipay.sdk.tid.b.a().a;
              if (!TextUtils.isEmpty(str2))
                localJSONObject4.put("tid", str2);
              localf2.i = localJSONObject4;
            }
            catch (JSONException localJSONException)
            {
            }
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            break label428;
          }
        }
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        g localg;
        continue;
        Object localObject1 = localg;
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.sdk.net.d
 * JD-Core Version:    0.6.0
 */