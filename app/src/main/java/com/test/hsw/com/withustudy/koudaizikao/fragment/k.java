package com.withustudy.koudaizikao.fragment;

import com.withustudy.koudaizikao.entity.ErrorExercise;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;

class k
  implements Comparator<Map.Entry<String, List<ErrorExercise>>>
{
  k(ErrorListFragement paramErrorListFragement)
  {
  }

  public int a(Map.Entry<String, List<ErrorExercise>> paramEntry1, Map.Entry<String, List<ErrorExercise>> paramEntry2)
  {
    String str = (String)paramEntry1.getKey();
    return ((String)paramEntry2.getKey()).compareTo(str);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.fragment.k
 * JD-Core Version:    0.6.0
 */