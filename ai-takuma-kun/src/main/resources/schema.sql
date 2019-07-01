/* チャット履歴 */
-- DROP TABLE IF EXISTS tt_chat;
CREATE TABLE IF NOT EXISTS tt_chat (
    CHAT_ID   bigint(20) unsigned NOT NULL AUTO_INCREMENT  /* チャットID */
   ,CHAT_TEXT varchar(1000)      NOT NULL                 /* 文章 */
   ,CHATTER_ID bigint(20)                    DEFAULT NULL /* 話者ID  */
   ,PRIMARY KEY (CHAT_ID)
);


/* 話者 */
-- DROP TABLE IF EXISTS tt_chatter;
CREATE TABLE IF NOT EXISTS tt_chatter (
    CHATTER_ID   bigint(20) unsigned NOT NULL AUTO_INCREMENT /* 話者ID */
   ,CHATTER_NAME varchar(1000)      NOT NULL                /* 話者名 */
   ,PRIMARY KEY (CHATTER_ID)
);

