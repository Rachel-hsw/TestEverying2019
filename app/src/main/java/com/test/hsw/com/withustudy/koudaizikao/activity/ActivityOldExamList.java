package com.withustudy.koudaizikao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.google.gson.Gson;
import com.withustudy.koudaizikao.a.b;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.ExamDateList;
import com.withustudy.koudaizikao.entity.ReqOldExam;
import com.withustudy.koudaizikao.entity.req.ExamDate;
import com.withustudy.koudaizikao.entity.req.UserSubject;
import com.withustudy.koudaizikao.g.l;
import java.util.List;
import java.util.Map;

public class ActivityOldExamList extends AbsBaseActivity
  implements View.OnClickListener
{
  public static final int a = 16;
  private static final int b;
  private LinearLayout c;
  private ListView d;
  private a e;
  private Bundle f;
  private String g;
  private String h;
  private LinearLayout i;
  private ExamDateList j;
  private List<ExamDate> k;
  private Handler l = new h(this);

  protected void bindData()
  {
    this.mProTools.a(true);
    ReqOldExam localReqOldExam = new ReqOldExam();
    UserSubject localUserSubject = new UserSubject();
    localUserSubject.setUid(this.mSP.i());
    localUserSubject.setSubjectId(this.g);
    localReqOldExam.setUserSubject(localUserSubject);
    c.b().ap().a(this, localReqOldExam, 0);
  }

  protected void initData()
  {
    this.f = getIntent().getExtras();
    try
    {
      this.g = this.f.getString("subjectId");
      this.h = this.f.getString("subjectName");
      return;
    }
    catch (Exception localException)
    {
    }
  }

  protected void initListener()
  {
    this.c.setOnClickListener(this);
    this.d.setOnItemClickListener(new i(this));
  }

  protected void initView()
  {
    this.c = ((LinearLayout)findViewById(2131296593));
    this.d = ((ListView)findViewById(2131296594));
    this.i = ((LinearLayout)findViewById(2131296595));
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131296593:
    }
    finish();
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

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    super.onSuccess(paramString1, paramMap, paramString2, paramInt);
    this.mProTools.b();
    Gson localGson;
    if (paramString1 != null)
    {
      localGson = c.a();
      switch (paramInt)
      {
      default:
      case 0:
      }
    }
    while (true)
    {
      return;
      try
      {
        this.j = ((ExamDateList)localGson.fromJson(paramString1, ExamDateList.class));
        if (this.j == null)
          continue;
        this.l.sendEmptyMessage(0);
        return;
      }
      catch (Exception localException)
      {
      }
    }
  }

  protected void setContentView()
  {
    setContentView(2130903096);
  }

  private class a extends BaseAdapter
  {
    private a()
    {
    }

    public int getCount()
    {
      if (ActivityOldExamList.b(ActivityOldExamList.this) == null)
        return 0;
      return ActivityOldExamList.b(ActivityOldExamList.this).size();
    }

    public Object getItem(int paramInt)
    {
      return null;
    }

    public long getItemId(int paramInt)
    {
      return 0L;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      ActivityOldExamList.b localb;
      if (paramView == null)
      {
        paramView = View.inflate(ActivityOldExamList.this.getApplicationContext(), 2130903095, null);
        localb = new ActivityOldExamList.b(ActivityOldExamList.this);
        ActivityOldExamList.b.a(localb, (TextView)paramView.findViewById(2131296592));
        paramView.setTag(localb);
      }
      while (true)
      {
        ExamDate localExamDate = (ExamDate)ActivityOldExamList.b(ActivityOldExamList.this).get(paramInt);
        ActivityOldExamList.b.a(localb).setText(localExamDate.getDate());
        return paramView;
        localb = (ActivityOldExamList.b)paramView.getTag();
      }
    }
  }

  class b
  {
    private TextView b;

    b()
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.ActivityOldExamList
 * JD-Core Version:    0.6.0
 */