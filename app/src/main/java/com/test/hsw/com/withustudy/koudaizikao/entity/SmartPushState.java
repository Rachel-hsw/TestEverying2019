package com.withustudy.koudaizikao.entity;

import java.io.Serializable;

public class SmartPushState
  implements Serializable
{
  private ResponseStatus responseStatus;
  private Scholarship scholarship;
  private SmartStat smartStat;

  public ResponseStatus getResponseStatus()
  {
    return this.responseStatus;
  }

  public Scholarship getScholarship()
  {
    return this.scholarship;
  }

  public SmartStat getSmartStat()
  {
    return this.smartStat;
  }

  public void setResponseStatus(ResponseStatus paramResponseStatus)
  {
    this.responseStatus = paramResponseStatus;
  }

  public void setScholarship(Scholarship paramScholarship)
  {
    this.scholarship = paramScholarship;
  }

  public void setSmartStat(SmartStat paramSmartStat)
  {
    this.smartStat = paramSmartStat;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.entity.SmartPushState
 * JD-Core Version:    0.6.0
 */