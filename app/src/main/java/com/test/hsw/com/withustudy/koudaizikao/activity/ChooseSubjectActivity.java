package com.withustudy.koudaizikao.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.Toast;
import com.google.gson.Gson;
import com.withustudy.koudaizikao.a.b;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.b.h;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.base.m;
import com.withustudy.koudaizikao.custom.AdaptiveGridView;
import com.withustudy.koudaizikao.d.a.j;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.ChooseProToChooseSub;
import com.withustudy.koudaizikao.entity.MajorAndSubject;
import com.withustudy.koudaizikao.entity.Subject;
import com.withustudy.koudaizikao.entity.SubjectW;
import com.withustudy.koudaizikao.entity.content.ResultStatus;
import com.withustudy.koudaizikao.entity.req.FindSubject;
import com.withustudy.koudaizikao.entity.req.MajorUpLoad;
import com.withustudy.koudaizikao.entity.req.UploadMajorAndSubject;
import com.withustudy.koudaizikao.fragment.PersonalFragment;
import com.withustudy.koudaizikao.fragment.PersonalFragment.b;
import com.withustudy.koudaizikao.g.l;
import com.withustudy.koudaizikao.g.n;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ChooseSubjectActivity extends AbsBaseActivity
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  public static final int f = 6;
  public static final int g = 10;
  public static final int h = 11;
  private Button i;
  private Button j;
  private AdaptiveGridView k;
  private h l;
  private List<Subject> m;
  private b n;
  private a o;
  private ChooseProToChooseSub p;

  private boolean a()
  {
    int[] arrayOfInt = this.l.a();
    int i1 = 0;
    int i2 = 0;
    while (true)
    {
      if (i1 >= arrayOfInt.length)
      {
        if (i2 != 0)
          break;
        return false;
      }
      if (arrayOfInt[i1] == 1)
        i2++;
      i1++;
    }
    return true;
  }

  protected void bindData()
  {
    this.mProTools.a();
    FindSubject localFindSubject = new FindSubject();
    localFindSubject.setVersionName(this.mSP.p());
    localFindSubject.setClientType(n.a());
    localFindSubject.setImei(n.d(this.mContext));
    localFindSubject.setNet(n.c(this.mContext));
    localFindSubject.setUid(this.mSP.i());
    MajorUpLoad localMajorUpLoad = new MajorUpLoad();
    localMajorUpLoad.setMajorId(this.p.getMajorId());
    localMajorUpLoad.setMajorName(this.p.getMajorName());
    localMajorUpLoad.setProvName(this.p.getProvName());
    localFindSubject.setMajor(localMajorUpLoad);
    c.b().L().a(this, localFindSubject, 10);
  }

  protected void initData()
  {
    try
    {
      this.p = ((ChooseProToChooseSub)getIntent().getExtras().getSerializable("Major"));
      this.n = new b(this);
      this.o = new a();
      this.m = new ArrayList();
      return;
    }
    catch (Exception localException)
    {
    }
  }

  protected void initListener()
  {
    this.i.setOnClickListener(this.o);
    this.j.setOnClickListener(this.o);
    this.k.setOnItemClickListener(this.o);
  }

  protected void initView()
  {
    this.i = ((Button)findViewById(2131296458));
    this.j = ((Button)findViewById(2131296460));
    this.k = ((AdaptiveGridView)findViewById(2131296459));
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
    this.n.sendEmptyMessage(5);
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    super.onSuccess(paramString1, paramMap, paramString2, paramInt);
    this.mProTools.b();
    switch (paramInt)
    {
    default:
    case 10:
    case 11:
    }
    do
    {
      do
        return;
      while (paramString1 == null);
      try
      {
        SubjectW localSubjectW = (SubjectW)c.a().fromJson(paramString1, SubjectW.class);
        if ((localSubjectW != null) && (localSubjectW.getSubject() != null))
        {
          this.n.sendMessage(this.n.obtainMessage(1, localSubjectW.getSubject()));
          return;
        }
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        this.n.sendMessage(this.n.obtainMessage(6, "服务器未响应，请稍后再试"));
        return;
      }
      this.n.sendEmptyMessage(2);
      return;
    }
    while (paramString1 == null);
    try
    {
      ResultStatus localResultStatus = (ResultStatus)c.a().fromJson(paramString1, ResultStatus.class);
      if ((localResultStatus != null) && (localResultStatus.getStatus().equals("OK")))
      {
        this.n.sendEmptyMessage(3);
        return;
      }
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
      this.n.sendMessage(this.n.obtainMessage(6, "服务器未响应，请稍后再试"));
      return;
    }
    this.n.sendEmptyMessage(4);
  }

  protected void setContentView()
  {
    setContentView(2130903076);
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
      case 2131296459:
      default:
      case 2131296458:
      case 2131296460:
      }
      do
      {
        return;
        ChooseSubjectActivity.this.finish();
        return;
      }
      while (ChooseSubjectActivity.c(ChooseSubjectActivity.this) == null);
      if (!ChooseSubjectActivity.h(ChooseSubjectActivity.this))
      {
        Toast.makeText(ChooseSubjectActivity.b(ChooseSubjectActivity.this), "请至少选择一个科目", 0).show();
        return;
      }
      ArrayList localArrayList = new ArrayList();
      int[] arrayOfInt = ChooseSubjectActivity.c(ChooseSubjectActivity.this).a();
      for (int i = 0; ; i++)
      {
        if (i >= arrayOfInt.length)
        {
          UploadMajorAndSubject localUploadMajorAndSubject = new UploadMajorAndSubject();
          localUploadMajorAndSubject.setVersionName(ChooseSubjectActivity.e(ChooseSubjectActivity.this).p());
          localUploadMajorAndSubject.setClientType(n.a());
          localUploadMajorAndSubject.setImei(n.d(ChooseSubjectActivity.b(ChooseSubjectActivity.this)));
          localUploadMajorAndSubject.setNet(n.c(ChooseSubjectActivity.b(ChooseSubjectActivity.this)));
          localUploadMajorAndSubject.setUid(ChooseSubjectActivity.e(ChooseSubjectActivity.this).i());
          MajorUpLoad localMajorUpLoad = new MajorUpLoad();
          localMajorUpLoad.setMajorId(ChooseSubjectActivity.f(ChooseSubjectActivity.this).getMajorId());
          localMajorUpLoad.setMajorName(ChooseSubjectActivity.f(ChooseSubjectActivity.this).getMajorName());
          localMajorUpLoad.setProvId(ChooseSubjectActivity.f(ChooseSubjectActivity.this).getProId());
          localMajorUpLoad.setProvName(ChooseSubjectActivity.f(ChooseSubjectActivity.this).getProvName());
          MajorAndSubject localMajorAndSubject = new MajorAndSubject();
          localMajorAndSubject.setMajor(localMajorUpLoad);
          localMajorAndSubject.setSubject(localArrayList);
          localUploadMajorAndSubject.setMajorSubject(localMajorAndSubject);
          ChooseSubjectActivity.g(ChooseSubjectActivity.this).a();
          c.b().M().a(ChooseSubjectActivity.this, localUploadMajorAndSubject, 11);
          return;
        }
        if (arrayOfInt[i] != 1)
          continue;
        localArrayList.add((Subject)ChooseSubjectActivity.a(ChooseSubjectActivity.this).get(i));
      }
    }

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      ChooseSubjectActivity.c(ChooseSubjectActivity.this).a(paramInt);
      ChooseSubjectActivity.c(ChooseSubjectActivity.this).notifyDataSetChanged();
    }
  }

  private static class b extends m<ChooseSubjectActivity>
  {
    public b(ChooseSubjectActivity paramChooseSubjectActivity)
    {
      super();
    }

    protected void a(ChooseSubjectActivity paramChooseSubjectActivity, Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default:
        return;
      case 1:
        ChooseSubjectActivity.a(paramChooseSubjectActivity).clear();
        ChooseSubjectActivity.a(paramChooseSubjectActivity).addAll((List)paramMessage.obj);
        ChooseSubjectActivity.a(paramChooseSubjectActivity, new h(ChooseSubjectActivity.a(paramChooseSubjectActivity), ChooseSubjectActivity.b(paramChooseSubjectActivity)));
        List localList;
        int[] arrayOfInt;
        if (a.j.a != null)
        {
          localList = a.j.a;
          arrayOfInt = new int[ChooseSubjectActivity.a(paramChooseSubjectActivity).size()];
        }
        for (int i = 0; ; i++)
        {
          if (i >= ChooseSubjectActivity.a(paramChooseSubjectActivity).size())
          {
            ChooseSubjectActivity.c(paramChooseSubjectActivity).a(arrayOfInt);
            ChooseSubjectActivity.d(paramChooseSubjectActivity).setAdapter(ChooseSubjectActivity.c(paramChooseSubjectActivity));
            ChooseSubjectActivity.d(paramChooseSubjectActivity).setSelector(2131034189);
            return;
          }
          arrayOfInt[i] = 0;
          if (!localList.contains(((Subject)ChooseSubjectActivity.a(paramChooseSubjectActivity).get(i)).getId()))
            continue;
          arrayOfInt[i] = 1;
        }
      case 2:
        Toast.makeText(ChooseSubjectActivity.b(paramChooseSubjectActivity), "服务器未能返回数据，请稍后再试", 0).show();
        return;
      case 3:
        ChooseSubjectActivity.e(paramChooseSubjectActivity).m(ChooseSubjectActivity.f(paramChooseSubjectActivity).getProId());
        ChooseSubjectActivity.e(paramChooseSubjectActivity).n(ChooseSubjectActivity.f(paramChooseSubjectActivity).getProvName());
        ChooseSubjectActivity.e(paramChooseSubjectActivity).o(ChooseSubjectActivity.f(paramChooseSubjectActivity).getMajorId());
        ChooseSubjectActivity.e(paramChooseSubjectActivity).p(ChooseSubjectActivity.f(paramChooseSubjectActivity).getMajorName());
        if (PersonalFragment.b != null)
          PersonalFragment.b.sendEmptyMessage(3);
        Intent localIntent1 = new Intent("finish_choose_province_activity");
        ChooseSubjectActivity.b(paramChooseSubjectActivity).sendBroadcast(localIntent1);
        Intent localIntent2 = new Intent("finish_choose_profession_activity");
        ChooseSubjectActivity.b(paramChooseSubjectActivity).sendBroadcast(localIntent2);
        ChooseSubjectActivity.e(paramChooseSubjectActivity).d(true);
        Intent localIntent3 = new Intent("com.koudai.refresh_subject");
        ChooseSubjectActivity.b(paramChooseSubjectActivity).sendBroadcast(localIntent3);
        paramChooseSubjectActivity.finish();
        return;
      case 4:
        Toast.makeText(ChooseSubjectActivity.b(paramChooseSubjectActivity), "服务器未能返回数据，请稍后再试", 0).show();
        return;
      case 5:
        ChooseSubjectActivity.g(paramChooseSubjectActivity).b();
        Toast.makeText(ChooseSubjectActivity.b(paramChooseSubjectActivity), "服务器未响应，请稍后再试", 0).show();
        return;
      case 6:
      }
      Toast.makeText(ChooseSubjectActivity.b(paramChooseSubjectActivity), (String)paramMessage.obj, 0).show();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.ChooseSubjectActivity
 * JD-Core Version:    0.6.0
 */