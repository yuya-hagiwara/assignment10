# 使用技術一覧
![68747470733a2f2f696d672e736869656c64732e696f2f62616467652f537072696e675f426f6f742d332e322e332d2532333644423333463f7374796c653d706c6173746963266c6f676f3d537072696e67266c6f676f436f6c6f723d253233364442333346](https://github.com/user-attachments/assets/ba96f9a6-64dd-4d68-b72d-fdd1fab2609f)
![68747470733a2f2f696d672e736869656c64732e696f2f62616467652f446f636b65722d2532333234393645443f7374796c653d706c6173746963266c6f676f3d446f636b6572266c6f676f436f6c6f723d7768697465](https://github.com/user-attachments/assets/81a80ad9-28cc-4172-adf8-81f3dfaea1b7)
![68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4d7953514c2d2532333434373941313f7374796c653d706c6173746963266c6f676f3d4d7953514c266c6f676f436f6c6f723d7768697465](https://github.com/user-attachments/assets/a8d7efad-81d3-4c89-8a96-dca3b0216a3e)
![68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4c616e67756167652d4a6176612d7265643f7374796c653d706c6173746963](https://github.com/user-attachments/assets/83f649d8-d168-4ac4-9c2b-d994a10ff1a4)
![68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4769745f4875622d2532333138313731373f7374796c653d706c6173746963266c6f676f3d476974487562266c6f676f436f6c6f723d7768697465-2](https://github.com/user-attachments/assets/08cb06e9-8161-4975-bd75-d934bc2ec76b)

AWSについては学習中になりますので実装次第更新予定です。



# サービス概要
- 名前と誕生日をセットにidで紐づけして登録します。登録の際idは自動で採番されます。
- ユーザーを全件JSON形式で取得します。また、名前に入力した文字が含まれる人の検索やidを指定して検索する条件取得ができます。
- idを指定しそのユーザーの名前と誕生日を更新できます。
- idを指定しそのユーザーを削除することができます。



# 作成にあたって
色々なAPIに挑戦しようと思いましたが、基本ができてこそ！
と思い作成致しました。
初めての作成ですが、これを皮切りにどんどん挑戦していこうと思っています！！



# セットアップについて
## 必要環境
- Java 17
- MySQL
- Docker 3.8



# アプリケーション概略図
![applicationMap](https://github.com/user-attachments/assets/0c4a8e2a-4786-473f-b7c9-59d997d0d2c2)



# API一覧


| API | Method | path |
|  ---  |  ---  |  ---  |
|ユーザー全件検索| GET | /users |
|ユーザーid検索| GET|/users/{id}|
|ユーザー名前検索| GET | /users/{name}
|ユーザー新規登録| POST | /users
|ユーザー更新処理| PATCH | /users/{id}
|ユーザー削除処理| DELETE| /users/{id}


# DBについて

## テーブル名：users

| column | data type | NotNull | key | description |
| - | - | - | - | - |
| id | int | NOT NULL | primaryKey | id 自動採番 |
| name | VARCHER(100) | NOT NULL |  | 名前 |
| birthday | DATE | NOT NULL |  | 誕生日 |


# Dockerについて

| version | 3.8 |
| - | - |
| platform | linux/x86_64 |
| environment |
| MYSQL_ROOT_PASSWORD | password |
| MYSQL_DATABASE | user_list |
| MYSQL_USER | user |
| MYSQL_PASSWORD | password |
| port | 3307:3306 |


# 自動テスト

- UserServiceの単体テスト
- UserMapperのDBテスト
- UserIntegrationテストの実装（結合テスト）

  今後GithubActionsによりCI実装予定。


 # portfolio
