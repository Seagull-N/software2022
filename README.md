# 空調調整要求しすてむ

## 起動方法
---
1. [airconditioner](airconditioner)フォルダをローカルにコピーする


2. データベースを作成
    ```
    mysql> create database airuser;
    mysql> create user airuser identified by 'airuser';
    mysql> grant all on air.* to airuser;  
    ```

3. アプリを実行

4. http://localhost:2289/ にアクセス

<br>

## 注意事項
---
1. 授業IDはrandで生成されているため, IDが被ってバグが起きた際はPHPMyAdminを使用してデータを全削除すること  
2. 指定された文字を入力するときは, 半角大文字で正しく打たないとバグが発生する可能性がある 

## 操作方法
---
1. 教師として使用する<br>
    1-1 ログインする<br>
        &emsp;&emsp;ID：被らないようなIDを適当に作成する ex) taro<br>
        &emsp;&emsp;role：TEACHERと入力する<br>

    1-2 授業を作成する<br>
        &emsp;&emsp;授業名: 授業名を入力する ex)大規模ソフトウェア論 <br>
        &emsp;&emsp;終了時間: 授業が何分後に終了するかを入力する ex)90<br>

    1-3 投票結果を確認する<br>
        &emsp;&emsp;各評価ごとの人数を確認する<br>
        &emsp;&emsp;ここで表示されている授業IDをメモしておく(生徒としてログインする際に使用する) ex) 22463<br>
        &emsp;&emsp;※集計機能は未実装であり、固定値を表示している

2. 生徒として使用する<br>
    2-1 ログインする<br>
        &emsp;&emsp;ID：被らないようなIDを適当に作成する ex) hanako<br>
        &emsp;&emsp;role：USERと入力する<br>

    2-2 授業を選択する  
        &emsp;&emsp;1-3でメモしておいた授業IDを入力する ex)22463<br>

    2-3 投票する  
        &emsp;&emsp;感じている状態をHOT, NORMAL, COLDから選択して入力する ex) HOT<br>

    2-4 完了画面  
         &emsp;&emsp;投票が完了したと表示される<br>
         &emsp;&emsp;戻るを押すと2-3に戻ることができる<br>
         &emsp;&emsp;※投票機能は未実装であり、何を入力しても完了とだけ表示されるようになっている  



