package com.tencent.tauth;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.connect.auth.AuthDialog;
import com.tencent.connect.auth.AuthMap;
import com.tencent.connect.auth.AuthMap.Auth;
import com.tencent.connect.common.AssistActivity;
import com.tencent.connect.common.BaseApi;
import com.tencent.open.a.f;
import com.tencent.open.utils.SystemUtils;
import com.tencent.open.utils.TemporaryStorage;
import com.tencent.open.utils.Util;
import org.json.JSONObject;

public class AuthActivity extends Activity
{
  private static final String ACTION_ADD_TO_QQFAVORITES = "addToQQFavorites";
  public static final String ACTION_KEY = "action";
  private static final String ACTION_SEND_TO_MY_COMPUTER = "sendToMyComputer";
  public static final String ACTION_SHARE_PRIZE = "sharePrize";
  private static final String ACTION_SHARE_TO_QQ = "shareToQQ";
  private static final String ACTION_SHARE_TO_QZONE = "shareToQzone";
  private static final String ACTION_SHARE_TO_TROOP_BAR = "shareToTroopBar";
  private static final String SHARE_PRIZE_ACTIVITY_ID = "activityid";
  private static final String TAG = f.d + ".AuthActivity";
  private static int mShareQzoneBackTime = 0;

  private void execAuthCallback(Bundle paramBundle, String paramString)
  {
    AuthMap localAuthMap = AuthMap.getInstance();
    String str1 = paramBundle.getString("serial");
    AuthMap.Auth localAuth = localAuthMap.get(str1);
    if (localAuth != null)
    {
      if (paramString.indexOf("://cancel") == -1)
        break label64;
      localAuth.listener.onCancel();
      localAuth.dialog.dismiss();
    }
    while (true)
    {
      localAuthMap.remove(str1);
      finish();
      return;
      label64: String str2 = paramBundle.getString("access_token");
      if (str2 != null)
        paramBundle.putString("access_token", localAuthMap.decode(str2, localAuth.key));
      String str3 = Util.encodeUrl(paramBundle);
      JSONObject localJSONObject = Util.decodeUrlToJson(new JSONObject(), str3);
      String str4 = localJSONObject.optString("cb");
      if (!"".equals(str4))
      {
        localAuth.dialog.callJs(str4, localJSONObject.toString());
        continue;
      }
      localAuth.listener.onComplete(localJSONObject);
      localAuth.dialog.dismiss();
    }
  }

  private void handleActionUri(Uri paramUri)
  {
    if ((paramUri == null) || (paramUri.toString().equals("")))
    {
      finish();
      return;
    }
    String str1 = paramUri.toString();
    Bundle localBundle1 = Util.decodeUrl(str1.substring(1 + str1.indexOf("#")));
    String str2 = localBundle1.getString("action");
    f.b(TAG, "-->handleActionUri, action: " + str2);
    if (str2 == null)
    {
      execAuthCallback(localBundle1, str1);
      return;
    }
    if ((str2.equals("shareToQQ")) || (str2.equals("shareToQzone")) || (str2.equals("sendToMyComputer")) || (str2.equals("shareToTroopBar")))
    {
      if ((str2.equals("shareToQzone")) && (SystemUtils.getAppVersionName(this, "com.tencent.mobileqq") != null) && (SystemUtils.compareQQVersion(this, "5.2.0") < 0))
      {
        mShareQzoneBackTime = 1 + mShareQzoneBackTime;
        if (mShareQzoneBackTime == 2)
        {
          mShareQzoneBackTime = 0;
          finish();
          return;
        }
      }
      Intent localIntent1 = new Intent(this, AssistActivity.class);
      localIntent1.putExtras(localBundle1);
      localIntent1.setFlags(603979776);
      startActivity(localIntent1);
      finish();
      return;
    }
    if (str2.equals("addToQQFavorites"))
    {
      Intent localIntent3 = getIntent();
      localIntent3.putExtras(localBundle1);
      localIntent3.putExtra("key_action", "action_share");
      Object localObject2 = TemporaryStorage.get(str2);
      if (localObject2 != null)
        BaseApi.handleDataToListener(localIntent3, (IUiListener)localObject2);
      finish();
      return;
    }
    if (str2.equals("sharePrize"))
    {
      Intent localIntent2 = getPackageManager().getLaunchIntentForPackage(getPackageName());
      String str3 = localBundle1.getString("response");
      Object localObject1 = "";
      try
      {
        String str4 = Util.parseJson(str3).getString("activityid");
        localObject1 = str4;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localIntent2.putExtra("sharePrize", true);
          Bundle localBundle2 = new Bundle();
          localBundle2.putString("activityid", (String)localObject1);
          localIntent2.putExtras(localBundle2);
        }
        startActivity(localIntent2);
        finish();
        return;
      }
      catch (Exception localException)
      {
        while (true)
          f.e(TAG, "sharePrize parseJson has exception.");
      }
    }
    execAuthCallback(localBundle1, str1);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Uri localUri = getIntent().getData();
    f.b(TAG, "-->onCreate, uri: " + localUri);
    handleActionUri(localUri);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.tauth.AuthActivity
 * JD-Core Version:    0.6.0
 */