package com.gensee.download;

public enum VodDownLoadStatus
{
  private int nStatus;

  static
  {
    BEGIN = new VodDownLoadStatus("BEGIN", 1, -1);
    DENY = new VodDownLoadStatus("DENY", 2, 0);
    START = new VodDownLoadStatus("START", 3, 1);
    FINISH = new VodDownLoadStatus("FINISH", 4, 2);
    FAILED = new VodDownLoadStatus("FAILED", 5, 3);
    STOP = new VodDownLoadStatus("STOP", 6, 4);
    LICENSE = new VodDownLoadStatus("LICENSE", 7, 12);
    VodDownLoadStatus[] arrayOfVodDownLoadStatus = new VodDownLoadStatus[8];
    arrayOfVodDownLoadStatus[0] = WAIT;
    arrayOfVodDownLoadStatus[1] = BEGIN;
    arrayOfVodDownLoadStatus[2] = DENY;
    arrayOfVodDownLoadStatus[3] = START;
    arrayOfVodDownLoadStatus[4] = FINISH;
    arrayOfVodDownLoadStatus[5] = FAILED;
    arrayOfVodDownLoadStatus[6] = STOP;
    arrayOfVodDownLoadStatus[7] = LICENSE;
    ENUM$VALUES = arrayOfVodDownLoadStatus;
  }

  private VodDownLoadStatus(int arg3)
  {
    int j;
    this.nStatus = j;
  }

  public int getStatus()
  {
    return this.nStatus;
  }

  public String toString()
  {
    return String.valueOf(this.nStatus);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.download.VodDownLoadStatus
 * JD-Core Version:    0.6.0
 */