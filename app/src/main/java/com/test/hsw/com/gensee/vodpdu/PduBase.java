package com.gensee.vodpdu;

public class PduBase
{
  public static final byte OPERATE_CANCEL_TOPMOST = 17;
  public static final byte OPERATE_CLEAR_HANDUP = 19;
  public static final byte OPERATE_CLOSE_AUDIO = 2;
  public static final byte OPERATE_CLOSE_VIDEO = 4;
  public static final byte OPERATE_EJECT = 10;
  public static final byte OPERATE_ENABLE_CHAT = 7;
  public static final byte OPERATE_HANDUP = 18;
  public static final byte OPERATE_MUTE_CHAT = 6;
  public static final byte OPERATE_NOTIFY_UPGRADE = 8;
  public static final byte OPERATE_OPEN_AUDIO = 1;
  public static final byte OPERATE_OPEN_VIDEO = 3;
  public static final byte OPERATE_OPEN_VIDEO_RESP = 5;
  public static final byte OPERATE_PRI_DENY = 12;
  public static final byte OPERATE_PRI_GRANT = 11;
  public static final byte OPERATE_SET_CHATER = 9;
  public static final byte OPERATE_SET_TELECTRL = 15;
  public static final byte OPERATE_SET_TOPMOST = 16;
  public static final byte OPERATE_WEBAUDIO_CANCEL = 14;
  public static final byte OPERATE_WEBAUDIO_INVITE = 13;
  public static final short PDU_TYPE_ANNO_BEGIN = 2048;
  public static final short PDU_TYPE_ANNO_CIRCLE = 2053;
  public static final short PDU_TYPE_ANNO_CLEANER = 2049;
  public static final short PDU_TYPE_ANNO_FREEPEN = 2051;
  public static final short PDU_TYPE_ANNO_LINE = 2055;
  public static final short PDU_TYPE_ANNO_LINE_EX = 2056;
  public static final short PDU_TYPE_ANNO_POINTER = 2050;
  public static final short PDU_TYPE_ANNO_POINTER_EX = 2057;
  public static final short PDU_TYPE_ANNO_RECT = 2054;
  public static final short PDU_TYPE_ANNO_TEXT = 2052;
  public static final byte PDU_TYPE_AV_ACTIVE_NOTIFY = 10;
  public static final byte PDU_TYPE_AV_ACTIVE_NOTIFY_APPSVR = 14;
  public static final byte PDU_TYPE_AV_ACTIVE_RQST = 15;
  public static final byte PDU_TYPE_AV_BEGIN = 5;
  public static final byte PDU_TYPE_AV_BROAD_NOTIFY = 8;
  public static final byte PDU_TYPE_AV_CHANN_LOSTADD = 11;
  public static final byte PDU_TYPE_AV_FORCE_KEY_FRAME = 12;
  public static final byte PDU_TYPE_AV_RECORD_NOTIFY = 9;
  public static final byte PDU_TYPE_AV_VIDEO_PARAM_FORCE = 13;
  public static final short PDU_TYPE_BC_BEGIN = 2560;
  public static final short PDU_TYPE_BC_LOTTERY = 2566;
  public static final byte PDU_TYPE_MP3_DATA_NOTIFY = 7;
  public static final short PDU_TYPE_PD_BEGIN = 512;
  public static final short PDU_TYPE_PD_COMMAND = 515;
  public static final short PDU_TYPE_PD_DOC = 513;
  public static final short PDU_TYPE_PD_PAGE = 514;
  public static final short PDU_TYPE_QA_ANSWER = 1282;
  public static final short PDU_TYPE_QA_BEGIN = 1280;
  public static final short PDU_TYPE_QA_COMMAND = 1283;
  public static final short PDU_TYPE_QA_PUBLISH = 1285;
  public static final short PDU_TYPE_QA_QUESTION = 1281;
  public static final short PDU_TYPE_ROOM_AV_CTRL = 4097;
  private static final short PDU_TYPE_ROOM_BEGIN = 4096;
  public static final short PDU_TYPE_ROOM_ROLLCALL_RESULT = 4098;
  public static final byte PDU_TYPE_SPEAKER_ACTIVE_NOTIFY = 6;
  public static final byte PD_CMD_ACTIVE = 2;
  public static final byte PD_CMD_CLOSED = 1;
  public static final byte QA_CMD_CANCELPUBLISH = 1;
  public static final byte QA_CMD_DISPATCH = 2;
  public static final byte QA_CMD_HIGHLIGHT = 5;
  public static final byte QA_CMD_TAG_AUDIO = 3;
  public static final byte QA_CMD_TAG_USER = 4;
  protected static final float TOUCH_WIDTH = 8.0F;
  private int type;
  private short version = 1;

  public byte[] getByteData()
  {
    return null;
  }

  public int getType()
  {
    return this.type;
  }

  public short getVersion()
  {
    return this.version;
  }

  public void setType(int paramInt)
  {
    this.type = paramInt;
  }

  public void setVersion(short paramShort)
  {
    this.version = paramShort;
  }

  public String toString()
  {
    return "PduBase [type=" + this.type + "]";
  }

  public static abstract interface AnnoType
  {
    public static final int ANNO_CIRCLE = 5;
    public static final int ANNO_CLEANER = 3;
    public static final int ANNO_FREEPEN = 2;
    public static final int ANNO_LINE = 7;
    public static final int ANNO_LINE_EX = 8;
    public static final int ANNO_NULL = 0;
    public static final int ANNO_POINTER = 1;
    public static final int ANNO_POINTER_EX = 9;
    public static final int ANNO_RECT = 6;
    public static final int ANNO_SELECTOR = 127;
    public static final int ANNO_TEXT = 4;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.vodpdu.PduBase
 * JD-Core Version:    0.6.0
 */