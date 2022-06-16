# monakey-remover
Just a single java class.  
MonaKeyを削除するActivity。
## 使用方法
1. apktool d -s senbura.apk (-sオプションが重要)
2. classes3.dexを配置
3. Manifest編集
4. apktool b
5. zipalignと署名
## 起動方法
https://chmate.monakey.clear/ のリンクを踏む
## その他
この方法なら、既存のバイナリやリソースなどの構成物に一切手を加えたり逆アセンブルしたりせずに、新しい自作のクラスファイルだけを追加する形なので、クリーンなやり方のはず。
