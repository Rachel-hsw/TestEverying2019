package com.withustudy.koudaizikao.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.http.e;
import com.withustudy.koudaizikao.entity.News;
import java.util.List;

public class p extends BaseAdapter
{
  private Context a;
  private List<News> b;

  public p(Context paramContext, List<News> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
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

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    a locala;
    if (paramView == null)
    {
      locala = new a();
      paramView = LayoutInflater.from(this.a).inflate(2130903204, null);
      locala.a = ((ImageView)paramView.findViewById(2131297303));
      locala.b = ((TextView)paramView.findViewById(2131297304));
      locala.c = ((TextView)paramView.findViewById(2131297305));
      locala.d = ((TextView)paramView.findViewById(2131297306));
      paramView.setTag(locala);
      if ((((News)this.b.get(paramInt)).getPanelUrl() == null) || (((News)this.b.get(paramInt)).getPanelUrl().equals("")))
        break label301;
      e.a(this.a).a(((News)this.b.get(paramInt)).getPanelUrl(), locala.a);
      label164: locala.b.setText(((News)this.b.get(paramInt)).getInstruction());
      if ((!((News)this.b.get(paramInt)).getArticleType().equals("SIGN_UP_INFO")) && (!((News)this.b.get(paramInt)).getArticleType().equals("COMMEN_QUESTION")))
        break label314;
      locala.c.setVisibility(4);
    }
    while (true)
    {
      locala.d.setText(((News)this.b.get(paramInt)).getCommentNum() + "回复");
      return paramView;
      locala = (a)paramView.getTag();
      break;
      label301: locala.a.setImageResource(2130837870);
      break label164;
      label314: locala.c.setVisibility(0);
      locala.c.setText(((News)this.b.get(paramInt)).getBriefText());
    }
  }

  class a
  {
    public ImageView a;
    public TextView b;
    public TextView c;
    public TextView d;

    a()
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.b.p
 * JD-Core Version:    0.6.0
 */