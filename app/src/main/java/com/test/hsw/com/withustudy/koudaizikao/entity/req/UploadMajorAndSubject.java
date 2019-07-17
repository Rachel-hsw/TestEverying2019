package com.withustudy.koudaizikao.entity.req;

import com.withustudy.koudaizikao.entity.MajorAndSubject;

public class UploadMajorAndSubject
{
  protected String clientType;
  protected String imei;
  private MajorAndSubject majorSubject;
  protected String net;
  private String uid;
  protected String versionName;

  public String getClientType()
  {
    return this.clientType;
  }

  public String getImei()
  {
    return this.imei;
  }

  public MajorAndSubject getMajorSubject()
  {
    return this.majorSubject;
  }

  public String getNet()
  {
    return this.net;
  }

  public String getUid()
  {
    return this.uid;
  }

  public String getVersionName()
  {
    return this.versionName;
  }

  public void setClientType(String paramString)
  {
    this.clientType = paramString;
  }

  public void setImei(String paramString)
  {
    this.imei = paramString;
  }

  public void setMajorSubject(MajorAndSubject paramMajorAndSubject)
  {
    this.majorSubject = paramMajorAndSubject;
  }

  public void setNet(String paramString)
  {
    this.net = paramString;
  }

  public void setUid(String paramString)
  {
    this.uid = paramString;
  }

  public void setVersionName(String paramString)
  {
    this.versionName = paramString;
  }

  public String toString()
  {
    return "UploadMajorAndSubject [uid=" + this.uid + ", majorSubject=" + this.majorSubject + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.entity.req.UploadMajorAndSubject
 * JD-Core Version:    0.6.0
 */