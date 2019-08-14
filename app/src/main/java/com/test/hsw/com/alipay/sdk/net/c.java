package com.alipay.sdk.net;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.exception.NetErrorException;
import org.apache.http.HttpResponse;

public final class c
{
  static a a;

  // ERROR //
  public static String a(HttpResponse paramHttpResponse)
    throws NetErrorException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokeinterface 21 1 0
    //   6: astore_1
    //   7: aload_1
    //   8: invokeinterface 27 1 0
    //   13: istore_2
    //   14: aload_0
    //   15: invokeinterface 31 1 0
    //   20: astore_3
    //   21: aconst_null
    //   22: astore 4
    //   24: aload_3
    //   25: invokeinterface 37 1 0
    //   30: astore 11
    //   32: aload 11
    //   34: astore 4
    //   36: aload_1
    //   37: invokeinterface 27 1 0
    //   42: sipush 200
    //   45: if_icmpne +8 -> 53
    //   48: aload 4
    //   50: ifnonnull +67 -> 117
    //   53: new 13	com/alipay/sdk/exception/NetErrorException
    //   56: dup
    //   57: new 39	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   64: iload_2
    //   65: invokevirtual 44	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   68: ldc 46
    //   70: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload_1
    //   74: invokeinterface 53 1 0
    //   79: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokespecial 59	com/alipay/sdk/exception/NetErrorException:<init>	(Ljava/lang/String;)V
    //   88: athrow
    //   89: astore 9
    //   91: new 13	com/alipay/sdk/exception/NetErrorException
    //   94: dup
    //   95: invokespecial 60	com/alipay/sdk/exception/NetErrorException:<init>	()V
    //   98: athrow
    //   99: astore 10
    //   101: aload 4
    //   103: astore 7
    //   105: aload 10
    //   107: astore 6
    //   109: aload 7
    //   111: invokevirtual 65	java/io/InputStream:close	()V
    //   114: aload 6
    //   116: athrow
    //   117: aload_3
    //   118: invokeinterface 69 1 0
    //   123: astore 13
    //   125: aload 13
    //   127: ifnull +33 -> 160
    //   130: aload 13
    //   132: invokeinterface 74 1 0
    //   137: ldc 76
    //   139: invokevirtual 82	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   142: ifeq +18 -> 160
    //   145: new 84	java/util/zip/GZIPInputStream
    //   148: dup
    //   149: aload 4
    //   151: invokespecial 87	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   154: astore 14
    //   156: aload 14
    //   158: astore 4
    //   160: aload_3
    //   161: invokeinterface 91 1 0
    //   166: l2i
    //   167: istore 15
    //   169: iload 15
    //   171: ifge +132 -> 303
    //   174: sipush 4096
    //   177: istore 16
    //   179: aload_3
    //   180: invokestatic 97	org/apache/http/util/EntityUtils:getContentCharSet	(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
    //   183: astore 17
    //   185: aload 17
    //   187: ifnonnull +7 -> 194
    //   190: ldc 99
    //   192: astore 17
    //   194: new 101	java/io/InputStreamReader
    //   197: dup
    //   198: aload 4
    //   200: aload 17
    //   202: invokespecial 104	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   205: astore 18
    //   207: new 106	org/apache/http/util/CharArrayBuffer
    //   210: dup
    //   211: iload 16
    //   213: invokespecial 109	org/apache/http/util/CharArrayBuffer:<init>	(I)V
    //   216: astore 19
    //   218: sipush 1024
    //   221: newarray char
    //   223: astore 20
    //   225: aload 18
    //   227: aload 20
    //   229: invokevirtual 115	java/io/Reader:read	([C)I
    //   232: istore 21
    //   234: iload 21
    //   236: iconst_m1
    //   237: if_icmpeq +16 -> 253
    //   240: aload 19
    //   242: aload 20
    //   244: iconst_0
    //   245: iload 21
    //   247: invokevirtual 118	org/apache/http/util/CharArrayBuffer:append	([CII)V
    //   250: goto -25 -> 225
    //   253: aload 19
    //   255: invokevirtual 119	org/apache/http/util/CharArrayBuffer:toString	()Ljava/lang/String;
    //   258: astore 22
    //   260: aload 4
    //   262: invokevirtual 65	java/io/InputStream:close	()V
    //   265: aload 22
    //   267: areturn
    //   268: astore 23
    //   270: aload 22
    //   272: areturn
    //   273: astore 8
    //   275: goto -161 -> 114
    //   278: astore 5
    //   280: aload 5
    //   282: astore 6
    //   284: aconst_null
    //   285: astore 7
    //   287: goto -178 -> 109
    //   290: astore 12
    //   292: aload 4
    //   294: astore 7
    //   296: aload 12
    //   298: astore 6
    //   300: goto -191 -> 109
    //   303: iload 15
    //   305: istore 16
    //   307: goto -128 -> 179
    //
    // Exception table:
    //   from	to	target	type
    //   24	32	89	java/lang/Exception
    //   36	48	89	java/lang/Exception
    //   53	89	89	java/lang/Exception
    //   117	125	89	java/lang/Exception
    //   130	156	89	java/lang/Exception
    //   160	169	89	java/lang/Exception
    //   179	185	89	java/lang/Exception
    //   194	225	89	java/lang/Exception
    //   225	234	89	java/lang/Exception
    //   240	250	89	java/lang/Exception
    //   253	260	89	java/lang/Exception
    //   91	99	99	finally
    //   160	169	99	finally
    //   179	185	99	finally
    //   194	225	99	finally
    //   225	234	99	finally
    //   240	250	99	finally
    //   253	260	99	finally
    //   260	265	268	java/lang/Exception
    //   109	114	273	java/lang/Exception
    //   24	32	278	finally
    //   36	48	290	finally
    //   53	89	290	finally
    //   117	125	290	finally
    //   130	156	290	finally
  }

  private static HttpResponse a(Context paramContext, String paramString1, String paramString2, com.alipay.sdk.data.c paramc)
    throws NetErrorException
  {
    if (a == null)
      a = new a(paramContext, paramString1);
    while (paramc != null)
    {
      return a.a(paramString2, paramc);
      if (TextUtils.equals(paramString1, a.a))
        continue;
      a.a = paramString1;
    }
    return a.a(paramString2, null);
  }

  private static void a()
  {
    a = null;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.sdk.net.c
 * JD-Core Version:    0.6.0
 */