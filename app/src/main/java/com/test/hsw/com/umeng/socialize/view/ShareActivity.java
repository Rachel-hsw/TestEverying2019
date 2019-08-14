package com.umeng.socialize.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.location.Location;
import android.os.AsyncTask.Status;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.umeng.socialize.bean.UMLocation;
import com.umeng.socialize.bean.UMShareMsg;
import com.umeng.socialize.bean.ax;
import com.umeng.socialize.bean.ay;
import com.umeng.socialize.common.b.a;
import com.umeng.socialize.controller.UMSocialService;
import com.umeng.socialize.controller.listener.SocializeListeners.SnsPostListener;
import com.umeng.socialize.location.d;
import com.umeng.socialize.media.BaseShareContent;
import com.umeng.socialize.media.SimpleShareContent;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.media.UMediaObject.a;
import com.umeng.socialize.utils.i;
import com.umeng.socialize.view.wigets.KeyboardListenRelativeLayout;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Set;

public class ShareActivity extends Activity
{
  public static final String b = "umeng_follow";
  private static final String c = ShareActivity.class.getName();
  private static final int d = 140;
  private Location A;
  private int B;
  private boolean C = false;
  private Dialog D;
  private UMediaObject E;
  private ax F = ax.b();
  private Set<String> G = null;
  private com.umeng.socialize.location.b H = null;
  protected ImageView a;
  private Button e;
  private Button f;
  private EditText g;
  private ImageButton h;
  private ImageButton i;
  private View j;
  private View k;
  private View l;
  private TextView m;
  private RelativeLayout n;
  private CheckBox o;
  private KeyboardListenRelativeLayout p;
  private SocializeListeners.SnsPostListener q;
  private ay r;
  private ProgressDialog s;
  private ProgressBar t;
  private Context u;
  private boolean v;
  private UMSocialService w;
  private String x;
  private com.umeng.socialize.bean.p y;
  private com.umeng.socialize.location.a z;

  private void a(int paramInt, Bitmap paramBitmap)
  {
    try
    {
      this.a.setImageBitmap(paramBitmap);
      this.a.setVisibility(0);
      this.k.setVisibility(0);
      return;
    }
    catch (Exception localException)
    {
      while (true)
        this.a.setImageResource(paramInt);
    }
  }

  private void a(Object paramObject, String paramString)
  {
    if (this.l == null)
      return;
    Class[] arrayOfClass;
    Object[] arrayOfObject;
    if ("init".equals(paramString))
    {
      arrayOfClass = new Class[] { Activity.class, com.umeng.socialize.bean.p.class, String.class };
      arrayOfObject = new Object[3];
      arrayOfObject[0] = this;
      arrayOfObject[1] = this.y;
      arrayOfObject[2] = this.x;
    }
    while (true)
    {
      try
      {
        this.l.getClass().getMethod(paramString, arrayOfClass).invoke(this.l, arrayOfObject);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        u();
        return;
      }
      if (!"onShow".equals(paramString))
        break;
      arrayOfClass = new Class[0];
      arrayOfObject = new Object[0];
    }
  }

  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.i.setVisibility(8);
      this.j.setVisibility(0);
      return;
    }
    if (this.A == null)
    {
      this.i.setImageResource(com.umeng.socialize.common.b.a(this, b.a.c, "umeng_socialize_location_off"));
      this.i.setVisibility(0);
      this.j.setVisibility(8);
      return;
    }
    this.i.setImageResource(com.umeng.socialize.common.b.a(this, b.a.c, "umeng_socialize_location_on"));
    this.i.setVisibility(0);
    this.j.setVisibility(8);
  }

  private void c()
  {
    i.c(c, "initLocationProvider.....");
    this.z = new com.umeng.socialize.location.a();
    d locald = new d();
    locald.a(this);
    this.z.a(locald);
    this.z.a(this);
    this.i.setImageResource(com.umeng.socialize.common.b.a(this, b.a.c, "umeng_socialize_location_off"));
  }

  private void d()
  {
    this.g = ((EditText)findViewById(com.umeng.socialize.common.b.a(this, b.a.b, "umeng_socialize_share_edittext")));
    String str1 = this.r.d();
    if (this.y == com.umeng.socialize.bean.p.g)
      str1 = this.F.a(com.umeng.socialize.bean.p.g.c()).E;
    if (!TextUtils.isEmpty(str1))
    {
      this.g.setText(str1);
      this.g.setSelection(str1.length());
    }
    this.i = ((ImageButton)findViewById(com.umeng.socialize.common.b.a(this, b.a.b, "umeng_socialize_location_ic")));
    this.j = findViewById(com.umeng.socialize.common.b.a(this, b.a.b, "umeng_socialize_location_progressbar"));
    this.i.setOnClickListener(new z(this));
    if (this.C)
    {
      q();
      this.l = s();
      if (this.l != null)
      {
        this.l.setVisibility(8);
        this.p.addView(this.l, -1, -1);
      }
    }
    this.h = ((ImageButton)findViewById(com.umeng.socialize.common.b.a(this, b.a.b, "umeng_socialize_share_at")));
    if (!p())
      this.h.setVisibility(8);
    while (true)
    {
      if ((this.C) && (this.l == null))
        this.h.setVisibility(8);
      this.h.setOnClickListener(new l(this));
      this.m = ((TextView)findViewById(com.umeng.socialize.common.b.a(this, b.a.b, "umeng_socialize_share_word_num")));
      this.v = h();
      this.e = ((Button)findViewById(com.umeng.socialize.common.b.a(this, b.a.b, "umeng_socialize_title_bar_leftBt")));
      this.e.setOnClickListener(new m(this));
      this.f = ((Button)findViewById(com.umeng.socialize.common.b.a(this, b.a.b, "umeng_socialize_title_bar_rightBt")));
      TextView localTextView = (TextView)findViewById(com.umeng.socialize.common.b.a(this, b.a.b, "umeng_socialize_title_bar_middleTv"));
      String str2 = "分享到" + com.umeng.socialize.common.p.a(this, this.y);
      if (this.y == com.umeng.socialize.bean.p.g)
        str2 = "分享到QQ";
      localTextView.setText(str2);
      this.a = ((ImageView)findViewById(com.umeng.socialize.common.b.a(this, b.a.b, "umeng_socialize_share_previewImg")));
      this.k = findViewById(com.umeng.socialize.common.b.a(this, b.a.b, "umeng_socialize_share_previewImg_remove"));
      this.k.setOnClickListener(new n(this));
      this.t = ((ProgressBar)findViewById(com.umeng.socialize.common.b.a(this, b.a.b, "umeng_socialize_share_previewImg_progressbar")));
      e();
      this.n = ((RelativeLayout)findViewById(com.umeng.socialize.common.b.a(this.u, b.a.b, "umeng_socialize_follow_layout")));
      if (this.w != null)
        this.G = this.F.a(this.y);
      if (!n())
        this.n.setVisibility(8);
      this.o = ((CheckBox)findViewById(com.umeng.socialize.common.b.a(this.u, b.a.b, "umeng_socialize_follow_check")));
      this.s = new ProgressDialog(this.u);
      this.s.setProgressStyle(0);
      this.s.setMessage("发送中...");
      this.s.setCancelable(false);
      o localo = new o(this);
      this.g.addTextChangedListener(localo);
      this.q = new a(this);
      this.f.setOnClickListener(new p(this));
      return;
      this.D = r();
      if (this.D == null)
        continue;
      this.D.setOwnerActivity(this);
    }
  }

  private void e()
  {
    UMediaObject.a locala;
    if (this.E != null)
    {
      locala = this.E.g();
      if ((locala != UMediaObject.a.c) && (locala != UMediaObject.a.b))
        break label83;
      String str = "umeng_socialize_share_music";
      if (locala == UMediaObject.a.b)
        str = "umeng_socialize_share_video";
      int i1 = com.umeng.socialize.common.b.a(this.u, b.a.c, str);
      this.a.setImageResource(i1);
      this.a.setVisibility(0);
      this.k.setVisibility(0);
    }
    label83: 
    do
      return;
    while (locala != UMediaObject.a.a);
    this.a.setImageDrawable(null);
    int i2 = com.umeng.socialize.common.b.a(this.u, b.a.c, "umeng_socialize_share_pic");
    UMImage localUMImage = (UMImage)this.E;
    this.t.setVisibility(0);
    this.a.setVisibility(4);
    new q(this, localUMImage, i2).c();
  }

  private void f()
  {
    UMShareMsg localUMShareMsg = new UMShareMsg();
    localUMShareMsg.a = this.g.getText().toString();
    localUMShareMsg.a(this.E);
    localUMShareMsg.b = UMLocation.a(this.A);
    this.w.f().a(localUMShareMsg);
    this.w.b(this.u, this.y, this.q);
    o();
  }

  private void g()
  {
    this.s.setMessage("载入中,请稍候...");
    this.s.show();
    com.umeng.socialize.sso.v localv = this.w.c().a(5658);
    if (localv != null)
    {
      localv.E = this.g.getText().toString();
      localv.e_();
      return;
    }
    i.c(c, "请先调用mController.getConfig().supportQQPlatform(getActivity(), \"你的app id\");支持QQ平台");
  }

  private boolean h()
  {
    int i1 = 140 - com.umeng.socialize.utils.m.c(this.g.getText().toString());
    i.c(c, "onTextChanged " + i1 + "   " + com.umeng.socialize.utils.m.c(this.g.getText().toString()));
    this.m.setText("" + i1);
    return i1 < 0;
  }

  private void i()
  {
    if (this.A != null)
    {
      new AlertDialog.Builder(this).setMessage("是否删除位置信息？").setCancelable(false).setPositiveButton("是", new t(this)).setNegativeButton("否", new s(this)).create().show();
      return;
    }
    l();
  }

  private void j()
  {
    String str;
    if (this.a.getDrawable() != null)
    {
      str = "";
      if (this.E != null)
        switch (y.a[this.E.g().ordinal()])
        {
        default:
        case 1:
        case 2:
        case 3:
        }
    }
    while (true)
    {
      new AlertDialog.Builder(this).setMessage("你确定删除" + str + "吗？").setCancelable(false).setPositiveButton("确定", new v(this)).setNegativeButton("取消", new u(this)).create().show();
      return;
      str = "音乐";
      continue;
      str = "图片";
      continue;
      str = "视频";
    }
  }

  private void k()
  {
    com.umeng.socialize.sso.v localv = this.F.a(com.umeng.socialize.bean.p.g.c());
    if (localv != null)
      localv.F = null;
  }

  private void l()
  {
    if (this.z == null)
      c();
    if ((this.H != null) && (this.H.getStatus() != AsyncTask.Status.FINISHED))
      this.H.cancel(true);
    this.H = new w(this, this.z);
    this.H.execute(new Void[0]);
  }

  private void m()
  {
    SharedPreferences.Editor localEditor = getSharedPreferences("umeng_follow", 0).edit();
    localEditor.putBoolean(this.y.toString(), false);
    localEditor.commit();
  }

  private boolean n()
  {
    if ((this.G == null) || (this.G.size() <= 0) || ((this.y != com.umeng.socialize.bean.p.e) && (this.y != com.umeng.socialize.bean.p.k)))
      return false;
    return getSharedPreferences("umeng_follow", 0).getBoolean(this.y.toString(), true);
  }

  private void o()
  {
    if ((this.n.getVisibility() == 0) && (this.o.isChecked()) && (this.G != null) && (this.G.size() > 0))
    {
      String[] arrayOfString = new String[this.G.size()];
      this.G.toArray(arrayOfString);
      this.w.a(this.u, this.y, null, arrayOfString);
      m();
    }
  }

  private boolean p()
  {
    return (this.y != com.umeng.socialize.bean.p.f) && (this.y != com.umeng.socialize.bean.p.g);
  }

  private void q()
  {
    try
    {
      Class localClass = Class.forName("com.umeng.socialize.view.FriendSelView");
      localClass.getDeclaredField("SHOWSILDEBAR").set(localClass, Boolean.FALSE);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      u();
    }
  }

  private Dialog r()
  {
    try
    {
      Constructor localConstructor = Class.forName("com.umeng.socialize.view.ShareAtDialogV2").getConstructor(new Class[] { ShareActivity.class, com.umeng.socialize.bean.p.class, String.class });
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = this;
      arrayOfObject[1] = this.y;
      arrayOfObject[2] = this.x;
      Dialog localDialog = (Dialog)localConstructor.newInstance(arrayOfObject);
      return localDialog;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      u();
    }
    return null;
  }

  private View s()
  {
    try
    {
      View localView = (View)Class.forName("com.umeng.socialize.view.FriendSelView").getConstructor(new Class[] { Context.class }).newInstance(new Object[] { this });
      return localView;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      u();
    }
    return null;
  }

  private boolean t()
  {
    try
    {
      if (this.l == null)
        this.l = s();
      if (this.l == null)
        return false;
      boolean bool = View.class.getDeclaredField("mInitialized").getBoolean(this.l);
      return bool;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      u();
    }
    return false;
  }

  private void u()
  {
    i.e(c, "如果需要使用‘@好友’功能，请添加相应的jar文件；否则忽略此信息");
  }

  protected void a()
  {
    if (this.B == -3)
    {
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
      new Handler().postDelayed(new r(this), 500L);
      return;
    }
    finish();
  }

  public void a(SpannableString paramSpannableString)
  {
    int i1 = this.g.getSelectionStart();
    this.g.getText().insert(i1, paramSpannableString);
  }

  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((com.umeng.socialize.common.r.r) && (paramKeyEvent.getKeyCode() == 4))
    {
      if (this.s.isShowing())
        this.s.dismiss();
      new Handler().postDelayed(new x(this), 400L);
      ay localay = this.w.f();
      SocializeListeners.SnsPostListener[] arrayOfSnsPostListener = (SocializeListeners.SnsPostListener[])this.w.c().a(SocializeListeners.SnsPostListener.class);
      int i1 = arrayOfSnsPostListener.length;
      for (int i2 = 0; i2 < i1; i2++)
        arrayOfSnsPostListener[i2].a(this.y, 40000, localay);
      if (this.w != null)
        this.w.c().a();
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }

  protected void onCreate(Bundle paramBundle)
  {
    this.C = com.umeng.socialize.utils.m.d(this);
    if (!this.C)
      setTheme(com.umeng.socialize.common.b.a(this, b.a.d, "Theme.UMDefault"));
    super.onCreate(paramBundle);
    this.u = this;
    setContentView(com.umeng.socialize.common.b.a(this, b.a.a, "umeng_socialize_post_share"));
    WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
    localLayoutParams.softInputMode = 16;
    if (this.C)
    {
      int[] arrayOfInt = com.umeng.socialize.utils.m.c(this.u);
      localLayoutParams.width = arrayOfInt[0];
      localLayoutParams.height = arrayOfInt[1];
    }
    getWindow().setAttributes(localLayoutParams);
    this.p = ((KeyboardListenRelativeLayout)findViewById(com.umeng.socialize.common.b.a(this, b.a.b, "umeng_socialize_share_root")));
    this.p.setOnKeyboardStateChangedListener(new k(this));
    this.x = getIntent().getStringExtra("dc");
    this.y = com.umeng.socialize.bean.p.a(getIntent().getStringExtra("sns"));
    if (this.y == null)
    {
      Toast.makeText(this, "出错啦！", 0).show();
      a();
    }
    if (TextUtils.isEmpty(this.x))
    {
      i.b(c, "####No EntityPool key..............");
      a();
    }
    this.w = com.umeng.socialize.controller.a.a(this.x);
    this.r = this.w.f();
    this.E = this.r.a();
    if ((this.E instanceof SimpleShareContent))
      if (!(this.E instanceof BaseShareContent))
        break label330;
    label330: for (this.E = ((BaseShareContent)this.E).c(); ; this.E = ((SimpleShareContent)this.E).l())
    {
      this.r.a(this, this.y, 15);
      if (this.y == com.umeng.socialize.bean.p.g)
        this.E = this.F.a(com.umeng.socialize.bean.p.g.c()).F;
      return;
    }
  }

  protected void onDestroy()
  {
    if (this.z != null)
      this.z.a();
    if (this.H != null)
      this.H.cancel(true);
    super.onDestroy();
  }

  protected void onResume()
  {
    d();
    if (this.F.d())
    {
      c();
      l();
    }
    this.g.requestFocus();
    super.onResume();
  }

  protected void onStop()
  {
    if ((this.s != null) && (this.s.isShowing()))
      this.s.dismiss();
    super.onStop();
  }

  static class a
    implements SocializeListeners.SnsPostListener
  {
    WeakReference<ShareActivity> a = null;

    public a(ShareActivity paramShareActivity)
    {
      this.a = new WeakReference(paramShareActivity);
    }

    public void a()
    {
      ShareActivity localShareActivity = (ShareActivity)this.a.get();
      if ((localShareActivity != null) && (localShareActivity.isFinishing()))
      {
        localShareActivity.a();
        com.umeng.socialize.utils.m.a(ShareActivity.v(localShareActivity));
      }
    }

    public void a(com.umeng.socialize.bean.p paramp, int paramInt, ay paramay)
    {
      if (paramInt == 200)
        paramay.l();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.view.ShareActivity
 * JD-Core Version:    0.6.0
 */