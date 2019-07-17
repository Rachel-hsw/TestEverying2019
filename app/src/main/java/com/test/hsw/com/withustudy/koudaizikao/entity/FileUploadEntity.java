package com.withustudy.koudaizikao.entity;

public class FileUploadEntity
{
  private String status;
  private String url;

  public String getStatus()
  {
    return this.status;
  }

  public String getUrl()
  {
    return this.url;
  }

  public void setStatus(String paramString)
  {
    this.status = paramString;
  }

  public void setUrl(String paramString)
  {
    this.url = paramString;
  }

  public String toString()
  {
    return "FileUpload [url=" + this.url + ", status=" + this.status + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.entity.FileUploadEntity
 * JD-Core Version:    0.6.0
 */