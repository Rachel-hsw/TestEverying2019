package com.gensee.entity;

import java.io.Serializable;
import java.util.List;

public class LoginResEntity
  implements Serializable
{
  private static final long serialVersionUID = 330177755185499919L;
  private String ablPort;
  private String albBakServer;
  private String albServer;
  private String choosePriorNetwork;
  private String confpassword;
  private long deviceStatus;
  private PingEntity fastPingEntity;
  private String gcDomain;
  private String gcPort;
  private String idcCode;
  private String ipLibEnabled;
  private String ipowner;
  private String isNeedVisitALB;
  private String isPlay;
  private String joinType;
  private MainIdc mainIdc;
  private String mainIdcCode;
  private String nickName;
  private List<PingEntity> pingArray;
  private String responsetype;
  private String result;
  private int role;
  private String servicetype;
  private long siteId;
  private String userData = "";
  private long userId;
  private String webUrl;
  private String webcastId;
  private String webcastSubject;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    LoginResEntity localLoginResEntity;
    do
    {
      return true;
      if (paramObject == null)
        return false;
      if (getClass() != paramObject.getClass())
        return false;
      localLoginResEntity = (LoginResEntity)paramObject;
    }
    while (this.userId == localLoginResEntity.userId);
    return false;
  }

  public String getAblPort()
  {
    return this.ablPort;
  }

  public String getAlbBakServer()
  {
    return this.albBakServer;
  }

  public String getAlbServer()
  {
    return this.albServer;
  }

  public String getChoosePriorNetwork()
  {
    return this.choosePriorNetwork;
  }

  public String getConfpassword()
  {
    return this.confpassword;
  }

  public long getDeviceStatus()
  {
    return this.deviceStatus;
  }

  public PingEntity getFastPingEntity()
  {
    return this.fastPingEntity;
  }

  public String getGcDomain()
  {
    return this.gcDomain;
  }

  public String getGcPort()
  {
    return this.gcPort;
  }

  public String getIdcCode()
  {
    return this.idcCode;
  }

  public String getIpLibEnabled()
  {
    return this.ipLibEnabled;
  }

  public String getIpowner()
  {
    return this.ipowner;
  }

  public String getIsNeedVisitALB()
  {
    return this.isNeedVisitALB;
  }

  public String getIsPlay()
  {
    return this.isPlay;
  }

  public String getJoinType()
  {
    return this.joinType;
  }

  public MainIdc getMainIdc()
  {
    return this.mainIdc;
  }

  public String getMainIdcCode()
  {
    return this.mainIdcCode;
  }

  public String getNickName()
  {
    return this.nickName;
  }

  public List<PingEntity> getPingArray()
  {
    return this.pingArray;
  }

  public String getResponsetype()
  {
    return this.responsetype;
  }

  public String getResult()
  {
    return this.result;
  }

  public int getRole()
  {
    return this.role;
  }

  public String getServicetype()
  {
    return this.servicetype;
  }

  public long getSiteId()
  {
    return this.siteId;
  }

  public String getUserData()
  {
    return this.userData;
  }

  public long getUserId()
  {
    return this.userId;
  }

  public String getWebUrl()
  {
    return this.webUrl;
  }

  public String getWebcastId()
  {
    return this.webcastId;
  }

  public String getWebcastSubject()
  {
    return this.webcastSubject;
  }

  public int hashCode()
  {
    return 31 + (int)(this.userId ^ this.userId >>> 32);
  }

  public void setAblPort(String paramString)
  {
    this.ablPort = paramString;
  }

  public void setAlbBakServer(String paramString)
  {
    this.albBakServer = paramString;
  }

  public void setAlbServer(String paramString)
  {
    this.albServer = paramString;
  }

  public void setChoosePriorNetwork(String paramString)
  {
    this.choosePriorNetwork = paramString;
  }

  public void setConfpassword(String paramString)
  {
    this.confpassword = paramString;
  }

  public void setDeviceStatus(long paramLong)
  {
    this.deviceStatus = paramLong;
  }

  public void setFastPingEntity(PingEntity paramPingEntity)
  {
    this.fastPingEntity = paramPingEntity;
  }

  public void setGcDomain(String paramString)
  {
    this.gcDomain = paramString;
  }

  public void setGcPort(String paramString)
  {
    this.gcPort = paramString;
  }

  public void setIdcCode(String paramString)
  {
    this.idcCode = paramString;
  }

  public void setIpLibEnabled(String paramString)
  {
    this.ipLibEnabled = paramString;
  }

  public void setIpowner(String paramString)
  {
    this.ipowner = paramString;
  }

  public void setIsNeedVisitALB(String paramString)
  {
    this.isNeedVisitALB = paramString;
  }

  public void setIsPlay(String paramString)
  {
    this.isPlay = paramString;
  }

  public void setJoinType(String paramString)
  {
    this.joinType = paramString;
  }

  public void setMainIdc(MainIdc paramMainIdc)
  {
    this.mainIdc = paramMainIdc;
  }

  public void setMainIdcCode(String paramString)
  {
    this.mainIdcCode = paramString;
  }

  public void setNickName(String paramString)
  {
    this.nickName = paramString;
  }

  public void setPingArray(List<PingEntity> paramList)
  {
    this.pingArray = paramList;
  }

  public void setResponsetype(String paramString)
  {
    this.responsetype = paramString;
  }

  public void setResult(String paramString)
  {
    this.result = paramString;
  }

  public void setRole(int paramInt)
  {
    this.role = paramInt;
  }

  public void setServicetype(String paramString)
  {
    this.servicetype = paramString;
  }

  public void setSiteId(long paramLong)
  {
    this.siteId = paramLong;
  }

  public void setUserData(String paramString)
  {
    this.userData = paramString;
  }

  public void setUserId(long paramLong)
  {
    this.userId = paramLong;
  }

  public void setWebUrl(String paramString)
  {
    this.webUrl = paramString;
  }

  public void setWebcastId(String paramString)
  {
    this.webcastId = paramString;
  }

  public void setWebcastSubject(String paramString)
  {
    this.webcastSubject = paramString;
  }

  public String toString()
  {
    return "LoginResEntity [result=" + this.result + ", isPlay=" + this.isPlay + ", siteId=" + this.siteId + ", userId=" + this.userId + ", webcastId=" + this.webcastId + ", webcastSubject=" + this.webcastSubject + ", idcCode=" + this.idcCode + ", servicetype=" + this.servicetype + ", ipowner=" + this.ipowner + ", confpassword=" + this.confpassword + ", responsetype=" + this.responsetype + ", joinType=" + this.joinType + ", nickName=" + this.nickName + ", mainIdcCode=" + this.mainIdcCode + ", albServer=" + this.albServer + ", ablPort=" + this.ablPort + ", albBakServer=" + this.albBakServer + ", webUrl=" + this.webUrl + ", role=" + this.role + ", deviceStatus=" + this.deviceStatus + ", isNeedVisitALB=" + this.isNeedVisitALB + ", ipLibEnabled=" + this.ipLibEnabled + ", gcDomain=" + this.gcDomain + ", gcPort=" + this.gcPort + ", mainIdc=" + this.mainIdc + ", pingArray=" + this.pingArray + ", fastPingEntity=" + this.fastPingEntity + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.entity.LoginResEntity
 * JD-Core Version:    0.6.0
 */