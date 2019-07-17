package com.gensee.entity;

import com.gensee.common.ServiceType;

public class InitParam
{
  private String domain;
  private String joinPwd;
  private String liveId;
  private String loginAccount;
  private String loginPwd;
  private String nickName;
  private String number;
  private ServiceType serviceType;
  private String userData = "";
  private long userId = -1L;

  public String getDomain()
  {
    return this.domain;
  }

  public String getJoinPwd()
  {
    return this.joinPwd;
  }

  public String getLiveId()
  {
    return this.liveId;
  }

  public String getLoginAccount()
  {
    return this.loginAccount;
  }

  public String getLoginPwd()
  {
    return this.loginPwd;
  }

  public String getNickName()
  {
    return this.nickName;
  }

  public String getNumber()
  {
    return this.number;
  }

  public ServiceType getServiceType()
  {
    return this.serviceType;
  }

  public String getUserData()
  {
    return this.userData;
  }

  public long getUserId()
  {
    return this.userId;
  }

  public String getVodDomain()
  {
    return this.domain;
  }

  public String getVodLoginName()
  {
    return this.loginAccount;
  }

  public String getVodLoginPwd()
  {
    return this.loginPwd;
  }

  public String getVodNickName()
  {
    return this.nickName;
  }

  public String getVodNumber()
  {
    return this.number;
  }

  public String getVodPwd()
  {
    return this.joinPwd;
  }

  public ServiceType getVodSType()
  {
    return this.serviceType;
  }

  public boolean isValid()
  {
    if ((this.domain == null) || ("".equals(this.domain)));
    do
      return false;
    while (((this.number == null) || ("".equals(this.number))) && ((this.liveId == null) || ("".equals(this.liveId)) || (this.serviceType == null)));
    return true;
  }

  public void setDomain(String paramString)
  {
    this.domain = paramString;
  }

  public void setJoinPwd(String paramString)
  {
    this.joinPwd = paramString;
  }

  public void setLiveId(String paramString)
  {
    this.liveId = paramString;
  }

  public void setLoginAccount(String paramString)
  {
    this.loginAccount = paramString;
  }

  public void setLoginPwd(String paramString)
  {
    this.loginPwd = paramString;
  }

  public void setNickName(String paramString)
  {
    this.nickName = paramString;
  }

  public void setNumber(String paramString)
  {
    this.number = paramString;
  }

  public void setServiceType(ServiceType paramServiceType)
  {
    this.serviceType = paramServiceType;
  }

  public void setUserData(String paramString)
  {
    this.userData = paramString;
  }

  public void setUserId(long paramLong)
  {
    this.userId = paramLong;
  }

  @Deprecated
  public void setVodDomain(String paramString)
  {
    this.domain = paramString;
  }

  @Deprecated
  public void setVodLoginName(String paramString)
  {
    this.loginAccount = paramString;
  }

  @Deprecated
  public void setVodLoginPwd(String paramString)
  {
    this.loginPwd = paramString;
  }

  @Deprecated
  public void setVodNickName(String paramString)
  {
    this.nickName = paramString;
  }

  @Deprecated
  public void setVodNumber(String paramString)
  {
    this.number = paramString;
  }

  public void setVodPwd(String paramString)
  {
    this.joinPwd = paramString;
  }

  @Deprecated
  public void setVodSType(ServiceType paramServiceType)
  {
    this.serviceType = paramServiceType;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.entity.InitParam
 * JD-Core Version:    0.6.0
 */