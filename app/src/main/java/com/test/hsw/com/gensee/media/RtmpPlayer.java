package com.gensee.media;

import com.gensee.parse.AnnotaionParse;
import com.gensee.parse.RtmpAnnotationParse;
import com.gensee.parse.RtmpAnnotationParse.IAnnotationDraw;
import com.gensee.pdu.AbsAnno;

public class RtmpPlayer extends AbsPlayer
  implements RtmpAnnotationParse.IAnnotationDraw
{
  public RtmpPlayer()
  {
    setPlayerType(0);
  }

  public void annoDraw(AbsAnno paramAbsAnno)
  {
    drawAnno(paramAbsAnno);
  }

  protected void renderAnno(String paramString)
  {
    if (this.mPage == null)
      return;
    if (this.parse == null)
      this.parse = new RtmpAnnotationParse(this);
    this.parse.parseAnnoXml(paramString);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.media.RtmpPlayer
 * JD-Core Version:    0.6.0
 */