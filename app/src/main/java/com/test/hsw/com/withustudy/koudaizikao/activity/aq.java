package com.withustudy.koudaizikao.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.Toast;
import com.withustudy.koudaizikao.custom.a.a;
import com.withustudy.koudaizikao.entity.BrushExcerciseBean;
import com.withustudy.koudaizikao.entity.Exercises;
import com.withustudy.koudaizikao.entity.RspCollectExcerBean;
import com.withustudy.koudaizikao.entity.UrlShortBean;
import com.withustudy.koudaizikao.entity.Urls;
import com.withustudy.koudaizikao.fragment.QuestionDetailFragment;
import com.withustudy.koudaizikao.g.h;
import com.withustudy.koudaizikao.g.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class aq extends Handler
{
  aq(QuestionDetailActivity paramQuestionDetailActivity)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
    case 7:
    case 0:
    case 10:
    case 1:
    case 3:
    case 5:
    case 8:
    case 9:
    case 6:
    case 22:
    case 21:
    case 101:
      label288: label336: label894: List localList1;
      do
      {
        do
        {
          RspCollectExcerBean localRspCollectExcerBean;
          do
          {
            do
            {
              return;
              Toast.makeText(this.a.getApplicationContext(), "小袋努力编题中。。。", 0).show();
              return;
              List localList2 = QuestionDetailActivity.a(this.a).getExercises();
              switch (this.a.e)
              {
              case 1:
              default:
                if ((localList2 == null) || (localList2.size() <= 0))
                  break;
                switch (this.a.e)
                {
                default:
                  QuestionDetailActivity.d(this.a).addAll(localList2);
                  switch (this.a.e)
                  {
                  default:
                  case 3:
                  case 16:
                  }
                case 10:
                case 888:
                case 9:
                case 12:
                }
              case 17:
              case 888:
              case 9:
              case 12:
              case 3:
              case 16:
                for (int i = 0; ; i++)
                {
                  if (i >= localList2.size())
                  {
                    if (QuestionDetailActivity.g(this.a))
                    {
                      QuestionDetailFragment localQuestionDetailFragment2 = new QuestionDetailFragment();
                      Bundle localBundle2 = new Bundle();
                      localBundle2.putSerializable("exercises", null);
                      localQuestionDetailFragment2.setArguments(localBundle2);
                      QuestionDetailActivity.f(this.a).add(localQuestionDetailFragment2);
                      QuestionDetailActivity.d(this.a).add(null);
                    }
                    com.withustudy.koudaizikao.g.j.a("mContentFragments.size=", Integer.valueOf(QuestionDetailActivity.f(this.a).size()));
                    if (QuestionDetailActivity.h(this.a) != null)
                      break label894;
                    QuestionDetailActivity.a(this.a, new ar(this, this.a.getSupportFragmentManager()));
                    QuestionDetailActivity.h(this.a).a(this.a);
                    QuestionDetailActivity.i(this.a).setAdapter(QuestionDetailActivity.h(this.a));
                    ((QuestionDetailFragment)QuestionDetailActivity.f(this.a).get(0)).a((Exercises)QuestionDetailActivity.d(this.a).get(0), this.a.b);
                    return;
                    QuestionDetailActivity.b(this.a).sendEmptyMessageDelayed(1, 100L);
                    QuestionDetailActivity.a(this.a, true);
                    break;
                    Boolean localBoolean2 = Boolean.valueOf(QuestionDetailActivity.a(this.a).isEnd());
                    if ((localBoolean2 == null) || (!localBoolean2.booleanValue()))
                      break;
                    QuestionDetailActivity.a(this.a, true);
                    break;
                    Boolean localBoolean1 = Boolean.valueOf(QuestionDetailActivity.a(this.a).isEnd());
                    if ((localBoolean1 == null) || (!localBoolean1.booleanValue()))
                      break;
                    QuestionDetailActivity.a(this.a, true);
                    break;
                    if (QuestionDetailActivity.c(this.a))
                      break;
                    this.a.v.postDelayed(this.a.w, 500L);
                    QuestionDetailActivity.b(this.a, true);
                    break;
                    if (QuestionDetailActivity.d(this.a).size() + localList2.size() != this.a.h.size())
                      break label288;
                    QuestionDetailActivity.a(this.a, true);
                    break label288;
                    QuestionDetailActivity.a(this.a, ((Exercises)localList2.get(0)).getTotalNum());
                    break label288;
                    QuestionDetailActivity.a(this.a, ((Exercises)localList2.get(0)).getTotalNum());
                    break label288;
                    if ((!this.a.d) || (this.a.r != 0))
                      break label336;
                    QuestionDetailActivity.c(this.a, true);
                    QuestionDetailActivity.e(this.a);
                    break label336;
                  }
                  Exercises localExercises = (Exercises)localList2.get(i);
                  QuestionDetailFragment localQuestionDetailFragment1 = new QuestionDetailFragment();
                  Bundle localBundle1 = new Bundle();
                  localBundle1.putSerializable("exercises", localExercises);
                  localQuestionDetailFragment1.setArguments(localBundle1);
                  QuestionDetailActivity.f(this.a).add(localQuestionDetailFragment1);
                }
                QuestionDetailActivity.h(this.a).notifyDataSetChanged();
                return;
              }
              h.a("解析异常或者题目为0");
              if (this.a.e != 1)
                continue;
              Toast.makeText(this.a.getApplicationContext(), "小袋努力编题中。。。", 0).show();
            }
            while ((this.a.e != 9) || (QuestionDetailActivity.g(this.a)));
            Toast.makeText(this.a.getApplicationContext(), "休息一下，赶快去刷别的题吧!", 0).show();
            return;
            Toast.makeText(this.a.getApplicationContext(), "小袋努力编题中。。。", 0).show();
            return;
            QuestionDetailActivity.j(this.a).b();
            return;
            QuestionDetailActivity.a(this.a, new QuestionDetailActivity.b(this.a, QuestionDetailActivity.k(this.a)));
            return;
            localRspCollectExcerBean = (RspCollectExcerBean)paramMessage.obj;
          }
          while (localRspCollectExcerBean == null);
          if ("OK".equals(localRspCollectExcerBean.getStatus()))
          {
            Toast.makeText(this.a.getApplicationContext(), "收藏成功!", 0).show();
            QuestionDetailActivity.l(this.a).put(Integer.valueOf(this.a.b), Boolean.valueOf(true));
            String str4 = ((Exercises)QuestionDetailActivity.d(this.a).get(this.a.b)).getExerciseId();
            QuestionDetailActivity.a(this.a, str4, "0");
            QuestionDetailActivity.m(this.a).setImageResource(2130837677);
            return;
          }
          Toast.makeText(this.a.getApplicationContext(), "收藏失败!", 0).show();
          return;
          Toast.makeText(this.a.getApplicationContext(), "取消成功!", 0).show();
          QuestionDetailActivity.l(this.a).put(Integer.valueOf(this.a.b), Boolean.valueOf(false));
          String str3 = ((Exercises)QuestionDetailActivity.d(this.a).get(this.a.b)).getExerciseId();
          QuestionDetailActivity.a(this.a, str3, "1");
          QuestionDetailActivity.m(this.a).setImageResource(2130837688);
          return;
          Toast.makeText(this.a.getApplicationContext(), "取消失败!", 0).show();
          return;
          QuestionDetailActivity.a(this.a, new as(this, this.a.getSupportFragmentManager()));
          QuestionDetailActivity.i(this.a).setAdapter(QuestionDetailActivity.h(this.a));
          QuestionDetailActivity.h(this.a).a(this.a);
          this.a.b = 0;
          ((QuestionDetailFragment)QuestionDetailActivity.f(this.a).get(0)).a((Exercises)QuestionDetailActivity.d(this.a).get(0), this.a.b);
          this.a.d = false;
          this.a.p = true;
          QuestionDetailActivity.n(this.a);
          return;
          QuestionDetailActivity.a(this.a, new at(this, this.a.getSupportFragmentManager()));
          QuestionDetailActivity.i(this.a).setAdapter(QuestionDetailActivity.h(this.a));
          QuestionDetailActivity.h(this.a).a(this.a);
          this.a.d = false;
          this.a.b = ((Integer)paramMessage.obj).intValue();
          ((QuestionDetailFragment)QuestionDetailActivity.f(this.a).get(this.a.b)).a((Exercises)QuestionDetailActivity.d(this.a).get(this.a.b), this.a.b);
          QuestionDetailActivity.i(this.a).setCurrentItem(this.a.b);
          this.a.p = true;
          QuestionDetailActivity.n(this.a);
          return;
          QuestionDetailActivity.o(this.a);
          return;
        }
        while (QuestionDetailActivity.p(this.a) == null);
        localList1 = QuestionDetailActivity.p(this.a).getUrls();
      }
      while ((localList1 == null) || (localList1.size() <= 0));
      Urls localUrls = (Urls)localList1.get(0);
      String str1 = localUrls.getUrl_short();
      String str2 = localUrls.getUrl_long();
      h.a("url_short ", str1);
      h.a("url_long ", str2);
      QuestionDetailActivity.a(this.a, new a(this.a, QuestionDetailActivity.i(this.a)));
      QuestionDetailActivity.q(this.a).c("快来口袋自考学本科吧，20大专业全科讲解题目，刷刷题就过关哦~");
      QuestionDetailActivity.q(this.a).a(str2);
      QuestionDetailActivity.q(this.a).d(str1);
      QuestionDetailActivity.q(this.a).b("口袋自考");
      QuestionDetailActivity.q(this.a).b();
      return;
    case 102:
    }
    QuestionDetailActivity.r(this.a);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.aq
 * JD-Core Version:    0.6.0
 */