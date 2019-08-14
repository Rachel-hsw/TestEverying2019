package com.gensee.net;

import android.content.Context;
import com.gensee.common.GenseeConfig;
import com.gensee.common.ServiceType;
import com.gensee.entity.AccessResEntity;
import com.gensee.entity.InitParam;
import com.gensee.entity.LoginResEntity;
import com.gensee.report.ReportInfo;
import com.gensee.utils.GenseeLog;
import com.gensee.utils.StringUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public abstract class AbsRoomSite extends AbsRtAction
{
  private String accessAddr = "http://%s/%s/site/accessInfo";
  private boolean bAttendeeOnly = false;
  String domain = "";
  private String loginAddr = "http://%s/%s/site/loginInfo";
  private String nickName = "";
  String number = "";
  private String password = "";
  private ServiceType serviceType;
  private String userData = "";
  private long userId = -1L;
  private String userName = "";
  private String watchWord = "";

  public AbsRoomSite(Context paramContext)
  {
    super(null);
    GenseeLog.reportInfo = new ReportInfo(paramContext);
    this.mHttpHandler = new AbsRoomSite.1(this, paramContext);
  }

  public AbsRoomSite(AbsRtHandler paramAbsRtHandler)
  {
    super(paramAbsRtHandler);
  }

  private void login(AccessResEntity paramAccessResEntity)
  {
    login(this.domain, this.userName, this.password, this.nickName, this.watchWord, paramAccessResEntity.getWebcastId());
  }

  private void loginAttende(String paramString1, String paramString2)
  {
    int i = 8;
    if (this.serviceType == ServiceType.ST_TRAINING)
      i = 7;
    doPostRequest(paramString1, paramString2 + i, new AbsRoomSite.5(this));
  }

  private void loginHost(String paramString1, String paramString2)
  {
    doPostRequest(paramString1, paramString2 + 3, new AbsRoomSite.3(this, paramString1, paramString2));
  }

  private void loginPanist(String paramString1, String paramString2)
  {
    doPostRequest(paramString1, paramString2 + 4, new AbsRoomSite.4(this, paramString1, paramString2));
  }

  private void onVerifyUserId(LoginResEntity paramLoginResEntity)
  {
    if (GenseeConfig.isUIDVerification)
      if (this.userId > 1000000000L)
        paramLoginResEntity.setUserId(this.userId);
    do
      return;
    while ((this.userId == 0L) || (this.userId == -1L));
    paramLoginResEntity.setUserId(this.userId);
  }

  protected void accessInfo(String paramString1, String paramString2)
  {
    if (!this.mHttpHandler.is3GOrWifi())
    {
      onErr(-104);
      return;
    }
    String str = this.accessAddr;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramString1;
    arrayOfObject[1] = this.serviceType.getValue();
    doPostRequest(String.format(str, arrayOfObject), "number=" + paramString2 + "&domain=" + paramString1, new AbsRoomSite.2(this));
  }

  protected void accessInfo(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, String paramString5, String paramString6, ServiceType paramServiceType)
  {
    this.userId = paramLong;
    if (paramString3 == null)
      paramString3 = "";
    this.userName = paramString3;
    this.password = paramString4;
    this.nickName = paramString5;
    this.watchWord = paramString6;
    this.domain = paramString1;
    this.number = paramString2;
    this.serviceType = paramServiceType;
    accessInfo(paramString1, paramString2);
  }

  protected void initLog(Context paramContext)
  {
    GenseeLog.initLog();
  }

  public void initWithGensee(InitParam paramInitParam)
  {
    if ((paramInitParam == null) || (!paramInitParam.isValid()))
      onErr(-107);
    String str3;
    label162: label170: 
    do
    {
      return;
      initLog(null);
      this.userId = paramInitParam.getUserId();
      this.userName = paramInitParam.getLoginAccount();
      String str1;
      if (this.userName == null)
      {
        str1 = "";
        this.userName = str1;
        this.password = paramInitParam.getLoginPwd();
        this.nickName = paramInitParam.getNickName();
        if (this.nickName != null)
          break label162;
      }
      for (String str2 = ""; ; str2 = this.nickName)
      {
        this.nickName = str2;
        this.watchWord = paramInitParam.getJoinPwd();
        this.domain = paramInitParam.getDomain();
        this.number = paramInitParam.getNumber();
        this.serviceType = paramInitParam.getServiceType();
        this.userData = paramInitParam.getUserData();
        str3 = paramInitParam.getLiveId();
        if (StringUtil.isEmpty(this.number))
          break label170;
        accessInfo(this.domain, this.number);
        return;
        str1 = this.userName;
        break;
      }
    }
    while (StringUtil.isEmpty(str3));
    login(this.domain, this.userName, this.password, this.nickName, this.watchWord, str3);
  }

  @Deprecated
  public void initWithGensee(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, ServiceType paramServiceType)
  {
    accessInfo(paramString1, paramString2, -1L, paramString3, paramString4, paramString5, paramString6, paramServiceType);
  }

  public boolean isbAttendeeOnly()
  {
    return this.bAttendeeOnly;
  }

  protected void login(AccessResEntity paramAccessResEntity, InitParam paramInitParam)
  {
    login(paramInitParam.getDomain(), paramInitParam.getLoginAccount(), paramInitParam.getLoginPwd(), paramInitParam.getNickName(), paramInitParam.getJoinPwd(), paramAccessResEntity.getWebcastId());
  }

  protected void login(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if (!this.mHttpHandler.is3GOrWifi())
    {
      onErr(-104);
      return;
    }
    String str1 = this.loginAddr;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramString1;
    arrayOfObject[1] = this.serviceType.getValue();
    String str2 = String.format(str1, arrayOfObject);
    try
    {
      String str6 = URLEncoder.encode(paramString2, "utf-8");
      str3 = str6;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      try
      {
        while (true)
        {
          String str5 = URLEncoder.encode(paramString4, "utf-8");
          paramString4 = str5;
          if (StringUtil.isEmpty(paramString4))
            paramString4 = str3;
          if (paramString3 == null)
            paramString3 = "";
          if (paramString5 == null)
            paramString5 = "";
          str4 = "login=" + str3 + "&password=" + paramString3 + "&watchword=" + paramString5 + "&webcastId=" + paramString6 + "&nickName=" + paramString4 + "&role=";
          if (this.bAttendeeOnly)
            break;
          loginHost(str2, str4);
          return;
          localUnsupportedEncodingException = localUnsupportedEncodingException;
          localUnsupportedEncodingException.printStackTrace();
          String str3 = paramString2;
        }
      }
      catch (Exception localException)
      {
        String str4;
        while (true)
          localException.printStackTrace();
        loginAttende(str2, str4);
      }
    }
  }

  protected boolean onAccessResult(AccessResEntity paramAccessResEntity)
  {
    if (paramAccessResEntity != null)
    {
      if (paramAccessResEntity.isLiveEnable())
        break label18;
      login(paramAccessResEntity);
    }
    while (true)
    {
      return false;
      label18: this.mHttpHandler.onError(-108, "");
    }
  }

  protected abstract void onErr(int paramInt);

  protected abstract void onLoginEnd(LoginResEntity paramLoginResEntity);

  public void setBox(boolean paramBoolean)
  {
    this.mHttpHandler.setBox(paramBoolean);
  }

  public void setbAttendeeOnly(boolean paramBoolean)
  {
    this.bAttendeeOnly = paramBoolean;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.net.AbsRoomSite
 * JD-Core Version:    0.6.0
 */