package com.umeng.socialize.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.view.WindowManager.BadTokenException;
import android.widget.Toast;
import com.umeng.socialize.bean.UMShareMsg;
import com.umeng.socialize.bean.ar;
import com.umeng.socialize.bean.aw;
import com.umeng.socialize.bean.ax;
import com.umeng.socialize.bean.ay;
import com.umeng.socialize.bean.l;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.common.b;
import com.umeng.socialize.common.b.a;
import com.umeng.socialize.common.r;
import com.umeng.socialize.controller.UMSocialService;
import com.umeng.socialize.media.BaseMediaObject;
import com.umeng.socialize.media.BaseShareContent;
import com.umeng.socialize.media.UMediaObject;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class m
{
  protected static final String a = m.class.getName();
  public static Set<Uri> b = new HashSet();
  private static String c;
  private static String d;
  private static String e;
  private static Pattern f = null;
  private static int g = 0;

  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(0.5F + paramFloat * paramContext.getResources().getDisplayMetrics().density);
  }

  public static Uri a(Context paramContext, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!new File(paramString).exists()));
    while (true)
    {
      return null;
      try
      {
        String str = MediaStore.Images.Media.insertImage(paramContext.getContentResolver(), paramString, "umeng_social_shareimg", null);
        if (TextUtils.isEmpty(str))
          continue;
        Uri localUri = Uri.parse(str);
        return localUri;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        i.b("com.umeng.socialize", "", localIllegalArgumentException);
        return null;
      }
      catch (Exception localException)
      {
        i.b("com.umeng.socialize", "", localException);
      }
    }
    return null;
  }

  public static Bundle a(String paramString)
  {
    try
    {
      URL localURL = new URL(paramString);
      Bundle localBundle = b(localURL.getQuery());
      localBundle.putAll(b(localURL.getRef()));
      return localBundle;
    }
    catch (MalformedURLException localMalformedURLException)
    {
    }
    return new Bundle();
  }

  public static String a(Context paramContext)
  {
    String str = r.u;
    if (TextUtils.isEmpty(str))
      try
      {
        ApplicationInfo localApplicationInfo = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
        if (localApplicationInfo != null)
        {
          Object localObject = localApplicationInfo.metaData.get("UMENG_APPKEY");
          if (localObject != null)
            return localObject.toString();
          i.a("com.umeng.socialize", "Could not read UMENG_APPKEY meta-data from AndroidManifest.xml.");
          return str;
        }
      }
      catch (Exception localException)
      {
        i.a("com.umeng.socialize", "Could not read UMENG_APPKEY meta-data from AndroidManifest.xml.", localException);
      }
    return str;
  }

  public static String a(Context paramContext, long paramLong)
  {
    long l = (System.currentTimeMillis() - paramLong) / 1000L;
    if (l < 0L)
      l = 0L;
    if ((TextUtils.isEmpty(c)) || (TextUtils.isEmpty(d)) || (TextUtils.isEmpty(e)))
    {
      c = paramContext.getResources().getString(b.a(paramContext, b.a.e, "umeng_socialize_msg_sec"));
      d = paramContext.getResources().getString(b.a(paramContext, b.a.e, "umeng_socialize_msg_min"));
      e = paramContext.getResources().getString(b.a(paramContext, b.a.e, "umeng_socialize_msg_hor"));
    }
    String str;
    if (l / 60L == 0L)
      str = l + c;
    while (true)
    {
      if (str == null)
        str = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(Long.valueOf(paramLong));
      return str;
      if (l / 3600L == 0L)
      {
        str = l / 60L + d;
        continue;
      }
      if (l / 86400L == 0L)
      {
        str = l / 3600L + e;
        continue;
      }
      str = null;
    }
  }

  public static void a(Dialog paramDialog)
  {
    if (paramDialog != null);
    try
    {
      if (paramDialog.isShowing())
      {
        Activity localActivity = paramDialog.getOwnerActivity();
        if ((localActivity == null) || (!localActivity.isFinishing()))
          paramDialog.dismiss();
      }
      return;
    }
    catch (WindowManager.BadTokenException localBadTokenException)
    {
      i.b(a, "dialog dismiss error", localBadTokenException);
    }
  }

  public static void a(Context paramContext, p paramp, Integer paramInteger)
  {
    if ((paramInteger.intValue() == 5027) || (paramInteger.intValue() == 5028) || (paramInteger.intValue() == 5014) || (paramInteger.intValue() == 5037))
    {
      k.g(paramContext, paramp);
      k.d(paramContext, paramp);
    }
  }

  public static void a(Context paramContext, String paramString1, String paramString2, UMediaObject paramUMediaObject, String paramString3)
  {
    UMSocialService localUMSocialService = com.umeng.socialize.controller.a.a(paramString1, l.b);
    UMShareMsg localUMShareMsg = new UMShareMsg();
    i.a(a, "send analytic report , the entity name is " + localUMSocialService.f().c);
    if ((paramUMediaObject instanceof BaseMediaObject))
      localUMShareMsg.a(paramUMediaObject);
    while (true)
    {
      localUMSocialService.f().b(false);
      localUMShareMsg.a = paramString2;
      localUMSocialService.a(paramContext, null, paramString3, localUMShareMsg, null);
      return;
      if (!(paramUMediaObject instanceof BaseShareContent))
        continue;
      localUMShareMsg.a(((BaseShareContent)paramUMediaObject).c());
    }
  }

  public static void a(Context paramContext, Map<String, Object> paramMap)
  {
    if ((paramContext == null) || (paramMap == null) || (paramMap.size() == 0))
      return;
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("umeng_socialize_key", 0).edit();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (paramMap.get(str) == null)
        continue;
      localEditor.putString(str, paramMap.get(str).toString());
    }
    localEditor.commit();
  }

  public static void a(Context paramContext, Set<Uri> paramSet)
  {
    Set localSet = (Set)d(a.b + "image_uri_cache");
    if ((localSet != null) && (localSet.size() > 0))
    {
      Iterator localIterator2 = localSet.iterator();
      while (localIterator2.hasNext())
        paramSet.add(Uri.parse((String)localIterator2.next()));
    }
    if ((paramSet != null) && (paramSet.size() > 0))
    {
      Iterator localIterator1 = paramSet.iterator();
      while (localIterator1.hasNext())
        paramContext.getContentResolver().delete((Uri)localIterator1.next(), null, null);
      paramSet.clear();
    }
    do
      return;
    while (paramSet != null);
    new HashSet();
  }

  public static void a(Object paramObject, String paramString)
  {
    try
    {
      File localFile = new File(paramString);
      if (localFile.exists())
        localFile.delete();
      localFile.createNewFile();
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(new FileOutputStream(localFile));
      localObjectOutputStream.writeObject(paramObject);
      localObjectOutputStream.flush();
      localObjectOutputStream.close();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public static boolean a()
  {
    try
    {
      Class.forName("com.google.android.maps.MapActivity");
      return true;
    }
    catch (Exception localException)
    {
      i.e(a, "The device has no google map lib!");
    }
    return false;
  }

  public static boolean a(Context paramContext, p paramp)
  {
    if ((!a(paramp)) || (paramContext == null));
    while (true)
    {
      return false;
      if (ax.b().c(paramp))
        break;
      if (paramContext == null)
        continue;
      Toast.makeText(paramContext, paramp + "没有在SDK中配置", 0).show();
      return false;
    }
    return true;
  }

  public static boolean a(p paramp)
  {
    return (paramp != null) && (paramp != p.b);
  }

  public static boolean a(String paramString, List<aw> paramList)
  {
    p localp = p.a(paramString);
    if (localp == null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
        if (((aw)localIterator.next()).a.equals(paramString))
          return true;
    }
    return a(localp);
  }

  public static ar[] a(Context paramContext, Map<p, Integer> paramMap, p[] paramArrayOfp)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayOfp != null)
    {
      int i = paramArrayOfp.length;
      int j = 0;
      if (j < i)
      {
        p localp = paramArrayOfp[j];
        if (k.b(paramContext, localp))
          localArrayList.add(new ar(localp.toString(), k.e(paramContext, localp)));
        while (true)
        {
          j++;
          break;
          if (paramMap == null)
            continue;
          paramMap.put(localp, Integer.valueOf(-101));
        }
      }
    }
    return (ar[])localArrayList.toArray(new ar[localArrayList.size()]);
  }

  public static Bundle b(String paramString)
  {
    Bundle localBundle = new Bundle();
    if (paramString != null)
    {
      String[] arrayOfString1 = paramString.split("&");
      int i = arrayOfString1.length;
      for (int j = 0; j < i; j++)
      {
        String[] arrayOfString2 = arrayOfString1[j].split("=");
        localBundle.putString(URLDecoder.decode(arrayOfString2[0]), URLDecoder.decode(arrayOfString2[1]));
      }
    }
    return localBundle;
  }

  private static Pattern b()
  {
    if (f == null)
      f = Pattern.compile("[^\\x00-\\xff]");
    return f;
  }

  public static void b(Dialog paramDialog)
  {
    if (paramDialog != null);
    try
    {
      if (!paramDialog.isShowing())
      {
        Activity localActivity = paramDialog.getOwnerActivity();
        if ((localActivity == null) || (!localActivity.isFinishing()))
          paramDialog.show();
      }
      return;
    }
    catch (WindowManager.BadTokenException localBadTokenException)
    {
      i.b(a, "dialog show error", localBadTokenException);
    }
  }

  public static void b(Context paramContext, Map<String, String> paramMap)
  {
    if ((paramContext == null) || (paramMap == null) || (paramMap.size() == 0))
      return;
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("umeng_socialize_secret", 0).edit();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (paramMap.get(str) == null)
        continue;
      localEditor.putString(str, ((String)paramMap.get(str)).toString());
    }
    localEditor.commit();
  }

  public static Object[] b(Context paramContext)
  {
    Object[] arrayOfObject;
    try
    {
      arrayOfObject = new Object[3];
      TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      arrayOfObject[0] = Boolean.valueOf(false);
      switch (localTelephonyManager.getSimState())
      {
      case 1:
        arrayOfObject[1] = "无卡";
      case 0:
      case 4:
      case 2:
      case 3:
      case 5:
      }
    }
    catch (Exception localException)
    {
      i.b(a, "cannot read SIM card. [" + localException.toString() + "]");
      return null;
    }
    arrayOfObject[0] = Boolean.valueOf(true);
    arrayOfObject[1] = "未知状态";
    break label167;
    arrayOfObject[1] = "需要NetworkPIN解锁";
    break label167;
    arrayOfObject[1] = "需要PIN解锁";
    break label167;
    arrayOfObject[1] = "需要PUK解锁";
    break label167;
    arrayOfObject[0] = Boolean.valueOf(true);
    arrayOfObject[1] = "良好";
    label167: return arrayOfObject;
  }

  public static int c(String paramString)
  {
    String str = paramString.trim();
    int i = 0;
    Matcher localMatcher = b().matcher(str);
    while (localMatcher.find())
      i++;
    int j = str.length() - i;
    if (j % 2 != 0)
      return i + (j + 1) / 2;
    return i + j / 2;
  }

  public static int[] c(Context paramContext)
  {
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = (int)paramContext.getResources().getDimension(b.a(paramContext, b.a.g, "umeng_socialize_pad_window_width"));
    arrayOfInt[1] = (int)paramContext.getResources().getDimension(b.a(paramContext, b.a.g, "umeng_socialize_pad_window_height"));
    return arrayOfInt;
  }

  // ERROR //
  public static <T> T d(String paramString)
  {
    // Byte code:
    //   0: new 71	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 74	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aload_1
    //   10: invokevirtual 78	java/io/File:exists	()Z
    //   13: istore 8
    //   15: iload 8
    //   17: ifne +22 -> 39
    //   20: iconst_0
    //   21: ifeq +7 -> 28
    //   24: aconst_null
    //   25: invokevirtual 596	java/io/ObjectInputStream:close	()V
    //   28: aconst_null
    //   29: areturn
    //   30: astore 12
    //   32: aload 12
    //   34: invokevirtual 597	java/io/IOException:printStackTrace	()V
    //   37: aconst_null
    //   38: areturn
    //   39: new 595	java/io/ObjectInputStream
    //   42: dup
    //   43: new 599	java/io/FileInputStream
    //   46: dup
    //   47: aload_1
    //   48: invokespecial 600	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   51: invokespecial 603	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   54: astore_3
    //   55: aload_3
    //   56: invokevirtual 606	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   59: astore 9
    //   61: aload 9
    //   63: ifnull +24 -> 87
    //   66: aload_3
    //   67: ifnull +7 -> 74
    //   70: aload_3
    //   71: invokevirtual 596	java/io/ObjectInputStream:close	()V
    //   74: aload 9
    //   76: areturn
    //   77: astore 11
    //   79: aload 11
    //   81: invokevirtual 597	java/io/IOException:printStackTrace	()V
    //   84: goto -10 -> 74
    //   87: aload_3
    //   88: ifnull -60 -> 28
    //   91: aload_3
    //   92: invokevirtual 596	java/io/ObjectInputStream:close	()V
    //   95: aconst_null
    //   96: areturn
    //   97: astore 10
    //   99: aload 10
    //   101: invokevirtual 597	java/io/IOException:printStackTrace	()V
    //   104: aconst_null
    //   105: areturn
    //   106: astore 6
    //   108: aconst_null
    //   109: astore_3
    //   110: aload 6
    //   112: invokevirtual 414	java/lang/Exception:printStackTrace	()V
    //   115: aload_3
    //   116: ifnull -88 -> 28
    //   119: aload_3
    //   120: invokevirtual 596	java/io/ObjectInputStream:close	()V
    //   123: aconst_null
    //   124: areturn
    //   125: astore 7
    //   127: aload 7
    //   129: invokevirtual 597	java/io/IOException:printStackTrace	()V
    //   132: aconst_null
    //   133: areturn
    //   134: astore_2
    //   135: aconst_null
    //   136: astore_3
    //   137: aload_2
    //   138: astore 4
    //   140: aload_3
    //   141: ifnull +7 -> 148
    //   144: aload_3
    //   145: invokevirtual 596	java/io/ObjectInputStream:close	()V
    //   148: aload 4
    //   150: athrow
    //   151: astore 5
    //   153: aload 5
    //   155: invokevirtual 597	java/io/IOException:printStackTrace	()V
    //   158: goto -10 -> 148
    //   161: astore 4
    //   163: goto -23 -> 140
    //   166: astore 6
    //   168: goto -58 -> 110
    //
    // Exception table:
    //   from	to	target	type
    //   24	28	30	java/io/IOException
    //   70	74	77	java/io/IOException
    //   91	95	97	java/io/IOException
    //   0	15	106	java/lang/Exception
    //   39	55	106	java/lang/Exception
    //   119	123	125	java/io/IOException
    //   0	15	134	finally
    //   39	55	134	finally
    //   144	148	151	java/io/IOException
    //   55	61	161	finally
    //   110	115	161	finally
    //   55	61	166	java/lang/Exception
  }

  public static boolean d(Context paramContext)
  {
    if (r.i)
    {
      WindowManager localWindowManager;
      int i;
      int j;
      if (g == 0)
      {
        localWindowManager = (WindowManager)paramContext.getSystemService("window");
        Display localDisplay = localWindowManager.getDefaultDisplay();
        i = localDisplay.getWidth();
        j = localDisplay.getHeight();
        if (i <= j)
          break label111;
      }
      while (true)
      {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
        g = (int)(0.5F + j / localDisplayMetrics.density);
        if (((0xF & paramContext.getResources().getConfiguration().screenLayout) < 3) || (g < 550))
          break;
        return true;
        label111: j = i;
      }
    }
    return false;
  }

  public static String e(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return "";
    StringBuilder localStringBuilder = new StringBuilder();
    char[] arrayOfChar = paramString.toCharArray();
    for (int i = -1 + arrayOfChar.length; i >= 0; i--)
      localStringBuilder.append(arrayOfChar[i]);
    return localStringBuilder.toString();
  }

  public static Map<String, Object> e(Context paramContext)
  {
    int i = 0;
    HashMap localHashMap;
    if (paramContext == null)
      localHashMap = null;
    while (true)
    {
      return localHashMap;
      SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("umeng_socialize_key", 0);
      localHashMap = new HashMap();
      p[] arrayOfp = p.values();
      int j = arrayOfp.length;
      while (i < j)
      {
        String str = arrayOfp[i].toString();
        if (localSharedPreferences.contains(str))
          localHashMap.put(str, localSharedPreferences.getString(str, ""));
        i++;
      }
    }
  }

  public static Map<String, String> f(Context paramContext)
  {
    int i = 0;
    HashMap localHashMap;
    if (paramContext == null)
      localHashMap = null;
    while (true)
    {
      return localHashMap;
      SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("umeng_socialize_secret", 0);
      localHashMap = new HashMap();
      p[] arrayOfp = p.values();
      int j = arrayOfp.length;
      while (i < j)
      {
        String str = arrayOfp[i].toString();
        if (localSharedPreferences.contains(str))
          localHashMap.put(str, localSharedPreferences.getString(str, ""));
        i++;
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.utils.m
 * JD-Core Version:    0.6.0
 */