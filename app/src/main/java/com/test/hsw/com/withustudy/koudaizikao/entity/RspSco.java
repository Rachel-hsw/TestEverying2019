package com.withustudy.koudaizikao.entity;

import java.io.Serializable;

public class RspSco
  implements Serializable
{
  private int amount;
  private boolean getScholarship;
  private String status;

  public int getAmount()
  {
    return this.amount;
  }

  public String getStatus()
  {
    return this.status;
  }

  public boolean isGetScholarship()
  {
    return this.getScholarship;
  }

  public void setAmount(int paramInt)
  {
    this.amount = paramInt;
  }

  public void setGetScholarship(boolean paramBoolean)
  {
    this.getScholarship = paramBoolean;
  }

  public void setStatus(String paramString)
  {
    this.status = paramString;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.entity.RspSco
 * JD-Core Version:    0.6.0
 */