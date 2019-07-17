package com.tencent.open.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import com.tencent.open.a.f;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.List;

public class SystemUtils
{
  public static final String ACTION_LOGIN = "action_login";
  public static final String ACTION_SHARE = "action_share";
  public static final String H5_SHARE_DATA = "h5_share_data";
  public static final String IS_LOGIN = "is_login";
  public static final String IS_QQ_MOBILE_SHARE = "is_qq_mobile_share";
  public static final String QQDATALINE_CALLBACK_ACTION = "sendToMyComputer";
  public static final String QQFAVORITES_CALLBACK_ACTION = "addToQQFavorites";
  public static final String QQ_SHARE_CALLBACK_ACTION = "shareToQQ";
  public static final String QQ_VERSION_NAME_4_2_0 = "4.2.0";
  public static final String QQ_VERSION_NAME_4_3_0 = "4.3.0";
  public static final String QQ_VERSION_NAME_4_5_0 = "4.5.0";
  public static final String QQ_VERSION_NAME_4_6_0 = "4.6.0";
  public static final String QQ_VERSION_NAME_5_0_0 = "5.0.0";
  public static final String QQ_VERSION_NAME_5_1_0 = "5.1.0";
  public static final String QQ_VERSION_NAME_5_2_0 = "5.2.0";
  public static final String QQ_VERSION_NAME_5_3_0 = "5.3.0";
  public static final String QZONE_SHARE_CALLBACK_ACTION = "shareToQzone";
  public static final String TROOPBAR_CALLBACK_ACTION = "shareToTroopBar";
  private static final String a = f.d + ".SysUtils";

  private static long a(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    long l = 0L;
    byte[] arrayOfByte = new byte[8192];
    while (true)
    {
      int i = paramInputStream.read(arrayOfByte, 0, arrayOfByte.length);
      if (i == -1)
        break;
      paramOutputStream.write(arrayOfByte, 0, i);
      l += i;
    }
    f.c(a, "-->copy, copyed size is: " + l);
    return l;
  }

  public static boolean checkMobileQQ(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      PackageInfo localPackageInfo2 = localPackageManager.getPackageInfo("com.tencent.mobileqq", 0);
      localPackageInfo1 = localPackageInfo2;
      i = 0;
      if (localPackageInfo1 != null)
        str = localPackageInfo1.versionName;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      try
      {
        int i;
        String str;
        f.b("MobileQQ verson", str);
        String[] arrayOfString = str.split("\\.");
        int j = Integer.parseInt(arrayOfString[0]);
        int k = Integer.parseInt(arrayOfString[1]);
        if (j <= 4)
        {
          i = 0;
          if (j == 4)
          {
            i = 0;
            if (k < 1);
          }
        }
        else
        {
          i = 1;
        }
        return i;
        localNameNotFoundException = localNameNotFoundException;
        f.b("checkMobileQQ", "error");
        localNameNotFoundException.printStackTrace();
        PackageInfo localPackageInfo1 = null;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return false;
  }

  public static int compareQQVersion(Context paramContext, String paramString)
  {
    return compareVersion(getAppVersionName(paramContext, "com.tencent.mobileqq"), paramString);
  }

  public static int compareVersion(String paramString1, String paramString2)
  {
    if ((paramString1 == null) && (paramString2 == null))
      return 0;
    if ((paramString1 != null) && (paramString2 == null))
      return 1;
    if ((paramString1 == null) && (paramString2 != null))
      return -1;
    String[] arrayOfString1 = paramString1.split("\\.");
    String[] arrayOfString2 = paramString2.split("\\.");
    for (int i = 0; ; i++)
    {
      int k;
      int m;
      try
      {
        if ((i < arrayOfString1.length) && (i < arrayOfString2.length))
        {
          k = Integer.parseInt(arrayOfString1[i]);
          m = Integer.parseInt(arrayOfString2[i]);
          if (k < m)
            return -1;
        }
        else
        {
          if (arrayOfString1.length > i)
            return 1;
          int j = arrayOfString2.length;
          if (j <= i)
            break;
          return -1;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        return paramString1.compareTo(paramString2);
      }
      if (k > m)
        return 1;
    }
  }

  // ERROR //
  @SuppressLint({"SdCardPath"})
  public static boolean extractSecureLib(String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 84	com/tencent/open/utils/SystemUtils:a	Ljava/lang/String;
    //   5: new 64	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   12: ldc 182
    //   14: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_0
    //   18: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokestatic 109	com/tencent/open/a/f:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: invokestatic 188	com/tencent/open/utils/Global:getContext	()Landroid/content/Context;
    //   30: astore 4
    //   32: aload 4
    //   34: ifnonnull +13 -> 47
    //   37: getstatic 84	com/tencent/open/utils/SystemUtils:a	Ljava/lang/String;
    //   40: ldc 190
    //   42: invokestatic 109	com/tencent/open/a/f:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: iconst_0
    //   46: ireturn
    //   47: aload 4
    //   49: ldc 192
    //   51: iconst_0
    //   52: invokevirtual 196	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   55: astore 5
    //   57: new 198	java/io/File
    //   60: dup
    //   61: aload 4
    //   63: invokevirtual 202	android/content/Context:getFilesDir	()Ljava/io/File;
    //   66: aload_1
    //   67: invokespecial 205	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   70: astore 6
    //   72: aload 6
    //   74: invokevirtual 209	java/io/File:exists	()Z
    //   77: ifne +108 -> 185
    //   80: aload 6
    //   82: invokevirtual 212	java/io/File:getParentFile	()Ljava/io/File;
    //   85: invokevirtual 215	java/io/File:mkdirs	()Z
    //   88: ifeq +9 -> 97
    //   91: aload 6
    //   93: invokevirtual 218	java/io/File:createNewFile	()Z
    //   96: pop
    //   97: aload 4
    //   99: invokevirtual 222	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   102: aload_0
    //   103: invokevirtual 228	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   106: astore 15
    //   108: aload 15
    //   110: astore 9
    //   112: aload 4
    //   114: aload_1
    //   115: iconst_0
    //   116: invokevirtual 232	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   119: astore_3
    //   120: aload 9
    //   122: aload_3
    //   123: invokestatic 234	com/tencent/open/utils/SystemUtils:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   126: pop2
    //   127: aload 5
    //   129: invokeinterface 240 1 0
    //   134: astore 18
    //   136: aload 18
    //   138: ldc 242
    //   140: iload_2
    //   141: invokeinterface 248 3 0
    //   146: pop
    //   147: aload 18
    //   149: invokeinterface 251 1 0
    //   154: pop
    //   155: aload 9
    //   157: ifnull +8 -> 165
    //   160: aload 9
    //   162: invokevirtual 254	java/io/InputStream:close	()V
    //   165: aload_3
    //   166: ifnull +7 -> 173
    //   169: aload_3
    //   170: invokevirtual 255	java/io/OutputStream:close	()V
    //   173: iconst_1
    //   174: ireturn
    //   175: astore 23
    //   177: aload 23
    //   179: invokevirtual 256	java/io/IOException:printStackTrace	()V
    //   182: goto -85 -> 97
    //   185: aload 5
    //   187: ldc 242
    //   189: iconst_0
    //   190: invokeinterface 260 3 0
    //   195: istore 7
    //   197: getstatic 84	com/tencent/open/utils/SystemUtils:a	Ljava/lang/String;
    //   200: new 64	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   207: ldc_w 262
    //   210: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: iload_2
    //   214: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   217: ldc_w 267
    //   220: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: iload 7
    //   225: invokevirtual 265	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   228: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokestatic 109	com/tencent/open/a/f:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   234: iload_2
    //   235: iload 7
    //   237: if_icmpne -140 -> 97
    //   240: iconst_1
    //   241: ireturn
    //   242: astore 12
    //   244: aconst_null
    //   245: astore 9
    //   247: getstatic 84	com/tencent/open/utils/SystemUtils:a	Ljava/lang/String;
    //   250: ldc_w 269
    //   253: aload 12
    //   255: invokestatic 272	com/tencent/open/a/f:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   258: aload 9
    //   260: ifnull +8 -> 268
    //   263: aload 9
    //   265: invokevirtual 254	java/io/InputStream:close	()V
    //   268: aload_3
    //   269: ifnull -224 -> 45
    //   272: aload_3
    //   273: invokevirtual 255	java/io/OutputStream:close	()V
    //   276: iconst_0
    //   277: ireturn
    //   278: astore 13
    //   280: iconst_0
    //   281: ireturn
    //   282: astore 8
    //   284: aconst_null
    //   285: astore 9
    //   287: aload 9
    //   289: ifnull +8 -> 297
    //   292: aload 9
    //   294: invokevirtual 254	java/io/InputStream:close	()V
    //   297: aload_3
    //   298: ifnull +7 -> 305
    //   301: aload_3
    //   302: invokevirtual 255	java/io/OutputStream:close	()V
    //   305: aload 8
    //   307: athrow
    //   308: astore 22
    //   310: goto -145 -> 165
    //   313: astore 21
    //   315: goto -142 -> 173
    //   318: astore 14
    //   320: goto -52 -> 268
    //   323: astore 11
    //   325: goto -28 -> 297
    //   328: astore 10
    //   330: goto -25 -> 305
    //   333: astore 8
    //   335: goto -48 -> 287
    //   338: astore 12
    //   340: goto -93 -> 247
    //
    // Exception table:
    //   from	to	target	type
    //   91	97	175	java/io/IOException
    //   97	108	242	java/lang/Exception
    //   272	276	278	java/io/IOException
    //   97	108	282	finally
    //   160	165	308	java/io/IOException
    //   169	173	313	java/io/IOException
    //   263	268	318	java/io/IOException
    //   292	297	323	java/io/IOException
    //   301	305	328	java/io/IOException
    //   112	155	333	finally
    //   247	258	333	finally
    //   112	155	338	java/lang/Exception
  }

  public static int getAndroidSDKVersion()
  {
    try
    {
      int i = Integer.valueOf(Build.VERSION.SDK).intValue();
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return 0;
  }

  public static String getAppName(Context paramContext)
  {
    return paramContext.getApplicationInfo().loadLabel(paramContext.getPackageManager()).toString();
  }

  // ERROR //
  public static String getAppSignatureMD5(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: getstatic 72	com/tencent/open/a/f:d	Ljava/lang/String;
    //   3: ldc_w 302
    //   6: invokestatic 304	com/tencent/open/a/f:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: aload_0
    //   10: invokevirtual 307	android/content/Context:getPackageName	()Ljava/lang/String;
    //   13: astore 5
    //   15: aload_0
    //   16: invokevirtual 121	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   19: aload 5
    //   21: bipush 64
    //   23: invokevirtual 129	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   26: getfield 311	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   29: astore 6
    //   31: ldc_w 313
    //   34: invokestatic 319	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   37: astore 7
    //   39: aload 7
    //   41: aload 6
    //   43: iconst_0
    //   44: aaload
    //   45: invokevirtual 325	android/content/pm/Signature:toByteArray	()[B
    //   48: invokevirtual 329	java/security/MessageDigest:update	([B)V
    //   51: aload 7
    //   53: invokevirtual 332	java/security/MessageDigest:digest	()[B
    //   56: invokestatic 338	com/tencent/open/utils/Util:toHexString	([B)Ljava/lang/String;
    //   59: astore 8
    //   61: aload 7
    //   63: invokevirtual 341	java/security/MessageDigest:reset	()V
    //   66: ldc_w 343
    //   69: new 64	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   76: ldc_w 345
    //   79: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload 8
    //   84: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokestatic 139	com/tencent/open/a/f:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   93: aload 7
    //   95: new 64	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   102: aload 5
    //   104: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: ldc_w 347
    //   110: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload 8
    //   115: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: ldc_w 347
    //   121: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload_1
    //   125: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: ldc_w 349
    //   131: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 353	com/tencent/open/utils/Util:getBytesUTF8	(Ljava/lang/String;)[B
    //   140: invokevirtual 329	java/security/MessageDigest:update	([B)V
    //   143: aload 7
    //   145: invokevirtual 332	java/security/MessageDigest:digest	()[B
    //   148: invokestatic 338	com/tencent/open/utils/Util:toHexString	([B)Ljava/lang/String;
    //   151: astore 9
    //   153: aload 9
    //   155: astore_3
    //   156: aload 7
    //   158: invokevirtual 341	java/security/MessageDigest:reset	()V
    //   161: ldc_w 343
    //   164: new 64	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   171: ldc_w 355
    //   174: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload_3
    //   178: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 139	com/tencent/open/a/f:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   187: aload_3
    //   188: areturn
    //   189: astore_2
    //   190: ldc_w 349
    //   193: astore_3
    //   194: aload_2
    //   195: astore 4
    //   197: aload 4
    //   199: invokevirtual 160	java/lang/Exception:printStackTrace	()V
    //   202: getstatic 72	com/tencent/open/a/f:d	Ljava/lang/String;
    //   205: ldc_w 357
    //   208: aload 4
    //   210: invokestatic 272	com/tencent/open/a/f:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   213: aload_3
    //   214: areturn
    //   215: astore 4
    //   217: goto -20 -> 197
    //
    // Exception table:
    //   from	to	target	type
    //   9	153	189	java/lang/Exception
    //   156	187	215	java/lang/Exception
  }

  public static String getAppVersionName(Context paramContext, String paramString)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      String str = localPackageManager.getPackageInfo(paramString, 0).versionName;
      return str;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return null;
  }

  public static String getRealPathFromUri(Activity paramActivity, Uri paramUri)
  {
    Cursor localCursor = paramActivity.managedQuery(paramUri, new String[] { "_data" }, null, null, null);
    String str = null;
    if (localCursor != null)
    {
      int i = localCursor.getColumnIndexOrThrow("_data");
      localCursor.moveToFirst();
      str = localCursor.getString(i);
    }
    return str;
  }

  public static boolean isActivityExist(Context paramContext, Intent paramIntent)
  {
    if ((paramContext == null) || (paramIntent == null));
    do
      return false;
    while (paramContext.getPackageManager().queryIntentActivities(paramIntent, 0).size() == 0);
    return true;
  }

  public static boolean isAppSignatureValid(Context paramContext, String paramString1, String paramString2)
  {
    f.a(f.d, "OpenUi, validateAppSignatureForPackage");
    try
    {
      PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(paramString1, 64);
      Signature[] arrayOfSignature = localPackageInfo.signatures;
      int i = arrayOfSignature.length;
      for (int j = 0; ; j++)
      {
        int k = 0;
        if (j < i)
        {
          if (!Util.encrypt(arrayOfSignature[j].toCharsString()).equals(paramString2))
            continue;
          k = 1;
        }
        return k;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return false;
  }

  @SuppressLint({"SdCardPath"})
  public static boolean isLibExtracted(String paramString, int paramInt)
  {
    Context localContext = Global.getContext();
    if (localContext == null)
      f.c(a, "-->isSecureLibExtracted, global context is null. ");
    File localFile;
    SharedPreferences localSharedPreferences;
    do
    {
      return false;
      localFile = new File(localContext.getFilesDir(), paramString);
      localSharedPreferences = localContext.getSharedPreferences("secure_lib", 0);
    }
    while (!localFile.exists());
    int i = localSharedPreferences.getInt("version", 0);
    f.c(a, "-->extractSecureLib, libVersion: " + paramInt + " | oldVersion: " + i);
    if (paramInt == i)
      return true;
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    localEditor.putInt("version", paramInt);
    localEditor.commit();
    return false;
  }

  public static boolean isSupportMultiTouch()
  {
    Method[] arrayOfMethod = MotionEvent.class.getDeclaredMethods();
    int i = arrayOfMethod.length;
    int j = 0;
    int k = 0;
    int m = 0;
    while (j < i)
    {
      Method localMethod = arrayOfMethod[j];
      if (localMethod.getName().equals("getPointerCount"))
        m = 1;
      if (localMethod.getName().equals("getPointerId"))
        k = 1;
      j++;
    }
    return (getAndroidSDKVersion() >= 7) || ((m != 0) && (k != 0));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.open.utils.SystemUtils
 * JD-Core Version:    0.6.0
 */