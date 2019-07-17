package krelve.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.a.a.b.a.g;
import com.a.a.b.c.a;
import com.a.a.b.e;
import com.a.a.b.e.a;
import com.withustudy.koudaizikao.g.h;
import java.util.ArrayList;
import java.util.List;

public class Kanner extends FrameLayout
{
  private int a;
  private com.a.a.b.d b;
  private List<ImageView> c;
  private Context d;
  private ViewPager e;
  private boolean f;
  private int g;
  private int h;
  private LinearLayout i;
  private List<ImageView> j;
  private Handler k = new Handler();
  private final Runnable l = new a(this);
  private c m;
  private int n;
  private int o;

  public Kanner(Context paramContext)
  {
    this(paramContext, null);
  }

  public Kanner(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public Kanner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.d = paramContext;
    a(paramContext);
    a();
  }

  private void a()
  {
    this.c = new ArrayList();
    this.j = new ArrayList();
    this.h = 3000;
  }

  private void a(Bitmap paramBitmap, ImageView paramImageView)
  {
    if ((this.o == 0) || (this.n == 0))
      return;
    int i1 = this.o;
    int i2 = this.n;
    h.a("展示的空间宽franco-width", "width = " + i1);
    h.a("展示的空间高franco-height", "height = " + i2);
    int i3 = paramBitmap.getWidth();
    int i4 = paramBitmap.getHeight();
    h.a("加载图片franco-widthDrawable", "widthDrawable = " + i3);
    h.a("加载图片franco-heightDrawable", "heightDrawable = " + i4);
    h.a("加载图片franco-heightDrawable比例", "widthDrawable/heightDrawable = " + i3 / i4);
    if ((float)(1.0D * paramBitmap.getHeight() / paramBitmap.getWidth()) >= (float)(1.0D * i2 / i1))
    {
      float f3 = i1 / i3;
      h.a("宽的比franco", "scaleWidth = " + f3);
      Matrix localMatrix2 = new Matrix();
      localMatrix2.postScale(f3, f3);
      float f4 = (float)(1.0D * (i2 * i3) / i1);
      Bitmap localBitmap2 = Bitmap.createBitmap(paramBitmap, 0, (int)(1.0D * i4 - f4) / 2, i3, (int)f4, localMatrix2, true);
      paramImageView.setBackgroundDrawable(new BitmapDrawable(getResources(), localBitmap2));
      int i7 = localBitmap2.getWidth();
      int i8 = localBitmap2.getHeight();
      h.a("截取后的宽" + i7);
      h.a("截取后的高" + i8);
      h.a("截取后的宽/长" + i7 / i8);
      return;
    }
    float f1 = i2 / i4;
    h.a("宽的比franco", "scaleHeight = " + f1);
    Matrix localMatrix1 = new Matrix();
    localMatrix1.postScale(f1, f1);
    float f2 = (float)(1.0D * (i1 * i4) / i2);
    Bitmap localBitmap1 = Bitmap.createBitmap(paramBitmap, (int)(1.0D * i3 - f2) / 2, 0, (int)f2, i4, localMatrix1, true);
    paramImageView.setBackgroundDrawable(new BitmapDrawable(getResources(), localBitmap1));
    int i5 = localBitmap1.getWidth();
    int i6 = localBitmap1.getHeight();
    h.a("截取后的宽" + i5);
    h.a("截取后的高" + i6);
    h.a("截取后的宽/长" + i5 / i6);
  }

  private void a(int[] paramArrayOfInt)
  {
    this.a = paramArrayOfInt.length;
    int i2;
    for (int i1 = 0; ; i1++)
    {
      if (i1 >= this.a)
      {
        ((ImageView)this.j.get(0)).setImageResource(2130837765);
        i2 = 0;
        if (i2 <= 1 + this.a)
          break;
        return;
      }
      ImageView localImageView1 = new ImageView(this.d);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.leftMargin = 5;
      localLayoutParams.rightMargin = 5;
      localImageView1.setImageResource(2130837764);
      this.i.addView(localImageView1, localLayoutParams);
      this.j.add(localImageView1);
    }
    ImageView localImageView2 = new ImageView(this.d);
    localImageView2.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    localImageView2.setBackgroundResource(2130837905);
    if (i2 == 0)
      localImageView2.setImageResource(paramArrayOfInt[(-1 + this.a)]);
    while (true)
    {
      this.c.add(localImageView2);
      i2++;
      break;
      if (i2 == 1 + this.a)
      {
        localImageView2.setImageResource(paramArrayOfInt[0]);
        continue;
      }
      localImageView2.setImageResource(paramArrayOfInt[(i2 - 1)]);
    }
  }

  private void a(String[] paramArrayOfString)
  {
    this.a = paramArrayOfString.length;
    com.a.a.b.c localc;
    int i2;
    for (int i1 = 0; ; i1++)
    {
      if (i1 >= this.a)
      {
        ((ImageView)this.j.get(0)).setImageResource(2130837765);
        localc = new c.a().b(true).d(true).a(Bitmap.Config.RGB_565).d();
        i2 = 0;
        if (i2 <= 1 + this.a)
          break;
        return;
      }
      ImageView localImageView1 = new ImageView(this.d);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.leftMargin = 5;
      localLayoutParams.rightMargin = 5;
      localImageView1.setImageResource(2130837764);
      this.i.addView(localImageView1, localLayoutParams);
      this.j.add(localImageView1);
    }
    ImageView localImageView2 = new ImageView(this.d);
    localImageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localImageView2.setBackgroundResource(2130837905);
    if (i2 == 0)
      this.b.a(paramArrayOfString[(-1 + this.a)], localImageView2, localc);
    while (true)
    {
      this.c.add(localImageView2);
      i2++;
      break;
      if (i2 == 1 + this.a)
      {
        this.b.a(paramArrayOfString[0], localImageView2, localc);
        continue;
      }
      this.b.a(paramArrayOfString[(i2 - 1)], localImageView2, localc);
    }
  }

  private void b()
  {
    this.c.clear();
    View localView = LayoutInflater.from(this.d).inflate(2130903225, this, true);
    this.e = ((ViewPager)localView.findViewById(2131297389));
    this.i = ((LinearLayout)localView.findViewById(2131297390));
    this.i.removeAllViews();
  }

  private void c()
  {
    this.e.setAdapter(new a());
    this.e.setFocusable(true);
    this.e.setCurrentItem(1);
    this.g = 1;
    this.e.addOnPageChangeListener(new b());
    d();
  }

  private void d()
  {
    this.f = true;
    this.k.postDelayed(this.l, 2000L);
  }

  public com.a.a.b.c a(int paramInt)
  {
    return new c.a().b(paramInt).c(paramInt).d(paramInt).b(true).d(true).a(Bitmap.Config.RGB_565).a(com.a.a.b.a.d.f).e(true).d();
  }

  public void a(int paramInt1, int paramInt2)
  {
    this.n = paramInt2;
    this.o = paramInt1;
  }

  public void a(Context paramContext)
  {
    e locale = new e.a(paramContext).b(3).a().b(new com.a.a.a.a.b.c()).a(g.b).b().c();
    com.a.a.b.d.a().a(locale);
    this.b = com.a.a.b.d.a();
  }

  public void setImagesRes(int[] paramArrayOfInt)
  {
    b();
    a(paramArrayOfInt);
    c();
  }

  public void setImagesUrl(String[] paramArrayOfString)
  {
    b();
    a(paramArrayOfString);
    c();
  }

  public void setOnBanerItemClickListener(c paramc)
  {
    this.m = paramc;
  }

  class a extends PagerAdapter
  {
    a()
    {
    }

    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      paramViewGroup.removeView((View)Kanner.g(Kanner.this).get(paramInt));
    }

    public int getCount()
    {
      return Kanner.g(Kanner.this).size();
    }

    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      ImageView localImageView = (ImageView)Kanner.g(Kanner.this).get(paramInt);
      localImageView.setOnClickListener(new b(this, paramInt));
      paramViewGroup.addView(localImageView);
      return Kanner.g(Kanner.this).get(paramInt);
    }

    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
  }

  class b
    implements ViewPager.OnPageChangeListener
  {
    b()
    {
    }

    public void onPageScrollStateChanged(int paramInt)
    {
      switch (paramInt)
      {
      default:
        return;
      case 1:
        Kanner.a(Kanner.this, false);
        return;
      case 2:
        Kanner.a(Kanner.this, true);
        return;
      case 0:
      }
      if (Kanner.d(Kanner.this).getCurrentItem() == 0)
        Kanner.d(Kanner.this).setCurrentItem(Kanner.c(Kanner.this), false);
      while (true)
      {
        Kanner.a(Kanner.this, Kanner.d(Kanner.this).getCurrentItem());
        Kanner.a(Kanner.this, true);
        return;
        if (Kanner.d(Kanner.this).getCurrentItem() != 1 + Kanner.c(Kanner.this))
          continue;
        Kanner.d(Kanner.this).setCurrentItem(1, false);
      }
    }

    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
    {
    }

    public void onPageSelected(int paramInt)
    {
      int i = 0;
      if (i >= Kanner.i(Kanner.this).size())
        return;
      if (i == paramInt - 1)
        ((ImageView)Kanner.i(Kanner.this).get(i)).setImageResource(2130837765);
      while (true)
      {
        i++;
        break;
        ((ImageView)Kanner.i(Kanner.this).get(i)).setImageResource(2130837764);
      }
    }
  }

  public static abstract interface c
  {
    public abstract void b(int paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     krelve.view.Kanner
 * JD-Core Version:    0.6.0
 */