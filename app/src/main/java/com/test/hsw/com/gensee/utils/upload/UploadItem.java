package com.gensee.utils.upload;

public class UploadItem
{
  public static final String FILE_TYPE = "FILE_TYPE";
  public static final String VALUE_TYPE = "VALUE_TYPE";
  private String name = "";
  private String type = "";
  private String value = "";

  public String getName()
  {
    return this.name;
  }

  public String getType()
  {
    return this.type;
  }

  public String getValue()
  {
    return this.value;
  }

  public void setName(String paramString)
  {
    this.name = paramString;
  }

  public void setType(String paramString)
  {
    this.type = paramString;
  }

  public void setValue(String paramString)
  {
    this.value = paramString;
  }

  public String toString()
  {
    return "UploadItem [name=" + this.name + ", value=" + this.value + ", type=" + this.type + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.utils.upload.UploadItem
 * JD-Core Version:    0.6.0
 */