package com.withustudy.koudaizikao.entity;

import java.io.Serializable;

public class PayStatus
  implements Serializable
{
  private String msg;
  private String status;

  public String getMsg()
  {
    return this.msg;
  }

  public String getStatus()
  {
    return this.status;
  }

  public void setMsg(String paramString)
  {
    this.msg = paramString;
  }

  public void setStatus(String paramString)
  {
    this.status = paramString;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.entity.PayStatus
 * JD-Core Version:    0.6.0
 */