package com.kitadai31;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MonakeyClearActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(linearLayout);

        //文字表示
        TextView text = new TextView(this);
        text.setText("MonaKey Remover 1.0\n削除ボタンをタップするとMonaKey(鍵)が削除されます。\n\n【警告】\n鍵の取得を同一IPアドレスで短期間に複数回繰り返すと、「不正取得を検知しました」規制でしばらく鍵が取得できなくなります。\n鍵を削除した後は、問題となった携帯回線での書き込み、問題となった板への書き込みなどに注意しましょう。\nまた、荒らし行為やそれに類する行為には絶対に使用しないでください。\n\n以上を理解した上で削除ボタンをタップしてください。");
        linearLayout.addView(text);

        //削除ボタン
        Button button = new Button(this);
        button.setText("削除");
        TextView text2 = new TextView(this); //ボタンを押したら表示されるテキストを生成しておく
        text2.setText("削除しました。");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //「削除しました」メッセージを出すようにすると削除ボタン二度押しでクラッシュするのでボタン無効化
                button.setEnabled(false);
                //MonaKey削除
                SharedPreferences pref = getSharedPreferences("2chapi", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.remove("2chapi_monakey");
                editor.commit();
                //削除メッセージ表示
                linearLayout.addView(text2);
            }
        });
        button.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        linearLayout.addView(button);
    }
}