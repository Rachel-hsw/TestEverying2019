package com.gensee.entity;

import java.io.Serializable;

public class VodParam extends VodPlayParam
  implements Serializable
{
  private static final long serialVersionUID = -2627483418112458274L;
  private String albPort = "80";
  private String confId;
  private String connectSvr;
  private String domain;
  public long lastPlayTime = 0L;
  private String result;
  private int sc = 0;
  private String service = "";
  private String sessionId;
  private String siteId;
  public long startPlayTime = 0L;
  private String tid;
  private String vodId;
  public long watchMaxDuration = 0L;

  public String getAlbPort()
  {
    return this.albPort;
  }

  public String getConfId()
  {
    return this.confId;
  }

  public String getConnectSvr()
  {
    return this.connectSvr;
  }

  public String getDomain()
  {
    return this.domain;
  }

  public String getResult()
  {
    return this.result;
  }

  public int getSc()
  {
    return this.sc;
  }

  public String getService()
  {
    return this.service;
  }

  public String getSessionId()
  {
    return this.sessionId;
  }

  public String getSiteId()
  {
    return this.siteId;
  }

  public String getTid()
  {
    return this.tid;
  }

  public String getVodId()
  {
    return this.vodId;
  }

  public void setAlbPort(String paramString)
  {
    this.albPort = paramString;
  }

  public void setConfId(String paramString)
  {
    this.confId = paramString;
  }

  public void setConnectSvr(String paramString)
  {
    this.connectSvr = paramString;
  }

  public void setDomain(String paramString)
  {
    this.domain = paramString;
  }

  public void setResult(String paramString)
  {
    this.result = paramString;
  }

  public void setSc(int paramInt)
  {
    this.sc = paramInt;
  }

  public void setService(String paramString)
  {
    this.service = paramString;
  }

  public void setSessionId(String paramString)
  {
    this.sessionId = paramString;
  }

  public void setSiteId(String paramString)
  {
    this.siteId = paramString;
  }

  public void setTid(String paramString)
  {
    this.tid = paramString;
  }

  public void setVodId(String paramString)
  {
    this.vodId = paramString;
  }

  public String toString()
  {
    return "VodParam [domain=" + this.domain + ", sessionId=" + this.sessionId + ", service=" + this.service + ", startPlayTime=" + this.startPlayTime + ", lastPlayTime=" + this.lastPlayTime + ", watchMaxDuration=" + this.watchMaxDuration + ", siteId=" + this.siteId + ", confId=" + this.confId + ", vodId=" + this.vodId + ", tid=" + this.tid + ", albPort=" + this.albPort + ", connectSvr=" + this.connectSvr + ", result=" + this.result + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.entity.VodParam
 * JD-Core Version:    0.6.0
 */