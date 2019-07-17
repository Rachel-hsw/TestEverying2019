package com.withustudy.koudaizikao.b;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.withustudy.koudaizikao.entity.News;
import com.withustudy.koudaizikao.g.b;
import java.util.ArrayList;
import java.util.List;

public class o extends BaseAdapter
{
  private List<News> a;
  private Context b;
  private final int c = 0;
  private final int d = 1;
  private final int e = 2;

  public o(List<News> paramList1, List<News> paramList2, List<News> paramList3, List<News> paramList4, Context paramContext)
  {
    this.b = paramContext;
    a(paramList1, paramList2, paramList3, paramList4);
  }

  private void a(List<News> paramList1, List<News> paramList2, List<News> paramList3, List<News> paramList4)
  {
    int i = 0;
    this.a = new ArrayList();
    News localNews1 = new News();
    localNews1.setArticleId(String.valueOf(-2));
    this.a.add(localNews1);
    News localNews2 = new News();
    localNews2.setArticleId(String.valueOf(-1));
    localNews2.setInstruction("EXAMINATION_ROAD");
    this.a.add(localNews2);
    int j = 0;
    int k;
    label167: int m;
    if (j >= paramList1.size())
    {
      News localNews3 = new News();
      localNews3.setArticleId(String.valueOf(-2));
      this.a.add(localNews3);
      News localNews4 = new News();
      localNews4.setArticleId(String.valueOf(-1));
      localNews4.setInstruction("SIGN_UP_INFO");
      this.a.add(localNews4);
      k = 0;
      if (k < paramList2.size())
        break label368;
      News localNews5 = new News();
      localNews5.setArticleId(String.valueOf(-2));
      this.a.add(localNews5);
      News localNews6 = new News();
      localNews6.setArticleId(String.valueOf(-1));
      localNews6.setInstruction("OFFICIAL_NEWS");
      this.a.add(localNews6);
      m = 0;
      label249: if (m < paramList3.size())
        break label395;
      News localNews7 = new News();
      localNews7.setArticleId(String.valueOf(-2));
      this.a.add(localNews7);
      News localNews8 = new News();
      localNews8.setArticleId(String.valueOf(-1));
      localNews8.setInstruction("COMMEN_QUESTION");
      this.a.add(localNews8);
    }
    while (true)
    {
      if (i >= paramList4.size())
      {
        return;
        this.a.add((News)paramList1.get(j));
        j++;
        break;
        label368: this.a.add((News)paramList2.get(k));
        k++;
        break label167;
        label395: this.a.add((News)paramList3.get(m));
        m++;
        break label249;
      }
      this.a.add((News)paramList4.get(i));
      i++;
    }
  }

  public int getCount()
  {
    return this.a.size();
  }

  public Object getItem(int paramInt)
  {
    return this.a.get(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public int getItemViewType(int paramInt)
  {
    if (((News)this.a.get(paramInt)).getArticleId().equals("-2"))
      return 0;
    if (((News)this.a.get(paramInt)).getArticleId().equals("-1"))
      return 1;
    return 2;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = null;
    int i = getItemViewType(paramInt);
    c localc;
    if (paramView == null)
      switch (i)
      {
      default:
        localc = null;
        switch (i)
        {
        default:
        case 1:
        case 2:
        }
      case 0:
      case 1:
      case 2:
      }
    do
    {
      return paramView;
      a locala = new a();
      paramView = LayoutInflater.from(this.b).inflate(2130903201, null);
      locala.a = ((ImageView)paramView.findViewById(2131297296));
      paramView.setTag(locala);
      localObject = null;
      localc = null;
      break;
      b localb = new b();
      paramView = LayoutInflater.from(this.b).inflate(2130903202, null);
      localb.a = ((ImageView)paramView.findViewById(2131297297));
      localb.b = ((TextView)paramView.findViewById(2131297298));
      paramView.setTag(localb);
      localObject = localb;
      localc = null;
      break;
      localc = new c();
      paramView = LayoutInflater.from(this.b).inflate(2130903203, null);
      localc.a = ((ImageView)paramView.findViewById(2131297299));
      localc.b = ((TextView)paramView.findViewById(2131297300));
      localc.c = ((TextView)paramView.findViewById(2131297302));
      localc.d = ((TextView)paramView.findViewById(2131297301));
      paramView.setTag(localc);
      localObject = null;
      break;
      switch (i)
      {
      default:
        localObject = null;
        localc = null;
        break;
      case 0:
        ((a)paramView.getTag());
        localObject = null;
        localc = null;
        break;
      case 1:
        localObject = (b)paramView.getTag();
        localc = null;
        break;
      case 2:
        localc = (c)paramView.getTag();
        localObject = null;
        break;
        if (((News)this.a.get(paramInt)).getInstruction().equals("EXAMINATION_ROAD"))
        {
          ((b)localObject).a.setBackgroundResource(2130837861);
          ((b)localObject).b.setTextColor(Color.parseColor("#fcb616"));
          ((b)localObject).b.setText(2131165412);
          return paramView;
        }
        if (((News)this.a.get(paramInt)).getInstruction().equals("SIGN_UP_INFO"))
        {
          ((b)localObject).a.setBackgroundResource(2130837858);
          ((b)localObject).b.setTextColor(Color.parseColor("#fb8e55"));
          ((b)localObject).b.setText(2131165413);
          return paramView;
        }
        if (!((News)this.a.get(paramInt)).getInstruction().equals("OFFICIAL_NEWS"))
          continue;
        ((b)localObject).a.setBackgroundResource(2130837859);
        ((b)localObject).b.setTextColor(Color.parseColor("#40b0ef"));
        ((b)localObject).b.setText(2131165414);
        return paramView;
      }
    }
    while (!((News)this.a.get(paramInt)).getInstruction().equals("COMMEN_QUESTION"));
    ((b)localObject).a.setBackgroundResource(2130837860);
    ((b)localObject).b.setTextColor(Color.parseColor("#f7586c"));
    ((b)localObject).b.setText(2131165415);
    return paramView;
    News localNews = (News)this.a.get(paramInt);
    if (((News)this.a.get(paramInt - 1)).getArticleId().equals("-1"))
    {
      localc.a.setVisibility(8);
      localc.b.setText(localNews.getInstruction());
      if ((!localNews.getArticleType().equals("SIGN_UP_INFO")) && (!localNews.getArticleType().equals("COMMEN_QUESTION")))
        break label748;
      localc.c.setVisibility(8);
    }
    while (true)
    {
      localc.d.setText(b.b(this.b, Long.valueOf(localNews.getCreatedTime()).longValue()));
      return paramView;
      localc.a.setVisibility(0);
      break;
      label748: localc.c.setVisibility(0);
      localc.c.setText(localNews.getBriefText());
    }
  }

  public int getViewTypeCount()
  {
    return 3;
  }

  class a
  {
    public ImageView a;

    a()
    {
    }
  }

  class b
  {
    public ImageView a;
    public TextView b;

    b()
    {
    }
  }

  class c
  {
    public ImageView a;
    public TextView b;
    public TextView c;
    public TextView d;

    c()
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.b.o
 * JD-Core Version:    0.6.0
 */