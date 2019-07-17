package com.tencent.connect.auth;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import android.widget.Toast;
import com.tencent.connect.a.a;
import com.tencent.open.a.f;
import com.tencent.open.utils.ApkExternalInfoTool;
import com.tencent.open.utils.Global;
import com.tencent.tauth.IUiListener;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class QQAuth
{
  private AuthAgent a;
  private QQToken b;

  private QQAuth(String paramString, Context paramContext)
  {
    f.c(f.d, "new QQAuth() --start");
    this.b = new QQToken(paramString);
    this.a = new AuthAgent(this.b);
    a.c(paramContext, this.b);
    f.c(f.d, "new QQAuth() --end");
  }

  private int a(Activity paramActivity, Fragment paramFragment, String paramString1, IUiListener paramIUiListener, String paramString2)
  {
    String str1 = paramActivity.getApplicationContext().getPackageName();
    Iterator localIterator = paramActivity.getPackageManager().getInstalledApplications(128).iterator();
    ApplicationInfo localApplicationInfo;
    do
    {
      if (!localIterator.hasNext())
        break;
      localApplicationInfo = (ApplicationInfo)localIterator.next();
    }
    while (!str1.equals(localApplicationInfo.packageName));
    for (String str2 = localApplicationInfo.sourceDir; ; str2 = null)
    {
      if (str2 != null)
        try
        {
          String str3 = ApkExternalInfoTool.readChannelId(new File(str2));
          if (!TextUtils.isEmpty(str3))
          {
            f.b(f.d, "-->login channelId: " + str3);
            int i = loginWithOEM(paramActivity, paramString1, paramIUiListener, str3, str3, "");
            return i;
          }
        }
        catch (IOException localIOException)
        {
          f.b(f.d, "-->login get channel id exception." + localIOException.getMessage());
          localIOException.printStackTrace();
        }
      f.b(f.d, "-->login channelId is null ");
      com.tencent.connect.common.BaseApi.isOEM = false;
      return this.a.doLogin(paramActivity, paramString1, paramIUiListener, false, paramFragment);
    }
  }

  public static QQAuth createInstance(String paramString, Context paramContext)
  {
    Global.setContext(paramContext.getApplicationContext());
    f.c(f.d, "QQAuth -- createInstance() --start");
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      localPackageManager.getActivityInfo(new ComponentName(paramContext.getPackageName(), "com.tencent.tauth.AuthActivity"), 0);
      localPackageManager.getActivityInfo(new ComponentName(paramContext.getPackageName(), "com.tencent.connect.common.AssistActivity"), 0);
      QQAuth localQQAuth = new QQAuth(paramString, paramContext);
      f.c(f.d, "QQAuth -- createInstance()  --end");
      return localQQAuth;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      f.b(f.d, "createInstance() error --end", localNameNotFoundException);
      Toast.makeText(paramContext.getApplicationContext(), "请参照文档在Androidmanifest.xml加上AuthActivity和AssitActivity的定义 ", 1).show();
    }
    return null;
  }

  public void checkLogin(IUiListener paramIUiListener)
  {
    this.a.b(paramIUiListener);
  }

  public QQToken getQQToken()
  {
    return this.b;
  }

  public boolean isSessionValid()
  {
    String str1 = f.d;
    StringBuilder localStringBuilder = new StringBuilder().append("isSessionValid(), result = ");
    if (this.b.isSessionValid());
    for (String str2 = "true"; ; str2 = "false")
    {
      f.a(str1, str2 + "");
      return this.b.isSessionValid();
    }
  }

  public int login(Activity paramActivity, String paramString, IUiListener paramIUiListener)
  {
    f.c(f.d, "login()");
    return login(paramActivity, paramString, paramIUiListener, "");
  }

  public int login(Activity paramActivity, String paramString1, IUiListener paramIUiListener, String paramString2)
  {
    f.c(f.d, "-->login activity: " + paramActivity);
    return a(paramActivity, null, paramString1, paramIUiListener, paramString2);
  }

  public int login(Fragment paramFragment, String paramString1, IUiListener paramIUiListener, String paramString2)
  {
    FragmentActivity localFragmentActivity = paramFragment.getActivity();
    f.c(f.d, "-->login activity: " + localFragmentActivity);
    return a(localFragmentActivity, paramFragment, paramString1, paramIUiListener, paramString2);
  }

  @Deprecated
  public int loginWithOEM(Activity paramActivity, String paramString1, IUiListener paramIUiListener, String paramString2, String paramString3, String paramString4)
  {
    f.c(f.d, "loginWithOEM");
    com.tencent.connect.common.BaseApi.isOEM = true;
    if (paramString2.equals(""))
      paramString2 = "null";
    if (paramString3.equals(""))
      paramString3 = "null";
    if (paramString4.equals(""))
      paramString4 = "null";
    com.tencent.connect.common.BaseApi.installChannel = paramString3;
    com.tencent.connect.common.BaseApi.registerChannel = paramString2;
    com.tencent.connect.common.BaseApi.businessId = paramString4;
    return this.a.doLogin(paramActivity, paramString1, paramIUiListener);
  }

  public void logout(Context paramContext)
  {
    f.c(f.d, "logout() --start");
    CookieSyncManager.createInstance(paramContext);
    setAccessToken(null, null);
    setOpenId(paramContext, null);
    f.c(f.d, "logout() --end");
  }

  public boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    f.c(f.d, "onActivityResult() ,resultCode = " + paramInt2 + "");
    return true;
  }

  public int reAuth(Activity paramActivity, String paramString, IUiListener paramIUiListener)
  {
    f.c(f.d, "reAuth()");
    return this.a.doLogin(paramActivity, paramString, paramIUiListener, true, null);
  }

  public void reportDAU()
  {
    this.a.a(null);
  }

  public void setAccessToken(String paramString1, String paramString2)
  {
    f.a(f.d, "setAccessToken(), validTimeInSecond = " + paramString2 + "");
    this.b.setAccessToken(paramString1, paramString2);
  }

  public void setOpenId(Context paramContext, String paramString)
  {
    f.a(f.d, "setOpenId() --start");
    this.b.setOpenId(paramString);
    a.d(paramContext, this.b);
    f.a(f.d, "setOpenId() --end");
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.connect.auth.QQAuth
 * JD-Core Version:    0.6.0
 */