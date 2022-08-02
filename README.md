# MonakeyClearActivity.java
(お知らせ)8/2 再公開しました

ただのJavaのクラスファイル。

某アプリに組み込むための、MonaKey(鍵)を削除する自作Activity。(アクティビティとは、Androidにおける「画面」のこと)  
「rootなしではどうあがいても外から鍵を削除できないのなら、内側から削除すればいい」という作戦です。

## 作成方法
1. apk(dev版)を用意 (play版だと分割apkで手間がかかる)
1. AndroidManifest編集 (アクティビティの宣言と、その起動手段を追加する。)
1. releasesからダウンロードした classes3.dex を配置 (これがコンパイルされた自作クラスの本体。)
1. 再ビルドとzipalignと署名

### 注意点
AndroidManifestを編集するために皆さん"あること"をされると思われるが、その際、バイナリ改造(dexの逆アセンブル)は不要なので -s オプションを付けること。

また、Windows上で普通に作業すると、apk内のファイルが名前の重複で大量に失われて壊れたapkが出来上がってしまう。  
これは試しに一度apkをそのまま解凍してみると異変に気が付くかも。そしてapkをzipファイルとしてそのまま開いてみると原因がわかるかも。  
幸いにもWindowsにはこれを解決する手段がある。Windowsのファイルシステムは意外とすごい。

## 組み込んだアクティビティの起動方法
アクティビティの名前は`com.kitadai31.MonakeyClearActivity`です。アクティビティを起動する手段はお好きな方法で構いません。

あくまでも参考ですが、AndroidManifest.xmlに次の記述を追加すれば、https://chmate.monakey.clear/ へのリンクを踏むことで当プログラムを呼び出せるようになります。
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
この方法を使った場合、[このスレ](https://eagle.5ch.net/test/read.cgi/livejupiter/1655380588/)を★1とかに入れとくと便利でしょう  
Android12ではアプリ情報から開くリンクを追加する必要があるかも

## その他
これはバイナリ改造不要で、ファイルを1つ追加するだけでできる。  
この方法であれば、既存のバイナリを逆アセンブルしたり、その他のリソースなどの構成物にも一切手を加えたりせずに、新しい自作のクラスファイルだけを追加する形なので、きっと法的にも安心(たぶん、おそらくは)。  
Android開発は未経験なので、ソースなどにツッコミどころがあればどしどしください  
起動方法も改良の余地があるはず

私のトリップ ◆1iIXcBIBf. ←何かあった時用

運営よ、もし怒ったとしたらすまない。[私の主張]()も聞いてくれ。  
ちなみにいくら鍵を消したところで、規制を受けている板に当該の回線や専ブラでの書き込みをすればまた鍵が無効化されるだけなので、規制の根本的な回避にはなりません。別ブラウザの併用は続ける必要があります。

※当ページで配布しているバイナリを他のアプリに組み込んだことによってもし損害を受けても私は一切責任を負いません。
