package c.a;

import com.umeng.a.w.b;
import java.io.File;

class fe
  implements w.b
{
  fe(fd paramfd)
  {
  }

  public void a(File paramFile)
  {
  }

  // ERROR //
  public boolean b(File paramFile)
  {
    // Byte code:
    //   0: new 22	java/io/FileInputStream
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 24	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore_2
    //   9: aload_2
    //   10: invokestatic 29	c/a/ch:b	(Ljava/io/InputStream;)[B
    //   13: astore 5
    //   15: aload_2
    //   16: invokestatic 33	c/a/ch:c	(Ljava/io/InputStream;)V
    //   19: aload_0
    //   20: getfield 12	c/a/fe:a	Lc/a/fd;
    //   23: invokestatic 38	c/a/fd:a	(Lc/a/fd;)Lc/a/ey;
    //   26: aload 5
    //   28: invokevirtual 43	c/a/ey:a	([B)[B
    //   31: astore 6
    //   33: aload 6
    //   35: ifnonnull +53 -> 88
    //   38: iconst_1
    //   39: istore 8
    //   41: iload 8
    //   43: iconst_2
    //   44: if_icmpne +26 -> 70
    //   47: aload_0
    //   48: getfield 12	c/a/fe:a	Lc/a/fd;
    //   51: invokestatic 46	c/a/fd:b	(Lc/a/fd;)Lc/a/b;
    //   54: invokevirtual 52	c/a/b:i	()Z
    //   57: ifeq +13 -> 70
    //   60: aload_0
    //   61: getfield 12	c/a/fe:a	Lc/a/fd;
    //   64: invokestatic 46	c/a/fd:b	(Lc/a/fd;)Lc/a/b;
    //   67: invokevirtual 55	c/a/b:h	()V
    //   70: aload_0
    //   71: getfield 12	c/a/fe:a	Lc/a/fd;
    //   74: invokestatic 58	c/a/fd:c	(Lc/a/fd;)Z
    //   77: ifeq +29 -> 106
    //   80: iconst_1
    //   81: ireturn
    //   82: aload_2
    //   83: invokestatic 33	c/a/ch:c	(Ljava/io/InputStream;)V
    //   86: aload_3
    //   87: athrow
    //   88: aload_0
    //   89: getfield 12	c/a/fe:a	Lc/a/fd;
    //   92: aload 6
    //   94: invokestatic 61	c/a/fd:a	(Lc/a/fd;[B)I
    //   97: istore 7
    //   99: iload 7
    //   101: istore 8
    //   103: goto -62 -> 41
    //   106: iload 8
    //   108: iconst_1
    //   109: if_icmpne +9 -> 118
    //   112: iconst_0
    //   113: ireturn
    //   114: astore_3
    //   115: goto -33 -> 82
    //   118: iconst_1
    //   119: ireturn
    //   120: astore_3
    //   121: aconst_null
    //   122: astore_2
    //   123: goto -41 -> 82
    //   126: astore 4
    //   128: iconst_0
    //   129: ireturn
    //
    // Exception table:
    //   from	to	target	type
    //   9	15	114	finally
    //   0	9	120	finally
    //   15	33	126	java/lang/Exception
    //   47	70	126	java/lang/Exception
    //   70	80	126	java/lang/Exception
    //   82	88	126	java/lang/Exception
    //   88	99	126	java/lang/Exception
  }

  public void c(File paramFile)
  {
    fd.b(this.a).g();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     c.a.fe
 * JD-Core Version:    0.6.0
 */