 /*チャット履歴*/
-- DROP TABLE IF EXISTS tt_chat ;
create table if not exists tt_chat ( 
    CHAT_ID BIGINT  ( 20 )  unsigned  not null  auto_increment  /*チャットID*/
   ,CHAT_TEXT VARCHAR  ( 1000 )  not null  /*文章*/
   ,CHATTER_ID BIGINT  ( 20 )  /*話者ID*/
   ,primary key ( CHAT_ID ) 
 );
