package com.withustudy.koudaizikao.activity;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.withustudy.koudaizikao.b.i;
import com.withustudy.koudaizikao.b.i.b;
import com.withustudy.koudaizikao.custom.a.a;
import com.withustudy.koudaizikao.custom.swipyrefresh.SwipyRefreshLayout;
import com.withustudy.koudaizikao.entity.RspQuestionComment;
import com.withustudy.koudaizikao.entity.UrlShortBean;
import com.withustudy.koudaizikao.entity.Urls;
import com.withustudy.koudaizikao.g.h;
import java.util.List;

class ba extends Handler
{
  ba(QuestionMoreComentActivity paramQuestionMoreComentActivity)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    try
    {
      switch (paramMessage.what)
      {
      case 0:
        QuestionMoreComentActivity.a(this.a).setRefreshing(false);
        List localList3 = QuestionMoreComentActivity.b(this.a).getComment();
        if ((localList3 != null) && (localList3.size() > 0))
        {
          QuestionMoreComentActivity.c(this.a).clear();
          QuestionMoreComentActivity.c(this.a).addAll(localList3);
          h.a("刷新数据 ExcerciseCommentAdapter size=" + QuestionMoreComentActivity.c(this.a).size());
          if (QuestionMoreComentActivity.d(this.a) == null)
          {
            QuestionMoreComentActivity.a(this.a, new i(this.a.getApplicationContext(), QuestionMoreComentActivity.c(this.a), this));
            QuestionMoreComentActivity.e(this.a).setAdapter(QuestionMoreComentActivity.d(this.a));
            return;
          }
          QuestionMoreComentActivity.d(this.a).notifyDataSetChanged();
          return;
        }
      case 1:
        QuestionMoreComentActivity.e(this.a).f();
        List localList2 = QuestionMoreComentActivity.b(this.a).getComment();
        if ((localList2 != null) && (localList2.size() > 0))
        {
          QuestionMoreComentActivity.c(this.a).addAll(localList2);
          h.a("加载更多 ExcerciseCommentAdapter size=" + QuestionMoreComentActivity.c(this.a).size());
          if (QuestionMoreComentActivity.d(this.a) == null)
          {
            QuestionMoreComentActivity.a(this.a, new i(this.a.getApplicationContext(), QuestionMoreComentActivity.c(this.a), this));
            QuestionMoreComentActivity.e(this.a).setAdapter(QuestionMoreComentActivity.d(this.a));
          }
        }
        while (true)
        {
          QuestionMoreComentActivity.a(this.a, false);
          return;
          QuestionMoreComentActivity.d(this.a).notifyDataSetChanged();
          continue;
          Toast.makeText(this.a.getApplicationContext(), "没有更多评论了!", 0).show();
        }
      case 3:
        try
        {
          QuestionMoreComentActivity.f(this.a).setText("");
          QuestionMoreComentActivity.g(this.a).hideSoftInputFromWindow(this.a.getCurrentFocus().getWindowToken(), 2);
          Toast.makeText(this.a.getApplicationContext(), "评论成功!", 0).show();
          QuestionMoreComentActivity.h(this.a);
          return;
        }
        catch (Exception localException2)
        {
          return;
        }
      case 4:
        Toast.makeText(this.a.getApplicationContext(), "评论失败!", 0).show();
        return;
      case 7:
        QuestionMoreComentActivity.g(this.a).toggleSoftInput(0, 2);
        QuestionMoreComentActivity.a(this.a, (i.b)paramMessage.obj);
        return;
      case 101:
        if (QuestionMoreComentActivity.i(this.a) != null)
        {
          List localList1 = QuestionMoreComentActivity.i(this.a).getUrls();
          if ((localList1 != null) && (localList1.size() > 0))
          {
            Urls localUrls = (Urls)localList1.get(0);
            String str1 = localUrls.getUrl_short();
            String str2 = localUrls.getUrl_long();
            h.a("url_short ", str1);
            h.a("url_long ", str2);
            QuestionMoreComentActivity.a(this.a, new a(this.a, QuestionMoreComentActivity.j(this.a)));
            QuestionMoreComentActivity.k(this.a).c("快来口袋自考学本科吧，20大专业全科讲解题目，刷刷题就过关哦~");
            QuestionMoreComentActivity.k(this.a).a(str2);
            QuestionMoreComentActivity.k(this.a).d(str1);
            QuestionMoreComentActivity.k(this.a).b("口袋自考");
            QuestionMoreComentActivity.k(this.a).b();
          }
        }
      }
      return;
    }
    catch (Exception localException1)
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.ba
 * JD-Core Version:    0.6.0
 */