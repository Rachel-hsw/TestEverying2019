package com.tencent.open;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import com.tencent.connect.auth.QQAuth;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.open.a.f;
import com.tencent.open.c.b;
import com.tencent.open.utils.Global;
import com.tencent.open.utils.OpenConfig;
import com.tencent.open.utils.ServerSetting;
import com.tencent.open.utils.SystemUtils;
import com.tencent.open.utils.Util;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import org.json.JSONException;
import org.json.JSONObject;

public class SocialApiIml extends BaseApi
{
  private static final String a = SocialApiIml.class.getName();
  private Activity b;

  public SocialApiIml(QQAuth paramQQAuth, QQToken paramQQToken)
  {
    super(paramQQAuth, paramQQToken);
  }

  public SocialApiIml(QQToken paramQQToken)
  {
    super(paramQQToken);
  }

  private void a(Activity paramActivity, Intent paramIntent, String paramString, Bundle paramBundle, IUiListener paramIUiListener)
  {
    f.b(f.d, "-->handleIntentWithAgent " + paramString + " params=" + paramBundle + " activityIntent=" + paramIntent);
    paramIntent.putExtra("key_action", paramString);
    paramIntent.putExtra("key_params", paramBundle);
    this.mActivityIntent = paramIntent;
    startAssitActivity(paramActivity, paramIUiListener);
  }

  private void a(Activity paramActivity, Intent paramIntent, String paramString1, Bundle paramBundle, String paramString2, IUiListener paramIUiListener, boolean paramBoolean)
  {
    f.b(f.d, "-->handleIntent " + paramString1 + " params=" + paramBundle + " activityIntent=" + paramIntent);
    if (paramIntent != null)
    {
      a(paramActivity, paramIntent, paramString1, paramBundle, paramIUiListener);
      return;
    }
    OpenConfig localOpenConfig = OpenConfig.getInstance(Global.getContext(), this.mToken.getAppId());
    if ((paramBoolean) || (localOpenConfig.getBoolean("C_LoginH5")));
    for (int i = 1; i != 0; i = 0)
    {
      a(paramActivity, paramString1, paramBundle, paramString2, paramIUiListener);
      return;
    }
    handleDownloadLastestQQ(paramActivity, paramBundle, paramIUiListener);
  }

  private void a(Activity paramActivity, String paramString, Bundle paramBundle, IUiListener paramIUiListener)
  {
    this.b = paramActivity;
    Intent localIntent = getAgentIntentWithTarget("com.tencent.open.agent.SocialFriendChooser");
    if (localIntent == null)
      localIntent = getAgentIntentWithTarget("com.tencent.open.agent.RequestFreegiftActivity");
    paramBundle.putAll(composeActivityParams());
    if ("action_ask".equals(paramString))
      paramBundle.putString("type", "request");
    while (true)
    {
      a(paramActivity, localIntent, paramString, paramBundle, ServerSetting.getInstance().getEnvUrl(Global.getContext(), "http://qzs.qq.com/open/mobile/request/sdk_request.html?"), paramIUiListener, false);
      return;
      if (!"action_gift".equals(paramString))
        continue;
      paramBundle.putString("type", "freegift");
    }
  }

  private void a(Activity paramActivity, String paramString1, Bundle paramBundle, String paramString2, IUiListener paramIUiListener)
  {
    f.b(f.d, "-->handleIntentWithH5 " + paramString1 + " params=" + paramBundle);
    Intent localIntent1 = getTargetActivityIntent("com.tencent.open.agent.AgentActivity");
    a locala = new a(paramActivity, paramIUiListener, paramString1, paramString2, paramBundle);
    Intent localIntent2 = getTargetActivityIntent("com.tencent.open.agent.EncryTokenActivity");
    if ((localIntent2 != null) && (localIntent1 != null) && (localIntent1.getComponent() != null) && (localIntent2.getComponent() != null) && (localIntent1.getComponent().getPackageName().equals(localIntent2.getComponent().getPackageName())))
    {
      localIntent2.putExtra("oauth_consumer_key", this.mToken.getAppId());
      localIntent2.putExtra("openid", this.mToken.getOpenId());
      localIntent2.putExtra("access_token", this.mToken.getAccessToken());
      localIntent2.putExtra("key_action", "action_check_token");
      this.mActivityIntent = localIntent2;
      if (hasActivityForIntent())
        startAssitActivity(paramActivity, locala);
      return;
    }
    String str = Util.encrypt("tencent&sdk&qazxc***14969%%" + this.mToken.getAccessToken() + this.mToken.getAppId() + this.mToken.getOpenId() + "qzone3.4");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("encry_token", str);
      locala.onComplete(localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      while (true)
        localJSONException.printStackTrace();
    }
  }

  private void a(Context paramContext, String paramString1, Bundle paramBundle, String paramString2, IUiListener paramIUiListener)
  {
    f.a(f.d, "OpenUi, showDialog --start");
    CookieSyncManager.createInstance(paramContext);
    paramBundle.putString("oauth_consumer_key", this.mToken.getAppId());
    if (this.mToken.isSessionValid())
      paramBundle.putString("access_token", this.mToken.getAccessToken());
    String str1 = this.mToken.getOpenId();
    if (str1 != null)
      paramBundle.putString("openid", str1);
    try
    {
      paramBundle.putString("pf", Global.getContext().getSharedPreferences("pfStore", 0).getString("pf", "openmobile_android"));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append(Util.encodeUrl(paramBundle));
      str2 = localStringBuilder.toString();
      f.b(f.d, "OpenUi, showDialog TDialog");
      if (("action_challenge".equals(paramString1)) || ("action_brag".equals(paramString1)))
      {
        f.b(f.d, "OpenUi, showDialog PKDialog");
        new PKDialog(this.b, paramString1, str2, paramIUiListener, this.mToken).show();
        return;
      }
    }
    catch (Exception localException)
    {
      String str2;
      while (true)
      {
        localException.printStackTrace();
        paramBundle.putString("pf", "openmobile_android");
      }
      new TDialog(this.b, paramString1, str2, paramIUiListener, this.mToken).show();
    }
  }

  public void ask(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener)
  {
    a(paramActivity, "action_ask", paramBundle, paramIUiListener);
  }

  protected Intent getTargetActivityIntent(String paramString)
  {
    Object localObject = new Intent();
    ((Intent)localObject).setClassName("com.qzone", paramString);
    Intent localIntent = new Intent();
    localIntent.setClassName("com.tencent.mobileqq", paramString);
    if ((SystemUtils.isActivityExist(Global.getContext(), localIntent)) && (SystemUtils.compareQQVersion(Global.getContext(), "4.7") >= 0))
      localObject = localIntent;
    while (true)
    {
      return localObject;
      if ((!SystemUtils.isActivityExist(Global.getContext(), (Intent)localObject)) || (SystemUtils.compareVersion(SystemUtils.getAppVersionName(Global.getContext(), "com.qzone"), "4.2") < 0))
        break;
      if (!SystemUtils.isAppSignatureValid(Global.getContext(), ((Intent)localObject).getComponent().getPackageName(), "ec96e9ac1149251acbb1b0c5777cae95"))
        return null;
    }
    return (Intent)null;
  }

  public void gift(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener)
  {
    a(paramActivity, "action_gift", paramBundle, paramIUiListener);
  }

  public void invite(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener)
  {
    this.b = paramActivity;
    Intent localIntent = getAgentIntentWithTarget("com.tencent.open.agent.SocialFriendChooser");
    if (localIntent == null)
      localIntent = getAgentIntentWithTarget("com.tencent.open.agent.AppInvitationActivity");
    paramBundle.putAll(composeActivityParams());
    a(paramActivity, localIntent, "action_invite", paramBundle, ServerSetting.getInstance().getEnvUrl(Global.getContext(), "http://qzs.qq.com/open/mobile/invite/sdk_invite.html?"), paramIUiListener, false);
  }

  public void story(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener)
  {
    this.b = paramActivity;
    Intent localIntent = getAgentIntentWithTarget("com.tencent.open.agent.SendStoryActivity");
    paramBundle.putAll(composeActivityParams());
    a(paramActivity, localIntent, "action_story", paramBundle, ServerSetting.getInstance().getEnvUrl(Global.getContext(), "http://qzs.qq.com/open/mobile/sendstory/sdk_sendstory_v1.3.html?"), paramIUiListener, false);
  }

  @SuppressLint({"SetJavaScriptEnabled"})
  public void writeEncryToken(Context paramContext)
  {
    String str1 = this.mToken.getAccessToken();
    String str2 = this.mToken.getAppId();
    String str3 = this.mToken.getOpenId();
    if ((str1 != null) && (str1.length() > 0) && (str2 != null) && (str2.length() > 0) && (str3 != null) && (str3.length() > 0));
    for (String str4 = Util.encrypt("tencent&sdk&qazxc***14969%%" + str1 + str2 + str3 + "qzone3.4"); ; str4 = null)
    {
      b localb = new b(paramContext);
      WebSettings localWebSettings = localb.getSettings();
      localWebSettings.setDomStorageEnabled(true);
      localWebSettings.setJavaScriptEnabled(true);
      localWebSettings.setDatabaseEnabled(true);
      String str5 = "<!DOCTYPE HTML><html lang=\"en-US\"><head><meta charset=\"UTF-8\"><title>localStorage Test</title><script type=\"text/javascript\">document.domain = 'qq.com';localStorage[\"" + this.mToken.getOpenId() + "_" + this.mToken.getAppId() + "\"]=\"" + str4 + "\";</script></head><body></body></html>";
      String str6 = ServerSetting.getInstance().getEnvUrl(paramContext, "http://qzs.qq.com");
      localb.loadDataWithBaseURL(str6, str5, "text/html", "utf-8", str6);
      return;
    }
  }

  private class a
    implements IUiListener
  {
    private IUiListener b;
    private String c;
    private String d;
    private Bundle e;
    private Activity f;

    a(Activity paramIUiListener, IUiListener paramString1, String paramString2, String paramBundle, Bundle arg6)
    {
      this.b = paramString1;
      this.c = paramString2;
      this.d = paramBundle;
      Object localObject;
      this.e = localObject;
    }

    public void onCancel()
    {
      this.b.onCancel();
    }

    public void onComplete(Object paramObject)
    {
      JSONObject localJSONObject = (JSONObject)paramObject;
      try
      {
        String str2 = localJSONObject.getString("encry_token");
        str1 = str2;
        this.e.putString("encrytoken", str1);
        SocialApiIml.a(SocialApiIml.this, SocialApiIml.a(SocialApiIml.this), this.c, this.e, this.d, this.b);
        if (TextUtils.isEmpty(str1))
        {
          f.b("miles", "The token get from qq or qzone is empty. Write temp token to localstorage.");
          SocialApiIml.this.writeEncryToken(this.f);
        }
        return;
      }
      catch (JSONException localJSONException)
      {
        while (true)
        {
          localJSONException.printStackTrace();
          f.b(f.d, "OpenApi, EncrytokenListener() onComplete error", localJSONException);
          String str1 = null;
        }
      }
    }

    public void onError(UiError paramUiError)
    {
      f.b(f.d, "OpenApi, EncryptTokenListener() onError" + paramUiError.errorMessage);
      this.b.onError(paramUiError);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.open.SocialApiIml
 * JD-Core Version:    0.6.0
 */