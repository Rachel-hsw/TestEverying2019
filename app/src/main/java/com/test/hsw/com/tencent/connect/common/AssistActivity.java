package com.tencent.connect.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.open.a.f;
import com.tencent.open.b.d;
import com.tencent.open.utils.TemporaryStorage;
import com.tencent.open.utils.Util;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import org.json.JSONObject;

public class AssistActivity extends Activity
{
  private static final String RESTART_FLAG = "RESTART_FLAG";
  private static final String TAG = "AssistActivity";
  public static boolean hackShareSend;
  public static boolean isQQMobileShare = false;
  private static BaseApi sApiObject;
  private BaseApi mAPiObject;

  static
  {
    hackShareSend = false;
  }

  public static Intent getAssistActivityIntent(Context paramContext)
  {
    return new Intent(paramContext, AssistActivity.class);
  }

  private void openBrowser(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("viaShareType");
    String str2 = paramBundle.getString("callbackAction");
    String str3 = paramBundle.getString("url");
    String str4 = paramBundle.getString("openId");
    String str5 = paramBundle.getString("appId");
    String str6 = "";
    String str7 = "";
    if ("shareToQQ".equals(str2))
    {
      str6 = "ANDROIDQQ.SHARETOQQ.XX";
      str7 = "10";
      if (Util.openBrowser(this, str3))
        break label164;
      IUiListener localIUiListener = (IUiListener)TemporaryStorage.get(str2);
      if (localIUiListener != null)
        localIUiListener.onError(new UiError(-6, "打开浏览器失败!", null));
      d.a().a(str4, str5, str6, str7, "3", "1", str1, "0", "2", "0");
      finish();
    }
    while (true)
    {
      getIntent().removeExtra("shareH5");
      return;
      if (!"shareToQzone".equals(str2))
        break;
      str6 = "ANDROIDQQ.SHARETOQZ.XX";
      str7 = "11";
      break;
      label164: d.a().a(str4, str5, str6, str7, "3", "0", str1, "0", "2", "0");
    }
  }

  public static void setApiObject(BaseApi paramBaseApi)
  {
    sApiObject = paramBaseApi;
  }

  public static void setResultDataForLogin(Activity paramActivity, Intent paramIntent)
  {
    if (paramIntent == null)
      paramActivity.setResult(10101, paramIntent);
    while (true)
    {
      return;
      try
      {
        String str1 = paramIntent.getStringExtra("key_response");
        f.b("AssistActivity", "AssistActivity--setResultDataForLogin-- " + str1);
        if (TextUtils.isEmpty(str1))
          continue;
        JSONObject localJSONObject = new JSONObject(str1);
        String str2 = localJSONObject.optString("openid");
        String str3 = localJSONObject.optString("access_token");
        if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)))
          break;
        paramActivity.setResult(10101, paramIntent);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
    paramActivity.setResult(12345, paramIntent);
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    f.b("AssistActivity", "AssistActivity--onActivityResult--" + paramInt2 + " data=" + paramIntent);
    f.b("AssistActivity", "--requestCode: " + paramInt1 + " | resultCode: " + paramInt2 + " | data: " + paramIntent);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 0)
    {
      if (!isFinishing())
        finish();
      return;
    }
    if (paramIntent != null)
      paramIntent.putExtra("key_action", "action_login");
    if (this.mAPiObject != null)
    {
      f.b("AssistActivity", "AssistActivity--onActivityResult-- mAPiObject != null");
      this.mAPiObject.onActivityResult(this, paramInt1, paramInt2, paramIntent);
    }
    while (true)
    {
      finish();
      return;
      f.b("AssistActivity", "AssistActivity--onActivityResult-- mAPiObject == null");
      setResultDataForLogin(this, paramIntent);
    }
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    f.b("AssistActivity", "AssistActivity--onCreate--");
    if (sApiObject == null)
      return;
    this.mAPiObject = sApiObject;
    sApiObject = null;
    Intent localIntent = this.mAPiObject.getActivityIntent();
    if (localIntent == null);
    Bundle localBundle;
    for (int i = 0; ; i = localIntent.getIntExtra("key_request_code", 0))
    {
      localBundle = getIntent().getBundleExtra("h5_share_data");
      boolean bool = false;
      if (paramBundle != null)
        bool = paramBundle.getBoolean("RESTART_FLAG");
      if (bool)
        break;
      if (localBundle != null)
        break label107;
      startActivityForResult(localIntent, i);
      return;
    }
    label107: openBrowser(localBundle);
  }

  protected void onDestroy()
  {
    f.b("AssistActivity", "-->onDestroy");
    super.onDestroy();
  }

  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    Object localObject = TemporaryStorage.get(paramIntent.getStringExtra("action"));
    StringBuilder localStringBuilder = new StringBuilder().append("AssistActivity--onNewIntent--");
    String str;
    if (localObject == null)
    {
      str = "mAPiObject = null";
      f.b("AssistActivity", str);
      paramIntent.putExtra("key_action", "action_share");
      if (localObject == null)
        break label95;
      BaseApi.handleDataToListener(paramIntent, (IUiListener)localObject);
    }
    while (true)
    {
      if (!isFinishing())
        finish();
      return;
      str = "mAPiObject != null";
      break;
      label95: setResult(-1, paramIntent);
    }
  }

  protected void onPause()
  {
    f.b("AssistActivity", "-->onPause");
    super.onPause();
  }

  protected void onResume()
  {
    f.b("AssistActivity", "-->onResume");
    super.onResume();
    Intent localIntent = getIntent();
    if (localIntent.getBooleanExtra("is_login", false));
    do
      return;
    while (localIntent.getBooleanExtra("is_qq_mobile_share", false));
    if ((!hackShareSend) && (!isFinishing()))
      finish();
    hackShareSend = false;
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    f.b("AssistActivity", "AssistActivity--onSaveInstanceState--");
    paramBundle.putBoolean("RESTART_FLAG", true);
    super.onSaveInstanceState(paramBundle);
  }

  protected void onStart()
  {
    f.b("AssistActivity", "-->onStart");
    super.onStart();
  }

  protected void onStop()
  {
    f.b("AssistActivity", "-->onStop");
    super.onStop();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.connect.common.AssistActivity
 * JD-Core Version:    0.6.0
 */