package com.tencent.connect.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.open.a.f;
import com.tencent.open.b.d;
import com.tencent.open.utils.Global;
import com.tencent.open.utils.SystemUtils;
import com.tencent.open.utils.TemporaryStorage;
import com.tencent.open.utils.Util;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.net.URLEncoder;
import java.util.ArrayList;

public class QzoneShare extends BaseApi
{
  public static final String SHARE_TO_QQ_APP_NAME = "appName";
  public static final String SHARE_TO_QQ_AUDIO_URL = "audio_url";
  public static final String SHARE_TO_QQ_EXT_INT = "cflag";
  public static final String SHARE_TO_QQ_EXT_STR = "share_qq_ext_str";
  public static final String SHARE_TO_QQ_IMAGE_LOCAL_URL = "imageLocalUrl";
  public static final String SHARE_TO_QQ_IMAGE_URL = "imageUrl";
  public static final String SHARE_TO_QQ_SITE = "site";
  public static final String SHARE_TO_QQ_SUMMARY = "summary";
  public static final String SHARE_TO_QQ_TARGET_URL = "targetUrl";
  public static final String SHARE_TO_QQ_TITLE = "title";
  public static final String SHARE_TO_QZONE_KEY_TYPE = "req_type";
  public static final int SHARE_TO_QZONE_TYPE_APP = 6;
  public static final int SHARE_TO_QZONE_TYPE_IMAGE = 5;
  public static final int SHARE_TO_QZONE_TYPE_IMAGE_TEXT = 1;
  public static final int SHARE_TO_QZONE_TYPE_NO_TYPE;
  private boolean a = true;
  private boolean b = false;
  private boolean c = false;
  private boolean d = false;
  public String mViaShareQzoneType = "";

  public QzoneShare(Context paramContext, QQToken paramQQToken)
  {
    super(paramQQToken);
  }

  private StringBuffer a(StringBuffer paramStringBuffer, Bundle paramBundle)
  {
    f.c(f.d, "fillShareToQQParams() --start");
    ArrayList localArrayList = paramBundle.getStringArrayList("imageUrl");
    String str1 = paramBundle.getString("appName");
    int i = paramBundle.getInt("req_type", 1);
    String str2 = paramBundle.getString("title");
    String str3 = paramBundle.getString("summary");
    paramBundle.putString("appId", this.mToken.getAppId());
    paramBundle.putString("sdkp", "a");
    paramBundle.putString("sdkv", "2.8.lite");
    paramBundle.putString("status_os", Build.VERSION.RELEASE);
    paramBundle.putString("status_machine", Build.MODEL);
    if ((!Util.isEmpty(str2)) && (str2.length() > 40))
      paramBundle.putString("title", str2.substring(0, 40) + "...");
    if ((!Util.isEmpty(str3)) && (str3.length() > 80))
      paramBundle.putString("summary", str3.substring(0, 80) + "...");
    if (!TextUtils.isEmpty(str1))
      paramBundle.putString("site", str1);
    if (localArrayList != null)
    {
      int j = localArrayList.size();
      String[] arrayOfString = new String[j];
      for (int k = 0; k < j; k++)
        arrayOfString[k] = ((String)localArrayList.get(k));
      paramBundle.putStringArray("imageUrl", arrayOfString);
    }
    paramBundle.putString("type", String.valueOf(i));
    String str4 = Util.encodeUrl(paramBundle);
    paramStringBuffer.append("&" + str4.replaceAll("\\+", "%20"));
    f.c(f.d, "fillShareToQQParams() --end");
    return paramStringBuffer;
  }

  private void a(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener)
  {
    f.c(f.d, "doshareToQzone() --start");
    StringBuffer localStringBuffer1 = new StringBuffer("mqqapi://share/to_qzone?src_type=app&version=1&file_type=news");
    ArrayList localArrayList = paramBundle.getStringArrayList("imageUrl");
    String str1 = paramBundle.getString("title");
    String str2 = paramBundle.getString("summary");
    String str3 = paramBundle.getString("targetUrl");
    String str4 = paramBundle.getString("audio_url");
    int i = paramBundle.getInt("req_type", 1);
    String str5 = paramBundle.getString("appName");
    int j = paramBundle.getInt("cflag", 0);
    String str6 = paramBundle.getString("share_qq_ext_str");
    String str7 = this.mToken.getAppId();
    String str8 = this.mToken.getOpenId();
    f.b("doshareToQzone", "openId:" + str8);
    if (localArrayList != null)
    {
      StringBuffer localStringBuffer2 = new StringBuffer();
      if (localArrayList.size() > 9);
      for (int k = 9; ; k = localArrayList.size())
        for (int m = 0; m < k; m++)
        {
          localStringBuffer2.append(URLEncoder.encode((String)localArrayList.get(m)));
          if (m == k - 1)
            continue;
          localStringBuffer2.append(";");
        }
      localStringBuffer1.append("&image_url=" + Base64.encodeToString(Util.getBytesUTF8(localStringBuffer2.toString()), 2));
    }
    if (!TextUtils.isEmpty(str1))
      localStringBuffer1.append("&title=" + Base64.encodeToString(Util.getBytesUTF8(str1), 2));
    if (!TextUtils.isEmpty(str2))
      localStringBuffer1.append("&description=" + Base64.encodeToString(Util.getBytesUTF8(str2), 2));
    if (!TextUtils.isEmpty(str7))
      localStringBuffer1.append("&share_id=" + str7);
    if (!TextUtils.isEmpty(str3))
      localStringBuffer1.append("&url=" + Base64.encodeToString(Util.getBytesUTF8(str3), 2));
    if (!TextUtils.isEmpty(str5))
      localStringBuffer1.append("&app_name=" + Base64.encodeToString(Util.getBytesUTF8(str5), 2));
    if (!Util.isEmpty(str8))
      localStringBuffer1.append("&open_id=" + Base64.encodeToString(Util.getBytesUTF8(str8), 2));
    if (!Util.isEmpty(str4))
      localStringBuffer1.append("&audioUrl=" + Base64.encodeToString(Util.getBytesUTF8(str4), 2));
    localStringBuffer1.append("&req_type=" + Base64.encodeToString(Util.getBytesUTF8(String.valueOf(i)), 2));
    if (!Util.isEmpty(str6))
      localStringBuffer1.append("&share_qq_ext_str=" + Base64.encodeToString(Util.getBytesUTF8(str6), 2));
    localStringBuffer1.append("&cflag=" + Base64.encodeToString(Util.getBytesUTF8(String.valueOf(j)), 2));
    f.b("doshareToQzone, url: ", localStringBuffer1.toString());
    com.tencent.connect.a.a.a(Global.getContext(), this.mToken, "requireApi", new String[] { "shareToNativeQQ" });
    this.mActivityIntent = new Intent("android.intent.action.VIEW");
    this.mActivityIntent.setData(Uri.parse(localStringBuffer1.toString()));
    this.mActivityIntent.putExtra("pkg_name", paramActivity.getPackageName());
    if (SystemUtils.compareQQVersion(paramActivity, "4.6.0") < 0)
    {
      if (hasActivityForIntent())
        startAssitActivity(paramActivity, paramIUiListener);
      f.c(f.d, "doShareToQzone() -- QQ Version is < 4.6.0");
      if (!hasActivityForIntent())
        break label926;
      d.a().a(this.mToken.getOpenId(), this.mToken.getAppId(), "ANDROIDQQ.SHARETOQZ.XX", "11", "3", "0", this.mViaShareQzoneType, "0", "1", "0");
      d.a().a(0, "SHARE_CHECK_SDK", "1000", this.mToken.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "");
    }
    while (true)
    {
      f.c(f.d, "doShareToQzone() --end");
      return;
      f.c(f.d, "doShareToQzone() -- QQ Version is > 4.6.0");
      Object localObject = TemporaryStorage.set("shareToQzone", paramIUiListener);
      if (localObject != null)
      {
        f.c(f.d, "doShareToQzone() -- do listener onCancel()");
        ((IUiListener)localObject).onCancel();
      }
      if (!hasActivityForIntent())
        break;
      startAssistActivity(paramActivity, 10104);
      break;
      label926: d.a().a(this.mToken.getOpenId(), this.mToken.getAppId(), "ANDROIDQQ.SHARETOQZ.XX", "11", "3", "1", this.mViaShareQzoneType, "0", "1", "0");
      d.a().a(1, "SHARE_CHECK_SDK", "1000", this.mToken.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent fail");
    }
  }

  private void b(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener)
  {
    f.a(f.d, "shareToH5Qzone() -- start");
    Object localObject = TemporaryStorage.set("shareToQzone", paramIUiListener);
    if (localObject != null)
    {
      f.c(f.d, "shareToH5Qzone() -- do listener onCancel()");
      ((IUiListener)localObject).onCancel();
    }
    StringBuffer localStringBuffer1 = new StringBuffer("http://openmobile.qq.com/api/check2?page=qzshare.html&loginpage=loginindex.html&logintype=qzone");
    if (paramBundle == null)
      paramBundle = new Bundle();
    StringBuffer localStringBuffer2 = a(localStringBuffer1, paramBundle);
    com.tencent.connect.a.a.a(Global.getContext(), this.mToken, "requireApi", new String[] { "shareToH5QQ" });
    Bundle localBundle = new Bundle();
    localBundle.putString("callbackAction", "shareToQzone");
    localBundle.putString("viaShareType", this.mViaShareQzoneType);
    localBundle.putString("url", localStringBuffer2.toString());
    localBundle.putString("openId", this.mToken.getOpenId());
    localBundle.putString("appId", this.mToken.getAppId());
    startAssistActivity(paramActivity, localBundle, 10104);
    d.a().a(0, "SHARE_CHECK_SDK", "1000", this.mToken.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToH5Qzone()");
    f.a(f.d, "shareToH5Qzone() --end");
  }

  public void onActivityResult(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
  }

  public void releaseResource()
  {
    TemporaryStorage.remove("shareToQzone");
  }

  public void shareToQzone(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener)
  {
    f.c(f.d, "shareToQzone() -- start");
    if (paramBundle == null)
    {
      paramIUiListener.onError(new UiError(-6, "传入参数不可以为空", null));
      d.a().a(1, "SHARE_CHECK_SDK", "1000", this.mToken.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "传入参数不可以为空");
      return;
    }
    String str1 = paramBundle.getString("title");
    String str2 = paramBundle.getString("summary");
    String str3 = paramBundle.getString("targetUrl");
    ArrayList localArrayList = paramBundle.getStringArrayList("imageUrl");
    String str4 = Util.getApplicationLable(paramActivity);
    int i;
    if (str4 == null)
    {
      str4 = paramBundle.getString("appName");
      i = paramBundle.getInt("req_type");
      switch (i)
      {
      case 2:
      case 3:
      case 4:
      default:
        this.mViaShareQzoneType = "1";
        switch (i)
        {
        case 2:
        case 3:
        case 4:
        default:
          label175: if ((Util.isEmpty(str1)) && (Util.isEmpty(str2)))
            if ((localArrayList != null) && (localArrayList.size() != 0))
              this.a = false;
        case 6:
        case 1:
        case 5:
        }
      case 6:
      case 1:
      case 5:
      }
    }
    String str5;
    Object localObject;
    while (true)
    {
      this.b = false;
      this.c = true;
      this.d = false;
      str5 = str1;
      localObject = str3;
      while (true)
      {
        if ((Util.hasSDCard()) || (SystemUtils.compareQQVersion(paramActivity, "4.5.0") >= 0))
          break label691;
        paramIUiListener.onError(new UiError(-6, "分享图片失败，检测不到SD卡!", null));
        f.e(f.d, "shareToQzone() sdcard is null--end");
        d.a().a(1, "SHARE_CHECK_SDK", "1000", this.mToken.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "分享图片失败，检测不到SD卡!");
        return;
        if (str4.length() <= 20)
          break;
        str4 = str4.substring(0, 20) + "...";
        break;
        this.mViaShareQzoneType = "4";
        break label175;
        this.mViaShareQzoneType = "1";
        break label175;
        this.mViaShareQzoneType = "2";
        break label175;
        if (SystemUtils.compareQQVersion(paramActivity, "5.0.0") < 0)
        {
          paramIUiListener.onError(new UiError(-15, "手Q版本过低，应用分享只支持手Q5.0及其以上版本", null));
          f.b(f.d, "-->shareToQzone, app share is not support below qq5.0.");
          d.a().a(1, "SHARE_CHECK_SDK", "1000", this.mToken.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone, app share is not support below qq5.0.");
          return;
        }
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = this.mToken.getAppId();
        arrayOfObject[1] = "mqq";
        String str8 = String.format("http://fusion.qq.com/cgi-bin/qzapps/unified_jump?appid=%1$s&from=%2$s&isOpenAppID=1", arrayOfObject);
        paramBundle.putString("targetUrl", str8);
        str5 = str1;
        localObject = str8;
        continue;
        this.a = true;
        this.b = false;
        this.c = true;
        this.d = false;
        str5 = str1;
        localObject = str3;
      }
      paramIUiListener.onError(new UiError(-5, "暂不支持纯图片分享到空间，建议使用图文分享", null));
      f.e(f.d, "shareToQzone() error--end暂不支持纯图片分享到空间，建议使用图文分享");
      d.a().a(1, "SHARE_CHECK_SDK", "1000", this.mToken.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() 暂不支持纯图片分享到空间，建议使用图文分享");
      return;
      str1 = "来自" + str4 + "的分享";
      this.a = true;
      continue;
      this.a = true;
    }
    label691: if (this.a)
    {
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        paramIUiListener.onError(new UiError(-5, "targetUrl为必填项，请补充后分享", null));
        f.e(f.d, "shareToQzone() targetUrl null error--end");
        d.a().a(1, "SHARE_CHECK_SDK", "1000", this.mToken.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "targetUrl为必填项，请补充后分享");
        return;
      }
      if (!Util.isValidUrl((String)localObject))
      {
        paramIUiListener.onError(new UiError(-5, "targetUrl有误", null));
        f.e(f.d, "shareToQzone() targetUrl error--end");
        d.a().a(1, "SHARE_CHECK_SDK", "1000", this.mToken.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "targetUrl有误");
        return;
      }
    }
    if (this.b)
    {
      paramBundle.putString("title", "");
      paramBundle.putString("summary", "");
    }
    while (true)
    {
      if (!TextUtils.isEmpty(str4))
        paramBundle.putString("appName", str4);
      if ((localArrayList == null) || ((localArrayList != null) && (localArrayList.size() == 0)))
      {
        if (!this.d)
          break;
        paramIUiListener.onError(new UiError(-6, "纯图分享，imageUrl 不能为空", null));
        f.e(f.d, "shareToQzone() imageUrl is null -- end");
        d.a().a(1, "SHARE_CHECK_SDK", "1000", this.mToken.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() imageUrl is null");
        return;
        if ((this.c) && (Util.isEmpty(str5)))
        {
          paramIUiListener.onError(new UiError(-6, "title不能为空!", null));
          f.e(f.d, "shareToQzone() title is null--end");
          d.a().a(1, "SHARE_CHECK_SDK", "1000", this.mToken.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() title is null");
          return;
        }
        if ((!Util.isEmpty(str5)) && (str5.length() > 200))
          paramBundle.putString("title", Util.subString(str5, 200, null, null));
        if ((Util.isEmpty(str2)) || (str2.length() <= 600))
          continue;
        paramBundle.putString("summary", Util.subString(str2, 600, null, null));
        continue;
      }
      else
      {
        for (int j = 0; j < localArrayList.size(); j++)
        {
          String str7 = (String)localArrayList.get(j);
          if ((Util.isValidUrl(str7)) || (Util.isValidPath(str7)))
            continue;
          localArrayList.remove(j);
        }
        if (localArrayList.size() == 0)
        {
          paramIUiListener.onError(new UiError(-6, "非法的图片地址!", null));
          f.e(f.d, "shareToQzone() MSG_PARAM_IMAGE_URL_FORMAT_ERROR--end");
          d.a().a(1, "SHARE_CHECK_SDK", "1000", this.mToken.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() 非法的图片地址!");
          return;
        }
        paramBundle.putStringArrayList("imageUrl", localArrayList);
      }
    }
    if (SystemUtils.compareQQVersion(paramActivity, "4.6.0") >= 0)
      a.a(paramActivity, localArrayList, new QzoneShare.1(this, paramBundle, paramActivity, paramIUiListener));
    while (true)
    {
      f.c(f.d, "shareToQzone() --end");
      return;
      if ((SystemUtils.compareQQVersion(paramActivity, "4.2.0") >= 0) && (SystemUtils.compareQQVersion(paramActivity, "4.6.0") < 0))
      {
        QQShare localQQShare = new QQShare(paramActivity, this.mToken);
        if ((localArrayList != null) && (localArrayList.size() > 0))
        {
          String str6 = (String)localArrayList.get(0);
          if ((i == 5) && (!Util.fileExists(str6)))
          {
            paramIUiListener.onError(new UiError(-6, "手Q版本过低，纯图分享不支持网路图片", null));
            f.e(f.d, "shareToQzone()手Q版本过低，纯图分享不支持网路图片");
            d.a().a(1, "SHARE_CHECK_SDK", "1000", this.mToken.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone()手Q版本过低，纯图分享不支持网路图片");
            return;
          }
          paramBundle.putString("imageLocalUrl", str6);
        }
        if (SystemUtils.compareQQVersion(paramActivity, "4.5.0") >= 0)
          paramBundle.putInt("cflag", 1);
        localQQShare.shareToQQ(paramActivity, paramBundle, paramIUiListener);
        continue;
      }
      b(paramActivity, paramBundle, paramIUiListener);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.connect.share.QzoneShare
 * JD-Core Version:    0.6.0
 */