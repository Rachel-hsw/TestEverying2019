package com.gensee.net;

import com.gensee.entity.AccessResEntity;
import com.gensee.entity.LoginResEntity;
import com.gensee.entity.PingEntity;
import java.io.InputStream;
import java.io.Serializable;

public abstract interface IHttpHandler
{
  public static final String RESULT_AUTHORIZATION_NOT_ENOUGH = "12";
  public static final String RESULT_FAIL = "2";
  public static final String RESULT_FAIL_LOGIN = "5";
  public static final String RESULT_FAIL_TOKEN = "4";
  public static final String RESULT_FAIL_WEBCAST = "3";
  public static final String RESULT_INVALID_ADDRESS = "10";
  public static final String RESULT_ISONLY_WEB = "7";
  public static final String RESULT_OWNER_ERROR = "9";
  public static final String RESULT_ROOM_NUMBER_UNEXIST = "0";
  public static final String RESULT_ROOM_OVERDUE = "11";
  public static final String RESULT_ROOM_UNEABLE = "8";
  public static final String RESULT_SUCCESS = "1";
  public static final String RESULT_UNSURPORT_MOBILE = "18";
  public static final String RESULT_UNTIMELY = "13";
  public static final String RESULT_VOD_ACC_PWD_ERR = "17";
  public static final String RESULT_VOD_INTI_FAIL = "14";
  public static final String RESULT_VOD_NUM_UNEXIST = "15";
  public static final String RESULT_VOD_PWD_ERR = "16";
  public static final String RESULT_WEBCAST_UNSTART = "6";

  public abstract boolean is3GOrWifi();

  public abstract AccessResEntity onAccessInfoRes(String paramString);

  public abstract AccessResEntity onAccessUrlInfoRes(String paramString);

  public abstract Object onAccessVod(String paramString);

  public abstract Object onAlbRes(String paramString);

  public abstract void onConnectError(int paramInt, String paramString);

  public abstract void onErr(int paramInt);

  public abstract Object onJoinRes(String paramString);

  public abstract Object onKeepLive(String paramString);

  public abstract void onLoginFinish(Serializable paramSerializable);

  public abstract LoginResEntity onLoginInfoRes(String paramString, boolean paramBoolean);

  public abstract Object onLoginVod(String paramString);

  public abstract void onVodInitEnd(Serializable paramSerializable);

  public abstract void sendBroadCast(String paramString, Serializable paramSerializable);

  public abstract void sendError(String paramString);

  public static abstract interface BaseRes
  {
    public abstract void onConnectError(int paramInt, String paramString);
  }

  public static abstract interface Error
  {
    public static final int DATA_TIMEOUT = 101;
    public static final int DOMAIN = 1;
    public static final int PARAM_INVALIDE = 102;
    public static final int SITE_UNUSED = 4;
    public static final int TIME_OUT = 2;
    public static final int UNKNOWN = 3;
    public static final int UN_NET = 100;
  }

  public static abstract interface OnPingPic
  {
    public abstract void onPingError(int paramInt, String paramString);

    public abstract void onPingPicRes(PingEntity paramPingEntity);
  }

  public static abstract interface ResAction
  {
    public static final String ACCESSINFO_RES = "accessinfores";
    public static final String ACCESSURLINFO_RES = "accessurlinfores";
    public static final String ALB_RES = "albinfores";
    public static final String ERROR_CONNECTED = "errorconnected";
    public static final String ERROR_ISONLY_WEB = "onlywebuser";
    public static final String ERROR_RES = "errorres";
    public static final String ERROR_ROOM_NUMBER_UNEXIST = "roomnumberunexist";
    public static final int ERR_NET_BROKEN = 2;
    public static final int ERR_TIME_OUT = 1;
    public static final String JOIN_RES = "joininfores";
    public static final String LOGININFO_RES = "logininfores";
    public static final String PUB_INIT_RES = "gspublishres";
    public static final String REC_INIT_RES = "gsreceiveres";
    public static final String RES_APPNAME = "appname";
    public static final String RES_DATA = "responsedata";
    public static final String VOD_ACC_RES = "gsvodaccessres";
    public static final String VOD_INIT_RES = "gsvodinitres";
  }

  public static abstract interface Response extends IHttpHandler.BaseRes
  {
    public abstract void onRes(String paramString);
  }

  public static abstract interface StreamResponse extends IHttpHandler.BaseRes
  {
    public abstract void onRes(InputStream paramInputStream);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.net.IHttpHandler
 * JD-Core Version:    0.6.0
 */