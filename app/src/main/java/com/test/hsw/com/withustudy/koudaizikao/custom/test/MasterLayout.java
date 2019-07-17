package com.withustudy.koudaizikao.custom.test;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import java.io.PrintStream;

public class MasterLayout extends FrameLayout
  implements View.OnClickListener
{
  private ScaleAnimation A;
  private AlphaAnimation B;
  private AlphaAnimation C;
  public a a;
  public int b = 0;
  public RectF c;
  int d = 0;
  boolean e = false;
  private ImageView f;
  private ImageView g;
  private ImageView h;
  private ImageView i;
  private Path j;
  private Path k;
  private Path l;
  private Path m;
  private Path n;
  private Bitmap o;
  private Bitmap p;
  private Bitmap q;
  private Paint r;
  private Paint s;
  private Paint t;
  private Paint u;
  private AnimationSet v;
  private AnimationSet w;
  private RotateAnimation x;
  private ScaleAnimation y;
  private ScaleAnimation z;

  public MasterLayout(Context paramContext)
  {
    super(paramContext);
    setOnClickListener(this);
    setBackgroundColor(-16711681);
    e();
    f();
    g();
    h();
    i();
    a();
  }

  public MasterLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOnClickListener(this);
    e();
    f();
    g();
    h();
    i();
    a();
  }

  private void e()
  {
    this.a = new a(getContext(), this);
    this.f = new ImageView(getContext());
    this.h = new ImageView(getContext());
    this.i = new ImageView(getContext());
    this.g = new ImageView(getContext());
    this.a.setClickable(false);
    this.f.setClickable(false);
    this.h.setClickable(false);
    this.i.setClickable(false);
    this.a.setClickable(false);
    setClickable(true);
    this.g.setClickable(false);
  }

  private void f()
  {
    this.r = new Paint(1);
    this.r.setAntiAlias(true);
    this.r.setColor(Color.rgb(0, 161, 234));
    this.r.setStrokeWidth(3.0F);
    this.r.setStyle(Paint.Style.STROKE);
    this.t = new Paint(1);
    this.t.setColor(Color.rgb(0, 161, 234));
    this.t.setStyle(Paint.Style.FILL_AND_STROKE);
    this.t.setAntiAlias(true);
    this.u = new Paint(1);
    this.u.setColor(-1);
    this.u.setStrokeWidth(12.0F);
    this.u.setStyle(Paint.Style.STROKE);
    this.u.setAntiAlias(true);
    this.s = new Paint(1);
    this.s.setColor(Color.rgb(0, 161, 234));
    this.s.setStyle(Paint.Style.FILL_AND_STROKE);
    this.s.setAntiAlias(true);
  }

  private void g()
  {
    this.x = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
    this.x.setDuration(1000L);
    this.v = new AnimationSet(true);
    this.w = new AnimationSet(true);
    this.w.setInterpolator(new AccelerateDecelerateInterpolator());
    this.v.setInterpolator(new AccelerateDecelerateInterpolator());
    this.z = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
    this.A = new ScaleAnimation(1.0F, 3.0F, 1.0F, 3.0F, 1, 0.5F, 1, 0.5F);
    this.y = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
    this.y.setDuration(200L);
    this.B = new AlphaAnimation(0.0F, 1.0F);
    this.C = new AlphaAnimation(1.0F, 0.0F);
    this.z.setDuration(150L);
    this.A.setDuration(150L);
    this.B.setDuration(150L);
    this.C.setDuration(150L);
    this.v.addAnimation(this.z);
    this.v.addAnimation(this.B);
    this.w.addAnimation(this.C);
    this.w.addAnimation(this.A);
    this.x.setAnimationListener(new b(this));
    this.w.setAnimationListener(new c(this));
    this.y.setAnimationListener(new d(this));
  }

  private void h()
  {
    DisplayMetrics localDisplayMetrics = getContext().getResources().getDisplayMetrics();
    this.b = (int)Math.sqrt(0.0217D * (localDisplayMetrics.widthPixels * localDisplayMetrics.heightPixels));
  }

  private void i()
  {
    this.l = new Path();
    this.l.moveTo(40 * this.b / 100, 36 * this.b / 100);
    this.l.lineTo(40 * this.b / 100, 63 * this.b / 100);
    this.l.lineTo(69 * this.b / 100, 50 * this.b / 100);
    this.l.close();
    this.j = new Path();
    this.j.moveTo(38 * this.b / 100, 38 * this.b / 100);
    this.j.lineTo(62 * this.b / 100, 38 * this.b / 100);
    this.j.lineTo(62 * this.b / 100, 62 * this.b / 100);
    this.j.lineTo(38 * this.b / 100, 62 * this.b / 100);
    this.j.close();
    this.m = new Path();
    this.m.moveTo(375 * this.b / 1000, this.b / 2 + 625 * this.b / 10000 - 3 * this.b / 100);
    this.m.lineTo(this.b / 2, 625 * this.b / 1000 + 625 * this.b / 10000 - 3 * this.b / 100);
    this.m.lineTo(625 * this.b / 1000, this.b / 2 + 625 * this.b / 10000 - 3 * this.b / 100);
    this.m.close();
    this.n = new Path();
    this.n.moveTo(4375 * this.b / 10000, this.b / 2 + 625 * this.b / 10000 - 3 * this.b / 100);
    this.n.lineTo(5625 * this.b / 10000, this.b / 2 + 625 * this.b / 10000 - 3 * this.b / 100);
    this.n.lineTo(5625 * this.b / 10000, 375 * this.b / 1000 + 625 * this.b / 10000 - 3 * this.b / 100);
    this.n.lineTo(4375 * this.b / 10000, 375 * this.b / 1000 + 625 * this.b / 10000 - 3 * this.b / 100);
    this.n.close();
    this.k = new Path();
    this.k.moveTo(30 * this.b / 100, 50 * this.b / 100);
    this.k.lineTo(45 * this.b / 100, 625 * this.b / 1000);
    this.k.lineTo(65 * this.b / 100, 350 * this.b / 1000);
  }

  public void a()
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(10, 10, 10, 10);
    this.g.setVisibility(8);
    Bitmap.Config localConfig = Bitmap.Config.ARGB_8888;
    Bitmap localBitmap1 = Bitmap.createBitmap(this.b, this.b, localConfig);
    Bitmap localBitmap2 = Bitmap.createBitmap(this.b, this.b, localConfig);
    Bitmap localBitmap3 = Bitmap.createBitmap(this.b, this.b, localConfig);
    this.q = Bitmap.createBitmap(this.b, this.b, localConfig);
    this.p = Bitmap.createBitmap(this.b, this.b, localConfig);
    this.o = Bitmap.createBitmap(this.b, this.b, localConfig);
    Canvas localCanvas1 = new Canvas(this.q);
    Canvas localCanvas2 = new Canvas(this.p);
    Canvas localCanvas3 = new Canvas(this.o);
    Canvas localCanvas4 = new Canvas(localBitmap3);
    Canvas localCanvas5 = new Canvas(localBitmap1);
    Canvas localCanvas6 = new Canvas(localBitmap2);
    float f1 = (float)(0.05D * this.b);
    float f2 = (float)(0.95D * this.b);
    System.out.println("full circle " + localCanvas5.getWidth() + localCanvas5.getHeight());
    float f3 = (float)(0.05D * this.b);
    float f4 = (float)(0.95D * this.b);
    RectF localRectF = new RectF(f1, f3, f2, f4);
    this.c = localRectF;
    localCanvas1.drawPath(this.l, this.s);
    localCanvas2.drawPath(this.j, this.t);
    localCanvas3.drawPath(this.k, this.u);
    localCanvas5.drawArc(this.c, 0.0F, 360.0F, false, this.r);
    localCanvas4.drawArc(this.c, 0.0F, 360.0F, false, this.s);
    localCanvas6.drawArc(this.c, -80.0F, 340.0F, false, this.r);
    this.f.setImageBitmap(this.q);
    this.d = 1;
    this.g.setImageBitmap(localBitmap3);
    this.h.setImageBitmap(localBitmap1);
    this.i.setImageBitmap(localBitmap2);
    this.a.setVisibility(8);
    addView(this.h, localLayoutParams);
    addView(this.i, localLayoutParams);
    addView(this.g, localLayoutParams);
    addView(this.f, localLayoutParams);
    addView(this.a, localLayoutParams);
  }

  public void b()
  {
    if ((!this.e) && (this.d == 1))
    {
      this.e = true;
      this.h.setVisibility(8);
      this.i.setVisibility(0);
      this.i.startAnimation(this.x);
    }
  }

  public void c()
  {
    this.f.setVisibility(8);
    this.g.setVisibility(0);
    this.g.startAnimation(this.y);
  }

  public void d()
  {
    this.a.a();
    this.a.setVisibility(8);
    this.f.setImageBitmap(this.q);
    this.d = 1;
  }

  public void onClick(View paramView)
  {
    b();
    System.out.println("Action onclick...");
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.test.MasterLayout
 * JD-Core Version:    0.6.0
 */