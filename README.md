(お知らせ)  
LSPatchがChMateで使えるようになったことで、どう考えてもそれで例の蓋を導入する方が楽になったので、これはもうアーカイブ化します。  
<sub>それに、下で「dex入れるだけだから法的に安心」とか自分に言い聞かせているけど普通に無理があるし、ホワイト路線でいきたいなら、[よりホワイトな方法](https://github.com/kitadai31/monakey-remover-app)も新しく考えたし。</sub>

# monakey-remover (Activity追加、dex組込み版)
これは、某アプリに組み込むための、MonaKey(鍵)を削除する機能を持った自作のActivityです。(アクティビティとは、Androidにおける「画面」のこと)  
配布しているバイナリ(dex)の中身は、 `MonakeyClearActivity.java` というただ1つのクラスです。

非rootではどうあがいても外から鍵を削除できないので、アプリ自体に鍵を削除する機能を追加してしまおう、という作戦です。

<img src="https://user-images.githubusercontent.com/90122968/183068963-abf71e3c-4b16-43e6-b9f4-616e92564b03.png" width="160px">

## 作成方法
1. apkを用意 (dev版を推奨、play版だと分割apkで手間がかかるため)
1. AndroidManifest.xml編集 (アクティビティの宣言と、その起動手段を追加する。)
1. releasesから classes3.dex をダウンロードし配置 (これがコンパイルされた自作Activityの本体。)
1. 再ビルドとzipalignと署名

### 注意点
バイナリ改造(dexの逆アセンブル)は不要なので、apktool d時には -s オプションを付けてください。

また、mateのapk内にはminifyの影響で同じ名前で大文字と小文字だけ違うファイルが大量にあるため、Windows環境で普通にapktoolすると名前の重複によって大量のファイルが失われて壊れたアプリが出来上がってしまいます。  
そのため、コマンドで大文字と小文字を区別するように属性変更したフォルダ内で作業しなければなりません。

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
この方法なら、既存のバイナリを逆アセンブルしたり、その他のリソースなどの構成物にも一切手を加えずに新しい自作のクラスファイルだけを追加する形なので、きっと法的にも安心(たぶん、おそらくは)。

逆に法的な観点を考えなければ、もっと深いところまで改造して便利にできるかも？(ヒント)  
→2022/09/07 結局Cookie削除ボタンでMonaKeyを削除できるようにする玉ねぎもできました

ちなみに、いくら鍵を消したところで規制中の板に当該の回線や専ブラで書き込めばまた鍵が無効化されるだけなので、鍵規制の根本的な回避にはなりません（重要）。不正取得規制にも注意。

私のトリップ: ◆1iIXcBIBf. ←何かあった時用

※なお、当プログラムに荒らしの助長をする意図はありません。[私の主張](https://github.com/kitadai31/monakey-remover/blob/main/myclaim.md)も聞いてください。

※当ページで配布しているバイナリを他のアプリに組み込んだことによってもし損害を受けても作成者は一切責任を負いません。
