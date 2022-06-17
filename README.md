# MonakeyClearActivity.java
ただのJavaのクラスファイル。

某アプリに組み込むためのMonaKey(鍵)削除用自作Activity。(アクティビティとは、Androidにおける「画面」のこと)  
非rootではどうあがいても外からアクセスすることができないのなら、内側からアクセスすればいいじゃない。

## 作成方法
1. AndroidManifest編集 (アクティビティの宣言を追加する。)
1. classes3.dexを配置 (これがコンパイルした自作クラスの本体。)
1. 再ビルドとzipalignと署名

### 注意点
AndroidManifestを編集するために"あること"をすると思われるが、その際、バイナリ改造は不要なので -s オプションを付けること。

また、Windows上で普通に作業すると、apk内のファイルが大量に失われて壊れたapkが出来上がってしまう。  
試しに一度apkをそのまま解凍してみると異変に気が付くかも。そしてapkをzipファイルとしてそのまま開いてみると原因がわかるかも。  
幸いにもWindowsにはこれを解決する手段がある。Windowsのファイルシステムは意外とすごい。

apkは単一APKなdev版を使用する

## 組み込んだアクティビティの起動方法
https://chmate.monakey.clear/ へのリンクを踏む

[このスレ](https://eagle.5ch.net/test/read.cgi/livejupiter/1655380588/)を★5とかに入れとくと便利かも  
Android12だとアプリ情報から開くリンクを追加する必要があるかも

## その他
バイナリ改造不要で、ファイル追加だけでできる。  
この方法なら、既存のバイナリを逆アセンブルしたり、その他のリソースなど構成物には一切手を加えずに、新しい自作のクラスファイルだけを追加する形なので、きっと法的にも安心(たぶん、おそらくは)。  
Android開発は未経験なので、ソースなどにツッコミどころがあればどしどしください  
起動方法も改良の余地があるはず

私のトリップ ◆1iIXcBIBf. ←何かあった時用

そして○ceよ、もう諦めろ。無駄なことしなくていいよ。  
ちなみに実行時の警告文にも書きましたが、いくら鍵を消したところで、特定の板に問題となった回線+専ブラでの書き込みをすればまた鍵が無効化されるだけなので、規制の根本的な回避にはなりません。
