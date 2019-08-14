package com.umeng.message.b;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.squareup.wire.Wire;
import com.umeng.b.a.a;
import com.umeng.b.a.b;
import com.umeng.message.PushAgent;
import com.umeng.message.protobuffer.PushResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

public class fb
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  private static final String i = fb.class.getName();
  private final int d = 1;
  private String e;
  private String f = "10.0.0.172";
  private int g = 80;
  private Context h;

  public fb(Context paramContext)
  {
    this.h = paramContext;
    this.e = a(paramContext);
  }

  private PushResponse a(byte[] paramArrayOfByte)
  {
    try
    {
      localPushResponse = (PushResponse)new Wire(new Class[0]).parseFrom(paramArrayOfByte, PushResponse.class);
      if (localPushResponse != null)
        a.a(i, "NetWork Response code:" + localPushResponse.code + "," + "msg:" + localPushResponse.description + "," + "info:" + localPushResponse.info);
      return localPushResponse;
    }
    catch (IOException localIOException)
    {
      while (true)
      {
        localIOException.printStackTrace();
        PushResponse localPushResponse = null;
      }
    }
  }

  private String a(Context paramContext)
  {
    StringBuffer localStringBuffer1 = new StringBuffer();
    localStringBuffer1.append("2.6.0");
    localStringBuffer1.append("/");
    localStringBuffer1.append("2.6.0");
    localStringBuffer1.append(" ");
    try
    {
      StringBuffer localStringBuffer2 = new StringBuffer();
      localStringBuffer2.append(b.x(paramContext));
      localStringBuffer2.append("/");
      localStringBuffer2.append(b.e(paramContext));
      localStringBuffer2.append(" ");
      localStringBuffer2.append(Build.MODEL);
      localStringBuffer2.append("/");
      localStringBuffer2.append(Build.VERSION.RELEASE);
      localStringBuffer2.append(" ");
      localStringBuffer2.append(dl.a(PushAgent.getInstance(paramContext).getMessageAppkey()));
      localStringBuffer1.append(URLEncoder.encode(localStringBuffer2.toString(), "UTF-8"));
      return localStringBuffer1.toString();
    }
    catch (Exception localException)
    {
      while (true)
        localException.printStackTrace();
    }
  }

  private boolean a()
  {
    if (this.h.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", this.h.getPackageName()) != 0)
      return false;
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)this.h.getSystemService("connectivity")).getActiveNetworkInfo();
      if ((localNetworkInfo != null) && (localNetworkInfo.getType() != 1))
      {
        String str = localNetworkInfo.getExtraInfo();
        if (str != null)
          if ((!str.equals("cmwap")) && (!str.equals("3gwap")))
          {
            boolean bool = str.equals("uniwap");
            if (!bool);
          }
          else
          {
            return true;
          }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }

  private byte[] b(byte[] paramArrayOfByte, String paramString)
  {
    HttpPost localHttpPost = new HttpPost(paramString);
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 10000);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, 30000);
    DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient(localBasicHttpParams);
    localHttpPost.addHeader("Msg-Type", "envelope");
    try
    {
      localHttpPost.setEntity(new InputStreamEntity(new ByteArrayInputStream(paramArrayOfByte), paramArrayOfByte.length));
      HttpResponse localHttpResponse = localDefaultHttpClient.execute(localHttpPost);
      int j = localHttpResponse.getStatusLine().getStatusCode();
      a.a(i, "status code : " + j);
      a.a(i, "Sent message to " + paramString);
      HttpEntity localHttpEntity = localHttpResponse.getEntity();
      if (localHttpEntity != null)
      {
        InputStream localInputStream = localHttpEntity.getContent();
        try
        {
          byte[] arrayOfByte = dl.a(localInputStream);
          return arrayOfByte;
        }
        finally
        {
          dl.b(localInputStream);
        }
      }
    }
    catch (ClientProtocolException localClientProtocolException)
    {
      a.b(i, "ClientProtocolException,Failed to send message.", localClientProtocolException);
      return null;
      return null;
    }
    catch (IOException localIOException)
    {
      a.b(i, "IOException,Failed to send message.", localIOException);
    }
    return null;
  }

  public PushResponse a(byte[] paramArrayOfByte, String paramString)
  {
    byte[] arrayOfByte = b(paramArrayOfByte, paramString);
    if (arrayOfByte == null)
      return null;
    return a(arrayOfByte);
  }

  // ERROR //
  public byte[] a(org.json.JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: getfield 43	com/umeng/message/b/fb:h	Landroid/content/Context;
    //   6: invokestatic 314	com/umeng/message/MsgLogStore:getInstance	(Landroid/content/Context;)Lcom/umeng/message/MsgLogStore;
    //   9: invokevirtual 317	com/umeng/message/MsgLogStore:getMsgConfigInfo_SerialNo	()I
    //   12: istore 19
    //   14: iload 19
    //   16: istore_2
    //   17: aload_0
    //   18: getfield 43	com/umeng/message/b/fb:h	Landroid/content/Context;
    //   21: invokestatic 141	com/umeng/message/PushAgent:getInstance	(Landroid/content/Context;)Lcom/umeng/message/PushAgent;
    //   24: invokevirtual 144	com/umeng/message/PushAgent:getMessageAppkey	()Ljava/lang/String;
    //   27: astore 4
    //   29: invokestatic 323	java/lang/System:currentTimeMillis	()J
    //   32: ldc2_w 324
    //   35: ldiv
    //   36: l2i
    //   37: istore 5
    //   39: aload_1
    //   40: invokevirtual 328	org/json/JSONObject:toString	()Ljava/lang/String;
    //   43: astore 15
    //   45: iconst_3
    //   46: anewarray 202	java/lang/String
    //   49: astore 16
    //   51: aload 16
    //   53: iconst_0
    //   54: aload 15
    //   56: aastore
    //   57: aload 16
    //   59: iconst_1
    //   60: ldc_w 330
    //   63: aastore
    //   64: aload 16
    //   66: iconst_2
    //   67: aload 4
    //   69: iconst_0
    //   70: bipush 16
    //   72: invokevirtual 334	java/lang/String:substring	(II)Ljava/lang/String;
    //   75: aastore
    //   76: aload 16
    //   78: invokestatic 339	com/umeng/message/b/dg:a	([Ljava/lang/String;)Ljava/lang/String;
    //   81: astore 17
    //   83: aload 17
    //   85: astore 8
    //   87: aload 8
    //   89: invokevirtual 343	java/lang/String:getBytes	()[B
    //   92: iconst_0
    //   93: aload 8
    //   95: invokevirtual 343	java/lang/String:getBytes	()[B
    //   98: arraylength
    //   99: invokestatic 348	com/umeng/message/b/j:a	([BII)Lcom/umeng/message/b/j;
    //   102: astore 18
    //   104: aload 18
    //   106: astore 9
    //   108: aload 8
    //   110: invokestatic 149	com/umeng/message/b/dl:a	(Ljava/lang/String;)Ljava/lang/String;
    //   113: astore 10
    //   115: new 64	java/lang/StringBuilder
    //   118: dup
    //   119: aload 4
    //   121: invokestatic 352	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   124: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   127: iload 5
    //   129: invokevirtual 276	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   132: aload 8
    //   134: invokestatic 149	com/umeng/message/b/dl:a	(Ljava/lang/String;)Ljava/lang/String;
    //   137: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokestatic 149	com/umeng/message/b/dl:a	(Ljava/lang/String;)Ljava/lang/String;
    //   146: astore 11
    //   148: getstatic 29	com/umeng/message/b/fb:i	Ljava/lang/String;
    //   151: new 64	java/lang/StringBuilder
    //   154: dup
    //   155: ldc_w 354
    //   158: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   161: aload_1
    //   162: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   165: ldc_w 356
    //   168: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: iload 5
    //   173: invokevirtual 276	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   176: ldc 79
    //   178: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: ldc_w 358
    //   184: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: aload 10
    //   189: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: ldc 79
    //   194: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: ldc_w 360
    //   200: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: aload 11
    //   205: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: ldc 79
    //   210: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: ldc_w 362
    //   216: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: iload_2
    //   220: invokevirtual 276	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   223: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 364	com/umeng/b/a/a:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   229: aload_0
    //   230: getfield 43	com/umeng/message/b/fb:h	Landroid/content/Context;
    //   233: invokestatic 314	com/umeng/message/MsgLogStore:getInstance	(Landroid/content/Context;)Lcom/umeng/message/MsgLogStore;
    //   236: iload_2
    //   237: iconst_1
    //   238: iadd
    //   239: invokevirtual 368	com/umeng/message/MsgLogStore:setMsgConfigInfo_SerialNo	(I)V
    //   242: new 370	com/umeng/message/protobuffer/PushRequest$Builder
    //   245: dup
    //   246: invokespecial 371	com/umeng/message/protobuffer/PushRequest$Builder:<init>	()V
    //   249: ldc_w 373
    //   252: invokevirtual 377	com/umeng/message/protobuffer/PushRequest$Builder:version	(Ljava/lang/String;)Lcom/umeng/message/protobuffer/PushRequest$Builder;
    //   255: iload_2
    //   256: invokestatic 382	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   259: invokevirtual 386	com/umeng/message/protobuffer/PushRequest$Builder:serialNo	(Ljava/lang/Integer;)Lcom/umeng/message/protobuffer/PushRequest$Builder;
    //   262: aload 4
    //   264: invokevirtual 389	com/umeng/message/protobuffer/PushRequest$Builder:signature	(Ljava/lang/String;)Lcom/umeng/message/protobuffer/PushRequest$Builder;
    //   267: iload 5
    //   269: invokestatic 382	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   272: invokevirtual 392	com/umeng/message/protobuffer/PushRequest$Builder:timestamp	(Ljava/lang/Integer;)Lcom/umeng/message/protobuffer/PushRequest$Builder;
    //   275: getstatic 398	com/umeng/message/protobuffer/PushRequest$entityEncodingFormat:JSON_AES	Lcom/umeng/message/protobuffer/PushRequest$entityEncodingFormat;
    //   278: invokevirtual 402	com/umeng/message/protobuffer/PushRequest$Builder:encryption	(Lcom/umeng/message/protobuffer/PushRequest$entityEncodingFormat;)Lcom/umeng/message/protobuffer/PushRequest$Builder;
    //   281: aload 9
    //   283: invokevirtual 406	com/umeng/message/protobuffer/PushRequest$Builder:entity	(Lcom/umeng/message/b/j;)Lcom/umeng/message/protobuffer/PushRequest$Builder;
    //   286: aload 10
    //   288: invokevirtual 409	com/umeng/message/protobuffer/PushRequest$Builder:checksum	(Ljava/lang/String;)Lcom/umeng/message/protobuffer/PushRequest$Builder;
    //   291: aload 11
    //   293: invokevirtual 412	com/umeng/message/protobuffer/PushRequest$Builder:salt	(Ljava/lang/String;)Lcom/umeng/message/protobuffer/PushRequest$Builder;
    //   296: invokevirtual 416	com/umeng/message/protobuffer/PushRequest$Builder:build	()Lcom/umeng/message/protobuffer/PushRequest;
    //   299: invokevirtual 421	com/umeng/message/protobuffer/PushRequest:toByteArray	()[B
    //   302: areturn
    //   303: astore_3
    //   304: aload_3
    //   305: invokevirtual 159	java/lang/Exception:printStackTrace	()V
    //   308: getstatic 29	com/umeng/message/b/fb:i	Ljava/lang/String;
    //   311: aload_3
    //   312: invokevirtual 422	java/lang/Exception:toString	()Ljava/lang/String;
    //   315: invokestatic 364	com/umeng/b/a/a:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   318: goto -301 -> 17
    //   321: astore 13
    //   323: aload 13
    //   325: astore 14
    //   327: aconst_null
    //   328: astore 8
    //   330: aload 14
    //   332: invokevirtual 423	org/json/JSONException:printStackTrace	()V
    //   335: aconst_null
    //   336: astore 9
    //   338: goto -230 -> 108
    //   341: astore 6
    //   343: aload 6
    //   345: astore 7
    //   347: aconst_null
    //   348: astore 8
    //   350: aload 7
    //   352: invokevirtual 159	java/lang/Exception:printStackTrace	()V
    //   355: aconst_null
    //   356: astore 9
    //   358: goto -250 -> 108
    //   361: astore 12
    //   363: aload 12
    //   365: invokevirtual 159	java/lang/Exception:printStackTrace	()V
    //   368: getstatic 29	com/umeng/message/b/fb:i	Ljava/lang/String;
    //   371: aload 12
    //   373: invokevirtual 422	java/lang/Exception:toString	()Ljava/lang/String;
    //   376: invokestatic 364	com/umeng/b/a/a:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   379: goto -137 -> 242
    //   382: astore 7
    //   384: goto -34 -> 350
    //   387: astore 14
    //   389: goto -59 -> 330
    //
    // Exception table:
    //   from	to	target	type
    //   2	14	303	java/lang/Exception
    //   39	83	321	org/json/JSONException
    //   39	83	341	java/lang/Exception
    //   229	242	361	java/lang/Exception
    //   87	104	382	java/lang/Exception
    //   87	104	387	org/json/JSONException
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.fb
 * JD-Core Version:    0.6.0
 */