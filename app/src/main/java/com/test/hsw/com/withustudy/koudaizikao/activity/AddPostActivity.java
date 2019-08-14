package com.withustudy.koudaizikao.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Message;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.android.http.k;
import com.google.gson.Gson;
import com.withustudy.koudaizikao.a.a;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.base.m;
import com.withustudy.koudaizikao.custom.AddImageView;
import com.withustudy.koudaizikao.entity.LocalImage;
import com.withustudy.koudaizikao.entity.Post;
import com.withustudy.koudaizikao.entity.content.PostAddContent;
import com.withustudy.koudaizikao.g.h;
import com.withustudy.koudaizikao.g.l;
import java.io.File;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AddPostActivity extends AbsBaseActivity
{
  public static final int a = 2;
  public static final int b = 3;
  public static final int c = 4;
  public static final int d = 5;
  public static final int e = 1;
  public static final int f = 6;
  public static final int g = 11;
  public static final int h = 9;
  private List<AddImageView> A;
  private List<File> B;
  private String[] C;
  private int D = 0;
  private String[] E;
  private LinearLayout i;
  private TextView j;
  private Button k;
  private EditText l;
  private EditText m;
  private LinearLayout n;
  private TextView o;
  private Button p;
  private Button q;
  private RelativeLayout r;
  private LinearLayout s;
  private TextView t;
  private b u;
  private a v;
  private InputMethodManager w;
  private int x;
  private boolean y = false;
  private List<Integer> z;

  private void a()
  {
    if ((this.z != null) && (this.z.size() == 2) && (!this.y) && (((Integer)this.z.get(0)).intValue() != 0) && (((Integer)this.z.get(1)).intValue() != 0))
    {
      int i1 = ((Integer)this.z.get(0)).intValue() - ((Integer)this.z.get(1)).intValue();
      if (i1 <= 0)
        i1 = 0 - i1;
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, i1);
      this.r.setLayoutParams(localLayoutParams);
      this.r.setVisibility(0);
      getWindow().setSoftInputMode(48);
      a(i1 / 2);
      this.y = true;
    }
  }

  private void a(int paramInt)
  {
    b();
    int i1 = 0;
    if (i1 >= 9)
      return;
    AddImageView localAddImageView = new AddImageView(this.mContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(paramInt, paramInt);
    if (i1 != 8)
      localLayoutParams.setMargins(0, 0, 69 * (this.mSP.y() / 720), 0);
    localAddImageView.setLayoutParams(localLayoutParams);
    localAddImageView.setIndex(i1);
    localAddImageView.setmHandler(this.v);
    if (i1 == 0)
      localAddImageView.setVisibility(0);
    while (true)
    {
      this.A.add(localAddImageView);
      this.s.addView(localAddImageView);
      i1++;
      break;
      localAddImageView.setVisibility(8);
    }
  }

  private void b()
  {
    if ((this.D < 0) || (this.D > 9))
      return;
    this.t.setText(getResources().getString(2131165512) + this.D + getResources().getString(2131165513) + (9 - this.D) + getResources().getString(2131165514));
  }

  private void c()
  {
    for (int i1 = 0; ; i1++)
    {
      if (i1 >= this.B.size())
        return;
      this.mFileTools.a((File)this.B.get(i1));
    }
  }

  protected void bindData()
  {
    this.l.requestFocus();
    this.w.toggleSoftInput(0, 2);
    this.v.sendMessageDelayed(this.v.obtainMessage(4), 100L);
    this.o.setText("北京市清河");
  }

  public void finish()
  {
    super.finish();
    c();
  }

  public void finish(int paramInt1, int paramInt2)
  {
    super.finish(paramInt1, paramInt2);
    c();
  }

  protected void initData()
  {
    this.u = new b();
    this.v = new a(this);
    this.w = ((InputMethodManager)getSystemService("input_method"));
    this.x = getIntent().getExtras().getInt("id");
    if (this.A == null)
    {
      this.A = new ArrayList();
      this.B = new ArrayList();
      return;
    }
    this.A.clear();
    c();
    this.B.clear();
  }

  protected void initListener()
  {
    this.j.setOnClickListener(this.u);
    this.i.getViewTreeObserver().addOnGlobalLayoutListener(this.u);
    this.q.setOnClickListener(this.u);
    this.p.setOnClickListener(this.u);
    this.k.setOnClickListener(this.u);
  }

  protected void initView()
  {
    this.i = ((LinearLayout)findViewById(2131296377));
    this.j = ((TextView)findViewById(2131296378));
    this.k = ((Button)findViewById(2131296379));
    this.l = ((EditText)findViewById(2131296380));
    this.m = ((EditText)findViewById(2131296381));
    this.n = ((LinearLayout)findViewById(2131296382));
    this.o = ((TextView)findViewById(2131296383));
    this.p = ((Button)findViewById(2131296384));
    this.q = ((Button)findViewById(2131296385));
    this.r = ((RelativeLayout)findViewById(2131296386));
    this.s = ((LinearLayout)findViewById(2131296388));
    this.t = ((TextView)findViewById(2131296389));
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == 11) && (paramIntent != null));
    try
    {
      ArrayList localArrayList = paramIntent.getExtras().getParcelableArrayList("result");
      int i1 = this.D;
      int i4;
      for (int i2 = 0; ; i2 = i4)
      {
        if (i1 < this.A.size())
        {
          int i3 = localArrayList.size();
          if (i2 < i3);
        }
        else
        {
          super.onActivityResult(paramInt1, paramInt2, paramIntent);
          return;
        }
        h.a(((LocalImage)localArrayList.get(i2)).getPath());
        ((AddImageView)this.A.get(i1)).setImage(((LocalImage)localArrayList.get(i2)).getPath());
        ((AddImageView)this.A.get(i1)).setDeleteVisibility(0);
        if (i1 != 8)
          ((AddImageView)this.A.get(i1 + 1)).setVisibility(0);
        this.D = (1 + this.D);
        b();
        File localFile = this.mFileTools.a(System.currentTimeMillis() + ".JPEG");
        h.a(localFile.getAbsolutePath());
        if (this.mFileTools.a(localFile, ((LocalImage)localArrayList.get(i2)).getPath()) != null)
          this.B.add(localFile);
        i4 = i2 + 1;
        i1++;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (true)
      {
        Toast.makeText(this.mContext, "图片过大，小袋内存不够用啦!", 0).show();
        localOutOfMemoryError.printStackTrace();
      }
    }
  }

  protected void onDestroy()
  {
    super.onDestroy();
    try
    {
      this.mProTools.b();
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void onError(String paramString1, String paramString2, int paramInt)
  {
    super.onError(paramString1, paramString2, paramInt);
    this.mProTools.b();
    Toast.makeText(this.mContext, "发送失败，请稍后再试", 0).show();
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    super.onSuccess(paramString1, paramMap, paramString2, paramInt);
    this.mProTools.b();
    if (paramString1 != null)
      try
      {
        PostAddContent localPostAddContent = (PostAddContent)c.a().fromJson(paramString1, PostAddContent.class);
        if ((localPostAddContent != null) && (localPostAddContent.getResult().equals("true")))
        {
          this.v.sendMessage(this.v.obtainMessage(1, localPostAddContent.getTopic()));
          return;
        }
        Toast.makeText(this.mContext, "服务器未能返回数据，请稍后再试", 0).show();
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        Toast.makeText(this.mContext, "服务器未响应，请稍后再试", 0).show();
      }
  }

  protected void setContentView()
  {
    setContentView(2130903066);
  }

  public static class a extends m<AddPostActivity>
  {
    public a(AddPostActivity paramAddPostActivity)
    {
      super();
    }

    protected void a(AddPostActivity paramAddPostActivity, Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default:
        return;
      case 1:
        Post localPost = (Post)paramMessage.obj;
        AddPostActivity.a(paramAddPostActivity);
        AddPostActivity.b(paramAddPostActivity).clear();
        AddPostActivity.a(paramAddPostActivity, 0);
        paramAddPostActivity.setResult(23);
        Bundle localBundle3 = new Bundle();
        localBundle3.putInt("id", localPost.getTopic_id());
        paramAddPostActivity.startNewActivity(PostDetailActivity.class, true, localBundle3);
        return;
      case 2:
        int k = ((Integer)paramMessage.obj).intValue();
        int m = -1 + AddPostActivity.b(paramAddPostActivity).size();
        int n = k;
        if (n >= AddPostActivity.c(paramAddPostActivity).size())
        {
          AddPostActivity.a(paramAddPostActivity, k);
          AddPostActivity.e(paramAddPostActivity);
          return;
        }
        if (m >= k)
        {
          AddPostActivity.d(paramAddPostActivity).a((File)AddPostActivity.b(paramAddPostActivity).get(m));
          AddPostActivity.b(paramAddPostActivity).remove(m);
          m--;
        }
        if (n == k)
          ((AddImageView)AddPostActivity.c(paramAddPostActivity).get(n)).a(false);
        while (true)
        {
          n++;
          break;
          ((AddImageView)AddPostActivity.c(paramAddPostActivity).get(n)).a(true);
        }
      case 3:
        Bundle localBundle2 = new Bundle();
        localBundle2.putInt("currImage", AddPostActivity.f(paramAddPostActivity));
        paramAddPostActivity.startNewActivityForResult(ImageSelectorActivity.class, AddPostActivity.f(paramAddPostActivity), localBundle2);
        return;
      case 4:
        AddPostActivity.g(paramAddPostActivity).showSoftInput(AddPostActivity.h(paramAddPostActivity), 0);
        return;
      case 5:
        AddPostActivity.a(paramAddPostActivity, (String[])paramMessage.obj);
        int j = 0;
        if (j >= AddPostActivity.i(paramAddPostActivity).length)
        {
          c.b().x().a(paramAddPostActivity, AddPostActivity.j(paramAddPostActivity), 1, AddPostActivity.k(paramAddPostActivity));
          return;
        }
        if (j != -1 + AddPostActivity.i(paramAddPostActivity).length)
          AddPostActivity.j(paramAddPostActivity)[4] = (AddPostActivity.j(paramAddPostActivity)[4] + AddPostActivity.i(paramAddPostActivity)[j] + ",");
        while (true)
        {
          j++;
          break;
          AddPostActivity.j(paramAddPostActivity)[4] = (AddPostActivity.j(paramAddPostActivity)[4] + AddPostActivity.i(paramAddPostActivity)[j]);
        }
      case 6:
      }
      ArrayList localArrayList = new ArrayList();
      for (int i = 0; ; i++)
      {
        if (i >= AddPostActivity.b(paramAddPostActivity).size())
        {
          Bundle localBundle1 = new Bundle();
          localBundle1.putInt("currentitem_key", ((Integer)paramMessage.obj).intValue());
          localBundle1.putString("type", "offline");
          localBundle1.putSerializable("image_name", (Serializable)localArrayList);
          paramAddPostActivity.startNewActivity(ShowPictureActivity.class, false, localBundle1);
          return;
        }
        localArrayList.add(((File)AddPostActivity.b(paramAddPostActivity).get(i)).getAbsolutePath());
      }
    }
  }

  class b
    implements View.OnClickListener, ViewTreeObserver.OnGlobalLayoutListener
  {
    b()
    {
    }

    public void onClick(View paramView)
    {
      switch (paramView.getId())
      {
      case 2131296380:
      case 2131296381:
      case 2131296382:
      case 2131296383:
      default:
        return;
      case 2131296378:
        AddPostActivity.this.finish();
        return;
      case 2131296385:
        if (!AddPostActivity.l(AddPostActivity.this))
          AddPostActivity.m(AddPostActivity.this);
        AddPostActivity.g(AddPostActivity.this).toggleSoftInput(0, 2);
        return;
      case 2131296384:
        AddPostActivity.n(AddPostActivity.this).setVisibility(8);
        return;
      case 2131296379:
      }
      if (AddPostActivity.h(AddPostActivity.this).getText().toString().equals(""))
      {
        Toast.makeText(AddPostActivity.k(AddPostActivity.this), "帖子标题不能为空", 0).show();
        return;
      }
      if (AddPostActivity.o(AddPostActivity.this).getText().toString().equals(""))
      {
        Toast.makeText(AddPostActivity.k(AddPostActivity.this), "帖子内容不能为空", 0).show();
        return;
      }
      AddPostActivity.b(AddPostActivity.this, new String[5]);
      AddPostActivity.j(AddPostActivity.this)[0] = AddPostActivity.p(AddPostActivity.this).i();
      AddPostActivity.j(AddPostActivity.this)[1] = URLEncoder.encode(AddPostActivity.h(AddPostActivity.this).getText().toString());
      AddPostActivity.j(AddPostActivity.this)[2] = URLEncoder.encode(AddPostActivity.o(AddPostActivity.this).getText().toString());
      AddPostActivity.j(AddPostActivity.this)[3] = String.valueOf(AddPostActivity.q(AddPostActivity.this));
      AddPostActivity.j(AddPostActivity.this)[4] = "";
      if (AddPostActivity.b(AddPostActivity.this).size() != 0)
        new k(AddPostActivity.b(AddPostActivity.this), new String[] { "bbs" }, AddPostActivity.r(AddPostActivity.this)).start();
      while (true)
      {
        AddPostActivity.s(AddPostActivity.this).a("努力发表中");
        return;
        c.b().x().a(AddPostActivity.this, AddPostActivity.j(AddPostActivity.this), 1, AddPostActivity.k(AddPostActivity.this));
      }
    }

    public void onGlobalLayout()
    {
      Rect localRect = new Rect();
      AddPostActivity.t(AddPostActivity.this).getWindowVisibleDisplayFrame(localRect);
      int i = AddPostActivity.p(AddPostActivity.this).x() - (localRect.bottom - localRect.top);
      if (AddPostActivity.u(AddPostActivity.this) == null)
      {
        AddPostActivity.a(AddPostActivity.this, new ArrayList());
        AddPostActivity.u(AddPostActivity.this).add(Integer.valueOf(i));
      }
      do
        return;
      while (AddPostActivity.u(AddPostActivity.this).contains(Integer.valueOf(i)));
      AddPostActivity.u(AddPostActivity.this).add(Integer.valueOf(i));
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.AddPostActivity
 * JD-Core Version:    0.6.0
 */