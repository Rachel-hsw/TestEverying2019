package com.gensee.entity;

import java.util.Arrays;
import java.util.List;

public class DocInfo
{
  private int docId;
  private String docName;
  private int pageNum;
  private PageInfo[] pages;
  private int type;

  public int getDocId()
  {
    return this.docId;
  }

  public String getDocName()
  {
    return this.docName;
  }

  public int getPageNum()
  {
    return this.pageNum;
  }

  public List<PageInfo> getPages()
  {
    if (this.pages == null)
      return null;
    return Arrays.asList(this.pages);
  }

  public int getType()
  {
    return this.type;
  }

  public void setDocId(int paramInt)
  {
    this.docId = paramInt;
  }

  public void setDocName(String paramString)
  {
    this.docName = paramString;
  }

  public void setPageNum(int paramInt)
  {
    this.pageNum = paramInt;
  }

  public void setPages(PageInfo[] paramArrayOfPageInfo)
  {
    if (paramArrayOfPageInfo == null);
    for (int i = 0; ; i = paramArrayOfPageInfo.length)
    {
      this.pageNum = i;
      this.pages = paramArrayOfPageInfo;
      return;
    }
  }

  public void setType(int paramInt)
  {
    this.type = paramInt;
  }

  public String toString()
  {
    return "DocInfo [docName=" + this.docName + ", pageNum=" + this.pageNum + ", docId=" + this.docId + ", type=" + this.type + ", pages=" + Arrays.toString(this.pages) + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.entity.DocInfo
 * JD-Core Version:    0.6.0
 */