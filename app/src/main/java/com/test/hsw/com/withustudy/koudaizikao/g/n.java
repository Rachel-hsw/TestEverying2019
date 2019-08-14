package com.withustudy.koudaizikao.g;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.b;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.a;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.a.a.a.v;

public class n
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final String d = "PULL_FROM_START";
  public static final String e = "PULL_FROM_END";
  private static Animation f;

  public static float a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    double d1 = 180.0D * Math.atan(Math.abs(paramInt1 - paramInt3) / Math.abs(paramInt2 - paramInt4)) / 3.141592653589793D;
    if (paramInt1 <= paramInt3)
      if (paramInt2 > paramInt4)
        d1 = 180.0D - d1;
    while (true)
    {
      return (float)Math.round(d1);
      if (paramInt2 >= paramInt4)
      {
        d1 += 180.0D;
        continue;
      }
      d1 = 360.0D - d1;
    }
  }

  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(0.5F + paramFloat * paramContext.getResources().getDisplayMetrics().density);
  }

  public static Bitmap a(Drawable paramDrawable)
  {
    if (paramDrawable == null)
      return null;
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    if (paramDrawable.getOpacity() != -1);
    for (Bitmap.Config localConfig = Bitmap.Config.ARGB_8888; ; localConfig = Bitmap.Config.RGB_565)
    {
      Bitmap localBitmap = Bitmap.createBitmap(i, j, localConfig);
      Canvas localCanvas = new Canvas(localBitmap);
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
      paramDrawable.draw(localCanvas);
      return localBitmap;
    }
  }

  public static Bitmap a(byte[] paramArrayOfByte, BitmapFactory.Options paramOptions)
  {
    if (paramArrayOfByte != null)
    {
      if (paramOptions != null)
        return BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, paramOptions);
      return BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    return null;
  }

  public static String a()
  {
    switch (Build.VERSION.SDK_INT)
    {
    default:
      return "android_";
    case 1:
      return "android_" + "1.0";
    case 2:
      return "android_" + "1.1";
    case 3:
      return "android_" + "1.5";
    case 4:
      return "android_" + "1.6";
    case 5:
      return "android_" + "2.0";
    case 6:
      return "android_" + "2.0.1";
    case 7:
      return "android_" + "2.1";
    case 8:
      return "android_" + "2.2";
    case 9:
      return "android_" + "2.3";
    case 10:
      return "android_" + "2.3.3";
    case 11:
      return "android_" + "3.0";
    case 12:
      return "android_" + "3.1";
    case 13:
      return "android_" + "3.2";
    case 14:
      return "android_" + "4.0";
    case 15:
      return "android_" + "4.0.2";
    case 16:
      return "android_" + "4.1";
    case 17:
      return "android_" + "4.2";
    case 18:
      return "android_" + "4.3";
    case 19:
      return "android_" + "4.4";
    case 20:
      return "android_" + "4.4";
    case 21:
      return "android_" + "5.0";
    case 22:
      return "android_" + "5.1";
    case 23:
    }
    return "android_" + "6.0";
  }

  public static String a(int paramInt)
  {
    if (paramInt < 1000)
      return paramInt + "m";
    int i = (int)Math.round(10.0D * paramInt / 1000.0D);
    if (i > 9999)
      return i / 10 + "km";
    if (i % 10 == 0)
      return i / 10 + "km";
    return i / 10.0D + "km";
  }

  public static String a(String paramString)
  {
    if (paramString == null)
      return "";
    try
    {
      String str = URLEncoder.encode(paramString, "UTF-8").replace("+", "%20").replace("*", "%2A").replace("%7E", "~").replace("#", "%23");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    throw new RuntimeException(localUnsupportedEncodingException.getMessage(), localUnsupportedEncodingException);
  }

  public static String a(String paramString1, String paramString2)
  {
    return "<font        color=\"" + paramString2 + "\">" + paramString1 + "</font>";
  }

  public static String a(String paramString1, String paramString2, String paramString3)
  {
    return "<font      size=\"" + paramString3 + "\"   color=\"" + paramString2 + "\">" + paramString1 + "</font>";
  }

  public static String a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramBoolean)
      return "<font  color=\"" + paramString2 + "\">" + "<b>" + paramString1 + "</b>" + "</font>";
    return "<font color=\"" + paramString2 + "\">" + paramString1 + "</font>";
  }

  public static void a(View paramView)
  {
    if (f == null)
    {
      f = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
      f.setInterpolator(new LinearInterpolator());
      f.setRepeatCount(99);
      f.setDuration(1000L);
      f.setAnimationListener(null);
    }
    f.setAnimationListener(new o(paramView));
    paramView.startAnimation(f);
  }

  private static void a(PullToRefreshListView paramPullToRefreshListView, Context paramContext)
  {
    paramPullToRefreshListView.a(false, true).setPullLabel(paramContext.getResources().getString(2131165340));
    paramPullToRefreshListView.a(false, true).setReleaseLabel(paramContext.getResources().getString(2131165341));
    paramPullToRefreshListView.a(false, true).setRefreshingLabel(paramContext.getResources().getString(2131165342));
    paramPullToRefreshListView.a(true, false).setPullLabel(paramContext.getResources().getString(2131165337));
    paramPullToRefreshListView.a(true, false).setReleaseLabel(paramContext.getResources().getString(2131165338));
    paramPullToRefreshListView.a(true, false).setRefreshingLabel(paramContext.getResources().getString(2131165339));
  }

  public static void a(String paramString, PullToRefreshListView paramPullToRefreshListView, Context paramContext)
  {
    if (paramString.equals("PULL_FROM_START"))
      paramPullToRefreshListView.setMode(PullToRefreshBase.b.b);
    while (true)
    {
      ((ListView)paramPullToRefreshListView.getRefreshableView()).setSelector(2131034189);
      a(paramPullToRefreshListView, paramContext);
      return;
      paramPullToRefreshListView.setMode(PullToRefreshBase.b.c);
    }
  }

  public static void a(boolean paramBoolean, PullToRefreshListView paramPullToRefreshListView, Context paramContext)
  {
    if (paramBoolean)
      paramPullToRefreshListView.setMode(PullToRefreshBase.b.d);
    while (true)
    {
      ((ListView)paramPullToRefreshListView.getRefreshableView()).setSelector(2131034189);
      a(paramPullToRefreshListView, paramContext);
      return;
      paramPullToRefreshListView.setMode(PullToRefreshBase.b.a);
    }
  }

  public static boolean a(Context paramContext)
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    return (localNetworkInfo != null) && (localNetworkInfo.isConnectedOrConnecting());
  }

  public static byte[] a(Bitmap paramBitmap)
  {
    if (paramBitmap == null)
      return null;
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }

  public static int b(Context paramContext)
  {
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (localNetworkInfo == null)
        return 0;
      int j = localNetworkInfo.getType();
      if (j == 0)
      {
        String str = localNetworkInfo.getExtraInfo();
        if (v.a(str))
          break label89;
        boolean bool = str.toLowerCase().equals("cmnet");
        if (bool)
          i = 3;
      }
      while (true)
      {
        return i;
        i = 2;
        continue;
        if (j != 1)
          break;
        i = 1;
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        int i = 0;
        continue;
        label89: i = 0;
      }
    }
  }

  public static int b(Context paramContext, float paramFloat)
  {
    return (int)(0.5F + paramFloat / paramContext.getResources().getDisplayMetrics().density);
  }

  public static String b(String paramString1, String paramString2)
  {
    return "<font   color=\"" + paramString2 + "\">" + "<big>" + paramString1 + "</big>" + "</font>";
  }

  public static boolean b(String paramString)
  {
    return (paramString == null) || ("".equals(paramString.trim())) || ("null".equals(paramString));
  }

  public static String c(Context paramContext)
  {
    if (b(paramContext) == 1)
      return "WIFI";
    if (b(paramContext) == 2)
      return "WAP";
    if (b(paramContext) == 3)
      return "NET";
    return null;
  }

  public static String c(String paramString1, String paramString2)
  {
    return "<a font color=\"" + paramString2 + "\">" + paramString1 + "</a>";
  }

  public static boolean c(String paramString)
  {
    return paramString.matches("([1-9][0-9]{4})|([0-9]{6,10})");
  }

  public static String d(Context paramContext)
  {
    if (paramContext != null)
    {
      Object localObject = paramContext.getSystemService("phone");
      if (localObject != null)
      {
        TelephonyManager localTelephonyManager = (TelephonyManager)localObject;
        if (localTelephonyManager != null)
          return localTelephonyManager.getDeviceId();
      }
    }
    return "";
  }

  public static boolean d(String paramString)
  {
    return paramString.replace("（", "(").replace("）", ")").matches("^.+\\(.+\\-.+\\)$");
  }

  public static boolean e(String paramString)
  {
    return Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$").matcher(paramString).matches();
  }

  public static String f(String paramString)
  {
    return "<b>" + paramString + "</b>";
  }

  public static boolean g(String paramString)
  {
    return Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$").matcher(paramString).find();
  }

  public static boolean h(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString.trim())))
      return false;
    String str = paramString.toLowerCase().trim();
    for (int i = 0; ; i++)
    {
      if (i >= str.length())
        return true;
      if ("0123456789,+".indexOf(str.charAt(i)) == -1)
        break;
    }
  }

  public static boolean i(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return false;
    return paramString.matches("[1][3578]\\d{9}");
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.g.n
 * JD-Core Version:    0.6.0
 */