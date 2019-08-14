package com.withustudy.koudaizikao.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.umeng.a.g;
import com.withustudy.koudaizikao.activity.VideoBoughtDetailActivity;
import com.withustudy.koudaizikao.activity.VideoSaleDetailActivity;
import com.withustudy.koudaizikao.activity.VideoTapePlayActivity;
import com.withustudy.koudaizikao.entity.VideoCourse;
import com.withustudy.koudaizikao.entity.content.VideoAllContent;
import java.util.List;

class y
  implements AdapterView.OnItemClickListener
{
  y(SimuFragment paramSimuFragment)
  {
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Bundle localBundle = new Bundle();
    VideoCourse localVideoCourse = (VideoCourse)SimuFragment.l(this.a).getCourse_list().get(paramInt);
    if (localVideoCourse.getBuy_status() == 0)
    {
      g.b(SimuFragment.n(this.a), "course_all_buy");
      localBundle.putString("class", localVideoCourse.getCourse_id());
      SimuFragment.a(this.a, VideoSaleDetailActivity.class, false, localBundle);
      return;
    }
    if (localVideoCourse.getCategory() == 0)
    {
      localBundle.putSerializable("class", localVideoCourse);
      SimuFragment.a(this.a, VideoBoughtDetailActivity.class, false, localBundle);
      return;
    }
    localBundle.putSerializable("class", localVideoCourse.getCourse_id());
    SimuFragment.a(this.a, VideoTapePlayActivity.class, false, localBundle);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.fragment.y
 * JD-Core Version:    0.6.0
 */