# MonakeyClearActivity.java
ただのJavaのクラスファイル。

某アプリに組み込むためのMonaKey(鍵)削除用の自作Activity。(アクティビティとは、Androidにおける「画面」のこと)

コンセプト「非rootではどうあがいても外から鍵を削除することができないのなら、内側から自己削除する機能を追加すればいいじゃない。」

## 作成方法
1. apk(dev版)を用意 (play版だと分割apkで手間がかかる)
1. AndroidManifest編集 (アクティビティの宣言を追加する。)
1. classes3.dexを配置 (これがコンパイルした自作クラスの本体。)
1. 再ビルドとzipalignと署名

### 注意点
AndroidManifestを編集するために皆さん"あること"をされると思われるが、その際、バイナリ改造は不要なので -s オプションを付けること。

また、Windows上で普通に作業すると、apk内のファイルが大量に失われて壊れたapkが出来上がってしまう。  
試しに一度apkをそのまま解凍してみると異変に気が付くかも。そしてapkをzipファイルとしてそのまま開いてみると原因がわかるかも。  
幸いにもWindowsにはこれを解決する手段がある。Windowsのファイルシステムは意外とすごい。

## 組み込んだアクティビティの起動方法
アクティビティの名前は`com.kitadai31.MonakeyClearActivity`です。アクティビティの起動手段はお好きな方法で構いません。

参考に、AndroidManifest.xmlに次の記述を追加すれば、https://chmate.monakey.clear/ へのリンクを踏むことで当プログラムを呼び出せるようになります。
```xml
        <activity android:name="com.kitadai31.MonakeyClearActivity">
            <intent-filter>
                <action android:name="android.intent.action.VIEW"/>
                <category android:name="android.intent.category.DEFAULT"/>
                <category android:name="android.intent.category.BROWSABLE"/>
                <data android:scheme="https" android:host="chmate.monakey.clear"/>
            </intent-filter>
        </activity>
```
この方法を使った場合、[このスレ](https://eagle.5ch.net/test/read.cgi/livejupiter/1655380588/)を★5とかに入れとくと便利でしょう  
Android12だとアプリ情報から開くリンクを追加する必要があるかも

## その他
バイナリ改造不要で、ファイルを1つ追加するだけでできる。  
この方法なら、既存のバイナリを逆アセンブルしたり、その他のリソースなどの構成物には一切手を加えずに、新しい自作のクラスファイルだけを追加する形なので、きっと法的にも安心(たぶん、おそらくは)。  
Android開発は未経験なので、ソースなどにツッコミどころがあればどしどしください  
起動方法も改良の余地があるはず

私のトリップ ◆1iIXcBIBf. ←何かあった時用

そして○ceよ、もう諦めろ。無駄なことしなくていいよ。  
ちなみにいくら鍵を消したところで、特定の板に問題となった回線や専ブラでの書き込みをすればまた鍵が無効化されるだけなので、規制の根本的な回避にはなりません。別ブラウザの併用は続ける必要があります。
