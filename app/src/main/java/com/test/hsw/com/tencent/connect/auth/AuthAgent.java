package com.tencent.connect.auth;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.PaintDrawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.CookieSyncManager;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.connect.a.a;
import com.tencent.connect.common.AssistActivity;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.BaseApi.ApiTask;
import com.tencent.connect.common.BaseApi.TempRequestListener;
import com.tencent.open.a.f;
import com.tencent.open.b.d;
import com.tencent.open.utils.Global;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.ServerSetting;
import com.tencent.open.utils.SystemUtils;
import com.tencent.open.utils.ThreadManager;
import com.tencent.open.utils.Util;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class AuthAgent extends BaseApi
{
  public static final String SECURE_LIB_FILE_NAME = "libwbsafeedit";
  public static final String SECURE_LIB_NAME = "libwbsafeedit.so";
  private IUiListener a;
  private String b;
  private Activity c;

  public AuthAgent(QQToken paramQQToken)
  {
    super(paramQQToken);
  }

  private int a(boolean paramBoolean, IUiListener paramIUiListener)
  {
    f.c(f.d, "OpenUi, showDialog -- start");
    CookieSyncManager.createInstance(Global.getContext());
    Bundle localBundle = composeCGIParams();
    if (paramBoolean)
      localBundle.putString("isadd", "1");
    localBundle.putString("scope", this.b);
    localBundle.putString("client_id", this.mToken.getAppId());
    if (isOEM)
      localBundle.putString("pf", "desktop_m_qq-" + installChannel + "-" + "android" + "-" + registerChannel + "-" + businessId);
    while (true)
    {
      String str1 = System.currentTimeMillis() / 1000L + "";
      localBundle.putString("sign", SystemUtils.getAppSignatureMD5(Global.getContext(), str1));
      localBundle.putString("time", str1);
      localBundle.putString("display", "mobile");
      localBundle.putString("response_type", "token");
      localBundle.putString("redirect_uri", "auth://tauth.qq.com/");
      localBundle.putString("cancel_display", "1");
      localBundle.putString("switch", "1");
      localBundle.putString("status_userip", Util.getUserIp());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(ServerSetting.getInstance().getEnvUrl(Global.getContext(), "http://openmobile.qq.com/oauth2.0/m_authorize?"));
      localStringBuilder.append(Util.encodeUrl(localBundle));
      String str2 = localStringBuilder.toString();
      TokenListener localTokenListener = new TokenListener(Global.getContext(), paramIUiListener, true, false);
      f.b(f.d, "OpenUi, showDialog TDialog");
      ThreadManager.executeOnSubThread(new AuthAgent.1(this, str2, localTokenListener));
      f.c(f.d, "OpenUi, showDialog -- end");
      return 2;
      localBundle.putString("pf", "openmobile_android");
    }
  }

  private void a(String paramString)
  {
    try
    {
      JSONObject localJSONObject = Util.parseJson(paramString);
      String str1 = localJSONObject.getString("access_token");
      String str2 = localJSONObject.getString("expires_in");
      String str3 = localJSONObject.getString("openid");
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3)))
      {
        this.mToken.setAccessToken(str1, str2);
        this.mToken.setOpenId(str3);
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private boolean a(Activity paramActivity, Fragment paramFragment, boolean paramBoolean)
  {
    f.c(f.d, "startActionActivity() -- start");
    Intent localIntent = getTargetActivityIntent("com.tencent.open.agent.AgentActivity");
    if (localIntent != null)
    {
      Bundle localBundle = composeCGIParams();
      if (paramBoolean)
        localBundle.putString("isadd", "1");
      localBundle.putString("scope", this.b);
      localBundle.putString("client_id", this.mToken.getAppId());
      if (isOEM)
      {
        localBundle.putString("pf", "desktop_m_qq-" + installChannel + "-" + "android" + "-" + registerChannel + "-" + businessId);
        localBundle.putString("need_pay", "1");
        localBundle.putString("oauth_app_name", SystemUtils.getAppName(Global.getContext()));
        localIntent.putExtra("key_action", "action_login");
        localIntent.putExtra("key_params", localBundle);
        this.mActivityIntent = localIntent;
        if (!hasActivityForIntent())
          break label300;
        this.a = new FeedConfirmListener(this.a);
        if (paramFragment == null)
          break label279;
        f.b("AuthAgent", "startAssitActivity fragment");
        startAssitActivity(paramFragment, this.a);
      }
      while (true)
      {
        f.c(f.d, "startActionActivity() -- end");
        d.a().a(0, "LOGIN_CHECK_SDK", "1000", this.mToken.getAppId(), "", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "");
        return true;
        localBundle.putString("pf", "openmobile_android");
        break;
        label279: f.b("AuthAgent", "startAssitActivity activity");
        startAssitActivity(paramActivity, this.a);
      }
    }
    label300: d.a().a(1, "LOGIN_CHECK_SDK", "1000", this.mToken.getAppId(), "", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "startActionActivity fail");
    f.c(f.d, "startActionActivity() -- end");
    return false;
  }

  protected void a(IUiListener paramIUiListener)
  {
    f.c(f.d, "reportDAU() -- start");
    String str1 = this.mToken.getAccessToken();
    String str2 = this.mToken.getOpenId();
    String str3 = this.mToken.getAppId();
    String str4 = "";
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3)))
      str4 = Util.encrypt("tencent&sdk&qazxc***14969%%" + str1 + str3 + str2 + "qzone3.4");
    if (TextUtils.isEmpty(str4))
    {
      f.e(f.d, "reportDAU -- encrytoken is null");
      return;
    }
    Bundle localBundle = composeCGIParams();
    localBundle.putString("encrytoken", str4);
    HttpUtils.requestAsync(this.mToken, Global.getContext(), "https://openmobile.qq.com/user/user_login_statis", localBundle, "POST", null);
    f.c(f.d, "reportDAU() -- end");
  }

  protected void b(IUiListener paramIUiListener)
  {
    Bundle localBundle = composeCGIParams();
    localBundle.putString("reqType", "checkLogin");
    BaseApi.TempRequestListener localTempRequestListener = new BaseApi.TempRequestListener(this, new CheckLoginListener(paramIUiListener));
    HttpUtils.requestAsync(this.mToken, Global.getContext(), "https://openmobile.qq.com/v3/user/get_info", localBundle, "GET", localTempRequestListener);
  }

  public int doLogin(Activity paramActivity, String paramString, IUiListener paramIUiListener)
  {
    return doLogin(paramActivity, paramString, paramIUiListener, false, null);
  }

  public int doLogin(Activity paramActivity, String paramString, IUiListener paramIUiListener, boolean paramBoolean, Fragment paramFragment)
  {
    this.b = paramString;
    this.c = paramActivity;
    this.a = paramIUiListener;
    if (a(paramActivity, paramFragment, paramBoolean))
    {
      f.c(f.d, "OpenUi, showUi, return Constants.UI_ACTIVITY");
      d.a().a(this.mToken.getOpenId(), this.mToken.getAppId(), "2", "1", "5", "0", "0", "0");
      return 1;
    }
    d.a().a(this.mToken.getOpenId(), this.mToken.getAppId(), "2", "1", "5", "1", "0", "0");
    f.d(f.d, "startActivity fail show dialog.");
    this.a = new FeedConfirmListener(this.a);
    return a(paramBoolean, this.a);
  }

  public void onActivityResult(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    ThreadManager.executeOnSubThread(new AuthAgent.2(this));
    Iterator localIterator = this.mTaskList.iterator();
    IUiListener localIUiListener2;
    while (localIterator.hasNext())
    {
      BaseApi.ApiTask localApiTask = (BaseApi.ApiTask)localIterator.next();
      if (localApiTask.mRequestCode != paramInt1)
        continue;
      localIUiListener2 = localApiTask.mListener;
      this.mTaskList.remove(localApiTask);
    }
    for (IUiListener localIUiListener1 = localIUiListener2; ; localIUiListener1 = null)
    {
      if (paramIntent == null)
      {
        if (localIUiListener1 != null)
          localIUiListener1.onCancel();
        return;
      }
      a(paramIntent.getStringExtra("key_response"));
      if (localIUiListener1 == null)
      {
        AssistActivity.setResultDataForLogin(paramActivity, paramIntent);
        return;
      }
      if (paramInt2 == -1)
        handleDataToListener(paramIntent, localIUiListener1);
      while (true)
      {
        releaseResource();
        f.b();
        return;
        f.b(f.d, "OpenUi, onActivityResult, Constants.ACTIVITY_CANCEL");
        localIUiListener1.onCancel();
      }
    }
  }

  public void releaseResource()
  {
    this.c = null;
    this.a = null;
  }

  private class CheckLoginListener
    implements IUiListener
  {
    IUiListener a;

    public CheckLoginListener(IUiListener arg2)
    {
      Object localObject;
      this.a = localObject;
    }

    public void onCancel()
    {
      if (this.a != null)
        this.a.onCancel();
    }

    public void onComplete(Object paramObject)
    {
      if (paramObject == null)
      {
        f.e("CheckLoginListener", "response data is null");
        return;
      }
      JSONObject localJSONObject = (JSONObject)paramObject;
      while (true)
      {
        try
        {
          int i = localJSONObject.getInt("ret");
          if (i == 0)
          {
            localObject = "success";
            if (this.a == null)
              break;
            this.a.onComplete(new JSONObject().put("ret", i).put("msg", localObject));
            return;
          }
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
          f.e("CheckLoginListener", "response data format error");
          return;
        }
        String str = localJSONObject.getString("msg");
        Object localObject = str;
      }
    }

    public void onError(UiError paramUiError)
    {
      if (this.a != null)
        this.a.onError(paramUiError);
    }
  }

  private class FeedConfirmListener
    implements IUiListener
  {
    IUiListener a;
    private final String c = "sendinstall";
    private final String d = "installwording";
    private final String e = "http://appsupport.qq.com/cgi-bin/qzapps/mapp_addapp.cgi";

    public FeedConfirmListener(IUiListener arg2)
    {
      Object localObject;
      this.a = localObject;
    }

    private Drawable a(String paramString, Context paramContext)
    {
      AssetManager localAssetManager = paramContext.getApplicationContext().getAssets();
      InputStream localInputStream;
      Object localObject;
      IOException localIOException2;
      try
      {
        localInputStream = localAssetManager.open(paramString);
        if (localInputStream == null)
          return null;
        if (paramString.endsWith(".9.png"))
        {
          Bitmap localBitmap = BitmapFactory.decodeStream(localInputStream);
          if (localBitmap != null)
          {
            byte[] arrayOfByte = localBitmap.getNinePatchChunk();
            NinePatch.isNinePatchChunk(arrayOfByte);
            NinePatchDrawable localNinePatchDrawable = new NinePatchDrawable(localBitmap, arrayOfByte, new Rect(), null);
            return localNinePatchDrawable;
          }
        }
      }
      catch (IOException localIOException1)
      {
        localObject = null;
        localIOException2 = localIOException1;
      }
      while (true)
      {
        localIOException2.printStackTrace();
        return localObject;
        return null;
        Drawable localDrawable = Drawable.createFromStream(localInputStream, paramString);
        localObject = localDrawable;
        try
        {
          localInputStream.close();
          return localObject;
        }
        catch (IOException localIOException3)
        {
        }
      }
    }

    private View a(Context paramContext, Drawable paramDrawable, String paramString, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
      float f = localDisplayMetrics.density;
      RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
      ImageView localImageView = new ImageView(paramContext);
      localImageView.setImageDrawable(paramDrawable);
      localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      localImageView.setId(1);
      int i = (int)(60.0F * f);
      int j = (int)(60.0F * f);
      (int)(14.0F * f);
      int k = (int)(18.0F * f);
      int m = (int)(6.0F * f);
      int n = (int)(18.0F * f);
      RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(i, j);
      localLayoutParams1.addRule(9);
      localLayoutParams1.setMargins(0, k, m, n);
      localRelativeLayout.addView(localImageView, localLayoutParams1);
      TextView localTextView = new TextView(paramContext);
      localTextView.setText(paramString);
      localTextView.setTextSize(14.0F);
      localTextView.setGravity(3);
      localTextView.setIncludeFontPadding(false);
      localTextView.setPadding(0, 0, 0, 0);
      localTextView.setLines(2);
      localTextView.setId(5);
      localTextView.setMinWidth((int)(185.0F * f));
      RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams2.addRule(1, 1);
      localLayoutParams2.addRule(6, 1);
      (int)(10.0F * f);
      localLayoutParams2.setMargins(0, 0, (int)(5.0F * f), 0);
      localRelativeLayout.addView(localTextView, localLayoutParams2);
      View localView = new View(paramContext);
      localView.setBackgroundColor(Color.rgb(214, 214, 214));
      localView.setId(3);
      RelativeLayout.LayoutParams localLayoutParams3 = new RelativeLayout.LayoutParams(-2, 2);
      localLayoutParams3.addRule(3, 1);
      localLayoutParams3.addRule(5, 1);
      localLayoutParams3.addRule(7, 5);
      localLayoutParams3.setMargins(0, 0, 0, (int)(12.0F * f));
      localRelativeLayout.addView(localView, localLayoutParams3);
      LinearLayout localLinearLayout = new LinearLayout(paramContext);
      RelativeLayout.LayoutParams localLayoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams4.addRule(5, 1);
      localLayoutParams4.addRule(7, 5);
      localLayoutParams4.addRule(3, 3);
      Button localButton1 = new Button(paramContext);
      localButton1.setText("跳过");
      localButton1.setBackgroundDrawable(a("buttonNegt.png", paramContext));
      localButton1.setTextColor(Color.rgb(36, 97, 131));
      localButton1.setTextSize(20.0F);
      localButton1.setOnClickListener(paramOnClickListener2);
      localButton1.setId(4);
      LinearLayout.LayoutParams localLayoutParams5 = new LinearLayout.LayoutParams(0, (int)(45.0F * f));
      localLayoutParams5.rightMargin = (int)(14.0F * f);
      localLayoutParams5.leftMargin = (int)(4.0F * f);
      localLayoutParams5.weight = 1.0F;
      localLinearLayout.addView(localButton1, localLayoutParams5);
      Button localButton2 = new Button(paramContext);
      localButton2.setText("确定");
      localButton2.setTextSize(20.0F);
      localButton2.setTextColor(Color.rgb(255, 255, 255));
      localButton2.setBackgroundDrawable(a("buttonPost.png", paramContext));
      localButton2.setOnClickListener(paramOnClickListener1);
      LinearLayout.LayoutParams localLayoutParams6 = new LinearLayout.LayoutParams(0, (int)(45.0F * f));
      localLayoutParams6.weight = 1.0F;
      localLayoutParams6.rightMargin = (int)(4.0F * f);
      localLinearLayout.addView(localButton2, localLayoutParams6);
      localRelativeLayout.addView(localLinearLayout, localLayoutParams4);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams((int)(279.0F * f), (int)(163.0F * f));
      localRelativeLayout.setPadding((int)(14.0F * f), 0, (int)(12.0F * f), (int)(12.0F * f));
      localRelativeLayout.setLayoutParams(localLayoutParams);
      localRelativeLayout.setBackgroundColor(Color.rgb(247, 251, 247));
      PaintDrawable localPaintDrawable = new PaintDrawable(Color.rgb(247, 251, 247));
      localPaintDrawable.setCornerRadius(f * 5.0F);
      localRelativeLayout.setBackgroundDrawable(localPaintDrawable);
      return localRelativeLayout;
    }

    private void a(String paramString, IUiListener paramIUiListener, Object paramObject)
    {
      Dialog localDialog = new Dialog(AuthAgent.e(AuthAgent.this));
      localDialog.requestWindowFeature(1);
      PackageManager localPackageManager = AuthAgent.e(AuthAgent.this).getPackageManager();
      try
      {
        PackageInfo localPackageInfo2 = localPackageManager.getPackageInfo(AuthAgent.e(AuthAgent.this).getPackageName(), 0);
        localPackageInfo1 = localPackageInfo2;
        Drawable localDrawable = null;
        if (localPackageInfo1 != null)
          localDrawable = localPackageInfo1.applicationInfo.loadIcon(localPackageManager);
        AuthAgent.FeedConfirmListener.1 local1 = new AuthAgent.FeedConfirmListener.1(this, localDialog, paramIUiListener, paramObject);
        AuthAgent.FeedConfirmListener.2 local2 = new AuthAgent.FeedConfirmListener.2(this, localDialog, paramIUiListener, paramObject);
        ColorDrawable localColorDrawable = new ColorDrawable();
        localColorDrawable.setAlpha(0);
        localDialog.getWindow().setBackgroundDrawable(localColorDrawable);
        localDialog.setContentView(a(AuthAgent.e(AuthAgent.this), localDrawable, paramString, local1, local2));
        localDialog.setOnCancelListener(new AuthAgent.FeedConfirmListener.3(this, paramIUiListener, paramObject));
        if ((AuthAgent.e(AuthAgent.this) != null) && (!AuthAgent.e(AuthAgent.this).isFinishing()))
          localDialog.show();
        return;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        while (true)
        {
          localNameNotFoundException.printStackTrace();
          PackageInfo localPackageInfo1 = null;
        }
      }
    }

    protected void a()
    {
      Bundle localBundle = AuthAgent.g(AuthAgent.this);
      HttpUtils.requestAsync(AuthAgent.h(AuthAgent.this), AuthAgent.e(AuthAgent.this), "http://appsupport.qq.com/cgi-bin/qzapps/mapp_addapp.cgi", localBundle, "POST", null);
    }

    public void onCancel()
    {
      if (this.a != null)
        this.a.onCancel();
    }

    public void onComplete(Object paramObject)
    {
      int i = 0;
      JSONObject localJSONObject;
      if (paramObject != null)
      {
        localJSONObject = (JSONObject)paramObject;
        if (localJSONObject == null);
      }
      try
      {
        int m = localJSONObject.getInt("sendinstall");
        i = 0;
        if (m == 1)
          i = 1;
        String str3 = localJSONObject.getString("installwording");
        str1 = str3;
        k = i;
        String str2 = URLDecoder.decode(str1);
        f.b("TAG", " WORDING = " + str2 + "xx");
        if ((k != 0) && (!TextUtils.isEmpty(str2)))
        {
          a(str2, this.a, paramObject);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        do
          while (true)
          {
            int j = i;
            f.d("FeedConfirm", "There is no value for sendinstall.");
            int k = j;
            String str1 = "";
          }
        while (this.a == null);
        this.a.onComplete(paramObject);
      }
    }

    public void onError(UiError paramUiError)
    {
      if (this.a != null)
        this.a.onError(paramUiError);
    }

    private abstract class ButtonListener
      implements View.OnClickListener
    {
      Dialog d;

      ButtonListener(Dialog arg2)
      {
        Object localObject;
        this.d = localObject;
      }
    }
  }

  private class TokenListener
    implements IUiListener
  {
    private final IUiListener b;
    private final boolean c;
    private final Context d;

    public TokenListener(Context paramIUiListener, IUiListener paramBoolean1, boolean paramBoolean2, boolean arg5)
    {
      this.d = paramIUiListener;
      this.b = paramBoolean1;
      this.c = paramBoolean2;
      f.b(f.d, "OpenUi, TokenListener()");
    }

    public void onCancel()
    {
      f.b(f.d, "OpenUi, TokenListener() onCancel");
      this.b.onCancel();
      f.b();
    }

    public void onComplete(Object paramObject)
    {
      f.b(f.d, "OpenUi, TokenListener() onComplete");
      JSONObject localJSONObject = (JSONObject)paramObject;
      try
      {
        String str1 = localJSONObject.getString("access_token");
        String str2 = localJSONObject.getString("expires_in");
        String str3 = localJSONObject.getString("openid");
        if ((str1 != null) && (AuthAgent.a(AuthAgent.this) != null) && (str3 != null))
        {
          AuthAgent.b(AuthAgent.this).setAccessToken(str1, str2);
          AuthAgent.c(AuthAgent.this).setOpenId(str3);
          a.d(this.d, AuthAgent.d(AuthAgent.this));
        }
        String str4 = localJSONObject.getString("pf");
        if (str4 != null);
        try
        {
          this.d.getSharedPreferences("pfStore", 0).edit().putString("pf", str4).commit();
          if (this.c)
            CookieSyncManager.getInstance().sync();
          this.b.onComplete(localJSONObject);
          AuthAgent.this.releaseResource();
          f.b();
          return;
        }
        catch (Exception localException)
        {
          while (true)
          {
            localException.printStackTrace();
            f.b(f.d, "OpenUi, TokenListener() onComplete error", localException);
          }
        }
      }
      catch (JSONException localJSONException)
      {
        while (true)
        {
          localJSONException.printStackTrace();
          f.b(f.d, "OpenUi, TokenListener() onComplete error", localJSONException);
        }
      }
    }

    public void onError(UiError paramUiError)
    {
      f.b(f.d, "OpenUi, TokenListener() onError");
      this.b.onError(paramUiError);
      f.b();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.connect.auth.AuthAgent
 * JD-Core Version:    0.6.0
 */