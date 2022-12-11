package com.kitadai31;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/*Ver 1.3*/
public class MonakeyClearActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(linearLayout);

        //文字表示
        TextView text = new TextView(this);
        text.setText("MonakeyClearActivity 1.3\n削除ボタンをタップするとMonaKey(鍵)が削除されます。\n\n【警告】\n鍵を削除しても、板単位で行われている規制を回避できるわけではありません。あなたの環境(回線・専ブラ・機種の組合わせ)で現在規制されている板へ書き込めば、何度でもBANされます。\n鍵を削除した後は、問題となった板への書き込みに注意しましょう。\n特に、鍵の取得を同一IPアドレスで短期間に複数回繰り返すと、「不正取得を検知しました」規制でしばらく鍵が取得できなくなるので注意が必要です。\n\nまた、荒らしなどの迷惑行為には絶対に使用しないでください。\n\n以上を理解した上で削除ボタンをタップしてください。");
        linearLayout.addView(text);

        //削除ボタン表示
        Button button = new Button(this);
        button.setText("削除");
        button.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        linearLayout.addView(button);

        //ボタンを押したら表示される用のtext2を生成しておく
        TextView text2 = new TextView(this);
        text2.setText("削除しました。");

        //削除ボタンの動作
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ボタン無効化
                button.setEnabled(false);
                //MonaKey削除
                getSharedPreferences("2chapi", 0).edit().remove("2chapi_monakey").commit();
                //削除メッセージ表示
                linearLayout.addView(text2);
            }
        });
    }
}