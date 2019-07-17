package com.gensee.entity;

import java.io.Serializable;

public class AccessResEntity
  implements Serializable
{
  private static final String NEED = "1";
  private static final long serialVersionUID = 6593051656166208739L;
  private String code;
  private boolean liveEnable;
  private String loginTag;
  private String reason;
  private String result;
  private long startTime;
  private String subject;
  private String watchword;
  private String webOnly;
  private String webcastId;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    AccessResEntity localAccessResEntity;
    do
      while (true)
      {
        return true;
        if (paramObject == null)
          return false;
        if (getClass() != paramObject.getClass())
          return false;
        localAccessResEntity = (AccessResEntity)paramObject;
        if (this.webcastId != null)
          break;
        if (localAccessResEntity.webcastId != null)
          return false;
      }
    while (this.webcastId.equals(localAccessResEntity.webcastId));
    return false;
  }

  public String getCode()
  {
    return this.code;
  }

  public String getLoginTag()
  {
    return this.loginTag;
  }

  public String getReason()
  {
    return this.reason;
  }

  public String getResult()
  {
    return this.result;
  }

  public long getStartTime()
  {
    return this.startTime;
  }

  public String getSubject()
  {
    return this.subject;
  }

  public String getWatchword()
  {
    return this.watchword;
  }

  public String getWebOnly()
  {
    return this.webOnly;
  }

  public String getWebcastId()
  {
    return this.webcastId;
  }

  public int hashCode()
  {
    if (this.webcastId == null);
    for (int i = 0; ; i = this.webcastId.hashCode())
      return i + 31;
  }

  public boolean isLiveEnable()
  {
    return this.liveEnable;
  }

  public boolean isNeedLogin()
  {
    return "1".equals(getLoginTag());
  }

  public boolean isNeedWatch()
  {
    return "1".equals(getWatchword());
  }

  public void setCode(String paramString)
  {
    this.code = paramString;
  }

  public void setLiveEnable(boolean paramBoolean)
  {
    this.liveEnable = paramBoolean;
  }

  public void setLoginTag(String paramString)
  {
    this.loginTag = paramString;
  }

  public void setReason(String paramString)
  {
    this.reason = paramString;
  }

  public void setResult(String paramString)
  {
    this.result = paramString;
  }

  public void setStartTime(long paramLong)
  {
    this.startTime = paramLong;
  }

  public void setSubject(String paramString)
  {
    this.subject = paramString;
  }

  public void setWatchword(String paramString)
  {
    this.watchword = paramString;
  }

  public void setWebOnly(String paramString)
  {
    this.webOnly = paramString;
  }

  public void setWebcastId(String paramString)
  {
    this.webcastId = paramString;
  }

  public String toString()
  {
    return "AccessResEntity [webcastId=" + this.webcastId + ", loginTag=" + this.loginTag + ", watchword=" + this.watchword + ", subject=" + this.subject + ", startTime=" + this.startTime + ", result=" + this.result + ", reason=" + this.reason + ", code=" + this.code + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.entity.AccessResEntity
 * JD-Core Version:    0.6.0
 */