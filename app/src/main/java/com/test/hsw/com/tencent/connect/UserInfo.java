package com.tencent.connect;

import android.content.Context;
import android.os.Bundle;
import com.tencent.connect.auth.QQAuth;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.BaseApi.TempRequestListener;
import com.tencent.open.utils.Global;
import com.tencent.open.utils.HttpUtils;
import com.tencent.tauth.IUiListener;

public class UserInfo extends BaseApi
{
  public static final String GRAPH_OPEN_ID = "oauth2.0/m_me";

  public UserInfo(Context paramContext, QQAuth paramQQAuth, QQToken paramQQToken)
  {
    super(paramQQAuth, paramQQToken);
  }

  public UserInfo(Context paramContext, QQToken paramQQToken)
  {
    super(paramQQToken);
  }

  public void getOpenId(IUiListener paramIUiListener)
  {
    Bundle localBundle = composeCGIParams();
    BaseApi.TempRequestListener localTempRequestListener = new BaseApi.TempRequestListener(this, paramIUiListener);
    HttpUtils.requestAsync(this.mToken, Global.getContext(), "oauth2.0/m_me", localBundle, "GET", localTempRequestListener);
  }

  public void getTenPayAddr(IUiListener paramIUiListener)
  {
    Bundle localBundle = composeCGIParams();
    localBundle.putString("ver", "1");
    BaseApi.TempRequestListener localTempRequestListener = new BaseApi.TempRequestListener(this, paramIUiListener);
    HttpUtils.requestAsync(this.mToken, Global.getContext(), "cft_info/get_tenpay_addr", localBundle, "GET", localTempRequestListener);
  }

  public void getUserInfo(IUiListener paramIUiListener)
  {
    Bundle localBundle = composeCGIParams();
    BaseApi.TempRequestListener localTempRequestListener = new BaseApi.TempRequestListener(this, paramIUiListener);
    HttpUtils.requestAsync(this.mToken, Global.getContext(), "user/get_simple_userinfo", localBundle, "GET", localTempRequestListener);
  }

  public void getVipUserInfo(IUiListener paramIUiListener)
  {
    Bundle localBundle = composeCGIParams();
    BaseApi.TempRequestListener localTempRequestListener = new BaseApi.TempRequestListener(this, paramIUiListener);
    HttpUtils.requestAsync(this.mToken, Global.getContext(), "user/get_vip_info", localBundle, "GET", localTempRequestListener);
  }

  public void getVipUserRichInfo(IUiListener paramIUiListener)
  {
    Bundle localBundle = composeCGIParams();
    BaseApi.TempRequestListener localTempRequestListener = new BaseApi.TempRequestListener(this, paramIUiListener);
    HttpUtils.requestAsync(this.mToken, Global.getContext(), "user/get_vip_rich_info", localBundle, "GET", localTempRequestListener);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.connect.UserInfo
 * JD-Core Version:    0.6.0
 */