package com.withustudy.koudaizikao.entity;

import java.io.Serializable;

public class Scholarship
  implements Serializable
{
  private String activityId;
  private int amount;

  public String getActivityId()
  {
    return this.activityId;
  }

  public int getAmount()
  {
    return this.amount;
  }

  public void setActivityId(String paramString)
  {
    this.activityId = paramString;
  }

  public void setAmount(int paramInt)
  {
    this.amount = paramInt;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.entity.Scholarship
 * JD-Core Version:    0.6.0
 */