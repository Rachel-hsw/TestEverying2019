package c.a;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ej extends a
{
  private static final String a = "utdid";
  private static final String b = "android.permission.WRITE_EXTERNAL_STORAGE";
  private static final Pattern c = Pattern.compile("UTDID\">([^<]+)");
  private Context d;

  public ej(Context paramContext)
  {
    super("utdid");
    this.d = paramContext;
  }

  private String b(String paramString)
  {
    if (paramString == null);
    Matcher localMatcher;
    do
    {
      return null;
      localMatcher = c.matcher(paramString);
    }
    while (!localMatcher.find());
    return localMatcher.group(1);
  }

  // ERROR //
  private String g()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 57	c/a/ej:h	()Ljava/io/File;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull +10 -> 16
    //   9: aload_1
    //   10: invokevirtual 62	java/io/File:exists	()Z
    //   13: ifne +5 -> 18
    //   16: aconst_null
    //   17: areturn
    //   18: new 64	java/io/FileInputStream
    //   21: dup
    //   22: aload_1
    //   23: invokespecial 67	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   26: astore_2
    //   27: aload_0
    //   28: aload_2
    //   29: invokestatic 72	c/a/ch:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   32: invokespecial 74	c/a/ej:b	(Ljava/lang/String;)Ljava/lang/String;
    //   35: astore 5
    //   37: aload_2
    //   38: invokestatic 77	c/a/ch:c	(Ljava/io/InputStream;)V
    //   41: aload 5
    //   43: areturn
    //   44: astore 4
    //   46: aload 4
    //   48: invokevirtual 80	java/lang/Exception:printStackTrace	()V
    //   51: aconst_null
    //   52: areturn
    //   53: astore_3
    //   54: aload_2
    //   55: invokestatic 77	c/a/ch:c	(Ljava/io/InputStream;)V
    //   58: aload_3
    //   59: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   18	27	44	java/lang/Exception
    //   37	41	44	java/lang/Exception
    //   54	60	44	java/lang/Exception
    //   27	37	53	finally
  }

  private File h()
  {
    if (!bt.a(this.d, "android.permission.WRITE_EXTERNAL_STORAGE"));
    do
      return null;
    while (!Environment.getExternalStorageState().equals("mounted"));
    File localFile1 = Environment.getExternalStorageDirectory();
    try
    {
      File localFile2 = new File(localFile1.getCanonicalPath(), ".UTSystemConfig/Global/Alvin2.xml");
      return localFile2;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public String f()
  {
    return g();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     c.a.ej
 * JD-Core Version:    0.6.0
 */