# MonakeyClearActivity.java
ただのJavaのクラスファイル。

自作のMonaKey削除用Activityを某アプリに追加し、鍵の自己削除を可能にする。(アクティビティとは、Androidにおける「画面」のこと)  
注意：説明はまだ作りかけ WIP

## 作成方法
1. AndroidManifestを編集するために例のあれを使う (ここで-sオプションを付けるのが重要)
2. AndroidManifest編集
3. classes3.dexを配置 (これがコンパイルされた自作クラスの本体。)
4. 例のあれで再びあれする
5. zipalignと署名

注意点：Windows上で普通に作業すると、apk内のファイルが大量に失われて壊れたapkが出来上がってしまう。  
試しに一度apkをそのまま解凍してみると異変に気が付くかも。そしてapkをzipファイルとしてそのまま開いてみると原因がわかるかも。  
幸いにもWindowsにはこれを解決する手段がある。Windowsのファイルシステムは意外とすごい。

apkは単一APKなdev版を使用しよう

## 起動方法
https://chmate.monakey.clear/ へのリンクを踏む

[このスレ](https://eagle.5ch.net/test/read.cgi/livejupiter/1655380588/)を★5とかに入れとくと便利かも  
Android12だとアプリ情報から開くリンクを追加する必要があるかも
## その他
バイナリ改造不要で、ファイル追加だけでできる。  
この方法なら、既存のバイナリやリソースなどの構成物には一切手を加えたり逆アセンブルしたりせずに、新しい自作のクラスファイルだけを追加する形なので、きっと法的にも安心(たぶん、おそらくは)。  
Android開発は未経験なので、ソースなどにツッコミどころがあればどしどしください  
起動方法も改良の余地があるはず

トリップ ◆1iIXcBIBf. ←何かあった時用

そして○ceよ、もう諦めろ。無駄なことはしなくていいから。
