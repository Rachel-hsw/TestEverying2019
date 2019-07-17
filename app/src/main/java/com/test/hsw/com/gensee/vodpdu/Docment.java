package com.gensee.vodpdu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Docment
  implements Serializable
{
  private static final long serialVersionUID = 578057251179188885L;
  private List<DocPage> pages;
  private String title;

  public Docment(PduDoc paramPduDoc)
  {
    this.title = paramPduDoc.getDocName();
    List localList = paramPduDoc.getPages();
    Iterator localIterator;
    if ((localList != null) && (localList.size() > 0))
    {
      this.pages = new ArrayList();
      localIterator = localList.iterator();
    }
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      PduPage localPduPage = (PduPage)localIterator.next();
      this.pages.add(new DocPage(localPduPage));
    }
  }

  public List<DocPage> getPages()
  {
    return this.pages;
  }

  public String getTitle()
  {
    return this.title;
  }

  public void setPages(List<DocPage> paramList)
  {
    this.pages = paramList;
  }

  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.vodpdu.Docment
 * JD-Core Version:    0.6.0
 */