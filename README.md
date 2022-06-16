# monakey-remover
Just a single java class.  
MonaKeyを削除する自作Activityを追加する。
## 使用方法
1. apktool d -s 5ch_no_senbura.apk (-sオプションが重要)
2. bin(バイナリという意味)フォルダの中にある classes3.dex を配置
3. Manifest編集
4. apktool b
5. zipalignと署名
注意点: 某専ブラのapkは特殊なことをしているので、普通にapktoolすると壊れる。  
「大文字と小文字を区別するディレクトリ」を用意し、そこで作業しなくてはならない。もしくはLinux上で作業する。
## 起動方法
https://chmate.monakey.clear/ のリンクを踏む
## その他
この方法なら、既存のバイナリやリソースなどの構成物に一切手を加えたり逆アセンブルしたりせずに、新しい自作のクラスファイルだけを追加する形なので、クリーンなやり方のはず。
Android開発は未経験なのでツッコミどころあればどしどしください

諦めろ○ce、もう無駄なことしなくていいよ
