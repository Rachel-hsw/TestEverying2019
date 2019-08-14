package com.withustudy.koudaizikao.fragment;

import com.withustudy.koudaizikao.entity.ErrorExercise;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;

class j
  implements Comparator<Map.Entry<String, List<ErrorExercise>>>
{
  j(ErrorListFragement paramErrorListFragement)
  {
  }

  public int a(Map.Entry<String, List<ErrorExercise>> paramEntry1, Map.Entry<String, List<ErrorExercise>> paramEntry2)
  {
    return Integer.parseInt(((String)paramEntry1.getKey()).split("_")[1]) - Integer.parseInt(((String)paramEntry2.getKey()).split("_")[1]);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.fragment.j
 * JD-Core Version:    0.6.0
 */