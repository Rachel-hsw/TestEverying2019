package com.withustudy.koudaizikao.fragment;

import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.f;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.umeng.a.g;
import com.withustudy.koudaizikao.a.a;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.activity.MainActivity;
import com.withustudy.koudaizikao.activity.VideoBoughtDetailActivity;
import com.withustudy.koudaizikao.activity.VideoSaleDetailActivity;
import com.withustudy.koudaizikao.activity.VideoTapePlayActivity;
import com.withustudy.koudaizikao.b.af;
import com.withustudy.koudaizikao.base.AbsBaseFragment;
import com.withustudy.koudaizikao.custom.LoadingView;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.New_course_ids;
import com.withustudy.koudaizikao.entity.VideoCourse;
import com.withustudy.koudaizikao.entity.content.VideoAllContent;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class VideoAllFragment extends AbsBaseFragment
{
  public static b a;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 10;
  public static final int g = 11;
  private static List<New_course_ids> r;
  List<New_course_ids> h = new ArrayList();
  private PullToRefreshListView i;
  private af j;
  private List<VideoCourse> k;
  private LoadingView l;
  private boolean m = false;
  private boolean n = false;
  private a o;
  private int p = 1;
  private final int q = 20;

  private void a(MainActivity paramMainActivity)
  {
    VideoMainFragment localVideoMainFragment = (VideoMainFragment)getParentFragment();
    if ((this.h != null) && (this.h.size() > 0))
    {
      Iterator localIterator = this.h.iterator();
      while (true)
      {
        if (!localIterator.hasNext())
          return;
        String str = ((New_course_ids)localIterator.next()).getCourse_id();
        Boolean localBoolean = (Boolean)paramMainActivity.newCourseIsClick.get(str);
        if ((localBoolean != null) && (!localBoolean.booleanValue()))
        {
          localVideoMainFragment.a.setVisibility(0);
          return;
        }
        localVideoMainFragment.a.setVisibility(8);
      }
    }
    localVideoMainFragment.a.setVisibility(8);
  }

  private void e()
  {
    this.m = true;
    this.p = 1;
    a locala = c.b().ay();
    String[] arrayOfString = new String[5];
    arrayOfString[0] = this.E.s();
    arrayOfString[1] = String.valueOf(this.p);
    arrayOfString[2] = String.valueOf(20);
    arrayOfString[3] = this.E.i();
    arrayOfString[4] = "0";
    locala.a(this, arrayOfString, 10, this.y);
  }

  private void f()
  {
    this.n = true;
    this.p = (1 + this.p);
    a locala = c.b().ay();
    String[] arrayOfString = new String[5];
    arrayOfString[0] = this.E.s();
    arrayOfString[1] = String.valueOf(this.p);
    arrayOfString[2] = String.valueOf(20);
    arrayOfString[3] = this.E.i();
    arrayOfString[4] = "0";
    locala.a(this, arrayOfString, 11, this.y);
  }

  public View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903168, null);
  }

  public void a()
  {
    this.k = new ArrayList();
    this.o = new a();
    a = new b(this);
  }

  public void a(View paramView)
  {
    this.i = ((PullToRefreshListView)paramView.findViewById(2131297109));
    this.l = ((LoadingView)paramView.findViewById(2131297110));
  }

  public void a(List<New_course_ids> paramList)
  {
    r = paramList;
    this.h.clear();
    if (paramList == null);
    while (true)
    {
      return;
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        New_course_ids localNew_course_ids = (New_course_ids)localIterator.next();
        if (localNew_course_ids.getIs_chuanjiang() != 1)
          continue;
        this.h.add(localNew_course_ids);
      }
    }
  }

  public void b()
  {
    com.withustudy.koudaizikao.g.n.a(true, this.i, this.y);
    e();
  }

  public void c()
  {
    this.i.setOnItemClickListener(this.o);
    this.i.setOnRefreshListener(this.o);
  }

  public void onError(String paramString1, String paramString2, int paramInt)
  {
    super.onError(paramString1, paramString2, paramInt);
    this.l.setVisibility(8);
    switch (paramInt)
    {
    default:
      return;
    case 10:
      this.m = false;
      this.i.f();
      return;
    case 11:
    }
    this.n = false;
    this.i.f();
  }

  public void onResume()
  {
    super.onResume();
    if (this.j != null)
    {
      this.j.a(r);
      this.j.notifyDataSetChanged();
    }
    a((MainActivity)getActivity());
  }

  public void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt)
  {
    super.onSuccess(paramString1, paramMap, paramString2, paramInt);
    this.l.setVisibility(8);
    switch (paramInt)
    {
    default:
      return;
    case 10:
      this.m = false;
      if (paramString1 != null);
      while (true)
      {
        try
        {
          VideoAllContent localVideoAllContent2 = (VideoAllContent)c.a().fromJson(paramString1, VideoAllContent.class);
          if ((localVideoAllContent2 == null) || (!localVideoAllContent2.getResult().equals("true")) || (localVideoAllContent2.getCourse_list() == null))
            continue;
          a.sendMessage(a.obtainMessage(1, localVideoAllContent2.getCourse_list()));
          this.i.f();
          return;
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          Toast.makeText(this.y, "服务器未响应，请稍后再试", 0).show();
          continue;
        }
        Toast.makeText(this.y, "服务器未响应，请稍后再试", 0).show();
      }
    case 11:
    }
    this.n = false;
    if (paramString1 != null);
    while (true)
    {
      try
      {
        VideoAllContent localVideoAllContent1 = (VideoAllContent)c.a().fromJson(paramString1, VideoAllContent.class);
        if ((localVideoAllContent1 == null) || (!localVideoAllContent1.getResult().equals("true")) || (localVideoAllContent1.getCourse_list() == null))
          continue;
        a.sendMessage(a.obtainMessage(2, localVideoAllContent1.getCourse_list()));
        this.i.f();
        return;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        Toast.makeText(this.y, "服务器未响应，请稍后再试", 0).show();
        continue;
      }
      Toast.makeText(this.y, "服务器未响应，请稍后再试", 0).show();
    }
  }

  class a
    implements AdapterView.OnItemClickListener, PullToRefreshBase.f<ListView>
  {
    a()
    {
    }

    public void a(PullToRefreshBase<ListView> paramPullToRefreshBase)
    {
      if (!VideoAllFragment.f(VideoAllFragment.this))
        VideoAllFragment.e(VideoAllFragment.this);
    }

    public void b(PullToRefreshBase<ListView> paramPullToRefreshBase)
    {
      if (!VideoAllFragment.g(VideoAllFragment.this))
        VideoAllFragment.h(VideoAllFragment.this);
    }

    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      Bundle localBundle = new Bundle();
      VideoCourse localVideoCourse = (VideoCourse)VideoAllFragment.a(VideoAllFragment.this).get(paramInt - 1);
      if (localVideoCourse.getBuy_status() == 0)
      {
        g.b(VideoAllFragment.b(VideoAllFragment.this), "course_all_buy");
        localBundle.putString("class", localVideoCourse.getCourse_id());
        VideoAllFragment.a(VideoAllFragment.this, VideoSaleDetailActivity.class, false, localBundle);
      }
      while (true)
      {
        MainActivity localMainActivity = (MainActivity)VideoAllFragment.this.getActivity();
        String str = localVideoCourse.getCourse_id();
        localMainActivity.newCourseIsClick.put(str, Boolean.valueOf(true));
        VideoAllFragment.a(VideoAllFragment.this, localMainActivity);
        return;
        if (localVideoCourse.getCategory() == 0)
        {
          localBundle.putSerializable("class", localVideoCourse);
          VideoAllFragment.a(VideoAllFragment.this, VideoBoughtDetailActivity.class, false, localBundle);
          continue;
        }
        localBundle.putSerializable("class", localVideoCourse.getCourse_id());
        VideoAllFragment.a(VideoAllFragment.this, VideoTapePlayActivity.class, false, localBundle);
      }
    }
  }

  public static class b extends com.withustudy.koudaizikao.base.n<VideoAllFragment>
  {
    public b(VideoAllFragment paramVideoAllFragment)
    {
      super();
    }

    protected void a(VideoAllFragment paramVideoAllFragment, Message paramMessage)
    {
      try
      {
        switch (paramMessage.what)
        {
        case 1:
          VideoAllFragment.a(paramVideoAllFragment).clear();
          VideoAllFragment.a(paramVideoAllFragment).addAll((List)paramMessage.obj);
          VideoAllFragment.a(paramVideoAllFragment, new af(VideoAllFragment.b(paramVideoAllFragment), VideoAllFragment.a(paramVideoAllFragment), VideoAllFragment.d()));
          VideoAllFragment.c(paramVideoAllFragment).setAdapter(VideoAllFragment.d(paramVideoAllFragment));
          return;
        case 2:
          VideoAllFragment.a(paramVideoAllFragment).addAll((List)paramMessage.obj);
          VideoAllFragment.d(paramVideoAllFragment).notifyDataSetChanged();
          ((ListView)VideoAllFragment.c(paramVideoAllFragment).getRefreshableView()).setSelection(VideoAllFragment.c(paramVideoAllFragment).getBottom());
          return;
        case 3:
          VideoAllFragment.e(paramVideoAllFragment);
          return;
        case 4:
          String str = (String)paramMessage.obj;
          for (int i = 0; i < VideoAllFragment.a(paramVideoAllFragment).size(); i++)
          {
            if (!((VideoCourse)VideoAllFragment.a(paramVideoAllFragment).get(i)).getCourse_id().equals(str))
              continue;
            ((VideoCourse)VideoAllFragment.a(paramVideoAllFragment).get(i)).setBuy_status(1);
            VideoAllFragment.d(paramVideoAllFragment).notifyDataSetChanged();
            return;
          }
        }
        return;
      }
      catch (Exception localException)
      {
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.fragment.VideoAllFragment
 * JD-Core Version:    0.6.0
 */