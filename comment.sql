CREATE DATABASE IF NOT EXISTS oasis;
USE oasis;
-- DROP TABLE IF EXISTS user; 
DROP TABLE IF EXISTS comment; 

set auto_increment_offset=1;
set auto_increment_increment=1; 

CREATE TABLE comment (

	comment_id  INT AUTO_INCREMENT NOT NULL,
	comment_product_id INT NOT NULL,
	comment_text TEXT NOT NULL,
	comment_img	 VARCHAR(255),
	comment_timestamp TIMESTAMP,
	comment_rate_stars VARCHAR(20),
    
    CONSTRAINT comment_primary_key PRIMARY KEY (comment_id)
);

-- INSERT INTO user (user_email, user_password, user_identity, user_company_name
-- 		, user_register_date, user_last_login, user_last_ip, user_nickname, user_avatar, user_intro)  
-- 	VALUES ('mlaitw@gmail.com','0000','ADMINISTRATOR', null, '2024-04-17', '2024-04-17 15:30:45', '127.0.0.1', 'Mike', 'C:\Users\T14 Gen 3\Downloads\resource\image\cat.jpg', 'Hi, I play video game since 12. I love Slay the Spire from Mega Crit and Hollow Knight from Team Cherry!');
--     
-- INSERT INTO user (user_email, user_password, user_identity, user_company_name
-- 		, user_register_date, user_last_login, user_last_ip, user_nickname, user_avatar, user_intro)  
-- 	VALUES ('superman@yahoo.com.tw','1111','REGULAR', null, '2024-04-18', '2024-04-17 15:30:45', '127.0.0.1', '超人', 'https://battlecats.2of3.net/img/Units/uni507_f00.png?20200710','');
--     
-- INSERT INTO user (user_email, user_password, user_identity, user_company_name
-- 		, user_register_date, user_last_login, user_last_ip, user_nickname, user_avatar, user_intro)  
-- 	VALUES ('stranger@gmail.com','2222','REGULAR', null, '2024-04-17', '2024-04-17 15:30:45', '127.0.0.1', '路人甲', 'https://i.pravatar.cc/300', '');

-- INSERT INTO user (user_email, user_password, user_identity, user_company_name
-- 		, user_register_date, user_last_login, user_last_ip, user_nickname, user_avatar, user_intro)  
-- 	VALUES ('clietSupport@riot.com','3333','COMPANY', 'RIOT', '2024-04-17', '2024-04-17 15:30:45', '127.0.0.1', '拳頭', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSYY9axR7mBZRU56b4lkCKEbkkMEynJU2r2SNaZpUi4r3iAXE62q8IFhjHMk-_1OBdcuNo&usqp=CAU', '');

-- INSERT INTO user (user_email, user_password, user_identity, user_company_name
-- 		, user_register_date, user_last_login, user_last_ip, user_nickname, user_avatar, user_intro)  
-- 	VALUES ('clientSupprt@klei.com','4444','COMPANY', 'Klei', '2024-04-17', '2024-04-17 15:30:45', '127.0.0.1', 'klei', 'https://s.yimg.com/os/creatr-uploaded-images/2020-06/1896af50-af7e-11ea-bff7-199b5e22ebd1', '');

-- INSERT INTO user (user_email, user_password, user_identity, user_company_name
-- 		, user_register_date, user_last_login, user_last_ip, user_nickname, user_avatar, user_intro)  
-- 	VALUES ('teamcherry@gmail.com','5555','COMPANY', 'Team Cherry', '2024-04-17', '2024-04-17 15:30:45', '127.0.0.1', 'cherry', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQLqKg6N8MiX0BuL2_rr4wopwty-4pkfgdT9td-Pn8mACLjIHOi_lKKdvrSLfRwO1XOpXY&usqp=CAU', '');

INSERT INTO comment (comment_product_id, comment_text, comment_img, comment_timestamp, comment_rate_stars)  
VALUES (1000000001, '是一個造型好看但是本身遊戲機制很不看好的爛遊戲 這裡並不是說他不好 而是這個遊戲慢慢轉行為課金遊戲的那種機制
如果是看到這款遊戲的造型想來遊玩的
建議先看看這遊戲的匹配機制 你玩一場輸3-5場都有可能 一週要你玩比賽50-100才有可能解鎖的到神話皮膚 不然你就還得課下一期把皮膚補回來！', 'https://blz-contentstack-images.akamaized.net/v3/assets/blt2477dcaf4ebd440c/blt9828b8ec022ebedd/65a815eecad56065fd589545/Jan_2024_Esports_Update.jpg?format=webply&quality=90', '2024-04-17 15:30:45', 5);

INSERT INTO comment (comment_product_id, comment_text, comment_img, comment_timestamp, comment_rate_stars)  
VALUES (1000000002, '新角色真醜 不如看球Z做莊', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSxl5uKVuFnFrewXRagVkvpKYPYkZGTb06VnYt0CaAqPQ&s', '2024-04-18 10:45:20', 4);

INSERT INTO comment (comment_product_id, comment_text, comment_img, comment_timestamp, comment_rate_stars)  
VALUES (1000000003, '那時候是2016年，我看到雙龍的預告，那句「龍が我が敵を喰らう」把我拉進了鬥陣特攻的世界。
跟幾個好朋友說了介紹了這個遊戲，優良的動畫輕鬆地拉了朋友入坑，花了1900元買了典藏版，讓我有了小小的虛榮感。
進遊戲之後，玩了半藏，幾場過去，比起射箭，我似乎更會被箭射到，幾場下來箭沒射到幾支，爬牆的能力倒是增加了不少。
源式就更不用說了，最常講的台詞就只有「I need healing」跟「龍神の剣を阿#$@&*」。
後來只好放棄了這兩個帶我入坑的角色開始練習了其他角色。
死神、攔路豬、托比昂到我最愛的炸彈鼠，這些角色貫穿了我的鬥陣生涯
到後面為了打贏雙飛練的76；為了讓自己有大範圍控場而學的小美，鬥陣特攻帶給我就像毒品般的快樂。
每一次的活動跟模式，我跟朋友都會激烈的討論，從一開始的路西歐足球，玩到後面變成前500，跟朋友一起幻想後面的夏季運動會的所有可能，暢談路西歐足球的美好，「如果路西歐足球出現在自訂該有多好」我對朋友這樣說著。鼠肯斯坦、冬境樂園、新春、捍衛密令、鬥陣對決、還有周年活動，每一個活動剛推出的時候，都是我們廢寢忘食的開始。
一年過去了，我們還是在期待最新的英雄什麼時候出，最新的動畫那最高品質的呈現。但英雄從一開始的三個月一隻，變成了有出就不錯了。而活動也是，跟朋友討論了無限可能的夏季運動會，籃球、躲避球、跑酷最後都只存在我們的期望中，夏季運動會是一個改了路西歐技能的路西歐足球。其他活動也不例外，本來以為到了下一次就會有新的內容，但每一次最新的往往只有排山倒海的造型。
英雄的失衡；303的出現；強制222；PVE英雄模式的取消；一代遊戲幣的不轉移，到最後，朋友已經各奔東西，沒有人肯留在這個地方了。而現在路西歐足球也真的出現在了自訂了，但好像一切都為時已晚了。我也只是在這，祭奠我的過去。

我將我的青春、最快樂的那個我、一同與這個遊戲埋葬於此。願你的靈魂去到更好的地方，變得更好。', 'https://cdn.mos.cms.futurecdn.net/tQUSFsqoZvrLGnD8V6DkH3-1200-80.jpg', '2024-04-19 09:15:30', 4);


USE oasis;
SELECT * FROM comment;
