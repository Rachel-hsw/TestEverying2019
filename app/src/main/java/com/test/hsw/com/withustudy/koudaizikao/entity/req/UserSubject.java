package com.withustudy.koudaizikao.entity.req;

import java.io.Serializable;

public class UserSubject
  implements Serializable
{
  protected String clientType;
  protected String imei;
  protected String net;
  private String subjectId;
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

  public String getNet()
  {
    return this.net;
  }

  public String getSubjectId()
  {
    return this.subjectId;
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

  public void setNet(String paramString)
  {
    this.net = paramString;
  }

  public void setSubjectId(String paramString)
  {
    this.subjectId = paramString;
  }

  public void setUid(String paramString)
  {
    this.uid = paramString;
  }

  public void setVersionName(String paramString)
  {
    this.versionName = paramString;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.entity.req.UserSubject
 * JD-Core Version:    0.6.0
 */