package com.withustudy.koudaizikao.b;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.ExerciseSummary;
import com.withustudy.koudaizikao.entity.Kpoint;
import com.withustudy.koudaizikao.g.b;
import java.util.List;

public class k extends BaseAdapter
{
  private static final int e = 0;
  private static final int f = 1;
  private Context a;
  private List b;
  private boolean c;
  private String d;

  public k(Context paramContext, List paramList, boolean paramBoolean, String paramString)
  {
    this.a = paramContext;
    this.b = paramList;
    this.c = paramBoolean;
    this.d = paramString;
  }

  public void a(String paramString)
  {
    this.d = paramString;
  }

  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }

  public int getCount()
  {
    return this.b.size();
  }

  public Object getItem(int paramInt)
  {
    return this.b.get(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public int getItemViewType(int paramInt)
  {
    if (this.d.equals("pro"))
      return 0;
    return 1;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    Object localObject1;
    a locala;
    if (paramView == null)
      switch (i)
      {
      default:
        localObject1 = null;
        locala = null;
      case 0:
      case 1:
      }
    while (true)
      switch (i)
      {
      default:
        return paramView;
        paramView = LayoutInflater.from(this.a).inflate(2130903196, null);
        locala = new a();
        locala.a = ((TextView)paramView.findViewById(2131297275));
        locala.b = ((TextView)paramView.findViewById(2131297276));
        locala.c = ((TextView)paramView.findViewById(2131297277));
        locala.d = ((TextView)paramView.findViewById(2131297278));
        paramView.setTag(locala);
        localObject1 = null;
        continue;
        paramView = LayoutInflater.from(this.a).inflate(2130903197, null);
        b localb = new b();
        localb.a = ((TextView)paramView.findViewById(2131297279));
        localb.b = ((ImageView)paramView.findViewById(2131297280));
        localb.c = ((TextView)paramView.findViewById(2131297281));
        localb.d = ((TextView)paramView.findViewById(2131297282));
        localb.e = ((TextView)paramView.findViewById(2131297283));
        paramView.setTag(localb);
        localObject1 = localb;
        locala = null;
        continue;
        switch (i)
        {
        default:
          localObject1 = null;
          locala = null;
          break;
        case 0:
          locala = (a)paramView.getTag();
          localObject1 = null;
          break;
        case 1:
          localObject1 = (b)paramView.getTag();
          locala = null;
        }
      case 0:
      case 1:
      }
    ExerciseSummary localExerciseSummary = (ExerciseSummary)this.b.get(paramInt);
    String str1 = localExerciseSummary.getKpoint().getName();
    locala.a.setText(str1);
    Object localObject2 = "";
    try
    {
      String str3 = b.a(Long.valueOf(localExerciseSummary.getTime()).longValue());
      localObject2 = str3;
      label394: locala.b.setText((CharSequence)localObject2);
      String str2 = localExerciseSummary.getExerciseDesc();
      locala.c.setText(str2);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams((int)(0.75D * f.a(this.a).y()), -2);
      locala.c.setLayoutParams(localLayoutParams);
      locala.d.setText(this.a.getResources().getString(2131165429));
      return paramView;
      if (this.d.equals("information"))
      {
        ((b)localObject1).a.setText("小编");
        ((b)localObject1).b.setBackgroundResource(2130837869);
        ((b)localObject1).c.setText("自考报考海淀区考生注意事项");
        ((b)localObject1).d.setText("今年的考试情况是这个样子的今年的考试情况是这个样子的今年的考试情况是这个样子的今年的考试情况是这个样子的");
        ((b)localObject1).e.setText("2015年8月1日");
        return paramView;
      }
      ((b)localObject1).a.setText("刘胡兰");
      ((b)localObject1).b.setBackgroundResource(2130837869);
      ((b)localObject1).c.setText("在这里开个帖子，记录自己未来几年自考生活");
      ((b)localObject1).d.setText("楼主今年高中毕业，高考只考了400多，只过我们省的大专线，哦呵呵呵呵呵呵");
      ((b)localObject1).e.setText("2015年8月1日");
      return paramView;
    }
    catch (Exception localException)
    {
      break label394;
    }
  }

  public int getViewTypeCount()
  {
    return 2;
  }

  class a
  {
    TextView a;
    TextView b;
    TextView c;
    TextView d;

    a()
    {
    }
  }

  class b
  {
    TextView a;
    ImageView b;
    TextView c;
    TextView d;
    TextView e;

    b()
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.b.k
 * JD-Core Version:    0.6.0
 */