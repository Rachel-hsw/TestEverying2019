package com.withustudy.koudaizikao.entity;

import java.io.Serializable;
import java.util.List;

public class SubjectErrorExercise
  implements Serializable
{
  private List<ErrorExercise> errorExercise;
  private Subject subject;

  public List<ErrorExercise> getErrorExercise()
  {
    return this.errorExercise;
  }

  public Subject getSubject()
  {
    return this.subject;
  }

  public void setErrorExercise(List<ErrorExercise> paramList)
  {
    this.errorExercise = paramList;
  }

  public void setSubject(Subject paramSubject)
  {
    this.subject = paramSubject;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.entity.SubjectErrorExercise
 * JD-Core Version:    0.6.0
 */