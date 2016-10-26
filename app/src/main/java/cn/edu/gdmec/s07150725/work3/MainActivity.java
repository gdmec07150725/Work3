package cn.edu.gdmec.s07150725.work3;

import android.app.Activity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.TextView;

public class MainActivity extends Activity {



    private TextView tView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            tView=new TextView(this);
            tView.setText("请单击按键或者屏幕");
            setContentView(tView);

    }
        /**按键按下时触发的事件*/
        public boolean onKeyDown(int keyCode,KeyEvent event){
            switch (keyCode){
                case KeyEvent.KEYCODE_HOME:
                    SetMessage("按下:Hom键");
                     break;
                case KeyEvent.KEYCODE_MENU:
                    SetMessage("按下:菜单键");
                   return true;
                case KeyEvent.KEYCODE_BACK:
                    SetMessage("按下:回退键");
                    break;
                case KeyEvent.KEYCODE_VOLUME_UP:
                    SetMessage("按下:声音加大键");
                    event.startTracking();
                  return  true;
                case KeyEvent.KEYCODE_VOLUME_DOWN:
                    SetMessage("按下:声音减少键");
                    event.startTracking();

                      return true;

                default:
                    SetMessage("按下的键码是"+keyCode);
                    break;
            }
            return super.onKeyDown(keyCode,event);

        }
        /**按键弹起时所触发的事件*/
        public boolean onKeyUp(int keyCode,KeyEvent event){
            switch (keyCode){
 case KeyEvent.KEYCODE_HOME:
                    SetMessage("放开:Home键");
                    break;
                case KeyEvent.KEYCODE_MENU:
                    SetMessage("放开:菜单键");
                    return true;
                case KeyEvent.KEYCODE_BACK:
                    SetMessage("放开:回退键");
                    break;
                case KeyEvent.KEYCODE_VOLUME_UP:
                    SetMessage("放开:声音加大键");
                    break;
                case KeyEvent.KEYCODE_VOLUME_DOWN:
                    SetMessage("放开:声音减少键");
                   break;


                default:
                    SetMessage("放开的键码是"+keyCode);
                 break;


            }
        return super.onKeyUp(keyCode,event);

    }
        /**长按键事件*/
        public boolean onKeyLongPress(int keyCode,KeyEvent event) {
            SetMessage("长时间按键");
        return  super.onKeyLongPress(keyCode,event);

    }
        /**按屏事件*/
        public boolean onTouchEvent(MotionEvent event){
            int action=event.getAction();
            if(action==MotionEvent.ACTION_CANCEL||action==MotionEvent.ACTION_DOWN||action==MotionEvent.ACTION_MOVE){
                return false;
            }
            //得到的触点位置
            String x=String.valueOf(event.getX());
            String y=String.valueOf(event.getY());
            SetMessage("触点坐标:("+x+","+y +")");
            return super.onTouchEvent(event);
        }

        @Override
        public void onBackPressed() {
            super.onBackPressed();
            SetMessage("按下返回键了");
        }
        /**显示触发事件的信息*/
        public void SetMessage(String str){
            String oldStr=tView.getText().toString();
            String newStr=oldStr+"\n"+str;
            tView.setText(newStr);
        }


}
