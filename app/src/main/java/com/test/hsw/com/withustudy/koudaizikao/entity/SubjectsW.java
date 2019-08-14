package com.withustudy.koudaizikao.entity;

import java.io.Serializable;
import java.util.List;

public class SubjectsW
  implements Serializable
{
  private List<Subjects> subjects;

  public List<Subjects> getSubjects()
  {
    return this.subjects;
  }

  public void setSubjects(List<Subjects> paramList)
  {
    this.subjects = paramList;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.entity.SubjectsW
 * JD-Core Version:    0.6.0
 */