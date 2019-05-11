# messageboard
## 功能要求
开发基于控制台的留言板系统。具体要求如下：

1. 显示留言板系统主菜单，包括显示留言、添加留言和退出系统三项。
2. 显示所有留言信息：包括各条留言的留言人、留言时间、留言标题和留言内容。
3. 用户添加留言：需要输入留言人、留言标题、留言内容，留言时间取当前时间。
4. 退出系统。

## 类的设计
采用DAO模式开发此系统，需要定义如下类

留言实体类（Message）

    留言Id(id)
    留言人(userName)
    留言标题(title)
    留言内容(contents)
    留言时间（createTime）

数据库连接和关闭类（BaseDao）

留言DAO接口(MessageDao)

留言DAO实现类（MessageDaoOracleImpl）

留言业务类（MessageService）

Main类

## 具体要求及推荐实现步骤

1. 创建数据库表message，添加测试数据不少于2条。
2. 创建序列messageSeq，用于实现message表的主键自增。
3. 创建实体类Message，根据业务提供需要的构造方法和setter/getter方法。	
4. 创建BaseDao类，实现数据库连接和关闭功能。
5. 创建DAO接口MessageDao，定义查询所有留言、添加留言的方法。
6. 创建DAO实现类MessageDaoOracleImpl，继承BaseDao类，实现MessageDao接口，使用JDBC完成相应数据库操作。 
7. 创建业务类MessageService，完成在控制台显示留言信息和用户添加留言操作。
8. 创建Main类，启动和运行系统。



