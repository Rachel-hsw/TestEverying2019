package com.withustudy.koudaizikao.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.withustudy.koudaizikao.custom.QuestionDiscussView;
import java.util.ArrayList;
import java.util.List;

public class z extends BaseAdapter
{
  private Context a;
  private List<Integer> b;
  private List<String> c;

  public z(Context paramContext, List<Integer> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
    this.c = new ArrayList();
    this.c.add("");
    this.c.add("");
    this.c.add("");
  }

  public int getCount()
  {
    return this.b.size();
  }

  public Object getItem(int paramInt)
  {
    return null;
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    a locala1;
    if (paramView == null)
    {
      locala1 = new a();
      QuestionDiscussView localQuestionDiscussView = new QuestionDiscussView(this.a);
      locala1.a = ((QuestionDiscussView)localQuestionDiscussView);
      localQuestionDiscussView.setTag(locala1);
      paramView = localQuestionDiscussView;
    }
    for (a locala2 = locala1; ; locala2 = (a)paramView.getTag())
    {
      locala2.a.setImageAvatar(2130837869);
      locala2.a.setTextUsername("焦作学员");
      locala2.a.setTextFloor("1楼");
      locala2.a.setTextContent("这道题弱爆了，地球人都会回答！这道题弱爆了，地球人都会回答！");
      locala2.a.setTextTime("2015年8月1日 10:10");
      if (((Integer)this.b.get(paramInt)).intValue() != 1)
        break;
      locala2.a.setImageDividerVisibility(0);
      locala2.a.setListVisibility(0);
      aa localaa = new aa(this.a, this.c);
      locala2.a.a(localaa, this.c);
      return paramView;
    }
    locala2.a.setImageDividerVisibility(8);
    locala2.a.setListVisibility(8);
    return paramView;
  }

  class a
  {
    public QuestionDiscussView a;

    a()
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.b.z
 * JD-Core Version:    0.6.0
 */