package com.withustudy.koudaizikao.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.withustudy.koudaizikao.entity.ChapterKpointSummary;
import com.withustudy.koudaizikao.entity.Section;
import com.withustudy.koudaizikao.entity.SectionKpointSummary;
import com.withustudy.koudaizikao.g.j;
import com.withustudy.koudaizikao.g.n;
import java.util.HashMap;
import java.util.List;

class ag
  implements View.OnClickListener
{
  ag(KnowledgeExplainActivity.a parama, int paramInt, KnowledgeExplainActivity.b paramb, ChapterKpointSummary paramChapterKpointSummary)
  {
  }

  public void onClick(View paramView)
  {
    Boolean localBoolean = (Boolean)KnowledgeExplainActivity.h(KnowledgeExplainActivity.a.a(this.a)).get(Integer.valueOf(this.b));
    if ((localBoolean == null) || (!localBoolean.booleanValue()))
    {
      KnowledgeExplainActivity.b.f(this.c).setVisibility(0);
      KnowledgeExplainActivity.b.g(this.c).setVisibility(8);
      KnowledgeExplainActivity.b.e(this.c).setVisibility(0);
      LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)KnowledgeExplainActivity.b.d(this.c).getLayoutParams();
      localLayoutParams1.leftMargin = n.a(KnowledgeExplainActivity.a.a(this.a).getApplicationContext(), 25.0F);
      KnowledgeExplainActivity.b.d(this.c).setLayoutParams(localLayoutParams1);
      if ((KnowledgeExplainActivity.b.f(this.c) != null) && (KnowledgeExplainActivity.b.f(this.c).getChildCount() > 0))
        KnowledgeExplainActivity.b.f(this.c).removeAllViews();
      List localList = this.d.getSectionKpointSummary();
      j.a("knowledgeItemList", Integer.valueOf(localList.size()));
      for (int i = 0; ; i++)
      {
        if (i >= localList.size())
        {
          KnowledgeExplainActivity.h(KnowledgeExplainActivity.a.a(this.a)).put(Integer.valueOf(this.b), Boolean.valueOf(true));
          return;
        }
        SectionKpointSummary localSectionKpointSummary = (SectionKpointSummary)localList.get(i);
        LinearLayout localLinearLayout = (LinearLayout)View.inflate(KnowledgeExplainActivity.a.a(this.a).getApplicationContext(), 2130903227, null);
        ((TextView)localLinearLayout.findViewById(2131297399)).setText("共" + localSectionKpointSummary.getTotalKpointNum() + "个知识点,已学" + localSectionKpointSummary.getLearnedKpointNum() + "个知识点");
        ((TextView)localLinearLayout.findViewById(2131297398)).setText(localSectionKpointSummary.getSection().getName());
        ((ImageButton)localLinearLayout.findViewById(2131297400)).setOnClickListener(KnowledgeExplainActivity.a.a(this.a));
        localLinearLayout.setOnClickListener(new ah(this, localSectionKpointSummary));
        KnowledgeExplainActivity.b.f(this.c).addView(localLinearLayout);
      }
    }
    KnowledgeExplainActivity.b.f(this.c).setVisibility(8);
    KnowledgeExplainActivity.b.e(this.c).setVisibility(8);
    LinearLayout.LayoutParams localLayoutParams2 = (LinearLayout.LayoutParams)KnowledgeExplainActivity.b.d(this.c).getLayoutParams();
    localLayoutParams2.leftMargin = n.a(KnowledgeExplainActivity.a.a(this.a).getApplicationContext(), 15.0F);
    KnowledgeExplainActivity.b.d(this.c).setLayoutParams(localLayoutParams2);
    KnowledgeExplainActivity.b.g(this.c).setVisibility(0);
    if ((KnowledgeExplainActivity.b.f(this.c) != null) && (KnowledgeExplainActivity.b.f(this.c).getChildCount() > 0))
      KnowledgeExplainActivity.b.f(this.c).removeAllViews();
    KnowledgeExplainActivity.h(KnowledgeExplainActivity.a.a(this.a)).put(Integer.valueOf(this.b), Boolean.valueOf(false));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.ag
 * JD-Core Version:    0.6.0
 */