CREATE TABLE `Step_Up_Ost`(
`Num`INT(11) NOT NULL AUTO_INCREMENT,
`Title` VARCHAR(200) NOT NULL,
`Artist` VARCHAR(200) NOT NULL,
`Album` VARCHAR(200) NOT NULL,
`Playtime` VARCHAR(50) NOT NULL,
PRIMARY KEY (`num`) USING BTREE 
)

INSERT INTO Step_Up_Ost (Title, Artist, Album, Playtime) VALUES ('Club Can''t Handle Me (feat. David Guetta)', 'Flo Rida', 'Only One Flo - Part.1', '3:55');