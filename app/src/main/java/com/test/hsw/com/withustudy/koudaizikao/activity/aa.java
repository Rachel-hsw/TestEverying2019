package com.withustudy.koudaizikao.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.umeng.a.g;
import com.withustudy.koudaizikao.entity.VideoCourse;
import com.withustudy.koudaizikao.entity.content.VideoAllContent;
import java.util.List;

class aa
  implements AdapterView.OnItemClickListener
{
  aa(IntellWecomeActivity paramIntellWecomeActivity)
  {
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Bundle localBundle = new Bundle();
    VideoCourse localVideoCourse = (VideoCourse)IntellWecomeActivity.access$0(this.a).getCourse_list().get(paramInt);
    if (localVideoCourse.getBuy_status() == 0)
    {
      g.b(IntellWecomeActivity.access$26(this.a), "course_all_buy");
      localBundle.putString("class", localVideoCourse.getCourse_id());
      this.a.startNewActivity(VideoSaleDetailActivity.class, false, localBundle);
      return;
    }
    if (localVideoCourse.getCategory() == 0)
    {
      localBundle.putSerializable("class", localVideoCourse);
      this.a.startNewActivity(VideoBoughtDetailActivity.class, false, localBundle);
      return;
    }
    localBundle.putSerializable("class", localVideoCourse.getCourse_id());
    this.a.startNewActivity(VideoTapePlayActivity.class, false, localBundle);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.aa
 * JD-Core Version:    0.6.0
 */