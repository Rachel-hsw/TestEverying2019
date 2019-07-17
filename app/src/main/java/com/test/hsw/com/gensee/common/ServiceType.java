package com.gensee.common;

public enum ServiceType
{
  private String value;

  static
  {
    ServiceType[] arrayOfServiceType = new ServiceType[3];
    arrayOfServiceType[0] = ST_CASTLINE;
    arrayOfServiceType[1] = ST_MEETING;
    arrayOfServiceType[2] = ST_TRAINING;
    ENUM$VALUES = arrayOfServiceType;
  }

  private ServiceType(String arg3)
  {
    Object localObject;
    this.value = localObject;
  }

  public String getValue()
  {
    return this.value;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.common.ServiceType
 * JD-Core Version:    0.6.0
 */