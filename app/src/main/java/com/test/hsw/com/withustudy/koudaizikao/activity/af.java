package com.withustudy.koudaizikao.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.withustudy.koudaizikao.entity.Section;
import com.withustudy.koudaizikao.entity.SectionKpointSummary;

class af
  implements View.OnClickListener
{
  af(KnowledgeExplainActivity.a parama, SectionKpointSummary paramSectionKpointSummary)
  {
  }

  public void onClick(View paramView)
  {
    KnowledgeExplainActivity.a(KnowledgeExplainActivity.a.a(this.a), new Bundle());
    Section localSection = this.b.getSection();
    String str1 = localSection.getId();
    String str2 = localSection.getName();
    String str3 = localSection.getSn();
    KnowledgeExplainActivity.i(KnowledgeExplainActivity.a.a(this.a)).putString("subjectId", KnowledgeExplainActivity.j(KnowledgeExplainActivity.a.a(this.a)));
    KnowledgeExplainActivity.i(KnowledgeExplainActivity.a.a(this.a)).putString("sectionId", str1);
    KnowledgeExplainActivity.i(KnowledgeExplainActivity.a.a(this.a)).putString("sectionName", str2);
    KnowledgeExplainActivity.i(KnowledgeExplainActivity.a.a(this.a)).putString("sectionSn", str3);
    KnowledgeExplainActivity.a.a(this.a).startNewActivity(KnowledgePointDetailActivity.class, 2130968591, 2130968589, false, KnowledgeExplainActivity.i(KnowledgeExplainActivity.a.a(this.a)));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.af
 * JD-Core Version:    0.6.0
 */