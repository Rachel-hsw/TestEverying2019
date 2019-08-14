package com.withustudy.koudaizikao.b;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.withustudy.koudaizikao.custom.QuestionDiscussView;
import java.util.List;

public class aa extends BaseAdapter
{
  private Context a;
  private List<String> b;
  private final int c = 0;
  private final int d = 1;

  public aa(Context paramContext, List<String> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
  }

  public int getCount()
  {
    return 1 + this.b.size();
  }

  public Object getItem(int paramInt)
  {
    return null;
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public int getItemViewType(int paramInt)
  {
    if (paramInt != this.b.size())
      return 0;
    return 1;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1 = null;
    int i = getItemViewType(paramInt);
    Object localObject2;
    if (paramView == null)
      switch (i)
      {
      default:
        localObject2 = null;
      case 0:
      case 1:
      }
    while (true)
      switch (i)
      {
      default:
        return paramView;
        a locala = new a();
        QuestionDiscussView localQuestionDiscussView = new QuestionDiscussView(this.a);
        locala.a = ((QuestionDiscussView)localQuestionDiscussView);
        localQuestionDiscussView.setTag(locala);
        paramView = localQuestionDiscussView;
        localObject1 = locala;
        localObject2 = null;
        continue;
        b localb = new b();
        paramView = LayoutInflater.from(this.a).inflate(2130903207, null);
        localb.a = ((TextView)paramView.findViewById(2131297316));
        paramView.setTag(localb);
        localObject2 = localb;
        localObject1 = null;
        continue;
        switch (i)
        {
        default:
          localObject2 = null;
          localObject1 = null;
          break;
        case 0:
          localObject1 = (a)paramView.getTag();
          localObject2 = null;
          break;
        case 1:
          localObject2 = (b)paramView.getTag();
          localObject1 = null;
        }
      case 0:
      case 1:
      }
    ((a)localObject1).a.setImageAvatar(2130837869);
    ((a)localObject1).a.setTextUsername("驻马店学员");
    ((a)localObject1).a.setFloorVisibility(8);
    ((a)localObject1).a.setDiscussButtonVisibility(8);
    ((a)localObject1).a.setTextContent("楼上有病！尼玛，这题很简单吗？我怎么没觉得呢，劳资连题目都美看懂！");
    ((a)localObject1).a.setTextTime("2015年8月1日 11:20");
    return paramView;
    ((b)localObject2).a.setText(this.a.getResources().getString(2131165451));
    return (View)(View)paramView;
  }

  public int getViewTypeCount()
  {
    return 2;
  }

  class a
  {
    public QuestionDiscussView a;

    a()
    {
    }
  }

  class b
  {
    public TextView a;

    b()
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.b.aa
 * JD-Core Version:    0.6.0
 */