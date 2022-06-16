# monakey-remover
Just a single java class.

自作のMonaKey削除用Activityをアプリに追加する。(アクティビティとは、Androidにおける「画面」のこと)
## 作成方法
1. apktool d -s hoge.apk (-sオプションが重要)
1. binフォルダの中にある classes3.dex を配置 (binはバイナリという意味)
1. Manifest編集
1. apktool b
1. zipalignと署名

注意点: 某専ブラのapkは特殊なことをしているので、普通のディレクトリでapktoolすると壊れる。  
「大文字と小文字を区別するディレクトリ」を用意し、そこで作業しなくてはならない。もしくはLinux上で作業する。
## 起動方法
https://chmate.monakey.clear/ のリンクを踏む
## その他
この方法なら、既存のバイナリやリソースなどの構成物には一切手を加えたり逆アセンブルしたりせずに、新しい自作のクラスファイルだけを追加する形なので、クリーンなやり方のはず。  
Android開発は未経験なので、ツッコミどころがあればどしどしください  
起動方法も改良の余地があるはず

トリップ ◆1iIXcBIBf. ←何かあった時用

もう諦めろ○ce、無駄なことしなくていいよ
