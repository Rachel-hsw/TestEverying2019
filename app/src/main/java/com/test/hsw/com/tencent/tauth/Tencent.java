package com.tencent.tauth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.tencent.connect.auth.QQAuth;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.share.QQShare;
import com.tencent.connect.share.QzoneShare;
import com.tencent.open.SocialApi;
import com.tencent.open.a.f;
import com.tencent.open.utils.Global;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.HttpUtils.HttpStatusException;
import com.tencent.open.utils.HttpUtils.NetworkUnavailableException;
import com.tencent.open.utils.SystemUtils;
import com.tencent.open.utils.TemporaryStorage;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class Tencent
{
  private static Tencent sInstance;
  private final QQAuth mQQAuth;

  private Tencent(String paramString, Context paramContext)
  {
    Global.setContext(paramContext.getApplicationContext());
    this.mQQAuth = QQAuth.createInstance(paramString, paramContext);
  }

  // ERROR //
  private static boolean checkManifestConfig(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 39	android/content/ComponentName
    //   3: dup
    //   4: aload_0
    //   5: invokevirtual 43	android/content/Context:getPackageName	()Ljava/lang/String;
    //   8: ldc 45
    //   10: invokespecial 48	android/content/ComponentName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   13: astore_2
    //   14: aload_0
    //   15: invokevirtual 52	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   18: aload_2
    //   19: iconst_0
    //   20: invokevirtual 58	android/content/pm/PackageManager:getActivityInfo	(Landroid/content/ComponentName;I)Landroid/content/pm/ActivityInfo;
    //   23: pop
    //   24: new 39	android/content/ComponentName
    //   27: dup
    //   28: aload_0
    //   29: invokevirtual 43	android/content/Context:getPackageName	()Ljava/lang/String;
    //   32: ldc 60
    //   34: invokespecial 48	android/content/ComponentName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: astore 6
    //   39: aload_0
    //   40: invokevirtual 52	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   43: aload 6
    //   45: iconst_0
    //   46: invokevirtual 58	android/content/pm/PackageManager:getActivityInfo	(Landroid/content/ComponentName;I)Landroid/content/pm/ActivityInfo;
    //   49: pop
    //   50: iconst_1
    //   51: ireturn
    //   52: astore_3
    //   53: new 62	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   60: ldc 65
    //   62: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: aload_1
    //   66: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: ldc 71
    //   71: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: astore 4
    //   79: ldc 76
    //   81: new 62	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   88: aload 4
    //   90: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: ldc 78
    //   95: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: aload_1
    //   99: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: ldc 80
    //   104: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: ldc 82
    //   109: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: ldc 84
    //   114: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 89	com/tencent/open/a/f:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   123: iconst_0
    //   124: ireturn
    //   125: astore 7
    //   127: ldc 91
    //   129: new 62	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   136: ldc 93
    //   138: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: ldc 95
    //   143: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 89	com/tencent/open/a/f:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   152: iconst_0
    //   153: ireturn
    //
    // Exception table:
    //   from	to	target	type
    //   0	24	52	android/content/pm/PackageManager$NameNotFoundException
    //   24	50	125	android/content/pm/PackageManager$NameNotFoundException
  }

  public static Tencent createInstance(String paramString, Context paramContext)
  {
    monitorenter;
    while (true)
    {
      try
      {
        f.a(f.d, "createInstance()  -- start");
        if (sInstance != null)
          continue;
        sInstance = new Tencent(paramString, paramContext);
        boolean bool = checkManifestConfig(paramContext, paramString);
        if (!bool)
        {
          localTencent = null;
          return localTencent;
          if (paramString.equals(sInstance.getAppId()))
            continue;
          sInstance.logout(paramContext);
          sInstance = new Tencent(paramString, paramContext);
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      f.a(f.d, "createInstance()  -- end");
      Tencent localTencent = sInstance;
    }
  }

  public static void handleResultData(Intent paramIntent, IUiListener paramIUiListener)
  {
    BaseApi.handleDataToListener(paramIntent, paramIUiListener);
  }

  public int ask(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener)
  {
    new SocialApi(this.mQQAuth.getQQToken()).ask(paramActivity, paramBundle, paramIUiListener);
    return 0;
  }

  public void checkLogin(IUiListener paramIUiListener)
  {
    this.mQQAuth.checkLogin(paramIUiListener);
  }

  public String getAccessToken()
  {
    return this.mQQAuth.getQQToken().getAccessToken();
  }

  public String getAppId()
  {
    return this.mQQAuth.getQQToken().getAppId();
  }

  public long getExpiresIn()
  {
    return this.mQQAuth.getQQToken().getExpireTimeInSecond();
  }

  public String getOpenId()
  {
    return this.mQQAuth.getQQToken().getOpenId();
  }

  public QQToken getQQToken()
  {
    return this.mQQAuth.getQQToken();
  }

  public int gift(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener)
  {
    new SocialApi(this.mQQAuth.getQQToken()).gift(paramActivity, paramBundle, paramIUiListener);
    return 0;
  }

  @Deprecated
  public void handleLoginData(Intent paramIntent, IUiListener paramIUiListener)
  {
    BaseApi.handleDataToListener(paramIntent, paramIUiListener);
  }

  public int invite(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener)
  {
    new SocialApi(this.mQQAuth.getQQToken()).invite(paramActivity, paramBundle, paramIUiListener);
    return 0;
  }

  public boolean isReady()
  {
    return (isSessionValid()) && (getOpenId() != null);
  }

  public boolean isSessionValid()
  {
    return this.mQQAuth.isSessionValid();
  }

  public boolean isSupportSSOLogin(Activity paramActivity)
  {
    if (SystemUtils.getAppVersionName(paramActivity, "com.tencent.mobileqq") == null)
      return false;
    return SystemUtils.checkMobileQQ(paramActivity);
  }

  public int login(Activity paramActivity, String paramString, IUiListener paramIUiListener)
  {
    return this.mQQAuth.login(paramActivity, paramString, paramIUiListener);
  }

  public int login(Fragment paramFragment, String paramString, IUiListener paramIUiListener)
  {
    return this.mQQAuth.login(paramFragment, paramString, paramIUiListener, "");
  }

  public int loginWithOEM(Activity paramActivity, String paramString1, IUiListener paramIUiListener, String paramString2, String paramString3, String paramString4)
  {
    return this.mQQAuth.loginWithOEM(paramActivity, paramString1, paramIUiListener, paramString2, paramString3, paramString4);
  }

  public void logout(Context paramContext)
  {
    this.mQQAuth.getQQToken().setAccessToken(null, "0");
    this.mQQAuth.getQQToken().setOpenId(null);
  }

  public boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    return false;
  }

  public int reAuth(Activity paramActivity, String paramString, IUiListener paramIUiListener)
  {
    return this.mQQAuth.reAuth(paramActivity, paramString, paramIUiListener);
  }

  public void releaseResource()
  {
    TemporaryStorage.remove("shareToQQ");
    TemporaryStorage.remove("shareToQzone");
    TemporaryStorage.remove("sendToMyComputer");
    TemporaryStorage.remove("addToQQFavorites");
    TemporaryStorage.remove("shareToTroopBar");
  }

  public void reportDAU()
  {
    this.mQQAuth.reportDAU();
  }

  public JSONObject request(String paramString1, Bundle paramBundle, String paramString2)
    throws IOException, JSONException, HttpUtils.NetworkUnavailableException, HttpUtils.HttpStatusException
  {
    return HttpUtils.request(this.mQQAuth.getQQToken(), Global.getContext(), paramString1, paramBundle, paramString2);
  }

  public void requestAsync(String paramString1, Bundle paramBundle, String paramString2, IRequestListener paramIRequestListener, Object paramObject)
  {
    HttpUtils.requestAsync(this.mQQAuth.getQQToken(), Global.getContext(), paramString1, paramBundle, paramString2, paramIRequestListener);
  }

  public void setAccessToken(String paramString1, String paramString2)
  {
    f.a(f.d, "setAccessToken(), expiresIn = " + paramString2 + "");
    this.mQQAuth.setAccessToken(paramString1, paramString2);
  }

  public void setOpenId(String paramString)
  {
    f.a(f.d, "setOpenId() --start");
    this.mQQAuth.setOpenId(Global.getContext(), paramString);
    f.a(f.d, "setOpenId() --end");
  }

  public void shareToQQ(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener)
  {
    new QQShare(paramActivity, this.mQQAuth.getQQToken()).shareToQQ(paramActivity, paramBundle, paramIUiListener);
  }

  public void shareToQzone(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener)
  {
    new QzoneShare(paramActivity, this.mQQAuth.getQQToken()).shareToQzone(paramActivity, paramBundle, paramIUiListener);
  }

  public int story(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener)
  {
    new SocialApi(this.mQQAuth.getQQToken()).story(paramActivity, paramBundle, paramIUiListener);
    return 0;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.tauth.Tencent
 * JD-Core Version:    0.6.0
 */