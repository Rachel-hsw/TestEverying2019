package com.withustudy.koudaizikao.b;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import com.android.http.e;
import com.withustudy.koudaizikao.entity.News;
import java.util.ArrayList;
import java.util.List;

public class q extends PagerAdapter
{
  private Context a;
  private List<ImageView> b;
  private List<News> c;

  public q(Context paramContext, List<ImageView> paramList, List<News> paramList1)
  {
    this.a = paramContext;
    this.b = paramList;
    this.c = paramList1;
  }

  public int a()
  {
    return this.b.size();
  }

  public void a(ArrayList<ImageView> paramArrayList)
  {
    this.b = paramArrayList;
  }

  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
  }

  public int getCount()
  {
    return 2147483647;
  }

  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    int i = paramInt % this.b.size();
    if (i < 0);
    for (int j = i + this.b.size(); ; j = i)
    {
      ImageView localImageView = (ImageView)this.b.get(j);
      ViewParent localViewParent = localImageView.getParent();
      if (localViewParent != null)
        ((ViewGroup)localViewParent).removeView(localImageView);
      e.a(this.a).a(((News)this.c.get(j)).getAttachUrl(), localImageView);
      paramViewGroup.addView(localImageView);
      return localImageView;
    }
  }

  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.b.q
 * JD-Core Version:    0.6.0
 */