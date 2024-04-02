DROP TABLE IF EXISTS POSTING;
DROP TABLE IF EXISTS `USER`;
DROP TABLE IF EXISTS REPLY;

CREATE TABLE `USER`(
                         ID INT(7)    NOT NULL PRIMARY KEY AUTO_INCREMENT,
                         NAME VARCHAR (20) NOT NULL,
                         EMAIL VARCHAR (50),
                         LV INT(7),
                         CREATED_AT DATETIME,
                         UPDATED_AT DATETIME
);

CREATE TABLE POSTING(
                         ID INT(7)      NOT NULL PRIMARY KEY AUTO_INCREMENT,
                         TITLE VARCHAR (20),
                         USER_ID INT(7),
                         TEXT VARCHAR (140),
                         CREATED_AT DATETIME,
                         UPDATED_AT DATETIME,
                         CONSTRAINT USER_ID_FK FOREIGN KEY (USER_ID) REFERENCES `USER`(ID)

);

CREATE TABLE REPLY(
                      ID INT(7)      NOT NULL PRIMARY KEY AUTO_INCREMENT,
                      USER_ID INT(7),
                      TEXT VARCHAR (50),
                      PARENT_REPLY_ID INT(7),
                      POSTING_ID INT(7),
                      CREATED_AT DATETIME,
                      UPDATED_AT DATETIME,
                      CONSTRAINT PARENT_REPLY_ID_FK FOREIGN KEY (PARENT_REPLY_ID) REFERENCES REPLY(ID)
);

