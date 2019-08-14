package c.a;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.a.k;
import com.umeng.a.w;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class ef
{
  private static final String a = ".imprint";
  private static final byte[] b = "pbl0".getBytes();
  private static ef e;
  private fb c;
  private ao d = null;
  private Context f;

  ef(Context paramContext)
  {
    this.f = paramContext;
  }

  private int a(String paramString)
  {
    ao localao = this.d;
    if ((localao == null) || (!localao.f()))
      return -1;
    aq localaq = (aq)localao.d().get(paramString);
    if ((localaq == null) || (TextUtils.isEmpty(localaq.c())))
      return -1;
    try
    {
      int i = Integer.parseInt(localaq.c().trim());
      return i;
    }
    catch (Exception localException)
    {
    }
    return -1;
  }

  private ao a(ao paramao1, ao paramao2)
  {
    if (paramao2 == null)
      return paramao1;
    Map localMap = paramao1.d();
    Iterator localIterator = paramao2.d().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((aq)localEntry.getValue()).e())
      {
        localMap.put(localEntry.getKey(), localEntry.getValue());
        continue;
      }
      localMap.remove(localEntry.getKey());
    }
    paramao1.a(paramao2.h());
    paramao1.a(a(paramao1));
    return paramao1;
  }

  public static ef a(Context paramContext)
  {
    monitorenter;
    try
    {
      if (e == null)
      {
        e = new ef(paramContext);
        e.b();
      }
      ef localef = e;
      return localef;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private boolean c(ao paramao)
  {
    if (!paramao.k().equals(a(paramao)))
      return false;
    Iterator localIterator = paramao.d().values().iterator();
    while (localIterator.hasNext())
    {
      aq localaq = (aq)localIterator.next();
      byte[] arrayOfByte1 = k.a(localaq.j());
      byte[] arrayOfByte2 = a(localaq);
      for (int i = 0; i < 4; i++)
        if (arrayOfByte1[i] != arrayOfByte2[i])
          return false;
    }
    return true;
  }

  private void e()
  {
    if (this.c == null);
    int k;
    do
    {
      return;
      int i = a("defcon");
      if (i != -1)
      {
        this.c.a(i);
        w.a(this.f).a(i);
      }
      int j = a("latent");
      if (j != -1)
      {
        int m = j * 1000;
        this.c.b(m);
        w.a(this.f).b(m);
      }
      k = a("codex");
    }
    while ((k != 0) && (k != 1) && (k != -1));
    this.c.c(k);
    w.a(this.f).c(k);
  }

  public ao a()
  {
    monitorenter;
    try
    {
      ao localao = this.d;
      monitorexit;
      return localao;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public String a(ao paramao)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = new TreeMap(paramao.d()).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localStringBuilder.append((String)localEntry.getKey());
      localStringBuilder.append(((aq)localEntry.getValue()).c());
      localStringBuilder.append(((aq)localEntry.getValue()).f());
      localStringBuilder.append(((aq)localEntry.getValue()).j());
    }
    localStringBuilder.append(paramao.b);
    return ch.a(localStringBuilder.toString()).toLowerCase(Locale.US);
  }

  public void a(fb paramfb)
  {
    this.c = paramfb;
  }

  public byte[] a(aq paramaq)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    localByteBuffer.order(null);
    localByteBuffer.putLong(paramaq.f());
    byte[] arrayOfByte1 = localByteBuffer.array();
    byte[] arrayOfByte2 = b;
    byte[] arrayOfByte3 = new byte[4];
    for (int i = 0; i < 4; i++)
      arrayOfByte3[i] = (byte)(arrayOfByte1[i] ^ arrayOfByte2[i]);
    return arrayOfByte3;
  }

  // ERROR //
  public void b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 247	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: getfield 38	c/a/ef:f	Landroid/content/Context;
    //   10: invokevirtual 253	android/content/Context:getFilesDir	()Ljava/io/File;
    //   13: ldc 8
    //   15: invokespecial 256	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   18: invokevirtual 259	java/io/File:exists	()Z
    //   21: ifne +4 -> 25
    //   24: return
    //   25: aload_0
    //   26: getfield 38	c/a/ef:f	Landroid/content/Context;
    //   29: ldc 8
    //   31: invokevirtual 263	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   34: astore 8
    //   36: aload 8
    //   38: astore 4
    //   40: aload 4
    //   42: invokestatic 266	c/a/ch:b	(Ljava/io/InputStream;)[B
    //   45: astore 9
    //   47: aload 9
    //   49: astore 5
    //   51: aload 4
    //   53: invokestatic 269	c/a/ch:c	(Ljava/io/InputStream;)V
    //   56: aload 5
    //   58: ifnull -34 -> 24
    //   61: new 43	c/a/ao
    //   64: dup
    //   65: invokespecial 270	c/a/ao:<init>	()V
    //   68: astore 6
    //   70: new 272	c/a/cp
    //   73: dup
    //   74: invokespecial 273	c/a/cp:<init>	()V
    //   77: aload 6
    //   79: aload 5
    //   81: invokevirtual 276	c/a/cp:a	(Lc/a/cl;[B)V
    //   84: aload_0
    //   85: aload 6
    //   87: putfield 36	c/a/ef:d	Lc/a/ao;
    //   90: return
    //   91: astore 7
    //   93: aload 7
    //   95: invokevirtual 279	java/lang/Exception:printStackTrace	()V
    //   98: return
    //   99: astore_3
    //   100: aconst_null
    //   101: astore 4
    //   103: aload_3
    //   104: invokevirtual 279	java/lang/Exception:printStackTrace	()V
    //   107: aload 4
    //   109: invokestatic 269	c/a/ch:c	(Ljava/io/InputStream;)V
    //   112: aconst_null
    //   113: astore 5
    //   115: goto -59 -> 56
    //   118: astore_2
    //   119: aload_1
    //   120: invokestatic 269	c/a/ch:c	(Ljava/io/InputStream;)V
    //   123: aload_2
    //   124: athrow
    //   125: astore_2
    //   126: aload 4
    //   128: astore_1
    //   129: goto -10 -> 119
    //   132: astore_3
    //   133: goto -30 -> 103
    //
    // Exception table:
    //   from	to	target	type
    //   61	90	91	java/lang/Exception
    //   25	36	99	java/lang/Exception
    //   25	36	118	finally
    //   40	47	125	finally
    //   103	107	125	finally
    //   40	47	132	java/lang/Exception
  }

  public void b(ao paramao)
  {
    if (paramao == null);
    while (true)
    {
      return;
      if (!c(paramao))
        continue;
      monitorenter;
      try
      {
        ao localao = this.d;
        if (localao == null);
        while (true)
        {
          this.d = paramao;
          monitorexit;
          if (this.d == null)
            break;
          e();
          return;
          paramao = a(localao, paramao);
        }
      }
      finally
      {
        monitorexit;
      }
    }
    throw localObject;
  }

  public void c()
  {
    if (this.d == null)
      return;
    try
    {
      byte[] arrayOfByte = new cv().a(this.d);
      ch.a(new File(this.f.getFilesDir(), ".imprint"), arrayOfByte);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public boolean d()
  {
    return new File(this.f.getFilesDir(), ".imprint").delete();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     c.a.ef
 * JD-Core Version:    0.6.0
 */