package com.withustudy.koudaizikao.activity;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.provider.MediaStore.Images.Media;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.android.http.e;
import com.android.http.k;
import com.google.gson.Gson;
import com.withustudy.koudaizikao.a.a;
import com.withustudy.koudaizikao.a.b;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.base.m;
import com.withustudy.koudaizikao.custom.LoadingView;
import com.withustudy.koudaizikao.entity.PersonalInfo;
import com.withustudy.koudaizikao.entity.content.ResultState;
import com.withustudy.koudaizikao.entity.req.ChangePersonalInfo;
import com.withustudy.koudaizikao.entity.req.UserBaseInfo;
import com.withustudy.koudaizikao.fragment.PersonalFragment;
import com.withustudy.koudaizikao.fragment.PersonalFragment.b;
import com.withustudy.koudaizikao.g.h;
import com.withustudy.koudaizikao.g.l;
import com.withustudy.koudaizikao.g.n;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PersonalSetActivity extends AbsBaseActivity
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  public static final int f = 6;
  public static final int g = 10;
  public static final int h = 11;
  public static final int i = 12;
  public static final int j = 20;
  public static final int k = 21;
  private TextView A;
  private b B;
  private a C;
  private PersonalInfo D;
  private File E;
  private Button l;
  private LoadingView m;
  private ImageView n;
  private TextView o;
  private TextView[] p;
  private LinearLayout q;
  private LinearLayout r;
  private LinearLayout s;
  private TextView t;
  private LinearLayout u;
  private LinearLayout v;
  private TextView w;
  private LinearLayout x;
  private TextView y;
  private LinearLayout z;

  private String a(String paramString)
  {
    if (paramString.length() != 11)
      return null;
    try
    {
      Long.valueOf(paramString);
      String str1 = paramString.substring(0, 3);
      String str2 = paramString.substring(7, 11);
      String str3 = str1 + "****" + str2;
      return str3;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return null;
  }

  private void a()
  {
    a locala = c.b().J();
    String[] arrayOfString = new String[2];
    arrayOfString[0] = this.mSP.i();
    arrayOfString[1] = "get";
    locala.a(this, arrayOfString, 10, this.mContext);
  }

  private void a(int paramInt)
  {
    int i1 = 0;
    if (i1 >= this.p.length)
      return;
    if (i1 == paramInt)
    {
      this.p[i1].setBackgroundColor(Color.parseColor("#00B8E5"));
      this.p[i1].setTextColor(Color.parseColor("#ffffff"));
    }
    while (true)
    {
      i1++;
      break;
      this.p[i1].setBackgroundColor(Color.parseColor("#ffffff"));
      this.p[i1].setTextColor(Color.parseColor("#999999"));
    }
  }

  protected void bindData()
  {
    this.q.setVisibility(8);
    this.m.setVisibility(0);
    a(2);
    a();
  }

  public void finish()
  {
    super.finish();
    if (this.E != null)
      this.mFileTools.a(this.E);
  }

  public void finish(int paramInt1, int paramInt2)
  {
    super.finish(paramInt1, paramInt2);
    if (this.E != null)
      this.mFileTools.a(this.E);
  }

  protected void initData()
  {
    this.B = new b(this);
    this.C = new a();
  }

  protected void initListener()
  {
    this.l.setOnClickListener(this.C);
    for (int i1 = 0; ; i1++)
    {
      if (i1 >= this.p.length)
      {
        this.r.setOnClickListener(this.C);
        this.s.setOnClickListener(this.C);
        this.u.setOnClickListener(this.C);
        this.n.setOnClickListener(this.C);
        return;
      }
      this.p[i1].setOnClickListener(this.C);
    }
  }

  protected void initView()
  {
    this.l = ((Button)findViewById(2131296596));
    this.m = ((LoadingView)findViewById(2131296615));
    this.q = ((LinearLayout)findViewById(2131296597));
    this.n = ((ImageView)findViewById(2131296599));
    this.o = ((TextView)findViewById(2131296600));
    this.r = ((LinearLayout)findViewById(2131296601));
    this.s = ((LinearLayout)findViewById(2131296602));
    this.t = ((TextView)findViewById(2131296603));
    this.p = new TextView[3];
    this.p[0] = ((TextView)findViewById(2131296605));
    this.p[1] = ((TextView)findViewById(2131296606));
    this.p[2] = ((TextView)findViewById(2131296607));
    this.u = ((LinearLayout)findViewById(2131296608));
    this.v = ((LinearLayout)findViewById(2131296609));
    this.w = ((TextView)findViewById(2131296610));
    this.x = ((LinearLayout)findViewById(2131296611));
    this.y = ((TextView)findViewById(2131296612));
    this.z = ((LinearLayout)findViewById(2131296613));
    this.A = ((TextView)findViewById(2131296614));
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    default:
    case 20:
    case 21:
    }
    while (true)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      if (paramInt2 == -1)
      {
        if (paramIntent == null)
          continue;
        try
        {
          Uri localUri = paramIntent.getData();
          if (localUri == null)
            continue;
          ContentResolver localContentResolver = getContentResolver();
          BitmapFactory.Options localOptions = new BitmapFactory.Options();
          localOptions.inSampleSize = 4;
          localObject = BitmapFactory.decodeStream(localContentResolver.openInputStream(localUri), null, localOptions);
          i1 = ((Bitmap)localObject).getWidth();
          i2 = ((Bitmap)localObject).getHeight();
          if (i1 > i2)
          {
            localObject = Bitmap.createBitmap((Bitmap)localObject, (i1 - i2) / 2, 0, i2, i2);
            if (this.mFileTools.a(this.E, (Bitmap)localObject) == null)
              continue;
            ((Bitmap)localObject).recycle();
            ArrayList localArrayList = new ArrayList();
            localArrayList.add(this.E);
            this.mProTools.a("正在上传头像");
            new k(localArrayList, new String[] { "account" }, this.B).start();
          }
        }
        catch (IOException localIOException)
        {
          while (true)
          {
            int i1;
            int i2;
            localIOException.printStackTrace();
            break;
            if (i2 <= i1)
              continue;
            int i3 = i2 - i1;
            Bitmap localBitmap = Bitmap.createBitmap((Bitmap)localObject, 0, i3 / 2, i1, i1);
            Object localObject = localBitmap;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          Toast.makeText(this.mContext, "图片过大，小袋内存不够用啦!", 0).show();
          localOutOfMemoryError.printStackTrace();
        }
        continue;
      }
      if (this.E == null)
        continue;
      this.mFileTools.a(this.E);
      continue;
      a();
    }
  }

  public void onError(String paramString1, String paramString2, int paramInt)
  {
    super.onError(paramString1, paramString2, paramInt);
    this.B.sendEmptyMessage(4);
    switch (paramInt)
    {
    default:
      return;
    case 11:
    }
    this.B.sendEmptyMessage(6);
  }

  protected void onResume()
  {
    super.onResume();
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    super.onSuccess(paramString1, paramMap, paramString2, paramInt);
    this.m.setVisibility(8);
    this.q.setVisibility(0);
    switch (paramInt)
    {
    default:
    case 10:
    case 11:
    case 12:
    }
    label227: 
    do
    {
      do
      {
        while (true)
        {
          return;
          if (paramString1 == null)
            continue;
          while (true)
          {
            try
            {
              this.D = ((PersonalInfo)c.a().fromJson(paramString1, PersonalInfo.class));
              if (this.D == null)
                break label271;
              if (!this.D.getNickname().equals(""))
              {
                this.o.setText(this.D.getNickname());
                this.t.setText(a(this.D.getPhoneNumber()));
                if (this.D.getProfileUrl().equals(""))
                  continue;
                this.mFileDownLoad.a(this.D.getProfileUrl(), this.n, 1000);
                if (!this.D.getGender().equals("MALE"))
                  break label227;
                a(0);
                return;
              }
            }
            catch (Exception localException3)
            {
              localException3.printStackTrace();
              Toast.makeText(this.mContext, "服务器未响应，请稍后再试", 0).show();
              return;
            }
            this.o.setText("小袋");
            continue;
            if (this.D.getGender().equals("FEMALE"))
            {
              a(1);
              return;
            }
            if (!this.D.getGender().equals("DEFAULT"))
              break;
            a(2);
            return;
          }
        }
        Toast.makeText(this.mContext, "服务器未能返回数据，请稍后再试", 0).show();
        return;
        this.B.sendEmptyMessage(6);
      }
      while (paramString1 == null);
      try
      {
        ResultState localResultState2 = (ResultState)c.a().fromJson(paramString1, ResultState.class);
        if ((localResultState2 != null) && (localResultState2.getState().equals("STATE_OK")))
        {
          this.B.sendMessage(this.B.obtainMessage(2));
          return;
        }
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        Toast.makeText(this.mContext, "服务器未响应，请稍后再试", 0).show();
        return;
      }
      this.B.sendEmptyMessage(4);
      return;
    }
    while (paramString1 == null);
    try
    {
      label271: ResultState localResultState1 = (ResultState)c.a().fromJson(paramString1, ResultState.class);
      if ((localResultState1 != null) && (localResultState1.getState().equals("STATE_OK")))
      {
        this.B.sendEmptyMessage(3);
        return;
      }
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
      Toast.makeText(this.mContext, "服务器未响应，请稍后再试", 0).show();
      return;
    }
    this.B.sendEmptyMessage(5);
  }

  protected void setContentView()
  {
    setContentView(2130903097);
  }

  class a
    implements View.OnClickListener
  {
    a()
    {
    }

    public void onClick(View paramView)
    {
      ChangePersonalInfo localChangePersonalInfo = new ChangePersonalInfo();
      localChangePersonalInfo.setVersionName(PersonalSetActivity.a(PersonalSetActivity.this).p());
      localChangePersonalInfo.setClientType(n.a());
      localChangePersonalInfo.setImei(n.d(PersonalSetActivity.d(PersonalSetActivity.this)));
      localChangePersonalInfo.setNet(n.c(PersonalSetActivity.d(PersonalSetActivity.this)));
      localChangePersonalInfo.setUid(PersonalSetActivity.a(PersonalSetActivity.this).i());
      switch (paramView.getId())
      {
      case 2131296597:
      case 2131296598:
      case 2131296600:
      case 2131296603:
      case 2131296604:
      default:
      case 2131296596:
      case 2131296601:
      case 2131296602:
        do
        {
          return;
          PersonalSetActivity.this.finish();
          return;
          Bundle localBundle = new Bundle();
          localBundle.putString("nickname", PersonalSetActivity.e(PersonalSetActivity.this).getNickname());
          PersonalSetActivity.this.startNewActivityForResult(SetNickNameActivity.class, 21, localBundle);
          return;
        }
        while (!PersonalSetActivity.e(PersonalSetActivity.this).getPhoneNumber().equals(""));
        PersonalSetActivity.this.startNewActivityForResult(BindPhoneActivity.class, 21, null);
        return;
      case 2131296605:
        PersonalSetActivity.a(PersonalSetActivity.this, 0);
        UserBaseInfo localUserBaseInfo3 = new UserBaseInfo();
        localUserBaseInfo3.setGender("MALE");
        localChangePersonalInfo.setUserBasicInfo(localUserBaseInfo3);
        c.b().e().a(PersonalSetActivity.this, localChangePersonalInfo, 12);
        return;
      case 2131296606:
        PersonalSetActivity.a(PersonalSetActivity.this, 1);
        UserBaseInfo localUserBaseInfo2 = new UserBaseInfo();
        localUserBaseInfo2.setGender("FEMALE");
        localChangePersonalInfo.setUserBasicInfo(localUserBaseInfo2);
        c.b().e().a(PersonalSetActivity.this, localChangePersonalInfo, 12);
        return;
      case 2131296607:
        PersonalSetActivity.a(PersonalSetActivity.this, 2);
        UserBaseInfo localUserBaseInfo1 = new UserBaseInfo();
        localUserBaseInfo1.setGender("DEFAULT");
        localChangePersonalInfo.setUserBasicInfo(localUserBaseInfo1);
        c.b().e().a(PersonalSetActivity.this, localChangePersonalInfo, 12);
        return;
      case 2131296608:
        if (PersonalSetActivity.e(PersonalSetActivity.this).getPhoneNumber().equals(""))
        {
          Toast.makeText(PersonalSetActivity.d(PersonalSetActivity.this), "请先绑定手机号", 0).show();
          return;
        }
        PersonalSetActivity.this.startNewActivity(SetPasswordActivity.class, false, null);
        return;
      case 2131296599:
      }
      PersonalSetActivity.a(PersonalSetActivity.this, PersonalSetActivity.f(PersonalSetActivity.this).a(System.currentTimeMillis() + ".JPEG"));
      h.a(PersonalSetActivity.g(PersonalSetActivity.this).getAbsolutePath());
      Intent localIntent = new Intent("android.intent.action.GET_CONTENT");
      localIntent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
      PersonalSetActivity.this.startActivityForResult(localIntent, 20);
    }
  }

  public static class b extends m<PersonalSetActivity>
  {
    public b(PersonalSetActivity paramPersonalSetActivity)
    {
      super();
    }

    protected void a(PersonalSetActivity paramPersonalSetActivity, Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default:
        return;
      case 1:
        ChangePersonalInfo localChangePersonalInfo = new ChangePersonalInfo();
        localChangePersonalInfo.setVersionName(PersonalSetActivity.a(paramPersonalSetActivity).p());
        localChangePersonalInfo.setClientType(n.a());
        localChangePersonalInfo.setImei(n.d(paramPersonalSetActivity));
        localChangePersonalInfo.setNet(n.c(paramPersonalSetActivity));
        localChangePersonalInfo.setUid(PersonalSetActivity.a(paramPersonalSetActivity).i());
        UserBaseInfo localUserBaseInfo = new UserBaseInfo();
        localUserBaseInfo.setProfileUrl(((String[])paramMessage.obj)[0]);
        localChangePersonalInfo.setUserBasicInfo(localUserBaseInfo);
        c.b().e().a(paramPersonalSetActivity, localChangePersonalInfo, 11);
        return;
      case 2:
        Toast.makeText(paramPersonalSetActivity, "设置头像成功", 0).show();
        PersonalSetActivity.b(paramPersonalSetActivity);
        PersonalFragment.b.sendEmptyMessage(4);
        return;
      case 3:
        Toast.makeText(paramPersonalSetActivity, "设置性别成功", 0).show();
        return;
      case 4:
      case 5:
        Toast.makeText(paramPersonalSetActivity, "服务器未能返回数据，请稍后再试", 0).show();
        return;
      case 6:
      }
      PersonalSetActivity.c(paramPersonalSetActivity).b();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.PersonalSetActivity
 * JD-Core Version:    0.6.0
 */