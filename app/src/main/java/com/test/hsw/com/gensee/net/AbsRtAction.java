package com.gensee.net;

import com.gensee.common.GenseeConstant.CommonErrCode;
import java.io.InputStream;

public class AbsRtAction
{
  protected static final String TAG = "AbsHttpAction";
  public static final int TIME_OUT = 30000;
  protected AbsRtHandler mHttpHandler;

  public AbsRtAction(AbsRtHandler paramAbsRtHandler)
  {
    this.mHttpHandler = paramAbsRtHandler;
  }

  protected void doGetRequest(String paramString, Response paramResponse)
  {
    if (!this.mHttpHandler.is3GOrWifi())
    {
      paramResponse.onConnectError(-104, "");
      return;
    }
    new Thread(new AbsRtAction.1(this, paramResponse, paramString)).start();
  }

  protected void doPostRequest(String paramString1, String paramString2, Response paramResponse)
  {
    new Thread(new AbsRtAction.2(this, paramResponse, paramString1, paramString2)).start();
  }

  static abstract interface BaseRes
  {
    public abstract void onConnectError(int paramInt, String paramString);
  }

  public static abstract interface ErrCode extends GenseeConstant.CommonErrCode
  {
    public static final int ERR_AUTHORIZATION_NOT_ENOUGH = 12;
    public static final int ERR_FAIL_WEBCAST = 3;
    public static final int ERR_INVALID_ADDRESS = 10;
    public static final int ERR_ISONLY_WEB = 7;
    public static final int ERR_LOGIN = 5;
    public static final int ERR_NUMBER_UNEXIST = 0;
    public static final int ERR_OWNER_ERROR = 9;
    public static final int ERR_ROLE = 2;
    public static final int ERR_ROOM_OVERDUE = 11;
    public static final int ERR_ROOM_UNEABLE = 8;
    public static final int ERR_TOKEN = 4;
    public static final int ERR_UNSURPORT_MOBILE = 18;
    public static final int ERR_UNTIMELY = 13;
    public static final int ERR_WEBCAST_UNSTART = 6;
    public static final int RESULT_SUCCESS = 1;
  }

  static abstract interface Response extends AbsRtAction.BaseRes
  {
    public abstract void onRes(String paramString);
  }

  public static abstract interface StreamResponse extends AbsRtAction.BaseRes
  {
    public abstract void onRes(InputStream paramInputStream);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.net.AbsRtAction
 * JD-Core Version:    0.6.0
 */