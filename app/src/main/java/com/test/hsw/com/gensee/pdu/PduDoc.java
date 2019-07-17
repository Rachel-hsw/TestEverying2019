package com.gensee.pdu;

import com.gensee.utils.GenseeLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PduDoc extends PduBase
{
  public static final int RT_PD_DOCUMENT_BMP = 8;
  public static final int RT_PD_DOCUMENT_EMF = 6;
  public static final int RT_PD_DOCUMENT_EXCEL = 4;
  public static final int RT_PD_DOCUMENT_JPEG = 5;
  public static final int RT_PD_DOCUMENT_PDF = 7;
  public static final int RT_PD_DOCUMENT_PPT = 1;
  public static final int RT_PD_DOCUMENT_PPTX = 10;
  public static final int RT_PD_DOCUMENT_SWF = 9;
  public static final int RT_PD_DOCUMENT_SWF_VERYDOC = 16;
  public static final int RT_PD_DOCUMENT_TXT = 3;
  public static final int RT_PD_DOCUMENT_WORD = 2;
  public static final int RT_PD_WHITEBOARD = 32;
  private static final String TAG = "PduDoc";
  protected byte dataType;
  private int docId;
  private String docName;
  private int docType;
  private PduPage mCurPage;
  private List<PduPage> mPages;
  private long ownerId;
  private int pageCount;
  protected int pageIndex;
  private byte savedOnServer;

  public PduDoc()
  {
    this.mPages = new ArrayList(0);
  }

  public PduDoc(int paramInt)
  {
    this.docId = paramInt;
  }

  private PduPage getPageById(long paramLong)
  {
    synchronized (this.mPages)
    {
      Iterator localIterator = this.mPages.iterator();
      PduPage localPduPage;
      do
      {
        if (!localIterator.hasNext())
          return null;
        localPduPage = (PduPage)localIterator.next();
      }
      while ((localPduPage == null) || (localPduPage.getPageId() != paramLong));
      return localPduPage;
    }
  }

  public int addAnno(AbsAnno paramAbsAnno)
  {
    if ((this.mCurPage != null) && (this.mCurPage.getPageId() == paramAbsAnno.getPageId()))
      return this.mCurPage.addAnno(paramAbsAnno, false);
    PduPage localPduPage = getPageById(paramAbsAnno.getPageId());
    if (localPduPage != null)
      localPduPage.addAnno(paramAbsAnno, false);
    return -1;
  }

  public boolean addPage(PduPage paramPduPage)
  {
    if (paramPduPage == null)
      return false;
    synchronized (this.mPages)
    {
      if (!this.mPages.contains(paramPduPage))
      {
        boolean bool = this.mPages.add(paramPduPage);
        return bool;
      }
    }
    monitorexit;
    return false;
  }

  public PduPage changeCurrentPage(int paramInt)
  {
    if (this.mPages == null)
      GenseeLog.e("PduDoc", "changeCurrentPage pages is null");
    do
      return null;
    while (paramInt >= this.mPages.size());
    PduPage localPduPage = (PduPage)this.mPages.get(paramInt);
    this.mCurPage = localPduPage;
    return localPduPage;
  }

  public boolean changePoint(AbsAnno paramAbsAnno)
  {
    if ((this.mCurPage != null) && (this.mCurPage.getPageId() == paramAbsAnno.getPageId()))
      return this.mCurPage.changePoint(paramAbsAnno);
    PduPage localPduPage = getPageById(paramAbsAnno.getPageId());
    if (localPduPage != null)
      localPduPage.changePoint(paramAbsAnno);
    return false;
  }

  public void clean(boolean paramBoolean)
  {
    Iterator localIterator = this.mPages.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        this.mPages.clear();
        this.mCurPage = null;
        return;
      }
      PduPage localPduPage = (PduPage)localIterator.next();
      if ((paramBoolean) && (localPduPage != null) && (localPduPage.equals(this.mCurPage)))
      {
        localPduPage.setPageId(-1);
        localPduPage.setDocId(-1);
        continue;
      }
      localPduPage.clear();
    }
  }

  public boolean delAnno(AbsAnno paramAbsAnno)
  {
    if ((this.mCurPage != null) && (this.mCurPage.getPageId() == paramAbsAnno.getPageId()))
      return this.mCurPage.delAnno(paramAbsAnno);
    PduPage localPduPage = getPageById(paramAbsAnno.getPageId());
    if (localPduPage != null)
      localPduPage.delAnno(paramAbsAnno);
    return false;
  }

  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Integer))
      if (this.docId != ((Integer)paramObject).intValue());
    PduDoc localPduDoc;
    do
    {
      do
      {
        return true;
        return false;
      }
      while (this == paramObject);
      if (paramObject == null)
        return false;
      if (getClass() != paramObject.getClass())
        return false;
      localPduDoc = (PduDoc)paramObject;
    }
    while (this.docId == localPduDoc.docId);
    return false;
  }

  public PduPage getCurPage()
  {
    if (this.mCurPage == null);
    synchronized (this.mPages)
    {
      if (this.mPages.size() > 0)
        this.mCurPage = ((PduPage)this.mPages.get(0));
      return this.mCurPage;
    }
  }

  public int getCurrentPageIndex()
  {
    int i = this.mPages.indexOf(this.mCurPage);
    if (i >= 0)
      return i;
    return 0;
  }

  public int getDocId()
  {
    return this.docId;
  }

  public String getDocName()
  {
    return this.docName;
  }

  protected PduPage[] getDocPages()
  {
    int i = this.mPages.size();
    if (i > 0)
    {
      PduPage[] arrayOfPduPage = new PduPage[i];
      return (PduPage[])this.mPages.toArray(arrayOfPduPage);
    }
    return null;
  }

  public int getDocType()
  {
    return this.docType;
  }

  public PduPage getNextPage()
  {
    int i = this.mPages.indexOf(this.mCurPage);
    if ((i < -1 + this.mPages.size()) && (i >= 0))
      return (PduPage)this.mPages.get(i + 1);
    return null;
  }

  public long getOwnerId()
  {
    return this.ownerId;
  }

  public int getPageCount()
  {
    if (this.pageCount == 0)
      return this.mPages.size();
    return this.pageCount;
  }

  public List<PduPage> getPages()
  {
    return this.mPages;
  }

  public PduPage getPrePage()
  {
    int i = this.mPages.indexOf(this.mCurPage);
    if ((i < this.mPages.size()) && (i > 0))
      return (PduPage)this.mPages.get(i - 1);
    return null;
  }

  public byte getSavedOnServer()
  {
    return this.savedOnServer;
  }

  public int hashCode()
  {
    return 31 * (31 + this.dataType) + this.docId;
  }

  public PduPage onCmd(long paramLong, int paramInt)
  {
    PduPage localPduPage = getPageById(paramLong);
    if (localPduPage != null)
    {
      this.mCurPage = localPduPage;
      localPduPage.setDocId(this.docId);
      localPduPage.setAniStep(paramInt);
    }
    return localPduPage;
  }

  public void onContent(long paramLong, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    PduPage localPduPage = getPageById(paramLong);
    if (localPduPage != null)
      localPduPage.onContent(paramArrayOfByte, paramBoolean, this.docId);
  }

  public void onGlContent(long paramLong, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    PduPage localPduPage = getPageById(paramLong);
    if (localPduPage != null)
      localPduPage.onGlContent(paramArrayOfByte, paramBoolean, this.docId);
  }

  public void setDocId(int paramInt)
  {
    this.docId = paramInt;
  }

  public void setDocName(String paramString)
  {
    this.docName = paramString;
  }

  public void setDocType(int paramInt)
  {
    this.docType = paramInt;
  }

  public void setOwnerId(long paramLong)
  {
    this.ownerId = paramLong;
  }

  public void setPageCount(int paramInt)
  {
    this.pageCount = paramInt;
  }

  protected void setPages(PduPage[] paramArrayOfPduPage)
  {
    if (paramArrayOfPduPage != null)
    {
      List localList = this.mPages;
      monitorenter;
      int i = 0;
      try
      {
        while (true)
        {
          if (i >= paramArrayOfPduPage.length)
            return;
          paramArrayOfPduPage[i].setDocId(this.docId);
          this.mPages.add(paramArrayOfPduPage[i]);
          i++;
        }
      }
      finally
      {
        monitorexit;
      }
    }
  }

  public void setSavedOnServer(byte paramByte)
  {
    this.savedOnServer = paramByte;
  }

  public String toString()
  {
    return "PduDoc [docName=" + this.docName + ", docId=" + this.docId + this.mPages + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.pdu.PduDoc
 * JD-Core Version:    0.6.0
 */