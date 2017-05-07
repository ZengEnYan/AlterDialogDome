package com.alterdialogdome;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*确定/取消*/
    public void alterDialogOne(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        /*设置标题*/
        builder.setTitle("假期调查");
        /*设置内容*/
        builder.setMessage("假期你学习了吗?");
        /*也可以设置图标*/
        builder.setIcon(R.drawable.studay);
        /*设置按钮  消极  没学习*/
        builder.setNegativeButton("就玩了,没有学", new DialogInterface.OnClickListener() {
            /*注意导包别倒错  DialogInterface;下的 */
            @Override
            public void onClick(DialogInterface dialog, int which) {
                /*点击按钮 让dialog消失*/
                dialog.dismiss();
                //成功后的吐丝
                Toast.makeText(MainActivity.this, "假期就玩了,哪有心情学习啊!.", Toast.LENGTH_SHORT).show();
            }
        });
        /*设置按钮 中性的 学了,没多大收获*/
        builder.setNeutralButton("学了,但没啥收获", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                /*点击按钮 让dialog消失*/
                dialog.dismiss();
                //成功后的吐丝
                Toast.makeText(MainActivity.this, "学了,但就那样,没太大收获.", Toast.LENGTH_SHORT).show();
            }
        });
        /*设置按钮 积极  学习了 感觉很不错*/
        builder.setPositiveButton("学习了,感觉很不错", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                /*点击按钮 让dialog消失*/
                dialog.dismiss();
                //成功后的吐丝
                Toast.makeText(MainActivity.this, "学了,感觉收获很不错.颇丰", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

    /*单选框*/
    public void alterDialogTwo(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("你喜欢学习哪一个科目?");
        /*也可以设置图标*/
        builder.setIcon(R.drawable.studay);
        /**
         * items    单选选项 String[]
         * checked  默认选中的选项 int
         */

        final String[] items = new String[]{"Android", "IOS", "H5"};

        builder.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //成功后的吐丝
                Toast.makeText(MainActivity.this, items[which], Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        builder.show();
    }

    /*多选框*/
    public void alterDialogThree(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("你喜欢学习哪些个科目?");
        /*也可以设置图标*/
        builder.setIcon(R.drawable.studay);
        final String[] items = new String[]{"Android", "IOS", "H5"};
        /**
         * 设置多选框,指定内容 指定默认是否选中
         */
        builder.setMultiChoiceItems(items, new boolean[]{true, false, false}, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                //成功后的吐丝
                Toast.makeText(MainActivity.this, items[which], Toast.LENGTH_SHORT).show();
            }
        });
        /*设置两个按钮提交   确定/取消*/
        builder.setNeutralButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }
}
