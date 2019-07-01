/* チャット履歴 */
DROP TABLE IF EXISTS tt_chat;
CREATE TABLE tt_chat (
    CHAT_ID   bigint(20) unsigned NOT NULL AUTO_INCREMENT /* チャットID */
   ,CHAT_TEXT text                NOT NULL                /* 文章 */
   ,TALKER_ID bigint(20)                    DEFAULT NULL  /* 発言者ID */
   ,PRIMARY KEY (CHAT_ID)
);

