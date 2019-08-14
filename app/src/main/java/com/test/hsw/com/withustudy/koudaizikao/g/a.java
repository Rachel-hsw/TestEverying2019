package com.withustudy.koudaizikao.g;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.preference.PreferenceManager;
import android.text.TextUtils;

public class a
{
  private static final String a = "cztchannel";
  private static final String b = "cztchannel_version";
  private static String c;

  public static String a(Context paramContext)
  {
    return a(paramContext, "");
  }

  public static String a(Context paramContext, String paramString)
  {
    if (!TextUtils.isEmpty(c))
      paramString = c;
    do
    {
      return paramString;
      c = b(paramContext);
      if (!TextUtils.isEmpty(c))
        return c;
      c = b(paramContext, "cztchannel");
    }
    while (TextUtils.isEmpty(c));
    c(paramContext, c);
    return c;
  }

  private static String b(Context paramContext)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
    int i = c(paramContext);
    if (i == -1)
      return "";
    int j = localSharedPreferences.getInt("cztchannel_version", -1);
    if (j == -1)
      return "";
    if (i != j)
      return "";
    return localSharedPreferences.getString("cztchannel", "");
  }

  // ERROR //
  private static String b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 64	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   4: getfield 69	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   7: astore_2
    //   8: new 71	java/lang/StringBuilder
    //   11: dup
    //   12: ldc 73
    //   14: invokespecial 76	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   17: aload_1
    //   18: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: astore_3
    //   25: new 86	java/util/zip/ZipFile
    //   28: dup
    //   29: aload_2
    //   30: invokespecial 87	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   33: astore 4
    //   35: aload 4
    //   37: invokevirtual 91	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   40: astore 11
    //   42: aload 11
    //   44: invokeinterface 97 1 0
    //   49: istore 12
    //   51: iload 12
    //   53: ifne +53 -> 106
    //   56: ldc 19
    //   58: astore 8
    //   60: aload 4
    //   62: ifnull +8 -> 70
    //   65: aload 4
    //   67: invokevirtual 100	java/util/zip/ZipFile:close	()V
    //   70: aload 8
    //   72: ldc 102
    //   74: invokevirtual 108	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   77: astore 9
    //   79: aload 9
    //   81: ifnull +145 -> 226
    //   84: aload 9
    //   86: arraylength
    //   87: iconst_2
    //   88: if_icmplt +138 -> 226
    //   91: aload 8
    //   93: iconst_1
    //   94: aload 9
    //   96: iconst_0
    //   97: aaload
    //   98: invokevirtual 112	java/lang/String:length	()I
    //   101: iadd
    //   102: invokevirtual 116	java/lang/String:substring	(I)Ljava/lang/String;
    //   105: areturn
    //   106: aload 11
    //   108: invokeinterface 120 1 0
    //   113: checkcast 122	java/util/zip/ZipEntry
    //   116: invokevirtual 125	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   119: astore 8
    //   121: aload 8
    //   123: aload_3
    //   124: invokevirtual 129	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   127: istore 13
    //   129: iload 13
    //   131: ifeq -89 -> 42
    //   134: goto -74 -> 60
    //   137: astore 5
    //   139: aconst_null
    //   140: astore 4
    //   142: aload 5
    //   144: invokevirtual 132	java/io/IOException:printStackTrace	()V
    //   147: aload 4
    //   149: ifnull +80 -> 229
    //   152: aload 4
    //   154: invokevirtual 100	java/util/zip/ZipFile:close	()V
    //   157: ldc 19
    //   159: astore 8
    //   161: goto -91 -> 70
    //   164: astore 10
    //   166: aload 10
    //   168: invokevirtual 132	java/io/IOException:printStackTrace	()V
    //   171: ldc 19
    //   173: astore 8
    //   175: goto -105 -> 70
    //   178: astore 6
    //   180: aconst_null
    //   181: astore 4
    //   183: aload 4
    //   185: ifnull +8 -> 193
    //   188: aload 4
    //   190: invokevirtual 100	java/util/zip/ZipFile:close	()V
    //   193: aload 6
    //   195: athrow
    //   196: astore 7
    //   198: aload 7
    //   200: invokevirtual 132	java/io/IOException:printStackTrace	()V
    //   203: goto -10 -> 193
    //   206: astore 14
    //   208: aload 14
    //   210: invokevirtual 132	java/io/IOException:printStackTrace	()V
    //   213: goto -143 -> 70
    //   216: astore 6
    //   218: goto -35 -> 183
    //   221: astore 5
    //   223: goto -81 -> 142
    //   226: ldc 19
    //   228: areturn
    //   229: ldc 19
    //   231: astore 8
    //   233: goto -163 -> 70
    //
    // Exception table:
    //   from	to	target	type
    //   25	35	137	java/io/IOException
    //   152	157	164	java/io/IOException
    //   25	35	178	finally
    //   188	193	196	java/io/IOException
    //   65	70	206	java/io/IOException
    //   35	42	216	finally
    //   42	51	216	finally
    //   106	129	216	finally
    //   142	147	216	finally
    //   35	42	221	java/io/IOException
    //   42	51	221	java/io/IOException
    //   106	129	221	java/io/IOException
  }

  private static int c(Context paramContext)
  {
    try
    {
      int i = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      return i;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
    }
    return -1;
  }

  private static void c(Context paramContext, String paramString)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    localEditor.putString("cztchannel", paramString);
    localEditor.putInt("cztchannel_version", c(paramContext));
    localEditor.commit();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.g.a
 * JD-Core Version:    0.6.0
 */