(お知らせ)8/2 再公開しました  
Android9以上の方 こんなのよりもずっと[いいもの](https://egg.5ch.net/test/read.cgi/android/1655208810/504-n)あるかも

# MonakeyClearActivity.java
ただのJavaのクラスファイル。

これは某アプリに組み込むための、MonaKey(鍵)を削除する機能を持った自作のActivityです。(アクティビティとは、Androidにおける「画面」のこと)  
「rootなしではどうあがいても外から鍵を削除できないのなら、内側から自己削除する機能を追加すればいい」という作戦です。  
[★動作イメージ(png画像)★](https://user-images.githubusercontent.com/90122968/183068963-abf71e3c-4b16-43e6-b9f4-616e92564b03.png)

## 作成方法
1. apkを用意 (dev版を推奨、play版だと分割apkで手間がかかるため)
1. AndroidManifest.xml編集 (アクティビティの宣言と、その起動手段を追加する。)
1. releasesから classes3.dex をダウンロードし配置 (これがコンパイルされた自作クラスの本体。)
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
これはバイナリ改造不要で、ファイルをたった1つ追加するだけ。  
この方法であれば、既存のバイナリを逆アセンブルしたり、その他のリソースなどの構成物にも一切手を加えたりせずに、新しい自作のクラスファイルだけを追加する形なので、きっと法的にも安心(たぶん、おそらくは)。  
逆に法的を考えなければもっとハードに改造して便利にできるかも？(大ヒント)
また、Android開発は未経験なので、ソースなどにツッコミどころがあれば教えてください。起動方法も改良の余地があるはず。  

ちなみにいくら鍵を消したところで、規制中の板に当該の回線や専ブラで書き込めばまた鍵が無効化されるだけなので、鍵規制の根本的な回避にはなりません（重要）。不正取得規制にも注意。

私のトリップ: ◆1iIXcBIBf. ←何かあった時用

運営さん、もし怒らせていたらすみません。でも[私の主張](https://github.com/kitadai31/monakey-remover/blob/main/myclaim.md)も聞いてください。このプログラムは荒らしの助長をしているわけではないと思っています。

※当ページで配布しているバイナリを他のアプリに組み込んだことによってもし損害を受けても作成者は一切責任を負いません。
