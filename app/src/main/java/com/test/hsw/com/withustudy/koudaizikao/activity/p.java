package com.withustudy.koudaizikao.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.withustudy.koudaizikao.entity.ChapterSummary;
import com.withustudy.koudaizikao.entity.Section;
import com.withustudy.koudaizikao.entity.SectionSummary;
import java.util.HashMap;
import java.util.List;

class p
  implements View.OnClickListener
{
  p(ChapterSectionListActivity.a parama, int paramInt, ChapterSectionListActivity.b paramb, ChapterSummary paramChapterSummary)
  {
  }

  public void onClick(View paramView)
  {
    Boolean localBoolean = (Boolean)ChapterSectionListActivity.g(ChapterSectionListActivity.a.a(this.a)).get(Integer.valueOf(this.b));
    List localList;
    int i;
    if ((localBoolean == null) || (!localBoolean.booleanValue()))
    {
      ChapterSectionListActivity.b.b(this.c).setVisibility(8);
      ChapterSectionListActivity.b.a(this.c).setVisibility(0);
      ChapterSectionListActivity.b.k(this.c).setVisibility(0);
      if ((ChapterSectionListActivity.b.k(this.c) != null) && (ChapterSectionListActivity.b.k(this.c).getChildCount() > 0))
        ChapterSectionListActivity.b.k(this.c).removeAllViews();
      localList = this.d.getSectionSummary();
      i = 0;
    }
    while (true)
    {
      if (i >= localList.size())
      {
        ChapterSectionListActivity.g(ChapterSectionListActivity.a.a(this.a)).put(Integer.valueOf(this.b), Boolean.valueOf(true));
        return;
      }
      SectionSummary localSectionSummary = (SectionSummary)localList.get(i);
      LinearLayout localLinearLayout = (LinearLayout)View.inflate(ChapterSectionListActivity.a.a(this.a).getApplicationContext(), 2130903262, null);
      localLinearLayout.setOnClickListener(new q(this, localSectionSummary));
      TextView localTextView = (TextView)localLinearLayout.findViewById(2131297490);
      String str = localSectionSummary.getGraspLevel();
      ImageView localImageView1 = (ImageView)localLinearLayout.findViewById(2131297493);
      ImageView localImageView2 = (ImageView)localLinearLayout.findViewById(2131297494);
      ImageView localImageView3 = (ImageView)localLinearLayout.findViewById(2131297495);
      ImageView localImageView4 = (ImageView)localLinearLayout.findViewById(2131297496);
      ImageView localImageView5 = (ImageView)localLinearLayout.findViewById(2131297497);
      try
      {
        double d1 = Math.ceil(Double.parseDouble(str));
        if (d1 == 0.0D)
        {
          localImageView1.setBackgroundResource(2130837506);
          localImageView2.setBackgroundResource(2130837506);
          localImageView3.setBackgroundResource(2130837506);
          localImageView4.setBackgroundResource(2130837506);
          localImageView5.setBackgroundResource(2130837506);
        }
        while (true)
        {
          label330: localTextView.setText(localSectionSummary.getDoneExerciseNum() + "题/" + localSectionSummary.getTotalExerciseNum() + "题");
          ((RelativeLayout)localLinearLayout.findViewById(2131297491));
          ((TextView)localLinearLayout.findViewById(2131297489)).setText(localSectionSummary.getSection().getName());
          ChapterSectionListActivity.b.k(this.c).addView(localLinearLayout);
          i++;
          break;
          if ((d1 > 0.0D) && (d1 < 10.0D))
          {
            localImageView1.setBackgroundResource(2130837577);
            localImageView2.setBackgroundResource(2130837506);
            localImageView3.setBackgroundResource(2130837506);
            localImageView4.setBackgroundResource(2130837506);
            localImageView5.setBackgroundResource(2130837506);
            continue;
          }
          if ((d1 >= 10.0D) && (d1 < 20.0D))
          {
            localImageView1.setBackgroundResource(2130837710);
            localImageView2.setBackgroundResource(2130837506);
            localImageView3.setBackgroundResource(2130837506);
            localImageView4.setBackgroundResource(2130837506);
            localImageView5.setBackgroundResource(2130837506);
            continue;
          }
          if ((d1 >= 20.0D) && (d1 < 30.0D))
          {
            localImageView1.setBackgroundResource(2130837710);
            localImageView2.setBackgroundResource(2130837577);
            localImageView3.setBackgroundResource(2130837506);
            localImageView4.setBackgroundResource(2130837506);
            localImageView5.setBackgroundResource(2130837506);
            continue;
          }
          if ((d1 >= 30.0D) && (d1 < 40.0D))
          {
            localImageView1.setBackgroundResource(2130837710);
            localImageView2.setBackgroundResource(2130837710);
            localImageView3.setBackgroundResource(2130837506);
            localImageView4.setBackgroundResource(2130837506);
            localImageView5.setBackgroundResource(2130837506);
            continue;
          }
          if ((d1 >= 40.0D) && (d1 < 50.0D))
          {
            localImageView1.setBackgroundResource(2130837710);
            localImageView2.setBackgroundResource(2130837710);
            localImageView3.setBackgroundResource(2130837577);
            localImageView4.setBackgroundResource(2130837506);
            localImageView5.setBackgroundResource(2130837506);
            continue;
          }
          if ((d1 >= 50.0D) && (d1 < 60.0D))
          {
            localImageView1.setBackgroundResource(2130837710);
            localImageView2.setBackgroundResource(2130837710);
            localImageView3.setBackgroundResource(2130837710);
            localImageView4.setBackgroundResource(2130837506);
            localImageView5.setBackgroundResource(2130837506);
            continue;
          }
          if ((d1 >= 60.0D) && (d1 < 70.0D))
          {
            localImageView1.setBackgroundResource(2130837710);
            localImageView2.setBackgroundResource(2130837710);
            localImageView3.setBackgroundResource(2130837710);
            localImageView4.setBackgroundResource(2130837577);
            localImageView5.setBackgroundResource(2130837506);
            continue;
          }
          if ((d1 >= 70.0D) && (d1 < 80.0D))
          {
            localImageView1.setBackgroundResource(2130837710);
            localImageView2.setBackgroundResource(2130837710);
            localImageView3.setBackgroundResource(2130837710);
            localImageView4.setBackgroundResource(2130837710);
            localImageView5.setBackgroundResource(2130837506);
            continue;
          }
          if ((d1 >= 80.0D) && (d1 < 90.0D))
          {
            localImageView1.setBackgroundResource(2130837710);
            localImageView2.setBackgroundResource(2130837710);
            localImageView3.setBackgroundResource(2130837710);
            localImageView4.setBackgroundResource(2130837710);
            localImageView5.setBackgroundResource(2130837577);
            continue;
          }
          if (d1 < 90.0D)
            continue;
          localImageView1.setBackgroundResource(2130837710);
          localImageView2.setBackgroundResource(2130837710);
          localImageView3.setBackgroundResource(2130837710);
          localImageView4.setBackgroundResource(2130837710);
          localImageView5.setBackgroundResource(2130837710);
        }
        ChapterSectionListActivity.b.b(this.c).setVisibility(0);
        if ((ChapterSectionListActivity.b.k(this.c) != null) && (ChapterSectionListActivity.b.k(this.c).getChildCount() > 0))
          ChapterSectionListActivity.b.k(this.c).removeAllViews();
        ChapterSectionListActivity.b.a(this.c).setVisibility(8);
        ChapterSectionListActivity.b.k(this.c).setVisibility(8);
        ChapterSectionListActivity.g(ChapterSectionListActivity.a.a(this.a)).put(Integer.valueOf(this.b), Boolean.valueOf(false));
        return;
      }
      catch (Exception localException)
      {
        break label330;
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.p
 * JD-Core Version:    0.6.0
 */