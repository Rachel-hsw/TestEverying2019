package com.withustudy.koudaizikao.b;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.http.e;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.Forum;
import java.util.List;

public class a extends BaseAdapter
{
  private Context a;
  private List<Forum> b;

  public a(Context paramContext, List<Forum> paramList)
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
      paramView = LayoutInflater.from(this.a).inflate(2130903187, null);
      locala = new a();
      locala.a = ((ImageView)paramView.findViewById(2131297182));
      locala.b = ((ImageView)paramView.findViewById(2131297183));
      locala.c = ((TextView)paramView.findViewById(2131297184));
      locala.d = ((TextView)paramView.findViewById(2131297186));
      locala.e = ((TextView)paramView.findViewById(2131297185));
      locala.f = ((TextView)paramView.findViewById(2131297187));
      paramView.setTag(locala);
      if (paramInt != 0)
        break label335;
      locala.a.setVisibility(8);
      label132: if ((((Forum)this.b.get(paramInt)).getForum_img() == null) || (((Forum)this.b.get(paramInt)).getForum_img().equals("")))
        break label347;
      e.a(this.a).a(((Forum)this.b.get(paramInt)).getForum_img(), locala.b);
    }
    while (true)
    {
      locala.c.setText(((Forum)this.b.get(paramInt)).getForum_name());
      locala.d.setText(((Forum)this.b.get(paramInt)).getForum_desc());
      if (f.a(this.a).i().equals(""))
        break label382;
      locala.e.setVisibility(0);
      if (((Forum)this.b.get(paramInt)).getForum_isfollow() != 1)
        break label360;
      locala.e.setText(this.a.getResources().getString(2131165494));
      return paramView;
      locala = (a)paramView.getTag();
      break;
      label335: locala.a.setVisibility(0);
      break label132;
      label347: locala.b.setImageResource(2130837869);
    }
    label360: locala.e.setText(this.a.getResources().getString(2131165495));
    return paramView;
    label382: locala.e.setVisibility(8);
    return paramView;
  }

  class a
  {
    public ImageView a;
    public ImageView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;

    a()
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.b.a
 * JD-Core Version:    0.6.0
 */