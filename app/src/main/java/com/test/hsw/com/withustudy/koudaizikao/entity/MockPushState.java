package com.withustudy.koudaizikao.entity;

import java.io.Serializable;

public class MockPushState
  implements Serializable
{
  private MoackStat moackStat;
  private ResponseStatus responseStatus;
  private Scholarship scholarship;

  public MoackStat getMoackStat()
  {
    return this.moackStat;
  }

  public ResponseStatus getResponseStatus()
  {
    return this.responseStatus;
  }

  public Scholarship getScholarship()
  {
    return this.scholarship;
  }

  public void setMoackStat(MoackStat paramMoackStat)
  {
    this.moackStat = paramMoackStat;
  }

  public void setResponseStatus(ResponseStatus paramResponseStatus)
  {
    this.responseStatus = paramResponseStatus;
  }

  public void setScholarship(Scholarship paramScholarship)
  {
    this.scholarship = paramScholarship;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.entity.MockPushState
 * JD-Core Version:    0.6.0
 */