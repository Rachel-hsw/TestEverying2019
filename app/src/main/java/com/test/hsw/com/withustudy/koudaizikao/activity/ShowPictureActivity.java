package com.withustudy.koudaizikao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.android.http.e;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import java.util.ArrayList;
import java.util.List;
import uk.co.senab.photoview.PhotoView;

public class ShowPictureActivity extends AbsBaseActivity
{
  public static final String a = "currentitem_key";
  public static final String b = "image_name";
  public static final String c = "type";
  public static final String d = "online";
  public static final String e = "offline";
  private LinearLayout f;
  private List<View> g = null;
  private ViewPager h;
  private b i;
  private List<String> j = null;
  private int k = 0;
  private String l;
  private a m;

  private void a(int paramInt)
  {
    PhotoView localPhotoView = new PhotoView(this);
    localPhotoView.setBackgroundColor(-16777216);
    localPhotoView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    localPhotoView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    if (this.l.equals("offline"))
      e.a(this.mContext).b("file://" + (String)this.j.get(paramInt), localPhotoView);
    while (true)
    {
      localPhotoView.setOnClickListener(this.m);
      this.g.add(localPhotoView);
      return;
      this.mFileDownLoad.a((String)this.j.get(paramInt), localPhotoView);
    }
  }

  protected void bindData()
  {
    for (int n = 0; ; n++)
    {
      if (n >= this.j.size())
      {
        this.i = new b(this.g);
        this.h.setAdapter(this.i);
        this.h.setCurrentItem(this.k);
        return;
      }
      a(n);
    }
  }

  protected void initData()
  {
    this.m = new a();
    this.l = getIntent().getExtras().getString("type");
    this.k = getIntent().getExtras().getInt("currentitem_key");
    this.j = ((List)getIntent().getExtras().getSerializable("image_name"));
    if (this.g == null)
    {
      this.g = new ArrayList();
      return;
    }
    this.g.clear();
  }

  protected void initListener()
  {
    this.f.setOnClickListener(this.m);
  }

  protected void initView()
  {
    this.f = ((LinearLayout)findViewById(2131296690));
    this.h = ((ViewPager)findViewById(2131296689));
  }

  protected void setContentView()
  {
    setContentView(2130903107);
  }

  class a
    implements View.OnClickListener
  {
    a()
    {
    }

    public void onClick(View paramView)
    {
      ShowPictureActivity.this.finish();
    }
  }

  class b extends PagerAdapter
  {
    private List<View> b;
    private int c;

    public b()
    {
      Object localObject;
      this.b = localObject;
      if (localObject == null);
      for (int i = 0; ; i = localObject.size())
      {
        this.c = i;
        return;
      }
    }

    public void destroyItem(View paramView, int paramInt, Object paramObject)
    {
      ((ViewPager)paramView).removeView((View)this.b.get(paramInt % this.c));
    }

    public void finishUpdate(View paramView)
    {
    }

    public int getCount()
    {
      return this.c;
    }

    public int getItemPosition(Object paramObject)
    {
      return -2;
    }

    public Object instantiateItem(View paramView, int paramInt)
    {
      try
      {
        ((ViewPager)paramView).addView((View)this.b.get(paramInt % this.c), 0);
        label26: return this.b.get(paramInt % this.c);
      }
      catch (Exception localException)
      {
        break label26;
      }
    }

    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.ShowPictureActivity
 * JD-Core Version:    0.6.0
 */