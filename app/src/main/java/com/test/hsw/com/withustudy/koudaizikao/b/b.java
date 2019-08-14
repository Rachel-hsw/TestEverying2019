package com.withustudy.koudaizikao.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.android.http.e;
import com.withustudy.koudaizikao.d.f;
import java.util.List;

public class b extends BaseAdapter
{
  private Context a;
  private List<String> b;

  public b(Context paramContext, List<String> paramList)
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
    ImageView localImageView1;
    if (paramView == null)
    {
      LinearLayout localLinearLayout = new LinearLayout(this.a);
      localImageView1 = new ImageView(this.a);
      localImageView1.setLayoutParams(new ViewGroup.LayoutParams(-2, (f.a(this.a).y() - (int)(30.0F * f.a(this.a).z() / 160.0F)) / 3));
      localImageView1.setScaleType(ImageView.ScaleType.CENTER_CROP);
      ((LinearLayout)localLinearLayout).addView(localImageView1);
      localLinearLayout.setTag(localImageView1);
      paramView = localLinearLayout;
    }
    for (ImageView localImageView2 = localImageView1; ; localImageView2 = (ImageView)paramView.getTag())
    {
      localImageView2.setBackgroundResource(2130837869);
      e.a(this.a).a((String)this.b.get(paramInt), localImageView2);
      return paramView;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.b.b
 * JD-Core Version:    0.6.0
 */