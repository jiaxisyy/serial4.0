package activity;



import com.hitek.serial.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;

import utils.Constants;

/**
 * A机状态界面
 * Created by zuheng.lv on 2016/4/26.
 */
public class AMachineStatusActivity extends Activity implements View.OnClickListener {


    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    /**这里写UI更新函数*/
                    switch (msg.what){
                        case 1:
                            stataus_btn_valve1.setSelected(msg.getData().getBoolean("y2"));
                            stataus_btn_valve2.setSelected(msg.getData().getBoolean("y3"));
                            stataus_btn_valve3.setSelected(msg.getData().getBoolean("y4"));
                            stataus_btn_valve4.setSelected(msg.getData().getBoolean("y5"));
                            stataus_btn_valve5.setSelected(msg.getData().getBoolean("y6"));
                            stataus_btn_valve6.setSelected(msg.getData().getBoolean("y7"));
                            stataus_btn_valve7.setSelected(msg.getData().getBoolean("y10"));
                            stataus_btn_valve8.setSelected(msg.getData().getBoolean("y11"));
                            stataus_btn_valve9.setSelected(msg.getData().getBoolean("y12"));
                            stataus_btn_valve10.setSelected(msg.getData().getBoolean("y13"));
                            stataus_btn_valve11.setSelected(msg.getData().getBoolean("y0"));
                            stataus_btn_valve12.setSelected(msg.getData().getBoolean("y1"));
                            break;
                    }

                    break;
            }
        }
    };
    private Button status_btn_back;
    private Button stataus_btn_valve1,stataus_btn_valve2,stataus_btn_valve3,stataus_btn_valve4,stataus_btn_valve5,stataus_btn_valve6;
    private Button stataus_btn_valve7,stataus_btn_valve8,stataus_btn_valve9,stataus_btn_valve10,stataus_btn_valve11,stataus_btn_valve12;
    boolean flag =true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.amachinestatus_layout);
        initView();
        initData();
        setData();
    }

    /**控件初始化*/
    public void initView(){
        stataus_btn_valve1 = (Button) findViewById(R.id.stataus_btn_valve1);
        stataus_btn_valve2 = (Button) findViewById(R.id.stataus_btn_valve2);
        stataus_btn_valve3 = (Button) findViewById(R.id.stataus_btn_valve3);
        stataus_btn_valve4 = (Button) findViewById(R.id.stataus_btn_valve4);
        stataus_btn_valve5 = (Button) findViewById(R.id.stataus_btn_valve5);
        stataus_btn_valve6 = (Button) findViewById(R.id.stataus_btn_valve6);
        stataus_btn_valve7 = (Button) findViewById(R.id.stataus_btn_valve7);
        stataus_btn_valve8 = (Button) findViewById(R.id.stataus_btn_valve8);
        stataus_btn_valve9 = (Button) findViewById(R.id.stataus_btn_valve9);
        stataus_btn_valve10 = (Button) findViewById(R.id.stataus_btn_valve10);
        stataus_btn_valve11 = (Button) findViewById(R.id.stataus_btn_valve11);
        stataus_btn_valve12 = (Button) findViewById(R.id.stataus_btn_valve12);
        status_btn_back = (Button) findViewById(R.id.status_btn_back);
        status_btn_back.setOnClickListener(this);

    }
    /**数据初始化*/
    public void initData(){


    }

    /**数据获取*/
    public void getData(){


    }
    /**数据跟新*/
    public void setData(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                /**这里写数据获取与数据处理函数*/


                while (flag) {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //A������
                    byte[] y2 = MyApplication.getInstance().mdbusreadbyte(Constants.Define.OP_BIT_Y, 2, 1);
                    //B������
                    byte[] y3 = MyApplication.getInstance().mdbusreadbyte(Constants.Define.OP_BIT_Y, 3, 1);
                    //A������
                    byte[] y4 = MyApplication.getInstance().mdbusreadbyte(Constants.Define.OP_BIT_Y, 4, 1);
                    //B������
                    byte[] y5 = MyApplication.getInstance().mdbusreadbyte(Constants.Define.OP_BIT_Y, 5, 1);
                    //A������
                    byte[] y6 = MyApplication.getInstance().mdbusreadbyte(Constants.Define.OP_BIT_Y, 6, 1);
                    //B������
                    byte[] y7 = MyApplication.getInstance().mdbusreadbyte(Constants.Define.OP_BIT_Y, 7, 1);
                    //A��ѹ��
                    byte[] y10 = MyApplication.getInstance().mdbusreadbyte(Constants.Define.OP_BIT_Y, 8, 1);
                    //B��ѹ��
                    byte[] y11 = MyApplication.getInstance().mdbusreadbyte(Constants.Define.OP_BIT_Y, 9, 1);
                    //A��ϴ��
                    byte[] y12 = MyApplication.getInstance().mdbusreadbyte(Constants.Define.OP_BIT_Y, 10, 1);
                    //B��ϴ��
                    byte[] y13 = MyApplication.getInstance().mdbusreadbyte(Constants.Define.OP_BIT_Y, 11, 1);
                    //��ѹ��
                    byte[] y0 = MyApplication.getInstance().mdbusreadbyte(Constants.Define.OP_BIT_Y, 0, 1);
                    //��ɻ�
                    byte[] y1 = MyApplication.getInstance().mdbusreadbyte(Constants.Define.OP_BIT_Y, 1, 1);

                    Bundle bundle = new Bundle();
                    if(y0[0]==0){
                        bundle.putBoolean("y0", false);
                    }else if(y0[0]==1){
                        bundle.putBoolean("y0", true);
                    }
                    if(y1[0]==0){
                        bundle.putBoolean("y1", false);
                    }else if(y1[0]==1){
                        bundle.putBoolean("y1", true);
                    }
                    if(y2[0]==0){
                        bundle.putBoolean("y2", false);
                    }else if(y2[0]==1){
                        bundle.putBoolean("y2", true);
                    }
                    if(y3[0]==0){
                        bundle.putBoolean("y3", false);
                    }else if(y3[0]==1){
                        bundle.putBoolean("y3", true);
                    }
                    if(y4[0]==0){
                        bundle.putBoolean("y4", false);
                    }else if(y4[0]==1){
                        bundle.putBoolean("y4", true);
                    }
                    if(y5[0]==0){
                        bundle.putBoolean("y5", false);
                    }else if(y5[0]==1){
                        bundle.putBoolean("y5", true);
                    }
                    if(y6[0]==0){
                        bundle.putBoolean("y6", false);
                    }else if(y6[0]==1){
                        bundle.putBoolean("y6", true);
                    }
                    if(y7[0]==0){
                        bundle.putBoolean("y7", false);
                    }else if(y7[0]==1){
                        bundle.putBoolean("y7", true);
                    }
                    if(y10[0]==0){
                        bundle.putBoolean("y10", false);
                    }else if(y10[0]==1){
                        bundle.putBoolean("y10", true);
                    }
                    if(y11[0]==0){
                        bundle.putBoolean("y11", false);
                    }else if(y11[0]==1){
                        bundle.putBoolean("y11", true);
                    }
                    if(y12[0]==0){
                        bundle.putBoolean("y12", false);
                    }else if(y12[0]==1){
                        bundle.putBoolean("y12", true);
                    }
                    if(y13[0]==0){
                        bundle.putBoolean("y13", false);
                    }else if(y13[0]==1){
                        bundle.putBoolean("y13", true);
                    }
                    Message msg = new Message();
                    msg.setData(bundle);
                    msg.what = 1;
                    handler.sendMessage(msg);
                }
            }
        }).start();
    }


    /**�����������*/
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.status_btn_back:
                Intent intent = new Intent(AMachineStatusActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        flag = false;
    }
}
