# monakey-remover
Just a single java class.  
自作のMonaKey削除用Activityを某アプリに追加する。(アクティビティとは、Androidにおける「画面」のこと)

## 作成方法
1. AndroidManifestを編集するために apktool d -s hoge.apk をする (-sオプションが重要)
1. binフォルダの中にある classes3.dex を配置 (これがコンパイルされた自作クラス本体。binはバイナリという意味。)
1. Manifest編集
1. apktool b
1. zipalignと署名

注意点: apkに大文字小文字違いの同名ファイルが含まれているので、普通のディレクトリでapktoolすると壊れる。  
そのため、「大文字と小文字を区別するディレクトリ」を用意し、そこで作業しなくてはならない。もしくはLinux上で作業する。  
apkは単一APKなdev版がおすすめ

## 起動方法
https://chmate.monakey.clear/ へのリンクを踏む

[このスレ](https://eagle.5ch.net/test/read.cgi/livejupiter/1655380588/)を★5とかに入れとくと便利かも  
Android12だとアプリ情報から開くリンクを追加する必要があるかも
## その他
この方法なら、既存のバイナリやリソースなどの構成物には一切手を加えたり逆アセンブルしたりせずに、新しい自作のクラスファイルだけを追加する形なので、比較的クリーンのはず。  
Android開発は未経験なので、ソースにツッコミどころがあればどしどしください  
起動方法も改良の余地があるはず

トリップ ◆1iIXcBIBf. ←何かあった時用

もう諦めろ○ce、無駄なことしなくていいよ
