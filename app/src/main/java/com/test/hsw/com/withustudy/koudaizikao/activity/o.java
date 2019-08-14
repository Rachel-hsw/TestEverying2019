package com.withustudy.koudaizikao.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.koudai.test.BrushExcerciseDetailActivity;
import com.withustudy.koudaizikao.entity.Section;
import com.withustudy.koudaizikao.entity.SectionSummary;

class o
  implements View.OnClickListener
{
  o(ChapterSectionListActivity.a parama, SectionSummary paramSectionSummary)
  {
  }

  public void onClick(View paramView)
  {
    Bundle localBundle = new Bundle();
    Section localSection = this.b.getSection();
    String str1 = localSection.getId();
    String str2 = localSection.getName();
    String str3 = localSection.getSn();
    localBundle.putString("totalExerciseNum", this.b.getTotalExerciseNum());
    localBundle.putString("section_id", str1);
    localBundle.putString("section_name", str2);
    localBundle.putString("section_sn", str3);
    localBundle.putString("subjectName", ChapterSectionListActivity.h(ChapterSectionListActivity.a.a(this.a)));
    localBundle.putString("subjectId", ChapterSectionListActivity.i(ChapterSectionListActivity.a.a(this.a)));
    localBundle.putInt("BrushPageFrom", 9);
    ChapterSectionListActivity.a.a(this.a).startNewActivity(BrushExcerciseDetailActivity.class, 2130968591, 2130968589, false, localBundle);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.o
 * JD-Core Version:    0.6.0
 */