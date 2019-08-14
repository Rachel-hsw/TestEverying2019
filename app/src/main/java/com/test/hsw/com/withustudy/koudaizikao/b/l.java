package com.withustudy.koudaizikao.b;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.android.http.e;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.LocalImage;
import java.util.List;

public class l extends BaseAdapter
{
  private List<LocalImage> a;
  private Context b;
  private Handler c;
  private int d;
  private AbsListView.LayoutParams e;

  public l(List<LocalImage> paramList, Context paramContext, Handler paramHandler, int paramInt)
  {
    this.a = paramList;
    this.b = paramContext;
    this.c = paramHandler;
    this.d = paramInt;
    int i = f.a(paramContext).y() - (int)(18.0F * f.a(paramContext).z() / 160.0F);
    this.e = new AbsListView.LayoutParams(i / 3, i / 3);
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

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    a locala;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.b).inflate(2130903186, null);
      locala = new a();
      locala.a = ((RelativeLayout)paramView.findViewById(2131297178));
      locala.a.setLayoutParams(this.e);
      locala.b = ((ImageView)paramView.findViewById(2131297179));
      locala.c = ((ImageView)paramView.findViewById(2131297180));
      locala.d = ((ImageView)paramView.findViewById(2131297181));
      paramView.setTag(locala);
      if (((LocalImage)this.a.get(paramInt)).isChoose())
        break label259;
      locala.d.setImageResource(2130837868);
      locala.c.setVisibility(8);
    }
    while (true)
    {
      locala.b.setTag(Integer.valueOf(paramInt));
      locala.b.setImageResource(2130837870);
      e.a(this.b).b("file://" + ((LocalImage)this.a.get(paramInt)).getPath(), locala.b, paramInt);
      ImageView localImageView1 = locala.c;
      ImageView localImageView2 = locala.d;
      locala.b.setOnClickListener(new m(this, paramInt, localImageView2, localImageView1));
      return paramView;
      locala = (a)paramView.getTag();
      break;
      label259: locala.d.setImageResource(2130837867);
      locala.c.setVisibility(0);
    }
  }

  class a
  {
    public RelativeLayout a;
    public ImageView b;
    public ImageView c;
    public ImageView d;

    a()
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.b.l
 * JD-Core Version:    0.6.0
 */