package com.tencent.open.utils;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import com.tencent.open.a.f;
import com.tencent.open.b.a;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.json.JSONException;
import org.json.JSONObject;

public class Util
{
  private static final String a = f.d + "." + Util.class.getName();
  private static String b = "";
  private static String c = "";
  private static String d = "";
  private static String e = "";
  private static int f = -1;
  private static String g;
  private static boolean h = true;
  private static String i = "0123456789ABCDEF";

  private static char a(int paramInt)
  {
    int j = paramInt & 0xF;
    if (j < 10)
      return (char)(j + 48);
    return (char)(97 + (j - 10));
  }

  private static String a(HttpResponse paramHttpResponse)
    throws IllegalStateException, IOException
  {
    InputStream localInputStream = paramHttpResponse.getEntity().getContent();
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    Header localHeader = paramHttpResponse.getFirstHeader("Content-Encoding");
    if ((localHeader != null) && (localHeader.getValue().toLowerCase().indexOf("gzip") > -1));
    for (Object localObject = new GZIPInputStream(localInputStream); ; localObject = localInputStream)
    {
      byte[] arrayOfByte = new byte[512];
      while (true)
      {
        int j = ((InputStream)localObject).read(arrayOfByte);
        if (j == -1)
          break;
        localByteArrayOutputStream.write(arrayOfByte, 0, j);
      }
      return new String(localByteArrayOutputStream.toByteArray(), "UTF-8");
    }
  }

  private static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName(paramString1, paramString2));
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.addFlags(1073741824);
    localIntent.addFlags(268435456);
    localIntent.setData(Uri.parse(paramString3));
    paramContext.startActivity(localIntent);
  }

  private static boolean a(Context paramContext)
  {
    try
    {
      PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo("com.tencent.mtt", 64);
      String str1 = localPackageInfo.versionName;
      int j = SystemUtils.compareVersion(str1, "4.3");
      int k = 0;
      Signature[] arrayOfSignature;
      if (j >= 0)
      {
        boolean bool1 = str1.startsWith("4.4");
        k = 0;
        if (!bool1)
        {
          arrayOfSignature = localPackageInfo.signatures;
          k = 0;
          if (arrayOfSignature == null);
        }
      }
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
        localMessageDigest.update(arrayOfSignature[0].toByteArray());
        String str2 = toHexString(localMessageDigest.digest());
        localMessageDigest.reset();
        boolean bool2 = str2.equals("d8391a394d4a179e6fe7bdb8a301258b");
        k = 0;
        if (bool2)
          k = 1;
        return k;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        f.e(a, "isQQBrowerAvailable has exception: " + localNoSuchAlgorithmException.getMessage());
        return false;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return false;
  }

  public static boolean checkNetWork(Context paramContext)
  {
    ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    int j;
    if (localConnectivityManager == null)
      j = 1;
    NetworkInfo[] arrayOfNetworkInfo;
    do
    {
      return j;
      arrayOfNetworkInfo = localConnectivityManager.getAllNetworkInfo();
      j = 0;
    }
    while (arrayOfNetworkInfo == null);
    for (int k = 0; ; k++)
    {
      int m = arrayOfNetworkInfo.length;
      j = 0;
      if (k >= m)
        break;
      if (arrayOfNetworkInfo[k].isConnectedOrConnecting())
        return true;
    }
  }

  public static Bundle composeHaboCgiReportParams(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("platform", "1");
    localBundle.putString("result", paramString1);
    localBundle.putString("code", paramString2);
    localBundle.putString("tmcost", paramString3);
    localBundle.putString("rate", paramString4);
    localBundle.putString("cmd", paramString5);
    localBundle.putString("uin", paramString6);
    localBundle.putString("appid", paramString7);
    localBundle.putString("share_type", paramString8);
    localBundle.putString("detail", paramString9);
    localBundle.putString("os_ver", Build.VERSION.RELEASE);
    localBundle.putString("network", a.a(Global.getContext()));
    localBundle.putString("apn", a.b(Global.getContext()));
    localBundle.putString("model_name", Build.MODEL);
    localBundle.putString("sdk_ver", "2.8.lite");
    localBundle.putString("packagename", Global.getPackageName());
    localBundle.putString("app_ver", getAppVersionName(Global.getContext(), Global.getPackageName()));
    return localBundle;
  }

  public static Bundle composeViaReportParams(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return composeViaReportParams(paramString1, paramString3, paramString4, paramString2, paramString5, paramString6, "", "", "", "", "", "");
  }

  public static Bundle composeViaReportParams(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("openid", paramString1);
    localBundle.putString("report_type", paramString2);
    localBundle.putString("act_type", paramString3);
    localBundle.putString("via", paramString4);
    localBundle.putString("app_id", paramString5);
    localBundle.putString("result", paramString6);
    localBundle.putString("type", paramString7);
    localBundle.putString("login_status", paramString8);
    localBundle.putString("need_user_auth", paramString9);
    localBundle.putString("to_uin", paramString10);
    localBundle.putString("call_source", paramString11);
    localBundle.putString("to_type", paramString12);
    return localBundle;
  }

  public static Bundle decodeUrl(String paramString)
  {
    Bundle localBundle = new Bundle();
    if (paramString != null)
    {
      String[] arrayOfString1 = paramString.split("&");
      int j = arrayOfString1.length;
      for (int k = 0; k < j; k++)
      {
        String[] arrayOfString2 = arrayOfString1[k].split("=");
        if (arrayOfString2.length != 2)
          continue;
        localBundle.putString(URLDecoder.decode(arrayOfString2[0]), URLDecoder.decode(arrayOfString2[1]));
      }
    }
    return localBundle;
  }

  public static JSONObject decodeUrlToJson(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject == null)
      paramJSONObject = new JSONObject();
    if (paramString != null)
    {
      String[] arrayOfString1 = paramString.split("&");
      int j = arrayOfString1.length;
      int k = 0;
      while (true)
        if (k < j)
        {
          String[] arrayOfString2 = arrayOfString1[k].split("=");
          if (arrayOfString2.length == 2);
          try
          {
            paramJSONObject.put(URLDecoder.decode(arrayOfString2[0]), URLDecoder.decode(arrayOfString2[1]));
            k++;
          }
          catch (JSONException localJSONException)
          {
            while (true)
              f.e(a, "decodeUrlToJson has exception: " + localJSONException.getMessage());
          }
        }
    }
    return paramJSONObject;
  }

  public static String encodePostBody(Bundle paramBundle, String paramString)
  {
    if (paramBundle == null)
      return "";
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramBundle.size();
    Iterator localIterator = paramBundle.keySet().iterator();
    int k = -1;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      int m = k + 1;
      Object localObject = paramBundle.get(str);
      if (!(localObject instanceof String))
      {
        k = m;
        continue;
      }
      localStringBuilder.append("Content-Disposition: form-data; name=\"" + str + "\"" + "\r\n" + "\r\n" + (String)localObject);
      if (m < j - 1)
        localStringBuilder.append("\r\n--" + paramString + "\r\n");
      k = m;
    }
    return localStringBuilder.toString();
  }

  public static String encodeUrl(Bundle paramBundle)
  {
    if (paramBundle == null)
      return "";
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramBundle.keySet().iterator();
    int j = 1;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramBundle.get(str);
      if ((!(localObject instanceof String)) && (!(localObject instanceof String[])))
        continue;
      label130: label173: label208: int k;
      if ((localObject instanceof String[]))
      {
        String[] arrayOfString;
        int m;
        if (j != 0)
        {
          j = 0;
          localStringBuilder.append(URLEncoder.encode(str) + "=");
          arrayOfString = paramBundle.getStringArray(str);
          if (arrayOfString == null)
            break label208;
          m = 0;
          if (m >= arrayOfString.length)
            break label208;
          if (m != 0)
            break label173;
          localStringBuilder.append(URLEncoder.encode(arrayOfString[m]));
        }
        while (true)
        {
          m++;
          break label130;
          localStringBuilder.append("&");
          break;
          localStringBuilder.append(URLEncoder.encode("," + arrayOfString[m]));
        }
        k = j;
        j = k;
        continue;
      }
      if (j != 0)
        j = 0;
      while (true)
      {
        localStringBuilder.append(URLEncoder.encode(str) + "=" + URLEncoder.encode(paramBundle.getString(str)));
        k = j;
        break;
        localStringBuilder.append("&");
      }
    }
    return localStringBuilder.toString();
  }

  public static String encrypt(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(getBytesUTF8(paramString));
      byte[] arrayOfByte = localMessageDigest.digest();
      if (arrayOfByte != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        int j = arrayOfByte.length;
        for (int k = 0; k < j; k++)
        {
          int m = arrayOfByte[k];
          localStringBuilder.append(a(m >>> 4));
          localStringBuilder.append(a(m));
        }
        String str = localStringBuilder.toString();
        paramString = str;
      }
      return paramString;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      f.e(a, "encrypt has exception: " + localNoSuchAlgorithmException.getMessage());
    }
    return paramString;
  }

  public static boolean fileExists(String paramString)
  {
    if (paramString == null);
    File localFile;
    do
    {
      return false;
      localFile = new File(paramString);
    }
    while ((localFile == null) || (!localFile.exists()));
    return true;
  }

  public static String getAppVersion(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      String str = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0).versionName;
      return str;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      f.e(a, "getAppVersion error" + localNameNotFoundException.getMessage());
    }
    return "";
  }

  public static String getAppVersionName(Context paramContext, String paramString)
  {
    if (paramContext == null)
      return "";
    getPackageInfo(paramContext, paramString);
    return b;
  }

  public static final String getApplicationLable(Context paramContext)
  {
    if (paramContext != null)
    {
      CharSequence localCharSequence = paramContext.getPackageManager().getApplicationLabel(paramContext.getApplicationInfo());
      if (localCharSequence != null)
        return localCharSequence.toString();
    }
    return null;
  }

  public static byte[] getBytesUTF8(String paramString)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes("UTF-8");
      return arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    return null;
  }

  public static String getLocation(Context paramContext)
  {
    if (paramContext == null)
      return "";
    try
    {
      LocationManager localLocationManager = (LocationManager)paramContext.getSystemService("location");
      Criteria localCriteria = new Criteria();
      localCriteria.setCostAllowed(false);
      localCriteria.setAccuracy(2);
      String str1 = localLocationManager.getBestProvider(localCriteria, true);
      if (str1 != null)
      {
        Location localLocation = localLocationManager.getLastKnownLocation(str1);
        if (localLocation == null)
          return "";
        double d1 = localLocation.getLatitude();
        double d2 = localLocation.getLongitude();
        g = d1 + "*" + d2;
        String str2 = g;
        return str2;
      }
    }
    catch (Exception localException)
    {
      f.b("getLocation", "getLocation>>>", localException);
    }
    return "";
  }

  public static void getPackageInfo(Context paramContext, String paramString)
  {
    if (paramContext == null)
      return;
    try
    {
      PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      c = localPackageInfo.versionName;
      b = c.substring(0, c.lastIndexOf('.'));
      e = c.substring(1 + c.lastIndexOf('.'), c.length());
      f = localPackageInfo.versionCode;
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      f.e(a, "getPackageInfo has exception: " + localNameNotFoundException.getMessage());
      return;
    }
    catch (Exception localException)
    {
      f.e(a, "getPackageInfo has exception: " + localException.getMessage());
    }
  }

  public static String getQUA3(Context paramContext, String paramString)
  {
    if (paramContext == null)
      return "";
    d = getAppVersionName(paramContext, paramString);
    return d;
  }

  public static String getUserIp()
  {
    try
    {
      while (true)
      {
        Enumeration localEnumeration1 = NetworkInterface.getNetworkInterfaces();
        while (true)
          if ((localEnumeration1 != null) && (localEnumeration1.hasMoreElements()))
          {
            Enumeration localEnumeration2 = ((NetworkInterface)localEnumeration1.nextElement()).getInetAddresses();
            if (!localEnumeration2.hasMoreElements())
              continue;
            InetAddress localInetAddress = (InetAddress)localEnumeration2.nextElement();
            if (localInetAddress.isLoopbackAddress())
              break;
            String str = localInetAddress.getHostAddress().toString();
            return str;
          }
      }
    }
    catch (SocketException localSocketException)
    {
      logd("Tencent-Util", localSocketException.toString());
    }
    return "";
  }

  public static String getVersionName(Context paramContext, String paramString)
  {
    if (paramContext == null)
      return "";
    getPackageInfo(paramContext, paramString);
    return c;
  }

  public static boolean hasSDCard()
  {
    boolean bool = Environment.getExternalStorageState().equals("mounted");
    File localFile = null;
    if (bool)
      localFile = Environment.getExternalStorageDirectory();
    return localFile != null;
  }

  public static String hexToString(String paramString)
  {
    int j = 0;
    if ("0x".equals(paramString.substring(0, 2)))
      paramString = paramString.substring(2);
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    while (true)
      if (j < arrayOfByte.length)
      {
        int k = j * 2;
        int m = 2 + j * 2;
        try
        {
          arrayOfByte[j] = (byte)(0xFF & Integer.parseInt(paramString.substring(k, m), 16));
          j++;
        }
        catch (Exception localException2)
        {
          while (true)
            f.e(a, "hexToString has exception: " + localException2.getMessage());
        }
      }
    try
    {
      String str = new String(arrayOfByte, "utf-8");
      return str;
    }
    catch (Exception localException1)
    {
      f.e(a, "hexToString has exception: " + localException1.getMessage());
    }
    return paramString;
  }

  public static boolean isEmpty(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }

  public static boolean isMobileQQSupportShare(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      int j = SystemUtils.compareVersion(localPackageManager.getPackageInfo("com.tencent.mobileqq", 0).versionName, "4.1");
      int k = 0;
      if (j >= 0)
        k = 1;
      return k;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      f.b("checkMobileQQ", "error");
    }
    return false;
  }

  public static boolean isNumeric(String paramString)
  {
    return Pattern.compile("[0-9]*").matcher(paramString).matches();
  }

  public static final boolean isValidPath(String paramString)
  {
    if (paramString == null);
    File localFile;
    do
    {
      return false;
      localFile = new File(paramString);
    }
    while ((localFile == null) || (!localFile.exists()));
    return true;
  }

  public static final boolean isValidUrl(String paramString)
  {
    if (paramString == null);
    do
      return false;
    while ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")));
    return true;
  }

  public static void logd(String paramString1, String paramString2)
  {
    if (h)
      f.b(paramString1, paramString2);
  }

  public static boolean openBrowser(Context paramContext, String paramString)
  {
    try
    {
      boolean bool2 = a(paramContext);
      bool1 = bool2;
      if (bool1);
      try
      {
        a(paramContext, "com.tencent.mtt", "com.tencent.mtt.MainActivity", paramString);
        break label136;
        a(paramContext, "com.android.browser", "com.android.browser.BrowserActivity", paramString);
      }
      catch (Exception localException7)
      {
      }
      if (bool1)
        try
        {
          a(paramContext, "com.android.browser", "com.android.browser.BrowserActivity", paramString);
        }
        catch (Exception localException4)
        {
          try
          {
            a(paramContext, "com.google.android.browser", "com.android.browser.BrowserActivity", paramString);
          }
          catch (Exception localException5)
          {
            try
            {
              a(paramContext, "com.android.chrome", "com.google.android.apps.chrome.Main", paramString);
            }
            catch (Exception localException6)
            {
              return false;
            }
          }
        }
      else
        try
        {
          a(paramContext, "com.google.android.browser", "com.android.browser.BrowserActivity", paramString);
        }
        catch (Exception localException2)
        {
          try
          {
            a(paramContext, "com.android.chrome", "com.google.android.apps.chrome.Main", paramString);
          }
          catch (Exception localException3)
          {
            return false;
          }
        }
    }
    catch (Exception localException1)
    {
      while (true)
        boolean bool1 = false;
    }
    label136: return true;
  }

  public static int parseIntValue(String paramString)
  {
    return parseIntValue(paramString, 0);
  }

  public static int parseIntValue(String paramString, int paramInt)
  {
    try
    {
      int j = Integer.parseInt(paramString);
      return j;
    }
    catch (Exception localException)
    {
    }
    return paramInt;
  }

  public static JSONObject parseJson(String paramString)
    throws JSONException
  {
    if (paramString.equals("false"))
      paramString = "{value : false}";
    if (paramString.equals("true"))
      paramString = "{value : true}";
    if (paramString.contains("allback("))
      paramString = paramString.replaceFirst("[\\s\\S]*allback\\(([\\s\\S]*)\\);[^\\)]*\\z", "$1").trim();
    if (paramString.contains("online[0]="))
      paramString = "{online:" + paramString.charAt(-2 + paramString.length()) + "}";
    return new JSONObject(paramString);
  }

  public static Bundle parseUrl(String paramString)
  {
    String str = paramString.replace("auth://", "http://");
    try
    {
      URL localURL = new URL(str);
      Bundle localBundle = decodeUrl(localURL.getQuery());
      localBundle.putAll(decodeUrl(localURL.getRef()));
      return localBundle;
    }
    catch (MalformedURLException localMalformedURLException)
    {
    }
    return new Bundle();
  }

  public static JSONObject parseUrlToJson(String paramString)
  {
    String str = paramString.replace("auth://", "http://");
    try
    {
      URL localURL = new URL(str);
      JSONObject localJSONObject = decodeUrlToJson(null, localURL.getQuery());
      decodeUrlToJson(localJSONObject, localURL.getRef());
      return localJSONObject;
    }
    catch (MalformedURLException localMalformedURLException)
    {
    }
    return new JSONObject();
  }

  public static void reportBernoulli(Context paramContext, String paramString1, long paramLong, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("appid_for_getting_config", paramString2);
    localBundle.putString("strValue", paramString2);
    localBundle.putString("nValue", paramString1);
    localBundle.putString("qver", "2.8.lite");
    if (paramLong != 0L)
      localBundle.putLong("elt", paramLong);
    new Util.1(paramContext, localBundle).start();
  }

  public static void showAlert(Context paramContext, String paramString1, String paramString2)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramContext);
    localBuilder.setTitle(paramString1);
    localBuilder.setMessage(paramString2);
    localBuilder.create().show();
  }

  // ERROR //
  public static final String subString(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: invokestatic 803	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifeq +8 -> 15
    //   10: ldc 46
    //   12: astore_0
    //   13: aload_0
    //   14: areturn
    //   15: aload_2
    //   16: invokestatic 803	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   19: ifne +158 -> 177
    //   22: aload_0
    //   23: aload_2
    //   24: invokevirtual 497	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   27: arraylength
    //   28: iload_1
    //   29: if_icmple -16 -> 13
    //   32: iconst_0
    //   33: istore 6
    //   35: iload 4
    //   37: aload_0
    //   38: invokevirtual 556	java/lang/String:length	()I
    //   41: if_icmpge -28 -> 13
    //   44: aload_0
    //   45: iload 4
    //   47: iload 4
    //   49: iconst_1
    //   50: iadd
    //   51: invokevirtual 553	java/lang/String:substring	(II)Ljava/lang/String;
    //   54: aload_2
    //   55: invokevirtual 497	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   58: arraylength
    //   59: istore 7
    //   61: iload 6
    //   63: iload 7
    //   65: iadd
    //   66: iload_1
    //   67: if_icmple +51 -> 118
    //   70: aload_0
    //   71: iconst_0
    //   72: iload 4
    //   74: invokevirtual 553	java/lang/String:substring	(II)Ljava/lang/String;
    //   77: astore 8
    //   79: aload 8
    //   81: astore 9
    //   83: aload_3
    //   84: invokestatic 803	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   87: ifne +28 -> 115
    //   90: new 20	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   97: aload 9
    //   99: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_3
    //   103: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: astore 11
    //   111: aload 11
    //   113: astore 9
    //   115: aload 9
    //   117: areturn
    //   118: iload 6
    //   120: iload 7
    //   122: iadd
    //   123: istore 6
    //   125: iinc 4 1
    //   128: goto -93 -> 35
    //   131: astore 5
    //   133: getstatic 809	java/lang/System:out	Ljava/io/PrintStream;
    //   136: new 20	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   143: ldc_w 811
    //   146: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload 5
    //   151: invokevirtual 562	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   154: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokevirtual 816	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   163: aload_0
    //   164: areturn
    //   165: astore 10
    //   167: aload 9
    //   169: astore_0
    //   170: aload 10
    //   172: astore 5
    //   174: goto -41 -> 133
    //   177: ldc 126
    //   179: astore_2
    //   180: goto -158 -> 22
    //
    // Exception table:
    //   from	to	target	type
    //   22	32	131	java/lang/Exception
    //   35	61	131	java/lang/Exception
    //   70	79	131	java/lang/Exception
    //   83	111	165	java/lang/Exception
  }

  public static String toHexString(String paramString)
  {
    byte[] arrayOfByte = getBytesUTF8(paramString);
    StringBuilder localStringBuilder = new StringBuilder(2 * arrayOfByte.length);
    for (int j = 0; j < arrayOfByte.length; j++)
    {
      localStringBuilder.append(i.charAt((0xF0 & arrayOfByte[j]) >> 4));
      localStringBuilder.append(i.charAt((0xF & arrayOfByte[j]) >> 0));
    }
    return localStringBuilder.toString();
  }

  public static String toHexString(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
      return null;
    StringBuilder localStringBuilder = new StringBuilder(2 * paramArrayOfByte.length);
    for (int j = 0; j < paramArrayOfByte.length; j++)
    {
      String str = Integer.toString(0xFF & paramArrayOfByte[j], 16);
      if (str.length() == 1)
        str = "0" + str;
      localStringBuilder.append(str);
    }
    return localStringBuilder.toString();
  }

  public static Statistic upload(Context paramContext, String paramString, Bundle paramBundle)
    throws MalformedURLException, IOException, HttpUtils.NetworkUnavailableException, HttpUtils.HttpStatusException
  {
    if (paramContext != null)
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localConnectivityManager != null)
      {
        NetworkInfo localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
        if ((localNetworkInfo == null) || (!localNetworkInfo.isAvailable()))
          throw new HttpUtils.NetworkUnavailableException("network unavailable");
      }
    }
    Bundle localBundle1 = new Bundle(paramBundle);
    String str1 = localBundle1.getString("appid_for_getting_config");
    localBundle1.remove("appid_for_getting_config");
    HttpClient localHttpClient = HttpUtils.getHttpClient(paramContext, str1, paramString);
    HttpPost localHttpPost = new HttpPost(paramString);
    Bundle localBundle2 = new Bundle();
    Iterator localIterator1 = localBundle1.keySet().iterator();
    while (localIterator1.hasNext())
    {
      String str3 = (String)localIterator1.next();
      Object localObject = localBundle1.get(str3);
      if (!(localObject instanceof byte[]))
        continue;
      localBundle2.putByteArray(str3, (byte[])(byte[])localObject);
    }
    localHttpPost.setHeader("Content-Type", "multipart/form-data; boundary=3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f");
    localHttpPost.setHeader("Connection", "Keep-Alive");
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    localByteArrayOutputStream.write(getBytesUTF8("--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
    localByteArrayOutputStream.write(getBytesUTF8(encodePostBody(localBundle1, "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f")));
    if (!localBundle2.isEmpty())
    {
      int m = localBundle2.size();
      localByteArrayOutputStream.write(getBytesUTF8("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
      Iterator localIterator2 = localBundle2.keySet().iterator();
      int n = -1;
      while (localIterator2.hasNext())
      {
        String str2 = (String)localIterator2.next();
        n++;
        localByteArrayOutputStream.write(getBytesUTF8("Content-Disposition: form-data; name=\"" + str2 + "\"; filename=\"" + "value.file" + "\"" + "\r\n"));
        localByteArrayOutputStream.write(getBytesUTF8("Content-Type: application/octet-stream\r\n\r\n"));
        byte[] arrayOfByte2 = localBundle2.getByteArray(str2);
        if (arrayOfByte2 != null)
          localByteArrayOutputStream.write(arrayOfByte2);
        if (n >= m - 1)
          continue;
        localByteArrayOutputStream.write(getBytesUTF8("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
      }
    }
    localByteArrayOutputStream.write(getBytesUTF8("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f--\r\n"));
    byte[] arrayOfByte1 = localByteArrayOutputStream.toByteArray();
    int j = 0 + arrayOfByte1.length;
    localByteArrayOutputStream.close();
    localHttpPost.setEntity(new ByteArrayEntity(arrayOfByte1));
    HttpResponse localHttpResponse = localHttpClient.execute(localHttpPost);
    int k = localHttpResponse.getStatusLine().getStatusCode();
    if (k == 200)
      return new Statistic(a(localHttpResponse), j);
    throw new HttpUtils.HttpStatusException("http status code error:" + k);
  }

  public static class Statistic
  {
    public long reqSize;
    public String response;
    public long rspSize;

    public Statistic(String paramString, int paramInt)
    {
      this.response = paramString;
      this.reqSize = paramInt;
      if (this.response != null)
        this.rspSize = this.response.length();
    }
  }

  private static class TBufferedOutputStream extends BufferedOutputStream
  {
    private int a = 0;

    public TBufferedOutputStream(OutputStream paramOutputStream)
    {
      super();
    }

    public int getLength()
    {
      return this.a;
    }

    public void write(byte[] paramArrayOfByte)
      throws IOException
    {
      super.write(paramArrayOfByte);
      this.a += paramArrayOfByte.length;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.open.utils.Util
 * JD-Core Version:    0.6.0
 */