package com.gensee.vodpdu;

import com.gensee.utils.GenseeLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PduDoc extends PduBase
{
  private static final String TAG = "PduDoc";
  private short animate;
  private long docId;
  private String docName;
  private int docType;
  private long fileHandle;
  private PduPage mCurPage;
  private List<PduPage> mPages = new ArrayList(0);
  private long ownerId;
  private int pageCount;
  private long timestamp;

  public PduDoc()
  {
    setType(513);
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
      while ((localPduPage == null) || (localPduPage.getBlockHandle() != paramLong));
      return localPduPage;
    }
  }

  public boolean addAnno(AbsAnno paramAbsAnno)
  {
    if ((this.mCurPage != null) && (this.mCurPage.getBlockHandle() == paramAbsAnno.getBlockhandle()))
      return this.mCurPage.addAnno(paramAbsAnno);
    PduPage localPduPage = getPageById(paramAbsAnno.getBlockhandle());
    if (localPduPage != null)
      localPduPage.addAnno(paramAbsAnno);
    return false;
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
    if ((this.mCurPage != null) && (this.mCurPage.getBlockHandle() == paramAbsAnno.getBlockhandle()))
      return this.mCurPage.changePoint(paramAbsAnno);
    PduPage localPduPage = getPageById(paramAbsAnno.getBlockhandle());
    if (localPduPage != null)
      localPduPage.changePoint(paramAbsAnno);
    return false;
  }

  public boolean delAnno(AbsAnno paramAbsAnno)
  {
    if ((this.mCurPage != null) && (this.mCurPage.getBlockHandle() == paramAbsAnno.getBlockhandle()))
      return this.mCurPage.delAnno(paramAbsAnno);
    PduPage localPduPage = getPageById(paramAbsAnno.getBlockhandle());
    if (localPduPage != null)
      localPduPage.delAnno(paramAbsAnno);
    return false;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    PduDoc localPduDoc;
    do
    {
      return true;
      if (paramObject == null)
        return false;
      if (getClass() != paramObject.getClass())
        return false;
      localPduDoc = (PduDoc)paramObject;
      if (this.docId != localPduDoc.docId)
        return false;
      if (this.fileHandle != localPduDoc.fileHandle)
        return false;
    }
    while (this.timestamp == localPduDoc.timestamp);
    return false;
  }

  public short getAnimate()
  {
    return this.animate;
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

  public long getDocId()
  {
    return this.docId;
  }

  public String getDocName()
  {
    return this.docName;
  }

  public int getDocType()
  {
    return this.docType;
  }

  public long getFileHandle()
  {
    return this.fileHandle;
  }

  public long getOwnerId()
  {
    return this.ownerId;
  }

  public int getPageCount()
  {
    return this.mPages.size();
  }

  public List<PduPage> getPages()
  {
    return this.mPages;
  }

  public long getTimestamp()
  {
    return this.timestamp;
  }

  public int hashCode()
  {
    return 31 * (31 * (31 + (int)(this.docId ^ this.docId >>> 32)) + (int)(this.fileHandle ^ this.fileHandle >>> 32)) + (int)(this.timestamp ^ this.timestamp >>> 32);
  }

  public void onCmd(long paramLong)
  {
    PduPage localPduPage = getPageById(paramLong);
    if (localPduPage != null)
      this.mCurPage = localPduPage;
  }

  public void onContent(long paramLong, byte[] paramArrayOfByte)
  {
    if ((this.mCurPage != null) && (this.mCurPage.getBlockHandle() == paramLong))
      this.mCurPage.onContent(paramArrayOfByte);
    PduPage localPduPage;
    do
    {
      return;
      localPduPage = getPageById(paramLong);
    }
    while (localPduPage == null);
    localPduPage.onContent(paramArrayOfByte);
  }

  public void setAnimate(short paramShort)
  {
    this.animate = paramShort;
  }

  public void setDocId(long paramLong)
  {
    this.docId = paramLong;
  }

  public void setDocName(String paramString)
  {
    this.docName = paramString;
  }

  public void setDocType(int paramInt)
  {
    this.docType = paramInt;
  }

  public void setFileHandle(long paramLong)
  {
    this.fileHandle = paramLong;
  }

  public void setOwnerId(long paramLong)
  {
    this.ownerId = paramLong;
  }

  public void setPageCount(int paramInt)
  {
    this.pageCount = paramInt;
  }

  public void setPages(List<PduPage> paramList)
  {
    this.mPages = paramList;
  }

  public void setTimestamp(long paramLong)
  {
    this.timestamp = paramLong;
  }

  public String toString()
  {
    return "PduDoc [docName=" + this.docName + ", docId=" + this.docId + ", docType=" + this.docType + ", pageCount=" + this.pageCount + ", ownerId=" + this.ownerId + ", fileHandle=" + this.fileHandle + ", animate=" + this.animate + ", mPages=" + this.mPages + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.vodpdu.PduDoc
 * JD-Core Version:    0.6.0
 */