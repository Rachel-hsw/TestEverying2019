package com.withustudy.koudaizikao.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.google.gson.Gson;
import com.koudai.test.BrushExcerciseDetailActivity;
import com.umeng.a.g;
import com.withustudy.koudaizikao.a.b;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.activity.ActivityCollectSubject;
import com.withustudy.koudaizikao.activity.ActivityErrorListActivity;
import com.withustudy.koudaizikao.activity.ActivityOldExamList;
import com.withustudy.koudaizikao.activity.BrushRankingActivity;
import com.withustudy.koudaizikao.activity.ChapterSectionListActivity;
import com.withustudy.koudaizikao.activity.KnowledgeExplainActivity;
import com.withustudy.koudaizikao.activity.SimulationInitActivity;
import com.withustudy.koudaizikao.base.SimpleAbsFragImpl;
import com.withustudy.koudaizikao.custom.IrregularPercentRelativeLayout;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.Subject;
import com.withustudy.koudaizikao.entity.SubjectStateW;
import com.withustudy.koudaizikao.entity.req.ReqSubjectState;
import com.withustudy.koudaizikao.g.h;
import com.withustudy.koudaizikao.g.n;
import java.io.PrintStream;
import java.util.Map;

public class SubjectFragment extends SimpleAbsFragImpl
  implements View.OnClickListener
{
  public static final int a = 888;
  private Subject b;
  private String c;
  private String d;
  private IrregularPercentRelativeLayout e;
  private IrregularPercentRelativeLayout f;
  private IrregularPercentRelativeLayout g;
  private IrregularPercentRelativeLayout h;
  private IrregularPercentRelativeLayout i;
  private IrregularPercentRelativeLayout j;
  private IrregularPercentRelativeLayout k;
  private IrregularPercentRelativeLayout l;
  private TextView m;
  private TextView n;
  private TextView o;
  private boolean p = false;
  private Handler q = new z(this);
  private SubjectStateW r;

  public View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    return View.inflate(getActivity(), 2130903167, null);
  }

  public void a()
  {
    ((BrushMainFragment)getParentFragment());
  }

  public void a(int paramInt, Subject paramSubject)
  {
    this.c = paramSubject.getId();
    this.d = paramSubject.getName();
    ReqSubjectState localReqSubjectState = new ReqSubjectState();
    localReqSubjectState.setClientType(n.a());
    localReqSubjectState.setImei(n.d(this.y));
    localReqSubjectState.setNet(n.c(this.y));
    localReqSubjectState.setVersionName(this.E.p());
    localReqSubjectState.setUid(this.E.i());
    localReqSubjectState.setSubjectId(paramSubject.getId());
    c.b().g().a(this, localReqSubjectState, 0);
  }

  public void a(View paramView)
  {
    this.i = ((IrregularPercentRelativeLayout)paramView.findViewById(2131296322));
    this.e = ((IrregularPercentRelativeLayout)paramView.findViewById(2131296323));
    this.f = ((IrregularPercentRelativeLayout)paramView.findViewById(2131296321));
    this.g = ((IrregularPercentRelativeLayout)paramView.findViewById(2131296324));
    this.h = ((IrregularPercentRelativeLayout)paramView.findViewById(2131297099));
    this.j = ((IrregularPercentRelativeLayout)paramView.findViewById(2131297100));
    this.k = ((IrregularPercentRelativeLayout)paramView.findViewById(2131297101));
    this.l = ((IrregularPercentRelativeLayout)paramView.findViewById(2131297094));
    int i1 = this.l.getHeight();
    int i2 = this.l.getWidth();
    h.a(i1 + ":" + i2);
    this.m = ((TextView)paramView.findViewById(2131297097));
    this.n = ((TextView)paramView.findViewById(2131297096));
    this.o = ((TextView)paramView.findViewById(2131297098));
  }

  public void a(boolean paramBoolean)
  {
    int i1 = this.l.getHeight();
    int i2 = this.l.getWidth();
    h.a("onWindowFocusChanged:" + i1 + ":" + i2);
  }

  public void c()
  {
    this.j.setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.h.setOnClickListener(this);
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131296322:
      g.b(this.y, "brush_main_zhangjielianxi");
      Bundle localBundle8 = new Bundle();
      localBundle8.putString("subjectId", this.c);
      localBundle8.putString("subjectName", this.d);
      a(ChapterSectionListActivity.class, false, localBundle8);
      return;
    case 2131296324:
      g.b(this.y, "brush_main_zhishidian");
      Bundle localBundle7 = new Bundle();
      localBundle7.putString("subjectId", this.c);
      localBundle7.putString("subjectName", this.d);
      a(KnowledgeExplainActivity.class, false, localBundle7);
      return;
    case 2131297099:
      g.b(this.y, "brush_main_zhinengshuati");
      Bundle localBundle6 = new Bundle();
      localBundle6.putString("subjectId", this.c);
      localBundle6.putString("subjectName", this.d);
      localBundle6.putInt("BrushPageFrom", 888);
      a(BrushExcerciseDetailActivity.class, false, localBundle6);
      return;
    case 2131296323:
      g.b(this.y, "brush_main_linianzhenti");
      Bundle localBundle5 = new Bundle();
      localBundle5.putString("subjectId", this.c);
      localBundle5.putString("subjectName", this.d);
      a(ActivityOldExamList.class, false, localBundle5);
      return;
    case 2131296321:
      g.b(this.y, "brush_main_monikao");
      Bundle localBundle4 = new Bundle();
      localBundle4.putString("subjectId", this.c);
      localBundle4.putString("subjectName", this.d);
      a(SimulationInitActivity.class, false, localBundle4);
      return;
    case 2131297108:
      g.b(this.y, "brush_main_mokaobang");
      Bundle localBundle3 = new Bundle();
      localBundle3.putInt("type", 1);
      localBundle3.putString("subjectId", this.c);
      localBundle3.putString("subjectName", this.d);
      a(BrushRankingActivity.class, false, localBundle3);
      return;
    case 2131297100:
      g.b(this.y, "brush_main_collect");
      Bundle localBundle2 = new Bundle();
      localBundle2.putString("subjectId", this.c);
      localBundle2.putString("subjectName", this.d);
      a(ActivityCollectSubject.class, false, localBundle2);
      return;
    case 2131297101:
    }
    g.b(this.y, "personal_error");
    Bundle localBundle1 = new Bundle();
    localBundle1.putInt("type", 1);
    localBundle1.putString("subjectId", this.c);
    localBundle1.putString("subjectName", this.d);
    a(ActivityErrorListActivity.class, false, localBundle1);
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    super.onSuccess(paramString1, paramMap, paramString2, paramInt);
    if (paramString1 != null)
    {
      Gson localGson = new Gson();
      try
      {
        this.r = ((SubjectStateW)localGson.fromJson(paramString1, SubjectStateW.class));
        if (this.r != null)
        {
          this.q.sendEmptyMessage(0);
          return;
        }
        h.a("刷题主界面数据解析实体bean为null");
        return;
      }
      catch (Exception localException)
      {
        h.a("刷题主界面数据实体解析异常:" + localException.getMessage());
      }
    }
  }

  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    System.out.println();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.fragment.SubjectFragment
 * JD-Core Version:    0.6.0
 */