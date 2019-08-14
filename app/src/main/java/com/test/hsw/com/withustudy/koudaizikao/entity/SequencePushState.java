package com.withustudy.koudaizikao.entity;

import java.io.Serializable;

public class SequencePushState
  implements Serializable
{
  private ResponseStatus responseStatus;
  private Scholarship scholarship;
  private SectionStat sectionStat;

  public ResponseStatus getResponseStatus()
  {
    return this.responseStatus;
  }

  public Scholarship getScholarship()
  {
    return this.scholarship;
  }

  public SectionStat getSectionStat()
  {
    return this.sectionStat;
  }

  public void setResponseStatus(ResponseStatus paramResponseStatus)
  {
    this.responseStatus = paramResponseStatus;
  }

  public void setScholarship(Scholarship paramScholarship)
  {
    this.scholarship = paramScholarship;
  }

  public void setSectionStat(SectionStat paramSectionStat)
  {
    this.sectionStat = paramSectionStat;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.entity.SequencePushState
 * JD-Core Version:    0.6.0
 */