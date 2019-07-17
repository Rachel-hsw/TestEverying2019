package com.withustudy.koudaizikao.activity;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.provider.MediaStore.Images.Media;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.withustudy.koudaizikao.b.l;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.base.m;
import com.withustudy.koudaizikao.entity.LocalImage;
import com.withustudy.koudaizikao.entity.LocalImageFolder;
import com.withustudy.koudaizikao.fragment.ImageSelectorFragment;
import com.withustudy.koudaizikao.g.f;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ImageSelectorActivity extends AbsBaseActivity
{
  public static final String a = "all";
  public static final String b = "currImage";
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 3;
  public static final int f = 4;
  public static final int g = 5;
  public static final int h = 6;
  private b A;
  private Button i;
  private ImageView j;
  private GridView k;
  private l l;
  private List<LocalImage> m;
  private RelativeLayout n;
  private TextView o;
  private TextView p;
  private ImageSelectorFragment q;
  private FragmentTransaction r;
  private List<LocalImage> s;
  private List<LocalImageFolder> t;
  private String u;
  private int v;
  private boolean w = false;
  private boolean x = false;
  private final float[] y = { 0.0F, 0.1F, 0.2F, 0.3F, 0.4F, 0.5F, 0.6F, 0.7F, 0.8F, 0.9F, 1.0F };
  private a z;

  private String b(String paramString)
  {
    return paramString.substring(1 + paramString.lastIndexOf("/"), paramString.length());
  }

  private void b()
  {
    this.s.clear();
    if (this.u.equals("all"))
      this.s.addAll(this.m);
    while (true)
    {
      this.l = new l(this.s, this.mContext, this.A, this.v);
      this.k.setAdapter(this.l);
      return;
      for (int i1 = 0; i1 < this.m.size(); i1++)
      {
        if (!((LocalImage)this.m.get(i1)).getParent().equals(this.u))
          continue;
        this.s.add((LocalImage)this.m.get(i1));
      }
    }
  }

  private void c()
  {
    if (!this.w)
    {
      this.w = true;
      this.r = this.mFragmentManager.beginTransaction();
      this.r.setCustomAnimations(2130968594, 2130968595);
      this.r.show(this.q).commit();
      new s(this).start();
      return;
    }
    this.w = false;
    this.r = this.mFragmentManager.beginTransaction();
    this.r.setCustomAnimations(2130968594, 2130968595);
    this.r.hide(this.q).commit();
    new t(this).start();
  }

  public int a()
  {
    return this.v;
  }

  public void a(String paramString)
  {
    this.u = paramString;
    if (this.u.equals("all"))
      this.o.setText("所有图片");
    while (true)
    {
      b();
      c();
      return;
      this.o.setText(this.u);
    }
  }

  protected void bindData()
  {
    this.j.setAlpha(0.0F);
    this.A.sendEmptyMessage(4);
    this.u = "all";
    this.p.setText("完成(" + this.v + "/9)");
    new c().start();
  }

  protected void initData()
  {
    this.v = getIntent().getExtras().getInt("currImage");
    this.z = new a();
    this.A = new b(this);
    this.s = new ArrayList();
    this.t = new ArrayList();
    this.m = new ArrayList();
    this.q = new ImageSelectorFragment();
    this.r = this.mFragmentManager.beginTransaction();
    this.r.add(2131296521, this.q).hide(this.q).commit();
  }

  protected void initListener()
  {
    this.i.setOnClickListener(this.z);
    this.p.setOnClickListener(this.z);
    this.n.setOnClickListener(this.z);
    this.j.setOnClickListener(this.z);
    this.k.setOnItemClickListener(this.z);
  }

  protected void initView()
  {
    this.i = ((Button)findViewById(2131296520));
    this.k = ((GridView)findViewById(2131296518));
    this.n = ((RelativeLayout)findViewById(2131296522));
    this.o = ((TextView)findViewById(2131296523));
    this.p = ((TextView)findViewById(2131296524));
    this.j = ((ImageView)findViewById(2131296519));
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this.w)
        c();
      while (true)
      {
        return true;
        finish();
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }

  protected void setContentView()
  {
    setContentView(2130903086);
  }

  class a
    implements View.OnClickListener, AdapterView.OnItemClickListener
  {
    a()
    {
    }

    public void onClick(View paramView)
    {
      switch (paramView.getId())
      {
      case 2131296521:
      case 2131296523:
      default:
      case 2131296520:
      case 2131296524:
      case 2131296522:
      case 2131296519:
      }
      do
      {
        do
        {
          return;
          ImageSelectorActivity.this.finish();
          return;
          ArrayList localArrayList = new ArrayList();
          for (int i = 0; ; i++)
          {
            if (i >= ImageSelectorActivity.c(ImageSelectorActivity.this).size())
            {
              Intent localIntent = new Intent();
              Bundle localBundle = new Bundle();
              localBundle.putParcelableArrayList("result", localArrayList);
              localIntent.putExtras(localBundle);
              ImageSelectorActivity.this.setResult(11, localIntent);
              ImageSelectorActivity.this.finish();
              return;
            }
            if (!((LocalImage)ImageSelectorActivity.c(ImageSelectorActivity.this).get(i)).isChoose())
              continue;
            localArrayList.add((LocalImage)ImageSelectorActivity.c(ImageSelectorActivity.this).get(i));
          }
        }
        while (!ImageSelectorActivity.k(ImageSelectorActivity.this));
        ImageSelectorActivity.l(ImageSelectorActivity.this);
        return;
      }
      while (!ImageSelectorActivity.m(ImageSelectorActivity.this));
      ImageSelectorActivity.l(ImageSelectorActivity.this);
    }

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
    }
  }

  private static class b extends m<ImageSelectorActivity>
  {
    public b(ImageSelectorActivity paramImageSelectorActivity)
    {
      super();
    }

    protected void a(ImageSelectorActivity paramImageSelectorActivity, Message paramMessage)
    {
      int i = 0;
      switch (paramMessage.what)
      {
      default:
        return;
      case 1:
        ImageSelectorActivity.a(paramImageSelectorActivity).a(ImageSelectorActivity.b(paramImageSelectorActivity));
        ImageSelectorActivity.a(paramImageSelectorActivity).a(ImageSelectorActivity.c(paramImageSelectorActivity).size());
        ImageSelectorActivity.a(paramImageSelectorActivity).a(((LocalImage)ImageSelectorActivity.c(paramImageSelectorActivity).get(0)).getPath());
        ImageSelectorActivity.a(paramImageSelectorActivity, true);
        ImageSelectorActivity.a(paramImageSelectorActivity, ((LocalImageFolder)ImageSelectorActivity.b(paramImageSelectorActivity).get(0)).getName());
        ImageSelectorActivity.d(paramImageSelectorActivity).setText(ImageSelectorActivity.e(paramImageSelectorActivity));
        ImageSelectorActivity.f(paramImageSelectorActivity);
        return;
      case 2:
        ImageSelectorActivity.g(paramImageSelectorActivity).setAlpha(ImageSelectorActivity.h(paramImageSelectorActivity)[paramMessage.arg1]);
        return;
      case 3:
        ImageSelectorActivity.g(paramImageSelectorActivity).setVisibility(0);
        return;
      case 4:
        ImageSelectorActivity.g(paramImageSelectorActivity).setVisibility(8);
        return;
      case 5:
        String str2 = (String)paramMessage.obj;
        while (true)
        {
          if (i >= ImageSelectorActivity.c(paramImageSelectorActivity).size())
          {
            ImageSelectorActivity.a(paramImageSelectorActivity, 1 + ImageSelectorActivity.i(paramImageSelectorActivity));
            ImageSelectorActivity.j(paramImageSelectorActivity).setText("完成(" + ImageSelectorActivity.i(paramImageSelectorActivity) + "/9)");
            return;
          }
          if (((LocalImage)ImageSelectorActivity.c(paramImageSelectorActivity).get(i)).getPath().equals(str2))
            ((LocalImage)ImageSelectorActivity.c(paramImageSelectorActivity).get(i)).setChoose(true);
          i++;
        }
      case 6:
      }
      String str1 = (String)paramMessage.obj;
      for (int j = 0; ; j++)
      {
        if (j >= ImageSelectorActivity.c(paramImageSelectorActivity).size())
        {
          ImageSelectorActivity.a(paramImageSelectorActivity, -1 + ImageSelectorActivity.i(paramImageSelectorActivity));
          ImageSelectorActivity.j(paramImageSelectorActivity).setText("完成(" + ImageSelectorActivity.i(paramImageSelectorActivity) + "/9)");
          return;
        }
        if (!((LocalImage)ImageSelectorActivity.c(paramImageSelectorActivity).get(j)).getPath().equals(str1))
          continue;
        ((LocalImage)ImageSelectorActivity.c(paramImageSelectorActivity).get(j)).setChoose(false);
      }
    }
  }

  class c extends Thread
  {
    c()
    {
    }

    public void run()
    {
      super.run();
      ImageSelectorActivity.c(ImageSelectorActivity.this).clear();
      ImageSelectorActivity.b(ImageSelectorActivity.this).clear();
      ArrayList localArrayList = new ArrayList();
      Uri localUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
      Cursor localCursor = ImageSelectorActivity.this.getContentResolver().query(localUri, null, "mime_type=? or mime_type=?", new String[] { "image/jpeg", "image/png" }, "date_modified");
      while (true)
      {
        if (!localCursor.moveToNext())
        {
          localCursor.close();
          ImageSelectorActivity.o(ImageSelectorActivity.this).sendEmptyMessage(1);
          return;
        }
        LocalImage localLocalImage = new LocalImage();
        localLocalImage.setChoose(false);
        String str1 = localCursor.getString(localCursor.getColumnIndex("_data"));
        localLocalImage.setPath(str1);
        File localFile = new File(str1).getParentFile();
        if ((localFile == null) || (localFile.getAbsolutePath().equals(ImageSelectorActivity.n(ImageSelectorActivity.this).a())))
        {
          localLocalImage.setParent("root");
          ImageSelectorActivity.c(ImageSelectorActivity.this).add(localLocalImage);
          continue;
        }
        String str2 = localFile.getAbsolutePath();
        localLocalImage.setParent(ImageSelectorActivity.b(ImageSelectorActivity.this, str2));
        ImageSelectorActivity.c(ImageSelectorActivity.this).add(localLocalImage);
        if (localArrayList.contains(str2))
          continue;
        localArrayList.add(str2);
        LocalImageFolder localLocalImageFolder = new LocalImageFolder();
        localLocalImageFolder.setName(ImageSelectorActivity.b(ImageSelectorActivity.this, str2));
        localLocalImageFolder.setFirst(str1);
        localLocalImageFolder.setCount(localFile.list(new u(this)).length);
        ImageSelectorActivity.b(ImageSelectorActivity.this).add(localLocalImageFolder);
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.ImageSelectorActivity
 * JD-Core Version:    0.6.0
 */