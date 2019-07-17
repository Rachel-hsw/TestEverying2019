package com.umeng.socialize.b.a;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.socialize.b.b.g;
import com.umeng.socialize.b.b.g.a;
import com.umeng.socialize.bean.ay;
import com.umeng.socialize.media.BaseMediaObject;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.utils.i;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public abstract class b extends g
{
  protected static String a = b.class.getName();
  protected Class<? extends f> b;
  protected int c;
  protected Context d;
  protected ay e;
  private b f;
  private Map<String, g.a> j = new HashMap();

  public b(Context paramContext, String paramString, Class<? extends f> paramClass, ay paramay, int paramInt, b paramb)
  {
    super("");
    this.b = paramClass;
    this.c = paramInt;
    this.d = paramContext;
    this.f = paramb;
    this.e = paramay;
    a = getClass().getName();
  }

  protected abstract String a();

  protected Map<String, Object> a(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    try
    {
      String str = com.umeng.socialize.b.b.a.a(paramString2, "UTF-8");
      if (this.f == b.b)
        localHashMap.put("ud_post", str);
      return localHashMap;
    }
    catch (Exception localException)
    {
      i.c(paramString1, paramString1 + "数据加密失败");
      localException.printStackTrace();
    }
    return localHashMap;
  }

  protected abstract Map<String, Object> a(Map<String, Object> paramMap);

  protected JSONObject a(JSONObject paramJSONObject, Map<String, Object> paramMap)
  {
    if ((paramMap == null) || (paramJSONObject == null) || (paramMap.size() == 0));
    while (true)
    {
      return paramJSONObject;
      Iterator localIterator = paramMap.entrySet().iterator();
      try
      {
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          paramJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return paramJSONObject;
  }

  public void a(UMediaObject paramUMediaObject, Map<String, Object> paramMap)
  {
    if (paramUMediaObject != null)
    {
      if (!paramUMediaObject.b())
        break label111;
      paramMap.putAll(paramUMediaObject.c_());
    }
    try
    {
      while (true)
      {
        if ((paramUMediaObject instanceof BaseMediaObject))
        {
          BaseMediaObject localBaseMediaObject = (BaseMediaObject)paramUMediaObject;
          String str1 = localBaseMediaObject.c();
          String str2 = localBaseMediaObject.d();
          if ((!TextUtils.isEmpty(str1)) || (!TextUtils.isEmpty(str2)))
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put(com.umeng.socialize.b.b.e.A, str1);
            localJSONObject.put(com.umeng.socialize.b.b.e.B, str2);
            paramMap.put("ext", localJSONObject);
          }
        }
        return;
        label111: byte[] arrayOfByte = paramUMediaObject.d_();
        if (arrayOfByte == null)
          continue;
        a(arrayOfByte, a.a, null);
      }
    }
    catch (Exception localException)
    {
      i.b(a, "can`t add qzone title & thumb.", localException);
    }
  }

  public boolean a(byte[] paramArrayOfByte, a parama, String paramString)
  {
    if (a.a == parama)
    {
      String str = com.umeng.socialize.common.a.a(paramArrayOfByte);
      if (TextUtils.isEmpty(str))
        str = "png";
      if (TextUtils.isEmpty(paramString))
        paramString = System.currentTimeMillis() + "";
      g.a locala = new g.a(paramString + "." + str, paramArrayOfByte);
      this.j.put(com.umeng.socialize.b.b.e.v, locala);
      return true;
    }
    return false;
  }

  // ERROR //
  protected byte[] a(String paramString)
  {
    // Byte code:
    //   0: new 232	java/io/FileInputStream
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 233	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   8: astore_2
    //   9: new 235	java/io/ByteArrayOutputStream
    //   12: dup
    //   13: aload_2
    //   14: invokevirtual 238	java/io/FileInputStream:available	()I
    //   17: invokespecial 241	java/io/ByteArrayOutputStream:<init>	(I)V
    //   20: astore_3
    //   21: sipush 1024
    //   24: newarray byte
    //   26: astore 9
    //   28: aload_2
    //   29: aload 9
    //   31: invokevirtual 245	java/io/FileInputStream:read	([B)I
    //   34: istore 10
    //   36: iload 10
    //   38: iconst_m1
    //   39: if_icmpeq +36 -> 75
    //   42: aload_3
    //   43: aload 9
    //   45: iconst_0
    //   46: iload 10
    //   48: invokevirtual 249	java/io/ByteArrayOutputStream:write	([BII)V
    //   51: goto -23 -> 28
    //   54: astore 6
    //   56: aload 6
    //   58: invokevirtual 107	java/lang/Exception:printStackTrace	()V
    //   61: aconst_null
    //   62: astore 7
    //   64: aload_2
    //   65: ifnull +7 -> 72
    //   68: aload_2
    //   69: invokevirtual 252	java/io/FileInputStream:close	()V
    //   72: aload 7
    //   74: areturn
    //   75: aload_3
    //   76: invokevirtual 255	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   79: astore 11
    //   81: aload 11
    //   83: astore 7
    //   85: aload_2
    //   86: ifnull -14 -> 72
    //   89: aload_2
    //   90: invokevirtual 252	java/io/FileInputStream:close	()V
    //   93: aload 7
    //   95: areturn
    //   96: astore 12
    //   98: aload 12
    //   100: invokevirtual 256	java/io/IOException:printStackTrace	()V
    //   103: aload 7
    //   105: areturn
    //   106: astore 8
    //   108: aload 8
    //   110: invokevirtual 256	java/io/IOException:printStackTrace	()V
    //   113: aconst_null
    //   114: areturn
    //   115: astore 13
    //   117: aconst_null
    //   118: astore_2
    //   119: aload 13
    //   121: astore 4
    //   123: aload_2
    //   124: ifnull +7 -> 131
    //   127: aload_2
    //   128: invokevirtual 252	java/io/FileInputStream:close	()V
    //   131: aload 4
    //   133: athrow
    //   134: astore 5
    //   136: aload 5
    //   138: invokevirtual 256	java/io/IOException:printStackTrace	()V
    //   141: goto -10 -> 131
    //   144: astore 4
    //   146: goto -23 -> 123
    //   149: astore 6
    //   151: aconst_null
    //   152: astore_2
    //   153: goto -97 -> 56
    //
    // Exception table:
    //   from	to	target	type
    //   9	28	54	java/lang/Exception
    //   28	36	54	java/lang/Exception
    //   42	51	54	java/lang/Exception
    //   75	81	54	java/lang/Exception
    //   89	93	96	java/io/IOException
    //   68	72	106	java/io/IOException
    //   0	9	115	finally
    //   127	131	134	java/io/IOException
    //   9	28	144	finally
    //   28	36	144	finally
    //   42	51	144	finally
    //   56	61	144	finally
    //   75	81	144	finally
    //   0	9	149	java/lang/Exception
  }

  public Map<String, Object> b()
  {
    return a(com.umeng.socialize.b.b.d.a(this.d, this.e, this.c));
  }

  public void b(String paramString)
  {
    try
    {
      String str = new URL(new URL(paramString), a()).toString();
      super.b(str);
      return;
    }
    catch (Exception localException)
    {
    }
    throw new com.umeng.socialize.a.a("Can not generate correct url in SocializeRequest [" + i() + "]", localException);
  }

  public Map<String, g.a> c()
  {
    return this.j;
  }

  public JSONObject d()
  {
    return null;
  }

  public String e()
  {
    Map localMap = a(com.umeng.socialize.b.b.d.a(this.d, this.e, this.c));
    return com.umeng.socialize.b.b.d.a(i(), localMap);
  }

  protected String f()
  {
    switch (c.a[this.f.ordinal()])
    {
    default:
      return h;
    case 1:
    }
    return g;
  }

  protected static enum a
  {
    static
    {
      a[] arrayOfa = new a[2];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      c = arrayOfa;
    }
  }

  protected static enum b
  {
    static
    {
      b[] arrayOfb = new b[2];
      arrayOfb[0] = a;
      arrayOfb[1] = b;
      c = arrayOfb;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.b.a.b
 * JD-Core Version:    0.6.0
 */