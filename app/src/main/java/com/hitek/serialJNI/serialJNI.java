package com.hitek.serialJNI;

public class serialJNI {
	static {
        System.loadLibrary("serialJNI");
    }
	public native  boolean init();
	public native  int mainloop();
	public native  byte[]  mdbusreadbyte(int type,int stadr,int len);			// ��ȡλԪ��,eg:X,Y,M,SM,
	public native  int mdbuswritebyte(int type,byte buf[],int stadr,int len);	// д��λԪ��,eg:X,Y,M,SM,
	
	public native  short[] mdbusreadword(int type,int stadr,int len);			// ������Ԫ��,eg:D,R	
	public native  int mdbuswriteword(int type,short buf[],int stadr,int len);	// д����Ԫ��,eg:D,R
	
	public native  int[] mdbusreaddword(int type, int stadr, int len);			//  ��˫��Ԫ��,eg:D,R
	public native  int mdbuswritedword(int type, int buf[], int stadr, int len);//	д˫��Ԫ��,eg:D,R
	
	public native  float[] mdbusreadreal(int type, int stadr, int len);			//	��������Ԫ��,eg:D,R
	public native  int mdbuswritereal(int type, float buf[],int stadr, int len);//  д�븡����Ԫ��,eg:D,R
	
	public native  void destory();
}
